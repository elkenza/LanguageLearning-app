package ma.xproce.languagelearning.service;

import ma.xproce.languagelearning.dao.entities.Individu;
import ma.xproce.languagelearning.dao.entities.Langue;
import org.springframework.data.domain.Page;

import java.util.List;

public interface LangueManager {
    public Langue addLangue(Langue langue);
    public Langue updateLangue(Langue langue);
    public boolean deleteLangueById(Integer id);
    public  boolean deleteLangue(Langue langue);
    public Langue getLangueById(Integer id);
    public Page<Langue> searchLangue(String keyword, int page, int taille);

}
