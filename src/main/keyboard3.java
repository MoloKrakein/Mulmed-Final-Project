package main;

import java.io.File;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class keyboard3 extends Application
{
	Scene scene;
	BorderPane bp;
	Image img;
	ImageView imgView;
	Button right, left, zoomIn, zoomOut;
	HBox hb;
	VBox vb2;
	Text text;
	GridPane gp;
	File file;
	boolean keyboardRotated = false;
	
	
	public void init()
	{
		file = new File("keyboard3.png");
		String imgUrl = file.toURI().toString();
		img = new Image(imgUrl);
		
		imgView = new ImageView(img);
		
		imgView.setFitHeight(400);
		imgView.setFitWidth(600);

		imgView.setPreserveRatio(true);
		imgView.setSmooth(true);
		
		
		bp = new BorderPane();
		hb = new HBox(imgView );
		
		hb.setAlignment(Pos.CENTER);
		hb.setPadding(new Insets(0, 0, 200, 0));
		

		bp.setCenter(imgView);
		bp.setBottom(hb);
		
		scene = new Scene(bp, 1000, 800 );
	}
	
	
	
	public void textFunction()
	{
		vb2 = new VBox();
		text = new Text("have you ever seen a typewriter keyboard? now you have seen it!");
		text.setFont(Font.font(20));
		text.setStyle("-fx-margin-top : 100px");
		text.setTranslateY(-40);
		text.setTranslateX(200);
		
		VBox vbUp = new VBox(imgView ,text, hb);
		
		vbUp.setAlignment(Pos.CENTER);
		vbUp.setSpacing(10);
		bp.setCenter(vbUp);
	}
	
	
	
	public void buttonFunction()
	{
		right = new Button("Rotate Right");
		right.setTranslateX(-230);

		left = new Button ("Rotate Left");
		left.setTranslateX(-315);
		left.setTranslateY(50);
		left.setPrefWidth(85);
		
		zoomIn = new Button ("Zoom In");
		zoomIn.setTranslateX(-280);
		zoomIn.setTranslateY(50);
		zoomIn.setPrefWidth(80);
		
		zoomOut = new Button("Zoom Out");
		zoomOut.setTranslateX(-360);
		
		
		
		
		hb.getChildren().addAll(text, right, left, zoomIn, zoomOut);
		
	}
	
	public void buttonCommand()
	{

		left.setOnMousePressed(e->{
			imgView.setRotate(imgView.getRotate()+ (- 90));
			keyboardRotated = true;
			moveTextAndButtons();
			
		});
		
		right.setOnMousePressed(e->{
			imgView.setRotate(imgView.getRotate()+ (90));
			keyboardRotated = true;
			moveTextAndButtons();
	
		});
		
		zoomIn.setOnMouseClicked(e->{
            double currentScale = imgView.getScaleX();
            double newScale = currentScale * 1.2;
            if (newScale <= 2.5) {
                imgView.setScaleX(newScale);
                imgView.setScaleY(newScale);
            }
			
		});
		
        zoomOut.setOnMouseClicked(e -> {
            double currentScale = imgView.getScaleX();
            double newScale = currentScale * 0.8;
            if (newScale >= 0.4) {
                imgView.setScaleX(newScale);
                imgView.setScaleY(newScale);
            }
        });
		
	}
	
	
	
    public void moveTextAndButtons() 
    {
    	double rotation = imgView.getRotate();
    	
        if (rotation % 180 == 0) 
        {
        	keyboardRotated = true;
            hb.setPadding(new Insets(0));
        }
        
        else 
        {
        	keyboardRotated = true;
            hb.setPadding(new Insets(200, 0, 0, 0));
            
        }
    }
	
	
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primary_Stage) throws Exception {
		// TODO Auto-generated method stub
		
		init();
		textFunction();
		buttonFunction();
		buttonCommand();
		moveTextAndButtons();
		
		primary_Stage.setScene(scene);
		primary_Stage.setTitle("View Image");
		primary_Stage.show();
	}



	public static void openNewScene(Stage primaryStage) {
		// TODO Auto-generated method stub
		
	}

}
