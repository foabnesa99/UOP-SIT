package window.Musterija;

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
import java.util.List;
import java.util.stream.Collectors;
import java.awt.event.ActionEvent;
import servFunkc.ServisaAuto;
import window.LoginWin;
import model.Automobil;
public class ListaAutoMust extends JDialog {
	private JTable table;
	private List<Automobil> auti;
	public static int selektovanid = 0;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaAutoMust dialog = new ListaAutoMust();
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

	

	
	public ListaAutoMust() {
		setTitle("LISTA SVIH AUTOMOBILA");
		
		
		
		auti = ServisaAuto.servis12.getAuti();
		setResizable(false);
		setBounds(100, 100, 640, 610);
		
		
		String kolone[] = {"ID" , "Marka Vozila" , "Model" , "Godina proizvodnje" , "Zapremina motora" , "Snaga Motora", "Vrsta goriva"};

		DefaultTableModel tableModel = new DefaultTableModel(kolone, 0);
		
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 111, 555, 328);
		getContentPane().add(scrollPane);
		
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_2 = new JButton("Izadji");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			dispose();
			}
		});
		btnNewButton_2.setBounds(12, 47, 89, 23);
		getContentPane().add(btnNewButton_2);
		
		
		
		ServisaAuto.servis12.ucitajMusteriju();
		if (ServisaAuto.servis12.getAuti().size()==0)
			ServisaAuto.servis12.ucitajAutomobile();
			auti =  ServisaAuto.servis12.getAuti().stream().filter(auto -> {
				return auto.getVlasnik().getId() == LoginWin.currentUser.getId();
					}).collect(Collectors.toList());
		
		
		
		for (int i = 0; i < auti.size(); i++){
			if(auti.get(i).isObrisan())continue;   
			int id = auti.get(i).getId();
			   
			   
			  // Musterija vlasnik = auti.get(i).getVlasnik();
			   MarkaVozila marka = auti.get(i).getMarka();
			   ModeliAuto model = auti.get(i).getModel();
			   int godproiz = auti.get(i).getGodProiz();
			   int zapremina = auti.get(i).getZaprMotora();
			   int snaga = auti.get(i).getSnagaMotora();
			   VrstaGoriva vrstagor = auti.get(i).getVrstaGoriva();
			   

			   Object[] data = {id, marka, model, godproiz, zapremina,snaga,vrstagor};
			                               
			                          

			   tableModel.addRow(data);

			}
		
		
	}
}

	
