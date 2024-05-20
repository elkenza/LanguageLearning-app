package ma.xproce.languagelearning.service;

import ma.xproce.languagelearning.dao.entities.Evaluation;
import ma.xproce.languagelearning.dao.repositories.EvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EvaluationManagerService implements EvaluationManager{
    @Autowired
    EvaluationRepository evaluationRepository;
    @Override
    public Evaluation addEvaluation(Evaluation evaluation) {
        try {
            return  evaluationRepository.save(evaluation);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Evaluation updateEvaluation(Evaluation evaluation) {
       Evaluation ev=evaluationRepository.findById(evaluation.getId()).get();
       ev.setIndividu(evaluation.getIndividu());
       ev.setNote(evaluation.getNote());
       ev.setMention(ev.getMention());
       return ev;
    }

    @Override
    public boolean deleteEvaluationById(Integer id) {
        if(evaluationRepository.existsById(id)){
            evaluationRepository.deleteById(id);
            return true;
        }
        else
            return false;
    }

    @Override
    public boolean deleteEvaluation(Evaluation evaluation) {
        if(evaluationRepository.existsById(evaluation.getId())){
            evaluationRepository.delete(evaluation);
            return true;
        }
        else
            return false;
    }

    @Override
    public Evaluation getEvaluationById(Integer id) {
        return evaluationRepository.findById(id).get();
    }

    @Override
    public List<Evaluation> getAllEvaluation() {
        return evaluationRepository.findAll();
    }
}
