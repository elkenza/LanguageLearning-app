package ma.xproce.languagelearning.service;

import ma.xproce.languagelearning.dao.entities.Individu;
import ma.xproce.languagelearning.dao.repositories.IndividuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IndividuManagerService implements IndividuManager{
    @Autowired
    IndividuRepository individuRepository;
    @Override
    public Individu addIndividu(Individu individu) {
        try {
            return  individuRepository.save(individu);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Individu updateIndividu(Individu individu) {
        Individu ind=individuRepository.findById(individu.getId()).get();
        ind.setName(individu.getName());
        ind.setEmail(individu.getEmail());
        ind.setPassword(individu.getPassword());
        ind.setTel(individu.getTel());
        ind.setTypeIndividu(individu.getTypeIndividu());
        ind.setCommentaires(individu.getCommentaires());
        ind.setEnseignememts(individu.getEnseignememts());
        ind.setEvaluation(individu.getEvaluation());
        ind.setMaitrises(individu.getMaitrises());
        ind.setLangues(individu.getLangues());
        individuRepository.save(ind);
        return ind;
    }

    @Override
    public boolean deleteIndividuById(Integer id) {
      if(individuRepository.existsById(id)){
          individuRepository.deleteById(id);
          return true;
      }
      else
          return false;
    }

    @Override
    public boolean deleteIndividu(Individu individu) {
        if(individuRepository.existsById(individu.getId())){
            individuRepository.delete(individu);
            return true;
        }
        else
            return false;
    }

    @Override
    public Individu getIndividuById(Integer id) {
        return individuRepository.findById(id).get();
    }

    @Override
    public Page<Individu> searchIndividu(String keyword, int page, int taille) {

        return individuRepository.findByNameContains(keyword, PageRequest.of(page,taille));
    }
}
