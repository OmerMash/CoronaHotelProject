package hit.co.il;
public class SingletonReception
{

	static SingletonReception mySingleton;
	
	private SingletonReception() {}
	
    /*public void Invoke(Model invoker) {
		getMySingleton();
	}*/
	
	public static SingletonReception getMySingleton() {
		if (mySingleton == null)
			mySingleton = new SingletonReception();
		return mySingleton;
	}
	
	public void Controller(SingletonReception control) throws InterruptedException {
		Model.ClearScreen();
		
		while(true)
    	{
    		
			System.out.println("Debug info:  * Controller took control of the system * ");
			System.out.println();
			System.out.println();
			
        	//if(userLoggedIn == 1) break; 
        	int action = 0;
        	
        	while(action <= 0 || action > 5) {
        		System.out.println("\nEnter your choice :\n1.Check-In \n2.Check-Out \n3.Order to room\n4.Exit\n");
        	
        	action = Model.input.nextInt();
        	
        	Model model = new Model();
        	// associate user actions to the right flow when logged in to the system
        	switch(action)
        	{
        	//check in
        	case 1:
        		Model.CheckIn(control);
        		break;
        	//check out
        	case 3:
        		model.RoomReservation(control);
        		break;
        	//rooms
        	
        	}
    	}
		
	}
	
	}
}
