package core;

public class Cars {
	
	public int numCar;
	public int numClient;
	public int numIntervention;
	public int numModel;
	public String model;
	public String marque;
	public int count;
	Cars(){
		
	}
	
	public Cars(String model,String marque,int count) {
		this.model = model;
		this.marque = marque;
		this.count = count;
		
	}
	public Cars(int numCar,String model,String marque,int numIntervention,int count) {
		this.model = model;
		this.marque = marque;
		this.count = count;
		this.numIntervention = numIntervention;
		this.numCar = numCar;
		
	}
	public void toPrint() {
		System.out.println(this.count+" "+this.model+" "+this.marque);
	}
	public String getModel() {
		return model;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
