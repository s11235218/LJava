## Spring

IoC(控制反转容器):**设计原则**,用来降低计算机代码之间的耦合度,最常见就是依赖注入,**对象生命周期不再由程序管理,而是交给Spring的Bean容器**

> 在程序开发中,实例的创建不再由调用者管理,而是由Spring容器管理,它负责控制程序之间的关系,而不由程序代码直接控制.控制权由程序代码转移到了Spring容器中,控制权发生了反转,这就是Spring的LoC思想

DI:

> 1. DI含义:依赖注入,为Bean对象注入依赖属性
> 2. 实现方式:属性注入,构造方法注入

框架使用流程:

1. 加载配置文件

   >```java
   >ApplicationContext context = new ClassPathXmlApplicationContext("applications.xml");
   >```

2. 初始化:根据配置项,进行初始化,如定义Bean进行实例化

   > ```java
   > <bean id="S###n" class="java.lang.String"></bean>
   > ```

3. 使用:如根据容器获取到Bean对象

>```java
>String s1 = (String)context.getBean("S###n");// 通过定义名称获取
>String s3 = context.getBean(String.class);// 通过类型获取:如果存在该类型多个对象时,会报错
>```

## DI:对象

依赖注入(Dependency Injection):依赖注入主要有两种实现方式,属性注入和构造方法注入

1. 属性注入:指loC容器使用setter方法诸如被依赖的实例,通过调用无参构造器或无参static工厂方法实例化bean后,调用该bean的setter方法,即可实现基于setter的DI

   >```java
   ><bean id="d##k1" class="S###n.Duck">
   >    <property name="name" value="Female"></property>
   >    <property name="age" value="18"></property>
   ></bean>
   >```

2. 构造方法注入:指loC容器使用构造方法注入被依赖的实例,基于构造器的DI通过调用带参数的构造方法实现,每一个参数代表一个依赖

   >```java
   ><bean id="S###n" class="java.lang.String">
   >    <constructor-arg value="小石"></constructor-arg>
   ></bean>
   >```



配置使用Bean的方式

（1）使用xml配置文件--Spring Framework本身决定

（2）使用Java注释方式：

​		前提：配置扫描的包--Spring Framework支持的注解，就会自动配置（Spring框架支持的注解（类），实例化Bean）

注解包括配置类，Bean的注解及其他；属性及方法上，存在Spring框架支持注解，也会支持对应初始化工作

Spring Boot作用：

1. 减少配置性工作：

   > 如web项目，一般步骤：
   >
   > 1. 创建web项目的结构，包括web资源文件夹和web.xml
   >
   > 2. 使用Spring Framework配置很多xml文件，文件中配置很多内容
   > 3. 部署到tomcat中
   >
   > 非web项目（使用Spring Boot 其中包括内置了很多配置）启动类中，自动完成的工作
   >
   > 默认的web配置：
   >
   > 1. web资源文件夹：映射静态资源文件夹
   > 2. 默认的web.xml
   > 3. 内置tomcat
   >
   > 自动扫描并初始化：
   >
   > 1. 扫描包：以启动类所在的包为扫描的包
   >
   > 2. 扫描类上的注解：扫描Spring框架支持的注解
   >
   >    >1. @Component:
   >
   > 3. 初始化：属性和方法上有Spring支持的注解，进行初始化
   >
   > > @Bean:配置类方法上的，以返回值作为Bean的实例对象，注册到容器中，Bean的名称是方法名
   > >
   > > 同一个类型，要实例化多个对象时，该方法适合
   > >
   > > 注意：@Bean注解方法，如果没有被扫描到，不会起作用

SpringBoot注意事项：

1. 启动类，必须在某一个包下
2. 默认扫描启动类所在的包下

**装配Bean的方式：**

1. @Autowired：属于Spring框架，
2. @Resource ：JDK提供的注解，表示资源。JDK只提供了规范，没有提供实现（JDBC、Servlet ：JDK提供规范，第三方厂商提供具体实现）

存在同一个类型，多个实例对象时：默认根据变量名查找bean的名称为变量名的bean，如果变量名和bean名称不一致，需要手动指定：

> @Autowired+Qualifier（bean名）
>
> @Resource(name= "bean名")

SpringMVC  ： Spring Framework项目中的一个框架，提供web请求处理的功能

**@Controller**：当前类型注册实例到容器中，并指定为Web请求的处理

**@RequestMapping**：可以定义请求相关配置：如路径，请求方法等（可以使用在类和方法上）

返回方式：

1. (非主流)返回静态资源：返回值类型为String，返回值为资源路径（静态资源和服务器资源都可）目前前后端分离开发
2. 返回json的数据：

> **@ResponseBody：**返回application/json的数据类型，返回值会序列化为json字符串

Controller中，请求数据的方式：

1. 路径变量：url中定义（变量名）作为占位符，使用@PathVariable对应变量

2. @RequstParam: 

   > 可以获取url中的数据请求
   >
   > 请求数据类型为x-www-form-urlencoded和form-data时，可以获取请求体中的数据
   >
   > 可以省略注释，或注解值，就以变量名匹配请求数据
   >
   > @RequstParam定义的类型，可以是基础数据类型，包装类型，自定义类型，都可以有多个参数，自定义类型是通过请求数据的key映射到类型字段中

3. @RequestBody: 

   > 请求数据类型为application/json时，解析请求体中的json字符串为Java对象

4. 直接使用Servlet的request和response对象

**注：**

> 1. @ResponseBody使用时，注意返回值为null和字符串的情况
> 2. 请求的数据类型（定义了请求体中的格式），Controller要使用对应的注释
> 3. 请求数据是放在url还是请求体中





SpringMVC:

统一数据式封装：@ControllerAdvice，实现ResponseBodyAdvice接口

统一异常处理：@ControllerAdvice+@ExceptionHandler，指定要捕获的异常类

提示：@ControllerAdvice和@ExceptionHandler可以有多个



配置WebMVC的特性：实现WebMVCAdapter接口，重写接口方法完成配置

配置拦截器：重写addInterpetor,给定要拦截的和排除的路径，最后的匹配结果，来决定是否执行拦截器方法

SpringMVC执行流程：

![image-20201109205128489](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201109205128489.png)

AOP（Aspect Oriented Programming）：面向切面编程，将业务逻辑的各个部分进行隔离，使开发人员编写业务逻辑时专心于核心业务，从而提高开发效率。

AOP应用场景：需要在具体的业务方法前后，执行统一业务逻辑处理代码

Spring框架实现AOP方式

1. JDK的实现方式：Proxy.newProxyInstance()结合InvocationHandler   被代理类需要实现某一个接口，通过接口来使用原理：Java文件在编译期编译为class字节码，运行时加载对应的类到方法区 

   > 1.  运行期，根据被代理类，生成了代理类字节码，将被代理类包装到代理类中
   > 2. 被代理类方法执行前后，插入统一处理逻辑
   > 3. 使用的时候，使用代理类，不再使用被代理类

2. CGLIB的实现方式

MethodInterceptor完成方法执行前后的业务逻辑插入再通过ASM字节码技术，生成代理类的字节码

前置条件：被代理类不需要实现接口，但不能为final修饰

Spring框架代理时：会根据是否实现接口来决定使用哪一种动态代理

Spring Bean的生命周期



面向过程编程、面向对象编程

面向接口编程：以jdbc和Servlet结合，减少代码耦合、扩展性、可移植性

面向切面编程





SpringBoot 的自动化配置

流程/原理：SpringBoot启动时，会扫描所有jar包中，META-INF/spring.factories文件，如果内容包含SpringBoot的配置，就会子哦对那个加载配置（SPI机制）

JDK原生就有SPI机制（ServiceLoader），SpringBoot就是模拟机制实现

