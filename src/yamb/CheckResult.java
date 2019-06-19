package yamb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CheckResult 
{
	//brojimo koliko ima istih kockica
	private static ArrayList<Integer> countDices (ArrayList<Dice> dices)
	{
		Integer number1 = 0;
		Integer number2 = 0;
		Integer number3 = 0;
		Integer number4 = 0;
		Integer number5 = 0;
		Integer number6 = 0;
				
		for (Dice dice : dices) 
		{
			if (dice.getNumber() == 1)
				number1++;
			else if (dice.getNumber() == 2)
				number2++;
			else if (dice.getNumber() == 3)
				number3++;
			else if (dice.getNumber() == 4)
				number4++;
			else if (dice.getNumber() == 5)
				number5++;
			else if (dice.getNumber() == 6)
				number6++;
		}
		ArrayList<Integer> niz = new ArrayList<>();
		niz.add(number1);
		niz.add(number2);
		niz.add(number3);
		niz.add(number4);
		niz.add(number5);
		niz.add(number6);
		
		return niz;
	}
	//smestamo u mapu kockice i broj istih vrednosti kockice
	private static HashMap<Dice, Integer> saveDicesInMap (ArrayList<Dice> dices)
	{
		HashMap<Dice, Integer> mapDice = new HashMap<Dice, Integer>();
		ArrayList<Integer> niz = new ArrayList<>();
		niz = countDices(dices);
		
		for (int i = 0; i < niz.size(); i++)
		{
			mapDice.put(dices.get(i), niz.get(dices.get(i).getNumber() - 1));
		}
		return mapDice;
	}
	
	public static int checkYamb (ArrayList<Dice> dices)
	{
		//ubaceno da ukoliko se ne zavrte kockice ne izbacuje gresku
		if (dices.get(0).getNumber() == 0)
			return 0;
				
		HashMap<Dice, Integer> mapDice = new HashMap<Dice, Integer>();
		mapDice = saveDicesInMap(dices);
		int sum = 0;
		for (Map.Entry<Dice, Integer> e : mapDice.entrySet())
		{
			if (e.getValue() >= 5)
				sum = e.getKey().getNumber() * 5 + 50;
		}
		return sum;
	}
	public static int checkPoker (ArrayList<Dice> dices)
	{
		//ubaceno da ukoliko se ne zavrte kockice ne izbacuje gresku
		if (dices.get(0).getNumber() == 0)
			return 0;
		
		HashMap<Dice, Integer> mapDice = new HashMap<Dice, Integer>();
		mapDice = saveDicesInMap(dices);
		int sum = 0;
		for (Map.Entry<Dice, Integer> e : mapDice.entrySet())
		{
			if (e.getValue() >= 4)
				sum = e.getKey().getNumber() * 4 + 40;
		}
		return sum;
	}
	public static int checkTriling (ArrayList<Dice> dices)
	{
		//ubaceno da ukoliko se ne zavrte kockice ne izbacuje gresku
		if (dices.get(0).getNumber() == 0)
			return 0;
		
		HashMap<Dice, Integer> mapDice = new HashMap<Dice, Integer>();
		mapDice = saveDicesInMap(dices);
		int sum = 0;
		for (Map.Entry<Dice, Integer> e : mapDice.entrySet())
		{
			if (e.getValue() >= 3)
				sum = e.getKey().getNumber() * 3 + 20;
		}
		
		return sum;
	}
	
	public static int checkFull (ArrayList<Dice> dices)
	{
		//ubaceno da ukoliko se ne zavrte kockice ne izbacuje gresku
		if (dices.get(0).getNumber() == 0)
			return 0;
		
		HashMap<Dice, Integer> mapDice = new HashMap<Dice, Integer>();
		mapDice = saveDicesInMap(dices);
		int sum = 0;
		int sum3 = 0;
		int sum2 = 0;
		for (Map.Entry<Dice, Integer> e : mapDice.entrySet())
		{
			if (e.getValue() >= 3)
				sum3 = e.getKey().getNumber() * 3;
			if (e.getValue() == 2)
				sum2 = e.getKey().getNumber() * 2;
		}
		if (sum3 != 0 && sum2 != 0)
			sum = sum3 + sum2 + 30;
		
		return sum;
	}
	public static int checkKenta (ArrayList<Dice> dices, int numberOfRoll)
	{
		//ubaceno da ukoliko se ne zavrte kockice ne izbacuje gresku
		if (dices.get(0).getNumber() == 0)
			return 0;
				
		int sum = 0;
		boolean kenta = false;
		int numberOfDifferent = 0;
		
		ArrayList<Integer> niz = new ArrayList<>();
		niz = countDices(dices);
		
		for (int i = 0; i < niz.size(); i++)
		{
			if (niz.get(i) == 1 || niz.get(i) == 2)
				numberOfDifferent++;
		}
		if (numberOfDifferent >= 5 && (niz.get(1) >= 1 && niz.get(2) >= 1 && niz.get(3) >= 1 && niz.get(4) >= 1))
			kenta = true;
		
		if (kenta == true)
		{
			if (numberOfRoll == 1)
				sum = 66;
			else if (numberOfRoll == 2)
				sum = 56;
			else
				sum = 46;
		}
		return sum;
	}
	
	//u nizu kockica proveravamo da li ima odredjeni broj i ako ima racunamo sumu tog istog broja
	public static int checkNumber (ArrayList<Dice> dices, int number)
	{
		//ubaceno da ukoliko se ne zavrte kockice ne izbacuje gresku
		if (dices.get(0).getNumber() == 0)
			return 0;
		
		HashMap<Dice, Integer> mapDice = new HashMap<Dice, Integer>();
		mapDice = saveDicesInMap(dices);
		int sum = 0;
		for (Map.Entry<Dice, Integer> e : mapDice.entrySet())
		{
			if (e.getKey().getNumber() == number)
				sum += e.getKey().getNumber();
				//sum = e.getValue() * number;
		}
		if (sum == (6*number))
			sum = 5*number;
		return sum;
	}
}
