package segelzwerg.sporttooolbox.web;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class Translator {

    public static String toLocale(String messageCode) {
        Locale locale = LocaleContextHolder.getLocale();
        if (Locale.US == locale) {
            return messageCode;
        }
        return locale.getLanguage() + "/" + messageCode;
    }
}
