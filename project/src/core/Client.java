package core;
import date.Date;

public class Client {
	
	public int numClient;
	public String civ;
	public String nomClient;
	public Date dateNaissance;
	public String addresse;
	public String telProf;
	public String telPrev;
	public String fax;
	Client(){
		
	}
	Client(int numClient_,String civ_ ,String nomClient_ ,Date dateNaissance , String addresse_, String telProf , String telPrev , String fax){
		this.numClient = numClient_;
		this.civ = civ_;
		this.addresse = addresse_;
		this.nomClient = nomClient_;
		this.dateNaissance = dateNaissance;
		this.telProf = telProf;
		this.telPrev = telPrev;
		this.fax = fax;
	}

}
