package window.Admin;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import model.Musterija;
import model.Serviser;
import model.Serviser.Specijalizacija;
import servFunkc.ServisaAuto;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class IzmenaServiser extends JDialog {
	private JTextField txtID;
	private JTextField txtIme;
	private JTextField txtPrez;
	private JTextField txtAdresa;
	private JTextField txtBroj;
	private JTextField txtUser;
	private JTextField txtPass;
	private JTextField txtJmbg;
	private JLabel lbIme;
	private JLabel lbPrez;
	private JLabel lbAdr;
	private JLabel lbBr;
	private JLabel lbUser;
	private JLabel lbPass;
	private JLabel lbJmbg;
	private int izabranid = 0;
	private JComboBox comboSpec;
	public ArrayList<Serviser> serviseri = new ArrayList<Serviser>();
	private JLabel lblPlata;
	private JTextField txtPlata;
	private JLabel lbPlata;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IzmenaServiser dialog = new IzmenaServiser();
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
	
	public IzmenaServiser(int id) {
		
		this();
		Serviser serv = ServisaAuto.servis12.nadjiServ(id);
		txtID.setText(serv.getId()+"");
		txtIme.setText(serv.getIme());
		txtPrez.setText(serv.getPrezime());
		txtAdresa.setText(serv.getAdresa());
		txtBroj.setText(serv.getBrTelefona());
		txtUser.setText(serv.getUsername());
		txtPass.setText(serv.getPassword());
		txtJmbg.setText(serv.getJmbg()+"");
		comboSpec.setSelectedItem(serv.getSpec());
		txtPlata.setText(serv.getPlata()+"");
		
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public IzmenaServiser() {
		if (ServisaAuto.servis12.getServ().size()==0)
			ServisaAuto.servis12.ucitajServisera();
			serviseri = ServisaAuto.servis12.getServ();
		
		setBounds(100, 100, 450, 750);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("ID");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(71, 11, 271, 21);
		getContentPane().add(label);
		
		txtID = new JTextField();
		txtID.setText("");
		txtID.setHorizontalAlignment(SwingConstants.CENTER);
		txtID.setEnabled(false);
		txtID.setColumns(10);
		txtID.setBounds(71, 27, 271, 26);
		getContentPane().add(txtID);
		
		JLabel label_1 = new JLabel("Ime");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(71, 64, 271, 21);
		getContentPane().add(label_1);
		
		txtIme = new JTextField();
		txtIme.setColumns(10);
		txtIme.setBounds(71, 80, 271, 26);
		getContentPane().add(txtIme);
		
		JLabel label_2 = new JLabel("Prezime");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(71, 117, 271, 21);
		getContentPane().add(label_2);
		
		txtPrez = new JTextField();
		txtPrez.setColumns(10);
		txtPrez.setBounds(71, 133, 271, 26);
		getContentPane().add(txtPrez);
		
		JLabel label_3 = new JLabel("Adresa");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(71, 170, 271, 21);
		getContentPane().add(label_3);
		
		txtAdresa = new JTextField();
		txtAdresa.setColumns(10);
		txtAdresa.setBounds(71, 186, 271, 26);
		getContentPane().add(txtAdresa);
		
		JLabel label_4 = new JLabel("Broj telefona");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(71, 223, 271, 21);
		getContentPane().add(label_4);
		
		txtBroj = new JTextField();
		txtBroj.setColumns(10);
		txtBroj.setBounds(71, 239, 271, 26);
		getContentPane().add(txtBroj);
		
		JLabel label_5 = new JLabel("Username");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(71, 272, 271, 21);
		getContentPane().add(label_5);
		
		txtUser = new JTextField();
		txtUser.setColumns(10);
		txtUser.setBounds(71, 288, 271, 26);
		getContentPane().add(txtUser);
		
		JLabel label_6 = new JLabel("Password");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(71, 325, 271, 21);
		getContentPane().add(label_6);
		
		txtPass = new JTextField();
		txtPass.setColumns(10);
		txtPass.setBounds(71, 341, 271, 26);
		getContentPane().add(txtPass);
		
		JLabel label11 = new JLabel("JMBG");
		label11.setHorizontalAlignment(SwingConstants.CENTER);
		label11.setBounds(71, 378, 271, 21);
		getContentPane().add(label11);
		
		txtJmbg = new JTextField();
		txtJmbg.setColumns(10);
		txtJmbg.setBounds(71, 394, 271, 26);
		getContentPane().add(txtJmbg);
		
		JRadioButton rdMuski = new JRadioButton("Muski");
		rdMuski.setSelected(true);
		rdMuski.setBounds(71, 443, 109, 23);
		getContentPane().add(rdMuski);
		
		JRadioButton rdZenski = new JRadioButton("Zenski");
		rdZenski.setBounds(284, 443, 55, 23);
		getContentPane().add(rdZenski);
		
		JLabel label_8 = new JLabel("Pol");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setBounds(71, 420, 271, 21);
		getContentPane().add(label_8);
		
		JLabel lblSpecijalizacija = new JLabel("Specijalizacija");
		lblSpecijalizacija.setHorizontalAlignment(SwingConstants.CENTER);
		lblSpecijalizacija.setBounds(71, 473, 271, 21);
		getContentPane().add(lblSpecijalizacija);
		
		comboSpec = new JComboBox(Serviser.Specijalizacija.values());
		comboSpec.setBounds(71, 494, 271, 21);
		getContentPane().add(comboSpec);
		ButtonGroup btg = new ButtonGroup();
		btg.add(rdZenski);
		btg.add(rdMuski);
		
		lbIme = new JLabel("*");
		lbIme.setForeground(Color.RED);
		lbIme.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbIme.setBounds(352, 86, 17, 14);
		getContentPane().add(lbIme);
		lbIme.setVisible(false);
		
		lbPrez = new JLabel("*");
		lbPrez.setForeground(Color.RED);
		lbPrez.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbPrez.setBounds(352, 139, 17, 14);
		getContentPane().add(lbPrez);
		lbPrez.setVisible(false);
		
		lbAdr = new JLabel("*");
		lbAdr.setForeground(Color.RED);
		lbAdr.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbAdr.setBounds(352, 192, 17, 14);
		getContentPane().add(lbAdr);
		lbAdr.setVisible(false);
		
		lbBr = new JLabel("*");
		lbBr.setForeground(Color.RED);
		lbBr.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbBr.setBounds(352, 245, 17, 14);
		getContentPane().add(lbBr);
		lbBr.setVisible(false);
		
		lbUser = new JLabel("*");
		lbUser.setForeground(Color.RED);
		lbUser.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbUser.setBounds(352, 294, 17, 14);
		getContentPane().add(lbUser);
		lbUser.setVisible(false);
		
		
		lbPass = new JLabel("*");
		lbPass.setForeground(Color.RED);
		lbPass.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbPass.setBounds(352, 347, 17, 14);
		getContentPane().add(lbPass);
		lbPass.setVisible(false);
		
		
		lbJmbg = new JLabel("*");
		lbJmbg.setForeground(Color.RED);
		lbJmbg.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbJmbg.setBounds(352, 400, 17, 14);
		getContentPane().add(lbJmbg);
		lbJmbg.setVisible(false);
		
		
		JButton btnNewButton = new JButton("Izmena");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
						String brTel = txtBroj.getText().trim();
						String user = txtUser.getText().trim();
						String pass = txtPass.getText().trim();
						Specijalizacija spec = (Specijalizacija) comboSpec.getSelectedItem();
						int plata = Integer.parseInt(txtPlata.getText().trim());
					
						Serviser novi = new Serviser(id,false,ime,prez,jmbg,pol,adresa,brTel,user,pass,plata,spec);
							ServisaAuto.servis12.izmeniServisera(novi);
							ServisaAuto.servis12.sacuvajServisera();
						
						JOptionPane.showMessageDialog(getContentPane(), "Uspesno ste izmenili musteriju!");
						
				
					
				}
			
			
			}
		});
		btnNewButton.setBounds(71, 632, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Izadji");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			dispose();
			}
		});
		btnNewButton_1.setBounds(248, 632, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		lblPlata = new JLabel("Plata");
		lblPlata.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlata.setBounds(71, 538, 271, 21);
		getContentPane().add(lblPlata);
		
		txtPlata = new JTextField();
		txtPlata.setColumns(10);
		txtPlata.setBounds(71, 554, 271, 26);
		getContentPane().add(txtPlata);
		
		lbPlata = new JLabel("*");
		lbPlata.setForeground(Color.RED);
		lbPlata.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbPlata.setBounds(352, 560, 17, 14);
		getContentPane().add(lbPlata);
		lbPlata.setVisible(false);
		
		
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
			 lbPlata.setVisible(true);
			 provera = false;
			 
		 }
		 if(provera == false)JOptionPane.showMessageDialog(null,"POLJA OZNACENA ZVEZDICOM NE SMEJU BITI PRAZNA!");
		 
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
		 try {
			 Integer.parseInt(txtPlata.getText().trim());
			}catch (NumberFormatException e) {
				poruka += "- Plata mora biti broj!\n";
				provera = false;
			}
	
		 JOptionPane.showMessageDialog(null,poruka);
			return provera;
		 
		 }	
		}


}
