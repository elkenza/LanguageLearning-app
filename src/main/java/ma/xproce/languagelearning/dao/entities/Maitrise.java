package ma.xproce.languagelearning.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Maitrise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String niveauLangue;
    private String experienceLinguistique;
    @ManyToOne
    private Individu individu;
    @ManyToOne
    private Langue langue;
}
