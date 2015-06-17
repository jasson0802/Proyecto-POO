/*
 * Created by JFormDesigner on Sat Jun 01 00:41:31 CST 2013
 */

package interfaz;
import apiCL.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

/**
 * @author Jason Gonzalez
 */
public class vEdicion extends JFrame {
	public vEdicion(){
		//clase = pClase;
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		/*	DefaultListModel modelo = new DefaultListModel();
		for(int i = 0; i<jerarquia.size(); i++){
	        modelo.addElement(jerarquia.get(i).getNombre());
	}
		listaClases.setModel(modelo);*/
		
		try {
			jerarquia.add(Introspeccion.introspeccion(Valores.clase));
		 
			// TODO Auto-generated catch block
		 //cambiar temp.get(x) por la clase seleccionada por el usuario
		for (int x = 0; x < jerarquia.get(0).getSuperClases().size(); x++){   
		  
			jerarquia.add(Introspeccion.introspeccion(jerarquia.get(0).getSuperClases().get(x)));
		}} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int j = 0; j < jerarquia.size();j++){
			JLabel temporal = new JLabel();
			labels.put(String.valueOf(j), temporal);
			nombres.add(jerarquia.get(j).getNombre());
		}
		
		for(int z = 0; z < (labels.size()-1);z++){
			JLabel temp = new JLabel();
			//temp.setIcon(new ImageIcon("flecha.gif"));
			flechas.put(String.valueOf(z), temp);
		}
		
		initComponents();}
		
	
	
	public ArrayList<String>nombres = new ArrayList<String>();
	
	private ArrayList<Clase> jerarquia = new ArrayList<Clase>(); 
	
	private String tablaHtml = "<html>"  ;
	private JLabel labelDiagrama = new JLabel();
	
	public void agregarClase(){
		panelCentro.setBackground(new Color(153, 204, 255));
		panelCentro.setLayout(null);
		

		
		//---- label7 ----
		int contador = 700;
		for(int i = 0; i< labels.size(); i++){
			String atributos="";
			String metodos = "";
			for(int j = 0; j<jerarquia.get(i).getAtributos().size();j++){
				atributos +=(jerarquia.get(i).getAtributos().get(j).replace("¡!"," ")+ "</br>");
			}
			for(int k = 0; k<jerarquia.get(i).getMetodosPropios().size();k++){
				metodos+=(jerarquia.get(i).getMetodosPropios().get(k).replace("¡!", " ")+"</br>");
			}
			
			for(int l = 0; l<jerarquia.get(i).getConstructores().size();l++){
				metodos+=(jerarquia.get(i).getConstructores().get(l).replace("¡!", " ")+"</br>");

			}
			tablaHtml 
	                += "<table border='1'BGCOLOR='#F4FA58' >"  
	                + "<tr>"  
	                + "     <td><br>"+jerarquia.get(i).getNombre()+"</br></td>"  
	                + "</tr>"  
	                
	                + "<tr>" 
	                
	                + "     <td>"+atributos+"</td>"  
	                + "</tr>"  
	                
	                + "<tr>"  
	                + "     <td>"+metodos+"</td>"  
	                + "</tr>"  
	                
	                + "</table>"  
	                + "<br>"+"<IMG SRC=flecha.gif>"+"<br>" ;//"</html>";  
			
			
			
			
			//labels.get(String.valueOf(i)).setText(tablaHtml);
			/*panelCentro.add(labels.get(String.valueOf(i)));
		
			int largo = jerarquia.get(i).getAtributos().size() + jerarquia.get(i).getMetodosPropios().size() + 150;
			
			
			if(i >0){
	
			labels.get(String.valueOf(i)).setBounds(400, labels.get(String.valueOf(i-1)).getY()-largo, 350, largo+150);}
			else{
				labels.get(String.valueOf(i)).setBounds(400, 700, 350, largo+100);
			}
			
			if(i<flechas.size()-1){
			flechas.get(String.valueOf(i)).setIcon(new ImageIcon("flecha.gif"));
			panelCentro.add(flechas.get(String.valueOf(i)));
			flechas.get(String.valueOf(i)).setBounds(500, 500+i, 1Clase00, 100);
			
			
			}
			
			
			JLabel imagen = new JLabel();
			imagen.setIcon(new ImageIcon("flecha.gif"));
			panelCentro.add(imagen);
			imagen.setBounds(800, 700, 200, 200);
			
			
			contador -= 200;*/
			
			
			//panelCentro.setPreferredSize(new Dimension
				//	(panelCentro.getPreferredSize().width,panelCentro.getPreferredSize().height + largo+100));
			
			}
		
		tablaHtml+="</html>";
		labelDiagrama.setText(tablaHtml);
		panelCentro.add(labelDiagrama);
		
		
		pack();
		panelCentro.setPreferredSize(new Dimension(2000,2000));
		panelCentro.revalidate();
		panelCentro.setAutoscrolls(true);
		
		


	}
	//panelEdicion.setViewportView(panelCentro);
		
	
	
	public Hashtable<String,JLabel>labels = new Hashtable<String,JLabel>();
	public Hashtable<String,JLabel>flechas = new Hashtable<String,JLabel>();
	
	
	

	private void botonEditarMouseClicked(MouseEvent e) {
		// TODO add your code here
		//mensajeEdicion.setVisible(true);
		try {
			File f = new File("DiagramaUml"+jerarquia.get(0).getNombre() + ".html");
			BufferedWriter bw;
			bw = new BufferedWriter(new FileWriter(f));
			bw.write(tablaHtml);
			bw.close();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}

	private void botonSalirMouseClicked(MouseEvent e) {
		// TODO add your code here
		this.dispose();
	}

	private void botonAceptar2MouseClicked(MouseEvent e) {
		// TODO add your code here
	}

	private void botonCancelarMouseClicked(MouseEvent e) {
		// TODO add your code here
		mensajeEdicion.dispose();
	}

	private void botonXmlMouseClicked(MouseEvent e) {
		// TODO add your code here
		CreadorXML miXml = new CreadorXML();
		try {
			try {
				Valores.ruta = miXml.crearXML(jerarquia);
				Valores.mensaje = "El archivo XML se creó existosamente en:";
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (ParserConfigurationException
				| TransformerException e1) {
			Valores.ruta = " ";
			Valores.mensaje = "No se pudo crear el archivo";
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		MensajeArchivo mensaje = new MensajeArchivo();
		mensaje.setVisible(true);
	}

	private void botonHtmlMouseClicked(MouseEvent e) {
		// TODO add your code here
		CreadorHtml miHtml = new CreadorHtml();
		try {
			Valores.ruta = miHtml.crearHTML(jerarquia);
			Valores.mensaje = "El archivo html se creó existosamente en:";
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			Valores.ruta = " ";
			Valores.mensaje = "No se pudo crear el archivo";
			e1.printStackTrace();
		}
		MensajeArchivo mensaje = new MensajeArchivo();
		mensaje.setVisible(true);
	}

	private void botonAceptar3MouseClicked(MouseEvent e) {
		// TODO add your code here
		
	}

	
	
	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Jason Gonzalez
		panelPrincipal = new JPanel();
		scrollLista = new JScrollPane();
		listaClases = new JList();
		botonEditar = new JButton();
		botonSalir = new JButton();
		panelEdicion = new JScrollPane();
		panelCentro = new JPanel();
		
		mensajeEdicion = new JDialog();
		panel3 = new JPanel();
		label1 = new JLabel();
		label2 = new JLabel();
		label3 = new JLabel();
		label4 = new JLabel();
		label5 = new JLabel();
		entradaNombre = new JTextField();
		comboTipo = new JComboBox();
		entradaValor = new JTextField();
		comboModificador = new JComboBox();
		comboExtras = new JComboBox();
		botonAceptar2 = new JButton();
		botonCancelar = new JButton();
		label6 = new JLabel();
		DefaultListModel modelo = new DefaultListModel();
		for(int i = nombres.size()-1; i>=0; i--){
	        modelo.addElement(nombres.get(i));
	}
		listaClases.setModel(modelo);

		//======== this ========
		Container contentPane = getContentPane();

		//======== panelPrincipal ========
		{



			//======== scrollLista ========
			{
				scrollLista.setViewportView(listaClases);
			}

			//---- botonEditar ----
			botonEditar.setText("Guardar");
			botonEditar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					botonEditarMouseClicked(e);
				}
			});

			//---- botonSalir ----
			botonSalir.setText("Salir");
			botonSalir.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					botonSalirMouseClicked(e);
				}
			});
			

			//======== panelEdicion ========
			{

				//======== panelCentro ========
				{
					panelCentro.setBackground(new Color(153, 204, 255));
					panelCentro.setLayout(null);
					
					
					
					
					//---- label7 ----
				
					for(int i = 0; i< labels.size(); i++){
						String atributos="";
						String metodos = "";
						for(int j = 0; j<jerarquia.get(i).getAtributos().size();j++){
							atributos +=(jerarquia.get(i).getAtributos().get(j).replace("¡!"," ")+ "<br>");
						}
						for(int k = 0; k<jerarquia.get(i).getMetodosPropios().size();k++){
							metodos+=(jerarquia.get(i).getMetodosPropios().get(k).replace("¡!", " ")+"<br>");
						}
						
						for(int l = 0; l<jerarquia.get(i).getConstructores().size();l++){
							metodos+=(jerarquia.get(i).getConstructores().get(l).replace("¡!", " ")+"<br>");
			
						}
						if(jerarquia.get(i).getNombre().equals("java.lang.Object")){
						tablaHtml  
				                += "<table border='1'BGCOLOR='#F4FA58' >"  
				                + "<tr>"  
				                + "     <td><br>"+jerarquia.get(i).getNombre()+"</br></td>"  
				                + "</tr>"  
				                
				                + "<tr>" 
				                
				                + "     <td>"+atributos+"</td></br>"  
				                + "</tr>"  
				                
				                + "<tr>"  
				                + "     <td>"+metodos+"</td></br>"  
				                + "</tr>"  
				                
				                + "</table>"  
				                + "<br><br>";}
						else{
							tablaHtml  
			                += "<table border='1'BGCOLOR='#F4FA58' >"  
			                + "<tr>"  
			                + "     <td><br>"+jerarquia.get(i).getNombre()+"</br></td>"  
			                + "</tr>"  
			                
			                + "<tr>" 
			                
			                + "     <td>"+atributos+"</td></br>"  
			                + "</tr>"  
			                
			                + "<tr>"  
			                + "     <td>"+metodos+"</td></br>"  
			                + "</tr>"  
			                
			                + "</table>"+  
			                //+ "<br><IMG SRC ="+"\"" + "flecha.jpg"+"\""+"><br>";
			                "&nbsp&nbsp&nbsp&nbsp&nbsp|<br>&nbsp&nbsp&nbsp&nbsp&nbsp|<br> __|__<br>"+
			                "&nbsp"+"\\"+"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp/<br>&nbsp&nbsp&nbsp"+"\\"+"&nbsp&nbsp&nbsp/<br>&nbsp&nbsp&nbsp&nbsp V";

							
						}
						
					}
						tablaHtml+="</html>";
						labelDiagrama.setText(tablaHtml);
						panelCentro.add(labelDiagrama);
						labelDiagrama.setBounds(550, 10, 300, 1000);
						
	
					
					
					
						pack();
						panelCentro.setPreferredSize(new Dimension(2000,2000));
						panelCentro.revalidate();
						panelCentro.setAutoscrolls(true);
						
						

						
						//panelCentro.setAutoscrolls(true);
						}
					
					
					/*for(int i = 0;i<flechas.size()-1;i++){
						flechas.get(String.valueOf(i)).setIcon(new ImageIcon("flecha.gif"));
						panelCentro.add(flechas.get(String.valueOf(i)));
						flechas.get(String.valueOf(i)).setBounds(500, labels.get(String.valueOf(i)).getY()+600, 200, 300);
					}
					
					pack();
					panelCentro.revalidate();*/
			
				}
				panelEdicion.setViewportView(panelCentro);
				
			}

			GroupLayout panelPrincipalLayout = new GroupLayout(panelPrincipal);
			panelPrincipal.setLayout(panelPrincipalLayout);
			panelPrincipalLayout.setHorizontalGroup(
				panelPrincipalLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
					.addGroup(panelPrincipalLayout.createSequentialGroup()
						.addGap(0, 0, Short.MAX_VALUE)
						.addComponent(botonEditar, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(botonSalir, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
					.addGroup(GroupLayout.Alignment.LEADING, panelPrincipalLayout.createSequentialGroup()
						.addComponent(scrollLista, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(panelEdicion))
			);
			panelPrincipalLayout.setVerticalGroup(
				panelPrincipalLayout.createParallelGroup()
					.addGroup(panelPrincipalLayout.createSequentialGroup()
						.addGroup(panelPrincipalLayout.createParallelGroup()
							.addComponent(scrollLista)
							.addComponent(panelEdicion))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(panelPrincipalLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(botonSalir)
							.addComponent(botonEditar))
						.addContainerGap())
			);
		

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addComponent(panelPrincipal, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addComponent(panelPrincipal, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		pack();
		setLocationRelativeTo(getOwner());

		//======== mensajeEdicion ========
		{
			Container mensajeEdicionContentPane = mensajeEdicion.getContentPane();

			//======== panel3 ========
			{

				
				//---- label1 ----
				label1.setText("Nombre:");

				//---- label2 ----
				label2.setText("Tipo:");

				//---- label3 ----
				label3.setText("Valor:");

				//---- label4 ----
				label4.setText("Modificador:");

				//---- label5 ----
				label5.setText("Extras:");

				//---- botonAceptar2 ----
				botonAceptar2.setText("Aceptar");
				botonAceptar2.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						botonAceptar2MouseClicked(e);
					}
				});

				//---- botonCancelar ----
				botonCancelar.setText("Cancelar");
				botonCancelar.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						botonCancelarMouseClicked(e);
					}
				});

				//---- label6 ----
				label6.setText("ApicITO Reloaded");

				GroupLayout panel3Layout = new GroupLayout(panel3);
				panel3.setLayout(panel3Layout);
				panel3Layout.setHorizontalGroup(
					panel3Layout.createParallelGroup()
						.addGroup(panel3Layout.createSequentialGroup()
							.addContainerGap()
							.addGroup(panel3Layout.createParallelGroup()
								.addGroup(GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
									.addComponent(botonAceptar2)
									.addGap(18, 18, 18)
									.addComponent(botonCancelar))
								.addGroup(panel3Layout.createSequentialGroup()
									.addGroup(panel3Layout.createParallelGroup()
										.addComponent(label4)
										.addComponent(label1, GroupLayout.Alignment.TRAILING)
										.addComponent(label2, GroupLayout.Alignment.TRAILING)
										.addComponent(label3, GroupLayout.Alignment.TRAILING)
										.addComponent(label5, GroupLayout.Alignment.TRAILING))
									.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
									.addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
										.addComponent(entradaNombre, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
										.addComponent(comboTipo, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
										.addComponent(entradaValor, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
										.addComponent(comboModificador, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
										.addComponent(comboExtras, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
										.addGroup(panel3Layout.createSequentialGroup()
											.addGap(21, 21, 21)
											.addComponent(label6)))))
							.addContainerGap(48, Short.MAX_VALUE))
				);
				panel3Layout.setVerticalGroup(
					panel3Layout.createParallelGroup()
						.addGroup(panel3Layout.createSequentialGroup()
							.addGap(6, 6, 6)
							.addComponent(label6)
							.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
							.addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(label1)
								.addComponent(entradaNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(label2)
								.addComponent(comboTipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(10, 10, 10)
							.addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(label3)
								.addComponent(entradaValor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
							.addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(label4)
								.addComponent(comboModificador, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
							.addGroup(panel3Layout.createParallelGroup()
								.addComponent(label5)
								.addComponent(comboExtras, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18, 18, 18)
							.addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(botonCancelar)
								.addComponent(botonAceptar2))
							.addContainerGap(19, Short.MAX_VALUE))
				);
			}

			GroupLayout mensajeEdicionContentPaneLayout = new GroupLayout(mensajeEdicionContentPane);
			mensajeEdicionContentPane.setLayout(mensajeEdicionContentPaneLayout);
			mensajeEdicionContentPaneLayout.setHorizontalGroup(
				mensajeEdicionContentPaneLayout.createParallelGroup()
					.addComponent(panel3, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			);
			mensajeEdicionContentPaneLayout.setVerticalGroup(
				mensajeEdicionContentPaneLayout.createParallelGroup()
					.addComponent(panel3, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			);
			mensajeEdicion.pack();
			mensajeEdicion.setLocationRelativeTo(mensajeEdicion.getOwner());
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Jason Gonzalez
	private JPanel panelPrincipal;
	private JScrollPane scrollLista;
	private JList listaClases;
	private JButton botonEditar;
	private JButton botonSalir;
	private JScrollPane panelEdicion;
	private JPanel panelCentro;
	
	private JDialog mensajeEdicion;
	private JPanel panel3;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JTextField entradaNombre;
	private JComboBox comboTipo;
	private JTextField entradaValor;
	private JComboBox comboModificador;
	private JComboBox comboExtras;
	private JButton botonAceptar2;
	private JButton botonCancelar;
	private JLabel label6;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
