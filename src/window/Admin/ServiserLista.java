package window.Admin;

import java.awt.EventQueue;

import model.Administrator;
import model.Musterija;
import model.Serviser;
import model.Serviser.Specijalizacija;
import model.Automobil.MarkaVozila;
import model.Automobil.ModeliAuto;
import model.Automobil.VrstaGoriva;
import servFunkc.ServisaAuto;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ServiserLista extends JDialog {
	private JTable tabela;
	private ArrayList<Serviser> serv;
	public static int selektovanid=0;
	public JButton btnNewButton;
	public JButton btnIzmeni;
	public JButton btnObrisi;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServiserLista dialog = new ServiserLista();
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
	public ServiserLista() {
		setBounds(100, 100, 750, 610);
		getContentPane().setLayout(null);
		serv = ServisaAuto.servis12.getServ();
		String kolone[] = {"ID", "Ime", "Prezime", "JMBG", "Pol", "Adresa", "Broj Telefona", "Username", "Password","Plata","Specijalizacija"};

		DefaultTableModel tableModel = new DefaultTableModel(kolone, 0);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 168, 714, 392);
		getContentPane().add(scrollPane);
		
		tabela = new JTable(tableModel);
		scrollPane.setViewportView(tabela);
		
		btnNewButton = new JButton("Dodaj novi");
		btnNewButton.setBounds(10, 38, 89, 23);
		getContentPane().add(btnNewButton);
		
		btnIzmeni = new JButton("Izmena");
		btnIzmeni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IzmenaServiser izm = new IzmenaServiser(selektovanid);
				izm.setVisible(true);
			}
		});
		btnIzmeni.setEnabled(false);
		btnIzmeni.setBounds(10, 100, 89, 23);
		getContentPane().add(btnIzmeni);
		
		JButton btnNewButton_2 = new JButton("Izadji");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			dispose();
			}
		});
		btnNewButton_2.setBounds(635, 38, 89, 23);
		getContentPane().add(btnNewButton_2);
		
		btnObrisi = new JButton("Obrisi");
		btnObrisi.setEnabled(false);
		btnObrisi.setBounds(635, 100, 89, 23);
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
	            btnIzmeni.setEnabled(true);
	            btnObrisi.setEnabled(true);
	        }
	    });
		
		//if (ServisaAuto.servis12.getServ().size()==0)
			//ServisaAuto.servis12.ucitajServisera();
		//	serv = ServisaAuto.servis12.getServ();
		
		
		
		for (int i = 0; i < serv.size(); i++){
			if(serv.get(i).isObrisan())continue;
			int id = serv.get(i).getId();
			   String ime = serv.get(i).getIme();
			   String prezime = serv.get(i).getPrezime();
			   long jmbg = serv.get(i).getJmbg();
			   String pol = serv.get(i).getPol();
			   String adresa = serv.get(i).getAdresa();
			   String brtel = serv.get(i).getBrTelefona();
			   String user = serv.get(i).getUsername();
			   String pass = serv.get(i).getPassword();
			   int plata = serv.get(i).getPlata();
			   Specijalizacija spec = serv.get(i).getSpec();

			   Object[] data = {id,ime,prezime,jmbg,pol,adresa,brtel,user,pass,plata,spec};
			                               
			                          

			   tableModel.addRow(data);

			}
	
	
	
	
	
	
	
	}
}
