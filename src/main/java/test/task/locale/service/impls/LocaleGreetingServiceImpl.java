package test.task.locale.service.impls;

import org.apache.log4j.Logger;
import test.task.locale.service.interfaces.LocaleGreetingService;

import java.io.UnsupportedEncodingException;
import java.time.LocalTime;
import java.util.Locale;
import java.util.ResourceBundle;

import static test.task.locale.tools.AppStaticValues.*;

public class LocaleGreetingServiceImpl implements LocaleGreetingService {
    private static Logger log = Logger.getLogger(LocaleGreetingService.class.getName());

    public String getGreetingMessage(LocalTime localTime) {
        log.info("Get greeting message was called at " + localTime.toString());

        Locale locale = Locale.getDefault();
        ResourceBundle messages = ResourceBundle.getBundle(MESSAGES_PATH, locale);

        int hour = localTime.getHour();
        String message;

        if (hour >= 6 && hour < 9) {
            message = messages.getString(MORNING);
        } else if (hour >= 9 && hour < 19) {
            message = messages.getString(DAY);
        } else if (hour >= 19 && hour < 23) {
            message = messages.getString(EVENING);
        } else {
            message = messages.getString(NIGHT);
        }

        try {
            message = new String(message.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        log.info("Returned message: \"" + message + "\"");
        return message;
    }
}
