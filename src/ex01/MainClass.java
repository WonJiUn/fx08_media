package ex01;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//${javafxCompControls},javafx.fxml
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
		//다른데서 메인코드 복붙한 이후에는 잘못 들어간 import 있는지 꼭 확인하기
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}
