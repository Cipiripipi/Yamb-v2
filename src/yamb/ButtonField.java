package yamb;

import javafx.scene.control.Button;

public class ButtonField extends Button 
{
	
	public ButtonField (String s)
	{
		this.setText(s);
		this.setPrefWidth(60);
		this.setDisable(false);
	}
}
