package org.example.UI;

import lombok.Getter;
import lombok.SneakyThrows;
import org.example.Connection.ContinentConnection;
import org.example.Connection.Repsonse.ContinentResponse;
import org.example.Connection.Repsonse.StatResponse;
import org.example.Connection.StatisticsConnection;
import org.example.Filtration.FiltrationStatResponse;
import org.example.XML.RootXml;
import org.example.XML.XmlOperations;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@Getter
public class TableXmlPane extends JPanel implements ActionListener {
    private JPanel xmlPanel;
    private JScrollPane tableScrollPane;
    private JButton importButton;
    private JButton exportButton;
    private JButton backToHomePage;
    private JComboBox continentComboBox;
    private JTextField countryTextField;
    private JSpinner deathsSpinner;
    private JButton filterButton;
    private JLabel filterLabel;
    private JLabel filterCountryLabel;
    private DefaultTableModel model;
    private List<StatResponse> stats;
    private HomePage backHome;

    public TableXmlPane(HomePage backHome) throws IOException, URISyntaxException, InterruptedException {
        this.backHome = backHome;
        exportButton.addActionListener(this);
        importButton.addActionListener(this);
        backToHomePage.addActionListener(this);
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
        } else if (source.equals(exportButton)) {

            File outputFile = FileChooser.chooseFileToSave("xml");

            if (outputFile != null) {
                RootXml<StatResponse> statResponseRootXml = new RootXml<>();
                statResponseRootXml.setListOfElements(stats);

                XmlOperations<RootXml> operations = new XmlOperations<>();
                operations.exportXML(statResponseRootXml, outputFile, RootXml.class, StatResponse.class);
                Dialogs.showExportInformation();
            }


        } else if (source.equals(importButton)) {

            model.setRowCount(0);

            File file = FileChooser.chooseFileToOpen();

            if (file != null) {
                XmlOperations<RootXml> operations = new XmlOperations<>();
                RootXml<StatResponse> importRoot = operations.importXML(file, RootXml.class, StatResponse.class);
                stats = importRoot.getListOfElements();
            }

            int statusCode = StatisticsConnection.updateStatistics(stats);
            if (statusCode == 401) {
                Dialogs.showFailedPermission();
            }
            if(statusCode == 200){
                completeRowsInTable();
                Dialogs.showUpdateInformation();
            }

        }else if(source.equals(filterButton)){

            String continent = continentComboBox.getSelectedItem().toString();
            String country = countryTextField.getText();
            String deaths = deathsSpinner.getValue().toString();

            model.setRowCount(0);
            stats = FiltrationStatResponse.filterData(continent,country,deaths);
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

        model.addColumn("Country");
        model.addColumn("Population");
        model.addColumn("Total cases");
        model.addColumn("Total deaths");
        model.addColumn("Total recovered");
        model.addColumn("Active cases");

        JTable table = new JTable(model);
        tableScrollPane.setViewportView(table);
    }

    public void setNumberModelForSpinner() {
        SpinnerNumberModel numberModel = new SpinnerNumberModel(0, 0, 2000000000, 1);
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

                continentComboBox.setSelectedItem("");
                deathsSpinner.setValue(0);

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


        continentComboBox.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                countryTextField.setText("");
            }
        });

        deathsSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                countryTextField.setText("");
            }
        });
    }
}
