package ma.xproce.languagelearning.service;

import ma.xproce.languagelearning.dao.entities.Enseignememt;
import ma.xproce.languagelearning.dao.repositories.EnseignementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EnseignememtManagerService implements EnseignememtManager{
    @Autowired
    EnseignementRepository enseignementRepository;
    @Override
    public Enseignememt addEnseignememt(Enseignememt enseignememt) {
        try {
            return  enseignementRepository.save(enseignememt);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Enseignememt updateEnseignememt(Enseignememt enseignememt) {
       Enseignememt ens=enseignementRepository.findById(enseignememt.getId()).get();
       ens.setDateEns(enseignememt.getDateEns());
       ens.setIndividuEtudant(enseignememt.getIndividuEtudant());
       ens.setIndividuEnseignant(enseignememt.getIndividuEnseignant());
       return ens;
    }

    @Override
    public boolean deleteEnseignememtById(Integer id) {
        if(enseignementRepository.existsById(id)){
            enseignementRepository.deleteById(id);
            return true;
        }
        else
            return false;
    }

    @Override
    public boolean deleteEnseignememt(Enseignememt enseignememt) {
        if(enseignementRepository.existsById(enseignememt.getId())){
            enseignementRepository.delete(enseignememt);
            return true;
        }
        else
            return false;
    }

    @Override
    public Enseignememt getEnseignememtById(Integer id) {
        return enseignementRepository.findById(id).get();
    }

    @Override
    public List<Enseignememt> getAllEnseignememt() {
        return enseignementRepository.findAll();
    }
}
