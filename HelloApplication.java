package com.example.cs2336asg6;

/*Written by Srinivas Kotha for CS2336.005, assignment 6,
starting November 23, 2021.
  NetID: ssk170630

This is a simple calculator in JavaFX which shows two Textfields
for the user to enter two numbers and 4 calculation buttons: add,
subtract, multiply, and divide. The result will display in a Label

 */



import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    /*
     * Textfields so the user will enter two numbers
     */
    TextField num1;
    TextField num2;

    /*
     * Buttons for each operation.
     * The calculator can add, subtract, multiply, or divide
     * the two numbers the user enters
     * Button addButton, subButton, multButton, divButton;
     */

    Button addButton;
    Button subButton;
    Button multButton;
    Button divButton;
    Button clrButton;

    /*
    Result is displayed in a Label
     */
    Label result; //res
    //  floating variables
    float n1, n2;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
     /*
     creating res object. The calculated numbers are stored in this label
      */
        result = new Label();

    /*
     creating objects for num 1 and num2
     */
        num1 = new TextField();
        num2 = new TextField();

        /*
        creating objects for the buttons
         */
        addButton = new Button("Add");
        subButton = new Button("Sub");
        multButton = new Button("Mul");
        divButton = new Button("Div");
        clrButton = new Button("Clear");


        /*
         calling calculation function
         */
        addButton.setOnMouseClicked(this::add);
        subButton.setOnMouseClicked(this::sub);
        multButton.setOnMouseClicked(this::mul);
        divButton.setOnMouseClicked(this::div);
        clrButton.setOnMouseClicked(this::clear);

     /*
     Stage title
      */
        primaryStage.setTitle("Simple Calculator");

        /*
         * Creating a Grid Pane with its properties
         * to display the calculator
         */
        GridPane pane = new GridPane();

     /*
     setting padding around the gridpane
      */
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));

     /*
     setting gap for grid rows and columns
      */
        pane.setVgap(5);
        pane.setHgap(5);

     /*
      Placing nodes in pane
     */

        pane.add(result, 1, 0, 4, 1);
        pane.add(new Label ("Result: "), 0 ,0);

        pane.add(new Label ("Number 1: "), 0, 1);
        pane.add(num1, 1, 1);

        pane.add(new Label ("Number 2: "), 0, 2);
        pane.add(num2, 1,2);

    /*
      adding the operations at row 4 and other columns
     */
        pane.add(addButton, 0, 3, 1, 1);
        pane.add(subButton, 1, 3, 1, 1);
        pane.add(multButton, 2, 3, 1, 1);
        pane.add(divButton, 3, 3, 1, 1);
        pane.add(clrButton, 4,3,1,1);

    /*
         creating scene
     */
        Scene scene = new Scene(pane, 400, 250);

    /*
          place scene in stage
     */
        primaryStage.setScene(scene);

    /*
      display stage
     */
        primaryStage.show();
    }
    /*
    Clear Button handler. Clear all values
     */
    private void clear(MouseEvent mouseEvent) {
        result.setText("");
        num1.clear();
        num2.clear();
    }

    //  calculating addition and displaying results
    public void add(MouseEvent event) {
        try{
            double n1 = Double.parseDouble(num1.getText());
            double n2 = Double.parseDouble(num2.getText());
            result.setText(String.valueOf(n1+n2));

        }
        catch(NumberFormatException ex )
        {
            //User entered bad numbers
            result.setText("Invalid Numbers");
        }

    }

    //  calculating subtraction and displaying results
    public void sub(MouseEvent event) {
        try
        {
            double n1 = Double.parseDouble(num1.getText());
            double n2 = Double.parseDouble(num2.getText());
            result.setText(String.valueOf(n1-n2));
        }
        catch(NumberFormatException ex)
        {
            // User entered bad numbers
            result.setText("Invalid Numbers");
        }

    }

    //  calculating multiplication and displaying result
    public void mul(MouseEvent event) {
       try
       {
           double n1 = Double.parseDouble(num1.getText());
           double n2 = Double.parseDouble(num2.getText());
           result.setText(String.valueOf(n1*n2));
       }
       catch(NumberFormatException ex)
       {
           //User entered bad numbers
           result.setText("Invalid Numbers");
       }
    }

    //  calculating division and displaying result
    public void div(MouseEvent event) {

        try {
            double n1 = Double.parseDouble(num1.getText());
            double n2 = Double.parseDouble(num2.getText());
            double divNum = 0.0;
            divNum = n1 / n2;
             result.setText(String.valueOf(divNum));
        }
        catch (ArithmeticException ex )
        {
            // Division by zero error
            result.setText("Invalid numbers");
        }
        catch(NumberFormatException ex)
        {
            // Invalid numbers entered
            result.setText("Invalid Numbers");
        }

    }
}
