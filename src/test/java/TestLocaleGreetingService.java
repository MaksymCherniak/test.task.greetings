import org.junit.BeforeClass;
import org.junit.Test;
import test.task.locale.service.interfaces.LocaleGreetingService;
import test.task.locale.service.interfaces.ServiceFactory;

import java.io.UnsupportedEncodingException;
import java.time.LocalTime;
import java.util.Locale;
import java.util.ResourceBundle;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static test.task.locale.tools.AppStaticValues.*;

public class TestLocaleGreetingService {
    private static ResourceBundle messages;
    private static LocaleGreetingService localeGreetingService;
    private static Locale locale;

    private LocalTime localTime;
    private String expectedMessage;

    @BeforeClass
    public static void init() {
        locale = Locale.getDefault();
        messages = ResourceBundle.getBundle(MESSAGES_PATH, locale);
        localeGreetingService = ServiceFactory.getLocaleGreetingService();
    }

    @Test
    public void morningTimeTest() throws UnsupportedEncodingException {
        localTime = LocalTime.of(7, 15);

        expectedMessage = new String(messages.getString(MORNING).getBytes("ISO-8859-1"), "UTF-8");

        assertThat(localeGreetingService.getGreetingMessage(localTime), is(expectedMessage));
    }

    @Test
    public void dayTimeTest() throws UnsupportedEncodingException {
        localTime = LocalTime.of(10, 27);

        expectedMessage = new String(messages.getString(DAY).getBytes("ISO-8859-1"), "UTF-8");

        assertThat(localeGreetingService.getGreetingMessage(localTime), is(expectedMessage));
    }

    @Test
    public void eveningTimeTest() throws UnsupportedEncodingException {
        localTime = LocalTime.of(19, 0);

        expectedMessage = new String(messages.getString(EVENING).getBytes("ISO-8859-1"), "UTF-8");

        assertThat(localeGreetingService.getGreetingMessage(localTime), is(expectedMessage));
    }

    @Test
    public void nightTimeTest() throws UnsupportedEncodingException {
        localTime = LocalTime.of(0, 0);

        expectedMessage = new String(messages.getString(NIGHT).getBytes("ISO-8859-1"), "UTF-8");

        assertThat(localeGreetingService.getGreetingMessage(localTime), is(expectedMessage));
    }
}
