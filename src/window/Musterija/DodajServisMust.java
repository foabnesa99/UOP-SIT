package window.Musterija;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.awt.event.ActionEvent;
import model.Automobil;
import model.Musterija;
import model.ServDeo;
import model.Automobil.MarkaVozila;
import model.Automobil.ModeliAuto;
import model.Automobil.VrstaGoriva;
import model.ServisAutomobila.Status;
import servFunkc.ServisaAuto;
import window.LoginWin;
import model.ServisAutomobila;
import model.Serviser;
public class DodajServisMust extends JDialog {
	private JTextField txtID;
	private List<Automobil> auti;
	private DefaultComboBoxModel<Object> cmb;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodajServisMust dialog = new DodajServisMust();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public DodajServisMust() {
		auti = ServisaAuto.servis12.getAuti();
		auti =  ServisaAuto.servis12.getAuti().stream().filter(auto -> {
			System.out.println(auto);
			return auto.getVlasnik().getId() == LoginWin.currentUser.getId();
				}).collect(Collectors.toList());
		setTitle("Zakazivanje novog servisa");
		cmb = new DefaultComboBoxModel<Object>(auti.toArray());
		
		setBounds(100, 100, 560, 600);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Unesite podatke za zakazivanje novog servisa");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(12, 13, 518, 23);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(108, 49, 329, 23);
		getContentPane().add(lblNewLabel_1);
		
		txtID = new JTextField();
		txtID.setBounds(118, 75, 289, 23);
		getContentPane().add(txtID);
		txtID.setColumns(10);
		
		JLabel lblVasiAutomobili = new JLabel("Vasi automobili:");
		lblVasiAutomobili.setHorizontalAlignment(SwingConstants.CENTER);
		lblVasiAutomobili.setBounds(108, 111, 329, 23);
		getContentPane().add(lblVasiAutomobili);
		
		JComboBox comboAuto = new JComboBox(cmb);
		comboAuto.setBounds(118, 147, 289, 23);
		getContentPane().add(comboAuto);
		
		JLabel lblOpisServisneIntervencije = new JLabel("Opis servisne intervencije:");
		lblOpisServisneIntervencije.setHorizontalAlignment(SwingConstants.CENTER);
		lblOpisServisneIntervencije.setBounds(108, 198, 329, 23);
		getContentPane().add(lblOpisServisneIntervencije);
		
		JTextArea txtOpis = new JTextArea();
		txtOpis.setBounds(118, 234, 294, 145);
		getContentPane().add(txtOpis);
		
		JButton btnNewButton = new JButton("Zakazi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//if(validacija()) {
					int id = Integer.parseInt(txtID.getText().trim());
					
					Automobil automobil = (Automobil)comboAuto.getSelectedItem(); 
					MarkaVozila marka = automobil.getMarka();
					ModeliAuto model = automobil.getModel();
					String opis = txtOpis.getText();
					//5|false|BMW|_320|1|2020-01-20T10:50|Zamena stakla vetrobran|Zakazan|2
					Serviser serviser = new Serviser();
					LocalDateTime termin = LocalDateTime.now();
					Status status = ServisAutomobila.Status.Zakazan;
					ArrayList<ServDeo> delovi = new ArrayList<ServDeo>();
					 //int id, boolean obrisan,MarkaVozila marka,ModeliAuto model,Serviser serv,LocalDateTime termin,String opis, 
					// Status status,	ArrayList<ServDeo> delovi
						ServisAutomobila novi = new ServisAutomobila(id,false, marka, model,serviser,termin, opis,status,delovi);
						ServisaAuto.servis12.dodajServis(novi);
						ServisaAuto.servis12.sacuvajServis(novi);
					
					JOptionPane.showMessageDialog(getContentPane(), "Uspesno ste zakazali servis!");
					
					//	}
			
			
			
			
			}
		});
		btnNewButton.setBounds(108, 425, 131, 58);
		getContentPane().add(btnNewButton);
		
		JButton btnOdustani = new JButton("Odustani");
		btnOdustani.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		btnOdustani.setBounds(276, 425, 131, 58);
		getContentPane().add(btnOdustani);
		
		
		
		
		
	}
}
