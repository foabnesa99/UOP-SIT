package window.Serviser;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import window.LoginWin;
import window.Admin.DodajDeo;
import window.Admin.DodajKnjizica;
import window.Admin.DodajServis;
import window.Admin.ListaAuto;
import window.Admin.ListaDelova;
import window.Admin.ListaKnjizica;
import window.Admin.ListaMust;
import window.Admin.ListaServisa;
import window.Admin.ServiserLista;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ServiserWinMain extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServiserWinMain dialog = new ServiserWinMain();
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
	public ServiserWinMain() {
		setTitle("SERVIS AUTOMOBILA");
		setBounds(100, 100, 525, 380);
		getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("KORISNICI");
		menuBar.add(menu);
		
		JMenu menu_2 = new JMenu("Serviseri");
		menu.add(menu_2);
		
		JMenuItem menuItem_5 = new JMenuItem("Pregled servisera");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ServiserLista ser = new ServiserLista();
			ser.setVisible(true);
			ser.btnIzmeni.setEnabled(false);
			ser.btnNewButton.setEnabled(false);
			
			}
		});
		menu_2.add(menuItem_5);
		
		JMenu menu_3 = new JMenu("Musterije");
		menu.add(menu_3);
		
		JMenuItem menuItem_8 = new JMenuItem("Pregled musterija");
		menuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ListaMust lm = new ListaMust();
			lm.setVisible(true);
			lm.btnDodaj.setEnabled(false);
			lm.btnIzmeni.setEnabled(false);
			lm.btnObrisi.setEnabled(false);
			
			}
		});
		menu_3.add(menuItem_8);
		
		JMenu menu_4 = new JMenu("Automobili");
		
		menuBar.add(menu_4);
		
		JMenuItem menuItem_11 = new JMenuItem("Lista automobila");
		menuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ListaAuto la = new ListaAuto();
			la.setVisible(true);
			la.btnIzmeni.setEnabled(false);
			la.btnNewButton.setEnabled(false);
			la.btnObrisi.setEnabled(false);
			
			}
		});
		menu_4.add(menuItem_11);
		
		JMenu menu_5 = new JMenu("Servis Automobila");
		menuBar.add(menu_5);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Dodavanje servisa");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			DodajServis serv = new DodajServis();
			serv.setVisible(true);
			}
		});
		menu_5.add(mntmNewMenuItem);
		
		JMenuItem mntmPregledSvihZakazanih = new JMenuItem("Pregled svih zakazanih servisa");
		mntmPregledSvihZakazanih.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ListaServisa lsa = new ListaServisa();
			lsa.setVisible(true);
			}
		});
		menu_5.add(mntmPregledSvihZakazanih);
		
		JMenu menu_6 = new JMenu("Servisna Knjizica");
		menuBar.add(menu_6);
		
		JMenuItem mntmDodavanjeServisneKnjizice = new JMenuItem("Dodavanje servisne knjizice");
		mntmDodavanjeServisneKnjizice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			DodajKnjizica dkn = new DodajKnjizica();
			dkn.setVisible(true);
			}
		});
		menu_6.add(mntmDodavanjeServisneKnjizice);
		
		JMenuItem menuItem_17 = new JMenuItem("Prikaz servisnih knjizica");
		menuItem_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ListaKnjizica lkn = new ListaKnjizica();
			lkn.setVisible(true);	
			}
		});
		menu_6.add(menuItem_17);
		
		JMenu menu_7 = new JMenu("Delovi");
		menuBar.add(menu_7);
		
		JMenuItem menuItem_18 = new JMenuItem("Dodavanje novog dela");
		menuItem_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			DodajDeo ddo = new DodajDeo();
			ddo.setVisible(true);
			
			}
		});
		menu_7.add(menuItem_18);
		
		JMenuItem menuItem_20 = new JMenuItem("Pregled svih delova");
		menuItem_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ListaDelova ldo = new ListaDelova();
			ldo.setVisible(true);
			
			}
		});
		menu_7.add(menuItem_20);
		
		JMenu menu_8 = new JMenu("KRAJ");
		menuBar.add(menu_8);
		
		JMenuItem menuItem_21 = new JMenuItem("Izadji");
		menuItem_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		menu_8.add(menuItem_21);

	}

}
