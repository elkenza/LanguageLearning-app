package ma.xproce.languagelearning.web;

import ma.xproce.languagelearning.dao.entities.Commentaire;
import ma.xproce.languagelearning.dao.entities.Individu;
import ma.xproce.languagelearning.service.CommentaireService;
import ma.xproce.languagelearning.service.IndividuManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CommentaireController {
    @Autowired
    CommentaireService commentaireService;
    @Autowired
    IndividuManager individuManager;
    @GetMapping("listeComments")
    public String listeComments(Model model){
        List<Commentaire> commentaireList=commentaireService.getAllCommentaire();
        model.addAttribute("listeComments",commentaireList);
        return "listeComments";
    }
    @GetMapping("addComment")
    public String addComments(){
        return "addComment";
    }
    @PostMapping("addComment")
    public String ajouterCommentaire(@RequestParam(name="message") String message,
                                     @RequestParam(name = "individuEtudiant") Integer idindividuEtudiant,
                                     @RequestParam(name = "individuEnseignant") Integer idindividuEnseignant){
        Individu individuEtudiant=individuManager.getIndividuById(idindividuEtudiant);
        Individu individuEnseignant=individuManager.getIndividuById(idindividuEnseignant);
        Commentaire commentaire=new Commentaire(null,message,individuEtudiant,individuEnseignant);
        commentaireService.addCommentaire(commentaire);
        return "redirecr:listeComments";
    }
    @GetMapping("deleteComment")
    public String deleteComment(@RequestParam(name = "id") Integer id){
        if(commentaireService.deleteCommentaireById(id))
            return "redirecr:listeComments";
        else
            return "error";

    }



}
