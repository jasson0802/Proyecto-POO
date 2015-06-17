package interfaz;

import java.io.*;
import java.util.ArrayList;

import apiCL.Clase;

public class EstructuraInformacion {

	public static String crearHTML (ArrayList<Clase> jerarquia) throws IOException{
		

        
        info+=("<html>");
        info+=("<body>");

        //se agrega el título al html
        agregarTitulo("Clases");
        
        for (int x = 0; x < jerarquia.size(); x++){
        	
        	agregarSubTitulo(jerarquia.get(x).getNombre() );
        	
        	agregarSubSubTitulo("SuperClases");
        	
        	//agrega las superclases
			for (int y = 0; y < jerarquia.get(x).getSuperClases().size(); y++){
				
				agregarElemento(jerarquia.get(x).getSuperClases().get(y));
				
			}
			
			agregarSubSubTitulo("Interfaces");
        	
        	//agrega las interfaces
			for (int y = 0; y < jerarquia.get(x).getInterfaces().size(); y++){
				
				agregarElemento(jerarquia.get(x).getInterfaces().get(y) );
				
			}
			
			agregarSubSubTitulo("Atributos");
			
			for (int y = 0; y < jerarquia.get(x).getAtributos().size(); y++){
				
				String [] atributo = jerarquia.get(x).getAtributos().get(y).split("¡!");
				
				agregarElemento(atributo[2] );
				
				//agrega los modificadores
				String [] modificadores = atributo[0].split(" ");
				
				agregarSubElemento ("Modificadores de Acceso" );
				
				for (int z = 0; z < modificadores.length; z++){
					
					agregarSubSubElemento(modificadores[z]);
					
				}
				
				//agregar el tipo
				
				agregarSubElemento(("Tipo: " + atributo[1]));
				
				//agregar el nombre
				agregarSubElemento(("Nombre: " + atributo[2]));
				
			}
			
			agregarSubSubTitulo("Constructores");
			
			//agrega los constructores
			for (int y = 0; y < jerarquia.get(x).getConstructores().size(); y++){
				
				//agregar el nombre
				agregarElemento(jerarquia.get(x).getConstructores().get(y).substring(0, jerarquia.get(x).getConstructores().get(y).indexOf("(")) );
				
				//agregar parametros
				String parametrosUnidos = jerarquia.get(x).getConstructores().get(y).substring(jerarquia.get(x).getConstructores().get(y).indexOf("(")+1,jerarquia.get(x).getConstructores().get(y).length()-1);
				String[] parametros = parametrosUnidos.split(",");
				
				agregarSubElemento("Parametros" );
				
				for (int z = 0; z < parametros.length; z++){
					
					agregarSubSubElemento(parametros[z] );
					
				}				
				
			}
			
			agregarSubSubTitulo("Metodos No Heredados");
			
			//agrega los metodos propios de la clase (no heredados)
			for (int y = 0; y < jerarquia.get(x).getMetodosPropios().size(); y++){
				
				String[] metodo = jerarquia.get(x).getMetodosPropios().get(y).split("¡!");
				
				//agregar el nombre
				agregarElemento(metodo[2] );
				
				//agregar modificadores de acceso
				agregarSubElemento("Modificadores de Acceso" );
				String[] modificadores = metodo[0].split(" ");				
				
				for (int z = 0; z < modificadores.length; z++){
					
					agregarSubSubElemento (modificadores[z] );
					
				}
				
				//agregar el tipo de retorno
				agregarSubElemento(("Tipo de retorno: " + metodo[1]) );
				
				//agregar el nombre
				agregarSubElemento(("Nombre: " + metodo[2]) );
				
				//crear etiqueta de parametros
				agregarSubElemento("Parametros");
				String[] parametros = metodo[0].split(",");
				
				for (int z = 0; z < parametros.length; z++){
					
					agregarSubSubElemento (parametros[z] );
				
				}
				
			}
			
			agregarSubSubTitulo("Metodos Heredados" );
			
			//agrega los metodos heredados
			for (int y = 0; y < jerarquia.get(x).getMetodosHeredados().size(); y++){
				
				String[] metodo = jerarquia.get(x).getMetodosHeredados().get(y).split("¡!");
				
				//agregar metodo
				agregarElemento(metodo[2]);
				
				//agregar superClase de la cual hereda el metodo
				agregarSubElemento (("Heredado de " + metodo[0]) );
				
				//crear etiqueta de modificadores de acceso
				agregarSubElemento ("Modificadores de Acceso" );
				String[] modificadores = metodo[1].split(" ");
				
				for (int z = 0; z < modificadores.length; z++){
					
					agregarSubSubElemento (modificadores[z] );
					
				}
				
				//agregar el tipo de retorno
				agregarSubElemento(("Tipo de retorno: " + metodo[1]) );
				
				//agregar el nombre
				agregarSubElemento(("Nombre: " + metodo[2]) );
				
				//crear etiqueta de parametros
				agregarSubElemento("Parametros" );
				String[] parametros = metodo[3].split(",");
				
				for (int z = 0; z < parametros.length; z++){
					
					agregarSubSubElemento(parametros[z] );					
				}
				
			}
        	
        }

        info+=("</text" + "area>");
        info+=("</body>");
        info+=("</html>");

        
        
        return (info);
		
	}
	
	
	public static String info = "";
	
	private static void agregarTitulo (String titulo ) throws IOException{
		
		String line = "<h1>" + titulo + "</h1>"; 
        info+=line;
        
		
	}
	
	private static void agregarSubTitulo (String subTitulo ) throws IOException{
		
		String line = "<h2><pre>    " + subTitulo + "</pre></h2>"; 
        info+=(line);
        
		
	}
	
	private static void agregarSubSubTitulo (String subSubTitulo ) throws IOException{
		
		String line = "<h3><pre>        " + subSubTitulo + "</pre></h3>"; 
        info+=(line);
 
		
	}
	
	private static void agregarElemento (String elemento ) throws IOException{
		
		String line = "<p><pre><i><b>            " + elemento + "</b></i></pre></p>"; 
        info+=(line);
        
		
	}
	
	private static void agregarSubElemento (String subElemento ) throws IOException{
		
		String line = "<p><pre>                " + subElemento + "</pre></p>"; 
        info+=(line);
        
		
	}
	
	private static void agregarSubSubElemento (String subSubElemento) throws IOException{
		
		String line = "<p><pre><kbd>                    " + subSubElemento + "</kbd></pre></p>"; 
        info+=(line);
        
		
	}
	
	

}
