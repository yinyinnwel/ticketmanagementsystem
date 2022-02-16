package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.ScaleTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import product_out.___Bundle;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AdminLoginController implements Initializable {

    @FXML
    private AnchorPane AdminloginPane;

    @FXML
    private ImageView adminPhoto;

    @FXML
    private JFXTextField userName;

    @FXML
    private Label errorName;

    @FXML
    private JFXPasswordField userPassword;

    @FXML
    private Label errorPassword;

    @FXML
    private CheckBox remember;

    @FXML
    private JFXButton btnRegister;

    @FXML
    private JFXButton btnLogin;

    @FXML
    private ChoiceBox<String> choiceBox;

    private Timer tmrTimer;
    double i=0.0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.init();
    }

    private void init(){
        prepare();
        binding();
        actions();
    }

    private void prepare(){

        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add("Admin");
        arrayList.add("User");
        ObservableList<String> ob=FXCollections.observableArrayList(arrayList);
        choiceBox.setItems(ob);
        choiceBox.getSelectionModel().select(0);


        choiceBox.setOnAction(e -> {
          //  System.out.println("hello");
            if(choiceBox.getValue().equals("User")){
                UserLoginController userLoginController=new UserLoginController();
                Parent parent= ___Bundle.__ViewLoader._getInstance()._load("userLogin",userLoginController);
                Stage stage=new Stage();
                stage.setScene(new Scene(parent));
                stage.initModality(Modality.WINDOW_MODAL);
                stage.setTitle("Go Go Application");
                stage.getIcons().add(new Image("images/app_logo.jpg"));
                stage.centerOnScreen();
                stage.setResizable(false);
                stage.show();
                Stage currentStage= (Stage) AdminloginPane.getScene().getWindow();
                currentStage.close();
            }
        });

        ScaleTransition sct = new ScaleTransition(Duration.seconds(3), adminPhoto);
        sct.setByX(1);
        sct.setByY(1);
        sct.setAutoReverse(true);
        sct.setCycleCount(ScaleTransition.INDEFINITE);
        sct.play();

    }

    private void binding(){


    }


    private void actions(){
        btnLogin.setOnAction(e->{
            AdminDashboardController adminDashboardController=new AdminDashboardController();
            Parent parent= ___Bundle.__ViewLoader._getInstance()._load("adminDashboard",adminDashboardController);
            Stage stage=new Stage();
            stage.setScene(new Scene(parent));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.setTitle("Go Go Application");
            stage.getIcons().add(new Image("images/app_logo.jpg"));
            stage.centerOnScreen();
            stage.setMaximized(true);
           // stage.setResizable(false);
            stage.show();
            Stage currentStage= (Stage) AdminloginPane.getScene().getWindow();
            currentStage.close();

       /*     tmrTimer = new Timer(40, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    i += 0.01;
                    progressBar.setProgress(i);
                    if (i == 1.0000000000000007) {
                        i = 0.0;
                        tmrTimer.stop();
                        AdminloginPane.setVisible(false);
                    }
                }
            });
            tmrTimer.start();*/
        });

        btnRegister.setOnAction(e->{
            AdminRegisterController adminRegisterController=new AdminRegisterController();
            Parent parent= ___Bundle.__ViewLoader._getInstance()._load("adminRegister",adminRegisterController);
            Stage stage=new Stage();
            stage.setScene(new Scene(parent));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.setTitle("Go Go Application");
            stage.getIcons().add(new Image("images/app_logo.jpg"));
            stage.centerOnScreen();
            stage.setResizable(false);
            stage.show();
            Stage currentStage= (Stage) AdminloginPane.getScene().getWindow();
            currentStage.close();
        });
    }
}
