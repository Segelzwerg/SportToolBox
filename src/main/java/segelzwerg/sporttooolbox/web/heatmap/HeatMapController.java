package segelzwerg.sporttooolbox.web.heatmap;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.multipart.MultipartFile;
import segelzwerg.sporttooolbox.web.ImageService;

import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;

@Controller
@SessionScope
public class HeatMapController {
    private HeatMapService heatMapService;
    private BufferedImage heatmap;
    private ImageService imageService;

    public HeatMapController(HeatMapService heatMapService, ImageService imageService) {
        this.heatMapService = heatMapService;
        this.imageService = imageService;
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
        heatMapService.generate();
        return "redirect:/heatmap/getImage";

    }

    @GetMapping("/heatmap/getImage")
    public String getImage() throws IOException, UnirestException {
        BufferedImage image = heatMapService.getImage();
        if (image == null) {
            throw new FileNotFoundException("There is no generated file on the server.");
        }
        this.heatmap = image;
        return "redirect:/heatmap";
    }

    @GetMapping("/heatmap-file")
    public ResponseEntity<byte[]> getHeatmapFile() throws IOException {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.IMAGE_PNG);
        byte[] bytes = imageService.getImageBytes(heatmap);
        return new ResponseEntity<>(bytes, httpHeaders, HttpStatus.OK);
    }

    @ExceptionHandler({UnirestException.class, FileNotFoundException.class})
    public String error() {
        return "/heatmap";
    }

}
