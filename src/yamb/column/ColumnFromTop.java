package yamb.column;

import java.util.ArrayList;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import yamb.Dice;

public class ColumnFromTop extends Column 
{

	public ColumnFromTop(ArrayList<Dice> dices, Button roll, ArrayList<CheckBox> chk) 
	{
		super(dices, roll, chk);
		Platform.runLater(() -> ruleFromTop(0, 12));
	}

}
