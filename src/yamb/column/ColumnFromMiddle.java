package yamb.column;

import java.util.ArrayList;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import yamb.Dice;

public class ColumnFromMiddle extends Column 
{

	public ColumnFromMiddle(ArrayList<Dice> dices, Button roll, ArrayList<CheckBox> chk) 
	{
		super(dices, roll, chk);
		Platform.runLater(() -> ruleFromTop(7, 12));
		Platform.runLater(() -> ruleFromBottom(6, 0));
	}

}
