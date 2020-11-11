package segelzwerg.sporttoolbox.web.heatmap;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

@Component
public class HeatMapService {
    private Integer sessionId = null;

    public void requestSessionId() throws UnirestException {
        this.sessionId = Integer.parseInt(Unirest.get("http://heatmap-provider:5000/create-session")
                .asString()
                .getBody());
    }

    public void uploadFile(MultipartFile file) throws UnirestException, IOException {
        if (sessionId == null) {
            requestSessionId();
        }
        File originalFile = new File(System.getProperty("java.io.tmpdir") + System.getProperty("file.separator") + Objects.requireNonNull(file.getOriginalFilename()));
        file.transferTo(originalFile);
        Unirest.post("http://heatmap-provider:5000/upload")
                .field("session", sessionId)
                .field("file", originalFile)
                .asEmpty();
    }

    public void generate() throws UnirestException {
        Unirest.post("http://heatmap-provider:5000/generate")
                .field("session", sessionId)
                .asString().getBody();
    }

    public BufferedImage getImage() throws UnirestException, IOException {

        HttpResponse<byte[]> session = Unirest.post("http://heatmap-provider:5000/get-image")
                .field("session", sessionId)
                .asBytes();
        return ImageIO.read(session.<InputStream>mapBody(ByteArrayInputStream::new));
    }
}
