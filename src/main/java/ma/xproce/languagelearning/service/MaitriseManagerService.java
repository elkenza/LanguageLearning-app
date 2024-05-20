package ma.xproce.languagelearning.service;

import ma.xproce.languagelearning.dao.entities.Maitrise;
import ma.xproce.languagelearning.dao.repositories.MaitriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MaitriseManagerService implements MaitriseManager {
    @Autowired
    MaitriseRepository maitriseRepository;
    @Override
    public Maitrise addMaitrise(Maitrise maitrise) {
        try {
            return  maitriseRepository.save(maitrise);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Maitrise updateMaitrise(Maitrise maitrise) {
        Maitrise mait=maitriseRepository.findById(maitrise.getId()).get();
        mait.setIndividu(maitrise.getIndividu());
        mait.setLangue(maitrise.getLangue());
        mait.setExperienceLinguistique(maitrise.getExperienceLinguistique());
        mait.setNiveauLangue(maitrise.getNiveauLangue());
        return mait;
    }

    @Override
    public boolean deleteMaitriseById(Integer id) {
        if(maitriseRepository.existsById(id)){
            maitriseRepository.deleteById(id);
            return true;
        }
        else
            return false;
    }

    @Override
    public boolean deleteMaitrise(Maitrise maitrise) {
        if(maitriseRepository.existsById(maitrise.getId())){
            maitriseRepository.delete(maitrise);
            return true;
        }
        else
            return false;
    }

    @Override
    public Maitrise getMaitriseById(Integer id) {
        return maitriseRepository.findById(id).get();
    }

    @Override
    public List<Maitrise> getAllMaitrise() {
        return maitriseRepository.findAll();
    }
}
