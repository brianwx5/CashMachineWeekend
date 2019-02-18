package rocks.zipcode.atm;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import rocks.zipcode.atm.bank.*;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.FlowPane;

import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.ImageInputStream;
import javax.xml.soap.Text;

/**
 * @author ZipCodeWilmington
 */
public class CashMachine2 extends Application {

    private TextField field = new TextField("Ex: 1000");
    private TextField field2 = new TextField();
    private TextField field3 = new TextField();
    private CashMachine cashMachine = new CashMachine(new Bank());

    private Parent createContent() {
        BorderPane borderPane = new BorderPane();
        borderPane.setPrefSize(600, 600);

        TextArea areaInfo = new TextArea();

        //Button for Exit
        Button btnExit = new Button("Exit");
        btnExit.setDisable(true);

        //Button to Deposit
        Button btnDeposit = new Button("Deposit");
        btnDeposit.setOnAction(e -> {
            Double amount = Double.parseDouble(field2.getText());
            cashMachine.deposit(amount);

            areaInfo.setText(cashMachine.toString());
        });
        btnDeposit.setMaxWidth(Double.MAX_VALUE);
        btnDeposit.setDisable(true);


        //Button to Withdraw
        Button btnWithdraw = new Button("Withdraw");
        btnWithdraw.setOnAction(e -> {
            Double amount = Double.parseDouble(field3.getText());
            cashMachine.withdraw(amount);
            areaInfo.setText(cashMachine.toString());
            if(cashMachine.isAccountBalanceWitthdrawn()){
                AlertBox.display();}
        });

        btnWithdraw.setMaxWidth(Double.MAX_VALUE);
        btnWithdraw.setDisable(true);


        //Button to Submit
        Button btnSubmit = new Button("Login ID");
        btnSubmit.setOnAction(e -> {
            int id = Integer.parseInt(field.getText());
            cashMachine.login(id);

            areaInfo.setText(cashMachine.toString());
            btnSubmit.setDisable(true);
            btnDeposit.setDisable(false);
            btnWithdraw.setDisable(false);
            btnExit.setDisable(false);

        });
        btnSubmit.setMaxWidth(Double.MAX_VALUE);



        //Button to Exit

        btnExit.setOnAction(e -> {
            cashMachine.exit();

            areaInfo.setText(cashMachine.toString());
            btnSubmit.setDisable(false);
            btnDeposit.setDisable(true);
            btnWithdraw.setDisable(true);
            btnExit.setDisable(true);
        });
        btnExit.setMaxWidth(Double.MAX_VALUE);


        //Label
        Label label = new Label("Welcome to ZipCloudBank");
        Label label2 = new Label("Deposit");
        label2.setAlignment(Pos.BASELINE_LEFT);
        Label label3 = new Label("Withdraw");
        label3.setAlignment(Pos.BASELINE_LEFT);

        //Layout
        HBox hBox = new HBox(10);
        hBox.getChildren().add(label);
        hBox.getChildren().add(field);
        hBox.getChildren().add(btnSubmit);
        hBox.setAlignment(Pos.CENTER_LEFT);
        hBox.setPadding(new Insets(15,15,15,15));

        //Vbox
        VBox vBox = new VBox(20);
        field2.setMinWidth(500);
        vBox.getChildren().add(label2);
        vBox.getChildren().add(field2);
        vBox.getChildren().add(label3);
        vBox.getChildren().add(field3);
        vBox.setAlignment(Pos.CENTER_LEFT);
        vBox.setPadding(new Insets(20,20,20,20));

        //Vbox 3
        VBox vBox3 = new VBox(60);
        vBox3.getChildren().add(btnDeposit);
        vBox3.getChildren().add(btnWithdraw);
        vBox3.setAlignment(Pos.CENTER);
        vBox3.setPadding(new Insets(56,20,20,20));

        //Vbox 2
        VBox vBox2 = new VBox();
        vBox2.getChildren().add(areaInfo);
        vBox2.getChildren().add(btnExit);


        borderPane.setTop(hBox);
        borderPane.setLeft(vBox);
        borderPane.setBottom(vBox2);
        borderPane.setRight(vBox3);
        return borderPane;
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Welcome to ZipCloudBank");
        stage.setScene(new Scene(createContent()));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
