package test.task.locale.service.impls;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import test.task.locale.service.interfaces.LocaleGreetingService;
import test.task.locale.tools.AppContext;

import java.time.LocalTime;
import java.util.Locale;

import static test.task.locale.tools.AppStaticValues.*;

public class LocaleGreetingServiceImpl implements LocaleGreetingService {
    private static Logger log = Logger.getLogger(LocaleGreetingService.class.getName());

    private ApplicationContext applicationContext = AppContext.getApplicationContext();

    public String getGreetingMessage(LocalTime localTime) {
        log.info("Get greeting message was called at " + localTime.toString());
        int hour = localTime.getHour();

        Locale locale = new Locale(EN);
        String message = null;

        switch (hour) {
            case 23:
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                message = applicationContext.getMessage(NIGHT, null, locale);
                break;
            case 6:
            case 7:
            case 8:
                message = applicationContext.getMessage(MORNING, null, locale);
                break;
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                message = applicationContext.getMessage(DAY, null, locale);
                break;
            case 19:
            case 20:
            case 21:
            case 22:
                message = applicationContext.getMessage(EVENING, null, locale);
                break;
        }

        log.info("Returned message: \"" + message + "\"");
        return message;
    }
}
