package segelzwerg.sporttooolbox.web.speed;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Locale;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SpeedControllerGermanTest {
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
    public void speedLoadGerman() throws Exception {
        Locale.setDefault(Locale.GERMANY);
        mockMvc.perform(get("/speed"))
                .andExpect(status().isOk());
    }
}
