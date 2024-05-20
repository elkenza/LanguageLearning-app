package ma.xproce.languagelearning.service;

import ma.xproce.languagelearning.dao.entities.Individu;
import ma.xproce.languagelearning.dao.entities.Langue;
import ma.xproce.languagelearning.dao.repositories.IndividuRepository;
import ma.xproce.languagelearning.dao.repositories.LangueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LangueManagerService implements LangueManager{
    @Autowired
    LangueRepository langueRepository;
    @Override
    public Langue addLangue(Langue langue) {
        try {
            return  langueRepository.save(langue);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Langue updateLangue(Langue langue) {
        Langue lang=langueRepository.findById(langue.getId()).get();
        lang.setName(langue.getName());
        lang.setLogo(langue.getLogo());
        lang.setTypeLangue(langue.getTypeLangue());
        lang.setIndividus(langue.getIndividus());
        lang.setMaitrises(langue.getMaitrises());
        langueRepository.save(lang);
        return lang;
    }

    @Override
    public boolean deleteLangueById(Integer id) {
      if(langueRepository.existsById(id)){
          langueRepository.deleteById(id);
          return true;
      }
      else
          return false;
    }

    @Override
    public boolean deleteLangue(Langue langue) {
        if(langueRepository.existsById(langue.getId())){
            langueRepository.delete(langue);
            return true;
        }
        else
            return false;
    }

    @Override
    public Langue getLangueById(Integer id) {
        return langueRepository.findById(id).get();
    }

    @Override
    public Page<Langue> searchLangue(String keyword, int page, int taille) {
        return langueRepository.findByNameContains(keyword, PageRequest.of(page,taille));
    }
}
