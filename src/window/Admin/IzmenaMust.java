package window.Admin;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import model.Automobil;
import model.Musterija;
import model.Automobil.MarkaVozila;
import model.Automobil.ModeliAuto;
import model.Automobil.VrstaGoriva;
import servFunkc.ServisaAuto;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IzmenaMust extends JDialog {
	private JTextField txtID;
	private JTextField txtIme;
	private JTextField txtPrezime;
	private JTextField txtAdresa;
	private JTextField txtBroj;
	private JTextField txtUser;
	private JTextField txtPass;
	private JTextField txtJmbg;
	private JLabel lbIme;
	private JLabel lbPrez;
	private JLabel lbAdr;
	private JLabel lbBr;
	private JLabel lbJmbg;
	private JLabel lbUser;
	private JLabel lbPass;
	ArrayList<Musterija> musterije = new ArrayList<Musterija>();
	
	
	
	private int izabrid = 0;
	private JTextField txtBodovi;
	private JTextField txtNagr;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IzmenaMust dialog = new IzmenaMust();
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
	
	public IzmenaMust(int id) {
		
		this();
		Musterija mu = ServisaAuto.servis12.nadjiMusteriju(id);
		txtID.setText(mu.getId()+"");
		txtIme.setText(mu.getIme());
		txtPrezime.setText(mu.getPrezime());
		txtAdresa.setText(mu.getAdresa());
		txtBroj.setText(mu.getBrTelefona());
		txtUser.setText(mu.getUsername());
		txtPass.setText(mu.getPassword());
		txtNagr.setText(mu.getNagrBodovi()+"");
		txtJmbg.setText(mu.getJmbg()+"");
	}
	
	
	
	
	
	public IzmenaMust() {
		izabrid = ListaMust.selektovanid;
		
		if (ServisaAuto.servis12.getMusterija().size()==0)
			ServisaAuto.servis12.ucitajMusteriju();
			musterije = ServisaAuto.servis12.getMusterija();
		
		setTitle("Izmena podataka musterije");
		setBounds(100, 100, 450, 620);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("ID");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(69, 11, 271, 21);
		getContentPane().add(label);
		
		txtID = new JTextField();
		txtID.setHorizontalAlignment(SwingConstants.CENTER);
		txtID.setEnabled(false);
		txtID.setColumns(10);
		txtID.setBounds(69, 27, 271, 26);
		getContentPane().add(txtID);
		txtID.setText(String.valueOf(izabrid));
		
		
		JLabel label_1 = new JLabel("Ime");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(69, 64, 271, 21);
		getContentPane().add(label_1);
		
		txtIme = new JTextField();
		txtIme.setColumns(10);
		txtIme.setBounds(69, 80, 271, 26);
		getContentPane().add(txtIme);
		
		JLabel label_2 = new JLabel("Prezime");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(69, 117, 271, 21);
		getContentPane().add(label_2);
		
		txtPrezime = new JTextField();
		txtPrezime.setColumns(10);
		txtPrezime.setBounds(69, 133, 271, 26);
		getContentPane().add(txtPrezime);
		
		JLabel label_3 = new JLabel("Adresa");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(69, 170, 271, 21);
		getContentPane().add(label_3);
		
		txtAdresa = new JTextField();
		txtAdresa.setColumns(10);
		txtAdresa.setBounds(69, 186, 271, 26);
		getContentPane().add(txtAdresa);
		
		JLabel label_4 = new JLabel("Broj telefona");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(69, 223, 271, 21);
		getContentPane().add(label_4);
		
		txtBroj = new JTextField();
		txtBroj.setColumns(10);
		txtBroj.setBounds(69, 239, 271, 26);
		getContentPane().add(txtBroj);
		
		JLabel label_5 = new JLabel("Username");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(69, 276, 271, 21);
		getContentPane().add(label_5);
		
		txtUser = new JTextField();
		txtUser.setColumns(10);
		txtUser.setBounds(69, 292, 271, 26);
		getContentPane().add(txtUser);
		
		JLabel label_6 = new JLabel("Password");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(69, 329, 271, 21);
		getContentPane().add(label_6);
		
		txtPass = new JTextField();
		txtPass.setColumns(10);
		txtPass.setBounds(69, 345, 271, 26);
		getContentPane().add(txtPass);
		
		JLabel label_7 = new JLabel("JMBG");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setBounds(69, 382, 271, 21);
		getContentPane().add(label_7);
		
		txtJmbg = new JTextField();
		txtJmbg.setColumns(10);
		txtJmbg.setBounds(69, 398, 271, 26);
		getContentPane().add(txtJmbg);
		
		txtNagr = new JTextField();
		txtNagr.setColumns(10);
		txtNagr.setBounds(69, 493, 271, 26);
		getContentPane().add(txtNagr);
		
		
		
		JRadioButton rdMuski = new JRadioButton("Muski");
		rdMuski.setSelected(true);
		rdMuski.setBounds(69, 447, 109, 23);
		getContentPane().add(rdMuski);
		
		JRadioButton rdZenski = new JRadioButton("Zenski");
		rdZenski.setBounds(231, 447, 109, 23);
		getContentPane().add(rdZenski);
		
		JLabel lblPol = new JLabel("Pol");
		lblPol.setHorizontalAlignment(SwingConstants.CENTER);
		lblPol.setBounds(69, 424, 271, 21);
		getContentPane().add(lblPol);
		
		ButtonGroup btg = new ButtonGroup();
		btg.add(rdZenski);
		btg.add(rdMuski);
		
		
		JLabel lblNagradniBodovi = new JLabel("Nagradni bodovi");
		lblNagradniBodovi.setHorizontalAlignment(SwingConstants.CENTER);
		lblNagradniBodovi.setBounds(69, 477, 271, 21);
		getContentPane().add(lblNagradniBodovi);
		
		
		JButton btnNewButton = new JButton("Izmena");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(validacija()) {
					
				int id = Integer.parseInt(txtID.getText().trim());
					String ime = txtIme.getText().trim();
					String prez = txtPrezime.getText().trim();
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
					short nagrbod = Short.parseShort(txtNagr.getText().trim());
					
				
					Musterija novi = new Musterija(id,false,ime,prez,jmbg,pol,adresa,brTel,user,pass,nagrbod);
						ServisaAuto.servis12.izmeniMusteriju(novi);
						ServisaAuto.servis12.sacuvajMusteriju();
					
					JOptionPane.showMessageDialog(getContentPane(), "Uspesno ste izmenili musteriju!");
					
					
				}
			}
		});
		btnNewButton.setBounds(69, 535, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Izlaz");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			dispose();
			}
		});
		btnNewButton_1.setBounds(248, 535, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		lbIme = new JLabel("*");
		lbIme.setForeground(Color.RED);
		lbIme.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbIme.setBounds(350, 86, 46, 14);
		getContentPane().add(lbIme);
		lbIme.setVisible(false);
		
		lbPrez = new JLabel("*");
		lbPrez.setForeground(Color.RED);
		lbPrez.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbPrez.setBounds(350, 139, 46, 14);
		getContentPane().add(lbPrez);
		lbPrez.setVisible(false);
		
		lbAdr = new JLabel("*");
		lbAdr.setForeground(Color.RED);
		lbAdr.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbAdr.setBounds(350, 192, 46, 14);
		getContentPane().add(lbAdr);
		lbAdr.setVisible(false);
		
		
		lbBr = new JLabel("*");
		lbBr.setForeground(Color.RED);
		lbBr.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbBr.setBounds(350, 245, 46, 14);
		getContentPane().add(lbBr);
		lbBr.setVisible(false);
		
		lbUser = new JLabel("*");
		lbUser.setForeground(Color.RED);
		lbUser.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbUser.setBounds(350, 298, 46, 14);
		getContentPane().add(lbUser);
		lbUser.setVisible(false);
		
		
		lbPass = new JLabel("*");
		lbPass.setForeground(Color.RED);
		lbPass.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbPass.setBounds(350, 351, 46, 14);
		getContentPane().add(lbPass);
		lbPass.setVisible(false);
		
		
		lbJmbg = new JLabel("*");
		lbJmbg.setForeground(Color.RED);
		lbJmbg.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbJmbg.setBounds(350, 404, 46, 14);
		getContentPane().add(lbJmbg);
		lbJmbg.setVisible(false);
		
		JLabel lblNagradniBodovi_1 = new JLabel("Nagradni bodovi");
		lblNagradniBodovi_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNagradniBodovi_1.setBounds(69, 477, 271, 21);
		getContentPane().add(lblNagradniBodovi_1);
		
		
	
		
		
		}
	public boolean validacija() {
		boolean provera = true;	
		String poruka = "";
		while(true) {
		
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
			 Short.parseShort(txtNagr.getText());
			}catch (NumberFormatException e) {
				poruka += "- Nagradni bodovi moraju biti broj!\n";
				provera = false;
			}
	
		 JOptionPane.showMessageDialog(null,poruka);
			return provera;
		 
		 }	
		}


}
