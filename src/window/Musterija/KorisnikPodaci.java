package window.Musterija;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import window.LoginWin;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import model.Musterija;
public class KorisnikPodaci extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtIme;
	private JTextField txtPrez;
	private JTextField txtJmbg;
	private JTextField txtAdr;
	private JTextField txtUser;
	private JTextField txtTel;
	private JTextField txtNagr;
	private JPasswordField txtPass;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			KorisnikPodaci dialog = new KorisnikPodaci();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public KorisnikPodaci() {
		setBounds(100, 100, 640, 750);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ime :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(149, 59, 288, 17);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Podaci o korisniku:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(12, 13, 559, 33);
		contentPanel.add(lblNewLabel_1);
		
		txtIme = new JTextField();
		txtIme.setEditable(false);
		txtIme.setBounds(149, 92, 288, 22);
		contentPanel.add(txtIme);
		txtIme.setColumns(10);
		
		JLabel lblPrezime = new JLabel("Prezime");
		lblPrezime.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrezime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrezime.setBounds(149, 127, 288, 17);
		contentPanel.add(lblPrezime);
		
		txtPrez = new JTextField();
		txtPrez.setEditable(false);
		txtPrez.setColumns(10);
		txtPrez.setBounds(149, 160, 288, 22);
		contentPanel.add(txtPrez);
		
		JLabel lblJmbg = new JLabel("JMBG :");
		lblJmbg.setHorizontalAlignment(SwingConstants.CENTER);
		lblJmbg.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblJmbg.setBounds(149, 195, 288, 17);
		contentPanel.add(lblJmbg);
		
		txtJmbg = new JTextField();
		txtJmbg.setEditable(false);
		txtJmbg.setColumns(10);
		txtJmbg.setBounds(149, 228, 288, 22);
		contentPanel.add(txtJmbg);
		
		JLabel lblAdresa = new JLabel("Adresa :");
		lblAdresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdresa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAdresa.setBounds(149, 263, 288, 17);
		contentPanel.add(lblAdresa);
		
		txtAdr = new JTextField();
		txtAdr.setEditable(false);
		txtAdr.setColumns(10);
		txtAdr.setBounds(149, 296, 288, 22);
		contentPanel.add(txtAdr);
		
		JLabel lblKorisnickoIme = new JLabel("Korisnicko ime :");
		lblKorisnickoIme.setHorizontalAlignment(SwingConstants.CENTER);
		lblKorisnickoIme.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblKorisnickoIme.setBounds(149, 331, 288, 17);
		contentPanel.add(lblKorisnickoIme);
		
		txtUser = new JTextField();
		txtUser.setEditable(false);
		txtUser.setColumns(10);
		txtUser.setBounds(149, 364, 288, 22);
		contentPanel.add(txtUser);
		
		JLabel lblSifra = new JLabel("Sifra :");
		lblSifra.setHorizontalAlignment(SwingConstants.CENTER);
		lblSifra.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSifra.setBounds(149, 399, 288, 17);
		contentPanel.add(lblSifra);
		
		JLabel lblBrojTelefona = new JLabel("Broj telefona :");
		lblBrojTelefona.setHorizontalAlignment(SwingConstants.CENTER);
		lblBrojTelefona.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBrojTelefona.setBounds(149, 467, 288, 17);
		contentPanel.add(lblBrojTelefona);
		
		txtTel = new JTextField();
		txtTel.setEditable(false);
		txtTel.setColumns(10);
		txtTel.setBounds(149, 500, 288, 22);
		contentPanel.add(txtTel);
		
		JLabel lblNagradniBodovi = new JLabel("Nagradni bodovi :");
		lblNagradniBodovi.setHorizontalAlignment(SwingConstants.CENTER);
		lblNagradniBodovi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNagradniBodovi.setBounds(149, 535, 288, 17);
		contentPanel.add(lblNagradniBodovi);
		
		txtNagr = new JTextField();
		txtNagr.setEditable(false);
		txtNagr.setColumns(10);
		txtNagr.setBounds(149, 568, 288, 22);
		contentPanel.add(txtNagr);
		
		txtPass = new JPasswordField();
		txtPass.setEditable(false);
		txtPass.setBounds(149, 432, 288, 22);
		contentPanel.add(txtPass);
		
		JCheckBox sifraBtn = new JCheckBox("Prikazi karaktere");
		sifraBtn.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					txtPass.setEchoChar((char)0);
		        } else {txtPass.setEchoChar('*');
		        };
			
			}
		});
		sifraBtn.setBounds(458, 431, 135, 25);
		contentPanel.add(sifraBtn);
		txtIme.setText(LoginWin.currentUser.getIme());
		txtPrez.setText(LoginWin.currentUser.getPrezime());
		txtJmbg.setText(LoginWin.currentUser.getJmbg()+"");
		txtAdr.setText(LoginWin.currentUser.getAdresa());
		txtUser.setText(LoginWin.currentUser.getUsername());
		txtPass.setText(LoginWin.currentUser.getPassword());
		txtTel.setText(LoginWin.currentUser.getBrTelefona());
		txtNagr.setText(((Musterija)LoginWin.currentUser).getNagrBodovi()+"");
		
		
		
		JButton btnNewButton = new JButton("IZLAZ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		btnNewButton.setBounds(149, 616, 288, 62);
		contentPanel.add(btnNewButton);
	
	
	}
}
