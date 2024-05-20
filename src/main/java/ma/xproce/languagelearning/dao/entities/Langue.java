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
public class Langue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String logo;
  //  private boolean is_native;
   // private boolean learning_language;
  //  private boolean speaking_language;
    private TypeLangue typeLangue;
    @ManyToMany
    private Collection<Individu> individus;
    @OneToMany
    private Collection<Maitrise> maitrises;

}
