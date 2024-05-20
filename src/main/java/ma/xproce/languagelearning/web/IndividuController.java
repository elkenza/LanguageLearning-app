package ma.xproce.languagelearning.web;

import ma.xproce.languagelearning.dao.entities.Individu;
import ma.xproce.languagelearning.dao.entities.Langue;
import ma.xproce.languagelearning.dao.entities.TypeIndividu;
import ma.xproce.languagelearning.service.IndividuManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndividuController {
    @Autowired
    IndividuManager individuManager;
    @GetMapping("listeIndividus")
    public String afficherIndividus(Model model,@RequestParam(name = "page",defaultValue = "0") int page,
                                    @RequestParam(name = "taille",defaultValue = "6") int taille,
                                    @RequestParam(name = "search", defaultValue = "") String keyword){
        Page<Individu> pageIndividu=individuManager.searchIndividu(keyword,page,taille);
        model.addAttribute("listeIndividus",pageIndividu.getContent());
        int[] pages=new int[pageIndividu.getTotalPages()];
        model.addAttribute("pages",pages);
        model.addAttribute("keyword", keyword);
        model.addAttribute("currentPage",page);
        return "listeIndividus";
    }
    @GetMapping("/addIndividu")
    public String addIndividu(Model model){
        Individu individu=new Individu();
        model.addAttribute("individu",individu);
        return "addIndividu";
    }

    @PostMapping("addIndividu")
    public String ajouter(@ModelAttribute("individu")Individu individu){
        if(individu.getTypeIndividu()==null)
            return "error";
       /* TypeIndividu tp;
        if(type=="Etudiant"){
            tp=TypeIndividu.Etudiant;
        } else if (type=="Enseignant") {
            tp=TypeIndividu.Enseignant;
        }else
            tp=TypeIndividu.both;

        Individu individu=new Individu(null,name,email,password,tel,tp,null,null,null,null,null);*/
        individuManager.addIndividu(individu);
        return "redirect:listeIndividus";
    }
    @GetMapping("/deleteIndividu")
    public String deleteIndividu(Model model,@RequestParam(name = "id") Integer id){
        if(individuManager.deleteIndividuById(id))
            return "redirect:listeIndividus";
        else
            return "error";
    }
    @GetMapping("/editIndividu")
    public String editIndividu(Model model,@RequestParam(name = "id") Integer id){
        Individu ind=individuManager.getIndividuById(id);
        Individu individu=new Individu();
        model.addAttribute("individu",individu);
        model.addAttribute("updatedIndividu",ind);
        return "editIndividu";
    }
    @PostMapping("/editIndividu")
    public String modifier(@ModelAttribute("individu")Individu individu){
        /*
        TypeIndividu tp;
        if(type=="Etudiant"){
            tp=TypeIndividu.Etudiant;
        } else if (type=="Enseignant") {
            tp=TypeIndividu.Enseignant;
        }else
            tp=TypeIndividu.both;

        Individu individu=new Individu(id,name,email,password,tel,tp,null,null,null,null,null);*/
        individuManager.updateIndividu(individu);
        return "redirect:listeIndividus";
    }


}
