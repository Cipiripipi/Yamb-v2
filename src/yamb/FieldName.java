package yamb;

import javafx.scene.layout.VBox;

public class FieldName 
{
	private VBox vb = new VBox();
	
	public FieldName ()
	{
		ButtonFieldName b = new ButtonFieldName("");
		b.setPrefSize(60, 50);
		
		ButtonFieldName b1 = new ButtonFieldName("1");
		ButtonFieldName b2 = new ButtonFieldName("2");
		ButtonFieldName b3 = new ButtonFieldName("3");
		ButtonFieldName b4 = new ButtonFieldName("4");
		ButtonFieldName b5 = new ButtonFieldName("5");
		ButtonFieldName b6 = new ButtonFieldName("6");
		
		ButtonFieldName z16 = new ButtonFieldName("SUM");
		
		ButtonFieldName max = new ButtonFieldName("MAX");
		ButtonFieldName min = new ButtonFieldName("MIN");
		
		ButtonFieldName zMaxMin = new ButtonFieldName("SUM");
		
		ButtonFieldName kenta = new ButtonFieldName("KENTA");
		ButtonFieldName triling = new ButtonFieldName("TRILING");
		ButtonFieldName full = new ButtonFieldName("FULL");
		ButtonFieldName poker = new ButtonFieldName("POKER");
		ButtonFieldName yamb = new ButtonFieldName("YAMB");
		
		ButtonFieldName zKentaYamb = new ButtonFieldName("SUM");
		
		vb.getChildren().addAll(b, b1, b2, b3, b4, b5, b6, z16, max, min, zMaxMin, kenta, triling, full, poker, yamb, zKentaYamb);
	}

	public VBox getVb() {return vb;}

}
