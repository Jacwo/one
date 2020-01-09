# mybatis
mybatis实现原理
    
    mybatis是一个持久层框架，实现了ORM思想，可以将查询的结果集自动转换成Java对象，也可以将JAVA对象转换成一条数据插入到数据库中
    查询结果集是怎么自动转换成java对象的呢，主要使用了反射机制，在配置文件中假设有一条select语句，查询之后列名与属性名要一一对应
    不对应的可以采用列别名，然后每个列名前添加set，通过反射机制获取set方法，然后在通过反射机制的method.invoke()来调用set方法
    给java对象的属性赋值，这样就完成了对象的封装
## $和#的区别

    1. mybatis在处理#{}时，会将sql中的#{}替换为？号，调用PreparedStatement的set方法来赋值
    2. mybatis在处理${}时，就是把${}替换成变量的值
    3. 使用#{}可以有效的防止sql注入，提高系统的安全性。原因在于预编译机制。预编译完成之后，sql的结构已经股东，即便用户输入
    非法参数，也不会对sql的结构产生影响，从而避免了潜在的安全风险。
## 数据库插入重复如何处理
     
 在开发过程中经常遇到插入重复的现象，如何解决？
    
    插入的过程一般分为两步，先判断是否存在记录，没有存在则插入否则不插入，如果存在并发操作，同时进行第一步，发现没有记录，然后
    都插入了数据而造成数据的重复。解决思路
    1.判断数据库是否有数据，有的话不插入，没有进入2
    2.向redis set key其中只有一个操作a会成功，其他并发操作b和c都是失败的
    3.上面set key成功的操作a，开始执行插入数据库操作，无论是否插入成功，都在最后del key
    4.上面set key失败的操作b和c sleep一下，然后在判断数据库是否有数据，有数据不插入，没有则重复上面的饿set key 此时是b和c在竞争
    失败则啥都不做，成功者则开始插入数据，无论插入成功还是失败都要del key
    
## 事务执行过程中宕机的处理
  数据库插入百万级数据的时候，还没有操作完，服务器重启了，数据库还会继续执行吗？还是直接回滚？
     
     不会自动执行，不会自动直接回滚，但是可以人工手动选择继续执行或者回滚，依据事务日志。
     事务开启时，事务中的操作都会写入存储引擎的日志缓冲中，在事务提交之前，这些缓冲的日志都需要提前刷新到磁盘上持久化，这就是日志先行。
     日志分为redo log和undo log
### mybatis中的dao接口和xml文件里的sql是如何建立关系的
  
- 解析xml   
首先，mybatis在初始化SqlSessionFactoryBean的时候，找到mapperLocations路径去解析里面所有的xml文件，这里我们重点关注两部分。
  
  
    1.创建SqlSource
    mybatis会把每个sql标签封装成一个SqlSource对象，然后根据SQL语句的不同，又分为动态sql和静态sql其中，静态sql包含一段string类型的sql
    语句，而动态sql则是由一个个sqlNode组成 
    ```
    <select id="getById" resultType="user">
        select * from user
        <where>
            <if test="uid!=null">
                and uid=#{uid}
            </if>
        </where>
    </select>
    ```
    动态sql 比如 wheresqlNode ifsqlNode test:uid!=null uid=#{uid}
    静态sql select * from user
    
    2.创建MappedStatement
    xml文件中的每一个sql标签就对应一个MapperdStatement对象，这里面有两个属性很重要
    id:全限定类名+方法名组成的ID
    sqlSource：当前SQL标签对应的SqlSource对象
    创建完MappedStatement对象，将它缓存到Configuration#mappedStatements中
    Configuration对象就是mybatis中的大管家，基本所有配置信息都维护在这里，把所有的xml都解析完成之后，Configuration就
    包含了所有的sql信息
    到目前为止，xml就解析完成了，当我们执行mybatis方法的时候，就通过全限定类名+方法名找到MappedStatement对象然后解析里面的
    sql内容，执行即可。     
- DAO代理
              
    我们的dao接口并没有实现类，那么我们在调用它的时候怎么执行到我们的sql语句呢
  
  
    伏笔  @MapperScan("com.xxx.dao") 
    他的作用是将包路径下所有类注册到spring bean中，并将将他们的bean class设置为MapperFactoryBean
    MapperFactoryBean实现了FactoryBean接口，俗称工厂bean，当我们使用@Autowired注入这个dao时候，会调用
    factoryBean的getObject方法 
    这个方法通过JDK动态代理，返回了一个Dao接口的代理对象这个代理对象的处理器就是MapperProxy对象，所以我们通过@Autowired注入Dao接口
    的时候注入的就是这个代理对象，我们调用Dao接口的方法时，则会调用到MapperProxy对象的invoke方法。
- 执行
    当我们调用Dao接口方法的时候，实际调用到代理对象的invoke方法，在这里实际调用的就是SqlSession里面的东西
    ```$xslt
        public class DefaultSqlSession implements SqlSession {
            public <E> List<E> selectList(String statement, Object parameter, RowBounds rowBounds) {
                try {
                    //通过statement全限定类型+方法名拿到MappedStatement对象，然后通过执行器Executor执行sql并返回。
                    MappedStatement ms = configuration.getMappedStatement(statement);
                    //调用执行器executor，解析sqlSource生成sql PreparedStatement执行。
                    return executor.query(ms,wrapCollection(parameter), rowBounds, Executor.NO_RESULT_HANDLER); 
                }  
            }
        }
    ```
## 什么是MyBatis的接口绑定，有什么实现方式？
    接口绑定，就是在mybatis中任意定义接口，然后把接口里面的方法和sql语句绑定，我们直接调用接口方法就可以，这样比原来SqlSession
    提供的方法，可以有更加灵活的选择和配置。
    接口绑定有两种实现方式，一种是通过注解绑定，就是在接口的方法上加上@select @update等注解，里面包含sql语句来绑定，另外一种就是
    在xml里面写sql来绑定，这种情况下，要指定xml映射文件里面的namespace必须为接口的全路径名
    
## mybatis的一级、二级缓存的作用是什么？
    一级缓存：基于PerpetualCache的HashMap的本地缓存，其存储作用域为session，当session flush或close后，该session中的所有cache
    将清空，默认打开一级缓存。
    二级缓存和一级缓存其机制相同，默认也是采用perpetualCache、HashMap存储，不同在于其存储作用域为Mapper并且可以自定义存储源，如Ehcache。
    默认不打开二级缓存。要开启二级缓存，使用二级缓存属性类需要实现Serializable序列化接口，可在他的映射文件中配置cache
    对于缓存数据更新机制。当某一个作用域，进行了CUD操作后，默认作用域下所有select中的缓存被清空。 
    
## mybatis工作原理及核心流程介绍
  对比JDBC来说
    
    jdbc四个核心对象
    1. DriverManger用于注册数据库连接
    2. Connection 与数据库连接对象
    3. Statement/PrepareStatement 操作数据库sql语句的对象
    4. ResultSet 结果集或一张虚拟表
    
    mybatis四大核心对象
    1.SqlSession对象，该对象包含了执行sql语句的所有方法，类似于JDBC里面的Connection
    2.Executor接口，它将根据SqlSession传递的参数动态地生成需要执行的sql语句同时负责缓存的维护，类似于JDBC里面的Statement/   PrepareStatement 
    3.MappedStatement对象，该对象是对映射sql的封装，用于存储要映射sql语句的id参数等信息。
    4.resultHandler对象，用于对返回的结果进行处理，最终得到自己想要的数据格式或类型。
![alt](http://www.mybatis.cn/usr/uploads/2019/10/326517643.png)
    
    1.读取mybatis的配置文件，mybatis-config.xml为mybatis的全局配置文件，用于配置数据库的连接信息。
    2.加载映射文件。映射文件即sql映射文件，该文件中配置了操作数据库的sql语句。需要在mybatis配置文件mybatis-config.xml中加载
    mybatis-config.xml可以加载多个映射文件，每个文件对于数据库中的一张表。
    3.构造会话工厂。通过mybatis的环境配置信息构建会话工厂SqlSessionFactory
    4.构建会话对象，由会话工厂创建sqlSession对象，该对象中包含了执行sql语句的所有方法。
    5.executor执行器，mybatis底层定义了一个Executor接口来操作数据库，它将根据SqlSession传递的参数动态地生成需要执行的sql语句。同时维护缓存。
    6.MapperStatement对象，在Executor接口的执行方法中有一个MappedStatement类型的参数，该参数是对映射信息的封装，用于存储映射的sql语句id、参数等信息。
    7.输入参数映射。输入参数类型可以是Map、List等集合类型，也可以是基本数据类型和POJO类型，输入参数映射过程类似于JDBC的preparedStatement
    8.输出结果映射。输出结果类型可以是Map、List等集合类型，也可以是基本数据类型和POJO类型。输出结果映射过程类似于JDBC对结果集的解析过程。
    