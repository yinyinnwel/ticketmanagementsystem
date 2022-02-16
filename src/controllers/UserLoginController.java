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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import product_out.___Bundle;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class UserLoginController implements Initializable {

    @FXML
    private AnchorPane userLoginPane;

    @FXML
    private ImageView userPhoto;

    @FXML
    private JFXTextField userName;

    @FXML
    private Label errorName;

    @FXML
    private JFXPasswordField userPassword;

    @FXML
    private Label errorPassword;

    @FXML
    private JFXButton btnCancel;

    @FXML
    private JFXButton btnLogin;

    @FXML
    private ChoiceBox<String> choiceBox;


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
        ObservableList<String> ob= FXCollections.observableArrayList(arrayList);
        choiceBox.setItems(ob);
        choiceBox.getSelectionModel().select(1);


        choiceBox.setOnAction(e -> {
            //  System.out.println("hello");
            if(choiceBox.getValue().equals("Admin")){
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
                Stage currentStage= (Stage) userLoginPane.getScene().getWindow();
                currentStage.close();
            }
        });

        ScaleTransition sct = new ScaleTransition(Duration.seconds(3), userPhoto);
        sct.setByX(0.8);
        sct.setByY(0.8);
        sct.setAutoReverse(true);
        sct.setCycleCount(ScaleTransition.INDEFINITE);
        sct.play();
    }
    private void binding(){


    }


    private void actions(){
        btnLogin.setOnAction(e->{
            UserDashboardController userDashboardController=new UserDashboardController();
            Parent parent= ___Bundle.__ViewLoader._getInstance()._load("userDashboard",userDashboardController);
            Stage stage=new Stage();
            stage.setScene(new Scene(parent));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.setTitle("Go Go Application");
            stage.getIcons().add(new Image("images/app_logo.jpg"));
            stage.centerOnScreen();
            // stage.setResizable(false);
            stage.show();
            Stage currentStage= (Stage) userLoginPane.getScene().getWindow();
            currentStage.close();
        });

        btnCancel.setOnAction(e->{

        });
    }
}
