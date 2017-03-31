package presentation;

import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import metier.Client;

public class ClientModele extends AbstractTableModel {

	private static final long serialVersionUID = -793548453026650662L;

	// colonnes de la table
	private String[] tableColumnNames = new String[] { "ID", "NOM", "PRENOM", "COULEUR YEUX" };
	// lignes de la table
	private Vector<String[]> tableValues = new Vector<String[]>();

	@Override
	public int getColumnCount() {
		// nombre de colonnes
		return tableColumnNames.length;
	}

	@Override
	public int getRowCount() {
		// nombre de lignes
		return tableValues.size();
	}

	@Override
	public Object getValueAt(int rowindex, int columnIndex) {
		// retour la valeur d'une cellule
		return tableValues.get(rowindex)[columnIndex];
	}

	// retourner le nom de la colonne
	public String getColumnName(int columnIndex) {
		return tableColumnNames[columnIndex];
	}

	// remplir le tableau avec les donnée issues de la bdd
	public void setData(List<Client> clients) {
		tableValues = new Vector<String[]>();
		for (Client c : clients) {
			tableValues.add(new String[] { String.valueOf(c.getId()), 
											c.getNom(), 
											c.getPrenom(), 
											c.getCouleurYeux() });
		}
		fireTableChanged(null);
	}
}
