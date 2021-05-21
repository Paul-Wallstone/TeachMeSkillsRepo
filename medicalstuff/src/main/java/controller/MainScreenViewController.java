package controller;


import classes.Stuff;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import object.Person;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MainScreenViewController {
    private static final String FXML_EDIT = "/view/edit.fxml";
    private Stage mainStage;
    private Parent fxmlEdit;
    private FXMLLoader fxmlLoader = new FXMLLoader();
    DBController dbController = new DBController();
    private EditDialogController editDialogController;
    private Stage editDialogStage;

    @FXML
    private Button addButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button updateButton;

    @FXML
    private TableView tableStuff;

    @FXML
    private TableColumn<Stuff, Integer> columnID;

    @FXML
    private TableColumn<Stuff, String> columnName;

    @FXML
    private TableColumn<Stuff, String> columnSurname;

    @FXML
    private TableColumn<Stuff, String> columnPosition;

    @FXML
    private TableColumn<Stuff, String> columnSpecialization;

    @FXML
    private TableColumn<Stuff, String> columnAge;

    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }


    @FXML
    private void initialize() throws SQLException {
        columnID.setCellValueFactory(new PropertyValueFactory<Stuff, Integer>("id"));
        columnName.setCellValueFactory(new PropertyValueFactory<Stuff, String>("name"));
        columnSurname.setCellValueFactory(new PropertyValueFactory<Stuff, String>("surname"));
        columnPosition.setCellValueFactory(new PropertyValueFactory<Stuff, String>("position"));
        columnAge.setCellValueFactory(new PropertyValueFactory<Stuff, String>("age"));
        columnSpecialization.setCellValueFactory(new PropertyValueFactory<Stuff, String>("specialization"));
        initListeners();
        dbController.inits();
        fillTable();
        initLoader();
    }

    private void fillTable() throws SQLException {
        dbController.setPersonList(dbController.findAll());
        tableStuff.setItems(dbController.getPersonList());
    }

    private void initListeners() {
        dbController.getPersonList().addListener(new ListChangeListener<Person>() {
            @Override
            public void onChanged(Change<? extends Person> c) {
            }
        });

        // слушает двойное нажатие для редактирования записи
        tableStuff.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 2) {
                    editDialogController.setPerson((Person) tableStuff.getSelectionModel().getSelectedItem());
                    showDialog();
                    try {
                        dbController.update(editDialogController.getPerson());
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private void initLoader() {
        try {
            fxmlLoader.setLocation(getClass().getResource("/view/edit.fxml"));
            fxmlEdit = fxmlLoader.load();
            editDialogController = fxmlLoader.getController();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void actionButtonPressed(ActionEvent actionEvent) throws SQLException {

        Object source = actionEvent.getSource();
        // если нажата не кнопка - выходим из метода
        if (!(source instanceof Button)) {
            return;
        }

        Button clickedButton = (Button) source;

        switch (clickedButton.getId()) {
            case "addButton":
                editDialogController.setPerson(new Person());
                showDialog();
                dbController.add(editDialogController.getPerson());
                break;

            case "updateButton":
                editDialogController.setPerson((Person) tableStuff.getSelectionModel().getSelectedItem());
                showDialog();
                dbController.update(editDialogController.getPerson());
                break;

            case "deleteButton":
                dbController.delete((Person) tableStuff.getSelectionModel().getSelectedItem());
                break;
        }

    }

    public void showDialog() {
        if (editDialogStage == null) {
            editDialogStage = new Stage();
            editDialogStage.setTitle("Редактирование записи");
            editDialogStage.setMinHeight(150);
            editDialogStage.setMinWidth(300);
            editDialogStage.setResizable(false);
            editDialogStage.setScene(new Scene(fxmlEdit));
            editDialogStage.initModality(Modality.WINDOW_MODAL);
            editDialogStage.initOwner(mainStage);
        }
        editDialogStage.showAndWait(); // для ожидания закрытия окна
    }
}
