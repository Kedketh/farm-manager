package model;

import java.sql.SQLException;
import java.util.ArrayList;

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
	private ObservableList<Bottelage> bottelages;
	private ObservableList<Transport> transports;

	public DataMgr(DbMgr db) throws ClassNotFoundException, SQLException {
		super();
		this.db = db;
		this.clients = db.getClientsList();
		this.champs = db.getChampsList();
		this.botteleuses = db.getBotteleuseList();
		this.moissonneuses = db.getMoissonneuseList();
		this.tracteurs = db.getTracteurList();
		this.recoltes = db.getRecoltes();
		this.bottelages = db.getBottelages();
		this.transports = db.getTransports();
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
		for (int i = 0; i < this.champs.size(); ++i) {
			if (this.champs.get(i).getIdCli() == IdCli)
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
	
	public ObservableList<Botteleuse> getBotteleuses(int idRec) throws ClassNotFoundException, SQLException {
		return db.getBotteleusesForRec(idRec);
	}
	
	public ObservableList<Botteleuse> getBotteleuses(String day, int fourchette,int idRec) throws ClassNotFoundException, SQLException {
		return db.getBotteleusesForDay(day,fourchette,idRec);
	}

	public void setBotteleuses(ObservableList<Botteleuse> botteleuses) {
		this.botteleuses = botteleuses;
	}

	public ObservableList<Moissonneuse> getMoissonneuses() {
		return moissonneuses;
	}

	public ObservableList<Moissonneuse> getMoissonneuses(String day, int fourchette,int idRec) throws ClassNotFoundException, SQLException {
		return db.getMoissonneuseForDay(day,fourchette,idRec);
	}
	public ObservableList<Moissonneuse> getMoissonneuses(int idRec) throws ClassNotFoundException, SQLException {
		return db.getMoissonneuseForRec(idRec);
	}
	
	public void setMoissonneuses(ObservableList<Moissonneuse> moissonneuses) {
		this.moissonneuses = moissonneuses;
	}

	public ObservableList<Tracteur> getTracteurs() {
		return tracteurs;
	}
	
	public ObservableList<Tracteur> getTracteurs(int idRec) throws ClassNotFoundException, SQLException {
		return db.getTracteursForRec(idRec);
	}
	public ObservableList<Tracteur> getTracteurs(String day, int fourchette,int idRec) throws ClassNotFoundException, SQLException {
		return db.getTracteursForDay(day,fourchette,idRec);
	}

	public void setTracteurs(ObservableList<Tracteur> tracteurs) {
		this.tracteurs = tracteurs;
	}

	public ObservableList<Recolte> getRecoltes() {
		return recoltes;
	}

	public ObservableList<Recolte> getRecoltes(String day) {
		ObservableList<Recolte> recoltes = FXCollections.observableArrayList();
		for (int i = 0; i < this.recoltes.size(); ++i) {
			if (this.recoltes.get(i).getDate().equals(day))
				recoltes.add(this.recoltes.get(i));
		}
		return recoltes;
	}
	public ObservableList<Recolte> getRecoltes(int idCh) throws ClassNotFoundException, SQLException{
		return db.getRecolteForChamps(idCh);
	}
	
	public ObservableList<Transport> getTransports() {
		return transports;
	}

	public void setTransports(ObservableList<Transport> transports) {
		this.transports = transports;
	}

	public void setRecoltes(ObservableList<Recolte> recoltes) {
		this.recoltes = recoltes;
	}

	public ObservableList<Bottelage> getBottelages() {
		return bottelages;
	}

	public void setBottelages(ObservableList<Bottelage> bottelages) {
		this.bottelages = bottelages;
	}

	public void update(String table, String field_id, int id, String field_data, int data) {
		db.update(table, field_id, id, field_data, data);
	}

	public void update(String table, String field_id, int id, String field_data, float data) {
		db.update(table, field_id, id, field_data, data);
	}

	public void update(String table, String field_id, int id, String field_data, String data) {
		db.update(table, field_id, id, field_data, data);
	}

	public void syncClients() throws ClassNotFoundException, SQLException {
		this.clients = db.getClientsList();
	}

	public void syncChamps() throws ClassNotFoundException, SQLException {
		this.champs = db.getChampsList();
	}

	public void syncMoissonneuses() throws ClassNotFoundException, SQLException {
		this.moissonneuses = db.getMoissonneuseList();
	}

	public void syncTracteurs() throws ClassNotFoundException, SQLException {
		this.tracteurs = db.getTracteurList();
	}

	public void syncBotteleuses() throws ClassNotFoundException, SQLException {
		this.botteleuses = db.getBotteleuseList();
	}

	public void syncRecoltes() throws ClassNotFoundException, SQLException {
		this.recoltes = db.getRecoltes();
	}
	
	public void addRecolte(String date, int idCli,int idCh, int idTrans, int idBot){
		db.insertRecolte(date, idCli,idCh, idTrans, idBot);
	}
	public void deleteRecolte(int id){
		db.delete("Recolte","Id_Rec",id);
	}
	public void updateMoissForRecolte(Moissonneuse moiss,int idRec,boolean state) throws ClassNotFoundException, SQLException{
		db.delete("RecolteMachine", "Id_Mach",moiss.getIdMach());
		if(state)
			db.insertMachineForRecolte(idRec,moiss.getIdMach());
	}
	
	public void updateTractForRecolte(Tracteur tract,int idRec,boolean state) throws ClassNotFoundException, SQLException{
		db.delete("RecolteMachine", "Id_Mach", tract.getIdMach());
		if(state)
			db.insertMachineForRecolte(idRec,tract.getIdMach());
	}
	
	public void updateBottForRecolte(Botteleuse bott,int idRec,boolean state) throws ClassNotFoundException, SQLException{
		db.delete("RecolteMachine", "Id_Mach", bott.getIdMach());
		if(state)
			db.insertMachineForRecolte(idRec,bott.getIdMach());
	}
	
	/* ====== MAJ INFO RECOLTE Accueil ====== */
	
	public void majinforecolte(String table, String colonne, int trac, String id_cli, int cli){
		String query = "UPDATE "+table+" SET "+colonne+"='"+trac+"' WHERE "+id_cli+"="+cli;
		System.out.println(query);
		
	}
}
