package yamb;

import javafx.scene.control.Button;

public class ButtonFieldName extends Button 
{
	public ButtonFieldName (String s)
	{
		this.setText(s);
		this.setPrefWidth(60);
		this.setDisable(true);
		//this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(1))));
		
	}
}
