package principal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entidades.usuarios;

public class ehv {
	
	List<usuarios> listaUsu = new ArrayList<usuarios>();    

    //FICHERO
    
    File fichero = null;
    FileReader fr = null;
    BufferedReader br = null;
    {
    try {
    	
        fichero = new File("C:\\Users\\csi22\\eclipse-workspace\\fichero.txt"); //directorio  direccion de memoria            
        fr = new FileReader(fichero);   //abre el fichero desde el directorio 'fichero'
        br = new BufferedReader(fr);    //le pasamos el reader
        
        String linea;
        String[] vCampos;
        Integer num=0;
        int i=0;
        
        while((linea=br.readLine())!=null) {
            
            //System.out.println(linea);
            vCampos=linea.split(";");
            
            num = Integer.decode(vCampos[2]);

            listaUsu.add(new usuarios());
            
            i++;
        }
        
    }
    
    catch(FileNotFoundException fnge){
        System.out.println("error  fichero no encontrado "+ fnge);
    }
    
    catch(IOException ioex) 
    {
        System.out.println("errorr linea "+ioex);                    
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
                System.out.println("errorr linea "+ioex);                    
            }
    }
    System.out.println(listaUsu);  
}
}