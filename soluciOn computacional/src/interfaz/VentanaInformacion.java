/*
 * Created by JFormDesigner on Sat Jun 01 23:36:36 CST 2013
 */

package interfaz;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

import apiCL.Clase;

/**
 * @author Jason Gonzalez
 */
public class VentanaInformacion extends JFrame {
	public VentanaInformacion() {
		jerarquia.clear();
		EstructuraInformacion.info ="";
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
		
		EstructuraInformacion miInformacion = new EstructuraInformacion();
		try {
			informacion = miInformacion.crearHTML(jerarquia);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initComponents();
	}
	
	private ArrayList<Clase> jerarquia = new ArrayList<Clase>();
	
	public String informacion;


	private void botonAceptarMouseClicked(MouseEvent e) {
		// TODO add your code here
		this.dispose();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Jason Gonzalez
		scrollPane1 = new JScrollPane();
		labelInformacion = new JLabel();
		botonAceptar = new JButton();

		//======== this ========
		Container contentPane = getContentPane();

		//======== scrollPane1 ========
		{

			//---- labelInformacion ----
			labelInformacion.setText(informacion);
			scrollPane1.setViewportView(labelInformacion);
		}

		//---- botonAceptar ----
		botonAceptar.setText("Aceptar");
		botonAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				botonAceptarMouseClicked(e);
			}
		});

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
				.addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
					.addContainerGap(490, Short.MAX_VALUE)
					.addComponent(botonAceptar)
					.addGap(18, 18, 18))
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 361, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(botonAceptar)
					.addGap(0, 9, Short.MAX_VALUE))
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Jason Gonzalez
	private JScrollPane scrollPane1;
	private JLabel labelInformacion;
	private JButton botonAceptar;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
