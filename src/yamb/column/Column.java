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
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import yamb.ButtonField;
import yamb.CheckResult;
import yamb.Dice;
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
		//setujemo polja koja trebaju da budu disablovana
		b.setDisable(true);
		b.setPrefSize(60, 50);
		Image diceImage = new Image("Kockice/ColumnFree.png");
	    BackgroundImage backgroundImage = new BackgroundImage(diceImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);
        b.setBackground(background);
		z16.setDisable(true);
		zMaxMin.setDisable(true);
		zKentaYamb.setDisable(true);
		
		
		kenta.setOnAction(e -> {
				YambForm.pickDices(dices, chk);
				kenta.setText(String.valueOf(CheckResult.checkKenta(dices, YambForm.getBrojPokusaja())));
				kenta.setDisable(true);
				resetAfter3roll(dices, roll, chk);
		});
		
		triling.setOnAction(e -> {
				
				YambForm.pickDices(dices, chk);
				triling.setText(String.valueOf(CheckResult.checkTriling(dices)));
				triling.setDisable(true);
				resetAfter3roll(dices, roll, chk);
		});
		
		full.setOnAction(e -> {
				YambForm.pickDices(dices, chk);
				full.setText(String.valueOf(CheckResult.checkFull(dices)));
				full.setDisable(true);
				resetAfter3roll(dices, roll, chk);
		});
		
		poker.setOnAction(e -> {
				YambForm.pickDices(dices, chk);
				poker.setText(String.valueOf(CheckResult.checkPoker(dices)));
				poker.setDisable(true);
				resetAfter3roll(dices, roll, chk);
		});
		
		yamb.setOnAction(e -> {
				YambForm.pickDices(dices, chk);
				yamb.setText(String.valueOf(CheckResult.checkYamb(dices)));
				yamb.setDisable(true);
				resetAfter3roll(dices, roll, chk);
		});
		
		max.setOnAction(e -> {
			YambForm.pickDices(dices, chk);
			if (numberOfSelectedDices(dices) == 5)
			{
				max.setText(String.valueOf(sumMaxMin(dices)));
				max.setDisable(true);
				resetAfter3roll(dices, roll, chk);
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
		});
		
		b2.setOnAction(e-> {
			YambForm.pickDices(dices, chk);
			b2.setText(String.valueOf(CheckResult.checkNumber(dices, 2)));
			b2.setDisable(true);
			resetAfter3roll(dices, roll, chk);
		});
		
		b3.setOnAction(e-> {
			YambForm.pickDices(dices, chk);
			b3.setText(String.valueOf(CheckResult.checkNumber(dices, 3)));
			b3.setDisable(true);
			resetAfter3roll(dices, roll, chk);
		});
		
		b4.setOnAction(e-> {
			YambForm.pickDices(dices, chk);
			b4.setText(String.valueOf(CheckResult.checkNumber(dices, 4)));
			b4.setDisable(true);
			resetAfter3roll(dices, roll, chk);
		});
		
		b5.setOnAction(e-> {
			YambForm.pickDices(dices, chk);
			b5.setText(String.valueOf(CheckResult.checkNumber(dices, 5)));
			b5.setDisable(true);
			resetAfter3roll(dices, roll, chk);
		});
		
		b6.setOnAction(e-> {
			YambForm.pickDices(dices, chk);
			b6.setText(String.valueOf(CheckResult.checkNumber(dices, 6)));
			b6.setDisable(true);
			resetAfter3roll(dices, roll, chk);
		});
		
		//ubacujemo u niz buttone da bi kasnije lakse mogli da definisemo rule za upis rezultata (preko for petlje) u suprotnom bi morali rucno da pisemo za svako polje
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
		
		//setujemo izgled polja za sumu
		z16.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(1))));
		z16.setStyle("-fx-background-color: white");
		zMaxMin.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(1))));
		zMaxMin.setStyle("-fx-background-color: white");
		zKentaYamb.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(1))));
		zKentaYamb.setStyle("-fx-background-color: white");
		
		vb.getChildren().addAll(b, b1, b2, b3, b4, b5, b6, z16, max, min, zMaxMin, kenta, triling, full, poker, yamb, zKentaYamb);
	}
	
	//nakon 3 bacanja kockice i upisa rezultata bacanje je ponovo omoguceno i kockice su podesene na 0 kao i svi checkboxovi su odcekirani
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
			for (Dice dice : dices) 
				if (dice.isSelected() == true)
					sum += dice.getNumber();
		return sum;
	}
	
	//Klikom na b1 (prilikom unosa rezultata) b2 se prebacuje na enable. Koristi se kod kolona kod kojih imamo pravila za redosled unosa. Metode ruleFromTop i ruleFromBottom
	private void onButtonClickChangeOtherButtonDisable (Button b1, Button b2)
	{
		b1.setOnMouseClicked(e -> b2.setDisable(false));
	}
	
	//prvo polje je omoguceno a sva ostala ispod su onemogucene dokle god je prvo polje prazno. Kada se prvo polje popuni onda prvo sledece polje postaje omoguceno
	//polja idu od gore ka dole
	protected void ruleFromTop (int start, int end)
	{
		for (int i = start; i < end; i++)
		{
			if (nizButtona.get(i).getText() == "")
				nizButtona.get(i+1).setDisable(true);
			onButtonClickChangeOtherButtonDisable(nizButtona.get(i), nizButtona.get(i+1));
		}
	}
	
	//prvo polje je omoguceno a sva ostala ispod su onemogucene dokle god je prvo polje prazno. Kada se prvo polje popuni onda prvo sledece polje postaje omoguceno
	//polja idu od dole ka gore
	protected void ruleFromBottom (int start, int end)
	{
		for (int i = start; i > end; i--)
		{
			if (nizButtona.get(i).getText() == "")
				nizButtona.get(i-1).setDisable(true);
			onButtonClickChangeOtherButtonDisable(nizButtona.get(i), nizButtona.get(i - 1));
		}
	}
	
	//nakon prvog bacanja kockice polja u koloni hand postavljamo na true. Pozivamo prilikom bacanja kockica
	public void ruleForHand()
	{
		if (YambForm.getBrojPokusaja() > 0)
			for (Button button : nizButtona) 
				button.setDisable(true);
	}
	
	//pri prvom bacanju vracamo polja u koloni hand koja su prazna na enable. Pozivamo prilikom bacanja kockica
	public void ruleForHandResetEmptyField()
	{
		if (YambForm.getBrojPokusaja() == 0)
			for (Button button : nizButtona)
				if (button.getText() == "" )
					button.setDisable(false);
	}
	
	public VBox getVb() {return vb;}
	public ButtonField getZ16() {return z16;}
	public ButtonField getzMaxMin() {return zMaxMin;}
	public ButtonField getzKentaYamb() {return zKentaYamb;}
	public ButtonField getB1() {return b1;}
	public ButtonField getB2() {return b2;}
	public ButtonField getB3() {return b3;}
	public ButtonField getB4() {return b4;}
	public ButtonField getB5() {return b5;}
	public ButtonField getB6() {return b6;}
	public ButtonField getMax() {return max;}
	public ButtonField getMin() {return min;}
	public ButtonField getKenta() {return kenta;}
	public ButtonField getTriling() {return triling;}
	public ButtonField getFull() {return full;}
	public ButtonField getPoker() {return poker;}
	public ButtonField getYamb() {return yamb;}
}
