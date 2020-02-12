package segelzwerg.sporttooolbox.web.pace;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import segelzwerg.sporttooolbox.web.speed.SpeedForm;

import java.util.Locale;

import static io.florianlopes.spring.test.web.servlet.request.MockMvcRequestBuilderUtils.postForm;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PaceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private SpeedForm paceForm;

    @BeforeEach
    void setUp() {
        paceForm = new SpeedForm();
        paceForm.setMajor(10);
        paceForm.setHour(1);
        paceForm.setDistanceMajorUnit("kilometer");
        paceForm.setPaceUnit("minutesPerKilometer");
    }

    @Test
    void pace_load_english() throws Exception {
        Locale.setDefault(Locale.US);
        mockMvc.perform(get("/pace"))
                .andExpect(status().isOk());
    }

    @Test
    void pace_load_german() throws Exception {
        Locale.setDefault(Locale.GERMANY);
        mockMvc.perform(get("/pace"))
                .andExpect(status().isOk());
    }

    @Test
    void paceCalculatingTest() throws Exception {
        MockHttpServletRequestBuilder builder = postForm("/pace", paceForm);
        mockMvc.perform(builder).andExpect(status().isOk());
    }

    @Test
    void autoDistanceTest() throws Exception {
        mockMvc.perform(post("/pace/autodistance").param("distance", "50km")).andExpect(status().is3xxRedirection());
    }

    @Test
    void timeCalculationTest() throws Exception {
        SpeedForm paceForm = new SpeedForm();
        paceForm.setMajor(100);
        paceForm.setDistanceMajorUnit("kilometer");
        paceForm.setDistanceMinorUnit("meter");
        paceForm.setHour(0);
        paceForm.setMinute(0);
        paceForm.setSecond(0);
        paceForm.setPace(4.3f);
        paceForm.setPaceUnit("minutesPerKilometer");

        MockHttpServletRequestBuilder builder = postForm("/pace", paceForm);

        mockMvc.perform(builder).andExpect(status().isOk());
    }
}