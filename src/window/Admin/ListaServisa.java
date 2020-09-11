package window.Admin;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import model.Administrator;
import model.Musterija;
import model.ServDeo;
import model.ServisAutomobila;
import model.Serviser;
import model.Automobil.MarkaVozila;
import model.Automobil.ModeliAuto;
import model.Automobil.VrstaGoriva;
import model.ServisAutomobila.Status;
import servFunkc.ServisaAuto;

import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ListaServisa extends JDialog {
	private JTable table;
	private int selektovanid;
	private ArrayList<ServisAutomobila> servisi = new ArrayList<ServisAutomobila>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaServisa dialog = new ListaServisa();
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
	public ListaServisa() {
		servisi = ServisaAuto.servis12.getServis();
		
		
		
		setTitle("Pregled svih servisa");
		setBounds(100, 100, 850, 610);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Dodaj novi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			DodajServis dso = new DodajServis();
			dso.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 38, 89, 23);
		getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 130, 814, 430);
		getContentPane().add(scrollPane);
		
		String kolone[] = {"ID", "Marka Vozila" , "Model" , "Serviser" , "Termin" , "Opis", "Korisceni delovi" , "Status"};

		DefaultTableModel tableModel = new DefaultTableModel(kolone, 0);
		
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		
		
		
		JButton btnIzmeni = new JButton("Izmena");
		btnIzmeni.setEnabled(false);
		btnIzmeni.setBounds(10, 83, 89, 23);
		getContentPane().add(btnIzmeni);
		
		JButton btnNewButton_2 = new JButton("Izadji");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			
			}
		});
		btnNewButton_2.setBounds(735, 38, 89, 23);
		getContentPane().add(btnNewButton_2);
		
		JButton btnObrisi = new JButton("Obrisi");
		btnObrisi.setEnabled(false);
		btnObrisi.setBounds(735, 83, 89, 23);
		getContentPane().add(btnObrisi);

	
		btnObrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 int a=JOptionPane.showConfirmDialog(null,"Da li ste sigurni da zelite da obrisete?");  
		            if(a==JOptionPane.YES_OPTION){  
		                ServisAutomobila servis = ServisaAuto.servis12.nadjiServis(selektovanid);
		                servis.setObrisan(true);
		                ServisaAuto.servis12.izmeniServis(servis);
		               
		            }  
	            
			}
		});
		
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	            
	            selektovanid=Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
	            btnIzmeni.setEnabled(true);
	            btnObrisi.setEnabled(true);
	        }
	    });
		
		if (ServisaAuto.servis12.getServis().size()==0)
			ServisaAuto.servis12.ucitajServis();
			servisi = ServisaAuto.servis12.getServis();
		
		ServisaAuto.servis12.ucitajAutomobile();
	//	ServisaAuto.servis12.ucitajDeo();
		ServisaAuto.servis12.ucitajServisera();
		
		for (int i = 0; i < servisi.size(); i++){
			if(servisi.get(i).isObrisan())continue;
			int id = servisi.get(i).getId();
			   
			   MarkaVozila marka = servisi.get(i).getMarka();
			   ModeliAuto model = servisi.get(i).getModel();
			   
			
			   Serviser serv = servisi.get(i).getServ();
			   LocalDateTime termin = servisi.get(i).getTermin();
			   String opis = servisi.get(i).getOpis();
			   ArrayList<ServDeo> delovi = servisi.get(i).getDelovi();
			   Status status = servisi.get(i).getStatus();
			   
			   
			   Object[] data = {id, marka, model, serv,termin,opis,delovi,status};
			                               
			                          

			   tableModel.addRow(data);

			}
	
	
	}
}
