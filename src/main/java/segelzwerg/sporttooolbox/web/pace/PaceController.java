package segelzwerg.sporttooolbox.web.pace;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.annotation.SessionScope;
import segelzwerg.sporttooolbox.iunits.Time;
import segelzwerg.sporttooolbox.iunits.distance.Distance;
import segelzwerg.sporttooolbox.iunits.pace.Pace;
import segelzwerg.sporttooolbox.web.DistanceAutoFillFactory;
import segelzwerg.sporttooolbox.web.Translator;
import segelzwerg.sporttooolbox.web.speed.SpeedForm;

@Controller
@SessionScope
public class PaceController {
    private final PaceService paceService;
    private SpeedForm form = null;

    public PaceController(PaceService paceService) {
        this.paceService = paceService;
    }

    /**
     * get pace page
     *
     * @param model
     * @return pace page name
     */
    @GetMapping("/pace")
    public String index(Model model) {
        if (form == null) {
            form = new SpeedForm();
        }
        model.addAttribute("form", form);
        return Translator.toLocale("PaceForm");
    }

    /**
     * calculates pace
     *
     * @param model
     * @param paceForm
     * @return
     */
    @PostMapping("/pace")
    public String computePace(Model model, SpeedForm paceForm) {
        form = paceForm;
        model.addAttribute("form", paceForm);
        if (paceForm.getPace() == 0) {
            Pace pace = paceService.calculatePace(paceForm);
            PacePresenter pacePresenter = new PacePresenter(pace);
            model.addAttribute("pace", pacePresenter);
        } else if (paceForm.getSecond() == 0 && paceForm.getMinute() == 0 && paceForm.getHour() == 0) {
            Time time = paceService.calculateTime(paceForm);
            model.addAttribute("time", time);
        } else if (form.getMajor() == 0 && form.getMinor() == 0) {
            Distance distance = paceService.calculateDistance(form);
            model.addAttribute("distance", distance);
        }
        return Translator.toLocale("PaceForm");
    }

    /**
     * fills out some distances values from template
     *
     * @param model
     * @param distance
     * @return
     */
    @PostMapping("/pace/autodistance")
    public String autoDistance(Model model, String distance) {
        form = DistanceAutoFillFactory.autoDistance(distance);
        return "redirect:/pace";
    }
}
