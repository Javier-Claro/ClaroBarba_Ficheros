package principal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entidades.usuarios;

public class lectorFichero {

	public static void main(String[] args) { 
		
		//Creamos un ArrayList para guardar la informacion del fichero:
		List<usuarios> bd=new ArrayList<usuarios>();
		
        System.out.println("Leyendo fichero de texto...:\n");

        //Se crean las utilidades de tipo file y buffer:
        File fichero = null;
        FileReader fr = null;
        BufferedReader br = null;
        
        try {
        	
            //Busca el directorio del archivo:
            fichero = new File("C:\\Users\\csi22\\eclipse-workspace\\fichero.txt");  
            
            //Se abre el fichero:
            fr = new FileReader(fichero); 
            
            //Le pasamos el reader:
            br = new BufferedReader(fr);    
            
            String linea;
            String[] vCampos;
            Integer num=0;
            
            while((linea=br.readLine())!=null) {
                
            	//Se dividen los datos que estaban unidos con ';':
                vCampos=linea.split(";");
                
                //Sirve para detectar el campo de números como un tipo int y no como un String:
                num = Integer.decode(vCampos[2]);
                
                //Se añaden los datos al ArrayList como un nuevo usuario:
                bd.add(new usuarios(vCampos[0],vCampos[1],num.intValue()));
               
            }
        }
        
        //Aquí se controlan cualquier error posible a la hora de la búsqueda o lectura del fichero:
        catch(FileNotFoundException fnge){
            System.out.println("error fichero no encontrado "+ fnge);
        }
        
        catch(IOException ioex) 
        {
            System.out.println("error linea "+ioex);                    
        }
        
        finally 
        {
            
                try 
                {                
                    if(null!=fr) {
                        fr.close();
                    }
                }
                    
                catch(IOException ioex) 
                {
                    System.out.println("error linea "+ioex);                    
                }
        }
        
        //Se acaba mostrando por pantalla el ArrayList usándo el método toString:
        System.out.println(bd.toString());        
        
    }
}