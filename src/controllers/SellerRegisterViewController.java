package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import product_out.___Bundle;

import java.net.URL;
import java.util.ResourceBundle;

public class SellerRegisterViewController implements Initializable {

    @FXML
    private AnchorPane registerViewPane;

    @FXML
    private JFXTextField userName_txf;

    @FXML
    private ImageView uploadImage;

    @FXML
    private Button btn_browse;

    @FXML
    private Label errorName;

    @FXML
    private JFXTextField userEmail_txf;

    @FXML
    private JFXTextField userNrcNo_txf;

    @FXML
    private Label errorEmail;

    @FXML
    private Label errorNRC;

    @FXML
    private JFXTextField userPhone_txf;

    @FXML
    private JFXTextField userCity_txf;

    @FXML
    private Label errorPhone;

    @FXML
    private Label errorCity;

    @FXML
    private JFXPasswordField userPassword_txf;

    @FXML
    private JFXPasswordField userCon_Pwd_txf;

    @FXML
    private Label errorPassword;

    @FXML
    private RadioButton radioMale;

    @FXML
    private RadioButton radioFemale;

    @FXML
    private Label errorGender;

    @FXML
    private JFXButton btn_add;

    @FXML
    private JFXButton btn_update;

    @FXML
    private JFXButton btn_delete;

    @FXML
    private TableColumn<?, ?> col_id;

    @FXML
    private TableColumn<?, ?> col_name;

    @FXML
    private TableColumn<?, ?> col_image;

    @FXML
    private TableColumn<?, ?> col_email;

    @FXML
    private TableColumn<?, ?> col_nrcNo;

    @FXML
    private TableColumn<?, ?> col_phone;

    @FXML
    private TableColumn<?, ?> col_city;

    @FXML
    private TableColumn<?, ?> col_password;

    @FXML
    private TableColumn<?, ?> col_gender;

    @FXML
    private BorderPane hbox;

    @FXML
    private HBox hbox_search;

    @FXML
    private JFXTextField txf_search;

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

    }
    private void binding(){


    }

    private  void  actions(){
        btn_add.setOnAction(e->{
            if(e.getEventType().equals(MouseButton.PRIMARY)){
                new Alert(Alert.AlertType.CONFIRMATION).show();
                AdminDashboardController adminDashboardController=new AdminDashboardController();
                Parent parent= ___Bundle.__ViewLoader._getInstance()._load("adminDashboard",adminDashboardController);
                Stage stage=new Stage();
                stage.setScene(new Scene(parent));
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setTitle("Go Go Application");
                stage.getIcons().add(new Image("images/app_logo.jpg"));
                // stage.centerOnScreen();
                stage.show();
            }
        });

    }
}
