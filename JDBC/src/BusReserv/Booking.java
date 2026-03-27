package BusReserv;
import java.util.*;
import java.sql.SQLException;
import java.text.*;

public class Booking {
	String passengerName;
	int busNo;
	Date date;
	
	Booking(){
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter name of passenger: ");
		passengerName=scn.next();
		
		System.out.println("Enter bus no: ");
		busNo=scn.nextInt();
		
		System.out.println("Enter date dd-mm-yyyy");
		String dateInput = scn.next();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
		
		try {
			date=dateFormat.parse(dateInput);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	

	public boolean isAvailable() throws SQLException  {
		BusDao busdao = new BusDao();
		BookingDao bookingdao = new BookingDao();
		int capacity = busdao.getCapacity(busNo);

		
		int booked =bookingdao.getBookedCount(busNo,date);
		
		return booked<capacity;
	}
}
