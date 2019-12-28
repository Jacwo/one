## servlet
servlet是在服务器上运行的小程序，一个servlet就是一个java类，并且可以通过请求相应编程模式来访问这个在服务器内的servlet程序
特性：线程不安全、单例
#### 生命周期
- 初始化 servlet对象创建之后马上执行初始化方法，只会执行一次
- 服务 每次处理请求都是在调用这个方法，他会调用多次
- 销毁 在servlet被销毁之前调用，负责释放servlet对象占有的资源的方法

---
三种实现方式
- 实现javax.servlet.Servlet
- 继承javax.servlet.GenericServlet
- 继承javax.servlet.http.HttpServlet类
---
Servlet执行流程
浏览器/test 发起请求的，服务器不会直接执行我们的类，而是在web.xml里寻找路径名，
1.浏览器输入访问路径后，懈怠了请求行，头，体
2.根据访问路径我们找到已注册的servlet名称
3.根据映射找到对应的servlet名
4.根据servlet的名找到全路径名，然后可以找到我们的类
5.找到权限定名后，通过反射创建对象，同时也创建了servletConfig里面放了一些初始化信息。
6.首先执行init方法但是我们发现我们定义类没有init方法，所以程序会调用父类里的init方法
7.接着，服务器会先创建两个对象，servletRequest和ServletResponse对象，用来封装浏览器的请求数据和相应数据
8.接着，服务器会默认招我们写的类里招service方法，不存在在父类招
9.到父类HttpServlet中发现有此方法，调用然后狗根据Get还是Post调用不同的方法。
web.xml

```$xslt
<servlet>
    <servlet-name>demo</servlet-name>
    <servlet-class>com.yyl.DemoServlet</servlet-class>
</servlet>

<servlet-mapping>
    <servlet-name>demo</servlet-name>
    <url-pattern>/test</url-pattern>
</servlet-mapping>
```
### 面试常问
1. 何时创建
默认异地次访问servlet时创建
2. 何时销毁
服务器管理servlet就销毁了
### tomcat装载servlet的三种情况
1. <servlet></servlet> 之间添加<load-on-startup>1</load-on-startup> 数字越小优先级越高
2. 客户端首次向某个servlet发送请求
3. servlet类被修改后tomcat会重新装载servlet

