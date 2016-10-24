package vierkantswortelLukasDemeyere;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Vierkantswortel extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("vierkantsvergelijking");
		TextField Field1 = new TextField();

		Label label1 = new Label();
		label1.setStyle("-fx-text-fill: black;-fx-font-family: 'comic sans ms' ;-fx-font-size: 16px;");
		label1.setText("x�+");

		TextField Field2 = new TextField();

		Label label2 = new Label();
		label2.setStyle("-fx-text-fill: black;-fx-font-family: 'comic sans ms' ;-fx-font-size: 16px;");
		label2.setText("x+");

		TextField Field3 = new TextField();

		Label resultaat = new Label();
		resultaat.setStyle("-fx-text-fill: black;-fx-font-family: 'comic sans ms' ;-fx-font-size: 16px;");
		resultaat.setText("= 0");
		
		Label resultaat1 = new Label();
		Label resultaat2 = new Label();
		resultaat1.setStyle("-fx-text-fill: black;-fx-font-family: 'comic sans ms' ;-fx-font-size: 16px;");
		resultaat2.setStyle("-fx-text-fill: black;-fx-font-family: 'comic sans ms' ;-fx-font-size: 16px;");
		
		Button bereken = new Button("Berekenen");
		Button sluit = new Button("Exit");
		
		
		bereken.setOnAction(e -> {
			try{	
				double a = Integer.parseInt(Field1.getText());
				double b = Integer.parseInt(Field2.getText());
				double c = Integer.parseInt(Field3.getText());
				double opl1;
				double opl2;
				double discriminant = Math.pow(b, 2) - (4*a*c);
				
				if (discriminant > 0 ){
					opl1 = (((-b) + Math.sqrt(discriminant))/(2*a));
					opl2 = (((-b) - Math.sqrt(discriminant))/(2*a));
					resultaat1.setText("De eerste oplossing is: " + opl1);
					resultaat2.setText("De tweede oplossing is: " + opl2);
				} else if (discriminant == 0){
					opl1 = ((-b))/(2*a);
					resultaat1.setText("Oplossing is: " + opl1);
					resultaat2.setText("");
				} else if (discriminant < 0) {
					resultaat1.setText("Geen oplossing.");
					resultaat2.setText("");
				}
			} catch ( NumberFormatException exception){
				resultaat1.setText("Voor een getal in!");
			}
		});
		
		sluit.setOnAction(e -> Platform.exit());
		
		VBox root = new VBox();
		HBox sub1 = new HBox();
		HBox sub2 = new HBox();
		VBox sub3 = new VBox();

		root.setSpacing(5);

		root.getChildren().addAll(sub1, sub2, sub3);
		sub1.getChildren().addAll(Field1, label1,Field2, label2,Field3, resultaat);
		sub2.getChildren().addAll(bereken, sluit);
		sub3.getChildren().addAll(resultaat1, resultaat2);


		Scene scene = new Scene(root, 500, 175);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
