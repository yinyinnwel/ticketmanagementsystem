package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import database.AdminRegister_DB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.AdminRegister;
import product_out.___Bundle;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AdminRegisterViewController implements Initializable {

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
    private BorderPane hbox;

    @FXML
    private TableColumn<AdminRegister, Integer> col_id = new TableColumn<AdminRegister,Integer>("ID");

    @FXML
    private TableColumn<AdminRegister, String> col_name=new TableColumn<AdminRegister,String>("Name");

    @FXML
    private TableColumn<AdminRegister, ?> col_image=new TableColumn<AdminRegister,String>("Image");

    @FXML
    private TableColumn<AdminRegister, ?> col_email=new TableColumn<AdminRegister,String>("Email");

    @FXML
    private TableColumn<AdminRegister, ?> col_nrcNo=new TableColumn<AdminRegister,String>("NRC No");

    @FXML
    private TableColumn<AdminRegister, ?> col_phone=new TableColumn<AdminRegister,String>("Phone No");

    @FXML
    private TableColumn<AdminRegister, ?> col_city=new TableColumn<AdminRegister,String>("City");

    @FXML
    private TableColumn<AdminRegister, ?> col_password=new TableColumn<AdminRegister,String>("Password");

    @FXML
    private TableColumn<AdminRegister, ?> col_gender=new TableColumn<AdminRegister,String>("Gender");

    @FXML
    private HBox hbox_search;

    @FXML
    private JFXTextField txf_search;

 //   ArrayList<AdminRegister> rgArrayList = (ArrayList<AdminRegister>) AdminRegister_DB.getRegisterLists();
  //  ObservableList<AdminRegister> oblist = FXCollections.observableArrayList(rgArrayList);

    String filepath = null;
    FileChooser filechooser = new FileChooser();

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
        btn_browse.setOnAction(e->{
            File file = filechooser.showOpenDialog(null);
            uploadImage.setImage(new Image(file.toURI().toString()));
        });

        btn_add.setOnAction(e->{
            System.out.println("hello");
        });

    }
}

//if(e.getEventType().equals(MouseButton.PRIMARY)){
//        System.out.println("hello");
//        new Alert(Alert.AlertType.CONFIRMATION).show();
//        AdminDashboardController adminDashboardController=new AdminDashboardController();
//        Parent parent= ___Bundle.__ViewLoader._getInstance()._load("adminDashboard",adminDashboardController);
//        Stage stage=new Stage();
//        stage.setScene(new Scene(parent));
//        stage.initModality(Modality.APPLICATION_MODAL);
//        stage.setTitle("Go Go Application");
//        stage.getIcons().add(new Image("images/app_logo.jpg"));
//        // stage.centerOnScreen();
//        stage.show();
//        }
