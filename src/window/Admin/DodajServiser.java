package window.Admin;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import model.Automobil;
import model.Musterija;
import model.Serviser;
import model.Serviser.Specijalizacija;
import servFunkc.ServisaAuto;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class DodajServiser extends JDialog {
	private JTextField txtID;
	private JTextField txtIme;
	private JTextField txtPrezime;
	private JTextField txtAdresa;
	private JTextField txtBroj;
	private JTextField txtUser;
	private JTextField txtPass;
	private JTextField txtJmbg;
	private JTextField txtPlata;
	private JLabel lbID;
	private JLabel lbIme;
	private JLabel lbPrez;
	private JLabel lbAdr;
	private JLabel lbJmbg;
	private JLabel lbBr;
	private JLabel lbUser;
	private JLabel lbPass;
	private JLabel lbPla;
	public ArrayList<Serviser> serviseri = new ArrayList<Serviser>();
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodajServiser dialog = new DodajServiser();
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
	public DodajServiser() {
		if (ServisaAuto.servis12.getServ().size()==0)
			ServisaAuto.servis12.ucitajServisera();
			serviseri = ServisaAuto.servis12.getServ();
		
		setTitle("Dodavanje novog servisera");
		setBounds(100, 100, 450, 750);
		getContentPane().setLayout(null);
		
		txtID = new JTextField();
		txtID.setColumns(10);
		txtID.setBounds(73, 60, 271, 26);
		getContentPane().add(txtID);
		
		JLabel label = new JLabel("ID");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(73, 44, 271, 21);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Ime");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(73, 97, 271, 21);
		getContentPane().add(label_1);
		
		txtIme = new JTextField();
		txtIme.setColumns(10);
		txtIme.setBounds(73, 113, 271, 26);
		getContentPane().add(txtIme);
		
		JLabel label_2 = new JLabel("Prezime");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(73, 150, 271, 21);
		getContentPane().add(label_2);
		
		txtPrezime = new JTextField();
		txtPrezime.setColumns(10);
		txtPrezime.setBounds(73, 166, 271, 26);
		getContentPane().add(txtPrezime);
		
		JLabel label_3 = new JLabel("Adresa");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(73, 203, 271, 21);
		getContentPane().add(label_3);
		
		txtAdresa = new JTextField();
		txtAdresa.setColumns(10);
		txtAdresa.setBounds(73, 219, 271, 26);
		getContentPane().add(txtAdresa);
		
		JLabel lblUnesitePodatkeZa = new JLabel("Unesite podatke za novog servisera");
		lblUnesitePodatkeZa.setHorizontalAlignment(SwingConstants.CENTER);
		lblUnesitePodatkeZa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUnesitePodatkeZa.setBounds(10, 11, 414, 26);
		getContentPane().add(lblUnesitePodatkeZa);
		
		JLabel label_4 = new JLabel("Broj telefona");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(73, 252, 271, 21);
		getContentPane().add(label_4);
		
		txtBroj = new JTextField();
		txtBroj.setColumns(10);
		txtBroj.setBounds(73, 268, 271, 26);
		getContentPane().add(txtBroj);
		
		JLabel label_5 = new JLabel("Username");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(73, 305, 271, 21);
		getContentPane().add(label_5);
		
		txtUser = new JTextField();
		txtUser.setColumns(10);
		txtUser.setBounds(73, 321, 271, 26);
		getContentPane().add(txtUser);
		
		JLabel label_6 = new JLabel("Password");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(73, 358, 271, 21);
		getContentPane().add(label_6);
		
		txtPass = new JTextField();
		txtPass.setColumns(10);
		txtPass.setBounds(73, 374, 271, 26);
		getContentPane().add(txtPass);
		
		JLabel label_7 = new JLabel("JMBG");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setBounds(73, 411, 271, 21);
		getContentPane().add(label_7);
		
		txtJmbg = new JTextField();
		txtJmbg.setColumns(10);
		txtJmbg.setBounds(73, 427, 271, 26);
		getContentPane().add(txtJmbg);
		
		JLabel label_8 = new JLabel("POL");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setBounds(73, 563, 271, 21);
		getContentPane().add(label_8);
		
		JRadioButton rdMuski = new JRadioButton("Muski");
		rdMuski.setSelected(true);
		rdMuski.setBounds(73, 591, 109, 23);
		getContentPane().add(rdMuski);
		
		JRadioButton rdZenski = new JRadioButton("Zenski");
		rdZenski.setBounds(235, 591, 109, 23);
		getContentPane().add(rdZenski);
		
		JLabel lblPlata = new JLabel("Plata");
		lblPlata.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlata.setBounds(73, 464, 271, 21);
		getContentPane().add(lblPlata);
		
		txtPlata = new JTextField();
		txtPlata.setColumns(10);
		txtPlata.setBounds(73, 480, 271, 26);
		getContentPane().add(txtPlata);
		
		JLabel lblSpecijalizacija = new JLabel("Specijalizacija");
		lblSpecijalizacija.setHorizontalAlignment(SwingConstants.CENTER);
		lblSpecijalizacija.setBounds(73, 517, 271, 21);
		getContentPane().add(lblSpecijalizacija);
		
		JComboBox comboSpec = new JComboBox(Serviser.Specijalizacija.values());
		comboSpec.setBounds(73, 536, 271, 20);
		getContentPane().add(comboSpec);
		
		JButton btnNewButton = new JButton("Dodaj");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(validacija()) {
					int id = Integer.parseInt(txtID.getText().trim());
					
					String ime = txtIme.getText();
					String prezime = txtPrezime.getText();
					long jmbg = Long.parseLong(txtJmbg.getText());
					String pol = "";
					if(rdMuski.isSelected()) {
						pol = "Muski";
					}
					if(rdZenski.isSelected()) {
						pol = "Zenski";
					}
					String adresa = txtAdresa.getText();
					String brtel = txtBroj.getText();
					String user = txtUser.getText();
					String pass = txtPass.getText();
					int plata = Integer.parseInt(txtPlata.getText());
					Specijalizacija spec = (Specijalizacija) comboSpec.getSelectedItem();
					
					
					 // DODAVANJE:
						Serviser novi = new Serviser(id,false,ime,prezime,jmbg,pol,adresa,brtel,user,pass,plata,spec);
						ServisaAuto.servis12.dodajServ(novi);
						ServisaAuto.servis12.sacuvajServisera(novi);
					
					txtID.setText("");
					txtIme.setText("");
					txtPrezime.setText("");
					
					txtAdresa.setText("");
					 txtBroj.setText("");
					txtUser.setText("");
					txtPass.setText("");
					txtJmbg.setText("");
					txtPlata.setText("");
					JOptionPane.showMessageDialog(getContentPane(), "Uspesno ste dodali servisera!");
				}
			}
		});
		btnNewButton.setBounds(73, 649, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Izadji");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			dispose();
			}
		});
		btnNewButton_1.setBounds(255, 649, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		 lbID = new JLabel("*");
		lbID.setForeground(Color.RED);
		lbID.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbID.setBounds(354, 66, 46, 14);
		getContentPane().add(lbID);
		lbID.setVisible(false);
		
		 lbIme = new JLabel("*");
		lbIme.setForeground(Color.RED);
		lbIme.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbIme.setBounds(354, 119, 46, 14);
		getContentPane().add(lbIme);
		lbIme.setVisible(false);
		
		 lbPrez = new JLabel("*");
		lbPrez.setForeground(Color.RED);
		lbPrez.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbPrez.setBounds(354, 172, 46, 14);
		getContentPane().add(lbPrez);
		lbPrez.setVisible(false);
		
		lbAdr = new JLabel("*");
		lbAdr.setForeground(Color.RED);
		lbAdr.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbAdr.setBounds(354, 225, 46, 14);
		getContentPane().add(lbAdr);
		lbAdr.setVisible(false);
		
		
		lbBr = new JLabel("*");
		lbBr.setForeground(Color.RED);
		lbBr.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbBr.setBounds(354, 274, 46, 14);
		getContentPane().add(lbBr);
		lbBr.setVisible(false);
		
		lbUser = new JLabel("*");
		lbUser.setForeground(Color.RED);
		lbUser.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbUser.setBounds(354, 327, 46, 14);
		getContentPane().add(lbUser);
		lbUser.setVisible(false);
		
		lbPass = new JLabel("*");
		lbPass.setForeground(Color.RED);
		lbPass.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbPass.setBounds(354, 380, 46, 14);
		getContentPane().add(lbPass);
		lbPass.setVisible(false);
		
		
		 lbJmbg = new JLabel("*");
		lbJmbg.setForeground(Color.RED);
		lbJmbg.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbJmbg.setBounds(354, 433, 46, 14);
		getContentPane().add(lbJmbg);
		lbJmbg.setVisible(false);
		
		lbPla = new JLabel("*");
		lbPla.setForeground(Color.RED);
		lbPla.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbPla.setBounds(354, 486, 46, 14);
		getContentPane().add(lbPla);
		lbPla.setVisible(false);
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
			for(Serviser serv : serviseri) {
				if(Integer.parseInt(txtID.getText()) == serv.getId()) {
					
					JOptionPane.showMessageDialog(null,"Serviser sa tim ID-om vec postoji!");	
					provera = false;
				}
				
			}
		 
		}
		if(txtIme.getText().isEmpty()) {
				lbIme.setVisible(true);
				provera = false;
				}
		 if(txtPrezime.getText().isEmpty()) {
				lbPrez.setVisible(true);
				provera = false;
			}
		 if(txtBroj.getText().isEmpty()) {
				lbBr.setVisible(true);
				provera = false;
			}
		 if(txtUser.getText().isEmpty()) {
				lbUser.setVisible(true);
				provera = false;
			}
		 if(txtPass.getText().isEmpty()) {
				lbPass.setVisible(true);
				provera = false;
			}
		 if(txtJmbg.getText().isEmpty()) {
				lbJmbg.setVisible(true);
				provera = false;
			}
		 if(txtAdresa.getText().isEmpty()) {
				lbAdr.setVisible(true);
				provera = false;
			}
		 if(txtPlata.getText().isEmpty()) {
			 lbPla.setVisible(true);
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
			 Long.parseLong(txtJmbg.getText().trim());
			}catch (NumberFormatException e) {
				poruka += "- JMBG mora biti broj\n";
				provera = false;
			}
		 try {
				Integer.parseInt(txtPlata.getText().trim());
			}catch (NumberFormatException e) {
				poruka += "- Plata mora biti broj!\n";
				provera = false;
			}
		 
		 if(txtJmbg.getText().trim().length() !=13) {
			 poruka += "- JMBG mora imati tacno 13 cifara!";
			 provera = false;
			 
		 }
		 
		 
		 JOptionPane.showMessageDialog(null,poruka);
			return provera;
		}	
		}



}
