package org.example.UI;

import com.google.gson.reflect.TypeToken;
import lombok.Getter;
import lombok.SneakyThrows;
import org.example.Connection.ContinentConnection;
import org.example.Connection.Repsonse.ContinentResponse;
import org.example.Connection.Repsonse.StatResponse;
import org.example.Connection.StatisticsConnection;
import org.example.Filtration.FiltrationStatResponse;
import org.example.JSON.JsonOperations;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@Getter
public class TableJsonPane extends JPanel implements ActionListener {

    private HomePage backHome;
    private JButton backToHomePage;
    private JPanel jsonPanel;
    private JScrollPane tableScrollPane;
    private JButton exportJson;
    private JButton importJson;
    private JTextField countryTextField;
    private JSpinner deathsSpinner;
    private JButton filterButton;
    private JLabel filterLabel;
    private JComboBox continentComboBox;
    private DefaultTableModel model;
    private List<StatResponse> stats;

    public TableJsonPane(HomePage backHome) throws IOException, URISyntaxException, InterruptedException {

        this.backHome = backHome;
        backToHomePage.addActionListener(this);
        exportJson.addActionListener(this);
        importJson.addActionListener(this);
        filterButton.addActionListener(this);

        createTable();
        setNumberModelForSpinner();
        completeContinentComboBox();
        addValidationToTextField();

        stats = StatisticsConnection.getAllStatistics();
        completeRowsInTable();
    }


    @SneakyThrows
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source.equals(backToHomePage)) {

            backHome.backToHome();

        } else if (source.equals(exportJson)) {

            File outputFile = FileChooser.chooseFileToSave("json");

            if (outputFile != null) {

                JsonOperations<StatResponse> jsonOperations = new JsonOperations<>();
                jsonOperations.exportJson(stats, outputFile);
            }


        } else if (source.equals(importJson)) {

            model.setRowCount(0);

            File inputFile = FileChooser.chooseFileToOpen();

            if (inputFile != null) {
                JsonOperations<StatResponse> jsonOperations = new JsonOperations<>();
                stats = jsonOperations.importJson(inputFile, new TypeToken<List<StatResponse>>() {
                });

                int statusCode = StatisticsConnection.updateStatistics(stats);
                if(statusCode == 401){
                    Dialogs.showFailedPermission();
                }else {
                    completeRowsInTable();
                    Dialogs.showUpdateInformation();
                }
            }



        } else if (source.equals(filterButton)) {

            String continent = continentComboBox.getSelectedItem().toString();
            String country = countryTextField.getText();
            String deaths = deathsSpinner.getValue().toString();

            model.setRowCount(0);
            stats = FiltrationStatResponse.filterData(continent, country, deaths);
            completeRowsInTable();
        }
    }

    public void completeRowsInTable() {
        for (StatResponse object : stats) {
            model.addRow(new Object[]{object.getCountry().getCountryName(), object.getCountryPopulation(), object.getTotalCases(), object.getTotalDeaths(), object.getTotalRecovered(), object.getActiveAccess()});
        }
    }

    public void createTable() {
        model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        model.addColumn("country");
        model.addColumn("population");
        model.addColumn("total cases");
        model.addColumn("total deaths");
        model.addColumn("total recovered");
        model.addColumn("active cases");

        JTable table = new JTable(model);
        tableScrollPane.setViewportView(table);
    }

    public void setNumberModelForSpinner() {
        SpinnerNumberModel numberModel = new SpinnerNumberModel(-1, -1, 2000000000, 1);
        deathsSpinner.setModel(numberModel);
    }

    public void completeContinentComboBox() throws IOException, URISyntaxException, InterruptedException {

        List<ContinentResponse> continentList = ContinentConnection.getAllContinent();
        continentComboBox.addItem("");
        for (ContinentResponse element : continentList) {
            continentComboBox.addItem(element.getContinentName());
        }
    }

    public void addValidationToTextField() {

        countryTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char c = e.getKeyChar();
                if (Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) {
                    countryTextField.setEditable(true);
                } else {
                    countryTextField.setEditable(false);
                    countryTextField.setEnabled(true);
                }
            }
        });
    }
}
