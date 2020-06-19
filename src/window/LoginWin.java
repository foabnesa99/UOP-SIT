package window;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import servFunkc.ServisaAuto;
import window.Admin.AdminWinMain;
import window.Musterija.MainMusterija;
import window.Serviser.ServiserWinMain;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;
import model.Musterija;
import model.Administrator;
import model.Serviser;



public class LoginWin extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField korisnickoTxt;
	
	private JPasswordField passwordTxt;
	

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LoginWin dialog = new LoginWin();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public LoginWin() {
		ServisaAuto.servis12.ucitajAdmin();
		ServisaAuto.servis12.ucitajAutomobile();
		ServisaAuto.servis12.ucitajDeo();
		ServisaAuto.servis12.ucitajMusteriju();
		ServisaAuto.servis12.ucitajServis();
		ServisaAuto.servis12.ucitajServisera();
		
		
		setBounds(100, 100, 450, 391);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		korisnickoTxt = new JTextField();
		korisnickoTxt.setBounds(93, 152, 234, 31);
		contentPanel.add(korisnickoTxt);
		korisnickoTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = korisnickoTxt.getText().trim();
				String pass = new String(passwordTxt.getPassword()).trim();
					if(ServisaAuto.servis12.LoginMusterija(username, pass)) {
						MainMusterija mst = new MainMusterija();
						mst.setVisible(true);
					}
					else if(ServisaAuto.servis12.LoginServiser(username, pass)) {
						ServiserWinMain ser = new ServiserWinMain();
						ser.setVisible(true);
						
					}
					else if(ServisaAuto.servis12.LoginAdmin(username, pass)) {
						AdminWinMain adm = new AdminWinMain();
						adm.setVisible(true);
						
					}
					else
						JOptionPane.showMessageDialog(getContentPane(), "Korisnicki podaci nisu ispravni!");
						
			
			dispose();
			
			}
		});
		btnNewButton.setBounds(93, 310, 234, 31);
		contentPanel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Dobro do\u0161li u sistem auto-servisa");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(93, 11, 215, 23);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Molimo,unesite va\u0161e podatke:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(112, 45, 215, 23);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Korisni\u010Dko ime:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(93, 118, 108, 23);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblLozinka = new JLabel("Lozinka:");
		lblLozinka.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLozinka.setBounds(93, 194, 108, 23);
		contentPanel.add(lblLozinka);
		
		passwordTxt = new JPasswordField();
		passwordTxt.setBounds(93, 228, 234, 31);
		contentPanel.add(passwordTxt);
	}
}
