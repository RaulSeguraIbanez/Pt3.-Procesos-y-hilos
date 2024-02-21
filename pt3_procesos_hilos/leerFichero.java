package pt3_procesos_hilos;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class leerFichero {
	
	public static void leerFichero(String ficheroTxt) {
		
		try {
			FileReader fr = new FileReader(ficheroTxt);
			BufferedReader br = new BufferedReader(fr);
			String stringMatriz1 = br.readLine();
			String stringMatriz2 = br.readLine();
			
			br.close();
			fr.close();
			
			main.crearMatricesBase(stringMatriz1, stringMatriz2);
			
		}catch(IOException e) {
			System.out.println("No se ha encontrado el fichero");
		}
	}
}
