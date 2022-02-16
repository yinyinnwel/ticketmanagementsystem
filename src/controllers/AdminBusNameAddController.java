package controllers;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class AdminBusNameAddController implements Initializable {

    @FXML
    private VBox vbox_busName;

    @FXML
    private JFXTextField txf_busName;

    @FXML
    private HBox hbox;

    @FXML
    private Button btn_add;

    @FXML
    private Button btn_delete;

    @FXML
    private Button btn_clear;


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
            System.out.println("hello");
        });

    }
}
