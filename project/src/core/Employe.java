package core;

public class Employe {
	
	public int numEmploye;
	public float salaire;
	public String name;
	public String lastName;
	public String category;
	public int interventions;
	Employe(){
		
	}
	public Employe(String name , String lastName,int numEmploye ,float salaire, String category){
		this.numEmploye = numEmploye;
		this.salaire = salaire;
		this.name = name;
		this.lastName = lastName;
		this.category = category;
	}
	public void setInterventions(int interventions) {
		this.interventions = interventions;
	}
	public void toPrint() {
		System.out.println(this.numEmploye+" "+this.lastName+" "+this.name);
	}
	public int getNumEmploye() {
		return numEmploye;
	}

}
