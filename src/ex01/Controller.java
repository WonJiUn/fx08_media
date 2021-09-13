package ex01;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Controller implements Initializable {

	private Parent root;
	ListView<String> fxListView;
	ImageView fxImageView;
	ObservableList<String> phoneString;
	ObservableList<Phone> phoneURL;
	
	public void setRoot(Parent root) {
		this.root = root;
		fxListView = (ListView)root.lookup("#fxListView");
		fxImageView = (ImageView)root.lookup("#fxImageView");
		setListView();
	}
	public void setListView() {
		setList();
		fxListView.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue)->{
			System.out.println("observable(형식) : " + observable);
			System.out.println("oldValue(이전값) : " + oldValue);
			System.out.println("newValue(현재값) : " + newValue);
			System.out.println(phoneString.get((int)newValue)); //1
			System.out.println(phoneURL.get((int)newValue).getSmartPhone()); //2
			System.out.println(phoneURL.get((int)newValue).getImage()); //3
			//1과 2는 같은값이 나오므로 1=3인값을 가져오라고 해도되고 2=3으로 해도 됨
			fxImageView.setImage(new Image("/phone/" + phoneURL.get((int)newValue).getImage()));
		});
	}
	public void setList() {
		phoneString = FXCollections.observableArrayList(); //객체화
		phoneURL = FXCollections.observableArrayList();
		for(int i = 1; i<8; i++) {
			phoneString.add("갤럭시S" + i);
			Phone phone = new Phone("갤럭시S" + i, "phone0" + i + ".png");
			//Phone 클래스의 생성자에서 작성해준 형식대로 맞춰준다
			phoneURL.add(phone);
		}
		fxListView.setItems(phoneString);
	}
	
	public void btn() {
		//새 창을 띄우는게 아니라 버튼을 눌렀을때 창 자체를 전환하는 방법
		FXMLLoader loader = new FXMLLoader(getClass().getResource("aaa.fxml"));

		Parent newRoot = null;
		Scene scene = null;
		
		try {
			newRoot = loader.load();
		}catch(Exception e) {
			
		}
		scene = new Scene(newRoot);
		
		Stage stage = (Stage)root.getScene().getWindow();
		
		stage.setScene(scene);
		stage.show();
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
