package segelzwerg.sporttooolbox.web.heatmap;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
@SessionScope
public class HeatMapController {
    private final HeatMapService heatMapService;

    public HeatMapController(HeatMapService heatMapService) {
        this.heatMapService = heatMapService;
    }

    @GetMapping("/heatmap")
    public String index(Model model) {
        model.addAttribute("heatmap", new HeatMap());
        return "heatmap";
    }

    @PostMapping("/heatmap/upload")
    public String upload(Model model, MultipartFile file) throws IOException, UnirestException {
        heatMapService.uploadFile(file);
        return "redirect:/heatmap";
    }

    @GetMapping("/heatmap/generate")
    public String generate() {
        heatMapService.generate();
        return "redirect:/heatmap";

    }

    @GetMapping("/heatmap/")
    public String getImage(Model model) throws IOException, UnirestException {
        BufferedImage heatmap = heatMapService.getImage();
        model.addAttribute("heatmap", new HeatMap(heatmap));
        return "heatmap";
    }


}
