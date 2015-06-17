package apiCL;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public final class Introspeccion {
	
	private static String[] paquetes;
	
	public Introspeccion() {

		setPaquetes();
		
	}

	private static void setPaquetes (){

		File fichero = new File("bin");
		paquetes = fichero.list();
		
	}
	
	public static String[] getPaquetes () {
		
		return paquetes;
		
	}
	
	@SuppressWarnings("unused")
	public static ArrayList<String> buscarEnPaquetes (String clase) {
		
		ArrayList<String> paquetesPoseedores = new ArrayList<String>(); //se guardaran en una lista las clases con el nombre recibido que existen
																		// de la forma "paqueteAlQuePertenece.clase
		
		for (int x = 0; x < paquetes.length; x++) {
			
			try {
				@SuppressWarnings("rawtypes")
				Class claseActual = Class.forName(paquetes[x] + "." + clase);
				paquetesPoseedores.add(paquetes[x] + "." + clase); //si la clase existe se realiza el try y se guarda el resultado
			} 
			catch (ClassNotFoundException e) {
				//si la clase no existe en este paquete el try no se realiza y se revisa en el siguiente paquete
			}
			
		}		
		
		return paquetesPoseedores;		

	}

	//debe recibir clase luego de buscarla con buscarEnPaquetes
	private static ArrayList<String> getSuperClases (String clase) throws ClassNotFoundException {
		
		@SuppressWarnings("rawtypes")
		Class claseActual = Class.forName(clase);
		ArrayList<String> superClases = new ArrayList<String>();
		
		while (!(clase.equals("java.lang.Object"))){
			superClases.add(claseActual.getSuperclass().getName());
			claseActual = claseActual.getSuperclass();
			clase = claseActual.getName();			
		}
		
		return superClases;		
		
	}

	//debe recibir clase luego de buscarla con buscarEnPaquetes
	@SuppressWarnings("rawtypes")
	private static ArrayList<String> getIntefaces (String clase) throws ClassNotFoundException {

		Class claseActual = Class.forName(clase);
		ArrayList<String> listaInterfaces = new ArrayList<String>();
		
		while (!(clase.equals("java.lang.Object"))){
			
			Class[] interfaces = claseActual.getInterfaces();
			
			for (int x = 0; x < interfaces.length; x++){
				
				listaInterfaces.add(interfaces[x].getName());
				
			}
			
			claseActual = claseActual.getSuperclass();
			clase = claseActual.getName();
			
		}
		
		return listaInterfaces;
		
	}
	
	//debe recibir clase luego de buscarla con buscarEnPaquetes
	@SuppressWarnings("rawtypes")
	private static ArrayList<String> getAtributos (String clase) throws ClassNotFoundException {

		Class claseActual = Class.forName(clase);
		ArrayList<String> listaAtributos = new ArrayList<String>(); // almacenara atributos de la forma "modificadores tipo nombre"
				
		Field[] atributos = claseActual.getDeclaredFields(); //arreglo con la informacion de los atributos de la clase
				
		for (int x = 0; x < atributos.length; x++){
				
			String atributo = ""; //variable temporal donde se ordenara adecuadamente la informacion de cada atributo
					
			atributo +=  Modifier.toString(atributos[x].getModifiers()) + "¡!";
			//se procede a recortar la informacion obtenida para mostrarla de la manera requerida por el cliente (por ej. convertir java.lang.String en String)
			atributo += atributos[x].getType().toString().contains(".") ? atributos[x].getType().toString().substring(atributos[x].getType().toString().lastIndexOf(".")+1) : atributos[x].getType().toString();
			atributo += "¡!" + atributos[x].getName();
				
			listaAtributos.add(atributo);
					
		}
			
		return listaAtributos;
			
	}
	
	//debe recibir clase luego de buscarla con buscarEnPaquetes
	@SuppressWarnings("rawtypes")
	private static ArrayList<String> getConstructores (String clase) throws ClassNotFoundException {

		Class claseActual = Class.forName(clase);
		ArrayList<String> listaConstructores = new ArrayList<String>(); // almacenara los constructores
				
		Constructor[] constructores = claseActual.getConstructors(); //arreglo con la informacion de los constructores de la clase
				
		for (int x = 0; x < constructores.length; x++){
				
			String constructor = constructores[x].toGenericString(); //variable temporal donde se ordenara adecuadamente la informacion de cada constructor
			//se reacomoda el constructor según el formato requerido
			constructor = constructor.substring(constructor.indexOf(".")+1);
			constructor = constructor.replace("java.lang.", "");				
			listaConstructores.add(constructor);
					
		}
			
		return listaConstructores;
			
	}
	
	//debe recibir clase luego de buscarla con buscarEnPaquetes
	@SuppressWarnings("rawtypes")
	private static ArrayList<ArrayList<String>> getMetodos (String clase) throws ClassNotFoundException {

		Class claseActual = Class.forName(clase);
		ArrayList<ArrayList<String>> listaMetodos = new ArrayList<ArrayList<String>>(); // almacenara las listas de metodos (listaMetodos.get(0) seran los metodos propios y listaMetodos.get(1) seran los heredados)
		
		ArrayList<String> listaMetodosPropios = new ArrayList<String>(); // almacenara los metodos propios de clase y se guardara en listaMetodos(0)
		ArrayList<String> listaMetodosHeredados = new ArrayList<String>(); // almacenara los metodos heredados de clase y se guardara en listaMetodos(1)
				
		Method[] metodos = claseActual.getMethods(); //arreglo con la informacion de los atributos de la clase
				
		for (int x = 0; x < metodos.length; x++){
			
			if (metodos[x].toGenericString().contains(clase)){
				
				String metodo = ""; //variable temporal donde se ordenara adecuadamente la informacion de cada metodo
				
				metodo +=  Modifier.toString(metodos[x].getModifiers()) + "¡!";
				//se procede a recortar la informacion obtenida para mostrarla de la manera requerida por el cliente (por ej. convertir java.lang.String en String)
				metodo += metodos[x].getReturnType().toString().replace("class java.lang.", "") + "¡!";
				metodo += metodos[x].getName() + "¡!(";
				
				Class<?>[] parametros = metodos[x].getParameterTypes();
				
				for (int y = 0; y < parametros.length; y++){
					
					 metodo += parametros[y].getName().contains(".") ? parametros[y].getName().substring(parametros[y].getName().lastIndexOf(".")+1) : parametros[y].getName() ;
					 metodo += ",";
					
				}
				
				metodo += ")";
				
				listaMetodosPropios.add(metodo);
				
			}
			
			else{
				
				String metodo = ""; //variable temporal donde se ordenara adecuadamente la informacion de cada metodo
				
				metodo += metodos[x].getDeclaringClass().toString().substring(metodos[x].getDeclaringClass().toString().indexOf(" ")+1) + "¡!";
				
				metodo +=  Modifier.toString(metodos[x].getModifiers()) + " ";
				//se procede a recortar la informacion obtenida para mostrarla de la manera requerida por el cliente (por ej. convertir java.lang.String en String)
				metodo += metodos[x].getReturnType().toString().replace("class java.lang.", "") + "¡!";
				metodo += metodos[x].getName() + "¡!(";
				
				Class<?>[] parametros = metodos[x].getParameterTypes();
				
				for (int y = 0; y < parametros.length; y++){
					
					 metodo += parametros[y].getName().contains(".") ? parametros[y].getName().substring(parametros[y].getName().lastIndexOf(".")+1) : parametros[y].getName() ;
					 metodo += ",";
					
				}
				
				metodo += ")";
				
				listaMetodosHeredados.add(metodo);
				
			}
					
		}
		
		listaMetodos.add(listaMetodosPropios);
		listaMetodos.add(listaMetodosHeredados);
			
		return listaMetodos;
			
	}
	
	//debe recibir clase luego de buscarla con buscarEnPaquetes
	public static Clase introspeccion (String clase) throws ClassNotFoundException{
		
		ArrayList<String> superClases, interfaces, atributos, constructores;
		ArrayList<ArrayList<String>> metodos;
		
		superClases = getSuperClases(clase);
		interfaces = getIntefaces(clase);
		atributos = getAtributos(clase);
		constructores = getConstructores(clase);
		metodos = getMetodos(clase);
		
		Clase claseIntrospeccionada = new Clase (clase, superClases, interfaces, atributos, constructores, metodos.get(0), metodos.get(1));
		
		return claseIntrospeccionada;
		
	}
	
}
