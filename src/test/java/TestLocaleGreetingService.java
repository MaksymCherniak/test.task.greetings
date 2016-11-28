import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import test.task.locale.service.interfaces.LocaleGreetingService;
import test.task.locale.tools.AppContext;

import java.time.LocalTime;
import java.util.Locale;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static test.task.locale.tools.AppStaticValues.*;

public class TestLocaleGreetingService {
    private static ApplicationContext applicationContext;
    private static LocaleGreetingService localeGreetingService;
    private static Locale locale;

    private LocalTime localTime;
    private String expectedMessage;

    @BeforeClass
    public static void init() {
        applicationContext = AppContext.getApplicationContext();
        localeGreetingService = (LocaleGreetingService) applicationContext.getBean("LocaleGreetingService");
        locale = new Locale(EN);
    }

    @Test
    public void morningTimeTest() {
        localTime = LocalTime.of(7, 15);

        expectedMessage = applicationContext.getMessage(MORNING, null, locale);

        assertThat(localeGreetingService.getGreetingMessage(localTime), is(expectedMessage));
    }

    @Test
    public void dayTimeTest() {
        localTime = LocalTime.of(10, 27);

        expectedMessage = applicationContext.getMessage(DAY, null, locale);

        assertThat(localeGreetingService.getGreetingMessage(localTime), is(expectedMessage));
    }

    @Test
    public void eveningTimeTest() {
        localTime = LocalTime.of(19, 0);

        expectedMessage = applicationContext.getMessage(EVENING, null, locale);

        assertThat(localeGreetingService.getGreetingMessage(localTime), is(expectedMessage));
    }

    @Test
    public void nightTimeTest() {
        localTime = LocalTime.of(0, 0);

        expectedMessage = applicationContext.getMessage(NIGHT, null, locale);

        assertThat(localeGreetingService.getGreetingMessage(localTime), is(expectedMessage));
    }
}
