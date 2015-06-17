package apiCL;

import java.io.*;
import java.util.ArrayList;

public class CreadorHtml {

	public static String crearHTML (ArrayList<Clase> jerarquia) throws IOException{
		
		File f = new File(jerarquia.get(0).getNombre() + ".html");
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        bw.write("<html>");
        bw.write("<body>");

        //se agrega el título al html
        agregarTitulo("Clases", bw);
        
        for (int x = 0; x < jerarquia.size(); x++){
        	
        	agregarSubTitulo(jerarquia.get(x).getNombre(), bw);
        	
        	agregarSubSubTitulo("SuperClases", bw);
        	
        	//agrega las superclases
			for (int y = 0; y < jerarquia.get(x).getSuperClases().size(); y++){
				
				agregarElemento(jerarquia.get(x).getSuperClases().get(y), bw);
				
			}
			
			agregarSubSubTitulo("Interfaces", bw);
        	
        	//agrega las interfaces
			for (int y = 0; y < jerarquia.get(x).getInterfaces().size(); y++){
				
				agregarElemento(jerarquia.get(x).getInterfaces().get(y), bw);
				
			}
			
			agregarSubSubTitulo("Atributos", bw);
			
			for (int y = 0; y < jerarquia.get(x).getAtributos().size(); y++){
				
				String [] atributo = jerarquia.get(x).getAtributos().get(y).split("¡!");
				
				agregarElemento(atributo[2], bw);
				
				//agrega los modificadores
				String [] modificadores = atributo[0].split(" ");
				
				agregarSubElemento ("Modificadores de Acceso", bw);
				
				for (int z = 0; z < modificadores.length; z++){
					
					agregarSubSubElemento(modificadores[z], bw);
					
				}
				
				//agregar el tipo
				
				agregarSubElemento(("Tipo: " + atributo[1]), bw);
				
				//agregar el nombre
				agregarSubElemento(("Nombre: " + atributo[2]), bw);
				
			}
			
			agregarSubSubTitulo("Constructores", bw);
			
			//agrega los constructores
			for (int y = 0; y < jerarquia.get(x).getConstructores().size(); y++){
				
				//agregar el nombre
				agregarElemento(jerarquia.get(x).getConstructores().get(y).substring(0, jerarquia.get(x).getConstructores().get(y).indexOf("(")), bw);
				
				//agregar parametros
				String parametrosUnidos = jerarquia.get(x).getConstructores().get(y).substring(jerarquia.get(x).getConstructores().get(y).indexOf("(")+1,jerarquia.get(x).getConstructores().get(y).length()-1);
				String[] parametros = parametrosUnidos.split(",");
				
				agregarSubElemento("Parametros", bw);
				
				for (int z = 0; z < parametros.length; z++){
					
					agregarSubSubElemento(parametros[z], bw);
					
				}				
				
			}
			
			agregarSubSubTitulo("Metodos No Heredados", bw);
			
			//agrega los metodos propios de la clase (no heredados)
			for (int y = 0; y < jerarquia.get(x).getMetodosPropios().size(); y++){
				
				String[] metodo = jerarquia.get(x).getMetodosPropios().get(y).split("¡!");
				
				//agregar el nombre
				agregarElemento(metodo[2], bw);
				
				//agregar modificadores de acceso
				agregarSubElemento("Modificadores de Acceso", bw);
				String[] modificadores = metodo[0].split(" ");				
				
				for (int z = 0; z < modificadores.length; z++){
					
					agregarSubSubElemento (modificadores[z], bw);
					
				}
				
				//agregar el tipo de retorno
				agregarSubElemento(("Tipo de retorno: " + metodo[1]), bw);
				
				//agregar el nombre
				agregarSubElemento(("Nombre: " + metodo[2]), bw);
				
				//crear etiqueta de parametros
				agregarSubElemento("Parametros", bw);
				String[] parametros = metodo[0].split(",");
				
				for (int z = 0; z < parametros.length; z++){
					
					agregarSubSubElemento (parametros[z], bw);
				
				}
				
			}
			
			agregarSubSubTitulo("Metodos Heredados", bw);
			
			//agrega los metodos heredados
			for (int y = 0; y < jerarquia.get(x).getMetodosHeredados().size(); y++){
				
				String[] metodo = jerarquia.get(x).getMetodosHeredados().get(y).split("¡!");
				
				//agregar metodo
				agregarElemento(metodo[2],bw);
				
				//agregar superClase de la cual hereda el metodo
				agregarSubElemento (("Heredado de " + metodo[0]), bw);
				
				//crear etiqueta de modificadores de acceso
				agregarSubElemento ("Modificadores de Acceso", bw);
				String[] modificadores = metodo[1].split(" ");
				
				for (int z = 0; z < modificadores.length; z++){
					
					agregarSubSubElemento (modificadores[z], bw);
					
				}
				
				//agregar el tipo de retorno
				agregarSubElemento(("Tipo de retorno: " + metodo[1]), bw);
				
				//agregar el nombre
				agregarSubElemento(("Nombre: " + metodo[2]), bw);
				
				//crear etiqueta de parametros
				agregarSubElemento("Parametros", bw);
				String[] parametros = metodo[3].split(",");
				
				for (int z = 0; z < parametros.length; z++){
					
					agregarSubSubElemento(parametros[z], bw);					
				}
				
			}
        	
        }

        bw.write("</text" + "area>");
        bw.write("</body>");
        bw.write("</html>");

        bw.close();
        
        return (new java.io.File(".").getCanonicalPath());
		
	}
	
	private static void agregarTitulo (String titulo, BufferedWriter bw) throws IOException{
		
		String line = "<h1>" + titulo + "</h1>"; 
        bw.write(line);
        bw.newLine();
		
	}
	
	private static void agregarSubTitulo (String subTitulo, BufferedWriter bw) throws IOException{
		
		String line = "<h2><pre>    " + subTitulo + "</pre></h2>"; 
        bw.write(line);
        bw.newLine();
		
	}
	
	private static void agregarSubSubTitulo (String subSubTitulo, BufferedWriter bw) throws IOException{
		
		String line = "<h3><pre>        " + subSubTitulo + "</pre></h3>"; 
        bw.write(line);
        bw.newLine();
		
	}
	
	private static void agregarElemento (String elemento, BufferedWriter bw) throws IOException{
		
		String line = "<p><pre><i><b>            " + elemento + "</b></i></pre></p>"; 
        bw.write(line);
        bw.newLine();
		
	}
	
	private static void agregarSubElemento (String subElemento, BufferedWriter bw) throws IOException{
		
		String line = "<p><pre>                " + subElemento + "</pre></p>"; 
        bw.write(line);
        bw.newLine();
		
	}
	
	private static void agregarSubSubElemento (String subSubElemento, BufferedWriter bw) throws IOException{
		
		String line = "<p><pre><kbd>                    " + subSubElemento + "</kbd></pre></p>"; 
        bw.write(line);
        bw.newLine();
		
	}
	
	

}
