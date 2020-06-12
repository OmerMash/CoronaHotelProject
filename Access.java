import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;

// /Users/i513387/eclipse-workspace/CoronaHotel/RESEPTION_ACCESS.txt 


public class Access extends Input{
	
	//Variables
    protected static int userCount=1;
    //protected static int numOfGuestsToCheckIn;
    protected String userName;
    protected String userID="User"+userCount;
    protected String pass="000";
    static String fileName = ("RESEPTION_ACCESS.txt") ;    //file name = source file name + _parsed.txt
	static boolean existAccessFile = false;
	String append_value;
	boolean loggedIn=false;
	static File file;
	static FileChannel fileChannel;


	
    //protected int Sex;
    //protected int Age;
    //protected int roomNumber;
    //protected int UID;
    //protected int Religious;	
    
    //Methods
    //Ctor
    public Access()
    {
    	userCount++;    	
    }
	
    
    public static int userDecision()
    {
    	//go to login scenario
    	System.out.println();
    	System.out.println("MENU");
    	System.out.println("CHOOSE ACTION:");
    	System.out.println();
    	System.out.println();
    	System.out.println("Login - 1");
    	System.out.println("Register - 2");
    	Reception.accessDecision  = Input.input.nextInt();
    	if(Reception.accessDecision != 1 && Reception.accessDecision != 2)
    	{
    		System.out.println("PLEASE CHOOSE ONLY 1 OR 2.");
    		Reception.accessDecision = 0;
    	}
    	return Reception.accessDecision;
    }
	/*********************************************************************************************************************************************/
    public void AbsoluteFilePathExample() throws IOException
    {
    	Reception.absolutePath = file.getAbsolutePath();
		System.out.println("File path : " + Reception.absolutePath);

		String filePath = Reception.absolutePath.
			     substring(0,Reception.absolutePath.lastIndexOf(File.separator));

		System.out.println("File path : " + filePath);
	}
	/*********************************************************************************************************************************************/
    public boolean StringFinder(String user, String path) {
    {
        double count = 0,countBuffer=0,countLine=0;
        String lineNumber = "";
        
        BufferedReader br;

        String line = "";

        try {
            br = new BufferedReader(new FileReader(path));
            try {
                while((line = br.readLine()) != null)
                {
                    if (line.equals(user))
                    {
                          br.close();
                          return true;
                    } 
                    br.close();
                    return false;
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	return false;
    }
    
	/*********************************************************************************************************************************************/
    public int CreateAccessFile() {
 	    //creating text file to save user names + passwords 
 	    file = new File(fileName);     //create the file.
 	   try {
 		   			
 		   	if (file.createNewFile())
			   {
	         	System.out.println("ACCESS file created"); //means no access file existed before->software havn't been used yet->go to register flow
	         	Reception.absolutePath = file.getAbsolutePath();
	        	//get file path + get file size  
	        	Path filePath = Paths.get(fileName);
                fileChannel = FileChannel.open(filePath);
                long fileSize = fileChannel.size();
                System.out.format("The size of the file: %d bytes", fileSize); //debug 
                System.out.println();
	         	System.out.println("\n path: "+ Reception.absolutePath);
	         	System.out.println();
	     
	         	return 0;
			   }
			else {
				System.out.println("ACCESS file Exist"); //means no access file existed before->software havn't been used yet->go to register flow
	         	Reception.absolutePath = file.getAbsolutePath();
	        	//get file path + get file size  
	        	Path filePath = Paths.get(fileName);
                fileChannel = FileChannel.open(filePath);
                long fileSize = fileChannel.size();
                System.out.format("The size of the file: %d bytes", fileSize); //debug 
                System.out.println();
	         	System.out.println("path: "+ Reception.absolutePath);
	         	System.out.println();
				return 1;
			}
		} 
 	   
 	   catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
 	   return 1;
 	}
 	/*********************************************************************************************************************************************/
 	 
 	/*********************************************************************************************************************************************/
 	public int Register(Reception user) throws IOException
 	{
 		int passValidation=0;
 		
 		System.out.println("REGISTER");
 		
 		//get reception user name
 		System.out.println("Please Enter Username: ");
 		this.userName = input.next();
 		
 		//get reception user password + validate password
 		for(int i=0 ; i<4 ; i++)
 		{
 			if (i==3) return 0;
 			System.out.println("Please Enter Password: ");
 			this.pass = input.next();
 			System.out.println("Verify Password: ");
 			String verifyPass = input.next();
 			if(this.pass.equalsIgnoreCase(verifyPass)) {
 				passValidation = 1;
 				break;
 			}
 			else {
 				System.out.println();
 				System.out.println("Passwords does not match");
 				System.out.println();
 				System.out.println();
 				continue;
 			}
 		}
 		FileWriter writer = new FileWriter (fileName,true);
 		writer.write(this.userName + "," + this.pass + ".");
 		writer.write('\n');
        //writer.append(this.userName + "," + this.pass + ".");
 		writer.flush(); 

 		System.out.println();
 		System.out.println("User " + this.userName + " Registerd succesfully"  ); 		
 		return(1);
 	}
 	
 	
	/*********************************************************************************************************************************************/	 
 	public boolean foundUserInAccessFile(String user, String file) throws FileNotFoundException
 	{
 			String line;
 			
 			Scanner scanner = new Scanner(file);
 			while (scanner.hasNextLine()) {
 			    String nextToken = scanner.nextLine();
 			    if (nextToken.equalsIgnoreCase(user))
 			    	return true;
 			}
 			return false;
 	}
	/**
	 * @throws FileNotFoundException *******************************************************************************************************************************************/	 

 	
 	public int Login(Reception user, String file) throws FileNotFoundException
 	{
 		String loginUserName, loginPassword, userDetails;
 		
 		while(loggedIn == false) {
 			
 			System.out.println("LOGIN" + '\n');
 	 		System.out.println("Enter UserName: ");
 	 		loginUserName = input.next();
 	 		System.out.println();
 	 		System.out.println("Enter Password: ");
 	 		loginPassword = input.next(); 
 	 		
 	 		userDetails = loginUserName + "," + loginPassword + ".";
 	 		
 	 		if(StringFinder(userDetails, Reception.absolutePath))// need to find a way to parse the file to validate login details!
 	 				{
 	 					System.out.println();
 	 					System.out.println();
 	 					System.out.println("Logged in succesfully");
 	 					loggedIn = true;
 	 					return 1;
 	 				}
 	 		System.out.println();
 	 		System.out.println();
 	 		System.out.println("PASSWORD OR USERNAME DID NOT MATCH");
 	 		System.out.println();
 	 		System.out.println("TRY AGAIN - 1");
 	 		System.out.println("LEAVE - 0");
 	 		int userChose = input.nextInt();
 	 		
 	 		if(userChose == 0) {
 	 			System.out.println("USER DID NOT LOGGED IN - GOING BACK TO ACCESS MENU");
 	 			return 0;
 	 		}
 	 		else if(userChose == 1) continue;
 	 		else if(input.nextInt() != 1) {
 	 			System.out.println("PLEASE CHOOSE ONLY 0 OR 1.");
 	 			continue;
 	 		}
 		}
 		
		return 0;
 		
 	}
 	

 	
	/*********************************************************************************************************************************************/
	public void PrintUserDetails(Access userID) {
		System.out.println("REGISTERED");
		System.out.println("Please Enter Username: ");
    	this.userID = input.next();
    	this.pass = input.next();
	}
	/*********************************************************************************************************************************************/
	
}
