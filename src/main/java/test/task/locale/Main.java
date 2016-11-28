package test.task.locale;

import test.task.locale.service.interfaces.LocaleGreetingService;
import test.task.locale.tools.AppContext;

import java.time.LocalTime;


public class Main {
    private static LocaleGreetingService localeGreetingService = (LocaleGreetingService) AppContext.getApplicationContext().getBean("LocaleGreetingService");

    public static void main(String[] args) {
        LocalTime localTime = LocalTime.now();

        System.out.println(localeGreetingService.getGreetingMessage(localTime));
    }
}
