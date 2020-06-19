package window.Admin;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import model.Administrator;
import model.Musterija;
import servFunkc.ServisaAuto;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class DodajAdmin extends JDialog {
	private JTextField txtID;
	private JTextField txtIme;
	private JTextField txtPrez;
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
	private JLabel lbBr;
	private JLabel lbUser;
	private JLabel lbPass;
	private JLabel lbJmbg;
	private JLabel lbPla;

	public ArrayList<Administrator> admini = new ArrayList<Administrator>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodajAdmin dialog = new DodajAdmin();
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
	public DodajAdmin() {
		setTitle("Dodavanje administratora");
		setBounds(100, 100, 450, 700);
		getContentPane().setLayout(null);
		
		if (ServisaAuto.servis12.getAdmin().size()==0)
			ServisaAuto.servis12.ucitajAdmin();
			admini = ServisaAuto.servis12.getAdmin();
		
		JLabel lblNewLabel = new JLabel("Unesite podatke za novog administratora");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 11, 414, 20);
		getContentPane().add(lblNewLabel);
		
		txtID = new JTextField();
		txtID.setColumns(10);
		txtID.setBounds(77, 58, 271, 26);
		getContentPane().add(txtID);
		
		JLabel label = new JLabel("ID");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(77, 42, 271, 21);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Ime");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(77, 95, 271, 21);
		getContentPane().add(label_1);
		
		txtIme = new JTextField();
		txtIme.setColumns(10);
		txtIme.setBounds(77, 111, 271, 26);
		getContentPane().add(txtIme);
		
		JLabel label_2 = new JLabel("Prezime");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(77, 148, 271, 21);
		getContentPane().add(label_2);
		
		txtPrez = new JTextField();
		txtPrez.setColumns(10);
		txtPrez.setBounds(77, 164, 271, 26);
		getContentPane().add(txtPrez);
		
		JLabel label_3 = new JLabel("Adresa");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(77, 201, 271, 21);
		getContentPane().add(label_3);
		
		txtAdresa = new JTextField();
		txtAdresa.setColumns(10);
		txtAdresa.setBounds(77, 217, 271, 26);
		getContentPane().add(txtAdresa);
		
		JLabel label_4 = new JLabel("Broj telefona");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(77, 254, 271, 21);
		getContentPane().add(label_4);
		
		txtBroj = new JTextField();
		txtBroj.setColumns(10);
		txtBroj.setBounds(77, 270, 271, 26);
		getContentPane().add(txtBroj);
		
		JLabel label_5 = new JLabel("Username");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(77, 307, 271, 21);
		getContentPane().add(label_5);
		
		txtUser = new JTextField();
		txtUser.setColumns(10);
		txtUser.setBounds(77, 323, 271, 26);
		getContentPane().add(txtUser);
		
		JLabel label_6 = new JLabel("Password");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(77, 360, 271, 21);
		getContentPane().add(label_6);
		
		txtPass = new JTextField();
		txtPass.setColumns(10);
		txtPass.setBounds(77, 376, 271, 26);
		getContentPane().add(txtPass);
		
		JLabel label_7 = new JLabel("JMBG");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setBounds(77, 413, 271, 21);
		getContentPane().add(label_7);
		
		txtJmbg = new JTextField();
		txtJmbg.setColumns(10);
		txtJmbg.setBounds(77, 429, 271, 26);
		getContentPane().add(txtJmbg);
		
		JLabel label_8 = new JLabel("POL");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setBounds(77, 466, 271, 21);
		getContentPane().add(label_8);
		
		JRadioButton rdMuski = new JRadioButton("Muski");
		rdMuski.setSelected(true);
		rdMuski.setBounds(77, 494, 109, 23);
		getContentPane().add(rdMuski);
		
		JRadioButton rdZenski = new JRadioButton("Zenski");
		rdZenski.setBounds(239, 494, 109, 23);
		getContentPane().add(rdZenski);
		
		ButtonGroup btg = new ButtonGroup();
		btg.add(rdMuski);
		btg.add(rdZenski);
		
		JButton btDodaj = new JButton("DODAJ");
		btDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(validacija()) {
					
					int id = Integer.parseInt(txtID.getText().trim());
					
					String ime = txtIme.getText();
					String prezime = txtPrez.getText();
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
					
					
					
					 // DODAVANJE:
						Administrator novi = new Administrator(id,false,ime,prezime,jmbg,pol,adresa,brtel,user,pass,plata);
						ServisaAuto.servis12.dodajAdmin(novi);
						ServisaAuto.servis12.sacuvajAdmin(novi);
					
					txtID.setText("");
					txtIme.setText("");
					txtPrez.setText("");
					
					txtAdresa.setText("");
					 txtBroj.setText("");
					txtUser.setText("");
					txtPass.setText("");
					txtJmbg.setText("");
					txtPlata.setText("");
					JOptionPane.showMessageDialog(getContentPane(), "Uspesno ste dodali administratora!");
					
					
					}
			
			}
		});
		btDodaj.setBounds(77, 600, 89, 23);
		getContentPane().add(btDodaj);
		
		JButton btIzlaz = new JButton("IZADJI");
		btIzlaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		btIzlaz.setBounds(259, 600, 89, 23);
		getContentPane().add(btIzlaz);
		
		txtPlata = new JTextField();
		txtPlata.setColumns(10);
		txtPlata.setBounds(77, 540, 271, 26);
		getContentPane().add(txtPlata);
		
		JLabel lblPlata = new JLabel("Plata");
		lblPlata.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlata.setBounds(77, 524, 271, 21);
		getContentPane().add(lblPlata);
		
		 lbID = new JLabel("*");
		lbID.setForeground(Color.RED);
		lbID.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbID.setBounds(358, 64, 18, 14);
		getContentPane().add(lbID);
		lbID.setVisible(false);
		
		 lbIme = new JLabel("*");
		lbIme.setForeground(Color.RED);
		lbIme.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbIme.setBounds(358, 117, 18, 14);
		getContentPane().add(lbIme);
		lbIme.setVisible(false);
		
		 lbPrez = new JLabel("*");
		lbPrez.setForeground(Color.RED);
		lbPrez.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbPrez.setBounds(358, 170, 18, 14);
		getContentPane().add(lbPrez);
		lbPrez.setVisible(false);
		
		lbAdr = new JLabel("*");
		lbAdr.setForeground(Color.RED);
		lbAdr.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbAdr.setBounds(358, 223, 18, 14);
		getContentPane().add(lbAdr);
		lbAdr.setVisible(false);
		
		
		lbBr = new JLabel("*");
		lbBr.setForeground(Color.RED);
		lbBr.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbBr.setBounds(358, 276, 18, 14);
		getContentPane().add(lbBr);
		lbBr.setVisible(false);
		
		
		lbUser = new JLabel("*");
		lbUser.setForeground(Color.RED);
		lbUser.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbUser.setBounds(358, 329, 18, 14);
		getContentPane().add(lbUser);
		lbUser.setVisible(false);
		
		
		lbPass = new JLabel("*");
		lbPass.setForeground(Color.RED);
		lbPass.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbPass.setBounds(358, 382, 18, 14);
		getContentPane().add(lbPass);
		lbPass.setVisible(false);
		
		
		lbJmbg = new JLabel("*");
		lbJmbg.setForeground(Color.RED);
		lbJmbg.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbJmbg.setBounds(358, 435, 18, 14);
		getContentPane().add(lbJmbg);
		lbJmbg.setVisible(false);
		
		
		lbPla = new JLabel("*");
		lbPla.setForeground(Color.RED);
		lbPla.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbPla.setBounds(358, 546, 18, 14);
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
			
			for(Administrator admin : admini) {
				
				 if(Integer.parseInt(txtID.getText()) == admin.getId()) {
						
						JOptionPane.showMessageDialog(null,"Administrator sa tim ID-om vec postoji!");	
						provera = false;
					}
					
				}
		}
		
		if(txtIme.getText().isEmpty()) {
				lbIme.setVisible(true);
				provera = false;
				}
		 if(txtPrez.getText().isEmpty()) {
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
