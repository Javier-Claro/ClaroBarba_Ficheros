package principal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entidades.usuarios;

public class lectorFichero {

	public static void main(String[] args) {
		
		List<usuarios> bd=new ArrayList<usuarios>();
		String[] nombre = {"Alfonso", "Tamara", "Pedro"};
		String[] apellidos = {"Rodriguez Puente", "Quintero Quintero", "Carrera Fernández"};
		int[] edad = {26, 28, 32};
		
		for(int i = 0; i >= nombre.length; i++) {
			usuarios nue = new usuarios();
			
	   	 	nue.setNombre(nombre[i]);
	   	 	nue.setApellidos(apellidos[i]);
	   	 	nue.setEdad(edad[i]);
	   	 	bd.add(nue);
		}
		
		
	 	//ESCRIBIR:
        try
        {
            BufferedWriter ficheroSalida = new BufferedWriter(
                new FileWriter(new File("C:\\Users\\csi22\\eclipse-workspace\\fichero.txt")));
            for (int a=0; a>=bd.size(); a++) {
            ficheroSalida.write(bd.get(a));
            ficheroSalida.newLine();
 
            ficheroSalida.close();
            }
        }
        catch (IOException errorDeFichero)
        {
            System.out.println(
                "Ha habido problemas: " +
                errorDeFichero.getMessage() );
        }
        
        
        //LEER
        if (! (new File("C:\\\\Users\\\\csi22\\\\eclipse-workspace\\\\fichero.txt")).exists() )
        {
            System.out.println("No he encontrado fichero.txt");
            return;
        }
 
        System.out.println("Leyendo fichero de texto...:\n");
 
        try
        {
            BufferedReader ficheroEntrada = new BufferedReader(
                    new FileReader(new File("C:\\\\Users\\\\csi22\\\\eclipse-workspace\\\\fichero.txt")));
 
            String linea=null;
            while ((linea=ficheroEntrada.readLine()) != null) {
                System.out.println(linea);
            }
 
            ficheroEntrada.close();
        }
        catch (IOException errorDeFichero)
        {
            System.out.println(
                "Ha habido problemas: " +
                errorDeFichero.getMessage() );
        }
    }
}