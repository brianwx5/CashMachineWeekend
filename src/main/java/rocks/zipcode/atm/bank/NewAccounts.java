package rocks.zipcode.atm.bank;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class NewAccounts {

    public static void display() {
        Stage window = new Stage();


        window.setTitle("Getting Started");
        window.setMinWidth(350);

        Label label = new Label();
        label.setText("ZipCloud Bank Sign Up Information");
        Label label2 = new Label();
        label2.setText("ID");
        TextField field = new TextField();
        Label label3 = new Label();
        label3.setText("Name");
        TextField field2 = new TextField();
        Label label4 = new Label();
        label4.setText("Email");
        TextField field3 = new TextField();
        Label label5 = new Label();
        label5.setText("Balance");
        TextField field4 = new TextField();
        Button confirmButton = new Button("Confirm");
        confirmButton.setOnAction(e -> window.close());
        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label2,field,label3,field2,label4,field3,label5,field4);
        layout.setAlignment(Pos.CENTER_LEFT);
        layout.setMinWidth(200);
        layout.setPadding(new Insets(10,10,10,90));

        HBox hBox = new HBox(10);
        hBox.getChildren().add(label);
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(5,5,5,5));

        HBox hBox2 = new HBox(10);
        hBox2.getChildren().addAll(confirmButton, closeButton);
        hBox2.setPadding(new Insets(5,5,5,5));
        hBox2.setAlignment(Pos.CENTER);

        BorderPane borderPane = new BorderPane();
        borderPane.setMinHeight(350);
        borderPane.setTop(hBox);
        borderPane.setLeft(layout);
        borderPane.setBottom(hBox2);

        Scene scene = new Scene(borderPane);
        window.setScene(scene);
        window.showAndWait();

    }
}

