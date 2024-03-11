/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otlob;

/**
 *
 * @author Nasef
 */
public class Meal {
    int resturant_id;
    String meal_name;
    double meal_price;

    public Meal(int resturant_id, String meal_name, double meal_price) {
        this.resturant_id = resturant_id;
        this.meal_name = meal_name;
        this.meal_price = meal_price;
    }

    public int getResturant_id() {
        return resturant_id;
    }

    public void setResturant_id(int resturant_id) {
        this.resturant_id = resturant_id;
    }

    public String getMeal_name() {
        return meal_name;
    }

    public void setMeal_name(String meal_name) {
        this.meal_name = meal_name;
    }

    public double getMeal_price() {
        return meal_price;
    }

    public void setMeal_price(double meal_price) {
        this.meal_price = meal_price;
    }
    
}
