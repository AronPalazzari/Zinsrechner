package vertiefendeAufgabe02;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ZinsController {

    @GetMapping("/zins")
    public String zins(@Valid @ModelAttribute("zinsForm") ZinsForm zinsform,
                       BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()) {
            return "zins";
        }

        model.addAttribute("endkapital", zinsform.getAnfangskapital() *
                            Math.pow(1 + zinsform.getZinssatz() / 100,
                                    zinsform.getLaufzeit()));

        java.util.List<ZinsZeile> zeilen = new java.util.ArrayList<>();
        double kapital = zinsform.getAnfangskapital();

        for (int jahr = 1; jahr <= zinsform.getLaufzeit(); jahr++) {
            double zinsen = kapital * zinsform.getZinssatz() / 100;
            zeilen.add(new ZinsZeile(jahr, kapital, zinsen, kapital + zinsen));
            kapital += zinsen;
        }

        model.addAttribute("zeilen", zeilen);

        return "zins";
    }
}
