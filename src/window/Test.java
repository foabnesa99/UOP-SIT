package window;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import model.*;
import model.Automobil.MarkaVozila;
import model.Automobil.ModeliAuto;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
public class Test extends JDialog {
public ComboBoxModel m;
public ComboBoxModel modelAuta;
public JComboBox ModelCombo;
private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Test dialog = new Test();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Test() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			m = new DefaultComboBoxModel<Automobil.MarkaVozila>(Automobil.MarkaVozila.values());
			
			
			JComboBox MarkaCombo = new JComboBox();
			MarkaCombo.setModel(m);
			MarkaCombo.setSelectedIndex(-1);
			MarkaCombo.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					System.out.println("Radi");
					Automobil.MarkaVozila izabranaMarka = (MarkaVozila) MarkaCombo.getSelectedItem();
					modelAuta = new DefaultComboBoxModel<Object>(izabranaMarka.getModeli().toArray());
					ModelCombo.setModel(modelAuta);
				}
			});
			
			MarkaCombo.addPropertyChangeListener(new PropertyChangeListener() {
				public void propertyChange(PropertyChangeEvent arg0) {
				
				}
			});
		
			MarkaCombo.setBounds(10, 11, 251, 20);
			contentPanel.add(MarkaCombo);
		}
		{
			ModelCombo = new JComboBox();
			ModelCombo.setBounds(10, 116, 261, 20);
			contentPanel.add(ModelCombo);
		}
			
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
