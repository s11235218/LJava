## Mybatis

**ORM：** 是通过实例化对象的语法，完成关系型数据库的操作技术，是“对象-关系映射”（Object/Relational Mapping）的缩写，ORM把数据库映射成对象。数据库设计表和字段时，也同时设计Java的实体类

> 数据库的表table-->类class
>
> 记录record行数据-->对象object
>
> 字段field-->对象的属性attribute

**jdbc操作步骤：** 设计一个框架更好操作数据库

> 1. 获取数据库连接Connection
> 2. 创建操作命令对象Statement----SQL语句（包含占位符）
> 3. 执行sql语句-----sql中，如果有占位符，在执行sql前要替换，会使用很多字段替换占位符（一般包装成一个对象，通过对象属性来操作）
> 4. 处理结果集（查询操作）----通过结果集对象.get类型(“结果集表头字段名”)，设置到一个对象属性中
> 5. 释放

**面试题：Hibernate和Mybatis区别？** 

1. Hibernate是一个全自动的ORM框架、Mybatis是半自动框架，Hibernate是以Java对象表示数据库的关系，自动的完成sql的包装，并且是跨数据库；Mybatis是一个半自动的ORM框架，需要写sql，需要配置Java对象间的关系
2. sql优化：
3. Hibernate更适合什么场景（数据库设计较为稳定），Mybatis更适合数据库调整比较快或比较大（快速迭代开发）

**Mybatis大概实现：** 

​	SQL语句（占位符）---->*（Statement、PreparedStatement）* 替换替换占位符执行SQL（以对象的属性替换占位符）---->*（查询操作）* 处理结果集（指定对象类型、结果集字段和对象属性映射）---->获取到返回值（处理结果集的结果）

**包含部分:** 1. 实体----替换占位符，结果集返回

2. sql----xml中配置sql（配置多个SQL，配置sql的id） 
3. 提供方法完成sql的处理：public 返回类型*（处理结果集的对象）* 方法名*（对应xml中sql的id）*（传入参数*（要替换占位符的数据）*）

> 补充：
>
> 1. Hibernate可以完全不写sql，就完成数据库操作（但支持写sql,但一般都不写），Mybatis需要写sql，并配置对象之间的关系
>
> 2. 通过Java代码操作对象，框架封装成sql语句，再执行
> 3. 优化工作较为方便
>
> 技术选型时考虑：1. 数据库是否设计上会有较大、较频繁的调整：Mybatis(调整) Hibernate（稳定）
>
> 2. sql优化：Mybatis做sql优化时更直接简单







*Spring 面试：*

*Spring怎么理解？*

*Spring IOC/DI怎么理解？*

*Spring Bean容器怎么理解？*

*AOP怎么理解？*



*一般问Spring Framework里的IOC/DI，Bean容器，AOP*

1. Bean容器：不再自己管理对象，而是交给Spring框架容器来进行管理--IOC（依赖控制反转，控制权有程序交给Spring容器）

2. DI：IOC的一种实现。DI实现方式：构造方法注入+属性注入    （实现原理：反射+ASM字节码技术）

3. AOP：

   > AOP名词概念：面向切面编程
   >
   > 应用场景：统一的业务逻辑处理，如事务管理，统一日志管理，统一异常处理，统一返回类型处理
   >
   > 实现方式：1. JDK的实现：被代理类需要实现一个接口，运行时动态生成代理类（生成方式）
   >
   > ​		Spring 框架使用代理类来完成工作
   >
   > ```伪代码
   > public class 被代理类 implements A接口{
   >    public void doSomething();
   > }
   > 
   > public class 代理类 implements A接口{
   >     private 被代理类 对象；
   >     public 代理类(被代理类 o) {
   >     	this.对象=o；
   >     }
   > public void doSomething(){
   > 	前置的统一业务();
   > 	对象.doSomething();
   > 	后置的统一业务();
   > }
   > ```
   > 2. CGLIB的实现：代理类继承被代理类----(被代理类不需要实现接口)
   >
   > 扩展：两种方式区别，效率问题？

SpringMVC----是一种分层的设计思想，Spring MVC是Spring中的实现

1. 熟练使用（Controller）2. 面试问题：某个注解，SpringMVC流程

@Controller-----类和方法上，注册一个处理web请求的实例

在同一返回@ResponseBody时，可以使用简洁注解：

@RestController：类上使用，方法默认默认都是@ResponseBody



@RequestMapping----类和方法上，表示接收请求的方式：如路径、请求方法、数据类型，少许和响应相关（数据类型）

​		服务提供的路径，由该注解路径，类和方法配置的路径字符串拼接

​		默认GET请求

只提供某个请求方法的写法：

@GetMapping：等同于@RequestMapping（method=RequestMethod.GET）

@PostMapping：等同于@RequestMapping（method=RequestMethod.POST）



请求参数：

@PathVariable：映射路径变量

@RequstParam：

​			省略注解时，默认的注解。

​			支持：基本数据类型、包装类型、自定义类型使用

​			接收：url请求数据，请求体中k=v格式的数据

@RequestBody：根据raw类型中具体的数据类型，来完成请求体到对象的转换(反序列化)，默认是接收application/json

支持的类型：HttpServletRequst/HttpServletResponse     HttpSession



**响应：**

@ResponseBody：需要返回对象到指定数据类型（默认application/json）

***注意事项：***

1. 不带@ResponseBody：

   表示返回某个服务器资源（接收String返回值，表示资源路径）

   转发写法：return “forward:路径”

   重定向写法：return “redirect:路径”    

   1.  路径是否以/开头，决定相对路径位置  

      ​		 转发带/，以项目部署路径后为相对位置

      ​		 重定向带/，会去掉项目部署路径

   2.  不带forward和redirect，为转发

2. 带@ResponseBody：

   返回某个对象，序列化为某个指定格式的数据（默认json）

   返回String，不会再序列化，

   返回null，响应体为空---项目开发时，自行封装



**SpringMVC流程：**

1. DispatcherServlet----在SpringBoot默认的处理路径为/**，表示所有请求都由该Servlet处理
2. HandlerMapping----处理请求映射：根据请求信息来映射服务资源
3. HandlerAdopter----处理器适配器
4. Controller----处理请求
5. 视图

**SpringBoot** 

1. **作用：**自动化配置，简化开发（SpringBoot提供的默认的一些配置，如web,jdbc，其他功能。第三方框架使用的SpringBoot规范，可以完成自动化配置工作）
2. **自动化配置原理：**扫描仪来包下，META-INF/springboot配置文件（spring.factories等），根据内容完成加载配置类，进一步完成配置类的初始化配置工作

synchronized的理解？

1. 使用场景：共享变量更新存在线程安全问题----解决线程安全

2. 作用：使用对象头加锁实现线程间互斥

3. 原理：

   > 字节码monitor机制（monitorenter monitorexit 可重入，计数器）
   >
   > 对象头的锁状态：五种，以及每种锁的使用场景、原理
   >
   > 锁优化----升级、粗化、消化

Mybatis：面试几率不太高

springboot(jar/META-INF/spring.factories)===>Mybatis配置类===>解析@MapperScan,知道了要扫描的包@Mapper接口

​																						*使用动态代理（AOP）生成接口的代理类、注册代理类到容器*

​                                                                    								===>解析xml文件的路径（application.properties）

Mybatis使用难点：关系映射较多

​	Mybatis占位符写法：

​	1.  #{变量名}：sql中真的占位符-----如字符串，替换占位符‘变量的值’（带单引号）

​	2.  ${变量名}：sql中没有占位符，sql拼接，有的不需要带单引号的替换，需要使用，如字符串“asc”，order by字段${变量名} 