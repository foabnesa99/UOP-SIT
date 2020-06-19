package window.Admin;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import model.Administrator;
import model.Automobil;
import model.Musterija;
import model.Automobil.MarkaVozila;
import model.Automobil.ModeliAuto;
import model.Automobil.VrstaGoriva;
import servFunkc.ServisaAuto;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ListaMust extends JDialog {
	private JTable tabela;
	
	private ArrayList<Musterija> must;
	public static int selektovanid = 0;
	public JButton btnDodaj;
	public JButton btnIzmeni;
	public JButton btnObrisi;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaMust dialog = new ListaMust();
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
	public ListaMust() {
		setTitle("Lista musterija");
		setBounds(100, 100, 700, 500);
		getContentPane().setLayout(null);
		
		must = ServisaAuto.servis12.getMusterija();
		
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 126, 664, 324);
		getContentPane().add(scrollPane);
		
		String kolone[] = {"ID", "Ime", "Prezime", "JMBG", "Pol", "Adresa", "Broj Telefona", "Username", "Password", "Nag. bodovi"};

		DefaultTableModel tableModel = new DefaultTableModel(kolone, 0);
		
		tabela = new JTable(tableModel);
		scrollPane.setViewportView(tabela);
		
		 btnDodaj = new JButton("Dodaj novi");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			DodajMust dod = new DodajMust();
			dod.setVisible(true);
				
			}
		});
		btnDodaj.setBounds(10, 22, 89, 23);
		getContentPane().add(btnDodaj);
		
		btnIzmeni = new JButton("Izmena");
		btnIzmeni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			IzmenaMust izm = new IzmenaMust(selektovanid);
			izm.setVisible(true);
			
			}
		});
		btnIzmeni.setEnabled(false);
		btnIzmeni.setBounds(10, 63, 89, 23);
		getContentPane().add(btnIzmeni);
		
		JButton btnIzlaz = new JButton("Izadji");
		btnIzlaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			dispose();
			}
		});
		btnIzlaz.setBounds(585, 22, 89, 23);
		getContentPane().add(btnIzlaz);
		
		btnObrisi = new JButton("Obrisi");
		btnObrisi.setBounds(585, 63, 89, 23);
		getContentPane().add(btnObrisi);
		
		
		
	
		if (ServisaAuto.servis12.getMusterija().size()==0)
			ServisaAuto.servis12.ucitajMusteriju();
			must = ServisaAuto.servis12.getMusterija();
		
		btnObrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 int a=JOptionPane.showConfirmDialog(null,"Da li ste sigurni da zelite da obrisete?");  
		            if(a==JOptionPane.YES_OPTION){  
		                Musterija musterija = ServisaAuto.servis12.nadjiMusteriju(selektovanid);
		                musterija.setObrisan(true);
		                ServisaAuto.servis12.izmeniMusteriju(musterija);
		               
		            }  
	            
			}
		});
		
		tabela.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	            
	            selektovanid=Integer.parseInt(tabela.getValueAt(tabela.getSelectedRow(), 0).toString());
	            btnIzmeni.setEnabled(true);
	            btnObrisi.setEnabled(true);
	        }
	    });
		
		
		for (int i = 0; i < must.size(); i++){
			   
			if(must.get(i).isObrisan())continue;	
			int id = must.get(i).getId();
			   String ime = must.get(i).getIme();
			   String prezime = must.get(i).getPrezime();
			   long jmbg = must.get(i).getJmbg();
			   String pol = must.get(i).getPol();
			   String adresa = must.get(i).getAdresa();
			   String brtel = must.get(i).getBrTelefona();
			   String user = must.get(i).getUsername();
			   String pass = must.get(i).getPassword();
			   short nagr = must.get(i).getNagrBodovi();

			   Object[] data = {id,ime,prezime,jmbg,pol,adresa,brtel,user,pass,nagr};
			                               
			                          

			   tableModel.addRow(data);

			}
		
	
	
	
	}





}
