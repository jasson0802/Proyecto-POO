package apiCL;

import java.util.ArrayList;

public final class Clase {
	
	//se utilizan atributos constantes porque si se desea actualizar la informacion de una clase es m�s seguro revisar toda la informaci�n nuevamente
	final private String nombre;
	final private ArrayList<String> superClases; //almacenar� la jerarquia de clases, desde la superclase siguiente hasta Object
	final private ArrayList<String> interfaces; //almacenar� las interfaces de la clase y sus superclases hasta llegar a Object
	final private ArrayList<String> atributos; //almacenar� los atributos de esta clase (modificadores�!tipo�!nombre)
	final private ArrayList<String> constructores; //almacenar� los constructores de la clase de la forma: nombreClase(tipoAtributo,tipoAtributo,...)
	final private ArrayList<String> metodosPropios;  //almacenar� los m�todos de la clase que no fueron heredados de una superclase (modificadores�!tipoRetorno�!nombre�!(parametro,parametro,...))
	final private ArrayList<String> metodosHeredados; //almacenar� los m�todos heredados (superClase�!modificadores�!tipoRetorno�!nombre�!(parametro,parametro,...))
	
	public Clase(	String nombre, ArrayList<String> superClases, ArrayList<String> interfaces,
					ArrayList<String> atributos, ArrayList<String> constructores,
					ArrayList<String> metodosPropios, ArrayList<String> metodosHeredados ) {
		
		this.nombre = nombre;
		this.superClases = superClases;
		this.interfaces = interfaces;
		this.atributos = atributos;
		this.constructores = constructores;
		this.metodosPropios = metodosPropios;
		this.metodosHeredados = metodosHeredados;
		
	}
	
	public String getNombre (){
		
		return this.nombre;
		
	}
	
	/**
	 * @return the superClases
	 */
	public ArrayList<String> getSuperClases() {
		return superClases;
	}

	/**
	 * @return the interfaces
	 */
	public ArrayList<String> getInterfaces() {
		return interfaces;
	}

	/**
	 * @return the atributos
	 */
	public ArrayList<String> getAtributos() {
		return atributos;
	}

	/**
	 * @return the constructores
	 */
	public ArrayList<String> getConstructores() {
		return constructores;
	}

	/**
	 * @return the metodosPropios
	 */
	public ArrayList<String> getMetodosPropios() {
		return metodosPropios;
	}

	/**
	 * @return the metodosHeredados
	 */
	public ArrayList<String> getMetodosHeredados() {
		return metodosHeredados;
	}
		
}
