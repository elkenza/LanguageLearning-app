package ma.xproce.languagelearning.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Individu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String password;
    private String tel;
    private TypeIndividu typeIndividu;
    @ManyToMany
    private Collection<Langue> langues;
    @OneToMany
    private Collection<Maitrise> maitrises;
    @OneToMany
    private Collection<Commentaire> commentaires;
    @OneToMany
    private Collection<Enseignememt> enseignememts;
    @OneToOne
    private Evaluation evaluation;
}
