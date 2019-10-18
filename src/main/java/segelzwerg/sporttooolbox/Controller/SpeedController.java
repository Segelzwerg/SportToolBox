package segelzwerg.sporttooolbox.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import segelzwerg.sporttooolbox.IUnits.Speed;
import segelzwerg.sporttooolbox.SpeedCalculator;

@Controller
public class SpeedController {
    private SpeedCalculator speedCalculator;

    @Autowired
    public SpeedController(SpeedCalculator speedCalculator) {
        this.speedCalculator = speedCalculator;
    }

    @GetMapping("/speed")
    public String string(Model model) {
        model.addAttribute("form", new SpeedForm());
        return "speedform";
    }

    @PostMapping("/speed")
    public String speedCalculating(Model model, SpeedForm form) {
        model.addAttribute("form", form);
        Speed speed = speedCalculator.computeSpeed();
        model.addAttribute("speed", speed);
        return "speedform";
    }
}
