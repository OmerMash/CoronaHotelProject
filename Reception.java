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
	
   //Ctor
    public Reception(){}    
     


   
	public static void main(String[] args) {
		
		System.out.println("                         *** Welcome to Corona Hotel Management System ***");
		System.out.println();   
			
	    try {
	           
	        	Reception user = new Reception();
	        	existUsersAccessFile = user.CreateAccessFile(); //go to create file function and create file for users access if it doesn't exist yet, return 1 if file is created. if file already exist return 0.
            
	        //while user does not have access decision yet (didn't chose to login or register)    
        	while(accessDecision == 0) 	
        	{
	            if(existUsersAccessFile == 1 && !Access.fileName.isEmpty() ) // if access file exist and it is not empty - then ask the user if he want's to login or register
	            	user.userDecision();
	            
	            else // if file not exist or exist but empty - that means no users exist in access file - go to register scenario
	            {
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
        	
        	while(true)
        	{
        		// associate user decision to the right flow (register / login)
            	switch(accessDecision)
            	{
            	case 1:
            		//go to login scenario
            		boolean firstRound = true;
            		if (userLoggedIn == 2) firstRound = false; 
            		while(userLoggedIn !=1 ) {
            			if(firstRound == false)
            				userLoggedIn = Access.userDecision();
            			if(userLoggedIn == 2) break;
            			userLoggedIn = user.Login(user, fileName);
            			firstRound = false;
            		}
            		if(userLoggedIn == 2) continue;
            		
            		
            		System.out.println("---------------------> Continue to Reception CLI to use the System now when user is logged in.");
            		//go to reception menu - need to build reception menu like a junction - everything is done from there
            		break;
            	case 2:
            		//go to register scenario
            		successfullyRegistered = user.Register(user);
            		
            		if(successfullyRegistered == 1)
            			accessDecision = 1;
            		break;
            	}	
            	if(userLoggedIn == 1) break; 
        	}
        	        	
        }
	        
        catch (Exception exc){
            exc.printStackTrace();
        }


	}
}