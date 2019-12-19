package segelzwerg.sporttooolbox.web.heatmap;

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
public class HeatMapControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void speed_load_english() throws Exception {
        Locale.setDefault(Locale.US);
        mockMvc.perform(get("/heatmap"))
                .andExpect(status().isOk());
    }

    @Test
    void speed_load_german() throws Exception {
        Locale.setDefault(Locale.GERMANY);
        mockMvc.perform(get("/heatmap"))
                .andExpect(status().isOk());
    }

}