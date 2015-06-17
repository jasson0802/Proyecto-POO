/*
 * Created by JFormDesigner on Sat Jun 01 17:51:30 CST 2013
 */

package interfaz;

import java.awt.*;
import javax.swing.*;

/**
 * @author Jason Gonzalez
 */
public class ClaseInterfaz extends JPanel {
	
	public ClaseInterfaz(){
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
		labelFlecha = new JLabel();

		//======== panel1 ========
		{
			panel1.setBackground(new Color(255, 255, 204));

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
						.addComponent(nombre, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
						.addGroup(panel2Layout.createSequentialGroup()
							.addContainerGap()
							.addGroup(panel2Layout.createParallelGroup()
								.addComponent(panelAtributos, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
								.addComponent(panelMetodos, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
							.addContainerGap())
				);
				panel2Layout.setVerticalGroup(
					panel2Layout.createParallelGroup()
						.addGroup(panel2Layout.createSequentialGroup()
							.addContainerGap()
							.addComponent(nombre)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(panelAtributos, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(panelMetodos, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
							.addGap(20, 20, 20))
				);
			}

			//---- labelFlecha ----
			labelFlecha.setText("text");

			GroupLayout panel1Layout = new GroupLayout(panel1);
			panel1.setLayout(panel1Layout);
			panel1Layout.setHorizontalGroup(
				panel1Layout.createParallelGroup()
					.addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
						.addContainerGap(26, Short.MAX_VALUE)
						.addComponent(labelFlecha, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addGap(75, 75, 75))
					.addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			);
			panel1Layout.setVerticalGroup(
				panel1Layout.createParallelGroup()
					.addGroup(panel1Layout.createSequentialGroup()
						.addComponent(panel2, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
						.addGap(18, 18, 18)
						.addComponent(labelFlecha, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
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
	private JLabel labelFlecha;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
