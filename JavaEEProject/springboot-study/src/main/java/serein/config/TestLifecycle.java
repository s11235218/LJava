package serein.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
public class TestLifecycle implements
        BeanNameAware,
        BeanFactoryAware,
        ApplicationContextAware,
        BeanPostProcessor,
        InitializingBean,
        DisposableBean {

    // BeanPostProcessor接口方法
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().equals(TestLifecycle.class)) {// 屏蔽其它类的信息
            System.out.println("postProcessBeforeInitialization: " + beanName);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().equals(TestLifecycle.class)) {// 屏蔽其他类的信息
            System.out.println("postProcessAfterInitialization: " + beanName);
        }
        return bean;
    }

    /**
     * BeanFactoryAware接口方法
     * @param beanFactory
     * @return void
     * @author Sssserein
     * @creed: Talk is cheap,show me the code
     * @date 2020/11/11 21:11
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("setBeanFactory");
    }

    // BeanNameAware接口方法
    @Override
    public void setBeanName(String name) {
        System.out.println("setBeanName");
    }

    // DisposableBean接口方法
    @Override
    public void destroy() throws Exception {
        System.out.println("destroy");
    }

    // ApplicationContextAware接口方法
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("setApplicationContext");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }


}
