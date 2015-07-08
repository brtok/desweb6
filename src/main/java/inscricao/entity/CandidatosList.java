/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inscricao.entity;

import java.util.ArrayList;

/**
 *
 * @author Bruno
 */
public class CandidatosList {
    
    private ArrayList<Candidato> candidatosList;
    
    public CandidatosList() {
        candidatosList = new ArrayList<>();
    }
    
    public void add(Candidato candidato) {
        candidatosList.add(candidato);
    }
    
    public void remove(Candidato candidato) {
        candidatosList.remove(candidato);
        int indice = -1;
        for (int i = 0; i < candidatosList.size(); i++) {
            if (candidatosList.get(0).getCpf().equals(candidato.getCpf())) {
                indice = i;
            }
        }
        if (indice != -1) {
            candidatosList.remove(indice);
        }
    }
    
    public ArrayList<Candidato> getCandidatosList() {
        return candidatosList;
    }
    
    public void setCandidatosList(ArrayList<Candidato> candidatosList) {
        this.candidatosList = candidatosList;
    }
}
