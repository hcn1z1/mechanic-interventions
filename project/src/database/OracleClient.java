package database;

import core.Cars;
import core.Employe;
import core.Interventions;
import java.sql.Connection;
import java.sql.*;
import java.sql.Date;

public class OracleClient {
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet result = null;
	public OracleClient(){
		
	}
	public boolean connect(String user, String password){
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			connection = DriverManager.getConnection(url,user,password);
			statement = connection.createStatement();
			// start default time format
			date();
			return true;
		}
		catch(Exception e) {
			System.out.println("Connection ERROR: couldn't establish connection with the host."+e);
			return false;
		}
	}
	public String connectGetRole() {
		try {
			ResultSet results = this.executeQuery("SELECT * FROM SESSION_ROLES");
			results.next();
			return results.getString(1);
		}
		catch(Exception e) {
			System.out.println("Couldn't Retrieve ROLE .. will be treated as DBA/ ERROR : "+e);
			return "DBA";
		}
	}
	ResultSet executeQuery(String query) throws Exception{
		return statement.executeQuery(query);
	}
	
	protected void date() throws Exception{
		executeQuery("ALTER SESSION SET NLS_DATE_FORMAT='YYYY-MM-DD'");
	}
	void closeConnection() {
		try {
		connection.close();
		statement.close();
		}catch(Exception SQLException) {
			System.out.println("Connection couldn't be closed");
		}
	}
	void closeResult() {
		try{
			result.close();
		}
		catch(Exception e) {
			
		}
	}
	public String executeR(String req) { // same as executeStatement but this returns a string
		try {
			System.out.println(req);
			ResultSet results = this.executeQuery(req);
			System.out.print("Executed !");
			return "";
		}
		catch(Exception e) {
			System.out.println("Error: while executing query : "+e);
			return "Error : "+e;
		}
	}
	public boolean executeStatement(String req) {
		try {
			System.out.println(req);
			ResultSet results = this.executeQuery(req);
			System.out.print("Executed !");
			return true;
		}
		catch(Exception e) {
			System.out.println("Error: while executing query : "+e);
			return false;
		}
	}
	
	protected void setInterventions(Employe[] employes) {
		for(int i = 0; i<employes.length;i++) {
				try {
					ResultSet results = this.executeQuery("SELECT EMPLOYE.NUMEMPLOYE, count(*) "
							+"FROM EMPLOYE, INTERVENANTS "
							+"WHERE EMPLOYE.NUMEMPLOYE = INTERVENANTS.NUMEMPLOYE and EMPLOYE.NUMEMPLOYE="
							+ employes[i].getNumEmploye() + " "
							+"Group by EMPLOYE.NUMEMPLOYE");
					results.next();
					int interventions = results.getInt(2);
					employes[i].setInterventions(interventions);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("Error retrieving info from "+ employes[i].getNumEmploye() + " : "+e);
					System.out.println("This error means no interventions = 0");
					employes[i].setInterventions(0);
					
				}
				
				// setting interventions number for each employee
				
			}
			
	}
	
	public Employe[] getEmployees() {
		try {
			Employe[] employes = new Employe[this.getEmployeNumber()];
			ResultSet results = this.executeQuery("SELECT * FROM EMPLOYE");
			int i = 0;
			// retrieving all employees and impliment them to object
			
			while(results.next()) {
				Employe employe = new Employe(results.getString(2),results.getString(3),results.getInt(1),results.getFloat(5),results.getString(4));
				employe.toPrint();
				// add employee to array
				employes[i] = employe;
				i++;
			}
			// settting interventions count based on numEmploye
			this.setInterventions(employes);
			return employes;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error retrieving ALL EMPLOYEES: "+e);
			return null;
		}
	}
	
	public Cars[] getCars() {
		try {
			Cars[] cars = new Cars[this.getCarsNumber()];
			ResultSet results = this.executeQuery("SELECT VEHICULE.NUMVEHICULE,MODELE.MODELE,MARQUE.MARQUE,INTERVENTIONS.NUMINTERVENTION ,count(*) FROM INTERVENTIONS,VEHICULE,MARQUE,MODELE WHERE INTERVENTIONS.NUMVEHICULE=VEHICULE.NUMVEHICULE and MODELE.NUMMODELE=VEHICULE.NUMMODELE and MODELE.NUMMARQUE=MARQUE.NUMMARQUE Group by VEHICULE.NUMVEHICULE,INTERVENTIONS.NUMINTERVENTION,MODELE.MODELE,MARQUE.MARQUE");
			int i = 0;
			
			while(results.next()) {
				System.out.println("Getting a fucking car");
				Cars car = new Cars(results.getInt(1),results.getString(2),results.getString(3),results.getInt(4),results.getInt(5));
				
				cars[i] = car;
				i++;
			}
			return cars;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error retrieving cars: "+e);
			return null;
	}}
	
	@SuppressWarnings("deprecation")
	public Interventions[] getInterventions() {
		try {
			Interventions[] intervs = new Interventions[this.getInterventenantsNumber()];
			ResultSet results = this.executeQuery("SELECT EMPLOYE.NOMEMP,INTERVENTIONS.NUMINTERVENTION,INTERVENTIONS.TYPEINTERVENTION,INTERVENTIONS.DATEDEBINTERV,INTERVENTIONS.DATEFININTERV,INTERVENTIONS.NUMVEHICULE"
					+ " FROM INTERVENANTS,EMPLOYE,INTERVENTIONS"
					+ " WHERE INTERVENANTS.NUMINTERVENTION= INTERVENTIONS.NUMINTERVENTION"
					+ " and INTERVENANTS.NUMEMPLOYE=EMPLOYE.NUMEMPLOYE");
			int i = 0;
			// retrieving all employees and impliment them to object
			
			while(results.next()) {
				Interventions interv = new Interventions(results.getString(1),results.getInt(2),results.getString(3),results.getDate(4),results.getDate(5),results.getInt(6));
				interv.printOut();
				// add employee to array
				intervs[i] = interv;
				i++;
			}
			return intervs;
			// settting interventions count based on numEmploye
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error retrieving ALL INTERVENTIONS: "+e);
			return null;
	}}
	
	public int getCarsNumber() {
			try{
				ResultSet results = this.executeQuery("SELECT count(*) FROM INTERVENTIONS,VEHICULE WHERE VEHICULE.NUMVEHICULE = INTERVENTIONS.NUMVEHICULE");
				 while (results.next()) {
			            return (Integer) results.getInt(1);
			        }
				return 0;
			}catch(Exception error) {
				System.out.println("error : "+error);
				return 0;
			}
		}
	public int getEmployeNumber() {
		try{
			ResultSet results = this.executeQuery("SELECT count(*) FROM EMPLOYE");
			 while (results.next()) {
		            return (Integer) results.getInt(1);
		        }
			return 0;
		}catch(Exception error) {
			System.out.println("error : "+error);
			return 0;
		}
	}
	public int getInterventenantsNumber() {
		try{
			ResultSet results = this.executeQuery("SELECT count(*) FROM INTERVENANTS");
			 while (results.next()) {
		            return (Integer) results.getInt(1);
		        }
			return 0;
		}catch(Exception error) {
			System.out.println("error : "+error);
			return 0;
		}
	}
	public void updateLastDate(String newValue,int numIntervention) {
		try {
			//String[] data = newValue.split("-");
			this.executeQuery("ALTER SESSION SET NLS_DATE_FORMAT='YYYY-MM-DD'");
			this.executeQuery("commit");
			ResultSet results = this.executeQuery("UPDATE INTERVENANTS SET DATEFIN='"+newValue+"' WHERE NUMINTERVENTION="+numIntervention);
			ResultSet result_ = this.executeQuery("UPDATE INTERVENTIONS SET DATEFININTERV ='"+newValue+"' WHERE NUMINTERVENTION="+numIntervention);
			this.executeQuery("ALTER SESSION SET NLS_DATE_FORMAT='YYYY-MM-DD HH24:MI:SS'");
		}
		catch(Exception e) {
			System.out.println("Error: Couldn't update date ;" + e);
		}
	}
	public void updateSalaryValue(float newValue,int numEmploye) {
		try{
			ResultSet results = this.executeQuery("UPDATE EMPLOYE SET SALAIRE="+newValue+" WHERE NUMEMPLOYE="+numEmploye);
			 
		}catch(Exception error) {
			System.out.println("error : "+error);
		}
	}


}
