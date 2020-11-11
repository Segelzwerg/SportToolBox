package segelzwerg.sporttoolbox.web.heatmap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.image.BufferedImage;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HeatMap {
    private BufferedImage heatmap;
}
