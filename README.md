#Spring

`Business Layer` ----------------> `Data Layer`

`Business Logic To Do` -------> `Data Service Logic To Do`

    The Business Layer may need to call the Data Layer to retrieve some data therefore
    the Business Layer will be dependent on the Data Layer thus making the Data Layer 
    a 'DEPENDENCY' for the Business Layer. 
    WHY?
    Because the without the Data Layer the Business Layer will not function as expected.

  
  ### @Component
  
      Indicates that an annotated class is a "component".
      Such classes are considered as candidates for auto-detection
      when using annotation-based configuration and classpath scanning.
     
      <p>Other class-level annotations may be considered as identifying
      a component as well, typically a special kind of component:
      e.g. the {@link Repository @Repository} annotation or AspectJ's
      {@link org.aspectj.lang.annotation.Aspect @Aspect} annotation.
      
  ### @Autowiring
  
  
    Marks a constructor, field, setter method or config method as to be
    autowired by Spring's dependency injection facilities.
    <p>Only one constructor (at max) of any given bean class may carry this
    annotation, indicating the constructor to autowire when used as a Spring
    bean. Such a constructor does not have to be public.
    <p>
    <p>Fields are injected right after construction of a bean, before any
    config methods are invoked. Such a config field does not have to be public.
    <p>
    <p>Config methods may have an arbitrary name and any number of arguments;
    each of those arguments will be autowired with a matching bean in the
    Spring container. Bean property setter methods are effectively just
    a special case of such a general config method. Such config methods
    do not have to be public.
    <p>
    <p>In the case of multiple argument methods, the 'required' parameter is
    applicable for all arguments.
    <p>
    <p>In case of a {@link java.util.Collection} or {@link java.util.Map}
    dependency type, the container will autowire all beans matching the
    declared value type. In case of a Map, the keys must be declared as
    type String and will be resolved to the corresponding bean names.
    <p>
    <p>Note that actual injection is performed through a
    {@link org.springframework.beans.factory.config.BeanPostProcessor
    BeanPostProcessor} which in turn means that you <em>cannot</em>
    use {@code @Autowired} to inject references into
    {@link org.springframework.beans.factory.config.BeanPostProcessor
    BeanPostProcessor} or
    {@link org.springframework.beans.factory.config.BeanFactoryPostProcessor BeanFactoryPostProcessor}
    types. Please consult the javadoc for the {@link org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor}
    class (which, by default, checks for the presence of this annotation).
  
  