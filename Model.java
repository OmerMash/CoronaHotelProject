package hit.co.il;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import hit.co.il.Enums.eProductType;

import java.io.BufferedReader;
import java.io.FileReader;


/*interface myModel{
	int userDecision();
	int Login(Model user, String file);
	void AbsoluteFilePath();
	boolean StringFinder(String user, String path);
	int CreateAccessFile();
	int Register(Access user);
	boolean foundUserInAccessFile(String user, String file);
	int Login(myModel user, String file);
	void PrintUserDetails(Model userID);
	void ClearScreen();
	


static Scanner input = new Scanner(System.in);
*/

    
    
public class Model{

	
	public Model(){}
	public static Scanner input = new Scanner(System.in);	
	
	//Variables
    protected static int userCount=1;
    protected static int numOfGuestsToCheckIn;
    protected String userName;
    protected String userID="User"+userCount;
    protected String pass="000";
    String AccessfileName = ("RESEPTION_ACCESS.txt") ;    //file name = source file name + _parsed.txt
    static String GuestfileName = ("Guest.txt") ;    //file name = source file name + _parsed.txt
	static boolean existAccessFile = false;
	String append_value;
	boolean loggedIn=false;
	static File file;
	static FileChannel fileChannel;
	static long fileSize;
	static int userChose;
	static SingletonReception mySingleton;
	
	private ProductsHash productsCollection = new ProductsHash();
    
    /*********************************************************************************************************************************************/
    public int userDecision()
    {
    	ClearScreen();
    	Access.accessDecision = 0;
    	while(Access.accessDecision != 1 && Access.accessDecision != 2)
    	{
    	//go to login scenario
    	System.out.println();
    	System.out.println("MENU");
    	System.out.println("CHOOSE ACTION:");
    	System.out.println();
    	System.out.println();
    	System.out.println("Login - 1");
    	System.out.println("Register - 2");
    	Access.accessDecision  = input.nextInt();
    	if(Access.accessDecision != 1 && Access.accessDecision != 2)
    		System.out.println("------> PLEASE CHOOSE ONLY 1 OR 2.");
    	}
    	return Access.accessDecision;
    }
	/*********************************************************************************************************************************************/

	/*********************************************************************************************************************************************/
    public void AbsoluteFilePath()
    {
    	Access.absolutePath = file.getAbsolutePath();
		System.out.println("File path : " + Access.absolutePath);

		String filePath = Access.absolutePath.
			     substring(0,Access.absolutePath.lastIndexOf(File.separator));

		System.out.println("File path : " + filePath);
	}
	/*********************************************************************************************************************************************/

	/*********************************************************************************************************************************************/
    public boolean StringFinder(String user, String path) {
    {
        double count = 0,countBuffer=0,countLine=0;
        
        BufferedReader br;

        String Thisline = "";

        try {
        	
            br = new BufferedReader(new FileReader(path));
            
            try {
                while((Thisline = br.readLine()) != null)
                {
                    if (Thisline.equals(user))
                    {
                          br.close();
                          return true;
                    } 
                }
                br.close();
                return false;
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
	return false;
    }
	/*********************************************************************************************************************************************/

	/*********************************************************************************************************************************************/
    public int CreateAccessFile() {
 	    //creating text file to save user names + passwords 
 	    file = new File(AccessfileName);     //create the file.
 	   try {
 		   			
 		   	if (file.createNewFile())
			   {
 		   		System.out.println("Debug info:");
	         	System.out.println("* Access file created"); //means no access file existed before->software havn't been used yet->go to register flow
	         	Access.absolutePath = file.getAbsolutePath();
	        	//get file path + get file size  
	        	Path filePath = Paths.get(AccessfileName);
                fileChannel = FileChannel.open(filePath);
                fileSize = fileChannel.size();
                System.out.format("* Size: %d bytes", fileSize); //debug 
	         	System.out.println("* Path: "+ Access.absolutePath);
	         	System.out.println();
	     
	         	return 0;
			   }
			else {
				System.out.println("Debug info:");
				System.out.println("* Access file Exist"); //means no access file existed before->software havn't been used yet->go to register flow
	         	Access.absolutePath = file.getAbsolutePath();
	        	//get file path + get file size  
	        	Path filePath = Paths.get(AccessfileName);
                fileChannel = FileChannel.open(filePath);
                long fileSize = fileChannel.size();
                System.out.format("* Size: %d bytes", fileSize); //debug 
                System.out.println();
	         	System.out.println("* Path: "+ Access.absolutePath);
	         	System.out.println();
				return 1;
			}
		} 
 	   
 	   catch (IOException e) {
				e.printStackTrace();
		}
 	   return 1;
 	}
 	/*********************************************************************************************************************************************/
 	/*********************************************************************************************************************************************/
    public int CreateGuestFile() {
 	    //creating text file to save user names + passwords 
 	    file = new File(GuestfileName);     //create the file.
 	   try {
 		   			
 		   	if (file.createNewFile())
			   {
 		   		System.out.println("Debug info:");
	         	System.out.println("* Guest file created"); //means no access file existed before->software havn't been used yet->go to register flow
	         	Access.absolutePath = file.getAbsolutePath();
	        	//get file path + get file size  
	        	Path filePath = Paths.get(GuestfileName);
                fileChannel = FileChannel.open(filePath);
                fileSize = fileChannel.size();
                System.out.format("* Size: %d bytes", fileSize); //debug 
	         	System.out.println("* Path: "+ Access.absolutePath);
	         	System.out.println();
	     
	         	return 0;
			   }
			else {
				System.out.println("Debug info:");
				System.out.println("* Guest file Exist"); //means no access file existed before->software havn't been used yet->go to register flow
	         	Access.absolutePath = file.getAbsolutePath();
	        	//get file path + get file size  
	        	Path filePath = Paths.get(GuestfileName);
                fileChannel = FileChannel.open(filePath);
                long fileSize = fileChannel.size();
                System.out.format("* Size: %d bytes", fileSize); //debug 
                System.out.println();
	         	System.out.println("* Path: "+ Access.absolutePath);
	         	System.out.println();
				return 1;
			}
		} 
 	   
 	   catch (IOException e) {
				e.printStackTrace();
		}
 	   return 1;
 	}
 	/*********************************************************************************************************************************************/
 	/*********************************************************************************************************************************************/
    public int Register()
 	{
		ClearScreen();
 		int passValidation=0;
 		
 		System.out.println("REGISTER");
 		System.out.println();
 		//get Access user name
 		System.out.print("Please Enter Username: ");
 		userName = input.next();
 		
 		//get Access user password + validate password
 		for(int i=0 ; i<4 ; i++)
 		{
 			if (i==3) return 3;
 			System.out.print("Please Enter Password: ");
 			pass = input.next();
 			System.out.print("Verify Password: ");
 			String verifyPass = input.next();
 			if(pass.equalsIgnoreCase(verifyPass)) {
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
 		FileWriter writer;
		try {
			writer = new FileWriter (AccessfileName,true);
	 		writer.write(userName + "," + pass + ".");
	 		writer.write('\n');
	        //writer.append(this.userName + "," + this.pass + ".");
	 		writer.flush(); 
		} catch (IOException e) {
			System.out.println("Error writing to Access users file");
			e.printStackTrace();
		}


 		System.out.println();
 		System.out.println("User " + userName + " Registerd succesfully"  ); 		
 		return(1);
 	}
	/*********************************************************************************************************************************************/

	/*********************************************************************************************************************************************/	 
    public boolean foundUserInAccessFile(String user, String file)
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

	/**
	 * @throws InterruptedException *******************************************************************************************************************************************/
    public int Login() throws InterruptedException
 	{
		ClearScreen();
 		String loginUserName, loginPassword, userDetails;
 		
 		while(loggedIn == false) {
 			
 			System.out.println("LOGIN" + '\n');
 	 		System.out.println("Enter UserName: ");
 	 		loginUserName = input.next();
 	 		System.out.println("Enter Password: ");
 	 		loginPassword = input.next(); 
 	 		
 	 		userDetails = loginUserName + "," + loginPassword + ".";
 	 		
 	 		if(StringFinder(userDetails, Access.absolutePath))// need to find a way to parse the file to validate login details!
 	 				{
 	 					System.out.println();
 	 					System.out.println();
 	 					System.out.println("Logged in succesfully");
 	 					TimeUnit.SECONDS.sleep(2);
 	 					loggedIn = true;
 	 					return 1;
 	 				}
 	 		input.reset();
 	 		System.out.println();
 	 		System.out.println();
 	 		System.out.println("PASSWORD OR USERNAME DID NOT MATCH");
 	 		System.out.println();
 	 		System.out.println("TRY AGAIN - 1");
 	 		System.out.println("LEAVE - 0");
 	 		userChose = input.nextInt();
 	 		ClearScreen();
 	 		if(userChose == 0) {
 	 			ClearScreen();
 	 			System.out.println("USER DID NOT LOGGED IN - GOING BACK TO ACCESS MENU");
 	 			return 3;
 	 		}
 	 		else if(userChose == 1) continue;
 	 			
 	 		System.out.println("PLEASE CHOOSE ONLY 0 OR 1.");
 	 		break;
 		}
 		
		return 0;
 		
 	}
 	/*********************************************************************************************************************************************/
	public static void ClearScreen() {
 		for(int i=0 ; i < 100 ; i++) {
 			System.out.println();
 		}
 	}
	/*********************************************************************************************************************************************/
	public static Room getRoom(int numOfGuests) {
		
		Room room = new Room(numOfGuests);
		if(room.roomNumber < 100) 
			return room;
		return null;
	}
	/**
	 * @throws InterruptedException *******************************************************************************************************************************************/
	public static void CheckIn(SingletonReception control) throws InterruptedException {
		
		String guestString="-Guest:ID,name,age,sex,religious-";
		
		System.out.println("Please Enter number of guests to check in:");
		int thisNumOfGuests = input.nextInt();
		Room r = getRoom(thisNumOfGuests);
		
		if(r != null)
		{
			switch(thisNumOfGuests) {
			case 1:
				r.roomtype = "ONE_BEDRM";
				break;
			case 2:
				r.roomtype = "TWO_BEDRM";
				break;
			case 3:
				r.roomtype = "THREE_BEDRM";
				break;
			case 4:
				r.roomtype = "PENTHOUS";
				break;
			}		
		}
		else {
			System.out.println();
			System.out.println("Hotel is full");
			System.out.println();
			//deal with this situation
		}
		
		//create guests and save them to DB(file) using one manipulated string
		for(int i=0 ; i < thisNumOfGuests ; i++) {
			Guest g = createGuest();
			guestString = guestString.concat( GuesttoString(g) );
		}
		guestString = guestString.concat( RoomtoString(r) );
		
		FileWriter writer;
		try {
			writer = new FileWriter (GuestfileName,true);
	 		writer.write(guestString);
	 		writer.write('\n');
	 		writer.flush(); 
		} catch (IOException e) {
			System.out.println("Error writing room to Guest users file");
			e.printStackTrace();
		}
		
		TimeUnit.SECONDS.sleep(1);
		ClearScreen();
		System.out.println(thisNumOfGuests+" Guests Checked-In Successfully \nGoing back to Main Menu.");
		TimeUnit.SECONDS.sleep(4);
		ClearScreen();
		
	}
	
	/*********************************************************************************************************************************************/

	public void GuestReservation(SingletonReception control) 
		{

			

				boolean userWantToExit = false;
				String firstMenuChosen;
				do
				{
					firstMenuChosen = firstMenu();
					ClearScreen();
					switch (firstMenuChosen)
					{
						case "1":
							insertNewProduct();
							break;
						case "2":
							showListOfProductsByType();
							break;
						case "3":
							changeAmountOfProduct();
							break;
						case "4":
							showCompleteDataOfProduct();
							break;

						case "8":
							userWantToExit = true;
							break;
					}
				} while (userWantToExit == false);
			}


			private void showCompleteDataOfProduct()
			{
				int catalogNumber;
				catalogNumber = askFromeUserCatalogNum();
				if (productsCollection.IsProductExist(catalogNumber))
				{
					System.out.printf("{0} - full  details:" + "\r\n", catalogNumber);
					System.out.println(productsCollection.ShowProductDetails(catalogNumber));
				}
				else
				{
					System.out.println("There is no such product...");
				}
			}

			public void changeAmountOfProduct()
			{
				int catalogNum;
				catalogNum = askFromeUserCatalogNum();
				if (productsCollection.IsProductExist(catalogNum))
				{
					try
					{
						int amountToAdd = askFromUserToChooseAndCheckHim("What the amount you want to add?", 1, Integer.MAX_VALUE);
						productsCollection.changeAmount(productsCollection.GetProduct(catalogNum).getProductQuantity() + amountToAdd, catalogNum);
						System.out.printf("product - {0}, amount was changed to {1}." + "\r\n", catalogNum, productsCollection.GetProduct(catalogNum).getProductQuantity());
					}
					catch (IllegalArgumentException ex)
					{
						System.out.println(ex.getMessage());
					}
				}
				else
				{
					System.out.println("There is no such product...");
				}
			}

			public void showListOfProductsByType()
			{
				ArrayList<Product> cooshenTypeProduct;
				eProductType enumSelectedCondition;
				enumSelectedCondition = askFromeUserProductType();
				cooshenTypeProduct = productsCollection.GetListOfProducts(enumSelectedCondition);
				System.out.printf("List of "+ enumSelectedCondition.toString() +"\r\n", enumSelectedCondition);

				for (Product product : cooshenTypeProduct)
				{
					//can also add catalog number and minimum amount..
					System.out.println(product.getProductName() + " , currently amount - " + product.getProductQuantity());
				}
			}

			private eProductType askFromeUserProductType()
			{
				eProductType productType;
				productType =  eProductType.valueOf(enumAskAndUserSelection(eProductType.class, "What is the product type?") );
				return productType;
			}

			private void insertNewProduct()
			{
				//eProductType enumProductType;
				int productCatalogNum;
				eProductType productType;
				Product product;
				try
				{
					//need to do check for user input
					productCatalogNum = (int)askFromeUserCatalogNum();
					if (productsCollection.IsProductExist(productCatalogNum))
					{
						System.out.println("This product is already exist.");
					}
					else
					{
						//get from user type of product to insert
						productType = eProductType.valueOf( enumAskAndUserSelection(eProductType.class, "What kind of product ? "));  
						productsCollection.InsertNewProductModel(productType, productCatalogNum);
						product = productsCollection.GetProduct(productCatalogNum);
						askForUniqueProperties(product);
						System.out.println("Product has been added successfully!");
					}
				}
				catch (RuntimeException ex)
				{
					System.out.println(ex.getMessage());
				}
			}
			private <E extends Enum<E>> int enumAskAndUserSelection (Class<E> enumType, String stringToPrint)
			{
		        int i;
		        System.out.println(stringToPrint);
		        i = 1;
		        for (E en : EnumSet.allOf(enumType))
		        {
		        	System.out.println(i + "{0}. {1}" + en);
		            i++;
		        }

		        return askFromUserToChooseAndCheckHim(1, enumType.getEnumConstants().length);
			}

			private void askForUniqueProperties(Product product)
			{
				boolean goodInput;
				int indexToSet = 1;
				String userInput;
				java.lang.Iterable<String> productProperties = product.GetProductProperties();

				for (String uniqueFeature : productProperties)
				{
					do
					{
						System.out.printf("{0}" + "\r\n", uniqueFeature);
						userInput = new Scanner(System.in).nextLine();
						goodInput = product.SetProductProperties(userInput, indexToSet);
						if (goodInput)
						{
							indexToSet++;
						}
						else
						{
							System.out.println("Bad input, try again...");
						}
					} while (!goodInput);
				}
			}

			private static int askFromeUserCatalogNum()
			 {
						System.out.println("Please enter product catalog number:");
						// need to check user input(check if int - you can use tryParse)
						return Integer.parseInt(new Scanner(System.in).nextLine());
			 }

			private  String firstMenu()
				{
						String firstMenu = "Dear User, Which of the following operations would you like to make?" + "\r\n" + 
			"\r\n" + 
			"1. Insert a new product" + "\r\n" + 
			"\r\n" + 
			"2. Show list of products by type" + "\r\n" + 
			"\r\n" + 
			"3. Add the amount of a product" + "\r\n" + 
			"\r\n" + 
			"4. Show complete data of product" + "\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"8. Exit";
						return String.valueOf(askFromUserToChooseAndCheckHim(firstMenu, 1, 8));
					}

					private int askFromUserToChooseAndCheckHim(String i_StringToPrint, int i_From, int i_To)
					{
						boolean validTryParse;
						int intMenuChosen;
						String stringMenuChosen;
						boolean validInput = true;

						do
						{
							System.out.println(i_StringToPrint);
							if (validInput == false)
							{
								System.out.printf("wrong...please choose again ({0}-{1})" + "\r\n", i_From, i_To);
							}

							stringMenuChosen = new Scanner(System.in).nextLine();
							tangible.OutObject<Integer> tempOut_intMenuChosen = new tangible.OutObject<Integer>();
							validTryParse = tangible.TryParseHelper.tryParseInt(stringMenuChosen, tempOut_intMenuChosen);
							intMenuChosen = tempOut_intMenuChosen.outArgValue;
							if (intMenuChosen <= i_To && intMenuChosen >= i_From && validTryParse)
							{
								validInput = true;
							}
							else
							{
								validInput = false;
							}
						} while (!validInput);

						return intMenuChosen;
					}

					private int askFromUserToChooseAndCheckHim(int i_From, int i_To)
					{
						boolean validTryParse;
						int intMenuChosen;
						String stringMenuChosen;
						boolean validInput = true;
						do
						{
							if (validInput == false)
							{
								System.out.printf("wrong...please choose again ({0}-{1})" + "\r\n", i_From, i_To);
							}

							stringMenuChosen = new Scanner(System.in).nextLine();
							//tangible.OutObject<Integer> tempOut_intMenuChosen = new tangible.OutObject<Integer>();
							//validTryParse = tangible.TryParseHelper.tryParseInt(stringMenuChosen, tempOut_intMenuChosen);
							try {
								intMenuChosen = Integer.parseInt(stringMenuChosen);
							}
							catch (NumberFormatException e)
							{
							   intMenuChosen = -1;
							}
							if (intMenuChosen != -1 && intMenuChosen <= i_To && intMenuChosen >= i_From)
							{
								validInput = true;
							}
							else
							{
								validInput = false;
							}
						} while (!validInput);

						return intMenuChosen;
					}


	/*********************************************************************************************************************************************/
	   public static Guest createGuest() {
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
	/*********************************************************************************************************************************************/
	/*********************************************************************************************************************************************/
	 public static String GuesttoString(Guest g){//overriding toString() method  
		  String parsedGuest =  g.UID+","+g.Name+","+g.Age+","+g.Sex+","+g.Religious+",";  
		  return parsedGuest;
		 }  
	/*********************************************************************************************************************************************/
	 public static String RoomtoString(Room r){//overriding toString() method  
		  String parsedRoom =  "Room:roomNumber,roomtype-"+r.roomNumber+","+r.roomtype+".";  
		  return parsedRoom;
		 }  
}
