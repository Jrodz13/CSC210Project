package org.example.chapter12;
import javafx.scene.control.PasswordField;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.Scene;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.VBox;
//import javafx.geometry.Pos;
//import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
/*
Team members: Johnnay Rodriguez and Ralphy Gomez
Course Computer Programming II CSC 210 0900[33327]
Short description of the project: The project is about a Pizza store where users could sign in with a username and a password. After signing in with a specific username and password the user is prompted with the pizza store menu where they can enter the pizza type that they want and the quantity of pizzas. After typing the pizza type, the quantity the user can click a button to calculate the price of the pizzas including the total price, tax, and price before tax.
Date: 05/14/2024
Project version 1 (Pizza store).
 */
public class Pizzafx extends Application
{
    // text Fields and labels
    private TextField usernameTextField;
    private TextField passwdPasswordField;
    private Label resultLabel;
    private TextField QuantityText;
    private TextField PizzanumberText;
    private Label totalCostLabel;
    private Label taxLabel;
    private Label beforeTaxLabel;

    public static void main(String[] args)
    {
        // Launch the application.
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        // Create a username and password Label
        Label usernameLabel = new Label("Username:");
        usernameLabel.setTextFill(Color.BLACK);
        usernameLabel.setFont(Font.font("Arial",FontWeight.BOLD,12));

        Label passwordLabel = new Label("Password:");
        passwordLabel.setTextFill(Color.BLACK);
        passwordLabel.setFont(Font.font("Arial",FontWeight.BOLD,12));

        // Create a TextField for username input.
        usernameTextField = new TextField();
        //Created a password field so the password cant be seen
        passwdPasswordField = new PasswordField();

        // Create a Button to login.
        Button loginButton = new Button("Login");
        loginButton.setTextFill(Color.BLUE);
        loginButton.setFont(Font.font("Arial",FontWeight.BOLD,12));

        // Register the event handler.
        loginButton.setOnAction(new LoginButtonHandler());

        // Create an empty Label to display the result.
        resultLabel = new Label();

        //Create a gridpane
        GridPane gridpane = new GridPane();
        gridpane.setHgap(10);
        gridpane.setVgap(10);
        gridpane.setPadding(new Insets(23));

        //Add the labels and button to the gridpane
        gridpane.add(usernameLabel,0,0);
        gridpane.add(usernameTextField,1,0);
        gridpane.add(passwordLabel,0,1);
        gridpane.add(passwdPasswordField,1,1);
        gridpane.add(loginButton,1,2);
        gridpane.add(resultLabel,1,3);

        //Create a new scene
        Scene scene = new Scene(gridpane);

        // Add the Scene to the Stage.
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login");
        primaryStage.show();
    }
    //Login button handler
    class LoginButtonHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event)
        {
            //Get the user and password from the PizzaStore class
            String user = PizzaStore.getUsername();
            String passwd = PizzaStore.getPasswd();
            String enteredPassword = passwdPasswordField.getText();

            //If the login is correct it would switch to the menu scene
            if (usernameTextField.getText().equals(user) && enteredPassword.equals(passwd)) {
                resultLabel.setText("Success");
                resultLabel.setTextFill(Color.GREEN);
                resultLabel.setFont(Font.font("Arial",FontWeight.BOLD,12));

                switchToSecondScene();

                Stage loginStage = (Stage) usernameTextField.getScene().getWindow();
                loginStage.close();
            }
            else {//If not successful say invalid login
                resultLabel.setText("Invalid Login");
                resultLabel.setTextFill(Color.RED);
                resultLabel.setFont(Font.font("Arial",FontWeight.BOLD,12));
            }
        }
    }
    //Menu scene
    private void switchToSecondScene() {
        //Labels
        totalCostLabel = new Label();
        totalCostLabel.setTextFill(Color.RED);
        totalCostLabel.setFont(Font.font("Arial",FontWeight.BOLD,12));
        taxLabel = new Label();
        taxLabel.setTextFill(Color.GREEN);
        taxLabel.setFont(Font.font("Arial",FontWeight.BOLD,12));
        beforeTaxLabel = new Label();
        beforeTaxLabel.setTextFill(Color.DARKBLUE);
        beforeTaxLabel.setFont(Font.font("Arial",FontWeight.BOLD,12));
        Label pizza = new Label("Pizza Type");
        pizza.setTextFill(Color.BLACK);
        pizza.setFont(Font.font("Arial",FontWeight.BOLD,12));
        Label regPizza = new Label("Regular");
        Label pepperoniPizza = new Label("Pepperoni");
        Label chickenPizza = new Label("Chicken");
        Label cheesePizza = new Label("Cheese");
        Label cost = new Label("Price");
        cost.setTextFill(Color.BLACK);
        cost.setFont(Font.font("Arial",FontWeight.BOLD,12));
        Label regPizzaPrice = new Label("$25");
        Label pepperoniPizzaPrice = new Label("$29");
        Label chickenPizzaPrice = new Label("$23");
        Label cheesePizzaPrice = new Label("$20");
        Label pizzaType = new Label("Enter pizza type");
        pizzaType.setTextFill(Color.BLACK);
        pizzaType.setFont(Font.font("Arial",FontWeight.BOLD,12));
        Label quantity = new Label("Enter quantity");
        quantity.setTextFill(Color.BLACK);
        quantity.setFont(Font.font("Arial",FontWeight.BOLD,12));

        //Text fields
        PizzanumberText = new TextField(); // Initialize the class field directly
        QuantityText = new TextField(); // Initialize the class field directly
        Pizzafx.this.PizzanumberText = new TextField();
        Pizzafx.this.QuantityText = new TextField();

        // Create a Button to perform the price calculation.
        Button calculatePrice = new Button("Calculate Price");
        calculatePrice.setTextFill(Color.BLUE);
        calculatePrice.setFont(Font.font("Arial",FontWeight.BOLD,12));

        // Register the event handler.
        calculatePrice.setOnAction(new CalculatePriceButtonHandler());
        calculatePrice.setTextFill(Color.GREEN);

        //Created a stage
        Stage secondStage = new Stage();

        //Create the grid pane for the pizza menu
        GridPane gridpane1 = new GridPane();
        gridpane1.setHgap(7);
        gridpane1.setVgap(7);
        gridpane1.setPadding(new Insets(35));

        //Add all the labels, button and text fields to the gridpane
        gridpane1.add(pizza,0,0);
        gridpane1.add(regPizza,0,1);
        gridpane1.add(pepperoniPizza,0,2);
        gridpane1.add(chickenPizza,0,3);
        gridpane1.add(cheesePizza,0,4);
        gridpane1.add(cost,1,0);
        gridpane1.add(regPizzaPrice,1,1);
        gridpane1.add(pepperoniPizzaPrice,1,2);
        gridpane1.add(chickenPizzaPrice,1,3);
        gridpane1.add(cheesePizzaPrice,1,4);
        gridpane1.add(pizzaType,0,6);
        gridpane1.add(PizzanumberText,0,7);
        gridpane1.add(quantity,0,8);
        gridpane1.add(QuantityText,0,9);
        gridpane1.add(taxLabel, 0, 12);
        gridpane1.add(beforeTaxLabel, 0, 13);
        gridpane1.add(totalCostLabel, 0, 14);
        gridpane1.add(calculatePrice,0,10);

        // Create a Scene.
        Scene scene1 = new Scene(gridpane1);
        // Add the Scene to the Stage.
        secondStage.setScene(scene1);
        // Set the stage title.
        secondStage.setTitle("JJ's Pizza Palace");
        // Show the window.
        secondStage.show();
    }
    //Calculate price button event handler
    public class CalculatePriceButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            // Get the pizza type from the text field
            String pizzaType = PizzanumberText.getText();
            String quantityText = QuantityText.getText();

            // Check if either pizzaType or quantityText is empty
            if (pizzaType.isEmpty() || quantityText.isEmpty()) {
                totalCostLabel.setText("Please enter both pizza type and quantity.");
                return;
            }
            // Parse quantity after ensuring it's not empty
            int quantity;
            try {
                quantity = Integer.parseInt(quantityText);
            } catch (NumberFormatException e) {
                totalCostLabel.setText("Invalid quantity entered.");
                return;
            }

            // Get price from PizzaStore class
            int price = PizzaStore.getPrice(pizzaType);

            // Check if the pizza type is valid
            if (price == -1) {
                totalCostLabel.setText("Invalid pizza type");
                return;
            }

            // Calculate total cost before tax
            double totalCostBeforeTax = price * quantity;

            // Calculate tax amount
            double taxAmount = PizzaStore.calculateTaxes(totalCostBeforeTax);

            // Display the calculated price before tax and tax amount
            beforeTaxLabel.setText(String.format("Price before tax: $%,.2f", totalCostBeforeTax));
            taxLabel.setText(String.format("Tax (8%%): $%,.2f", taxAmount));

            // Calculate total price including tax
            double totalPrice = PizzaStore.calculateTotalCost(totalCostBeforeTax);

            // Display the total price
            String totalPriceMessage = String.format("Total Price (incl. tax): $%,.2f", totalPrice);
            totalCostLabel.setText(totalPriceMessage);
        }
    }
}



