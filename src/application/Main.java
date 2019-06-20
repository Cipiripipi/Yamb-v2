package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import yamb.GameOption;
import yamb.YambForm;

public class Main extends Application 
{
	GameOption go = new GameOption();
	YambForm yambForm;
	@Override
	public void start(Stage primaryStage) 
	{
		try
		{
			
			primaryStage.setMaxHeight(315);
			primaryStage.setMaxWidth(415);
			primaryStage.setTitle("YAMB");
			primaryStage.setScene(go.getScene());
			primaryStage.show();
			
			go.getOk().setOnAction(e -> {
				yambForm = new YambForm(go);
				primaryStage.setMinWidth(600);
				primaryStage.setMinHeight(720);
				primaryStage.setScene(yambForm.getScene());
				primaryStage.show();
			});
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
