import java.io.Console;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class Reception extends Access {
    
	//Variables
	static String absolutePath;
	static int successfullyRegistered; 
	static int userLoggedIn=0;
	static int tries;
	final static String ESC = "\033[";
	static int existUsersAccessFile=0;
	static int accessDecision=0;
	
	//static int existUsersAccessFile=0;
   //Ctor
    public Reception(){}    
     


   
	public static void main(String[] args) {
		
		System.out.println("                         *** Welcome to Corona Hotel Management System ***");
		System.out.println();   
			
	    try {
	           
	        	Reception user = new Reception();
	        	existUsersAccessFile = user.CreateAccessFile(); //go to create file function and create file for users access if it doesn't exist yet, return 1 if file is created. if file already exist return 0.
                
        	while(accessDecision == 0) 
        	{
	            if(existUsersAccessFile == 1 && !fileName.isEmpty() )
	            {
		            	/*//go to login scenario
		            	System.out.println("Login - 1");
		            	System.out.println("Register - 2");
		            	accessDecision  = Input.input.nextInt();
		            	if(accessDecision != 1 && accessDecision != 2)
		            	{
		            		System.out.println("PLEASE CHOOSE ONLY 1 OR 2.");
		            		accessDecision = 0;
		            	}*/
	            	user.userDecision();
	            }
	            else 
	            {
            		//go to register scenario
	            	for(tries = 0 ; successfullyRegistered!=1 && tries < 3 ; tries++)
	            	{
	            		System.out.println("Please Register to Enter Reception");
	            		successfullyRegistered = user.Register(user);
	            		if(successfullyRegistered==1) {
	            			accessDecision = 1;
	            			break;
	            		}
	            		System.out.println("Failed to Register Please try again");
            			System.out.println();
	            	}
	            	if(tries == 3) {
	            		System.out.println("3 Failed password attempts detected, Starting registration again");
	        			System.out.println();
	        			TimeUnit.SECONDS.sleep(3);
	        			accessDecision = 0;
	            	}
              	
	        	}
	        }
        	
        	switch(accessDecision)
        	{
        	case 1:
        		//go to login scenario
        		boolean firstRound = true;
        		while(userLoggedIn !=1 ) {
        			if(firstRound == false)
        				userLoggedIn = Access.userDecision();
        			userLoggedIn = user.Login(user, fileName);
        			firstRound = false;
        		}
        		//go to reception menu - need to build reception menu like a junction - everything is done from there
        		break;
        	case 2:
        		//go to register scenario
        		System.out.println("Please Register to Enter Reception");
        		successfullyRegistered = user.Register(user);
        		
        		if(successfullyRegistered == 1)
            		userLoggedIn = user.Login(user, fileName);
        		
        		break;
        	}
        	
        }
	        
        catch (Exception exc){
            exc.printStackTrace();
        }


	}
}