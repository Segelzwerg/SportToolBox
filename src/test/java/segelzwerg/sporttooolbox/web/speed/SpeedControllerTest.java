package segelzwerg.sporttooolbox.web.speed;

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
public class SpeedControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void speed_load_english() throws Exception {
        Locale.setDefault(Locale.US);
        mockMvc.perform(get("/speed"))
                .andExpect(status().isOk());
    }
}