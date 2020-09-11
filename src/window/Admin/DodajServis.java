package window.Admin;

import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import model.Automobil;
import model.Musterija;
import model.ServDeo;
import model.ServisAutomobila;
import model.Serviser;
import model.Automobil.MarkaVozila;
import model.Automobil.ModeliAuto;
import model.Automobil.VrstaGoriva;
import model.ServisAutomobila.Status;
import servFunkc.ServisaAuto;

import javax.swing.JTextField;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JFormattedTextField;

public class DodajServis extends JDialog {
	
		public ComboBoxModel m;
		public ComboBoxModel modelAuta;
		public JComboBox ModelCombo;
		private final JPanel contentPanel = new JPanel();
		private JTextField txtID;
		private JTextField txtNaziv;
		private JTextField txtCena;
		private JComboBox MarkaCombo;
		public ArrayList<Automobil> auti = new ArrayList<Automobil>();
		private JLabel lblNewLabel;
		private JLabel lblNewLabel_1;
		private JTextField textField;
		private JLabel lblMarkaAutomobila;
		private JLabel lblModel;
		private JLabel lblServiser;
		public ArrayList<Serviser> serviseri = new ArrayList<Serviser>();
		public ArrayList<ServDeo> delovi = new ArrayList<ServDeo>();
		private JTextField txtTermin;
		private ArrayList<ServisAutomobila> servisi = new ArrayList<ServisAutomobila>();
		private JLabel lbID;
		private JLabel lbDat;
		  private static String format = "(\\d\\d:\\d\\d) (\\d{2}.\\d{2}.\\d{4})";

		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			try {
				DodajServis dialog = new DodajServis();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		/**
		 * Create the dialog.
		 */
		
		
		
		
		
		
		public DodajServis() {
			setTitle("Novi servis");
			if (ServisaAuto.servis12.getServ().size()==0)
				ServisaAuto.servis12.ucitajServisera();
				serviseri = ServisaAuto.servis12.getServ();
			
				if (ServisaAuto.servis12.getDelovi().size()==0)
					ServisaAuto.servis12.ucitajDeo();
					delovi = ServisaAuto.servis12.getDelovi();
					if (ServisaAuto.servis12.getServis().size()==0)
						ServisaAuto.servis12.ucitajServis();
						servisi = ServisaAuto.servis12.getServis();
					
					setBounds(100, 100, 450, 730);
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

				MarkaCombo.setBounds(83, 108, 251, 20);
				contentPanel.add(MarkaCombo);
			}
			{
				ModelCombo = new JComboBox();
				ModelCombo.setBounds(83, 164, 251, 20);
				contentPanel.add(ModelCombo);
			}
			{
				lblNewLabel = new JLabel("Unesite podatke za novi servis");
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblNewLabel.setBounds(10, 11, 414, 14);
				contentPanel.add(lblNewLabel);
			}
			{
				lblNewLabel_1 = new JLabel("ID");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_1.setBounds(83, 36, 251, 14);
				contentPanel.add(lblNewLabel_1);
			}
			{
				txtID = new JTextField();
				txtID.setBounds(83, 52, 251, 20);
				contentPanel.add(txtID);
				txtID.setColumns(10);
			}
			{
				lblMarkaAutomobila = new JLabel("Marka automobila");
				lblMarkaAutomobila.setHorizontalAlignment(SwingConstants.CENTER);
				lblMarkaAutomobila.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblMarkaAutomobila.setBounds(83, 83, 251, 14);
				contentPanel.add(lblMarkaAutomobila);
			}
			{
				lblModel = new JLabel("Model");
				lblModel.setHorizontalAlignment(SwingConstants.CENTER);
				lblModel.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblModel.setBounds(83, 139, 251, 14);
				contentPanel.add(lblModel);
			}
			{
				lblServiser = new JLabel("Serviser");
				lblServiser.setHorizontalAlignment(SwingConstants.CENTER);
				lblServiser.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblServiser.setBounds(83, 195, 251, 14);
				contentPanel.add(lblServiser);
			}
			
			JComboBox comboServiser = new JComboBox();
			comboServiser.setBounds(83, 220, 251, 20);
			contentPanel.add(comboServiser);
			
			comboServiser.setModel(new DefaultComboBoxModel<Serviser>(serviseri.toArray(new Serviser[0])));
			
			JLabel lblDatumServisa = new JLabel("Datum servisa");
			lblDatumServisa.setHorizontalAlignment(SwingConstants.CENTER);
			lblDatumServisa.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblDatumServisa.setBounds(83, 251, 251, 14);
			contentPanel.add(lblDatumServisa);
			
			JLabel lblKratakOpis = new JLabel("Kratak opis");
			lblKratakOpis.setHorizontalAlignment(SwingConstants.CENTER);
			lblKratakOpis.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblKratakOpis.setBounds(83, 307, 251, 14);
			contentPanel.add(lblKratakOpis);
			
			JTextArea txtOpis = new JTextArea();
			txtOpis.setBounds(83, 332, 251, 82);
			contentPanel.add(txtOpis);
			
			JLabel lblListaDelova = new JLabel("Lista delova");
			lblListaDelova.setHorizontalAlignment(SwingConstants.CENTER);
			lblListaDelova.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblListaDelova.setBounds(83, 425, 251, 14);
			contentPanel.add(lblListaDelova);
			
			DefaultListModel<ServDeo> dlm = new DefaultListModel<ServDeo>();
			for(ServDeo d : delovi ){
			 dlm.addElement(d);
			}    
			
			
			JList<ServDeo> listaDelova = new JList<ServDeo>(dlm);
			listaDelova.setBounds(83, 453, 251, 166);
			contentPanel.add(listaDelova);
			
			JButton btnNewButton = new JButton("Dodaj");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(validacija()) {
					int id = Integer.parseInt(txtID.getText().trim());
					
					MarkaVozila marka = (MarkaVozila) MarkaCombo.getSelectedItem();
					ModeliAuto model = (ModeliAuto) ModelCombo.getSelectedItem();
					String opis = txtOpis.getText().trim();
					Serviser serv = (Serviser)comboServiser.getSelectedItem();
					
					LocalDateTime termin = LocalDateTime.parse(txtTermin.getText().trim(),DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy")); 
					
					ArrayList<ServDeo> korisceniD = new ArrayList<ServDeo>();
					korisceniD.addAll(listaDelova.getSelectedValuesList());
					
					
					 // DODAVANJE:
						ServisAutomobila novi = new ServisAutomobila(id,false,marka, model,serv,termin,opis,ServisAutomobila.Status.Zakazan,korisceniD);
						ServisaAuto.servis12.dodajServis(novi);
						ServisaAuto.servis12.sacuvajServis(novi);
					
					JOptionPane.showMessageDialog(getContentPane(), "Uspesno ste dodali servis!");
					
					}
			
				
				
				}
			});
			btnNewButton.setBounds(83, 657, 89, 23);
			contentPanel.add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("Izadji");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				dispose();
				
				}
			});
			btnNewButton_1.setBounds(245, 657, 89, 23);
			contentPanel.add(btnNewButton_1);
			
			txtTermin = new JTextField();
			txtTermin.setToolTipText("HH:MM dd-mm-yyyy");
			txtTermin.setBounds(83, 276, 256, 20);
			contentPanel.add(txtTermin);
			txtTermin.setColumns(10);
			
			lbID = new JLabel("*");
			lbID.setForeground(Color.RED);
			lbID.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lbID.setBounds(344, 55, 16, 14);
			contentPanel.add(lbID);
			lbID.setVisible(false);
			
			lbDat = new JLabel("*");
			lbDat.setForeground(Color.RED);
			lbDat.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lbDat.setBounds(349, 279, 16, 14);
			contentPanel.add(lbDat);
			lbDat.setVisible(false);

			
			

		
		
		}

		public boolean validacija() {
			boolean provera = true;	
			String poruka = "";
			Pattern r = Pattern.compile(format);
		    Matcher m = r.matcher(txtTermin.getText());
			
			while(true) {
			
				
			    if (m.matches())
			    {
			      provera = true;
			    }
			    else {
			    	provera = false;
				      poruka +="-Datum servisa mora biti u formatu HH:MM dd.mm.yyyy \n";
			    	
			    }
			    if(txtID.getText().isEmpty()) {
					lbID.setVisible(true);
					provera = false;
					}
			else {
				for(ServisAutomobila servis : servisi) {
					if(Integer.parseInt(txtID.getText()) == servis.getId()) {
						
						JOptionPane.showMessageDialog(null,"Servis sa tim ID-om vec postoji!");	
						provera = false;
					}
					
				}
			}
			if(txtTermin.getText().isEmpty()) {
					lbDat.setVisible(true);
					provera = false;
					}
			
			 
			 
			 
			 
			 if(provera == false)JOptionPane.showMessageDialog(null,"POLJA OZNACENA ZVEZDICOM NE SMEJU BITI PRAZNA!");
			 
			 try {
					Integer.parseInt(txtID.getText().trim());
				}catch (NumberFormatException e) {
					poruka += "- ID mora biti broj!\n";
					provera = false;
				}
			 
			 
			 
			 JOptionPane.showMessageDialog(null,poruka);
				return provera;
			}	
			}
}
