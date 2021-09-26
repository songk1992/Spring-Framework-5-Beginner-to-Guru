package guru.spring5.section3.services;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

// https://github.com/springframeworkguru/sfg-di/blob/life-cycle-demo/src/main/java/guru/springframework/sfgdi/services/LifeCycleDemoBean.java

@Component
public class LifeCycleDemoBean implements InitializingBean, DisposableBean, BeanNameAware,
    BeanFactoryAware, ApplicationContextAware
{
    public LifeCycleDemoBean() {
        System.out.println("## 생성자 실행");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("## been factory has been set");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("## been 이름은" + s);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("## life cycle 종료");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("## life cycle has its property set");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("## Application Context has been set");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("## Post Construct annotated method has been called");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("## The PreDestroy annotated method has been called");
    }

    public void beforeInit(){
        System.out.println("## Before init called by bean post processor");
    }

    public void afterInit(){
        System.out.println("## After init called by bean post processor");
    }
}
