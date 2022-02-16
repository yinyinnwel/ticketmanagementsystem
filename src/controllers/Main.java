package controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import product_out.___Bundle;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        AdminLoginController adminLoginController=new AdminLoginController();
        Parent parent = ___Bundle.__ViewLoader._getInstance()._load("adminLogin",adminLoginController);
        Stage stage=new Stage();
        stage.setScene(new Scene(parent));
        stage.setTitle("Go Go Application");
        stage.getIcons().add(new Image("images/app_logo.jpg"));
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();
    }


    public  static  void  main(String [] args){
        launch(args);
    }
}
