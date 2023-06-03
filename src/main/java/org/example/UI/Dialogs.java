package org.example.UI;

import javax.swing.*;

public class Dialogs {
    public static void showFailedLoginDialog() {

        String message = "Nieudane logowanie. Spróbuj ponownie.";

        JOptionPane.showMessageDialog(null, message, "Błąd logowania", JOptionPane.ERROR_MESSAGE);
    }
    public static void showFailedPermission() {

        String message = "Dostępne tylko dla admina.";

        JOptionPane.showMessageDialog(null, message, "Błąd logowania", JOptionPane.ERROR_MESSAGE);
    }

    public static void showUpdateInformation(){
        String message = "Rekordy zostały zmodyfikowane";

        JOptionPane.showMessageDialog(null, message, "Modyfikacja", JOptionPane.INFORMATION_MESSAGE);
    }
}
