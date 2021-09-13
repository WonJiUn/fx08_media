package ex01;

import javafx.beans.property.SimpleStringProperty;

public class Phone {
	private SimpleStringProperty smartPhone;
	private SimpleStringProperty image;
	//fx에서 쓰는 String 자료형이라고 보면된다
	
	public Phone(String smartPhone, String image) { //생성자
		this.smartPhone = new SimpleStringProperty(smartPhone);
		this.image = new SimpleStringProperty(image);
	}

	public String getSmartPhone() {
		return smartPhone.get();
	}

	public void setSmartPhone(String smartPhone) {
		this.smartPhone = new SimpleStringProperty(smartPhone);
	}

	public String getImage() {
		return image.get();
	}

	public void setImage(String image) {
		this.image = new SimpleStringProperty(image);
	}
	//자료형이 다르기 때문에 일반 세터게터에서 조금 변형을 해줘야함
}
