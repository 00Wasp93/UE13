package UE13;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner; 

public class A2_TempTableCelFahr {
	
	static boolean isExistingTempTable;
	
	private void calculateTempTable() { 
		PrintWriter pWriter = null;
		
		try {
			pWriter = new PrintWriter(new BufferedWriter(new FileWriter("tempTable.txt")),true);
			pWriter.printf("°C \t °F%n");
		
		for( int tempCel= -20; tempCel < 31; tempCel++ ) {
			pWriter.printf("%d \t %d%n",tempCel, (tempCel*9)/5+32);
		}
		
		} catch (IOException ioe) {
            ioe.printStackTrace();
		}finally {
            if (pWriter != null){
                pWriter.flush();
                pWriter.close();
            }
        }
    }
	
	static private boolean validateTempTable() {
		Path table = FileSystems.getDefault().getPath("C:\\Users\\Marcel Necker\\eclipse-workspace\\BolesDietrich", "tempTable.txt");
		isExistingTempTable = Files.exists( table );
		return isExistingTempTable;
	}
	
	static private void createTempTable() {
		String yesOrNo;
		
		A2_TempTableCelFahr tempTable = new A2_TempTableCelFahr(); 
		
		tempTable.calculateTempTable();
		
		validateTempTable();
		
		if( isExistingTempTable ) {
			System.out.println( "Die Tempteratutabelle wurde erfolgreich erstellt." );
		}	
		else {
			System.out.println( "Hopla, Etwas ist schiefgelaufen. Soll es nocheinmal versucht werden? Tippe J or N?");
			yesOrNo = new Scanner( System.in ).next();
			
			if( yesOrNo.toLowerCase() == "j" )
				createTempTable();
			else
				System.exit(0);
		}
		
	}
	
	
	public static void main( String[] args ) {
		createTempTable() ;
		
	}
}

