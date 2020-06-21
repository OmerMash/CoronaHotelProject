
public class Guest extends Input {
	
	//Variables
    protected static int guestCount;
    protected static int numOfGuestsToCheckIn;
    protected String Name = "guest_" + guestCounter();
    protected int Sex;
    protected int Age;
    protected int roomNumber;
    protected int UID;
    protected int Religious;
    
    
    //Methods
    //Ctor
    public Guest()
    {
    	guestCount++;
    }

    public static int guestCounter() {
        return guestCount;
    }

    public void getNumOfGuests() {
    	System.out.print("Please enter number of Guests for check-in: ");
    	numOfGuestsToCheckIn = input.nextInt();
    }
    
    public void createGuest() {
    	Guest guest = new Guest();	
    	for(int i = 1  ;  i <= numOfGuestsToCheckIn  ;  i++) {
        	System.out.println();
        	System.out.println("Please enter Guest "+i+" info:");
        	System.out.println("Guest "+ i +" Name:");
        	Name = input.next();
        	System.out.println("Guest "+ i +" Sex: 1-male, 2-female ");
        	Sex = input.nextInt();
        	System.out.println("Guest "+ i +" Age: ");
        	Age = input.nextInt();
        	System.out.println("Guest "+ i +" ID: ");
        	UID = input.nextInt();
        	System.out.println("Guest "+ i +" Religious?:  1-Yes, 2-No ");
        	Religious = input.nextInt();
    	}
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
