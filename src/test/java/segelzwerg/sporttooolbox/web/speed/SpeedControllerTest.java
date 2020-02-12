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
    void setUp() {
        speedForm = new SpeedForm();
        speedForm.setMajor(10);
        speedForm.setHour(1);
        speedForm.setDistanceMajorUnit("kilometer");
        speedForm.setSpeedUnit("kilometerPerHour");
    }

    @Test
    void speed_load_english() throws Exception {
        Locale.setDefault(Locale.US);
        mockMvc.perform(get("/speed"))
                .andExpect(status().isOk());
    }

    @Test
    void speed_load_german() throws Exception {
        Locale.setDefault(Locale.GERMANY);
        mockMvc.perform(get("/speed"))
                .andExpect(status().isOk());
    }

    @Test
    void speedCalculatingTest() throws Exception {
        MockHttpServletRequestBuilder builder = postForm("/speed", speedForm);
        mockMvc.perform(builder).andExpect(status().isOk());
    }

    @Test
    void autoDistanceTest() throws Exception {
        mockMvc.perform(post("/speed/autodistance").param("distance", "50km")).andExpect(status().is3xxRedirection());
    }
}