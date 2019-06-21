package yamb.column;

import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import yamb.CheckResult;
import yamb.DiceCanvas;

public class ColumnMax extends Column 
{
	
	public ColumnMax(ArrayList<DiceCanvas> dicesCanvas, Button roll, ArrayList<CheckBox> chk) 
	{
		super(dicesCanvas, roll, chk);
		Image diceImage = new Image("Kockice/ColumnMax.png");
	    BackgroundImage backgroundImage = new BackgroundImage(diceImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);
        b.setBackground(background);

		b1.setOnMouseReleased(e -> {
			if (CheckResult.checkNumber(dicesCanvas, 1) != 5)
				b1.setText("0");
		});
		
		b2.setOnMouseReleased(e -> {
			if (CheckResult.checkNumber(dicesCanvas, 2) != 10)
				b2.setText("0");
		});
		
		b3.setOnMouseReleased(e -> {
			if (CheckResult.checkNumber(dicesCanvas, 3) != 15)
				b3.setText("0");
		});
		
		b4.setOnMouseReleased(e -> {
			if (CheckResult.checkNumber(dicesCanvas, 4) != 20)
				b4.setText("0");
		});
		
		b5.setOnMouseReleased(e -> {
			if (CheckResult.checkNumber(dicesCanvas, 5) != 25)
				b5.setText("0");
		});
		
		b6.setOnMouseReleased(e -> {
			if (CheckResult.checkNumber(dicesCanvas, 6) != 30)
				b6.setText("0");
		});
		
		kenta.setOnMouseReleased(e -> {
			if (kenta.getText().equalsIgnoreCase("56") || kenta.getText().equalsIgnoreCase("46"))
				kenta.setText("0");
			
		});
		
		triling.setOnMouseReleased(e -> {
			if (CheckResult.checkTriling(dicesCanvas) != 38)
				triling.setText("0");
		});
		
		full.setOnMouseReleased(e -> {
			if (CheckResult.checkFull(dicesCanvas) != 58)
				full.setText("0");
		});
		
		poker.setOnMouseReleased(e -> {
			if (CheckResult.checkPoker(dicesCanvas) != 64)
				poker.setText("0");
		});
		
		yamb.setOnMouseReleased(e -> {
			if (CheckResult.checkYamb(dicesCanvas) != 80)
				yamb.setText("0");
		});
		
		max.setOnMouseReleased(e -> {
			if (max.getText().equalsIgnoreCase("30") == false)
				max.setText("0");
		});
		
		min.setOnMouseReleased(e -> {
			if (min.getText().equals("5") == false)
				min.setText("0");
		});
	}
}
