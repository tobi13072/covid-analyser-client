package org.example.UI;

import lombok.Getter;
import lombok.SneakyThrows;
import org.example.Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;


@Getter
public class HomePage extends JFrame implements ActionListener {
    private JButton XMLOperationsButton;
    private JPanel homePanel;
    private JButton jsonOperationsButton;
    private JButton exitButton;
    private LoginPage login;

    public HomePage() throws IOException {
        setTitle("COVID ANALYSER");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BufferedImage image = Objects.requireNonNull(Icon.getIcon()).orElseThrow(RuntimeException::new);
        setIconImage(image);

        if (Objects.isNull(login)) {
            login = new LoginPage(this);
            setContentPane(login.getLoginPanel());
        } else {
            setContentPane(homePanel);
        }


        XMLOperationsButton.addActionListener(this);
        jsonOperationsButton.addActionListener(this);
        exitButton.addActionListener(this);
    }

    @SneakyThrows
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source.equals(XMLOperationsButton)) {
            TableXmlPane table = new TableXmlPane(this);
            setContentPane(table.getXmlPanel());
            revalidate();
        } else if (source.equals(jsonOperationsButton)) {
            TableJsonPane table = new TableJsonPane(this);
            setContentPane(table.getJsonPanel());
            revalidate();
        } else if (source.equals(exitButton)) {

            setContentPane(login.getLoginPanel());

            File file = new File("token.txt");
            if (file.exists()) {
                file.delete();
            }

        }
    }

    public void backToHome() {
        login.getLoginField().setText("");
        login.getPasswordField().setText("");
        setContentPane(homePanel);
        revalidate();
    }
}
