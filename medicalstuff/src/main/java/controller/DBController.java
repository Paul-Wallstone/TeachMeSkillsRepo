package controller;

import classes.Stuff;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import object.Person;
import utils.CRUDUtils;
import utils.DBUtils;

import java.sql.Connection;
import java.sql.SQLException;


public class DBController {
    private static Connection connection;

    public static Connection getConnection() {
        return connection;
    }

    public static void inits() throws SQLException {
        connection = DBUtils.getConnection();
    }

    public static void close() throws SQLException {
        connection.close();
    }

    private ObservableList<Person> personList = FXCollections.observableArrayList();

    public void setPersonList(ObservableList<Person> personList) {
        this.personList = personList;
    }

    public boolean add(Person person) {
        try {
            Stuff stuff = new Stuff(person.getId(), person.getName(), person.getSurname(), person.getAge(), person.getPosition(), person.getSpecialization());
            CRUDUtils.saveDoctorsData(stuff, connection);
            personList.clear();
            findAll();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }


    // для коллекции не используется, но пригодится для случая, когда данные хранятся в БД и пр.
    public boolean update(Person person) throws SQLException {
        Stuff stuff = new Stuff(person.getId(), person.getName(), person.getSurname(), person.getAge(), person.getPosition(), person.getPosition());
        CRUDUtils.updateDoctorsData(stuff, getConnection());
        personList.clear();
        findAll();
        return true;
    }


    public boolean delete(Person person) throws SQLException {
        CRUDUtils.deleteDoctorsData(person.getId(), getConnection());
        personList.clear();
        findAll();
        return true;
    }

    public ObservableList<Person> getPersonList() {
        return personList;
    }

    public ObservableList<Person> findAll() throws SQLException {
        for (Stuff s : CRUDUtils.getDoctorsData(getConnection())) {
            personList.add(new Person(s.getId(), s.getName(), s.getSurname(), s.getAge(), s.getPosition(), s.getSpecialization()));
        }
        return personList;
    }
}

