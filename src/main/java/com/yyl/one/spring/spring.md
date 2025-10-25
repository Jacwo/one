
11:35:44.439 [main] INFO com.ruijie.spring.MyBeanFactoryPostProcessor - execute BeanFactoryPostProcessor#postProcessBeanFactory

11:35:44.543 [main] INFO com.ruijie.spring.MyInstantiationAwareBeanPostProcessor - execute InstantiationAwareBeanPostProcessor#postProcessBeforeInstantiation for testSpring
11:35:44.545 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Returning cached instance of singleton bean 'beansConfig'
11:35:44.566 [main] INFO com.ruijie.spring.TestSpring - execute TestSpring#new TestSpring()
11:35:44.566 [main] INFO com.ruijie.spring.TestSpring - execute TestSpring#setName(test)
11:35:44.566 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Eagerly caching bean 'testSpring' to allow for resolving potential circular references
11:35:44.566 [main] INFO com.ruijie.spring.MyInstantiationAwareBeanPostProcessor - execute InstantiationAwareBeanPostProcessor#postProcessAfterInstantiation for testSpring
11:35:44.573 [main] INFO com.ruijie.spring.MyInstantiationAwareBeanPostProcessor - execute InstantiationAwareBeanPostProcessor#postProcessProperties for testSpring
11:35:44.574 [main] INFO com.ruijie.spring.TestSpring - execute BeanNameAware#setBeanName
11:35:44.574 [main] INFO com.ruijie.spring.TestSpring - execute BeanFactoryAware#setBeanFactory
11:35:44.574 [main] INFO com.ruijie.spring.TestSpring - execute ApplicationContextAware#setApplicationContext
11:35:44.574 [main] INFO com.ruijie.spring.MyBeanPostProcessor - execute BeanPostProcessor#postProcessBeforeInitialization for testSpring
11:35:44.574 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Invoking afterPropertiesSet() on bean with name 'testSpring'
11:35:44.574 [main] INFO com.ruijie.spring.TestSpring - execute InitializingBean#afterPropertiesSet
11:35:44.574 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Invoking init method  'doInit' on bean with name 'testSpring'
11:35:44.574 [main] INFO com.ruijie.spring.TestSpring - execute User#doInit
11:35:44.574 [main] INFO com.ruijie.spring.MyBeanPostProcessor - execute BeanPostProcessor#postProcessAfterInitialization for testSpring
11:35:44.574 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Finished creating instance of bean 'testSpring'

11:35:44.607 [Thread-0] DEBUG org.springframework.beans.factory.support.DisposableBeanAdapter - Invoking destroy() on bean with name 'testSpring'
11:35:44.607 [Thread-0] INFO com.ruijie.spring.TestSpring - execute DisposableBean#destroy
11:35:44.608 [Thread-0] DEBUG org.springframework.beans.factory.support.DisposableBeanAdapter - Invoking destroy method 'doDestroy' on bean with name 'testSpring'
11:35:44.608 [Thread-0] INFO com.ruijie.spring.TestSpring - execute User#doDestroy
Disconnected from the target VM, address: '127.0.0.1:43482', transport: 'socket'

Process finished with exit code 0

- BeanFactoryPostProcessor 实现这个接口主要处理bean的依赖，比如只有A只有在B存在的时候再进行实例化setDependsOn
- postProcessBeforeInstantiation bean实例化之前执行 spring使用这个拓展点完成了script脚本实例化的支持
- Construct 执行构造方法
- setName 执行成员
- postProcessAfterInstantiation bean实例化之后执行，暂未发现使用
- postProcessPropertyValues  实例化完成成员变量的处理，spring使用这个完成Autowired注解的出来
- setBeanName  BeanNameAware
- setBeanFactory   BeanFactoryAware            
- setApplicationContext  ApplicationContextAware
- postProcessBeforeInitialization  bean 初始化之前 spring使用这个处理一些注解比如ConfigurationProperties
- afterPropertiesSet  InitializingBean
- doInit
- postProcessAfterInitialization bean 初始化之后，可以对一些bean加上代理
- doDestroy
  https://www.cnblogs.com/eiffelzero/p/18608702