package three.phase.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author andrii
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
//        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
//        context.getBean(Messenger.class).say();
        new AnnotationConfigApplicationContext("three.phase.constructor");
    }

}
