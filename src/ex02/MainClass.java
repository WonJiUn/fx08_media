package ex02;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//${javafxCompControls},javafx.fxml,javafx.web
//평소에 하던거에서 뒤에 하나 추가되어야함
public class MainClass extends Application {

	@Override
	public void start(Stage arg0) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("eventTest.fxml"));

		Parent root = loader.load();
		Scene scene = new Scene(root);
		
		Controller ctl = loader.getController();
		ctl.setRoot(root);
		
		arg0.setScene(scene);
		arg0.show();
		
	}
	public static void main(String[] args) {
		launch(args);
	} 
	
}
