package ex02;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class MediaServiceImpl implements MediaService {
	
	MediaPlayer mediaPlayer;
	MediaView mediaView;
	Button btnPlay, btnPause, btnStop;
	boolean endOfMedia;
	
	Label labelTime;
	Slider sliderVolume;
	ProgressBar progressBar;
	ProgressIndicator progressIndicator;
	
	@Override
	public void myStart() {
		mediaPlayer.play();
		
	}

	@Override
	public void myStop() {
		mediaPlayer.stop();
		
	}

	@Override
	public void myPause() {
		mediaPlayer.pause();
	}

	public void setControl(Parent root) {
		mediaView = (MediaView)root.lookup("#fxMediaView");
		btnPlay = (Button)root.lookup("#btnPlay");
		btnPause = (Button)root.lookup("#btnPause");
		btnStop = (Button)root.lookup("#btnStop");
		
		labelTime = (Label)root.lookup("#labelTime");
		sliderVolume = (Slider)root.lookup("#sliderVolume");
		progressBar = (ProgressBar)root.lookup("#progressBar");
		progressIndicator = (ProgressIndicator)root.lookup("#progressIndicator");
	}
	@Override
	public void setMedia(Parent root, String mediaName) {
		setControl(root);
		//System.out.println(getClass().getResource(mediaName));
		Media media = new Media(getClass().getResource(mediaName).toString());
		mediaPlayer = new MediaPlayer(media);
		//경로에서 동영상을 불러오고 그걸 플레이어에 넣어주면됨
		mediaView.setMediaPlayer(mediaPlayer);
		
		mediaPlayer.setOnReady(new Runnable() {
			//Runnable은 인터페이스로 만들어져있음. 이후로는 람다식을 이용하여 작성하는게 편함
			@Override
			public void run() {
				btnPlay.setDisable(false);
				btnStop.setDisable(true);
				btnPause.setDisable(true);
				//재생되지 않은 상태에서는 일시정지와 종료버튼 비활성화
				
				mediaPlayer.currentTimeProperty().addListener((a,b,c)->{
					//흐르는 시간 / 최종시간
					double progress = mediaPlayer.getCurrentTime().toSeconds() / mediaPlayer.getTotalDuration().toSeconds();
					progressBar.setProgress(progress);
					progressIndicator.setProgress(progress);
					labelTime.setText((int)mediaPlayer.getCurrentTime().toSeconds() + "/" + (int)mediaPlayer.getTotalDuration().toSeconds());
				});
			}
		
		});
		
		mediaPlayer.setOnPlaying(()->{
			
			sliderVolume.setValue(50.0); //시작할때 기본소리크기 설정
			
			btnPlay.setDisable(true);
			btnStop.setDisable(false);
			btnPause.setDisable(false);
		});
		
		mediaPlayer.setOnStopped(()->{
			btnPlay.setDisable(false);
			btnStop.setDisable(true);
			btnPause.setDisable(true);
		});
		
		mediaPlayer.setOnPaused(()->{
			btnPlay.setDisable(false);
			btnStop.setDisable(false);
			btnPause.setDisable(true);
		});
		
		//동영상이 완전히 종료되었을때 이벤트 설정
		mediaPlayer.setOnEndOfMedia(()->{
			btnPlay.setDisable(false);
			btnStop.setDisable(true);
			btnPause.setDisable(true);
			myStop(); 
			//영상을 처음으로 돌림
		});
		
	}

	@Override
	public void volumeControl() {
		mediaPlayer.setVolume(sliderVolume.getValue()/100.0);
		//볼륨 기본 설정값
		
	}
	
	

}
