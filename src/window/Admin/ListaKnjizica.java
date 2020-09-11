package window.Admin;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Automobil;
import model.ServDeo;
import model.ServKnjizica;
import model.ServisAutomobila;
import model.Serviser.Specijalizacija;
import servFunkc.ServisaAuto;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListaKnjizica extends JDialog {
	private JTable table;
	private ArrayList<ServKnjizica> knjizice = new ArrayList<ServKnjizica>();
	public static int selektovanid = 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaKnjizica dialog = new ListaKnjizica();
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
	public ListaKnjizica() {
		setBounds(100, 100, 700, 500);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 122, 658, 318);
		getContentPane().add(scrollPane);
		
		JButton button = new JButton("Dodaj novi");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			DodajKnjizica dkn = new DodajKnjizica();
			dkn.setVisible(true);
			}
		});
		button.setBounds(12, 45, 109, 23);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("Izmeni");
		button_1.setEnabled(false);
		button_1.setBounds(12, 79, 109, 23);
		getContentPane().add(button_1);
		
		JButton button_2 = new JButton("Izadji");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		button_2.setBounds(581, 52, 89, 23);
		getContentPane().add(button_2);
		
		JButton button_3 = new JButton("Obrisi");
		button_3.setEnabled(false);
		button_3.setBounds(581, 86, 89, 23);
		getContentPane().add(button_3);
		
		//ServisaAuto.servis12.ucitajServis();
		knjizice = ServisaAuto.servis12.getKnjizica();
		String kolone[] = {"ID", "Automobil" , "    Lista servisa     "};
	

		DefaultTableModel tableModel = new DefaultTableModel(kolone, 0);
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		
		for (int i = 0; i < knjizice.size(); i++){
			if(knjizice.get(i).isObrisan())continue;
			int id = knjizice.get(i).getId();
			   Automobil auto = knjizice.get(i).getAuto();
			   List<ServisAutomobila> servisi = knjizice.get(i).getServlista();
			   

			   Object[] data = {id,auto,servisi};
			                               
			                          

			   tableModel.addRow(data);

			}
	

	}
}
