# Spring

`Business Layer` ----------------> `Data Layer`

`Business Logic To Do` -------> `Data Service Logic To Do`

    The Business Layer may need to call the Data Layer to retrieve some data therefore
    the Business Layer will be dependent on the Data Layer thus making the Data Layer 
    a 'DEPENDENCY' for the Business Layer. 
    WHY?
    Because the without the Data Layer the Business Layer will not function as expected.

  
### Component
  
      public @interface Component
      
      Indicates that an annotated class is a "component". 
      Such classes are considered as candidates for auto-detection 
      when using annotation-based configuration and classpath scanning.
      Other class-level annotations may be considered as identifying 
      a component as well, typically a special kind of component: e.g. 
      the @Repository annotation or AspectJ's @Aspect annotation.
      
### Autowired

    public @interface Autowired
    
    Marks a constructor, field, setter method or config method as to be 
    autowired by Spring's dependency injection facilities.
    Only one constructor (at max) of any given bean class may carry this 
    annotation, indicating the constructor to autowire when used as a 
    Spring bean. Such a constructor does not have to be public.
    
    Fields are injected right after construction of a bean, before 
    any config methods are invoked. Such a config field does not have 
    to be public.
    
    Config methods may have an arbitrary name and any number of arguments; 
    each of those arguments will be autowired with a matching bean in the 
    Spring container. Bean property setter methods are effectively just a 
    special case of such a general config method. Such config methods do 
    not have to be public.
    
    In the case of multiple argument methods, the 'required' parameter is 
    applicable for all arguments.
    
    In case of a Collection or Map dependency type, the container will 
    autowire all beans matching the declared value type. In case of a Map, 
    the keys must be declared as type String and will be resolved to 
    the corresponding bean names.
    
    Note that actual injection is performed through a BeanPostProcessor 
    which in turn means that you cannot use @Autowired to inject references 
    into BeanPostProcessor or BeanFactoryPostProcessor types. Please consult
     the javadoc for the AutowiredAnnotationBeanPostProcessor class 
     (which, by default, checks for the presence of this annotation).
  
### Component-Scan
    
    public @interface ComponentScan
    
    Configures component scanning directives for use with @Configuration classes. 
    Provides support parallel with Spring XML's <context:component-scan> element.
    Either basePackageClasses() or basePackages() (or its alias value()) may be 
    specified to define specific packages to scan. If specific packages are not 
    defined, scanning will occur from the package of the class that declares this 
    annotation.
    
    Note that the <context:component-scan> element has an annotation-config attribute; 
    however, this annotation does not. This is because in almost all cases when using 
    @ComponentScan, default annotation config processing (e.g. processing @Autowired 
    and friends) is assumed. Furthermore, when using AnnotationConfigApplicationContext, 
    annotation config processors are always registered, meaning that any attempt to 
    disable them at the @ComponentScan level would be ignored.
    
## Spring Core Container Modules

![Spring Core Container Modules Image](images/spring-overview.png)

    - The main part of the Spring Framework is the core container.
    - The two most important parts within the Core container is the Application Context and the Bean Factory.
    - In the examples we were using the Application Context to launch up the Spring Beans. So all the beans were 
    running inside the Application Context we defined.
    - Instead of using the Application Context we could have used the BeanFactory. 
    - The BeanFactory is the main interface which provides handling of beans, the IOC features of Spring.
    - Application Context extends the BeanFactory and provides additional functionalities on top of it.
    
 ![BeanFactory vs Application Context Image](images/BeanFactoryVsApplicationContext.png)
 
    - Application Context also supports integration of multiple configuration modules.
   
 ![ApplicationContext Based Container Image](images/Application-Context-Based-Container.jpg)

    Benefits of using the Application Context over the BeanFactory includes:
        - It provides really good integration for Aspect-Oriented-Programming. 
        - It provides really good integration with message resources. In typical web applications
        you would want Internationalization and Application Context has it built out of the box.
        - Application Context also has specific event handling. It provies listeners (e.g. request/response listeners)
        out of the box. 
        - Application Context can handle other contexts e.g. WebApplicationContext.
        
The Spring Documentation does advise us to use the Application Context over the BeanFactory [here.](https://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#beans-introduction)
    
    
For more info about the Spring Core Container check out Appendix 1.

## Other Modules

### Core-Container

The **Spring Core Container** consists of the `spring-core`, `spring-beans`, `spring-context`, `spring-context-support`, 
and `spring-expression` (Spring Expression Language) modules.

The `spring-core` and `spring-beans` modules provide the fundamental parts of the framework, including the IoC 
and Dependency Injection features. The BeanFactory is a sophisticated implementation of the factory pattern. 
It removes the need for programmatic singletons and allows you to decouple the configuration and 
specification of dependencies from your actual program logic.

The  `Context` (spring-context) module builds on the solid base provided by the `Core and Beans` modules: 
it is a means to access objects in a framework-style manner that is similar to a JNDI registry. 
The Context module inherits its features from the Beans module and adds support for 
internationalization (using, for example, resource bundles), event propagation, resource loading, 
and the transparent creation of contexts by, for example, a Servlet container. 
The Context module also supports Java EE features such as EJB, JMX, and basic remoting. 
The `ApplicationContext` interface is the focal point of the Context module. spring-context-support 
provides support for integrating common third-party libraries into a Spring application context for 
caching (EhCache, Guava, JCache), mailing (JavaMail), scheduling (CommonJ, Quartz) and 
template engines (FreeMarker, JasperReports, Velocity).

The `spring-expression` module provides a powerful Expression Language for querying and 
manipulating an object graph at runtime. It is an extension of the unified expression language (unified EL) 
as specified in the JSP 2.1 specification. The language supports setting and getting property values, 
property assignment, method invocation, accessing the content of arrays, collections and indexers, 
logical and arithmetic operators, named variables, and retrieval of objects by name from Spring’s IoC container. 
It also supports list projection and selection as well as common list aggregations.


### AOP and Instrumentation
The `spring-aop` module provides an AOP Alliance-compliant aspect-oriented programming implementation 
allowing you to define, for example, method interceptors and pointcuts to cleanly decouple code that 
implements functionality that should be separated. Using source-level metadata functionality, you can also 
incorporate behavioral information into your code, in a manner similar to that of .NET attributes.

The separate `spring-aspects` module provides integration with AspectJ.

The `spring-instrument` module provides class instrumentation support and classloader implementations 
to be used in certain application servers. The `spring-instrument-tomcat` module contains Spring’s 
instrumentation agent for Tomcat.

### Messaging
Spring Framework 4 includes a `spring-messaging` module with key abstractions from the 
Spring Integration project such as Message, MessageChannel, MessageHandler, and others to serve as a 
foundation for messaging-based applications. The module also includes a set of annotations for mapping 
messages to methods, similar to the Spring MVC annotation based programming model.

### Data Access/Integration
The Data Access/Integration layer consists of the `JDBC`, `ORM`, `OXM`, `JMS`, and `Transaction` modules.

The `spring-jdbc` module provides a JDBC-abstraction layer that removes the need to do tedious JDBC coding 
and parsing of database-vendor specific error codes.

The `spring-tx` module supports programmatic and declarative transaction management for classes that 
implement special interfaces and for all your POJOs (Plain Old Java Objects).

The `spring-orm` module provides integration layers for popular object-relational mapping APIs, 
including JPA, JDO, and Hibernate. Using the spring-orm module you can use all of these O/R-mapping 
frameworks in combination with all of the other features Spring offers, such as the simple declarative 
transaction management feature mentioned previously.

The `spring-oxm` module provides an abstraction layer that supports Object/XML mapping implementations 
such as JAXB, Castor, XMLBeans, JiBX and XStream.

The `spring-jms` module (Java Messaging Service) contains features for producing and consuming messages. 
Since Spring Framework 4.1, it provides integration with the `spring-messaging module`.

### Web
The Web layer consists of the `spring-web`, `spring-webmvc`, `spring-websocket`, and `spring-webmvc-portlet` modules.

The `spring-web` module provides basic web-oriented integration features such as multipart file upload functionality 
and the initialization of the IoC container using Servlet listeners and a web-oriented application context. 
It also contains an HTTP client and the web-related parts of Spring’s remoting support.

The `spring-webmvc` module (also known as the Web-Servlet module) contains Spring’s model-view-controller (MVC) 
and REST Web Services implementation for web applications. Spring’s MVC framework provides a clean separation 
between domain model code and web forms and integrates with all of the other features of the Spring Framework.

The `spring-webmvc-portlet` module (also known as the Web-Portlet module) provides the MVC implementation to be used 
in a Portlet environment and mirrors the functionality of the `spring-webmvc` module.

### Test
The `spring-test` module supports the unit testing and integration testing of Spring components with JUnit or TestNG. 
It provides consistent loading of Spring `ApplicationContext`s and caching of those contexts. It also provides mock 
objects that you can use to test your code in isolation.

For Usage Scenarios for uses of these modules you should check out Appendix 2.

# Appendix

1)  [Core Container](https://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#overview-core-container)
2)  [Usage Scenarios](https://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#overview-usagescenarios)