/*
 * Created by JFormDesigner on Sat Jun 01 01:59:09 CST 2013
 */

package interfaz;

import apiCL.*;

import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

/**
 * @author Jason Gonzalez
 */
public class MenuPrincipal extends JFrame {
	public MenuPrincipal() {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		initComponents();
	
	}
	
	private Valores values=  new Valores();
	private void botonAceptarMouseClicked(MouseEvent e) {
		// TODO add your code here
		values.clase = entradaNombre.getText();
		jerarquia.clear();
		
		try {
			jerarquia.add(Introspeccion.introspeccion(Valores.clase));
		 
			
			// TODO Auto-generated catch block
		 //cambiar temp.get(x) por la clase seleccionada por el usuario
		for (int x = 0; x < jerarquia.get(0).getSuperClases().size(); x++){   
		  
			jerarquia.add(Introspeccion.introspeccion(jerarquia.get(0).getSuperClases().get(x)));
		}} catch (ClassNotFoundException p) {
			// TODO Auto-generated catch block
			p.printStackTrace();
		}
		vEdicion ventana = new vEdicion();
		ventana.setVisible(true);
		}
		

	private void botonSalirMouseClicked(MouseEvent e) {
		// TODO add your code here
		this.dispose();
	}

	private void botonEditarMouseClicked(MouseEvent e) {
		// TODO add your code here
		values.clase = comboPaquetes.getSelectedItem().toString();
		jerarquia.clear();
		
		try {
			jerarquia.add(Introspeccion.introspeccion(Valores.clase));
		 
			
			// TODO Auto-generated catch block
		 //cambiar temp.get(x) por la clase seleccionada por el usuario
		for (int x = 0; x < jerarquia.get(0).getSuperClases().size(); x++){   
		  
			jerarquia.add(Introspeccion.introspeccion(jerarquia.get(0).getSuperClases().get(x)));
		}} catch (ClassNotFoundException p) {
			// TODO Auto-generated catch block
			p.printStackTrace();
		}
		vEdicion ventana = new vEdicion();
		ventana.setVisible(true);
	}

	private void botonSalir2MouseClicked(MouseEvent e) {
		// TODO add your code here
		mensajeRepetidos.setVisible(false);
		entradaNombre.setText("");
		this.setVisible(true);
	}

	private void btnAMouseClicked(MouseEvent e) {
		// TODO add your code here
		mensajeError.setVisible(false);
	}

	private void botonXmlMouseClicked(MouseEvent e) {
		// TODO add your code here
		
jerarquia.clear();
		
		try {
			jerarquia.add(Introspeccion.introspeccion(Valores.clase));
		 
			
			// TODO Auto-generated catch block
		 //cambiar temp.get(x) por la clase seleccionada por el usuario
		for (int x = 0; x < jerarquia.get(0).getSuperClases().size(); x++){   
		  
			jerarquia.add(Introspeccion.introspeccion(jerarquia.get(0).getSuperClases().get(x)));
		}} catch (ClassNotFoundException p) {
			// TODO Auto-generated catch block
			p.printStackTrace();
		}
		CreadorXML miXml = new CreadorXML();
	
		try {
			try {
				miXml.crearXML(jerarquia);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (ParserConfigurationException
				| TransformerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
	
	private ArrayList<Clase> jerarquia = new ArrayList<Clase>(); 

	private void botonHtmlMouseClicked(MouseEvent e) {
		// TODO add your code here
	}

	private void botonValidarMouseClicked(MouseEvent e) {
		// TODO add your code here
		//System.out.println("Entro a validar");
		jerarquia.clear();
		//System.out.println("Limpio jerarquia");
		Introspeccion miIntro = new Introspeccion();
		//System.out.println("Crea instrospeccion");
		String variable = entradaNombre.getText();
		//System.out.println("Toma la entrada de texto");
		
		ArrayList<String> listaClases  = miIntro.buscarEnPaquetes(variable);
		//System.out.println("Crea una lista con las clases del proyecto");
		if(listaClases.isEmpty()){
			mensajeError.setVisible(true);
		}
		/*else if(listaClases.size()==1){
			//values.clase = listaClases.get(0);
			//vEdicion ventana = new vEdicion();
			//ventana.setVisible(true);
			botonXml.setEnabled(true);
			botonHtml.setEnabled(true);
			botonInformacion.setEnabled(true);
			botonAceptar.setEnabled(true);
			System.out.println("Setea botones");
			Valores.clase = variable;
			System.out.println("Asigna a clase general el valor de la entrada de texto");
				
		}*/
		else{
			comboPaquetes.removeAllItems();
			for(int i = 0; i<listaClases.size();i++){
				comboPaquetes.addItem(listaClases.get(i));
			}
			mensajeRepetidos.setVisible(true);
			this.setVisible(false);
		
		}
	}

	private void botonAceptar3MouseClicked(MouseEvent e) {
		// TODO add your code here
	}

	private void botonInfo2MouseClicked(MouseEvent e) {
		// TODO add your code here
		values.clase = comboPaquetes.getSelectedItem().toString();
		jerarquia.clear();
		
		try {
			jerarquia.add(Introspeccion.introspeccion(Valores.clase));
		 
			
			// TODO Auto-generated catch block
		 //cambiar temp.get(x) por la clase seleccionada por el usuario
		for (int x = 0; x < jerarquia.get(0).getSuperClases().size(); x++){   
		  
			jerarquia.add(Introspeccion.introspeccion(jerarquia.get(0).getSuperClases().get(x)));
		}} catch (ClassNotFoundException p) {
			// TODO Auto-generated catch block
			p.printStackTrace();
		}
	
		Valores.miClase = jerarquia.get(0);
		VentanaInformacion miVentana = new VentanaInformacion();
		miVentana.setVisible(true);
	}

	private void botonHtml2MouseClicked(MouseEvent e) {
		// TODO add your code here
		values.clase = comboPaquetes.getSelectedItem().toString();
		jerarquia.clear();
		
		try {
			jerarquia.add(Introspeccion.introspeccion(Valores.clase));
		 
			
			// TODO Auto-generated catch block
		 //cambiar temp.get(x) por la clase seleccionada por el usuario
		for (int x = 0; x < jerarquia.get(0).getSuperClases().size(); x++){   
		  
			jerarquia.add(Introspeccion.introspeccion(jerarquia.get(0).getSuperClases().get(x)));
		}} catch (ClassNotFoundException p) {
			// TODO Auto-generated catch block
			p.printStackTrace();
		}
	
		Valores.miClase = jerarquia.get(0);
		
		
		MensajeArchivo miVentana = new MensajeArchivo();
		CreadorHtml miHtml = new CreadorHtml();
		try{
			miVentana.labelRuta.setText( miHtml.crearHTML(jerarquia));
			miVentana.labelMensaje.setText("El archivo Html se creó correctamente en:");
		}catch(Exception a){
			miVentana.labelMensaje.setText("No se pudo crear el archivo");
		}
		
		//MensajeArchivo miVentana = new MensajeArchivo();
		miVentana.setVisible(true);
		
		/*CreadorHtml miHtml = new CreadorHtml();
		try {
			Valores.ruta = miHtml.crearHTML(jerarquia);
			Valores.mensaje = "El archivo html se creó existosamente en:";
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			Valores.ruta = " ";
			Valores.mensaje = "No se pudo crear el archivo";
			e1.printStackTrace();
		}*/
		
	}

	private void botonXml2MouseClicked(MouseEvent e) {
		// TODO add your code here
		values.clase = comboPaquetes.getSelectedItem().toString();
		jerarquia.clear();
		
		try {
			jerarquia.add(Introspeccion.introspeccion(Valores.clase));
		 
			
			// TODO Auto-generated catch block
		 //cambiar temp.get(x) por la clase seleccionada por el usuario
		for (int x = 0; x < jerarquia.get(0).getSuperClases().size(); x++){   
		  
			jerarquia.add(Introspeccion.introspeccion(jerarquia.get(0).getSuperClases().get(x)));
		}} catch (ClassNotFoundException p) {
			// TODO Auto-generated catch block
			p.printStackTrace();
		}
	
		Valores.miClase = jerarquia.get(0);
		
		CreadorXML miXml = new CreadorXML();
		MensajeArchivo miVentana = new MensajeArchivo();
		
		try{
			miVentana.labelRuta.setText( miXml.crearXML(jerarquia));
			miVentana.labelMensaje.setText("El archivo XML se creó correctamente en:");
		}catch(Exception c){
			miVentana.labelMensaje.setText("No se pudo generar el archivo");
		}
		
		
		miVentana.setVisible(true);
		/*CreadorXML miXml = new CreadorXML();
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
		}*/

	}

	private void botonInformacionMouseClicked(MouseEvent e) {
		// TODO add your code here
		Introspeccion miIntro = new Introspeccion();
		//System.out.println("Instancia bien");
		try {
			Clase miClase = miIntro.introspeccion(Valores.clase);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Jason Gonzalez
		panel1 = new JPanel();
		botonSalir = new JButton();
		entradaNombre = new JTextField();
		label1 = new JLabel();
		botonValidar = new JButton();
		mensajeRepetidos = new JDialog();
		panel3 = new JPanel();
		label3 = new JLabel();
		comboPaquetes = new JComboBox();
		botonEditar = new JButton();
		botonSalir2 = new JButton();
		botonInfo2 = new JButton();
		botonXml2 = new JButton();
		botonHtml2 = new JButton();
		mensajeError = new JDialog();
		panel2 = new JPanel();
		label2 = new JLabel();
		btnA = new JButton();
		mensajeArchivo = new JDialog();
		label7 = new JLabel();
		labelRuta = new JLabel();
		botonAceptar3 = new JButton();

		//======== this ========
		Container contentPane = getContentPane();

		//======== panel1 ========
		{

		

			//---- botonSalir ----
			botonSalir.setText("Salir");
			botonSalir.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					botonSalirMouseClicked(e);
				}
			});

			//---- label1 ----
			label1.setText("Nombre de la clase:");

			//---- botonValidar ----
			botonValidar.setText("Validar");
			botonValidar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					botonValidarMouseClicked(e);
				}
			});

			GroupLayout panel1Layout = new GroupLayout(panel1);
			panel1.setLayout(panel1Layout);
			panel1Layout.setHorizontalGroup(
				panel1Layout.createParallelGroup()
					.addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
						.addGap(18, 18, 18)
						.addComponent(label1)
						.addGap(6, 6, 6)
						.addComponent(entradaNombre, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(panel1Layout.createParallelGroup()
							.addComponent(botonValidar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(botonSalir, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(37, 37, 37))
			);
			panel1Layout.setVerticalGroup(
				panel1Layout.createParallelGroup()
					.addGroup(panel1Layout.createSequentialGroup()
						.addGap(29, 29, 29)
						.addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(label1)
							.addComponent(botonValidar)
							.addComponent(entradaNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(botonSalir)
						.addContainerGap(13, Short.MAX_VALUE))
			);
		}

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addComponent(panel1, GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		pack();
		setLocationRelativeTo(getOwner());

		//======== mensajeRepetidos ========
		{
			Container mensajeRepetidosContentPane = mensajeRepetidos.getContentPane();

			//======== panel3 ========
			{

			

				//---- label3 ----
				label3.setText("Clase:");

				//---- botonEditar ----
				botonEditar.setText("Ver Diagrama");
				botonEditar.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						botonEditarMouseClicked(e);
					}
				});

				//---- botonSalir2 ----
				botonSalir2.setText("Salir");
				botonSalir2.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						botonSalir2MouseClicked(e);
					}
				});

				//---- botonInfo2 ----
				botonInfo2.setText("Ver informaci\u00f3n");
				botonInfo2.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						botonInfo2MouseClicked(e);
					}
				});

				//---- botonXml2 ----
				botonXml2.setText("Generar Xml");
				botonXml2.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						botonXml2MouseClicked(e);
					}
				});

				//---- botonHtml2 ----
				botonHtml2.setText("Generar Html");
				botonHtml2.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						botonHtml2MouseClicked(e);
					}
				});

				GroupLayout panel3Layout = new GroupLayout(panel3);
				panel3.setLayout(panel3Layout);
				panel3Layout.setHorizontalGroup(
					panel3Layout.createParallelGroup()
						.addGroup(GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
							.addGap(41, 41, 41)
							.addGroup(panel3Layout.createParallelGroup()
								.addGroup(panel3Layout.createSequentialGroup()
									.addComponent(label3)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(comboPaquetes, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())
								.addGroup(GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
									.addGap(0, 0, Short.MAX_VALUE)
									.addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
										.addComponent(botonEditar, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
										.addComponent(botonHtml2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
									.addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
										.addComponent(botonInfo2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(botonXml2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGap(22, 22, 22))))
						.addGroup(GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(botonSalir2, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
							.addGap(99, 99, 99))
				);
				panel3Layout.setVerticalGroup(
					panel3Layout.createParallelGroup()
						.addGroup(panel3Layout.createSequentialGroup()
							.addContainerGap()
							.addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(label3)
								.addComponent(comboPaquetes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18, 18, 18)
							.addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(botonInfo2)
								.addComponent(botonEditar))
							.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
							.addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(botonXml2)
								.addComponent(botonHtml2))
							.addGap(18, 18, 18)
							.addComponent(botonSalir2)
							.addContainerGap(32, Short.MAX_VALUE))
				);
			}

			GroupLayout mensajeRepetidosContentPaneLayout = new GroupLayout(mensajeRepetidosContentPane);
			mensajeRepetidosContentPane.setLayout(mensajeRepetidosContentPaneLayout);
			mensajeRepetidosContentPaneLayout.setHorizontalGroup(
				mensajeRepetidosContentPaneLayout.createParallelGroup()
					.addGroup(mensajeRepetidosContentPaneLayout.createSequentialGroup()
						.addComponent(panel3, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE)
						.addGap(0, 1, Short.MAX_VALUE))
			);
			mensajeRepetidosContentPaneLayout.setVerticalGroup(
				mensajeRepetidosContentPaneLayout.createParallelGroup()
					.addComponent(panel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			);
			mensajeRepetidos.pack();
			mensajeRepetidos.setLocationRelativeTo(mensajeRepetidos.getOwner());
		}

		//======== mensajeError ========
		{
			Container mensajeErrorContentPane = mensajeError.getContentPane();

			//======== panel2 ========
			{
				panel2.setBackground(Color.black);

		

				//---- label2 ----
				label2.setText("La clase solicitada no existe");
				label2.setFont(new Font("Consolas", Font.PLAIN, 16));
				label2.setForeground(Color.green);

				//---- btnA ----
				btnA.setText("Aceptar");
				btnA.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						btnAMouseClicked(e);
					}
				});

				GroupLayout panel2Layout = new GroupLayout(panel2);
				panel2.setLayout(panel2Layout);
				panel2Layout.setHorizontalGroup(
					panel2Layout.createParallelGroup()
						.addGroup(panel2Layout.createSequentialGroup()
							.addContainerGap()
							.addGroup(panel2Layout.createParallelGroup()
								.addGroup(panel2Layout.createSequentialGroup()
									.addComponent(label2)
									.addGap(0, 0, Short.MAX_VALUE))
								.addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
									.addGap(0, 0, Short.MAX_VALUE)
									.addComponent(btnA)))
							.addContainerGap())
				);
				panel2Layout.setVerticalGroup(
					panel2Layout.createParallelGroup()
						.addGroup(panel2Layout.createSequentialGroup()
							.addGap(18, 18, 18)
							.addComponent(label2)
							.addGap(18, 18, 18)
							.addComponent(btnA)
							.addContainerGap(25, Short.MAX_VALUE))
				);
			}

			GroupLayout mensajeErrorContentPaneLayout = new GroupLayout(mensajeErrorContentPane);
			mensajeErrorContentPane.setLayout(mensajeErrorContentPaneLayout);
			mensajeErrorContentPaneLayout.setHorizontalGroup(
				mensajeErrorContentPaneLayout.createParallelGroup()
					.addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			);
			mensajeErrorContentPaneLayout.setVerticalGroup(
				mensajeErrorContentPaneLayout.createParallelGroup()
					.addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			);
			mensajeError.pack();
			mensajeError.setLocationRelativeTo(mensajeError.getOwner());
		}

		//======== mensajeArchivo ========
		{
			Container mensajeArchivoContentPane = mensajeArchivo.getContentPane();

			//---- label7 ----
			label7.setText("El archivo se cre\u00f3 correctamente en la carpeta:");

			//---- labelRuta ----
			labelRuta.setText("text");

			//---- botonAceptar3 ----
			botonAceptar3.setText("Aceptar");
			botonAceptar3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					botonAceptar3MouseClicked(e);
				}
			});

			GroupLayout mensajeArchivoContentPaneLayout = new GroupLayout(mensajeArchivoContentPane);
			mensajeArchivoContentPane.setLayout(mensajeArchivoContentPaneLayout);
			mensajeArchivoContentPaneLayout.setHorizontalGroup(
				mensajeArchivoContentPaneLayout.createParallelGroup()
					.addGroup(mensajeArchivoContentPaneLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(mensajeArchivoContentPaneLayout.createParallelGroup()
							.addComponent(label7, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
							.addGroup(GroupLayout.Alignment.TRAILING, mensajeArchivoContentPaneLayout.createSequentialGroup()
								.addGap(0, 178, Short.MAX_VALUE)
								.addComponent(botonAceptar3))
							.addComponent(labelRuta, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE))
						.addContainerGap())
			);
			mensajeArchivoContentPaneLayout.setVerticalGroup(
				mensajeArchivoContentPaneLayout.createParallelGroup()
					.addGroup(mensajeArchivoContentPaneLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(label7)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(labelRuta)
						.addGap(13, 13, 13)
						.addComponent(botonAceptar3)
						.addContainerGap(18, Short.MAX_VALUE))
			);
			mensajeArchivo.pack();
			mensajeArchivo.setLocationRelativeTo(mensajeArchivo.getOwner());
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Jason Gonzalez
	private JPanel panel1;
	private JButton botonSalir;
	private JTextField entradaNombre;
	private JLabel label1;
	private JButton botonValidar;
	private JDialog mensajeRepetidos;
	private JPanel panel3;
	private JLabel label3;
	private JComboBox comboPaquetes;
	private JButton botonEditar;
	private JButton botonSalir2;
	private JButton botonInfo2;
	private JButton botonXml2;
	private JButton botonHtml2;
	private JDialog mensajeError;
	private JPanel panel2;
	private JLabel label2;
	private JButton btnA;
	private JDialog mensajeArchivo;
	private JLabel label7;
	private JLabel labelRuta;
	private JButton botonAceptar3;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
