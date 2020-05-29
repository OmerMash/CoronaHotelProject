
public class COVID {
	private boolean Health;
	
	private void timeForCoronaTest(int UID, boolean Health, int counterTime, int numOfCoronaTests) {
		if(counterTime>=14)
		{
			if(numOfCoronaTests>=3 && Health == true) {
				System.out.println("The Guest" + UID +"need to do Check Out");
			}
			
			else // numOfCoronaTests<3
			{
				System.out.println("The Guest" + UID +" need to do more Corona test");
				System.out.println("Send the guest to do Corona test..");
			}
		} 
		else //counterTime<14 
		{
			 System.out.println("The Guest" + UID +"have"+ (14 -counterTime) +"for the next Corona test");
		}

}
	private boolean is_healthy(int UID, boolean Health) {
		System.out.println("The Guest"+ UID+ "health status:");
		if(Health==true) {
			System.out.println("The Guest is healthy!");
			return true;
		}
			
		else {
			System.out.println("The Guest is NOT healthy!");
			return false;
		}
	}
	private void TimeToHeal(int UID,int counterTime) {
		System.out.println("The Guest"+ UID+ "have" +(14-counterTime) +"for healing... Of course, it depends on how many tests the guest did.");
	}
}


