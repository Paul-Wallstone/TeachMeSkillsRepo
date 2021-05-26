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
    }
}