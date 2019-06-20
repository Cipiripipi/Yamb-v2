package yamb.column;

import java.util.ArrayList;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import yamb.Dice;

public class ColumnFromTopAndBottomToMiddle extends Column
{

	public ColumnFromTopAndBottomToMiddle(ArrayList<Dice> dices, Button roll, ArrayList<CheckBox> chk) 
	{
		super(dices, roll, chk);
		Image diceImage = new Image("Kockice/ColumnToMiddle.png");
	    BackgroundImage backgroundImage = new BackgroundImage(diceImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);
        b.setBackground(background);
		Platform.runLater(() -> ruleFromTop(0, 6));
		Platform.runLater(() -> ruleFromBottom(12, 7));
	}

}
