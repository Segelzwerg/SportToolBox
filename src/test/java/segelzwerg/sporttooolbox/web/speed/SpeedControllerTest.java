package segelzwerg.sporttooolbox.web.speed;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.Locale;

import static io.florianlopes.spring.test.web.servlet.request.MockMvcRequestBuilderUtils.postForm;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SpeedControllerTest {
    private static final String LOCATION_PROVIDER = "locations";

    @Autowired
    private MockMvc mockMvc;

    private SpeedForm speedForm;

    public static Locale[] locations() {
        return new Locale[]{Locale.US, Locale.GERMANY};
    }

    @BeforeEach
    public void setUp() {
        speedForm = new SpeedForm();
        speedForm.setMajor(10);
        speedForm.setHour(1);
        speedForm.setDistanceMajorUnit("kilometer");
        speedForm.setSpeedUnit("kilometerPerHour");
    }

    @ParameterizedTest
    @MethodSource(LOCATION_PROVIDER)
    @SneakyThrows
    public void loadContext(Locale locale) {
        Locale.setDefault(locale);
        mockMvc.perform(get("/speed"))
                .andExpect(status().isOk());
    }

    @ParameterizedTest
    @MethodSource(LOCATION_PROVIDER)
    @SneakyThrows
    public void speedCalculatingTest(Locale locale) {
        Locale.setDefault(locale);

        MockHttpServletRequestBuilder builder = postForm("/speed", speedForm);
        mockMvc.perform(builder).andExpect(status().isOk());
    }

    @ParameterizedTest
    @MethodSource(LOCATION_PROVIDER)
    @SneakyThrows
    public void autoDistanceTest(Locale locale) {
        Locale.setDefault(locale);

        mockMvc.perform(post("/speed/autodistance").param("distance", "50km")).andExpect(status().is3xxRedirection());
    }

    @ParameterizedTest
    @MethodSource(LOCATION_PROVIDER)
    @SneakyThrows
    public void timeCalculationTest(Locale locale) {
        Locale.setDefault(locale);

        SpeedForm speedForm = new SpeedForm();
        speedForm.setMajor(100);
        speedForm.setDistanceMajorUnit("kilometer");
        speedForm.setDistanceMinorUnit("meter");
        speedForm.setHour(0);
        speedForm.setMinute(0);
        speedForm.setSecond(0);
        speedForm.setSpeed(4.3f);
        speedForm.setSpeedUnit("kilometerPerHour");

        MockHttpServletRequestBuilder builder = postForm("/speed", speedForm);

        mockMvc.perform(builder).andExpect(status().isOk());
    }

    @ParameterizedTest
    @MethodSource(LOCATION_PROVIDER)
    public void distanceCalculationTest(Locale locale) throws Exception {
        Locale.setDefault(locale);

        SpeedForm speedForm = new SpeedForm();
        speedForm.setMajor(0);
        speedForm.setMinor(0);
        speedForm.setHour(3);
        speedForm.setSpeed(30);
        speedForm.setSpeedUnit("kilometerPerHour");

        MockHttpServletRequestBuilder builder = postForm("/speed", speedForm);

        mockMvc.perform(builder).andExpect(status().isOk());
    }
}