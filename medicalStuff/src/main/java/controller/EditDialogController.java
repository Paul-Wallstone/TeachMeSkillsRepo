package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import object.Person;


public class EditDialogController {


    @FXML
    private TextField txtName;

    @FXML
    private TextField txtSurname;

    @FXML
    private TextField txtAge;

    @FXML
    private TextField txtPosition;

    @FXML
    private TextField txtSpecialization;


    @FXML
    private Button btnOk;

    @FXML
    private Button btnCancel;


    private Person person = new Person();

    public void setPerson(Person person) {
        if (person == null) {
            return;
        }
        this.person = person;
        txtName.setText(person.getName());
        txtSurname.setText(person.getSurname());
        txtAge.setText(String.valueOf(person.getAge()));
        txtPosition.setText(person.getPosition());
        txtSpecialization.setText(person.getSpecialization());
    }

    public Person getPerson() {
        return person;
    }

    public void actionClose(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.hide();
    }

    public void actionSave(ActionEvent actionEvent) {
        if (!checkValues()) {
            return;
        }
        person.setName(txtName.getText());
        person.setSurname(txtSurname.getText());
        person.setAge(Integer.parseInt(txtAge.getText()));
        person.setPosition(txtPosition.getText());
        person.setSpecialization(txtSpecialization.getText());
        actionClose(actionEvent);
    }

    private boolean checkValues() {
        if (txtName.getText().trim().length() == 0 || txtSurname.getText().trim().length() == 0) {
            return false;
        }
        return true;
    }

}
