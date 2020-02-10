package segelzwerg.sporttooolbox.web;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Component
public class Translator {
    static List<Locale> englishLocals = new ArrayList<Locale>(Arrays.asList(Locale.ENGLISH, Locale.US));

    public static String toLocale(String messageCode) {
        Locale locale = LocaleContextHolder.getLocale();
        if (englishLocals.contains(locale)) {
            return messageCode;
        }
        return locale.getLanguage() + "/" + messageCode;
    }
}
