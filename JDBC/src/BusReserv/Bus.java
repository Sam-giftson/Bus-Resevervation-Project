package BusReserv;

public class Bus {
	
	private int busNo;
	private boolean ac;
	private int capacity;  //get and set
	
	Bus(int no,boolean ac,int cap){
		this.busNo=no;
		this.ac=ac;
		this.capacity=cap;
	}
	
	public int getBusNo() {
		return busNo;
	}

	public void setBusNo(int no) {
		 busNo=no;
	}
	
	public boolean isAc() {           //accessor
		return ac;
	}
	
	public void setAc(boolean val) {   //mutator
		ac = val;
		
	}
	public int getCapacity() {           //accessor
		return capacity;
	}
	
	public void setCapacity(int cap) {   //mutator
		capacity=cap;
	}
	
	public void displayBusInfo(){
		System.out.println("Bus no " + busNo + " Ac: " + ac + " Total Capacity: " + capacity);
	}


}
