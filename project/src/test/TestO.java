package test;
import core.*;
import database.OracleClient;


public class TestO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OracleClient dbmServer = new OracleClient();
		dbmServer.connect("SYSTEM", "root");
		Interventions bot[] = dbmServer.getInterventions();
		System.out.print("length "+ bot.length);
		for(Interventions intervention:bot) {
			System.out.print(intervention.hour);
		}
	}

}
