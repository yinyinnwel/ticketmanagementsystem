package controllers;

import com.jfoenix.controls.JFXButton;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import product_out.___Bundle;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminDashboardController implements Initializable {

    @FXML
    private AnchorPane adminDashboardPane;

    @FXML
    private StackPane stackPane;

    @FXML
    private ImageView menuList;

    @FXML
    private ImageView menuClose;

    @FXML
    private VBox slider;

    @FXML
    private HBox adminPhoto;

    @FXML
    private JFXButton btn_admin;

    @FXML
    private JFXButton btn_seller;

    @FXML
    private JFXButton btn_busLine;

    @FXML
    private JFXButton btn_airLine;

    @FXML
    private JFXButton btn_logout;

    @FXML
    private AnchorPane replaceAnchorPane;

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
//        slider.setTranslateX(-200);
        menuList.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider);
            slide.setCycleCount(1);
            slide.setAutoReverse(false);

            slide.setToX(0);
            slide.play();

            slider.setTranslateX(-200);

            slide.setOnFinished((ActionEvent e)-> {
                menuList.setVisible(false);
                menuClose.setVisible(true);
            });
        });

        menuClose.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider);
            slide.setCycleCount(1);
            slide.setAutoReverse(false);

            slide.setToX(-200);
            slide.play();

            slider.setTranslateX(0);

            slide.setOnFinished((ActionEvent e)-> {
                menuList.setVisible(true);
                menuClose.setVisible(false);
            });
        });

      //-----------------------

        btn_admin.setOnAction(e->{
            AdminRegisterViewController adminRegisterViewController=new AdminRegisterViewController();
            Parent parent= ___Bundle.__ViewLoader._getInstance()._load("adminRegisterView",adminRegisterViewController);
            AnchorPane.setTopAnchor(parent,0.0);
            AnchorPane.setRightAnchor(parent,0.0);
            AnchorPane.setBottomAnchor(parent,0.0);
            AnchorPane.setLeftAnchor(parent,0.0);
            replaceAnchorPane.getChildren().add(parent);

        });

        btn_seller.setOnAction(e->{
            SellerRegisterViewController sellerRegisterViewController=new SellerRegisterViewController();
            Parent parent= ___Bundle.__ViewLoader._getInstance()._load("sellerRegisterView",sellerRegisterViewController);
            AnchorPane.setTopAnchor(parent,0.0);
            AnchorPane.setRightAnchor(parent,0.0);
            AnchorPane.setBottomAnchor(parent,0.0);
            AnchorPane.setLeftAnchor(parent,0.0);
            replaceAnchorPane.getChildren().add(parent);

        });

        btn_busLine.setOnAction(e->{
            AdminBusLineController adminBusLineController=new AdminBusLineController();
            Parent parent= ___Bundle.__ViewLoader._getInstance()._load("adminBusLine",adminBusLineController);
            AnchorPane.setTopAnchor(parent,0.0);
            AnchorPane.setRightAnchor(parent,0.0);
            AnchorPane.setBottomAnchor(parent,0.0);
            AnchorPane.setLeftAnchor(parent,0.0);
            replaceAnchorPane.getChildren().add(parent);

        });

        btn_airLine.setOnAction(e->{
            AdminAirLineController adminAirLineController=new AdminAirLineController();
            Parent parent= ___Bundle.__ViewLoader._getInstance()._load("adminAirLine",adminAirLineController);
            AnchorPane.setTopAnchor(parent,0.0);
            AnchorPane.setRightAnchor(parent,0.0);
            AnchorPane.setBottomAnchor(parent,0.0);
            AnchorPane.setLeftAnchor(parent,0.0);
            replaceAnchorPane.getChildren().add(parent);

        });

        btn_logout.setOnMouseClicked(e->{
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Are you sure that you wanna to logout?", ButtonType.YES,ButtonType.NO);
            alert.showAndWait();
            if(alert.getResult().equals(ButtonType.YES)) {
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
                Stage currentStage= (Stage) adminDashboardPane.getScene().getWindow();
                currentStage.close();
            }
        });
    }
}
