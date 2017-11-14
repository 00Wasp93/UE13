package UE13;

/**
 * BMI Calculator with feedback.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class A4_5_BMICalculator {
	 static int 		 age;
	 static double 		 weigth;
	 static double 		 heigth;
	 static double 		 amputationValue;
	 static final double hand 		   = 0.8; 
	 static final double unterarm 	   = 2.2;
	 static final double oberarm 	   = 3.5; 
	 static final double fu� 		   = 1.8; 
	 static final double unterschenkel = 5.3; 
	 static final double oberschenkel  = 11.6; 
	
	 
	private static void inputAgeHeigthWeigth() { 
		
		System.out.println("Wie alt sind Sie?");
		
		age = new Scanner( System.in ).nextInt();
		
		System.out.println("Wie gro� sind Sie (in Metern)?");
		
		heigth = new Scanner( System.in ).useLocale( Locale.ENGLISH ).nextDouble();
		
		System.out.println("Was zeigt die Waage morgens an?");
		
		weigth = new Scanner( System.in ).useLocale( Locale.ENGLISH ).nextDouble();
		
		System.out.printf("Sie sind %d Jahre alt, sind %s gro� und wiegen %s kg.%n", age, heigth, weigth);
	}
	
	private static double handleAmputation() {
		System.out.println("Verf�gen Sie �ber Amputationen? J / N ?");
		
		String yesOrNo = new Scanner( System.in ).next().toLowerCase();
		
		switch( yesOrNo ) {
		case "j" : inputAmputations(); break;
		case "n" : amputationValue = 0; break;
		}
		
		return amputationValue;
	} 
	
	private static double inputAmputations() {
		System.out.println("Wie viele H�nde wurden Ihnen abgenommen?");
		amputationValue = new Scanner( System.in ).nextInt()*hand;
		
		System.out.println("Wie viele Oberarme wurden Ihnen abgenommen?");
		amputationValue += new Scanner( System.in ).nextInt()*oberarm;
		
		System.out.println("Wie viele Unterarme wurden Ihnen abgenommen?");
		amputationValue += new Scanner( System.in ).nextInt()*unterarm;
		
		System.out.println("Wie viele F��e wurden Ihnen abgenommen?");
		amputationValue += new Scanner( System.in ).nextInt()*fu�;
		
		System.out.println("Wie viele Oberschenkel wurden Ihnen abgenommen?");
		amputationValue += new Scanner( System.in ).nextInt()*oberschenkel;
		
		System.out.println("Wie viele Unterschenkel wurden Ihnen abgenommen?");
		amputationValue += new Scanner( System.in ).nextInt()*unterschenkel;
		
		return amputationValue;
	}
	
	static void calculateBMI( int age, double heigth, double weigth ) {
		
		handleAmputation();
		
		int BMI = (int) (((weigth*100)/(100 - amputationValue)) / (heigth*heigth));
		
		System.out.printf("Ihr BMI betr�gt: %s%n", BMI);
		
		evaluateBMI( BMI, age );
	}
	
	private static void evaluateBMI( int BMI, int age ) {
	/****************************************************
	 *        Alter    BMI 
	 *    < 25 Jahre  19-24 
     *   25-64 Jahre  22-27 
     *    > 64 Jahre  24-29	
	 *****************************************************/
		if( age < 25 ) {
			
			if( BMI < 19 )
				System.out.println("Ihr BMI ist zu niedrig. G�nnen Sie sich eine fette Pizza."); 
			else if( BMI > 24 )
				System.out.println("Ihr BMI ist zu hoch. Vezichten Sie auf die n�chste Pizza."); 
			else 
				System.out.println("Ihr BMI liegt im gr�nen Bereich. Gl�ckwunsch!"); 
			}
		
		else if( age > 24 && age < 65 ) {
			
			if( BMI < 22 )
				System.out.println("Ihr BMI ist zu niedrig. G�nnen Sie sich eine fette Pizza."); 
			else if( BMI > 27 )
				System.out.println("Ihr BMI ist zu hoch. Vezichten Sie auf die n�chste Pizza."); 
			else 
				System.out.println("Ihr BMI liegt im gr�nen Bereich. Gl�ckwunsch!"); 
		}
		
		else {
			
			if( BMI < 24 )
				System.out.println("Ihr BMI ist zu niedrig. G�nnen Sie sich eine fette Pizza."); 
			else if( BMI > 29 )
				System.out.println("Ihr BMI ist zu hoch. Vezichten Sie auf die n�chste Pizza."); 
			else 
				System.out.println("Ihr BMI liegt im gr�nen Bereich. Gl�ckwunsch!"); 
		}
	}
		
	public static void main(String[] args ) {
		System.out.println("M�chten Sie Ihren BMI berechnen? J / N ?" );
		
		String yesOrNo = new Scanner( System.in ).next().toLowerCase();
		
		if( yesOrNo.equals( "j" ) ) {
			
			while( true ) {
				
				inputAgeHeigthWeigth();
			
				calculateBMI( age, heigth, weigth );
				
				System.out.println("M�chten Sie Ihren BMI erneut berechnen? J / N ? " );
				
				yesOrNo = new Scanner( System.in ).next().toLowerCase();
				
				if( yesOrNo.equals( "n" ) ) {
					System.out.println("Ok. Bis zum n�chten Mal.");
					System.exit(0);
				}	
			}
			
		} else {
			
			System.out.println("Ok. Bis zum n�chten Mal.");
			System.exit(0);
		}
		
	}
}
