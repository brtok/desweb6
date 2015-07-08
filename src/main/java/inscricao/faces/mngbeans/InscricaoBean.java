package inscricao.faces.mngbeans;

import inscricao.entity.Candidato;
import inscricao.entity.Idioma;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import utfpr.faces.support.PageBean;

/**
 *
 * @author Wilson
 */
@ManagedBean
@RequestScoped
@Named
public class InscricaoBean extends PageBean {

    private static final Idioma[] idiomas = {
        new Idioma(1, "Inglês"),
        new Idioma(2, "Alemão"),
        new Idioma(3, "Francês")
    };
    private Candidato candidato = new Candidato(idiomas[0]); // inicialmente ingles
    private List<SelectItem> idiomaItemList;
    
    private ListDataModel<Candidato> dataModel;
    
    public InscricaoBean() {
        RegistroBean bean = (RegistroBean) getBean("registroBean");
        ArrayList<Candidato> list = bean.getCandidatosList();
        dataModel = new ListDataModel(list);
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public List<SelectItem> getIdiomaItemList() {
        if (idiomaItemList != null) {
            return idiomaItemList;
        }
        idiomaItemList = new ArrayList<>();
        for (Idioma id : idiomas) {
            idiomaItemList.add(new SelectItem(id.getCodigo(), id.getDescricao()));
        }
        return idiomaItemList;
    }

    public String confirmaAction() {
        candidato.setDataHora(new Date());
        candidato.setIdioma(idiomas[candidato.getIdioma().getCodigo() - 1]);
        RegistroBean bean = (RegistroBean) getBean("registroBean");
        bean.addCandidato(candidato);
        return "confirma";
    }

    public String candidatoAction(Candidato candidato) {
        setCandidato(candidato);
        return "inscricao";
    }

    public String excluirAction(Candidato candidato) {
        RegistroBean bean = (RegistroBean) getBean("registroBean");
        bean.removeCandidato(candidato);
        
        return "candidatos";
    }

    public ListDataModel getDataModel() {
        return dataModel;
    }
}
