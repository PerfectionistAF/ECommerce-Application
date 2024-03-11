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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nasef
 */
public class AdminDashboardController implements Initializable {
        Stage stage;
    Parent root;
    Scene scene;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
        @FXML
    public void addRest(ActionEvent e) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("addRestaurant.fxml"));
        root = loader.load();
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
           
    
    }
    
            @FXML
    public void delRest(ActionEvent e) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("deleteRestaurant.fxml"));
        root = loader.load();
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
           
    
    }
    
            @FXML
    public void addMeal(ActionEvent e) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("addMeal.fxml"));
        root = loader.load();
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
           
    
    }
    
            @FXML
    public void delMeal(ActionEvent e) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("deleteMeal.fxml"));
        root = loader.load();
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
           
    
    }
    
    
}
