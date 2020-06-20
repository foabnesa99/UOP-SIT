package window.Admin;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Automobil;
import model.ServDeo;
import model.ServKnjizica;
import model.ServisAutomobila;
import model.Serviser;
import model.Automobil.MarkaVozila;
import model.Automobil.ModeliAuto;
import servFunkc.ServisaAuto;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class DodajKnjizica extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtID;
	private ArrayList<ServisAutomobila> servisi = new ArrayList<ServisAutomobila>();
	private ArrayList<ServKnjizica> knjizice  = new ArrayList<ServKnjizica>();
	private ArrayList<Automobil> auti = new ArrayList<Automobil>();
 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DodajKnjizica dialog = new DodajKnjizica();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DodajKnjizica() {
		if (ServisaAuto.servis12.getServis().size()==0)
			ServisaAuto.servis12.ucitajServis();
			servisi = ServisaAuto.servis12.getServis();
			
			if (ServisaAuto.servis12.getKnjizica().size()==0)
				ServisaAuto.servis12.ucitajKnjizicu();
				knjizice = ServisaAuto.servis12.getKnjizica();
				if (ServisaAuto.servis12.getAuti().size()==0)
					ServisaAuto.servis12.ucitajAutomobile();
					auti = ServisaAuto.servis12.getAuti();
		
		setTitle("Dodavanje servisne knjizice");
		setBounds(100, 100, 450, 550);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Unesite podatke za novu servisnu knjizicu");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 13, 408, 16);
		contentPanel.add(lblNewLabel);
		
		txtID = new JTextField();
		txtID.setBounds(92, 59, 248, 27);
		contentPanel.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(92, 42, 248, 16);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblAutomobil = new JLabel("Automobil");
		lblAutomobil.setHorizontalAlignment(SwingConstants.CENTER);
		lblAutomobil.setBounds(92, 99, 248, 16);
		contentPanel.add(lblAutomobil);
		
		JComboBox comboAuto = new JComboBox();
		comboAuto.setBounds(92, 128, 248, 27);
		contentPanel.add(comboAuto);
		comboAuto.setModel(new DefaultComboBoxModel<Automobil>(auti.toArray(new Automobil[0])));
		
		DefaultListModel<ServisAutomobila> dlm = new DefaultListModel<ServisAutomobila>();
		for(ServisAutomobila sd : servisi ){
		 dlm.addElement(sd);
		}    
		JList<ServisAutomobila> servisLista = new JList<ServisAutomobila>(dlm);
		servisLista.setBounds(92, 192, 248, 238);
		contentPanel.add(servisLista);
		
		JLabel lblServisi = new JLabel("Servisi");
		lblServisi.setHorizontalAlignment(SwingConstants.CENTER);
		lblServisi.setBounds(92, 163, 248, 16);
		contentPanel.add(lblServisi);
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//if(validacija()) {
					int id = Integer.parseInt(txtID.getText().trim());
					
					
					Automobil auto = (Automobil)comboAuto.getSelectedItem();
					
					
					ArrayList<ServisAutomobila> servisiauto= new ArrayList<ServisAutomobila>();
					servisiauto.addAll(servisLista.getSelectedValuesList());
					
					
					 // DODAVANJE:
						ServKnjizica novi = new ServKnjizica(id,false,auto,servisiauto);
						ServisaAuto.servis12.dodajServKnJiz(novi);
						ServisaAuto.servis12.sacuvajKnjizica(novi);
					
					JOptionPane.showMessageDialog(getContentPane(), "Uspesno ste dodali servisnu knjizicu!");
					
				//	}
			
				
			}
		});
		btnDodaj.setBounds(92, 465, 97, 25);
		contentPanel.add(btnDodaj);
		
		JButton btnIzlaz = new JButton("Izadji");
		btnIzlaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		btnIzlaz.setBounds(243, 465, 97, 25);
		contentPanel.add(btnIzlaz);
	}
}
