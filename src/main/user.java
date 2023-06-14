package main;

import java.io.File;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class user extends Application 
{

	Scene scene;
	BorderPane bp;
	MenuBar menubar = new MenuBar();
	MenuItem logout = new MenuItem("Logout");
	MenuItem viewKeyboard = new MenuItem("View Keyboard");
	
	File file;
	Media videoMedia;
	MediaPlayer videoPlayer;
	MediaView videoView;
	Text text;
	

	
	public void menuSettings()
	{
        Menu fileMenu = new Menu("Menu");
        fileMenu.getItems().addAll(logout, viewKeyboard);

        // Create menu bar
        menubar.getMenus().add(fileMenu);
        bp.setTop(menubar);
        
        logout.setOnAction(e->{
        	Stage stage = (Stage) bp.getScene().getWindow();
        	stage.close();
        	
        	videoPlayer.stop();
        	
        	
        	Main secondScript = new Main();
        	try 
        	{
        		secondScript.start(new Stage());
        	}
        	catch ( Exception ex)
        	{
        		ex.printStackTrace();
        	}
        	
        	
        });
	}
	
	
	
	public void videoFunction()
	{

		//read path file buat video 
		file = new File("keyboard.mp4");
		videoMedia = new Media(file.toURI(). toString());
		videoPlayer = new MediaPlayer(videoMedia);
		
		videoView = new MediaView(videoPlayer);

		videoView.setFitWidth(700);
		videoView.setFitHeight(600);
	
		bp.setCenter(videoView);
		
		videoPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		videoPlayer.setAutoPlay(true);
		

		lanjut = new Button("CONTINUE >>	");
		
        lanjut.setFont(Font.font(18));
		lanjut.setStyle("-fx-background-color :#363636; -fx-text-fill : white ");

		lanjut.setTranslateX(-300);
	}
	
	VBox vb, vb2 = new VBox();
	VBox vbUp = new VBox();
	GridPane gp, gp2 = new GridPane();
	Button lanjut = new Button();
	Text title = new Text();

	public void titleFunction()
	{
		vb2 = new VBox();
		title = new Text("NEW KEYBOARD HAS ARRIVED!");
		title.setFont(Font.font(56));
		
		
		VBox vbUp = new VBox(title, videoView, lanjut);

		vbUp.setAlignment(Pos.CENTER);
		vbUp.setSpacing(10);
		
		bp.setCenter(vbUp);
	}
	
	
	

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primary_Stage) throws Exception {
		// TODO Auto-generated method stub
		bp = new BorderPane();
		scene = new Scene(bp, 1200, 700);
		videoFunction();
		titleFunction();
		menuSettings();
		

		
		primary_Stage.show();
		primary_Stage.setTitle("USER");
		primary_Stage.setScene(scene);
		
	}

}
