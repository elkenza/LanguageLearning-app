package ma.xproce.languagelearning;

import ma.xproce.languagelearning.dao.entities.*;
import ma.xproce.languagelearning.dao.repositories.*;
import ma.xproce.languagelearning.security.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LanguageLearningApplication {
    @Autowired
    IndividuRepository individuRepository;
    @Autowired
    LangueRepository langueRepository;
    @Autowired
    CommentaireRepository commentaireRepository;
    @Autowired
    EnseignementRepository enseignementRepository;
    @Autowired
    MaitriseRepository maitriseRepository;
    @Autowired
    EvaluationRepository evaluationRepository;

    public static void main(String[] args) {
        SpringApplication.run(LanguageLearningApplication.class, args);
    }
   @Bean
    public CommandLineRunner commandLineRunner(AccountService accountService){
        return args -> {
          /*  Individu individu = new Individu(null,"Ilyas","ilyastiken@outlook.fr","ilyas123","0650023922", TypeIndividu.Etudiant,null,null,null,null,null);
            individuRepository.save(individu);
            Langue langue=new Langue(null,"français","fr.png", TypeLangue.is_native,null,null);
            langueRepository.save(langue);
            Langue langue1=new Langue(null,"English","eng.png",TypeLangue.learning_language,null,null);
            langueRepository.save(langue1);
            accountService.createUser("admin","admin@gmail.com","123","123");

            accountService.createUser("user","user@gmail.com","1234","1234");
            accountService.createRole("ADMIN");

            accountService.createRole("USER");

            accountService.addRoleToUser("admin","ADMIN");
            accountService.addRoleToUser("user","USER");
            accountService.addRoleToUser("admin","USER");*/
           // accountService.removeRoleFromUser("admin","USER");

        };
    }

}
