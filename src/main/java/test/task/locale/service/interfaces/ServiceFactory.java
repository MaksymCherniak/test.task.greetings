package test.task.locale.service.interfaces;

import test.task.locale.service.impls.LocaleGreetingServiceImpl;

public class ServiceFactory {
    private static LocaleGreetingService localeGreetingService;

    public static LocaleGreetingService getLocaleGreetingService() {
        if (localeGreetingService == null) {
            localeGreetingService = new LocaleGreetingServiceImpl();
        }

        return localeGreetingService;
    }
}
