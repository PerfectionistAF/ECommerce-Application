/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otlob;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nasef
 */
public class CustomerLoginController implements Initializable {
        Stage stage;
    Parent root;
    Scene scene;

    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private Label errorCode;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onAdd(ActionEvent event) throws IOException {
        Customer customer = new Customer();
        if(customer.customerLogin(username.getText(), password.getText())){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("makeOrder.fxml"));
        root = loader.load();
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
        }else{
            errorCode.setVisible(true);
        }
    }
    
            @FXML
    public void onHome(ActionEvent e) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("landingPage.fxml"));
        root = loader.load();
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
           
    
    }
    
}
