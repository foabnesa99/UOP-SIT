package window.Admin;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import servFunkc.ServisaAuto;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import model.Automobil;
import model.Musterija;
import model.Serviser;
import model.Automobil.MarkaVozila;
import model.Automobil.ModeliAuto;
import model.Automobil.VrstaGoriva;
import java.awt.Color;


public class DodajMust extends JDialog {
	private JTextField txtID;
	private JTextField txtIme;
	private JTextField txtPrezime;
	private JTextField txtAdresa;
	private JTextField txtBr;
	private JTextField txtUser;
	private JTextField txtPass;
	private JTextField txtJmbg;
	private JLabel lbID;
	private JLabel lbIme;
	private JLabel lbPrezime;
	private JLabel lbAdr;
	private JLabel lbBroj;
	private JLabel lbUser;
	private JLabel lbPass;
	private JLabel lbJmbg;
	
	
	
	
	
	
	public ArrayList<Musterija> muster = new ArrayList<Musterija>();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodajMust dialog = new DodajMust();
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
	public DodajMust() {
		
		
		setTitle("Dodavanje novog musterije");
		setBounds(100, 100, 450, 620);
		getContentPane().setLayout(null);
		
		if (ServisaAuto.servis12.getMusterija().size()==0)
			ServisaAuto.servis12.ucitajMusteriju();
			muster = ServisaAuto.servis12.getMusterija();
		
		
		JLabel lblNewLabel = new JLabel("Unesite podatke za novog musteriju");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 11, 414, 26);
		getContentPane().add(lblNewLabel);
		
		txtID = new JTextField();
		txtID.setBounds(83, 64, 271, 26);
		getContentPane().add(txtID);
		txtID.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(83, 48, 271, 21);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblIme = new JLabel("Ime");
		lblIme.setHorizontalAlignment(SwingConstants.CENTER);
		lblIme.setBounds(83, 101, 271, 21);
		getContentPane().add(lblIme);
		
		txtIme = new JTextField();
		txtIme.setColumns(10);
		txtIme.setBounds(83, 117, 271, 26);
		getContentPane().add(txtIme);
		
		JLabel lblPrezime = new JLabel("Prezime");
		lblPrezime.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrezime.setBounds(83, 154, 271, 21);
		getContentPane().add(lblPrezime);
		
		txtPrezime = new JTextField();
		txtPrezime.setColumns(10);
		txtPrezime.setBounds(83, 170, 271, 26);
		getContentPane().add(txtPrezime);
		
		JLabel lblAdresa = new JLabel("Adresa");
		lblAdresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdresa.setBounds(83, 207, 271, 21);
		getContentPane().add(lblAdresa);
		
		txtAdresa = new JTextField();
		txtAdresa.setColumns(10);
		txtAdresa.setBounds(83, 223, 271, 26);
		getContentPane().add(txtAdresa);
		
		JLabel lblBrojTelefona = new JLabel("Broj telefona");
		lblBrojTelefona.setHorizontalAlignment(SwingConstants.CENTER);
		lblBrojTelefona.setBounds(83, 260, 271, 21);
		getContentPane().add(lblBrojTelefona);
		
		txtBr = new JTextField();
		txtBr.setColumns(10);
		txtBr.setBounds(83, 276, 271, 26);
		getContentPane().add(txtBr);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBounds(83, 313, 271, 21);
		getContentPane().add(lblUsername);
		
		txtUser = new JTextField();
		txtUser.setColumns(10);
		txtUser.setBounds(83, 329, 271, 26);
		getContentPane().add(txtUser);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(83, 366, 271, 21);
		getContentPane().add(lblPassword);
		
		txtPass = new JTextField();
		txtPass.setColumns(10);
		txtPass.setBounds(83, 382, 271, 26);
		getContentPane().add(txtPass);
		
		JLabel lblJmbg = new JLabel("JMBG");
		lblJmbg.setHorizontalAlignment(SwingConstants.CENTER);
		lblJmbg.setBounds(83, 419, 271, 21);
		getContentPane().add(lblJmbg);
		
		txtJmbg = new JTextField();
		txtJmbg.setColumns(10);
		txtJmbg.setBounds(83, 435, 271, 26);
		getContentPane().add(txtJmbg);
		
		JLabel lblPol = new JLabel("POL");
		lblPol.setHorizontalAlignment(SwingConstants.CENTER);
		lblPol.setBounds(83, 472, 271, 21);
		getContentPane().add(lblPol);
		
		JRadioButton rbMuski = new JRadioButton("Muski");
		rbMuski.setSelected(true);
		rbMuski.setBounds(83, 500, 109, 23);
		getContentPane().add(rbMuski);
		
		JRadioButton rbZenski = new JRadioButton("Zenski");
		rbZenski.setBounds(245, 500, 109, 23);
		getContentPane().add(rbZenski);
		
		JButton btnNewButton = new JButton("DODAJ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(validacija()) {
				int id = Integer.parseInt(txtID.getText().trim());
				
				String ime = txtIme.getText();
				String prezime = txtPrezime.getText();
				long jmbg = Long.parseLong(txtJmbg.getText());
				String pol = "";
				if(rbMuski.isSelected()) {
					pol = "Muski";
				}
				if(rbZenski.isSelected()) {
					pol = "Zenski";
				}
				String adresa = txtAdresa.getText();
				String brtel = txtBr.getText();
				String user = txtUser.getText();
				String pass = txtPass.getText();
				short nagrb = 0;
				
				
				
				 // DODAVANJE:
					Musterija novi = new Musterija(id,false,ime,prezime,jmbg,pol,adresa,brtel,user,pass,nagrb);
					ServisaAuto.servis12.dodajMusteriju(novi);
					ServisaAuto.servis12.sacuvajMusteriju(novi);
				
				txtID.setText("");
				txtIme.setText("");
				txtPrezime.setText("");
				
				txtAdresa.setText("");
				 txtBr.setText("");
				txtUser.setText("");
				txtPass.setText("");
				txtJmbg.setText("");
					
				JOptionPane.showMessageDialog(getContentPane(), "Uspesno ste dodali musteriju!");
				
				
				}
			}
		});
		btnNewButton.setBounds(83, 547, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("IZADJI");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		
		btnNewButton_1.setBounds(265, 547, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		ButtonGroup bg=new ButtonGroup();    
		bg.add(rbMuski);
		bg.add(rbZenski);    
		
		lbID = new JLabel("*");
		lbID.setForeground(Color.RED);
		lbID.setBounds(365, 64, 23, 26);
		getContentPane().add(lbID);
		lbID.setVisible(false);
		
		
		lbIme = new JLabel("*");
		lbIme.setForeground(Color.RED);
		lbIme.setBounds(364, 123, 23, 26);
		getContentPane().add(lbIme);
		lbIme.setVisible(false);
		
		lbPrezime = new JLabel("*");
		lbPrezime.setForeground(Color.RED);
		lbPrezime.setBounds(364, 176, 23, 26);
		getContentPane().add(lbPrezime);
		lbPrezime.setVisible(false);
		
		lbAdr = new JLabel("*");
		lbAdr.setForeground(Color.RED);
		lbAdr.setBounds(364, 229, 23, 26);
		getContentPane().add(lbAdr);
		lbAdr.setVisible(false);
		
		lbBroj = new JLabel("*");
		lbBroj.setForeground(Color.RED);
		lbBroj.setBounds(364, 282, 23, 26);
		getContentPane().add(lbBroj);
		lbBroj.setVisible(false);
		
		lbUser = new JLabel("*");
		lbUser.setForeground(Color.RED);
		lbUser.setBounds(364, 335, 23, 26);
		getContentPane().add(lbUser);
		lbUser.setVisible(false);
		
		lbPass = new JLabel("*");
		lbPass.setForeground(Color.RED);
		lbPass.setBounds(364, 388, 23, 26);
		getContentPane().add(lbPass);
		lbPass.setVisible(false);
		
		lbJmbg = new JLabel("*");
		lbJmbg.setForeground(Color.RED);
		lbJmbg.setBounds(364, 441, 23, 26);
		getContentPane().add(lbJmbg);
		lbJmbg.setVisible(false);
		
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
			 for(Musterija must : muster) {
					if(Integer.parseInt(txtID.getText()) == must.getId()) {
						
						JOptionPane.showMessageDialog(null,"Musterija sa tim ID-om vec postoji!");	
						provera = false;
					}
					
				}
		}
		if(txtIme.getText().isEmpty()) {
				lbIme.setVisible(true);
				provera = false;
				}
		 if(txtPrezime.getText().isEmpty()) {
				lbPrezime.setVisible(true);
				provera = false;
			}
		 if(txtBr.getText().isEmpty()) {
				lbBroj.setVisible(true);
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
		 if(txtJmbg.getText().trim().length() !=13) {
			 poruka += "- JMBG mora imati tacno 13 cifara!";
			 provera = false;
			 
		 }
		 
		 
		 JOptionPane.showMessageDialog(null,poruka);
			return provera;
		}	
		}


}
