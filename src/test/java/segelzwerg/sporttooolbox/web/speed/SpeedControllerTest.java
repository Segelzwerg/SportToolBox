package segelzwerg.sporttooolbox.web.speed;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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

    @Autowired
    private MockMvc mockMvc;

    private SpeedForm speedForm;

    @BeforeEach
    public void setUp() {
        speedForm = new SpeedForm();
        speedForm.setMajor(10);
        speedForm.setHour(1);
        speedForm.setDistanceMajorUnit("kilometer");
        speedForm.setSpeedUnit("kilometerPerHour");
    }

    @Test
    public void speed_load_english() throws Exception {
        Locale.setDefault(Locale.US);
        mockMvc.perform(get("/speed"))
                .andExpect(status().isOk());
    }

    @Test
    public void speedCalculatingTest() throws Exception {
        MockHttpServletRequestBuilder builder = postForm("/speed", speedForm);
        mockMvc.perform(builder).andExpect(status().isOk());
    }

    @Test
    public void autoDistanceTest() throws Exception {
        mockMvc.perform(post("/speed/autodistance").param("distance", "50km")).andExpect(status().is3xxRedirection());
    }

    @Test
    public void timeCalculationTest() throws Exception {
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
}