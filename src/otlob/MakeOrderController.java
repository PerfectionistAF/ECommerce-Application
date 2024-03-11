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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nasef
 */
public class MakeOrderController implements Initializable {
    Stage stage;
    Parent root;
    Scene scene;
    Admin admin;
     ObservableList<Double>prices;
    private int restaurant_index_selected;
    private int meal_index_selected;
    private double meal_price_selected;
      @FXML
    private ComboBox restaurant_name;
    @FXML
    private ComboBox meal_name;
    @FXML
    private TextField quantity;
    @FXML
    private TextField creditcard;
    @FXML
    private TextField cvve;
    @FXML
    private TextField address;
    @FXML
    private CheckBox visa;
    @FXML
    private Button submit;
    @FXML
    private Label restaurantValue;
    @FXML
    private Label mealValue;
    @FXML
    private Label quantityValue;
        @FXML
    private Label creditcardlabel;
            @FXML
    private Label cvvelabel;
                @FXML
    private Label addresslabel;
                @FXML
    private Label totallabel;                
                @FXML
    private Label total;
   
    @FXML
    private Label title;
    /**
     * Initializes the controller class.
     */
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
    public void onHome(ActionEvent e) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("landingPage.fxml"));
        root = loader.load();
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
           
    
    }
    
        @FXML
    public void onAdd(ActionEvent e){
      admin = new Admin();
      
      this.restaurant_name.setVisible(false);
      this.meal_name.setVisible(false);   
      this.quantity.setVisible(false);    
      this.creditcard.setVisible(false);    
      this.cvve.setVisible(false);
      this.address.setVisible(false);   
      this.visa.setVisible(false);   
      this.title.setText("Invoice");
      this.restaurantValue.setVisible(true);
      this.restaurantValue.setText(this.restaurant_name.getValue().toString());
      this.mealValue.setVisible(true);  
      this.mealValue.setText(this.meal_name.getValue().toString());
      this.quantityValue.setVisible(true);  
      this.quantityValue.setText(this.quantity.getText());
      this.creditcardlabel.setVisible(false);   
      this.cvvelabel.setVisible(false);    
      this.addresslabel.setVisible(false);       
      this.totallabel.setVisible(true);    
      this.total.setVisible(true);
      this.total.setText(""+meal_price_selected*Integer.parseInt(this.quantityValue.getText()));
      
      
    }
        @FXML
    public void restaurantChange(ActionEvent e) throws IOException{
           restaurant_index_selected=restaurant_name.getSelectionModel().getSelectedIndex()+1;
           
        ObservableList<String>  meals = FXCollections.observableArrayList();
        prices= FXCollections.observableArrayList();
        for(int i=0;i<admin.getMeals(restaurant_index_selected).size();i++){
            meals.add(admin.getMeals(restaurant_index_selected).get(i).meal_name);
            prices.add(admin.getMeals(restaurant_index_selected).get(i).meal_price);
        }
        meal_name.setItems(meals); 
    }
    
    public void mealChange(ActionEvent e) throws IOException{
        meal_price_selected=prices.get(meal_name.getSelectionModel().getSelectedIndex());

    }
    
}
