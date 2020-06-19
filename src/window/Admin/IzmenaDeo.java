package window.Admin;

import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.Automobil;

import model.ServDeo;

import model.Automobil.MarkaVozila;
import model.Automobil.ModeliAuto;

import servFunkc.ServisaAuto;

import javax.swing.JTextField;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class IzmenaDeo extends JDialog {
	
		public ComboBoxModel m;
		public ComboBoxModel modelAuta;
		public JComboBox ModelCombo;
		private final JPanel contentPanel = new JPanel();
		private JTextField txtID;
		private JTextField txtNaziv;
		private JTextField txtCena;
		private JComboBox MarkaCombo;
		public ArrayList<Automobil> auti = new ArrayList<Automobil>();
		private JLabel lbCena;
		private JLabel lbNaz;
		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			try {
				IzmenaDeo dialog = new IzmenaDeo();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		/**
		 * Create the dialog.
		 */
		public IzmenaDeo(int id) {
			this();
			ServDeo deo = ServisaAuto.servis12.nadjiDeo(id);
			txtID.setText(deo.getId()+"");
			MarkaCombo.setSelectedItem(deo.getMarkaVoz());
			ModelCombo.setSelectedItem(deo.getModelVoz());
			txtNaziv.setText(deo.getNazivDela());
			txtCena.setText(deo.getCena()+"");
			
			
		}
		
		
		
		
		
		public IzmenaDeo() {
			setTitle("Izmena podataka dela");
			if (ServisaAuto.servis12.getAuti().size()==0)
				ServisaAuto.servis12.ucitajAutomobile();
				auti = ServisaAuto.servis12.getAuti();
			
			
			setBounds(100, 100, 450, 450);
			getContentPane().setLayout(new BorderLayout());
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(contentPanel, BorderLayout.CENTER);
			contentPanel.setLayout(null);
			{
				m = new DefaultComboBoxModel<Automobil.MarkaVozila>(Automobil.MarkaVozila.values());

				MarkaCombo = new JComboBox();
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

				MarkaCombo.setBounds(83, 123, 251, 20);
				contentPanel.add(MarkaCombo);
			}
			{
				ModelCombo = new JComboBox();
				ModelCombo.setBounds(83, 179, 251, 20);
				contentPanel.add(ModelCombo);
			}
			{
				JLabel lbNaziv_1 = new JLabel("ID");
				lbNaziv_1.setHorizontalAlignment(SwingConstants.CENTER);
				lbNaziv_1.setBounds(83, 42, 251, 14);
				contentPanel.add(lbNaziv_1);
			}
			{
				txtID = new JTextField();
				txtID.setEnabled(false);
				txtID.setBounds(83, 67, 251, 20);
				contentPanel.add(txtID);
				txtID.setColumns(10);
			}
			{
				JLabel lblMarkaVozila = new JLabel("Marka vozila");
				lblMarkaVozila.setHorizontalAlignment(SwingConstants.CENTER);
				lblMarkaVozila.setBounds(83, 98, 251, 14);
				contentPanel.add(lblMarkaVozila);
			}
			{
				JLabel lblModel = new JLabel("Model");
				lblModel.setHorizontalAlignment(SwingConstants.CENTER);
				lblModel.setBounds(83, 154, 251, 14);
				contentPanel.add(lblModel);
			}
			
			JLabel lblNaziv = new JLabel("Naziv");
			lblNaziv.setHorizontalAlignment(SwingConstants.CENTER);
			lblNaziv.setBounds(83, 210, 251, 14);
			contentPanel.add(lblNaziv);
			
			txtNaziv = new JTextField();
			txtNaziv.setColumns(10);
			txtNaziv.setBounds(83, 235, 251, 20);
			contentPanel.add(txtNaziv);
			
			JLabel lblCena = new JLabel("Cena");
			lblCena.setHorizontalAlignment(SwingConstants.CENTER);
			lblCena.setBounds(83, 266, 251, 14);
			contentPanel.add(lblCena);
			
			txtCena = new JTextField();
			txtCena.setColumns(10);
			txtCena.setBounds(83, 291, 251, 20);
			contentPanel.add(txtCena);
			
			JButton btnNewButton = new JButton("Izmeni");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					if(validacija()) {
						int id = Integer.parseInt(txtID.getText().trim());
						
						MarkaVozila marka = (MarkaVozila) MarkaCombo.getSelectedItem();
						ModeliAuto model = (ModeliAuto) ModelCombo.getSelectedItem();
						String naziv = txtNaziv.getText().trim();
						int cena = Integer.parseInt(txtCena.getText().trim());
						
						// DODAVANJE:
							ServDeo novi = new ServDeo(id,false,marka,model,naziv,cena);
							ServisaAuto.servis12.izmeniDeo(novi);
							ServisaAuto.servis12.sacuvajDeo();
						
						JOptionPane.showMessageDialog(getContentPane(), "Uspesno ste izmenili automobil!");
						
				}	
				}
			});
			btnNewButton.setBounds(83, 334, 89, 23);
			contentPanel.add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("Izadji");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				dispose();
				}
			});
			btnNewButton_1.setBounds(245, 334, 89, 23);
			contentPanel.add(btnNewButton_1);
			
			lbNaz = new JLabel("*");
			lbNaz.setForeground(Color.RED);
			lbNaz.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lbNaz.setBounds(344, 238, 15, 14);
			contentPanel.add(lbNaz);
			lbNaz.setVisible(false);
			
			lbCena = new JLabel("*");
			lbCena.setForeground(Color.RED);
			lbCena.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lbCena.setBounds(344, 294, 15, 14);
			contentPanel.add(lbCena);
			lbCena.setVisible(false);
		
		}
		public boolean validacija() {
			boolean provera = true;	
			String poruka = "";
			while(true) {
			
			if(txtNaziv.getText().isEmpty()) {
					lbNaz.setVisible(true);
					provera = false;
					}
			 if(txtCena.getText().isEmpty()) {
					lbCena.setVisible(true);
					provera = false;
				}
			
			 
			 
			 if(provera == false)JOptionPane.showMessageDialog(null,"POLJA OZNACENA ZVEZDICOM NE SMEJU BITI PRAZNA!");
			 
			
			 try {
					Integer.parseInt(txtCena.getText().trim());
				}catch (NumberFormatException e) {
					poruka += "- Cena mora biti broj!\n";
					provera = false;
				}
			 JOptionPane.showMessageDialog(null,poruka);
				return provera;
			 }
			 
			 
			 
			}

}