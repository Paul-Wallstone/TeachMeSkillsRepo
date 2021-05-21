package application;

import controller.MainScreenViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.CRUDUtils;
import utils.DBUtils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class App extends Application {
//    private static Connection connection;
//
//    public static Connection getConnection() {
//        return connection;
//    }
//
//    public static void inits() throws SQLException {
//        connection = DBUtils.getConnection();
//    }
//
//    public static void close() throws SQLException {
//        connection.close();
//    }

    @Override
    public void init() throws Exception {
        System.out.println("Application inits");
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("Launching Application");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/view/mainScreenView.fxml"));
        Parent fxmlMain = fxmlLoader.load();
        MainScreenViewController mainController = fxmlLoader.getController();
        mainController.setMainStage(primaryStage);

        primaryStage.setTitle("База персонала");
        primaryStage.setMinHeight(400);
        primaryStage.setMinWidth(600);
        primaryStage.setScene(new Scene(fxmlMain, 600, 400));
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        System.out.println("Application stops");
        super.stop();
    }


    public static void main(String[] args) throws SQLException {
        Application.launch(args);

//        inits();
//        System.out.println("Init");
//        CRUDUtils.getDoctorsData(connection).stream().forEach(System.out::println);
//        Stuff stuff = new Stuff(1, "FF", "FF", 100, "FF", "FF");
//        CRUDUtils.updateDoctorsData(stuff, connection);
//        CRUDUtils.deleteDoctorsData(2, connection);
//        Stuff stuff2 = new Stuff(1, "FFW", "FFW", 100, "FFW", "FFW");
//        CRUDUtils.saveStudentData(stuff2, connection);
//        CRUDUtils.getDoctorsData(connection).stream().forEach(System.out::println);
//        close();
//        System.out.println("Close");

    }
}