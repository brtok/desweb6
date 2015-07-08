/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inscricao.faces.mngbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import utfpr.faces.support.RequestBean;

/**
 *
 * @author Bruno
 */
@ManagedBean
@RequestScoped
public class LoginBean extends RequestBean {
    
    private String login;
    private String senha;
    private String result;
    
    public LoginBean() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String logoutAction() {
        String action = null;
        HttpServletRequest request = getRequest();
        try {
            request.logout();
            action = "/index.xhtml?faces-redirect=true";
        } catch (ServletException e) {
            log("logoutAction", e);
        }
        return action;
    }
}
