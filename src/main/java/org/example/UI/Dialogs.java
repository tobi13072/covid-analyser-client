package org.example.UI;

import javax.swing.*;

public class Dialogs {
    public static void showFailedLoginDialog() {

        String message = "Username or password is invalid. Try again.";

        JOptionPane.showMessageDialog(null, message, "Login error", JOptionPane.ERROR_MESSAGE);
    }
    public static void showFailedPermission() {

        String message = "Available only for administrator.";

        JOptionPane.showMessageDialog(null, message, "Permission denied", JOptionPane.ERROR_MESSAGE);
    }

    public static void showUpdateInformation(){
        String message = "Records were modified";

        JOptionPane.showMessageDialog(null, message, "Modification", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void showExportInformation(){
        String message = "Data was successfully exported";

        JOptionPane.showMessageDialog(null, message, "Export", JOptionPane.INFORMATION_MESSAGE);
    }
}
