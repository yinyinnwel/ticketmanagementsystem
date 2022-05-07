package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import com.kitfox.svg.A;
import database.AdminRegister_DB;
import javafx.animation.ScaleTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import models.AdminRegister;
import product_out.___Bundle;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.function.IntFunction;
import java.util.stream.IntStream;

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
    private JFXRadioButton radioMale;

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

    byte[] imgByte;
  //  String filepath = null;
    FileChooser filechooser = new FileChooser();
    ArrayList<AdminRegister> registerArrayList;

    String radioGender;

    ToggleGroup group=new ToggleGroup();


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


        radioMale.setToggleGroup(group);
        radioFemale.setToggleGroup(group);

        radioMale.setUserData("Male");
        radioFemale.setUserData("Female");

//        if(radioMale.isSelected()){
//            radioGender = "Male";
//        }else {
//            radioGender = "Female";
//        }




    }

    private  boolean checkNRC(){
        boolean flag = false;
        if(userNRC_txf.getText()!=null && !userNRC_txf.getText().isEmpty()){

            if(userNRC_txf.getText().trim().split("N\\)")[1].length() == 6){
                errorNRC.setText(null);
                flag= true;
            }else{
                errorNRC.setText("Format is Wrong!");
                flag= false;

            }
        }
        return  flag;
    }

    private boolean checkPhoneNo(){
        boolean flag=false;
        if(userPhone_txf.getText()!=null && !userPhone_txf.getText().isEmpty()){

            if(userPhone_txf.getText().length()==11 && userPhone_txf.getText().startsWith("09")){
                errorPhone.setText(null);
                flag=true;
            }else {
                errorPhone.setText("Start 09 and number length is 11");
                flag=false;

            }
        }

        return flag;
    }

    public byte[] imgByte(String imgPath) throws IOException {
        imgByte =imgByte(imgPath);
        File file = new File(imgPath);
        BufferedImage bufferedImage = ImageIO.read(file);

        WritableRaster writableRaster = bufferedImage.getRaster();
        DataBufferByte dataBufferByte = (DataBufferByte)writableRaster.getDataBuffer();

        return dataBufferByte.getData();

    }

    private void binding(){

    }


    private void actions(){

//        radioMale.selectedProperty().addListener((o1,o2,newValue)->{
////            if(newValue){
//                radioFemale.selectedProperty().set(!newValue);
//        //    }
//        });
//        radioFemale.selectedProperty().addListener((o1,o2,newValue)->{
////            if(newValue){
//                radioMale.selectedProperty().set(!newValue);
//        //    }
//        });

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
            restrictTextFields(userPhone_txf,newValue);
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

        userPassword_txf.textProperty().addListener((o1,o2,newValue)->{
            userCon_Pwd_txf.setDisable(newValue.isEmpty());
            if(newValue.isEmpty()){
                errorPwd.setText("Your Password is required!");
            }else {
                if(!userCon_Pwd_txf.getText().trim().equals(newValue.trim())){
                    errorPwd.setText("Password is do not match!");
                }else{
                    errorPwd.setText(null);
                }

            }
        });

        userCon_Pwd_txf.textProperty().addListener((o1,o2,newValue)->{
            if(newValue.isEmpty()){
                errorPwd.setText("Your Confirm Password is required!");
            }else {
                if(!userPassword_txf.getText().trim().equals(newValue.trim())){
                    errorPwd.setText("Password is do not match!");
                }else{
                    errorPwd.setText(null);
                }

            }
        });



        btn_browse.setOnAction(e->{
            File file = filechooser.showOpenDialog(null);
            imageView.setImage(new Image(file.toURI().toString()));
            try {
                imgByte = imgByte(file.toURI().toString());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
          //  System.out.println(imgByte.toString());
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




        btnRegister.setOnAction(e-> {
                    TextField[] fields = {userName_txf, userEmail_txf, userNRC_txf, userPhone_txf, userCity_txf,
                            userPassword_txf, userCon_Pwd_txf};

               //     System.out.println(checkTextfield_Empty(fields));

            System.out.println(checkNRC());
            System.out.println(checkPhoneNo());

            if(!checkTextfield_Empty(fields)){
                if(checkNRC() && checkPhoneNo() ){
                    AdminRegister adminRegister = new AdminRegister(0, userName_txf.getText().toLowerCase(),
                            IntStream.range(0,imgByte.length).mapToObj(i->imgByte[i]).toArray(Byte[]::new),
                                userEmail_txf.getText(), userNRC_txf.getText(), userPhone_txf.getText(), userCity_txf.getText().toLowerCase(),
                                userPassword_txf.getText(), group.getSelectedToggle().getUserData().toString());
                    System.out.println(adminRegister);
                    AdminRegister_DB.addRegister(adminRegister);

                    showAlert();


                }
            }else{
                new Alert(Alert.AlertType.ERROR,"Fill all Data!").show();
               // showAlert().setContentText("fill all data!");
            }


//
//            System.out.println(userPassword_txf.getText().equals(userCon_Pwd_txf.getText()));
//            if (userPassword_txf.getText().equals(userCon_Pwd_txf.getText())) {
//
//
//                if (userNRC_txf.getText().split("N\\)")[1].length() >= 6) {
//
//                    AdminRegister adminRegister = new AdminRegister(0, userName_txf.getText().toLowerCase(), filepath,
//                            userEmail_txf.getText(), userNRC_txf.getText(), userPhone_txf.getText(), userCity_txf.getText().toLowerCase(),
//                            userPassword_txf.getText(), group.getSelectedToggle().getUserData().toString());
//                    System.out.println(adminRegister);
//                    AdminRegister_DB.addRegister(adminRegister);
//                }
//            }





//            AdminLoginController adminLoginController=new AdminLoginController();
//            Parent parent= ___Bundle.__ViewLoader._getInstance()._load("adminLogin",adminLoginController);
//            Stage stage=new Stage();
//            stage.setScene(new Scene(parent));
//            stage.initModality(Modality.WINDOW_MODAL);
//            stage.setTitle("Go Go Application");
//            stage.getIcons().add(new Image("images/app_logo.jpg"));
//            stage.centerOnScreen();
//            stage.setResizable(false);
//            stage.show();
//            Stage currentStage= (Stage) registerPane.getScene().getWindow();
//            currentStage.close();

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
            flag = field.getText().isEmpty();
        }
        return flag;
    }

    private void showAlert(){
        Alert alert=new Alert(Alert.AlertType.INFORMATION,"SuccessFul Data!");
        alert.show();
        Service service=new Service() {
            @Override
            protected Task createTask() {
                return new Task() {
                    @Override
                    protected Object call() throws Exception {
                        Thread.sleep(3000);
                        return null;
                    }
                };
            }
        };
        service.restart();
        service.setOnSucceeded(event->{
            alert.close();

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

    private void restrictTextFields(TextField textField, String value) {
        if (!value.matches("\\d*")) {
            textField.setText(value.replaceAll("[^\\d]", ""));
        }
        textField.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.SPACE) {
                    event.consume(); // to cancel space key
                }
            }
        });

    }
}
