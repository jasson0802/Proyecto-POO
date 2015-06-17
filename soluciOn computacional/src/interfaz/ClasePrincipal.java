/*
 * Created by JFormDesigner on Sat Jun 01 21:41:24 CST 2013
 */

package interfaz;

import java.awt.*;
import javax.swing.*;

/**
 * @author Jason Gonzalez
 */
public class ClasePrincipal extends JPanel {
	
	public ClasePrincipal(){
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Jason Gonzalez
		panel1 = new JPanel();
		panel2 = new JPanel();
		nombre = new JLabel();
		panelAtributos = new JScrollPane();
		listaAtributos = new JList();
		panelMetodos = new JScrollPane();
		listaMetodos = new JList();
		

		//======== panel1 ========
		{

			// JFormDesigner evaluation mark
			panel1.setBorder(new javax.swing.border.CompoundBorder(
				new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
					"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
					javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
					java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


			//======== panel2 ========
			{
				panel2.setBackground(new Color(255, 255, 204));

				//---- nombre ----
				nombre.setText("text");

				//======== panelAtributos ========
				{

					//---- listaAtributos ----
					listaAtributos.setBackground(new Color(255, 255, 204));
					panelAtributos.setViewportView(listaAtributos);
				}

				//======== panelMetodos ========
				{

					//---- listaMetodos ----
					listaMetodos.setBackground(new Color(255, 255, 204));
					panelMetodos.setViewportView(listaMetodos);
				}

				GroupLayout panel2Layout = new GroupLayout(panel2);
				panel2.setLayout(panel2Layout);
				panel2Layout.setHorizontalGroup(
					panel2Layout.createParallelGroup()
						.addComponent(panelAtributos, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
						.addComponent(panelMetodos, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
						.addComponent(nombre, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
				);
				panel2Layout.setVerticalGroup(
					panel2Layout.createParallelGroup()
						.addGroup(panel2Layout.createSequentialGroup()
							.addContainerGap()
							.addComponent(nombre, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(panelAtributos, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(panelMetodos, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
				);
			}

			GroupLayout panel1Layout = new GroupLayout(panel1);
			panel1.setLayout(panel1Layout);
			panel1Layout.setHorizontalGroup(
				panel1Layout.createParallelGroup()
					.addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			);
			panel1Layout.setVerticalGroup(
				panel1Layout.createParallelGroup()
					.addComponent(panel2, GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
			);
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Jason Gonzalez
	private JPanel panel1;
	private JPanel panel2;
	private JLabel nombre;
	private JScrollPane panelAtributos;
	private JList listaAtributos;
	private JScrollPane panelMetodos;
	private JList listaMetodos;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
