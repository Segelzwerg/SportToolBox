package segelzwerg.sporttooolbox.web;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class TranslatorTest {


    private String messageCode;

    @BeforeEach
    void setUp() {
        messageCode = "message_code";
    }

    @Test
    void toLocale_US() {
        Locale.setDefault(Locale.US);
        String translatedMessageCode = Translator.toLocale(messageCode);
        assertThat(translatedMessageCode, equalTo(messageCode));

    }

    @Test
    void toLocale_DE() {
        Locale.setDefault(Locale.GERMANY);
        String translatedMessageCode = Translator.toLocale(messageCode);
        String expectedMessageCode = "de/" + messageCode;
        assertThat(translatedMessageCode, equalTo(expectedMessageCode));
    }
}