package segelzwerg.sporttooolbox.web.heatmap;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Controller
@SessionScope
public class HeatMapController {
    private final HeatMapService heatMapService;
    private BufferedImage heatmap;

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

    @PostMapping("/heatmap/generate")
    public String generate() throws UnirestException {
        try {
            heatMapService.generate();

        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/heatmap";
        }
        return "redirect:/heatmap/getImage";

    }

    @GetMapping("/heatmap/getImage")
    public String getImage() throws IOException, UnirestException {
        this.heatmap = heatMapService.getImage();
        checkHeatMap();
        return "redirect:/heatmap";
    }

    @GetMapping("/heatmap-file")
    public ResponseEntity<byte[]> getHeatmapFile() throws IOException {
        checkHeatMap();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.IMAGE_PNG);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(heatmap, "png", baos);
        byte[] bytes = baos.toByteArray();
        return new ResponseEntity<>(bytes, httpHeaders, HttpStatus.OK);
    }

    private void checkHeatMap() {
        if (heatmap == null) {
            System.out.println("Heatmap is not loaded");
            throw new NullPointerException("There is no heatmap loaded.");
        }
    }

}
