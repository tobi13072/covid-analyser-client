package org.example.UI;

import lombok.Getter;
import lombok.SneakyThrows;
import org.example.Connection.Connection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Getter
public class LoginPage extends JPanel implements ActionListener {
    private JPanel loginPanel;
    private JTextField loginField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel loginLabel;
    private JLabel passwordLabel;
    private HomePage home;


    public LoginPage(HomePage home) {
        this.home = home;
        loginButton.addActionListener(this);
    }

    @SneakyThrows
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source.equals(loginButton)) {

            Connection conn = new Connection();
            String username = loginField.getText();
            String pass = passwordField.getText();

            Integer statusCode = conn.login(username, pass);

            if (statusCode.equals(200)) {
                home.backToHome();
                home.setTitle(home.TITLE + " [" + username + "]");
            } else {
                Dialogs.showFailedLoginDialog();
            }
        }
    }
}
