package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import database.AdminRegister_DB;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.util.Callback;
import models.AdminRegister;

import java.io.ByteArrayInputStream;
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
    private TableView<AdminRegister> tableView;

    @FXML
    private TableColumn<AdminRegister, Integer> col_id = new TableColumn<AdminRegister,Integer>("ID");

    @FXML
    private TableColumn<AdminRegister, String> col_name=new TableColumn<AdminRegister,String>("Name");

    @FXML
    private TableColumn<AdminRegister, byte[]> col_image=new TableColumn<AdminRegister,byte[]>("Image");

    @FXML
    private TableColumn<AdminRegister, String> col_email=new TableColumn<AdminRegister,String>("Email");

    @FXML
    private TableColumn<AdminRegister, String> col_nrcNo=new TableColumn<AdminRegister,String>("NRC No");

    @FXML
    private TableColumn<AdminRegister, String> col_phone=new TableColumn<AdminRegister,String>("Phone No");

    @FXML
    private TableColumn<AdminRegister, String> col_city=new TableColumn<AdminRegister,String>("City");

    @FXML
    private TableColumn<AdminRegister, String> col_password=new TableColumn<AdminRegister,String>("Password");

    @FXML
    private TableColumn<AdminRegister, String> col_gender=new TableColumn<AdminRegister,String>("Gender");

    @FXML
    private HBox hbox_search;

    @FXML
    private JFXTextField txf_search;

   ArrayList<AdminRegister> rgArrayList = (ArrayList<AdminRegister>) AdminRegister_DB.getRegisterLists();
    ObservableList<AdminRegister> oblist = FXCollections.observableArrayList(rgArrayList);

    AdminRegister index;
    int delete_index;

    String filepath = null;
    FileChooser filechooser = new FileChooser();

    ToggleGroup group=new ToggleGroup();

    public void search(String text) {
        System.out.println(text);

        ObservableList<AdminRegister> registers = FXCollections.observableArrayList(rgArrayList);

        registers = registers.filtered(rg -> {

            return rg.getRg_name().toLowerCase().contains(text) ||
                    String.valueOf(rg.getRg_id()).contains(text) ||
                    rg.getRg_city().toLowerCase().contains(text);

        });

        tableView.setItems(registers);
        tableView.refresh();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.init();
    }

    private void init(){
        prepare();
        binding();
        actions();
    }

    public void inserttoTable() {
        ArrayList<AdminRegister> registers = (ArrayList<AdminRegister>) AdminRegister_DB.getRegisterLists();
        ObservableList<AdminRegister> rgList = FXCollections.observableArrayList(registers);
        tableView.setItems(rgList);

    }

    private void prepare(){
        radioMale.setToggleGroup(group);
        radioFemale.setToggleGroup(group);

        radioMale.setUserData("Male");
        radioFemale.setUserData("Female");


        col_id.setCellValueFactory(new PropertyValueFactory<AdminRegister, Integer>("rg_id"));
        col_name.setCellValueFactory(new PropertyValueFactory<AdminRegister, String>("rg_name"));
        col_image.setCellFactory(new Callback<TableColumn<AdminRegister, byte[]>, TableCell<AdminRegister, byte[]>>() {
            @Override
            public TableCell<AdminRegister, byte[]> call(TableColumn<AdminRegister, byte[]> param) {
                ImageView imageView=new ImageView();
                TableCell<AdminRegister,byte[]> cell=new TableCell<AdminRegister,byte[]>(){
                    public void data(byte[] item,boolean empty){
                        if(item!=null){
                            Image img=new Image(new ByteArrayInputStream(item));
                            imageView.setImage(img);
                            imageView.setFitWidth(130);
                            imageView.setFitHeight(100);
                        }
                    }
                };
                cell.setGraphic(imageView);
                return cell;

            }
        });
        col_image.setCellValueFactory(new PropertyValueFactory<AdminRegister, byte[]>("rg_image"));
        col_email.setCellValueFactory(new PropertyValueFactory<AdminRegister,String>("rg_email"));
        col_nrcNo.setCellValueFactory(new PropertyValueFactory<AdminRegister, String>("rg_nrc"));
        col_phone.setCellValueFactory(new PropertyValueFactory<AdminRegister, String>("rg_phoneNo"));
        col_city.setCellValueFactory(new PropertyValueFactory<AdminRegister, String>("rg_city"));
        col_password.setCellValueFactory(new PropertyValueFactory<AdminRegister, String>("rg_password"));
        col_gender.setCellValueFactory(new PropertyValueFactory<AdminRegister,String>("rg_gender"));


        tableView.setItems(oblist);

        inserttoTable();
    }
    private void binding(){


    }

    private  void  actions(){

        //gender
        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                if (group.getSelectedToggle() != null) {
                    getClass().getResource(
                            group.getSelectedToggle().getUserData().toString()
                    );
                }
            }

        });

        //search
        txf_search.textProperty().addListener((observable, oldValue, newValue) -> {

            if (newValue != null && !newValue.isEmpty()) {

                String text = txf_search.getText().trim().toLowerCase();

                search(text);

            } else {
                search("");
            }
        });

        //filechooser
        btn_browse.setOnAction(e->{
            File file = filechooser.showOpenDialog(null);
            uploadImage.setImage(new Image(file.toURI().toString()));
        });


        //add
        btn_add.setOnAction(e->{

        });

        //update
        btn_update.setOnAction(e->{

        });

        //delete
        btn_delete.setOnAction(e->{
            tableView.getItems().clear();
            AdminRegister_DB.delete_Register(delete_index);
     //       inserttoTable();
            userName_txf.clear();
            userEmail_txf.clear();
            userNrcNo_txf.clear();
            userPhone_txf.clear();
            userCity_txf.clear();
            userPassword_txf.clear();
            userCon_Pwd_txf.clear();
            filepath = null;
            uploadImage.setImage(new Image("file:///D:\\Jetbrain Projects\\TicketManagementSystem_V2\\src\\images\\user.png"));

            tableView.refresh();
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
