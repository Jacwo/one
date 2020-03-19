### JAVA类与类之间的关系 UML
在UML类图中，类使用包含类名，属性和方法，且带有分割线的矩形表示

- '+'表示public
- '-'表示private
- '#'表示protected

### 类之间大体分为五种关系
    1.依赖关系
    表示一个类依赖于另一个类的定义，其中一个类的变化将影响到另外一个类
    是一种use a 关系，如果A依赖于B，则B表现为A的局部变量，方法参数，静态方法调用等
    -------------------▶
    2.关联关系
    单向或者双向是一种has a的关系，如果A单向关联B则可以说A has aB
    class Customer{
        private Address address;
    }
    class Address{
        
    }
    －▶
    3.聚合关系
    聚合单向关系，是关联关系的一种，于关联关系区别是语义上的，关联的两个对象通常是平等的
    聚合则一般不平等，有一种整体和局部的感觉
    class Team {
        private Persion persion; 
    }
    class Persion{
    
    }
    ◇-▶
    4.组合关系
    单向是一种强依赖的特殊聚合关系 has a
    class Person{
        private Head head;
    }
    class Head{
    
    }
    ◆-▶
    5.继承关系
    类之间的继承和接口的实现
    -▷ 继承
    ----▷ 接口实现