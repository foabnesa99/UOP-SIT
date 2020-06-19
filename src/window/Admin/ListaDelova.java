package window.Admin;

import java.awt.EventQueue;
import java.util.ArrayList;

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
import model.ServDeo;
import model.Automobil.MarkaVozila;
import model.Automobil.ModeliAuto;
import model.Automobil.VrstaGoriva;
import servFunkc.ServisaAuto;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListaDelova extends JDialog {
	private JTable tabela;
	private ArrayList<ServDeo> delovi = new ArrayList<ServDeo>();
	public static int selektovanid = 0;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaDelova dialog = new ListaDelova();
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
	public ListaDelova() {
		setTitle("Prikaz svih delova");
		setBounds(100, 100, 530, 500);
		getContentPane().setLayout(null);
		ServisaAuto.servis12.ucitajAutomobile();
		delovi = ServisaAuto.servis12.getDelovi();
		String kolone[] = {"ID", "Marka" , "Model" , "Naziv" ,"Cena"};

		DefaultTableModel tableModel = new DefaultTableModel(kolone, 0);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 135, 494, 315);
		getContentPane().add(scrollPane);
		
		tabela = new JTable(tableModel);
		scrollPane.setViewportView(tabela);
		
		JButton btnNewButton = new JButton("Dodaj novi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			DodajDeo dd = new DodajDeo();
			dd.setVisible(true);
			
			}
		});
		btnNewButton.setBounds(10, 21, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnIzmeni = new JButton("Izmena");
		btnIzmeni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			IzmenaDeo izm = new IzmenaDeo(selektovanid);
			izm.setVisible(true);
			
			}
		});
		btnIzmeni.setEnabled(false);
		btnIzmeni.setBounds(10, 80, 89, 23);
		getContentPane().add(btnIzmeni);
		
		JButton btnNewButton_2 = new JButton("Izadji");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		btnNewButton_2.setBounds(415, 21, 89, 23);
		getContentPane().add(btnNewButton_2);
		
		JButton btnObrisi = new JButton("Obrisi");
		btnObrisi.setEnabled(false);
		btnObrisi.setBounds(415, 80, 89, 23);
		getContentPane().add(btnObrisi);

		btnObrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 int a=JOptionPane.showConfirmDialog(null,"Da li ste sigurni da zelite da obrisete?");  
		            if(a==JOptionPane.YES_OPTION){  
		                ServDeo deo = ServisaAuto.servis12.nadjiDeo(selektovanid);
		                deo.setObrisan(true);
		                ServisaAuto.servis12.izmeniDeo(deo);
		               
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
		
		
		
		if (ServisaAuto.servis12.getDelovi().size()==0)
			ServisaAuto.servis12.ucitajDeo();
			delovi = ServisaAuto.servis12.getDelovi();
		
		
		for (int i = 0; i < delovi.size(); i++){
			if(delovi.get(i).isObrisan())continue;
				int id = delovi.get(i).getId();
			  
			   MarkaVozila marka = delovi.get(i).getMarkaVoz();
			   ModeliAuto model = delovi.get(i).getModelVoz();
			  String naziv = delovi.get(i).getNazivDela();
			  int cena = delovi.get(i).getCena();
			   

			   Object[] data = {id, marka,model,naziv,cena};
			                               
			                          

			   tableModel.addRow(data);

			}
		
	
	
	}

}
