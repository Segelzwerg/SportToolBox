package segelzwerg.sporttooolbox.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import segelzwerg.sporttooolbox.IUnits.Speed;

/**
 * Speed Controller
 */
@Controller
public class SpeedController {
    private SpeedService service;

    @Autowired
    public SpeedController(SpeedService service) {
        this.service = service;
    }

    /**
     * Get speed page
     *
     * @param model
     * @return speed page name
     */
    @GetMapping("/speed")
    public String string(Model model) {
        model.addAttribute("form", new SpeedForm());
        return Translator.toLocale("SpeedForm");
    }

    /**
     * Calculate speed
     *
     * @param model
     * @param form
     * @return calculated speed
     */
    @PostMapping("/speed")
    public String speedCalculating(Model model, SpeedForm form) {
        model.addAttribute("form", form);
        Speed speed = service.calculateSpeed(form);
        SpeedPresenter speedPresenter = new SpeedPresenter(speed);
        model.addAttribute("speed", speedPresenter);
        return Translator.toLocale("SpeedForm");
    }
}
