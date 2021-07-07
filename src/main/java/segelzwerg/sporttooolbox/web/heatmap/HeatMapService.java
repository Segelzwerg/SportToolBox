package segelzwerg.sporttooolbox.web.heatmap;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

@Component
public class HeatMapService {
    private Integer sessionId = null;
    @Value(value = "${heatmap.service.url}")
    private String heatmapProviderURL;

    public void requestSessionId() throws UnirestException {
        this.sessionId = Integer.parseInt(Unirest.get(heatmapProviderURL + "/create-session")
                .asString()
                .getBody());
    }

    public void uploadFile(MultipartFile file) throws UnirestException, IOException {
        if (sessionId == null) {
            requestSessionId();
        }
        File originalFile = new File(System.getProperty("java.io.tmpdir") + System.getProperty("file.separator") + Objects.requireNonNull(file.getOriginalFilename()));
        file.transferTo(originalFile);
        Unirest.post(heatmapProviderURL + "/upload")
                .field("session", sessionId)
                .field("file", originalFile)
                .asBinary().getBody();
    }

    public void generate() throws UnirestException {
        Unirest.post(heatmapProviderURL + "/generate")
                .field("session", sessionId)
                .asString().getBody();
    }

    public BufferedImage getImage() throws UnirestException, IOException {

        try {
            HttpResponse<InputStream> session = Unirest.post(heatmapProviderURL + "/get-image")
                    .field("session", sessionId)
                    .asBinary();
            InputStream rawBody = session
                    .getRawBody();
            return ImageIO.read(rawBody);
        } catch (UnirestException | IOException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
