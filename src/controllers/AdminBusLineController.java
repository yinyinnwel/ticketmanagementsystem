package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import product_out.___Bundle;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminBusLineController implements Initializable {

    @FXML
    private AnchorPane busLinePane;

    @FXML
    private HBox search_hbox;

    @FXML
    private JFXTextField searchData_txf;

    @FXML
    private DatePicker searchDate;

    @FXML
    private ComboBox<?> combo_busName;

    @FXML
    private Label label_busNameAdd;

    @FXML
    private ComboBox<?> combo_busNo;

    @FXML
    private Label label_busNoAdd;

    @FXML
    private Label errorBusName;

    @FXML
    private Label errorBusNo;

    @FXML
    private ComboBox<?> combo_busFrom;

    @FXML
    private Label label_busFromAdd;

    @FXML
    private ComboBox<?> combo_busTo;

    @FXML
    private Label label_busToAdd;

    @FXML
    private Label errorBusFrom;

    @FXML
    private Label errorBusTo;

    @FXML
    private JFXDatePicker busDate;

    @FXML
    private JFXTimePicker busTime;

    @FXML
    private Label errorDate;

    @FXML
    private Label errorTime;

    @FXML
    private HBox busSeatCol;

    @FXML
    private ComboBox<?> combo_seatCol;

    @FXML
    private Label label_seatColAdd;

    @FXML
    private ComboBox<?> combo_seatQty;

    @FXML
    private Label label_seatQtyAdd;

    @FXML
    private Label errorColumn;

    @FXML
    private Label errorQty;

    @FXML
    private JFXTextField busPrice_txf;

    @FXML
    private Label errorPrice;

    @FXML
    private JFXButton btn_add;

    @FXML
    private JFXButton btn_update;

    @FXML
    private JFXButton btn_delete;

    @FXML
    private TableColumn<?, ?> col_busID;

    @FXML
    private TableColumn<?, ?> col_busName;

    @FXML
    private TableColumn<?, ?> col_busNo;

    @FXML
    private TableColumn<?, ?> col_from;

    @FXML
    private TableColumn<?, ?> col_to;

    @FXML
    private TableColumn<?, ?> col_date;

    @FXML
    private TableColumn<?, ?> col_time;

    @FXML
    private TableColumn<?, ?> col_seatCol;

    @FXML
    private TableColumn<?, ?> col_seatQty;

    @FXML
    private TableColumn<?, ?> col_price;


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
        label_busNameAdd.setOnMouseClicked(e->{
            AdminBusNameAddController adminBusNameAddController=new AdminBusNameAddController();
            Parent parent = ___Bundle.__ViewLoader._getInstance()._load("adminBusNameAdd",adminBusNameAddController);
            Stage stage=new Stage();
            stage.setScene(new Scene(parent));
            stage.setTitle("Go Go Application");
            stage.getIcons().add(new Image("images/app_logo.jpg"));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.centerOnScreen();
            stage.show();
        });
    }
}
