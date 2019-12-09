package segelzwerg.sporttooolbox.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import segelzwerg.sporttooolbox.IUnits.Pace;

@Controller
public class PaceController {
    private final PaceService paceService;

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
        model.addAttribute("form", new SpeedForm());
        return Translator.toLocale("PaceForm");
    }

    /**
     * calculates pace
     *
     * @param model
     * @param form
     * @return
     */
    @PostMapping("/pace")
    public String computePace(Model model, SpeedForm form) {
        model.addAttribute("form", form);
        Pace pace = paceService.calculatePace(form);
        PacePresenter pacePresenter = new PacePresenter(pace);
        model.addAttribute("pace", pacePresenter);
        return Translator.toLocale("PaceForm");
    }
}
