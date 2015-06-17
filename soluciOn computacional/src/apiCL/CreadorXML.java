package apiCL;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public final class CreadorXML {
	
	public static String crearXML (ArrayList<Clase> jerarquia) throws ParserConfigurationException, TransformerException, IOException{
		
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		
		// clases
		Document doc = docBuilder.newDocument();
		Element clases = doc.createElement("Clases");
		doc.appendChild(clases);
		
		for (int x = 0; x < jerarquia.size(); x++){
			
			Element clase = doc.createElement(jerarquia.get(x).getNombre());
			
			Element superClases = doc.createElement("Superclases");
			
			//agrega las superclases
			for (int y = 0; y < jerarquia.get(x).getSuperClases().size(); y++){
				
				Element superClase = doc.createElement(jerarquia.get(x).getSuperClases().get(y));
				superClases.appendChild(superClase);
				
			}
			
			clase.appendChild(superClases);
			
			Element interfaces = doc.createElement("Interfaces");
			
			//agrega las interfaces
			for (int y = 0; y < jerarquia.get(x).getInterfaces().size(); y++){
				
				Element interfaz = doc.createElement(jerarquia.get(x).getInterfaces().get(y));
				interfaces.appendChild(interfaz);
				
			}
			
			clase.appendChild(interfaces);
			
			Element atributos = doc.createElement("Atributos");	
			
			//agrega los atributos
			for (int y = 0; y < jerarquia.get(x).getAtributos().size(); y++){
				
				String [] atributo = jerarquia.get(x).getAtributos().get(y).split("¡!");
				
				Element etiquetaAtributo = doc.createElement(atributo[2]);
				
				//agrega los modificadores
				String [] modificadores = atributo[0].split(" ");
				
				Element etiquetaModificadores = doc.createElement("ModificadoresAcceso");
				
				for (int z = 0; z < modificadores.length; z++){
					
					Element modificador = doc.createElement(modificadores[z]);
					etiquetaModificadores.appendChild(modificador);
					
				}
				
				etiquetaAtributo.appendChild(etiquetaModificadores);
				
				//fin agregar modificadores
				
				//agregar el tipo
				try{
				Element tipo = doc.createElement(atributo[1]);
				etiquetaAtributo.appendChild(tipo);
				}
				catch (org.w3c.dom.DOMException dom){}				
				
				//agregar el nombre
				Element nombre = doc.createElement(atributo[2]);
				etiquetaAtributo.appendChild(nombre);
				
				atributos.appendChild(etiquetaAtributo);
				clase.appendChild(atributos);
				
			}
			
			Element constructores = doc.createElement("Constructores");
			
			//agrega los constructores
			for (int y = 0; y < jerarquia.get(x).getConstructores().size(); y++){
				
				//agregar el nombre
				Element nombre = doc.createElement(jerarquia.get(x).getConstructores().get(y).substring(0, jerarquia.get(x).getConstructores().get(y).indexOf("(")));
				constructores.appendChild(nombre);
				
				//agregar parametros
				String parametrosUnidos = jerarquia.get(x).getConstructores().get(y).substring(jerarquia.get(x).getConstructores().get(y).indexOf("(")+1,jerarquia.get(x).getConstructores().get(y).length()-1);
				String[] parametros = parametrosUnidos.split(",");
				
				Element etiquetaParametros = doc.createElement("Parametros");
				
				for (int z = 0; z < parametros.length; z++){
					
					try { 
						Element parametro = doc.createElement(parametros[z]);
						etiquetaParametros.appendChild(parametro);					
					}
					catch (org.w3c.dom.DOMException dom){}
					
				}				
				
				constructores.appendChild(etiquetaParametros);
				
			}
			
			clase.appendChild(constructores);
			
			Element metodosPropios = doc.createElement("MetodosNoHeredados");
			
			//agrega los metodos propios de la clase (no heredados)
			for (int y = 0; y < jerarquia.get(x).getMetodosPropios().size(); y++){
				
				String[] metodo = jerarquia.get(x).getMetodosPropios().get(y).split("¡!");
				
				//agregar el nombre
				Element etiquetaMetodo = doc.createElement(metodo[2]);
				
				//crear etiqueta de modificadores de acceso
				String[] modificadores = metodo[0].split(" ");
				Element etiquetaModificadores = doc.createElement("ModificadoresAcceso");
				
				for (int z = 0; z < modificadores.length; z++){
					
					Element modificadorAcceso = doc.createElement(modificadores[z]);
					etiquetaModificadores.appendChild(modificadorAcceso);
					
				}
				
				etiquetaMetodo.appendChild(etiquetaModificadores);
				//agrega y termina etiqueta de modificadores de acceso
				
				//agregar el tipo de retorno
				try {
					Element tipoRetorno = doc.createElement(metodo[1]);
					etiquetaMetodo.appendChild(tipoRetorno);
				}
				catch (Exception e){}
				
				//agregar el nombre
				Element nombreMetodo = doc.createElement(metodo[2]);
				etiquetaMetodo.appendChild(nombreMetodo);
				
				//crear etiqueta de parametros
				String[] parametros = metodo[0].split(",");
				Element etiquetaParametros = doc.createElement("Parametros");
				
				for (int z = 0; z < parametros.length; z++){
					
					try{
						Element parametro = doc.createElement(parametros[z]);
						etiquetaParametros.appendChild(parametro);
					}
					catch (org.w3c.dom.DOMException dom){}					
				}
				
				etiquetaMetodo.appendChild(etiquetaParametros);
				//agrega y termina etiqueta de parametros
				
				metodosPropios.appendChild(etiquetaMetodo);
				
			}
			
			clase.appendChild(metodosPropios);
			
			Element metodosHeredados = doc.createElement("MetodosHeredados");
			
			//agrega los metodos heredados
			for (int y = 0; y < jerarquia.get(x).getMetodosHeredados().size(); y++){
				
				String[] metodo = jerarquia.get(x).getMetodosHeredados().get(y).split("¡!");
				
				//agregar metodo
				Element etiquetaMetodo = doc.createElement(metodo[2]);
				
				//agregar superClase de la cual hereda el metodo
				String superClase = "Heredado_De_" + metodo[0];
				Element etiquetaSuperClase = doc.createElement(superClase);
				etiquetaMetodo.appendChild(etiquetaSuperClase);
				
				//crear etiqueta de modificadores de acceso
				String[] modificadores = metodo[1].split(" ");
				Element etiquetaModificadores = doc.createElement("ModificadoresAcceso");
				
				for (int z = 0; z < modificadores.length; z++){
					
					Element modificadorAcceso = doc.createElement(modificadores[z]);
					etiquetaModificadores.appendChild(modificadorAcceso);
					
				}
				
				etiquetaMetodo.appendChild(etiquetaModificadores);
				//agrega y termina etiqueta de modificadores de acceso
				
				//agregar el tipo de retorno
				try {
					Element tipoRetorno = doc.createElement(metodo[1]);
					etiquetaMetodo.appendChild(tipoRetorno);
				}
				catch (org.w3c.dom.DOMException dom){}	
				
				//agregar el nombre
				Element nombreMetodo = doc.createElement(metodo[2]);
				etiquetaMetodo.appendChild(nombreMetodo);
				
				//crear etiqueta de parametros
				String[] parametros = metodo[3].split(",");
				Element etiquetaParametros = doc.createElement("Parametros");
				
				for (int z = 0; z < parametros.length; z++){
					
					try{
						Element parametro = doc.createElement(parametros[z]);
						etiquetaParametros.appendChild(parametro);
					}
					catch (org.w3c.dom.DOMException dom){}					
				}
				
				etiquetaMetodo.appendChild(etiquetaParametros);
				//agrega y termina etiqueta de parametros
				
				metodosHeredados.appendChild(etiquetaMetodo);
				
			}
			
			clase.appendChild(metodosHeredados);
			
			clases.appendChild(clase);
			
		}		
		
		// crear xml
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(jerarquia.get(0).getNombre() + ".xml"));
		transformer.transform(source, result);

		return (new java.io.File(".").getCanonicalPath());
		
		
	} 

}