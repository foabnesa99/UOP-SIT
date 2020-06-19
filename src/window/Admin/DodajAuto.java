package window.Admin;


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
import model.Automobil.VrstaGoriva;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.beans.PropertyChangeEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import servFunkc.ServisaAuto;
import java.awt.Color;

public class DodajAuto extends JDialog {
public ComboBoxModel m;
public ComboBoxModel modelAuta;
public JComboBox ModelCombo;
private final JPanel contentPanel = new JPanel();
private JTextField txtGodina;
private JTextField txtZapremina;
private JTextField txtSnaga;
private JTextField txtID;
private JLabel lbID;
private JLabel lbSna;
private JLabel lbZap;
private JLabel lbGod;

public JComboBox MarkaCombo;
public JComboBox comboGorivo;
public JComboBox comboVlasnik;
public Musterija must;
public Automobil auto;
public ArrayList<Musterija> muster = new ArrayList<Musterija>();
public ArrayList<Automobil> auti = new ArrayList<Automobil>();

/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DodajAuto dialog = new DodajAuto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DodajAuto() {
		
		if (ServisaAuto.servis12.getMusterija().size()==0)
		ServisaAuto.servis12.ucitajMusteriju();
		muster = ServisaAuto.servis12.getMusterija();
		if (ServisaAuto.servis12.getAuti().size()==0)
			ServisaAuto.servis12.ucitajAutomobile();
			auti = ServisaAuto.servis12.getAuti();
		
		
		setTitle("Dodavanje novog automobila");
		setBounds(100, 100, 450, 610);
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
		
			MarkaCombo.setBounds(75, 117, 251, 20);
			contentPanel.add(MarkaCombo);
		}
		{
			ModelCombo = new JComboBox();
			ModelCombo.setBounds(75, 172, 251, 20);
			contentPanel.add(ModelCombo);
		}
		{
			JLabel lblNewLabel = new JLabel("Unesite podatke za nov automobil:");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel.setBounds(40, 11, 322, 20);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Marka:");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblNewLabel_1.setBounds(147, 94, 102, 20);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblModel = new JLabel("Model");
			lblModel.setHorizontalAlignment(SwingConstants.CENTER);
			lblModel.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblModel.setBounds(147, 148, 102, 20);
			contentPanel.add(lblModel);
		}
		
		txtGodina = new JTextField();
		txtGodina.setBounds(75, 225, 251, 20);
		contentPanel.add(txtGodina);
		txtGodina.setColumns(10);
		
		txtZapremina = new JTextField();
		txtZapremina.setColumns(10);
		txtZapremina.setBounds(75, 280, 251, 20);
		contentPanel.add(txtZapremina);
		
		txtSnaga = new JTextField();
		txtSnaga.setColumns(10);
		txtSnaga.setBounds(75, 340, 251, 20);
		contentPanel.add(txtSnaga);
		
		comboGorivo = new JComboBox(Automobil.VrstaGoriva.values());
		comboGorivo.setBounds(75, 397, 251, 20);
		contentPanel.add(comboGorivo);
		
		
		
			
	
		
		comboVlasnik = new JComboBox();
		comboVlasnik.setBounds(75, 451, 251, 20);
		contentPanel.add(comboVlasnik);
		comboVlasnik.setModel(new DefaultComboBoxModel<Musterija>(muster.toArray(new Musterija[0])));
		
		
		
		JLabel lblGodinaProizvodnje = new JLabel("Godina proizvodnje");
		lblGodinaProizvodnje.setHorizontalAlignment(SwingConstants.CENTER);
		lblGodinaProizvodnje.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGodinaProizvodnje.setBounds(138, 203, 125, 20);
		contentPanel.add(lblGodinaProizvodnje);
		
		JLabel lblZapreminaMotoraccm = new JLabel("Zapremina motora (ccm)");
		lblZapreminaMotoraccm.setHorizontalAlignment(SwingConstants.CENTER);
		lblZapreminaMotoraccm.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblZapreminaMotoraccm.setBounds(111, 256, 185, 20);
		contentPanel.add(lblZapreminaMotoraccm);
		
		JLabel lblSnagaMotoraks = new JLabel("Snaga motora (ks)");
		lblSnagaMotoraks.setHorizontalAlignment(SwingConstants.CENTER);
		lblSnagaMotoraks.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSnagaMotoraks.setBounds(125, 311, 152, 20);
		contentPanel.add(lblSnagaMotoraks);
		
		JLabel lblPogonskoGorivo = new JLabel("Vrsta goriva");
		lblPogonskoGorivo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPogonskoGorivo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPogonskoGorivo.setBounds(147, 371, 102, 20);
		contentPanel.add(lblPogonskoGorivo);
		
		JLabel lblVlasnik = new JLabel("Vlasnik");
		lblVlasnik.setHorizontalAlignment(SwingConstants.CENTER);
		lblVlasnik.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblVlasnik.setBounds(147, 428, 102, 20);
		contentPanel.add(lblVlasnik);
		
		
		JButton btnNewButton = new JButton("DODAJ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(validacija()) {
					int id = Integer.parseInt(txtID.getText().trim());
					
					MarkaVozila marka = (MarkaVozila) MarkaCombo.getSelectedItem();
					ModeliAuto model = (ModeliAuto) ModelCombo.getSelectedItem();
					short godproiz = Short.parseShort(txtGodina.getText().trim());					
					int zapremina = Integer.parseInt(txtZapremina.getText().trim());
					int snaga = Integer.parseInt(txtSnaga.getText().trim());
					VrstaGoriva vrstag = (VrstaGoriva) comboGorivo.getSelectedItem();
					Musterija must = (Musterija) comboVlasnik.getSelectedItem();
					
					 // DODAVANJE:
						Automobil novi = new Automobil(id,false, must, marka, model,godproiz, zapremina, snaga,vrstag);
						ServisaAuto.servis12.dodajAuto(novi);
						ServisaAuto.servis12.sacuvajAuto(novi);
					
					JOptionPane.showMessageDialog(getContentPane(), "Uspesno ste dodali automobil!");
					
						}
			
			
			}
		});
		btnNewButton.setBounds(75, 529, 115, 31);
		contentPanel.add(btnNewButton);
		
		JButton btnOdustani = new JButton("Odustani");
		btnOdustani.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		btnOdustani.setBounds(211, 529, 115, 31);
		contentPanel.add(btnOdustani);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblId.setBounds(147, 42, 102, 20);
		contentPanel.add(lblId);
		
		txtID = new JTextField();
		txtID.setColumns(10);
		txtID.setBounds(75, 63, 251, 20);
		contentPanel.add(txtID);
		
		lbID = new JLabel("*");
		lbID.setForeground(Color.RED);
		lbID.setHorizontalAlignment(SwingConstants.CENTER);
		lbID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbID.setBounds(336, 66, 46, 14);
		contentPanel.add(lbID);
		lbID.setVisible(false);
		
		lbGod = new JLabel("*");
		lbGod.setHorizontalAlignment(SwingConstants.CENTER);
		lbGod.setForeground(Color.RED);
		lbGod.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbGod.setBounds(336, 228, 46, 14);
		contentPanel.add(lbGod);
		lbGod.setVisible(false);
		
		lbZap = new JLabel("*");
		lbZap.setHorizontalAlignment(SwingConstants.CENTER);
		lbZap.setForeground(Color.RED);
		lbZap.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbZap.setBounds(336, 283, 46, 14);
		contentPanel.add(lbZap);
		lbZap.setVisible(false);
		
		lbSna = new JLabel("*");
		lbSna.setHorizontalAlignment(SwingConstants.CENTER);
		lbSna.setForeground(Color.RED);
		lbSna.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbSna.setBounds(336, 343, 46, 14);
		contentPanel.add(lbSna);
		lbSna.setVisible(false);
	}

public boolean validacija() {
	boolean provera = true;	
	String poruka = "";
	while(true) {
	if(txtID.getText().isEmpty()) {
			lbID.setVisible(true);
			provera = false;
			}
	else {
		
		for(Automobil auto : auti) {
			if(Integer.parseInt(txtID.getText()) == auto.getId()) {
				
				JOptionPane.showMessageDialog(null,"Automobil sa tim ID-om vec postoji!");	
				provera = false;
			}
			
		}
	}
	if(txtSnaga.getText().isEmpty()) {
			lbSna.setVisible(true);
			provera = false;
			}
	 if(txtZapremina.getText().isEmpty()) {
			lbZap.setVisible(true);
			provera = false;
		}
	 if(txtGodina.getText().isEmpty()) {
			lbGod.setVisible(true);
			provera = false;
		}
	
	 
	 
	 
	 if(provera == false)JOptionPane.showMessageDialog(null,"POLJA OZNACENA ZVEZDICOM NE SMEJU BITI PRAZNA!");
	 
	 try {
			Integer.parseInt(txtID.getText().trim());
		}catch (NumberFormatException e) {
			poruka += "- ID mora biti broj!\n";
			provera = false;
		}
	 try {
		 Integer.parseInt(txtSnaga.getText().trim());
		}catch (NumberFormatException e) {
			poruka += "- Snaga mora biti broj\n";
			provera = false;
		}
	 try {
		 Integer.parseInt(txtZapremina.getText().trim());
		}catch (NumberFormatException e) {
			poruka += "- Zapremina mora biti broj\n";
			provera = false;
		}
	 try {
		 Integer.parseInt(txtGodina.getText().trim());
		}catch (NumberFormatException e) {
			poruka += "- Godina proizvodnje mora biti broj\n";
			provera = false;
		}
	 JOptionPane.showMessageDialog(null,poruka);
		return provera;
	}	
	}


}