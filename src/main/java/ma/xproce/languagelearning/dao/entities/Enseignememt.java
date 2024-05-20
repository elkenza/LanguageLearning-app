package ma.xproce.languagelearning.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Enseignememt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date dateEns;
    @ManyToOne
    private Individu individuEtudant;
    @ManyToOne
    private Individu individuEnseignant;



}
