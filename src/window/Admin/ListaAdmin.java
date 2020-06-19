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
import model.Serviser;
import model.Serviser.Specijalizacija;
import servFunkc.ServisaAuto;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ListaAdmin extends JDialog {
	private JTable tabela;
	private ArrayList<Administrator> admin;
	public static int selektovanid=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaAdmin dialog = new ListaAdmin();
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
	public ListaAdmin() {
		setTitle("Lista administratora");
		setBounds(100, 100, 750, 610);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 151, 714, 409);
		getContentPane().add(scrollPane);
		
		admin = ServisaAuto.servis12.getAdmin();
		String kolone[] = {"ID", "Ime", "Prezime", "JMBG", "Pol", "Adresa", "Broj Telefona", "Username", "Password","Plata"};

		DefaultTableModel tableModel = new DefaultTableModel(kolone, 0);
		
		
		tabela = new JTable(tableModel);
		scrollPane.setViewportView(tabela);
		
		JButton btnDodaj = new JButton("Dodaj novi");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			DodajAdmin dd = new DodajAdmin();
			dd.setVisible(true);
			}
		});
		btnDodaj.setBounds(10, 30, 89, 23);
		getContentPane().add(btnDodaj);
		
		JButton btnIzmeni = new JButton("Izmena");
		btnIzmeni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			IzmenaAdmin izm = new IzmenaAdmin(selektovanid);
			izm.setVisible(true);
			}
		});
		btnIzmeni.setEnabled(false);
		btnIzmeni.setBounds(10, 92, 89, 23);
		getContentPane().add(btnIzmeni);
		
		JButton btnNewButton_2 = new JButton("Izadji");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		btnNewButton_2.setBounds(635, 30, 89, 23);
		getContentPane().add(btnNewButton_2);
		
		JButton btnObrisi = new JButton("Obrisi");
		
		btnObrisi.setEnabled(false);
		btnObrisi.setBounds(635, 92, 89, 23);
		getContentPane().add(btnObrisi);
		btnObrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 int a=JOptionPane.showConfirmDialog(null,"Da li ste sigurni da zelite da obrisete?");  
		            if(a==JOptionPane.YES_OPTION){  
		                Administrator admin = ServisaAuto.servis12.nadjiAdmin(selektovanid);
		                admin.setObrisan(true);
		                ServisaAuto.servis12.izmeniAdmin(admin);
		               
		            }  
	            
			}
		});
		tabela.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	            
	            selektovanid=Integer.parseInt(tabela.getValueAt(tabela.getSelectedRow(), 0).toString());
	            btnObrisi.setEnabled(true);
	            btnIzmeni.setEnabled(true);
	            
	            
	            
	           
	            
	        
	        }
	    });
		
		if (ServisaAuto.servis12.getAdmin().size()==0)
			ServisaAuto.servis12.ucitajAdmin();
			admin = ServisaAuto.servis12.getAdmin();
		
	
		
		for (int i = 0; i < admin.size(); i++){
			if(admin.get(i).isObrisan())continue;
			int id = admin.get(i).getId();
			   String ime = admin.get(i).getIme();
			   String prezime = admin.get(i).getPrezime();
			   long jmbg = admin.get(i).getJmbg();
			   String pol = admin.get(i).getPol();
			   String adresa = admin.get(i).getAdresa();
			   String brtel = admin.get(i).getBrTelefona();
			   String user = admin.get(i).getUsername();
			   String pass = admin.get(i).getPassword();
			   int plata = admin.get(i).getPlata();
			   

			   Object[] data = {id,ime,prezime,jmbg,pol,adresa,brtel,user,pass,plata};
			                               
			                          

			   tableModel.addRow(data);
			   
			}
	
	}
}
