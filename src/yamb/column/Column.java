package yamb.column;

import java.util.ArrayList;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import yamb.ButtonField;
import yamb.CheckResult;
import yamb.Dice;
import yamb.SumResult;
import yamb.YambForm;

public class Column 
{
	private VBox vb = new VBox();
	private Background background0 = new Background(new BackgroundImage(new Image("Kockice/Kockica.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT));
	
	protected ButtonField b = new ButtonField("");
	 
	protected ButtonField b1 = new ButtonField("");
	protected ButtonField b2 = new ButtonField("");
	protected ButtonField b3 = new ButtonField("");
	protected ButtonField b4 = new ButtonField("");
	protected ButtonField b5 = new ButtonField("");
	protected ButtonField b6 = new ButtonField("");
	 
	protected ButtonField z16 = new ButtonField("");
	 
	protected ButtonField max = new ButtonField("");
	protected ButtonField min = new ButtonField("");
	 
	protected ButtonField zMaxMin = new ButtonField("");
	 
	protected ButtonField kenta = new ButtonField("");
	protected ButtonField triling = new ButtonField("");
	protected ButtonField full = new ButtonField("");
	protected ButtonField poker = new ButtonField("");
	protected ButtonField yamb = new ButtonField("");
	 
	protected ButtonField zKentaYamb = new ButtonField("");
	
	protected ArrayList<ButtonField> nizButtona = new ArrayList<>();
	
	public Column (ArrayList<Dice> dices, Button roll, ArrayList<CheckBox> chk)
	{
		b.setDisable(true);
		z16.setDisable(true);
		zMaxMin.setDisable(true);
		zKentaYamb.setDisable(true);
		
		kenta.setOnAction(e -> {
				YambForm.pickDices(dices, chk);
				kenta.setText(String.valueOf(CheckResult.checkKenta(dices, YambForm.getBrojPokusaja())));
				kenta.setDisable(true);
				resetAfter3roll(dices, roll, chk);
				zKentaYamb.setText(String.valueOf(SumResult.sumKentaYamb(kenta, triling, full, poker, yamb)));
		});
		
		triling.setOnAction(e -> {
				
				YambForm.pickDices(dices, chk);
				triling.setText(String.valueOf(CheckResult.checkTriling(dices)));
				triling.setDisable(true);
				resetAfter3roll(dices, roll, chk);
				zKentaYamb.setText(String.valueOf(SumResult.sumKentaYamb(kenta, triling, full, poker, yamb)));
		});
		
		full.setOnAction(e -> {
				YambForm.pickDices(dices, chk);
				full.setText(String.valueOf(CheckResult.checkFull(dices)));
				full.setDisable(true);
				resetAfter3roll(dices, roll, chk);
				zKentaYamb.setText(String.valueOf(SumResult.sumKentaYamb(kenta, triling, full, poker, yamb)));
		});
		
		poker.setOnAction(e -> {
				YambForm.pickDices(dices, chk);
				poker.setText(String.valueOf(CheckResult.checkPoker(dices)));
				poker.setDisable(true);
				resetAfter3roll(dices, roll, chk);
				zKentaYamb.setText(String.valueOf(SumResult.sumKentaYamb(kenta, triling, full, poker, yamb)));
		});
		
		yamb.setOnAction(e -> {
				YambForm.pickDices(dices, chk);
				yamb.setText(String.valueOf(CheckResult.checkYamb(dices)));
				yamb.setDisable(true);
				resetAfter3roll(dices, roll, chk);
				zKentaYamb.setText(String.valueOf(SumResult.sumKentaYamb(kenta, triling, full, poker, yamb)));
		});
		
		max.setOnAction(e -> {
			YambForm.pickDices(dices, chk);
			if (numberOfSelectedDices(dices) == 5)
			{
				max.setText(String.valueOf(sumMaxMin(dices)));
				max.setDisable(true);
				resetAfter3roll(dices, roll, chk);
				zMaxMin.setText(String.valueOf(SumResult.sumMaxMin(max, min, b1)));
			}
			else
			{
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information Dialog");
				alert.setHeaderText("You must select 5 dice");
				alert.showAndWait();
			}
		});
		
		min.setOnAction(e -> {
			YambForm.pickDices(dices, chk);
			if (numberOfSelectedDices(dices) == 5)
			{
				min.setText(String.valueOf(sumMaxMin(dices)));
				min.setDisable(true);
				resetAfter3roll(dices, roll, chk);
				zMaxMin.setText(String.valueOf(SumResult.sumMaxMin(max, min, b1)));
			}
			else
			{
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information Dialog");
				alert.setHeaderText("You must select 5 dice");
				alert.showAndWait();
			}
		});
		
		b1.setOnAction(e-> {
			YambForm.pickDices(dices, chk);
			b1.setText(String.valueOf(CheckResult.checkNumber(dices, 1)));
			b1.setDisable(true);
			resetAfter3roll(dices, roll, chk);
			z16.setText(String.valueOf(SumResult.sumNumber(b1, b2, b3, b4, b5, b6)));
		});
		
		b2.setOnAction(e-> {
			YambForm.pickDices(dices, chk);
			b2.setText(String.valueOf(CheckResult.checkNumber(dices, 2)));
			b2.setDisable(true);
			resetAfter3roll(dices, roll, chk);
			z16.setText(String.valueOf(SumResult.sumNumber(b1, b2, b3, b4, b5, b6)));
		});
		
		b3.setOnAction(e-> {
			YambForm.pickDices(dices, chk);
			b3.setText(String.valueOf(CheckResult.checkNumber(dices, 3)));
			b3.setDisable(true);
			resetAfter3roll(dices, roll, chk);
			z16.setText(String.valueOf(SumResult.sumNumber(b1, b2, b3, b4, b5, b6)));
		});
		
		b4.setOnAction(e-> {
			YambForm.pickDices(dices, chk);
			b4.setText(String.valueOf(CheckResult.checkNumber(dices, 4)));
			b4.setDisable(true);
			resetAfter3roll(dices, roll, chk);
			z16.setText(String.valueOf(SumResult.sumNumber(b1, b2, b3, b4, b5, b6)));
		});
		
		b5.setOnAction(e-> {
			YambForm.pickDices(dices, chk);
			b5.setText(String.valueOf(CheckResult.checkNumber(dices, 5)));
			b5.setDisable(true);
			resetAfter3roll(dices, roll, chk);
			z16.setText(String.valueOf(SumResult.sumNumber(b1, b2, b3, b4, b5, b6)));
		});
		
		b6.setOnAction(e-> {
			YambForm.pickDices(dices, chk);
			b6.setText(String.valueOf(CheckResult.checkNumber(dices, 6)));
			b6.setDisable(true);
			resetAfter3roll(dices, roll, chk);
			z16.setText(String.valueOf(SumResult.sumNumber(b1, b2, b3, b4, b5, b6)));
		});
		
		nizButtona.add(b1);//0
		nizButtona.add(b2);
		nizButtona.add(b3);
		nizButtona.add(b4);
		nizButtona.add(b5);
		nizButtona.add(b6);
		nizButtona.add(max);//6
		nizButtona.add(min);//7
		nizButtona.add(kenta);
		nizButtona.add(triling);
		nizButtona.add(full);
		nizButtona.add(poker);
		nizButtona.add(yamb);//12
		
		vb.getChildren().addAll(b, b1, b2, b3, b4, b5, b6, z16, max, min, zMaxMin, kenta, triling, full, poker, yamb, zKentaYamb);
	}
	//++++++++++++++++++++++++++
	protected void resetAfter3roll(ArrayList<Dice> dices, Button roll, ArrayList<CheckBox> chk)
	{
		YambForm.setBrojPokusaja(0);
		roll.setDisable(false);
		
		for (Dice dice : dices) 
		{
			
			Platform.runLater(() -> dice.setNumber(0));//pri svakom resetu setovane kockice na 0, u suprotnom bi mogli vise puta da upisujemo isti rezultat (jer ostaju upamcenje poslednje kockice)
			Platform.runLater(() -> dice.setBackground(background0));//setujemo "praznu" kockicu
		}
		for (CheckBox c : chk)
		{
			Platform.runLater(() -> c.setSelected(false));
		}
	}
	//broj obelezenih kockica, potrebno je prilikom upisa max i min
	protected int numberOfSelectedDices (ArrayList<Dice> dices)
	{
		int b = 0;
		for (Dice d : dices) 
		{
			if (d.isSelected() == true)
				b++;
		}
		return b;
	}
	//sabira kockice, potrebno je prilikom upisa max i min
	protected int sumMaxMin(ArrayList<Dice> dices)
	{
		int sum = 0;
		if (numberOfSelectedDices(dices) == 5)
		{
			for (Dice dice : dices) 
			{
				if (dice.isSelected() == true)
					sum += dice.getNumber();
			}
		}
		return sum;
	}
	//Klikom na b1 (prilikom unosa rezultata) b2 se prebacuje na enable. Koristi se kod kolona kod kojih imamo pravila za redosled unosa
	public void onButtonClickChangeOtherButtonDisable (Button b1, Button b2)
	{
		b1.setOnMouseClicked(e -> {
			b2.setDisable(false);
		});
	}
	
	protected void ruleFromTop (int start, int end)
	{
		for (int i = start; i < end; i++)
		{
			if (nizButtona.get(i).getText() == "")
				nizButtona.get(i+1).setDisable(true);
			onButtonClickChangeOtherButtonDisable(nizButtona.get(i), nizButtona.get(i+1));
		}
	}
	
	protected void ruleFromBottom (int start, int end)
	{
		for (int i = start; i > end; i--)
		{
			if (nizButtona.get(i).getText() == "")
				nizButtona.get(i-1).setDisable(true);
			onButtonClickChangeOtherButtonDisable(nizButtona.get(i), nizButtona.get(i - 1));
		}
	}
	
	//nakon prvog bacanja kockice polja u coloni hand postavljamo na true.
	public void ruleForHand()
	{
		if (YambForm.getBrojPokusaja() > 0)
		{
			for (Button button : nizButtona) 
			{
				button.setDisable(true);
			}
		}
	}
	//pri prvom bacanju vracamo polja koja su prazna na enable
	public void ruleForHandResetEmptyField()
	{
		if (YambForm.getBrojPokusaja() == 0)
		{
			for (Button button : nizButtona)
			{
				if (button.getText() == "" )
					button.setDisable(false);
			}
		}
	}
	
	protected void ruleForMax()
	{
		
	}

	public VBox getVb() {return vb;}
		
}
