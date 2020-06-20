package window.Admin;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.ServDeo;
import model.ServKnjizica;
import servFunkc.ServisaAuto;

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
		
		ServisaAuto.servis12.ucitajServis();
		knjizice = ServisaAuto.servis12.getKnjizica();
		String kolone[] = {"ID", "Automobil" , "    Lista delova     "};
	

		DefaultTableModel tableModel = new DefaultTableModel(kolone, 0);
		table = new JTable();
		

	}
}
