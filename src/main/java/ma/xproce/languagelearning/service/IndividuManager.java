package ma.xproce.languagelearning.service;

import ma.xproce.languagelearning.dao.entities.Individu;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IndividuManager {
    public Individu addIndividu(Individu individu);
    public Individu updateIndividu(Individu individu);
    public boolean deleteIndividuById(Integer id);
    public  boolean deleteIndividu(Individu individu);
    public Individu getIndividuById(Integer id);
    public Page<Individu> searchIndividu(String keyword, int page, int taille);

}
