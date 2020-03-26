### IOC和AOP的理解
- IOC 

    是利用java反射机制还有工厂设计模式的思想，本来调用者的实例由调用者来创建这样耦合性太强，
    IOC则是统一交给spring来管理创建，将对象创建交给容器管理，你只需在spring配置文件中配置相应的bean
    以及设置相关的属性，让spring容器来生成类的实例对象，在spring容器启动时候，spring会把你在配置中配置的bean都初始化好
    然后在你调用的时候，就把你初始化好的那些bean分配给你需要调用的类
    优点：
    接耦合，开发更方便
    高层不依赖与底层
    更容易测试
    因为把对象生成放在了xml里面，所以当我们需要实现一个子类将会变得狠简单，只要修改xml就行了
- AOP
   
    比如有个方法来做一些事情，但是要求用户登陆才能做，你就可以在这个方法执行前验证一下，执行后记录下操作日志，把前后的这些
    与业务无关的代码抽出来放在一个类里，这个类就是切面，这个被环绕的方法就是切点，方法前后做的处理就是增强处理
    aop使用的是动态代理包括JDK动态代理和CGLib动态代理，使用哪个看被代理类有没有实现接口
    
    1. Joinpoint 连接点
    2. PointCut 切入点
    3. Advice 增强
    4. Aspect 切面
    5. Target 目标对象
    6. weaving 织入
    7. Proxy 代理
    
###  Spring IOC的初始化过程
     读取             解析                   注册
xml--------Resource--------BeanDefinition---------BeanFactory
    
第一个过程是Resource的资源定位。这个Resource 指的是BeanDefinition的资源定位，这个过程就是容器找数据的过程
第二个过程是BeanDefinition的载入过程，这个载入过程就是把用户定义好的Beam表示成Ioc容器内部的数据结构这个结构就是BeanDefition
第三个过程是向IOC容器注册这些BeanDefinition的过程，这个过程就是将前面的BeanDefition保存到HashMap中

### spring bean的加载机制生命周期

- Bean的加载过程

        1. 转换beanName  
        消除修饰符，比如name=&test 取别名最后的beanName
        2. 从缓存中加载实例 
        实例在spring的同一个容器中只会被创建一次，后面在想获取该bean时，就是尝试从缓存中获取，如果获取不到再从singleFactories中加载
        3. 实例化bean 
        缓存中记录的bean一般只是最原始的bean状态，这时就需要对bean进行实例化，如果得到的bean的原始状态，但又要对bean进行处理，这时真正
        需要的是工程bean中定义的factory-method方法中返回的bean
        4. 检测parentBeanFactory
        如果缓存中没有数据就会转到父类工厂中去加载，！containsBeanDefinition（beanName）就是检测如果当前加载xml文件中不包含
        beanName所对应的配置，就只能到parentBeanFactory中尝试加载
        5. 存储xml配置文件的GernericBeanDefinition转换成RootBeanDefinition xml配置文件中读取到的bean信息是存储在GernericBeanDefinition
        中的，但Bean的后续处理是针对RootBeanDefinition的所以转换后才能进行后续操作
        6. 初始化依赖的bean 
        7. 创建bean 
        spring根据不同的scope创建bean实例。

- 生命周期
在传统的java应用中bean的生命周期很简单，使用new进行bean的实例化，然后该bean就可以使用了，一旦该bean不再被使用则由java自动
进行垃圾回收
相比之前，spring容器中的bean的生命周期就相对复杂的多了，正确理解spring bean的生命周期非常重要。

        1. spring对bean进行实例化
        2. spring将值和bean的引用注入进bean对应的属性中
        3. 如果bean实现了beanNameAware几口，spring将bean的id传递给setBeanName方法。
             实现BeannameAware主要是为了通过bean的引用来获得Bean的iD
        4. 如果bean实现了BeanFactoryAware接口，spring将调用setBeanFactory方法把beanFactory容器实例作为参数传入
             BeanFactoryAware主要目的是为了获取spring容器，如bean通过spring容器发布事件
        5. 如果Bean实现了ApplicationContextAware接口 spring将调用setApplicationContext方法将上下文传入进来
            作用与beanFactory类似都是为了获取spring容器，不同的spring容器在调用setApplicationContext方法会把自己做为
            参数传入，而setBeanFactory需要程序员指定BeanFactory
        6. 如果bean实现了beanpostProcess接口spring将调用他们的postProcessBeforeInitialization方法
            作用是在bean创建成功后对bean进行增强处理，如bean进行修改增加龚哥功能
        7. 如果bean实现了InitializingBean接口 spring将调用他们的afterPropertiesSet方法
            作用与在配置文件中对bean使用init-method声明初始化作用一样都是在bean的全部属性设置成功之后执行初始化方法
        8.如果bean实现了beanPoestprocess接口spring将调用postProcessAfterInitialization方法
            作用和6一样，只不过是在bean初始化后执行的
        9. 经过上面的工作bean一直在应用上下文中被使用直到上下文被销魂
        10 如果bean实现了DisposttableBean接口，spring将调用他的destory方法。
          
- spring实例化的三种方式
    1. 使用无残构造创建
    2. 使用静态工厂创建对象
    3. 使用实例工厂创建对象
    
- BeanFoctory和FactoryBean的区别
    1. beanFactory是个Factory 也就是IoC容器或对象工厂，在spring中所有的bean都是有beanFactory来进行管理的，提供了实例化对象和拿对象的功能
    2. factory是一个bean这个bean不是简单的bean而是一个能产生或者修饰对象生成工厂bean他的实现与设计模式中的工厂模式和修饰起模式类似
- BeanFactory和ApplicationContext的区别
    beanFactory 是spring最底层的接口，提供了嘴贱的容器的功能，只提供了实例化对象和拿对象的功能、
    装载bean的区别，beanFactoiry在启动的时候不会取实例化bean，从容器中拿bean的时候才会实例化
    applicationContext 在启动的时候就把所有的bean全部实例化，他还提供延迟实例化的方法lazy-init=true
- springmvc返回xml
    @RequestMapping(value = "/serviceValidate", produces = {"application/xml; charset=UTF-8"})
              

 
    
   