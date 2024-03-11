/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otlob;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nasef
 */
public class AddMealController implements Initializable {
    Admin admin;
    private int restaurant_index_selected;
    private int meal_index_selected;
        Stage stage;
    Parent root;
    Scene scene;
    
    @FXML
    private ComboBox restaurant_name;
    @FXML
    private TextField meal_name;
    @FXML
    private TextField quantity;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        admin = new Admin();
        ObservableList<String>  restaurants = FXCollections.observableArrayList();
        for(int i=0;i<admin.getRestaurants().size();i++){
            restaurants.add(admin.getRestaurants().get(i).restaurant_name);
        }
        restaurant_name.setItems(restaurants);
        



    }    
    
    
    @FXML
    public void onAdd(ActionEvent e) throws IOException{
      admin = new Admin();
      admin.addMeal(meal_name.getText(),restaurant_index_selected,Integer.parseInt(quantity.getText()));
            FXMLLoader loader = new FXMLLoader(getClass().getResource("adminDashboard.fxml"));
        root = loader.load();
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
           
          

    }
    
    @FXML
    public void restaurantChange(ActionEvent e) throws IOException{
           restaurant_index_selected=restaurant_name.getSelectionModel().getSelectedIndex()+1;

    
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
