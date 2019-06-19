package yamb;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import yamb.column.Column;
import yamb.column.ColumnFromBottom;
import yamb.column.ColumnFromMiddle;
import yamb.column.ColumnFromTop;
import yamb.column.ColumnFromTopAndBottomToMiddle;
import yamb.column.ColumnHand;
import yamb.column.ColumnMax;
import yamb.column.ColumnSum;

public class YambForm 
{

	private Scene scene;
	private ArrayList<Dice> dices = new ArrayList<>();
	private ArrayList<CheckBox> chk = new ArrayList<>();
	private static int brojPokusaja = 0;
	
	private Button roll = new Button("ROLL");
	
	ColumnFromTop columnFromTop = new ColumnFromTop(dices, roll, chk);
	Column columnFree = new Column(dices, roll, chk);
	ColumnFromBottom columnFromBottom = new ColumnFromBottom(dices, roll, chk);
	ColumnFromMiddle columnFromMiddle = new ColumnFromMiddle(dices, roll, chk);
	ColumnFromTopAndBottomToMiddle columnFromTopAndBottomToMiddle = new ColumnFromTopAndBottomToMiddle(dices, roll, chk);
	ColumnHand columnHand = new ColumnHand(dices, roll, chk);
	ColumnMax columnMax = new ColumnMax(dices, roll, chk);
	ColumnSum columnSum = new ColumnSum();
	
	public YambForm(GameOption go) 
	{
		
		// GLAVNO
		VBox vbox = new VBox();
		vbox.setPadding(new Insets(5, 5, 5, 5));

		// GP ZA KOCKICE I CHECK
		GridPane gp1 = new GridPane();
		gp1.setVgap(10);
		gp1.setHgap(10);
		gp1.setPadding(new Insets(5, 10, 5, 50));
		for (int i = 0; i < 6; i++) 
		{
			if (go.getTg().getSelectedToggle() != null) 
			{
				Dice dice = new Dice(gp1, go.getTg().getSelectedToggle().getUserData().toString());
				gp1.add(dice, i, 0);
				dices.add(dice);
			} 
			else 
			{
				Dice dice = new Dice(gp1, "black");
				gp1.add(dice, i, 0);
				dices.add(dice);
			}

			CheckBox check = new CheckBox();
			GridPane.setMargin(check, new Insets(0, 0, 0, 25));
			gp1.add(check, i, 1);
			chk.add(check);
		}
		vbox.getChildren().add(gp1);

		// BUTTON ZAVRTI
		roll.setMinWidth(200);
		roll.setMinHeight(30);
		VBox.setMargin(roll, new Insets(5, 0, 20, 185));

		roll.setOnAction((ActionEvent event) -> {
			columnHand.ruleForHand();
			columnHand.ruleForHandResetEmptyField();
			
			if (brojPokusaja <= 2)
			{
				brojPokusaja++;
				for (int i = 0; i < dices.size(); i++) 
				{
					if (chk.get(i).isSelected() == false) 
					{
						dices.get(i).rollDice();
						dices.get(i).showDice(dices.get(i));
					}
				}
			}

			if (brojPokusaja >= 3) 
			{
				roll.setDisable(true);
				
			}
		});

		vbox.getChildren().add(roll);
		
		//Za pakovanje kolona
		GridPane gpColumn = new GridPane();
		gpColumn.add(new FieldName().getVb(), 0, 0);
		
		
		gpColumn.add(columnFromTop.getVb(), 1, 0);
		
		
		gpColumn.add(columnFree.getVb(), 2, 0);
		
		
		gpColumn.add(columnFromBottom.getVb(), 3, 0);
		
		
		gpColumn.add(columnFromMiddle.getVb(), 4, 0);
		
		
		gpColumn.add(columnFromTopAndBottomToMiddle.getVb(), 5, 0);
		
		
		gpColumn.add(columnHand.getVb(), 6, 0);
		
		
		gpColumn.add(columnMax.getVb(), 7, 0);
		
		
		gpColumn.add(columnSum.getVb(), 8, 0);
		
		
		vbox.getChildren().add(gpColumn);

		scene = new Scene(vbox, 400, 400);
	}
	
	//pravi listu sa obelezenim kockicama
	public static void pickDices (ArrayList<Dice> dices, ArrayList<CheckBox> chk) 
	{
		for (Dice dice : dices) 
		{
			dice.setSelected(false);
		}
		for (int i = 0; i < dices.size(); i ++)
		{
			if (chk.get(i).isSelected() == true)
				dices.get(i).setSelected(true);
		}
	}
	
	public Scene getScene() {return scene;}
	public static int getBrojPokusaja() {return brojPokusaja;}
	public static void setBrojPokusaja(int brojPokusaja) {YambForm.brojPokusaja = brojPokusaja;}
	

}
