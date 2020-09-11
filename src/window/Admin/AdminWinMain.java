package window.Admin;

import java.awt.Dialog;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import window.LoginWin;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminWinMain extends JDialog {
		/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminWinMain dialog = new AdminWinMain();
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
	public AdminWinMain() {
		setTitle("SERVIS AUTOMOBILA");
		setBounds(100, 100, 525, 380);
		getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("KORISNICI");
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_5 = new JMenu("Administratori");
		mnNewMenu.add(mnNewMenu_5);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Dodavanje novog administratora");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			DodajAdmin ddaj = new DodajAdmin();
			ddaj.setVisible(true);
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Pregled administratora");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ListaAdmin listaa = new ListaAdmin();
			listaa.setVisible(true);
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_6 = new JMenu("Serviseri");
		mnNewMenu.add(mnNewMenu_6);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Dodavanje servisera");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			DodajServiser dod = new DodajServiser();
			dod.setVisible(true);
			
			}
		});
		mnNewMenu_6.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Pregled servisera");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ServiserLista ser = new ServiserLista();
			ser.setVisible(true);
			}
		});
		mnNewMenu_6.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_7 = new JMenu("Musterije");
		mnNewMenu.add(mnNewMenu_7);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Dodavanje musterije");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			DodajMust must = new DodajMust();
			must.setVisible(true);
			
			}
		});
		mnNewMenu_7.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Pregled musterija");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ListaMust lm = new ListaMust();
			lm.setVisible(true);
			
			}
		});
		mnNewMenu_7.add(mntmNewMenuItem_8);
		
		JMenu mnNewMenu_1 = new JMenu("Automobili");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Dodavanje automobila");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			DodajAuto add = new DodajAuto();
			add.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_9);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Lista automobila");
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ListaAuto listaauto = new ListaAuto();
			listaauto.setVisible(true);
			
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_11);
		
		JMenu mnNewMenu_2 = new JMenu("Servis Automobila");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_12 = new JMenuItem("Zakazivanje novog servisa");
		mntmNewMenuItem_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			DodajServis ds = new DodajServis();
			ds.setVisible(true);
			
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_12);
		
		JMenuItem mntmNewMenuItem_14 = new JMenuItem("Pregled svih servisa");
		mntmNewMenuItem_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ListaServisa lsa = new ListaServisa();
			lsa.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_14);
		
		JMenu mnNewMenu_3 = new JMenu("Servisna Knjizica");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_15 = new JMenuItem("Dodavanje servisne knjizice");
		mntmNewMenuItem_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			DodajKnjizica dknj = new DodajKnjizica();
			dknj.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_15);
		
		JMenuItem mntmNewMenuItem_17 = new JMenuItem("Prikaz servisnih knjizica");
		mntmNewMenuItem_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ListaKnjizica lkn = new ListaKnjizica();
			lkn.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_17);
		
		JMenu mnNewMenu_4 = new JMenu("Delovi");
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_18 = new JMenuItem("Dodavanje novog dela");
		mntmNewMenuItem_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			DodajDeo ddo = new DodajDeo();
			ddo.setVisible(true);
			
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_18);
		
		JMenuItem mntmNewMenuItem_20 = new JMenuItem("Pregled svih delova");
		mntmNewMenuItem_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ListaDelova ldeo = new ListaDelova();
			ldeo.setVisible(true);
			
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_20);
		
		JMenu mnNewMenu_8 = new JMenu("KRAJ");
		mnNewMenu_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		menuBar.add(mnNewMenu_8);
		
		JMenuItem mntmNewMenuItem_21 = new JMenuItem("Izadji");
		mntmNewMenuItem_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(1);
			}
		});
		mnNewMenu_8.add(mntmNewMenuItem_21);

	}
}
