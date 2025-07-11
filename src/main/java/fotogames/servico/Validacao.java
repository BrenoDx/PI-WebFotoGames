/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fotogames.servico;

import javax.swing.JOptionPane;

/**
 *
 * @author breno
 */
public class Validacao {

    public boolean cliente(String cpf, String email, String telefone) {
        boolean status = true;
        if (!cpf.matches("[0-9]{3}[.]{1}[0-9]{3}[.]{1}[0-9]{3}[-]{1}[0-9]{2}")) {
            JOptionPane.showMessageDialog(null, "CPF do paciente inválido! xxx.xxx.xxx-xx");
            status = false;
        } else if (!email.matches("\\w+@\\w+\\.\\w{2,3}\\.\\w{2,3}")) {
            JOptionPane.showMessageDialog(null, "Email inválido!");
            status = false;
        } else if (!telefone.matches("[(]{1}[0-9]{2}[)][0-9]{9}")) {
            JOptionPane.showMessageDialog(null, "Telefone inválido! (xx)xxxxxxxxx");
            status = false;
        }
        return status;
    }
}
