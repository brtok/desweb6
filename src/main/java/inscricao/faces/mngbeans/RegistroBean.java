/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inscricao.faces.mngbeans;

import inscricao.entity.Candidato;
import inscricao.entity.CandidatosList;
import java.io.Serializable;
import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 *
 * @author Bruno
 */
@Named("registroBean")
@ApplicationScoped
public class RegistroBean extends utfpr.faces.support.PageBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private CandidatosList candidatosList;
    
    public ArrayList<Candidato> getCandidatosList() {
        return candidatosList.getCandidatosList();
    }

    public void setCandidatosList(ArrayList<Candidato> CandidatosList) {
        this.candidatosList.setCandidatosList(CandidatosList);
    }

    public RegistroBean() {
        candidatosList = new CandidatosList();
    }

    public void addCandidato(Candidato candidato) {
        candidatosList.add(candidato);
    }
    
    public void removeCandidato(Candidato candidato) {
        candidatosList.remove(candidato);
    }
    
}
