package model;

import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataMgr {
	private DbMgr db;
	
	private ObservableList<Client> clients;
	private ObservableList<Champs> champs;
	private ObservableList<Botteleuse> botteleuses;
	private ObservableList<Moissonneuse> moissonneuses;
	private ObservableList<Tracteur> tracteurs;
	private ObservableList<Recolte> recoltes;
	
	
	public DataMgr(DbMgr db) throws ClassNotFoundException, SQLException {
		super();
		this.db = db;
		this.clients = db.getClientsList();
		this.champs = db.getChampsList();
		this.botteleuses = db.getBotteleuseList();
		this.moissonneuses = db.getMoissonneuseList();
		this.tracteurs = db.getTracteurList();
		this.recoltes = db.getRecoltes();
	}


	public DbMgr getDb() {
		return db;
	}


	public void setDb(DbMgr db) {
		this.db = db;
	}


	public ObservableList<Client> getClients() {
		return clients;
	}


	public void setClients(ObservableList<Client> clients) {
		this.clients = clients;
	}


	public ObservableList<Champs> getChamps() {
		return champs;
	}
	
	public ObservableList<Champs> getChamps(int IdCli) {
		ObservableList<Champs> champs = FXCollections.observableArrayList();
		for(int i = 0; i < this.champs.size(); ++i){
			if(this.champs.get(i).getIdCli() == IdCli)
				champs.add(this.champs.get(i));
		}
		return champs;
	}


	public void setChamps(ObservableList<Champs> champs) {
		this.champs = champs;
	}


	public ObservableList<Botteleuse> getBotteleuses() {
		return botteleuses;
	}


	public void setBotteleuses(ObservableList<Botteleuse> botteleuses) {
		this.botteleuses = botteleuses;
	}


	public ObservableList<Moissonneuse> getMoissonneuses() {
		return moissonneuses;
	}
	
	public ObservableList<Moissonneuse> getMoissonneuses(String day) {
		ObservableList<Moissonneuse> moissonneuses = FXCollections.observableArrayList();
		for(int i = 0; i < this.recoltes.size(); ++i){
			if(this.recoltes.get(i).getDate() == day)
				moissonneuses.add(this.moissonneuses.get(i));
		}
		return moissonneuses;
	} 


	public void setMoissonneuses(ObservableList<Moissonneuse> moissonneuses) {
		this.moissonneuses = moissonneuses;
	}


	public ObservableList<Tracteur> getTracteurs() {
		return tracteurs;
	}


	public void setTracteurs(ObservableList<Tracteur> tracteurs) {
		this.tracteurs = tracteurs;
	}


	public ObservableList<Recolte> getRecoltes() {
		return recoltes;
	}
	
	public ObservableList<Recolte> getRecoltes(String day) {
		ObservableList<Recolte> recoltes = FXCollections.observableArrayList();
		for(int i = 0; i < this.recoltes.size(); ++i){
			if(this.recoltes.get(i).getDate().equals(day))
				recoltes.add(this.recoltes.get(i));
		}
		return recoltes;
	}


	public void setRecoltes(ObservableList<Recolte> recoltes) {
		this.recoltes = recoltes;
	}
	
		
	
}
