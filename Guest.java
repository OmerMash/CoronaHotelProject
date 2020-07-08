import java.util.Scanner;

public class Guest{
	
	//Variables
    protected static int guestCount=0;
    protected int numOfGuestsToCheckIn;
    protected String Name;
    protected int Sex;
    protected int Age;
    protected int roomNumber;
    protected double UID;
    protected int Religious;
	public static Scanner input = new Scanner(System.in);	

    
    //Methods
    //Ctor
    public Guest()
    {
    	guestCount++;
    }

    /*public static Guest createGuest() {
    	  	Guest guest = new Guest();	
    	  	System.out.println("Please fill-up Guest Details for Check-in :");
    	  	System.out.println();
        	System.out.println();
        	
        	
        	System.out.println("Guest Details:");
        	System.out.println("Guest Name:");
        	guest.Name = input.next();
        	System.out.println("Guest ID: ");
    		guest.UID = input.nextDouble();
        	
        	while(guest.Sex != 1 && guest.Sex !=2) {
        		System.out.println("Guest Sex: 1-male, 2-female ");
        		guest.Sex = input.nextInt();
            	if(guest.Sex != 1 && guest.Sex !=2) {
            		System.out.println("Please Choose 1 or 2 only.");
            		System.out.println();
            	}
        	}  	
        	while(guest.Age <= 0 || guest.Age > 120) {
        		System.out.println("Guest Age:");
        		guest.Age = input.nextInt();
            	if(guest.Age <= 0 || guest.Age > 120) {
            		System.out.println("Please enter valid age only.");
            		System.out.println();
            	}
        	}
        	while(guest.Religious != 1 && guest.Religious !=2) {
        		System.out.println("Religious?:  1-Yes, 2-No ");
        		guest.Religious = input.nextInt();
            	if(guest.Religious != 1 && guest.Religious !=2) {
            		System.out.println("Please Choose 1 or 2 only.");
            		System.out.println();
            	}
        	}
        	return guest;
    	}
*/
        	
        	
    
    
    
    public static int guestCounter() {
        return guestCount;
    }  

    
    public void printCheckInDetails() {
    	System.out.println();
    	System.out.println();
    	System.out.println("Check in details:");
    	System.out.println();
    	System.out.println(Guest.guestCounter()+ " Guests checked-in successfuly:");
    	System.out.println();
    	for(int i = 1  ;  i <= numOfGuestsToCheckIn  ;  i++) {
        	System.out.println("Guest_"+ i + " info:");
        	System.out.println("Name: " + Name);
        	System.out.println("Sex: " + Sex);
        	System.out.println("Age " + Age);
        	System.out.println("ID: " + UID);
        	System.out.println("Religoius: " + Religious);
        	System.out.println();
    	}
    }
    
    public void DeleteGuest(Guest UID) {
    	//add body - free memory allocation + decrease guestCounter + update rooms
    }
    
    
    
    
    
    
    
    
}
