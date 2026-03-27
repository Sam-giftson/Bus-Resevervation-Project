package BusReserv;

import java.util.Scanner;
import java.sql.SQLException;
import java.util.ArrayList;
public class BusDemo {

	public static void main(String[] args) throws SQLException {
		
		BusDao busdao = new BusDao();
		busdao.displayBusInfo();
		
		 

		Scanner scn=new Scanner(System.in);
		int input=1;
		while(input==1)
		{
			System.out.println("Enter 1 to Enter 2 to Exit");
			 input = scn.nextInt();
		
			if(input==1)
			{
				Booking booking = new Booking();
				if(booking.isAvailable()) {
					BookingDao bookingdao = new BookingDao();
					bookingdao.addBooking(booking);
					System.out.println("your booking is confirmed");
				}
				else
				{
					System.out.println("sorry choose other bus or dates");
				}
				
			}
			
		}
		scn.close();
	}
}
