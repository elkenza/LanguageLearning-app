package ma.xproce.languagelearning.service;

import ma.xproce.languagelearning.dao.entities.Enseignememt;
import ma.xproce.languagelearning.dao.entities.Evaluation;

import java.util.List;

public interface EnseignememtManager {
    public Enseignememt addEnseignememt(Enseignememt enseignememt);
    public Enseignememt updateEnseignememt(Enseignememt enseignememt);
    public boolean deleteEnseignememtById(Integer id);
    public  boolean deleteEnseignememt(Enseignememt enseignememt);
    public Enseignememt getEnseignememtById(Integer id);
    public List<Enseignememt> getAllEnseignememt();

}
