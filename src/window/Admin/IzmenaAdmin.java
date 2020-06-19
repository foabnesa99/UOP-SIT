package window.Admin;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import model.Administrator;
import model.Serviser;
import model.Serviser.Specijalizacija;
import servFunkc.ServisaAuto;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class IzmenaAdmin extends JDialog {
	private JTextField txtID;
	private JTextField txtIme;
	private JTextField txtPrez;
	private JTextField txtAdresa;
	private JTextField txtBr;
	private JTextField txtUser;
	private JTextField txtPass;
	private JTextField txtJmbg;
	private JTextField txtPlata;
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
					IzmenaAdmin dialog = new IzmenaAdmin();
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
	
	public IzmenaAdmin(int id) {
		this();
		Administrator admin = ServisaAuto.servis12.nadjiAdmin(id);
		txtID.setText(admin.getId()+"");
		txtIme.setText(admin.getIme());
		txtPrez.setText(admin.getPrezime());
		txtAdresa.setText(admin.getAdresa());
		txtBr.setText(admin.getBrTelefona());
		txtUser.setText(admin.getUsername());
		txtPass.setText(admin.getPassword());
		txtJmbg.setText(admin.getJmbg()+"");
		txtPlata.setText(admin.getPlata()+"");
		
		
	}
	
	
	public IzmenaAdmin() {
		setBounds(100, 100, 450, 700);
		getContentPane().setLayout(null);
		
		
		if (ServisaAuto.servis12.getAdmin().size()==0)
			ServisaAuto.servis12.ucitajAdmin();
			admini = ServisaAuto.servis12.getAdmin();
		
		txtID = new JTextField();
		txtID.setEnabled(false);
		txtID.setColumns(10);
		txtID.setBounds(80, 27, 271, 26);
		getContentPane().add(txtID);
		
		JLabel label = new JLabel("ID");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(80, 11, 271, 21);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Ime");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(80, 64, 271, 21);
		getContentPane().add(label_1);
		
		txtIme = new JTextField();
		txtIme.setColumns(10);
		txtIme.setBounds(80, 80, 271, 26);
		getContentPane().add(txtIme);
		
		JLabel label_2 = new JLabel("Prezime");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(80, 117, 271, 21);
		getContentPane().add(label_2);
		
		txtPrez = new JTextField();
		txtPrez.setColumns(10);
		txtPrez.setBounds(80, 133, 271, 26);
		getContentPane().add(txtPrez);
		
		JLabel label_3 = new JLabel("Adresa");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(80, 170, 271, 21);
		getContentPane().add(label_3);
		
		txtAdresa = new JTextField();
		txtAdresa.setColumns(10);
		txtAdresa.setBounds(80, 186, 271, 26);
		getContentPane().add(txtAdresa);
		
		JLabel label_4 = new JLabel("Broj telefona");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(80, 223, 271, 21);
		getContentPane().add(label_4);
		
		txtBr = new JTextField();
		txtBr.setColumns(10);
		txtBr.setBounds(80, 239, 271, 26);
		getContentPane().add(txtBr);
		
		JLabel label_5 = new JLabel("Username");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(80, 276, 271, 21);
		getContentPane().add(label_5);
		
		txtUser = new JTextField();
		txtUser.setColumns(10);
		txtUser.setBounds(80, 292, 271, 26);
		getContentPane().add(txtUser);
		
		JLabel label_6 = new JLabel("Password");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(80, 329, 271, 21);
		getContentPane().add(label_6);
		
		txtPass = new JTextField();
		txtPass.setColumns(10);
		txtPass.setBounds(80, 345, 271, 26);
		getContentPane().add(txtPass);
		
		JLabel label_7 = new JLabel("JMBG");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setBounds(80, 382, 271, 21);
		getContentPane().add(label_7);
		
		txtJmbg = new JTextField();
		txtJmbg.setColumns(10);
		txtJmbg.setBounds(80, 398, 271, 26);
		getContentPane().add(txtJmbg);
		
		JLabel label_8 = new JLabel("POL");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setBounds(80, 435, 271, 21);
		getContentPane().add(label_8);
		
		JRadioButton rdMuski = new JRadioButton("Muski");
		rdMuski.setSelected(true);
		rdMuski.setBounds(80, 463, 109, 23);
		getContentPane().add(rdMuski);
		
		JRadioButton rdZenski = new JRadioButton("Zenski");
		rdZenski.setBounds(242, 463, 109, 23);
		getContentPane().add(rdZenski);
		
		JButton btnIzmena = new JButton("IZMENA");
		btnIzmena.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(validacija()) {
					
					int id = Integer.parseInt(txtID.getText().trim());
						String ime = txtIme.getText().trim();
						String prez = txtPrez.getText().trim();
						long jmbg = Long.parseLong(txtJmbg.getText().trim());
						
						String pol = "";
						if (rdMuski.isSelected()) {
							pol = "Muski";
						}
						if(rdZenski.isSelected()) {
							pol = "Zenski";
						}
						String adresa = txtAdresa.getText().trim();
						String brTel = txtBr.getText().trim();
						String user = txtUser.getText().trim();
						String pass = txtPass.getText().trim();
						
						int plata = Integer.parseInt(txtPlata.getText().trim());
					
						Administrator novi = new Administrator(id,false,ime,prez,jmbg,pol,adresa,brTel,user,pass,plata);
							ServisaAuto.servis12.izmeniAdmin(novi);
							ServisaAuto.servis12.sacuvajAdmin();
						
						JOptionPane.showMessageDialog(getContentPane(), "Uspesno ste izmenili administratora!");
						
				
					
				}
			
			
			
			}
		});
		btnIzmena.setBounds(80, 569, 89, 23);
		getContentPane().add(btnIzmena);
		
		JButton button_1 = new JButton("IZADJI");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		button_1.setBounds(262, 569, 89, 23);
		getContentPane().add(button_1);
		
		txtPlata = new JTextField();
		txtPlata.setColumns(10);
		txtPlata.setBounds(80, 509, 271, 26);
		getContentPane().add(txtPlata);
		
		JLabel label_9 = new JLabel("Plata");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setBounds(80, 493, 271, 21);
		getContentPane().add(label_9);
		
		lbIme = new JLabel("*");
		lbIme.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbIme.setForeground(Color.RED);
		lbIme.setBounds(361, 86, 18, 14);
		getContentPane().add(lbIme);
		lbIme.setVisible(false);
		
		lbPrez = new JLabel("*");
		lbPrez.setForeground(Color.RED);
		lbPrez.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbPrez.setBounds(361, 139, 18, 14);
		getContentPane().add(lbPrez);
		lbPrez.setVisible(false);
		
		
		lbAdr = new JLabel("*");
		lbAdr.setForeground(Color.RED);
		lbAdr.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbAdr.setBounds(361, 191, 18, 14);
		getContentPane().add(lbAdr);
		lbAdr.setVisible(false);
		
		lbBr = new JLabel("*");
		lbBr.setForeground(Color.RED);
		lbBr.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbBr.setBounds(361, 245, 18, 14);
		getContentPane().add(lbBr);
		lbBr.setVisible(false);
		
		lbUser = new JLabel("*");
		lbUser.setForeground(Color.RED);
		lbUser.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbUser.setBounds(361, 298, 18, 14);
		getContentPane().add(lbUser);
		lbUser.setVisible(false);
		
		lbPass = new JLabel("*");
		lbPass.setForeground(Color.RED);
		lbPass.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbPass.setBounds(361, 351, 18, 14);
		getContentPane().add(lbPass);
		lbPass.setVisible(false);
		
		lbJmbg = new JLabel("*");
		lbJmbg.setForeground(Color.RED);
		lbJmbg.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbJmbg.setBounds(361, 404, 18, 14);
		getContentPane().add(lbJmbg);
		lbJmbg.setVisible(false);
		
		lbPla = new JLabel("*");
		lbPla.setForeground(Color.RED);
		lbPla.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbPla.setBounds(361, 515, 18, 14);
		getContentPane().add(lbPla);
		lbPla.setVisible(false);
	
	
	
		
		
	}
	public boolean validacija() {
		boolean provera = true;	
		String poruka = "";
		while(true) {
		
		if(txtIme.getText().isEmpty()) {
				lbIme.setVisible(true);
				provera = false;
				}
		 if(txtPrez.getText().isEmpty()) {
				lbPrez.setVisible(true);
				provera = false;
			}
		 if(txtBr.getText().isEmpty()) {
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
