package org.example.UI;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.time.LocalDate;

public class FileChooser {
    public static File chooseFileToOpen() {
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setDialogTitle("Wybierz plik JSON do otworzenia:");
        int returnValue = jfc.showOpenDialog(null);

        File file = null;

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            file = jfc.getSelectedFile();
        }
        return file;
    }

    public static File chooseFileToSave(String fileExtension) {
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setDialogTitle("Wybierz kataolg do zapisu pliku:");
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnValue = jfc.showSaveDialog(null);

        File outputFile = null;

        if (returnValue == JFileChooser.APPROVE_OPTION && jfc.getSelectedFile().isDirectory()) {
            StringBuilder fileName = new StringBuilder().append("\\raport-").append(LocalDate.now()).append(".").append(fileExtension);
            String filePath = jfc.getSelectedFile() + fileName.toString();
            outputFile = new File(filePath);
        }
        return outputFile;
    }
}
