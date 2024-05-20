package ma.xproce.languagelearning.service;

import ma.xproce.languagelearning.dao.entities.Commentaire;
import ma.xproce.languagelearning.dao.entities.Maitrise;

import java.util.List;

public interface MaitriseManager {
    public Maitrise addMaitrise(Maitrise maitrise);
    public Maitrise updateMaitrise(Maitrise maitrise);
    public boolean deleteMaitriseById(Integer id);
    public  boolean deleteMaitrise(Maitrise maitrise);
    public Maitrise getMaitriseById(Integer id);
    public List<Maitrise> getAllMaitrise();

}
