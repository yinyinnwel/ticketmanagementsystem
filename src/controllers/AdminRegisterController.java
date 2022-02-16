package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import database.AdminRegister_DB;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import models.AdminRegister;
import product_out.___Bundle;

import javax.swing.*;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

public class AdminRegisterController implements Initializable {

    @FXML
    private AnchorPane registerPane;

    @FXML
    private ImageView adminphoto;

    @FXML
    private JFXTextField userName_txf;

    @FXML
    private ImageView imageView;

    @FXML
    private Button btn_browse;

    @FXML
    private Label errorName;

    @FXML
    private JFXTextField userEmail_txf;

    @FXML
    private JFXTextField userPhone_txf;

    @FXML
    private Label errorEmail;

    @FXML
    private Label errorPhone;

    @FXML
    private JFXTextField userNRC_txf;

    @FXML
    private JFXTextField userCity_txf;

    @FXML
    private Label errorNRC;

    @FXML
    private Label errorCity;

    @FXML
    private JFXPasswordField userPassword_txf;

    @FXML
    private JFXPasswordField userCon_Pwd_txf;

    @FXML
    private Label errorPwd;

    @FXML
    private JFXRadioButton radioMale=new JFXRadioButton("Male");

    @FXML
    private JFXRadioButton radioFemale=new JFXRadioButton("Female");

    @FXML
    private Label errorGender;

    @FXML
    private JFXButton btnCancel;

    @FXML
    private JFXButton btnRegister;

    private Timer tmrTimer;
    double i=0.0;

    String filepath = null;
    FileChooser filechooser = new FileChooser();
    ArrayList<AdminRegister> registerArrayList;

    String radioGender;

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
        ScaleTransition sct = new ScaleTransition(Duration.seconds(3), adminphoto);
        sct.setByX(0.3);
        sct.setByY(0.3);
        sct.setAutoReverse(true);
        sct.setCycleCount(ScaleTransition.INDEFINITE);
        sct.play();

        if(radioMale.isSelected()){
            radioGender = "male";
        }else {
            radioGender = "female";
        }

    }

    private void binding(){

    }


    private void actions(){

        radioMale.selectedProperty().addListener((o1,o2,newValue)->{
//            if(newValue){
                radioFemale.selectedProperty().set(!newValue);
        //    }
        });
        radioFemale.selectedProperty().addListener((o1,o2,newValue)->{
//            if(newValue){
                radioMale.selectedProperty().set(!newValue);
        //    }
        });


        userName_txf.textProperty().addListener((o1,o2,newValue)->{
            if(newValue.isEmpty()){
                errorName.setText("Your Name is required!");
            }else {
                errorName.setText(null);
                btnRegister.setDisable(false);
            }
        });

        userEmail_txf.textProperty().addListener((o1,o2,newValue)->{
            if(newValue.isEmpty()){
                errorEmail.setText("Your Email is required!");
            }else {
                errorEmail.setText(null);
                btnRegister.setDisable(false);
            }
        });

        userNRC_txf.textProperty().addListener((o1,o2,newValue)->{
            if(newValue.isEmpty()){
                errorNRC.setText("Your NRCNo is required!");
            }else {
                errorNRC.setText(null);
                btnRegister.setDisable(false);
            }
        });

        userPhone_txf.textProperty().addListener((o1,o2,newValue)->{
            if(newValue.isEmpty()){
                errorPhone.setText("Your PhoneNo is required!");
            }else {
                errorPhone.setText(null);
                btnRegister.setDisable(false);
            }
        });

        userCity_txf.textProperty().addListener((o1,o2,newValue)->{
            if(newValue.isEmpty()){
                errorCity.setText("Your City is required!");
            }else {
                errorCity.setText(null);
                btnRegister.setDisable(false);

            }
        });


        btn_browse.setOnAction(e->{
            File file = filechooser.showOpenDialog(null);
            imageView.setImage(new Image(file.toURI().toString()));
        });


        btnCancel.setOnAction(e->{
            AdminLoginController adminLoginController=new AdminLoginController();
            Parent parent= ___Bundle.__ViewLoader._getInstance()._load("adminLogin",adminLoginController);
            Stage stage=new Stage();
            stage.setScene(new Scene(parent));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.setTitle("Go Go Application");
            stage.getIcons().add(new Image("images/app_logo.jpg"));
            stage.centerOnScreen();
            stage.setResizable(false);
            stage.show();
            Stage currentStage= (Stage) registerPane.getScene().getWindow();
            currentStage.close();
        });

        btnRegister.setOnAction(e->{
            TextField[] fields = { userName_txf, userEmail_txf, userNRC_txf, userPhone_txf, userCity_txf,
                    userPassword_txf,userCon_Pwd_txf };


//       //     System.out.println(checkTextfield_Empty(fields));
//            if (checkTextfield_Empty(fields)) {
//
//                if (userPhone_txf.getText().length() == 11 && userPhone_txf.getText().startsWith("09")) {
//
//                    System.out.println(userPassword_txf.getText().equals(userCon_Pwd_txf.getText()));
//                    if (userPassword_txf.getText().equals(userCon_Pwd_txf.getText())) {
//
//
//                        if (userNRC_txf.getText().split("N\\)")[1].length() >= 6) {
//
////                            AdminRegister adminRegister = new AdminRegister(0, userName_txf.getText().toLowerCase(),filepath,
////                                    userEmail_txf.getText(), userNRC_txf.getText(), userPhone_txf.getText(),userCity_txf.getText().toLowerCase(),
////                                    userPassword_txf.getText(), "Male");
////                        System.out.println(radioGender);
////                            AdminRegister_DB.addRegister(adminRegister);
//
//                            new Alert(Alert.AlertType.CONFIRMATION, "Save Your Data!").showAndWait();
//
//
//                            userName_txf.clear();
//                            userEmail_txf.clear();
//                            userCity_txf.clear();
//                            userNRC_txf.clear();
//                            userPhone_txf.clear();
//                            userPassword_txf.clear();
//                            userCon_Pwd_txf.clear();
//                        } else {
//
//                        }
//
//                    } else {
//                        //  new Alert(Alert.AlertType.WARNING, "Do not match with pre_password!").showAndWait();
//                        errorPwd.setText("Do not match with pre_password!");
//                    }
//
//                } else {
//
//                }
//
//            } else {
//                new Alert(Alert.AlertType.ERROR, "Please fill your data").showAndWait();
//
//            }

            AdminLoginController adminLoginController=new AdminLoginController();
            Parent parent= ___Bundle.__ViewLoader._getInstance()._load("adminLogin",adminLoginController);
            Stage stage=new Stage();
            stage.setScene(new Scene(parent));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.setTitle("Go Go Application");
            stage.getIcons().add(new Image("images/app_logo.jpg"));
            stage.centerOnScreen();
            stage.setResizable(false);
            stage.show();
            Stage currentStage= (Stage) registerPane.getScene().getWindow();
            currentStage.close();

        });

    }

    public static boolean checkTextfield_Empty(TextField[] fields) { // check all textfields have text
        boolean flag = true;
        for (TextField field : fields) {
//            if (field.getText().trim().isEmpty() == true) {
//
//                flag = false;
//            }else {
//                flag = true;
//            }
            flag = field.getText().isEmpty()? true:false;
        }
        return flag;
    }
}
