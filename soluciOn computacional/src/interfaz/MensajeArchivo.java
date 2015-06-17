/*
 * Created by JFormDesigner on Sat Jun 01 19:52:47 CST 2013
 */

package interfaz;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Jason Gonzalez
 */
public class MensajeArchivo extends JFrame {
	public MensajeArchivo() {
		
		initComponents();
		
		Valores.ruta="";
		Valores.mensaje="";
	}

	private void botonAceptarMouseClicked(MouseEvent e) {
		// TODO add your code here
		this.dispose();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Jason Gonzalez
		labelMensaje = new JLabel();
		labelRuta = new JLabel();
		botonAceptar = new JButton();
		
		labelMensaje.setText(Valores.mensaje);
		labelRuta.setText(Valores.ruta);

		//======== this ========
		Container contentPane = getContentPane();

		//---- labelMensaje ----
		labelMensaje.setText("text");

		//---- labelRuta ----
		labelRuta.setText("text");

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
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(contentPaneLayout.createParallelGroup()
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGroup(contentPaneLayout.createParallelGroup()
								.addComponent(labelMensaje)
								.addComponent(labelRuta))
							.addGap(0, 259, Short.MAX_VALUE))
						.addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
							.addGap(0, 208, Short.MAX_VALUE)
							.addComponent(botonAceptar)))
					.addContainerGap())
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(labelMensaje)
					.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
					.addComponent(labelRuta)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
					.addComponent(botonAceptar)
					.addGap(20, 20, 20))
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Jason Gonzalez
	public JLabel labelMensaje;
	public JLabel labelRuta;
	private JButton botonAceptar;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
