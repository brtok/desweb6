/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inscricao.validate;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Bruno
 */
@FacesConverter("cpfConverter")
public class CPFConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) throws ConverterException {
        try {
            if (!string.matches("^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$")
                    && !string.matches("^\\d{3}\\d{3}\\d{3}\\-\\d{2}$")
                    && !string.matches("^\\d{11}$")) {
                FacesMessage msg = new FacesMessage("CPF '" + string + "' inválido.");
                throw new ConverterException(msg);
            }
            String onlyNum = string.replace("-", "").replace(".", "");
            if (onlyNum.length() != 11) {
                FacesMessage msg = new FacesMessage("CPF '" + string + "' inválido");
                throw new ConverterException(msg);
            }
            for (char c : onlyNum.toCharArray()) {
                if (!Character.isDigit(c)) {
                    FacesMessage msg = new FacesMessage("CPF '" + string + "' inválido");
                    throw new ConverterException(msg);
                }
            }
            long cpf = Long.parseLong(onlyNum);
            return cpf;
        } catch (ConverterException | NumberFormatException e) {
            FacesMessage msg = new FacesMessage("CPF '" + string + "' inválido");
            throw new ConverterException(msg);
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        long cpfLong = (long) o;
        String cpf = Long.toString(cpfLong);

        // Caso em que o cpf perdeu os primeiros dígito na conversão por eles serem 0
        if (cpf.length() < 11) {
            int numZeros = 11 - cpf.length();
            for (int i = 0; i < numZeros; i++) {
                cpf = "0" + cpf;
            }
        }
        
        cpf = cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9, 11);
        return cpf;
    }

}
