package yamb.column;

import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import yamb.Dice;

public class ColumnHand extends Column 
{

	public ColumnHand(ArrayList<Dice> dices, Button roll, ArrayList<CheckBox> chk) 
	{
		super(dices, roll, chk);
	}

}
