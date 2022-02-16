package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminAirLineController implements Initializable {

    @FXML
    private AnchorPane airLinePane;

    @FXML
    private HBox search_hbox;

    @FXML
    private JFXTextField searchData_txf;

    @FXML
    private DatePicker searchDate;

    @FXML
    private ComboBox<?> combo_airName;

    @FXML
    private Label label_airName;

    @FXML
    private JFXDatePicker airDate;

    @FXML
    private Label errorAirName;

    @FXML
    private Label errorDate;

    @FXML
    private ComboBox<?> combo_airFrom;

    @FXML
    private Label label_airFrom;

    @FXML
    private ComboBox<?> combo_airTo;

    @FXML
    private Label label_airTo;

    @FXML
    private Label errorBusFrom;

    @FXML
    private Label errorBusTo;

    @FXML
    private JFXTimePicker departureTime;

    @FXML
    private JFXTimePicker arrivalTime;

    @FXML
    private Label errorDepartureTime;

    @FXML
    private Label errorArrivalTime;

    @FXML
    private HBox busSeatCol;

    @FXML
    private ComboBox<?> combo_seatCol;

    @FXML
    private Label label_seatCol;

    @FXML
    private ComboBox<?> combo_seatQty;

    @FXML
    private Label label_seatQty;

    @FXML
    private Label errorColumn;

    @FXML
    private Label errorQty;

    @FXML
    private JFXTextField airPrice_txf;

    @FXML
    private ComboBox<?> combo_airClass;

    @FXML
    private Label errorPrice;

    @FXML
    private Label errorAirClass;

    @FXML
    private JFXButton btn_add;

    @FXML
    private JFXButton btn_update;

    @FXML
    private JFXButton btn_delete;

    @FXML
    private TableColumn<?, ?> col_airID;

    @FXML
    private TableColumn<?, ?> col_airName;

    @FXML
    private TableColumn<?, ?> col_from;

    @FXML
    private TableColumn<?, ?> col_to;

    @FXML
    private TableColumn<?, ?> col_date;

    @FXML
    private TableColumn<?, ?> col_departureTime;

    @FXML
    private TableColumn<?, ?> col_arrivalTime;

    @FXML
    private TableColumn<?, ?> col_seatCol;

    @FXML
    private TableColumn<?, ?> col_seatQty;

    @FXML
    private TableColumn<?, ?> col_price;

    @FXML
    private TableColumn<?, ?> col_airClass;

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

    }
}
