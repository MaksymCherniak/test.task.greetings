package test.task.locale.tools;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AppContext {
    private static ApplicationContext applicationContext = new GenericXmlApplicationContext("spring-config.xml");

    static {
        applicationContext = new GenericXmlApplicationContext("spring-config.xml");
    }

    private AppContext() {}

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
}
