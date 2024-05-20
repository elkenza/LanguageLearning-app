package ma.xproce.languagelearning.web;


import ma.xproce.languagelearning.dao.entities.Langue;
import ma.xproce.languagelearning.service.LangueManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LanguageController {
    @Autowired
    LangueManager langueManager;

    @GetMapping("")
    public String start(){
        return "homePage";
    }

    @GetMapping("listeLangues")
    public String afficherLangue(Model model,@RequestParam(name = "page",defaultValue = "0") int page,
                                 @RequestParam(name = "taille",defaultValue = "6") int taille,
                                 @RequestParam(name = "search", defaultValue = "") String keyword){
        Page<Langue> liste= langueManager.searchLangue(keyword,page,taille);
        model.addAttribute("listeLangues",liste.getContent());
        int[] pages=new int[liste.getTotalPages()];
        model.addAttribute("pages",pages);
        model.addAttribute("keyword", keyword);
        model.addAttribute("currentPage",page);
        return "listeLangues";
    }

    @GetMapping("addLangue")
    public String ajouterLangue(Model model){
        Langue langue=new Langue();
        model.addAttribute("langue",langue);
        return "addLangue";
    }
    @PostMapping("addLangue")
    public String ajout(@ModelAttribute("langue")Langue langue){

        //Langue langue=new Langue(null,name,logo,Boolean.parseBoolean(is_native),Boolean.parseBoolean(learning_language),Boolean.parseBoolean(speaking_language),null,null);
        langueManager.addLangue(langue);
        return "redirect:listeLangues";
    }

    @GetMapping("/deleteLangue")
    public String deleteLangue(Model model,@RequestParam(name = "id") Integer id){
        if(langueManager.deleteLangueById(id))
            return "redirect:listeLangues";
        else
            return "error";
    }
    @GetMapping("/editLangue")
    public String editLangue(Model model,@RequestParam(name = "id") Integer id){
        Langue lang=langueManager.getLangueById(id);
        model.addAttribute("updatedLangue",lang);
        return "editLangue";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("langue")Langue langue){
        //boolean isNativeValue = is_native != null ? Boolean.parseBoolean(is_native) : false;
       // boolean learningLanguageValue = learning_language != null ? Boolean.parseBoolean(learning_language) : false;
        //boolean speakingLanguageValue = speaking_language != null ? Boolean.parseBoolean(speaking_language) : false;

        langueManager.updateLangue(langue);
        return "redirect:listeLangues";
    }
}
