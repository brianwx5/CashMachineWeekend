package rocks.zipcode.atm.bank;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class AlertBox {

    public static void display() {
        Stage window = new Stage();


        window.setTitle("Alert");
        window.setMinWidth(250);

        Label label = new Label();
        label.setText("By withdrawing this amount, you will be overdrafting.");
        Button closeButton = new Button("Okay");
        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label,closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

    }
}
