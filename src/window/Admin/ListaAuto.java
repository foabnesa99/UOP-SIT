package window.Admin;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import model.Musterija;
import model.Automobil.MarkaVozila;
import model.Automobil.ModeliAuto;
import model.Automobil.VrstaGoriva;
import javax.swing.JButton;

import model.Administrator;
import model.Automobil;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import servFunkc.ServisaAuto;
import model.Automobil;
public class ListaAuto extends JDialog {
	private JTable table;
	private ArrayList<Automobil> auti;
	public static int selektovanid = 0;
	public JButton btnNewButton ;
	public	JButton btnIzmeni;
	public JButton btnObrisi; 
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaAuto dialog = new ListaAuto();
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

	

	
	public ListaAuto() {
		setTitle("LISTA SVIH AUTOMOBILA");
		
		
		
		auti = ServisaAuto.servis12.getAuti();
		setResizable(false);
		setBounds(100, 100, 640, 610);
		
		
		String kolone[] = {"ID", "Vlasnik" , "Marka Vozila" , "Model" , "Godina proizvodnje" , "Zapremina motora" , "Snaga Motora", "Vrsta goriva"};

		DefaultTableModel tableModel = new DefaultTableModel(kolone, 0);
		
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 111, 555, 328);
		getContentPane().add(scrollPane);
		
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		
		btnNewButton = new JButton("Dodaj novi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			DodajAuto auto = new DodajAuto();
			auto.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 34, 89, 23);
		getContentPane().add(btnNewButton);
		
		btnIzmeni = new JButton("Izmeni");
		btnIzmeni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			IzmenaAuto izmena = new IzmenaAuto(selektovanid);
			izmena.setVisible(true);
			
			
			}
		});
		btnIzmeni.setEnabled(false);
		btnIzmeni.setBounds(10, 68, 89, 23);
		getContentPane().add(btnIzmeni);
		
		JButton btnNewButton_2 = new JButton("Izadji");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			dispose();
			}
		});
		btnNewButton_2.setBounds(525, 34, 89, 23);
		getContentPane().add(btnNewButton_2);
		
		btnObrisi = new JButton("Obrisi");
		btnObrisi.setEnabled(false);
		btnObrisi.setBounds(525, 68, 89, 23);
		getContentPane().add(btnObrisi);
		
		
		btnObrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 int a=JOptionPane.showConfirmDialog(null,"Da li ste sigurni da zelite da obrisete?");  
		            if(a==JOptionPane.YES_OPTION){  
		                Automobil auto= ServisaAuto.servis12.nadjiAuto(selektovanid);
		                auto.setObrisan(true);
		                ServisaAuto.servis12.izmeniAuto(auto);
		               
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
		
	//	ServisaAuto.servis12.ucitajMusteriju();
		if (ServisaAuto.servis12.getAuti().size()==0)
			ServisaAuto.servis12.ucitajAutomobile();
			auti = ServisaAuto.servis12.getAuti();
		
		
		
		for (int i = 0; i < auti.size(); i++){
			if(auti.get(i).isObrisan())continue;   
			int id = auti.get(i).getId();
			   
			   
			   Musterija vlasnik = auti.get(i).getVlasnik();
			   MarkaVozila marka = auti.get(i).getMarka();
			   ModeliAuto model = auti.get(i).getModel();
			   int godproiz = auti.get(i).getGodProiz();
			   int zapremina = auti.get(i).getZaprMotora();
			   int snaga = auti.get(i).getSnagaMotora();
			   VrstaGoriva vrstagor = auti.get(i).getVrstaGoriva();
			   

			   Object[] data = {id, vlasnik, marka, model, godproiz, zapremina,snaga,vrstagor};
			                               
			                          

			   tableModel.addRow(data);

			}
		
		
	}
}

	
