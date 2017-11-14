package UE13;

import java.util.Locale;
import java.util.Scanner;


public class A1_CelsiusToFahrenheit {

	static double tempFahr;
	
	private static double calculateCelsiusToFahrenheit( double tempCel ) {
		tempFahr = (tempCel*9)/5+32;
		return tempFahr; 
	}
	
	
	public static void main( String[] args ) {
		
		System.out.println("Temperatur in Celsius:");
		
		double tempCel = new Scanner( System.in ).useLocale( Locale.ENGLISH ).nextDouble();
		
		calculateCelsiusToFahrenheit( tempCel );
		
		System.out.println(tempCel + "°C sind " + tempFahr +"°F." );
	}

}
