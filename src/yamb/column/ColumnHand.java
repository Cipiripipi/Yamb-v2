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
import yamb.DiceCanvas;

public class ColumnHand extends Column 
{

	public ColumnHand(ArrayList<DiceCanvas> dicesCanvas, Button roll, ArrayList<CheckBox> chk) 
	{
		super(dicesCanvas, roll, chk);
		Image diceImage = new Image("Kockice/ColumnHand.png");
	    BackgroundImage backgroundImage = new BackgroundImage(diceImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);
        b.setBackground(background);
	}

}
