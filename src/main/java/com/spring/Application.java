package com.spring;

import com.spring.bean.Dog;
import org.springframework.beans.annotation.AnnotationBeanUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.annotation.Validated;

import java.lang.reflect.AnnotatedElement;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xu rongchao
 * @date 2020/8/28 21:08
 */
@ComponentScan("com.spring.bean")
@Configurable
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class Application {

    /**
     * IOC
     * Conditional @Primary @Lazy @Scope @Primary @Import
     * 3. @AutoWire @Value
     * 4. xxxAware: 想要使用Spring容器底层的一些组件（ApplicationContext BeanFactory）都是xxxAwareProcessor实现的 ApplicationContextAwareProcessor
     * 5. @Profile 指定组件在哪个环境下才能被注册到容器中 -Dspring.profiles.active=test
     */

    /**
     * AOP
     * 使用
     * 1. @Aspect
     * 2. @Pointcut
     * 3. @EnableAspectJAutoProxy
     * 原理
     * 1. @EnableAspectJAutoProxy是什么？
     *     1） @Import(AspectJAutoProxyRegistrar.class) 通过AspectJAutoProxyRegistrar注册 AnnotationAwareAspectJAutoProxyCreator
     * 2. AnnotationAwareAspectJAutoProxyCreator
     *     AnnotationAwareAspectJAutoProxyCreator
     *         -> AspectJAwareAdvisorAutoProxyCreator
     *             -> AbstractAdvisorAutoProxyCreator
     *                 -> AbstractAutoProxyCreator
     *                     implement SmartInstantiationAwareBeanPostProcessor, BeanFactoryAware
     *                     关注后置处理器的工作（bean初始化完成前后的做的事情）、自动装配BeanFactory
     *
     * 执行流程
     *     1）传入配置类，创建ioc容器
     *     2） 注册配置类，调用refresh() 刷新容器
     *     3） registerBeanPostProcessor(beanFactory);注册bean的后置处理器来方便拦截bean的创建
     *         1） 先获取ioc容器已经定义了的需要创建对象的所有BeanPostProcessor
     *         2） 给容器中加别的BeanPostProcessor
     *         3） 优先注册实现了PriorityOrder接口的BeanPostProcessor
     *         4) 在给容器中注册实现了Ordered接口的BeanPostProcessor；
     *         5） 注册没有实现优先级接口的BeanPostProcessor
     *         6） 注册BeanPostProcessor，实际上就是创建BeanPostProcessor对象，保存在容器中：
     *             创建internalAutoProxyCreator的BeanPostProcessor【AnnotationAwareAspectJAutoProxyCreator】
     *             1) 创建Bean的实例
     *             2） populateBean: 给bean的各种属性赋值
     *             3) initializeBean: 初始化bean
     *                 1） invokeAwareMethod()：处理Aware接口的方法回调
     *                 2） applyBeanPostProcessorBeforeInitialization(),应用后置处理器的postBeforeInitialization
     *                 3) invokeInitMethod(): 执行自定义的初始化方法
     *                 4） applyBeanPostProcessorAfterInitialization
     *             4) BeanPostProcessor(AnnotationAwareAspectJAutoProxyCreator) 创建成功
     *         7） 把BeanPostProcessor注册到BeanFactory中
     *             beanFactory.addBeanPostProcessor(postProcessor)
     * ------------------ 以上就是创建和注册AnnotationAwareAspectJAutoProxyCreator ---------------------------
     *    4) finishBeanFactoryInitialization(beanFactory); 完成BeanFactory初始化工作；创建剩下的单实例Bean
     *        1） 遍历获取容器中所有的Bean，依次创建对象getBean(beanName)
     *            getBean -> doGetBean() -> getSingleton() ->
     *        2) 创建Bean
     *            1） 先从缓存中获取当前bean，如果能获取到，说明是被创建过的；
     *            2） createBean()
     *            【BeanPostProcessor是bean创建前后】
     *            【InstantiationAwareBeanPostProcessor是在Bean实例之前先尝试用后置处理器返回对象】
     *                1) resolveBeforeInstantiation(beanName, mbdToUse)解析BeforeInstantiat
     *                希望后置处理器在此能返回一个代理对象；如果能返回代理对象就使用，如果不能就继续
     *                    1) 后置处理器尝试返回对象
     *                        if (bean!=null) {
     *                            bean = applyBeanPostProcessorAfterInitialization(bean, beanDe)
     *                        }
     *                2) doCreateBean(beanName, mbdToUse, args)真正的去创建一个，和3.6流程一样
     *
     *
     * AnnotationAwareAspectJAutoProxyCreator 是通过 @EnableAspectJAutoProxy注解中的@Import 注入到spring容器中的
     * AnnotationAwareAspectJAutoProxyCreator[InstantiationAwareBeanPostProcessor]
     * 1. 每一个bean创建之前，调用postProcessBeforeInstantiation()
     *     1. 判断当前bean是否在adviseBean中（保存了所有增强Bean）
     *     2. 判断当前bean是否在基础类（Advice, Pointcut, Advisor, AopInfrastructureBean）,或者是否是切面（@Aspect）
     *     3. 是否需要跳过： 1.获取候选的增强器（切面里面的通知方法）
     *     4.
     * 2. 创建对象
     *     postProcessAfterInitialization
     *         return wrapIfNecessary(bean, beanName, cacheKey)
     *         1. 获取当前bean的所有增强器 Object[] specificInterceptors
     *             1. 找到候选的所有增强器
     *             2. 获取能在bean使用的增强器
     *             3. 给增强器排序
     *         2. 保存当前bean在advisedBeans中
     *         3.如果当前 bean需要增强，创建当前bean的代理对象
     *             1. 获取所有增强器
     *             2. 保存到proxyFactory
     *             3. 创建代理对象 （JdkDynamicApoProxy ObjectCglibAopProxy）
     *         4. 给容器中返回当前组件使用cglib增强了的组件
     *         5. 以后容器中获取到的就是这个组件的代理对象，之后执行的都是被增强的方法
     * 3. 目标方法执行
     *     容器中保存了组件的代理对象（cglib增强后的对象）这个对象里面保存了详细信息 比如增强器，目标对象，xxx
     *     1. cglib 
     *
     *
     */
    public static void main(String[] args) {
//        AnnotationBeanUtils.copyPropertiesToBean();
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        context.getBeanFactory().destroyBean(context.getBean(Dog.class));
        System.out.println(context.getBean(Dog.class));
        System.out.println(context.getBean(Dog.class));
    }
}