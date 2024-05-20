package ma.xproce.languagelearning.service;

import ma.xproce.languagelearning.dao.entities.Evaluation;
import ma.xproce.languagelearning.dao.entities.Individu;

import java.util.List;

public interface EvaluationManager {
    public Evaluation addEvaluation(Evaluation evaluation);
    public Evaluation updateEvaluation(Evaluation evaluation);
    public boolean deleteEvaluationById(Integer id);
    public  boolean deleteEvaluation(Evaluation evaluation);
    public Evaluation getEvaluationById(Integer id);
    public List<Evaluation> getAllEvaluation();

}
