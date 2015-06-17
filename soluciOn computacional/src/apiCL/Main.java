package apiCL;

import interfaz.MenuPrincipal;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

public final class Main {
	
	//static Introspeccion apiCL = new Introspeccion();
	
	public static void main(String[] args) throws ClassNotFoundException, ParserConfigurationException, TransformerException, FileNotFoundException {
		
//		String clase = "Persona";
//		
//		ArrayList<String> temp = Introspeccion.buscarEnPaquetes(clase);
//		
//		ArrayList<Clase> jerarquia = new ArrayList<Clase>(); 
//		
//		jerarquia.add(Introspeccion.introspeccion(temp.get(0))); //cambiar temp.get(x) por la clase seleccionada por el usuario
//		
//		for (int x = 0; x < jerarquia.get(0).getSuperClases().size(); x++){
//			
//			jerarquia.add(Introspeccion.introspeccion(jerarquia.get(0).getSuperClases().get(x)));
//			
//		}
//		
//		CreadorXML.crearXML(jerarquia);
//		
		MenuPrincipal menu = new MenuPrincipal();
		menu.setVisible(true);
	}
	
	
	
	
	
}