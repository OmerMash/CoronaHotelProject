import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;


public class Model {


 public Model() {}
 public static Scanner input = new Scanner(System.in);

 //Variables
 protected static int userCount = 1;
 protected static int numOfGuestsToCheckIn;
 protected String userName;
 protected String userID = "User" + userCount;
 protected String pass = "000";
 String AccessfileName = ("RESEPTION_ACCESS.txt");
 static String varFileName = "varFile.txt";
 static String GuestfileName = ("Guest.txt");
 static boolean existAccessFile = false;
 String append_value;
 boolean loggedIn = false;
 static File AccessFile;
 static File GuestFile;
 static File VarFile;
 static FileChannel fileChannel;
 static long fileSize;
 static int userChose;
 static SingletonReception mySingleton;


 /*********************************************************************************************************************************************/
 public int userDecision() {
  ClearScreen();
  Access.accessDecision = 0;
  while (Access.accessDecision != 1 && Access.accessDecision != 2) {
   //go to login scenario
   System.out.println();
   System.out.println("MENU");
   System.out.println("CHOOSE ACTION:");
   System.out.println();
   System.out.println();
   System.out.println("Login - 1");
   System.out.println("Register - 2");
   Access.accessDecision = input.nextInt();
   if (Access.accessDecision != 1 && Access.accessDecision != 2)
    System.out.println("------> PLEASE CHOOSE ONLY 1 OR 2.");
  }
  return Access.accessDecision;
 }
 /*********************************************************************************************************************************************/
 public void AbsoluteFilePath(File thisFile) {
  String absolutePath = thisFile.getAbsolutePath();
  System.out.println("File path : " + absolutePath);
  String filePath = absolutePath.substring(0, absolutePath.lastIndexOf(File.separator));
  System.out.println("File path : " + filePath);
 }
 /*********************************************************************************************************************************************/
 public boolean StringFinder(String user, String path) {
  {
   BufferedReader br;
   String Thisline = "";

   try {

    br = new BufferedReader(new FileReader(path));

    try {
     while ((Thisline = br.readLine()) != null) {
      if (Thisline.equals(user)) {
       br.close();
       return true;
      }
     }
     br.close();
     return false;

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
  AccessFile = new File(AccessfileName); //create the file.
  try {

   if (AccessFile.createNewFile()) {
    System.out.println("Debug info:");
    System.out.println("* Access file created"); //means no access file existed before->software havn't been used yet->go to register flow
    Access.absolutePath = AccessFile.getAbsolutePath();
    //get file path + get file size  
    Path filePath = Paths.get(AccessfileName);
    fileChannel = FileChannel.open(filePath);
    fileSize = fileChannel.size();
    System.out.format("* Size: %d bytes", fileSize); //debug 
    System.out.println("* Path: " + Access.absolutePath);
    System.out.println();

    return 0;
   } else {
    System.out.println("Debug info:");
    System.out.println("* Access file Exist"); //means no access file existed before->software havn't been used yet->go to register flow
    Access.absolutePath = AccessFile.getAbsolutePath();
    //get file path + get file size  
    Path filePath = Paths.get(AccessfileName);
    fileChannel = FileChannel.open(filePath);
    long fileSize = fileChannel.size();
    System.out.format("* Size: %d bytes", fileSize); //debug 
    System.out.println();
    System.out.println("* Path: " + Access.absolutePath);
    System.out.println();
    return 1;
   }
  } catch (IOException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
  return 1;
 }
 /*********************************************************************************************************************************************/
 public int CreateGuestFile() {
  //creating text file to save guests by room.
  GuestFile = new File(GuestfileName); //create the file.
  try {

   if (GuestFile.createNewFile()) {
    System.out.println("Debug info:");
    System.out.println("* Guest file created"); 
    Access.absolutePath = GuestFile.getAbsolutePath();
    //get file path + get file size  
    Path filePath = Paths.get(GuestfileName);
    fileChannel = FileChannel.open(filePath);
    fileSize = fileChannel.size();
    System.out.format("* Size: %d bytes", fileSize); //debug 
    System.out.println("* Path: " + Access.absolutePath);
    System.out.println();

    return 0;
   } else {
    System.out.println("Debug info:");
    System.out.println("* Guest file Exist"); 
    Access.absolutePath = GuestFile.getAbsolutePath();
    //get file path + get file size  
    Path filePath = Paths.get(GuestfileName);
    fileChannel = FileChannel.open(filePath);
    long fileSize = fileChannel.size();
    System.out.format("* Size: %d bytes", fileSize); //debug 
    System.out.println();
    System.out.println("* Path: " + Access.absolutePath);
    System.out.println();
    return 1;
   }
  } catch (IOException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
  return 1;
 }
 /**
 * @throws InterruptedException *******************************************************************************************************************************************/
 public int Register() throws InterruptedException {
  ClearScreen();
  int passValidation = 0;

  System.out.println("REGISTER");
  System.out.println();
  //get Access user name
  System.out.print("Please Enter Username: ");
  userName = input.next();

  //get Access user password + validate password
  for (int i = 0; i < 4; i++) {
   if (i == 3) return 3;
   System.out.print("Please Enter Password: ");
   pass = input.next();
   System.out.print("Verify Password: ");
   String verifyPass = input.next();
   if (pass.equalsIgnoreCase(verifyPass)) {
    passValidation = 1;
    break;
   } else {
	ClearScreen();
    System.out.println();
    System.out.println();
    System.out.println("Passwords does not match");
    System.out.println();
    System.out.println();
    continue;
   }
  }
  FileWriter writer;
  try {
   writer = new FileWriter(AccessfileName, true);
   writer.write(userName + "," + pass + ".");
   writer.write('\n');
   writer.flush();
  } catch (IOException e) {
   System.out.println("Error writing to Access users file");
   e.printStackTrace();
  }

  System.out.println();
  System.out.println("User " + userName + " Registerd succesfully");
  TimeUnit.SECONDS.sleep(2);
  ClearScreen();
  return (1);
 }
 /*********************************************************************************************************************************************/
 public boolean foundUserInAccessFile(String user, String file) {
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
 public int Login() throws InterruptedException {
  ClearScreen();
  String loginUserName, loginPassword, userDetails;

  while (loggedIn == false) {

   System.out.println("LOGIN" + '\n');
   System.out.println("Enter UserName: ");
   loginUserName = input.next();
   System.out.println("Enter Password: ");
   loginPassword = input.next();

   userDetails = loginUserName + "," + loginPassword + ".";

   if (StringFinder(userDetails, Access.absolutePath)) {
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
   if (userChose == 0) {
    ClearScreen();
    System.out.println("USER DID NOT LOGGED IN - GOING BACK TO ACCESS MENU");
    return 3;
   } else if (userChose == 1) continue;

   System.out.println("PLEASE CHOOSE ONLY 0 OR 1.");
   break;
  }

  return 0;

 }
 /*********************************************************************************************************************************************/
 public static void ClearScreen() {
  for (int i = 0; i < 100; i++) {
   System.out.println();
  }
 }
 /**
  * @throws IOException *******************************************************************************************************************************************/
 public static Room getRoom(int numOfGuests) throws IOException {

  Room room = new Room(numOfGuests);

  FileWriter writer;
  try {
   writer = new FileWriter(varFileName);
   writer.write("roomNumber-" + Room.roomNumber);
   writer.write('\n');
   writer.flush();
  } catch (IOException e) {
   System.out.println("Error writing roomNumber to varFile.txt");
   e.printStackTrace();
  }

  if (Room.roomNumber < 100)
   return room;
  System.out.println("Hotel Capacity is full - no available rooms.");
  return null;
 }
 /**
  * @throws IOException *******************************************************************************************************************************************/
 public static void getVars() throws IOException {

  VarFile = new File(varFileName);
  try {

   VarFile.createNewFile();


   FileWriter writer;
   Room.roomNumber = getRoomNumberFromVarFile();
   try {
    writer = new FileWriter(varFileName);
    writer.write("RoomNumber" + Room.roomNumber); //update VarFile
    writer.write('\n');
    writer.flush();
   } catch (IOException e) {
    System.out.println("Error writing room to Guest users file");
    e.printStackTrace();
   }
  } catch (IOException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
 }

 /**
  * @throws FileNotFoundException *******************************************************************************************************************************************/
 public static int getRoomNumberFromVarFile() throws FileNotFoundException {
  int num = 0, i, intFromline, numericValue;

  String line;
  Scanner scanner = new Scanner(VarFile);


  while (scanner.hasNextLine()) {


   line = scanner.nextLine();
   i = line.length();

   while (i > 0 && Character.isDigit(line.charAt(i - 1))) {

    intFromline = line.charAt(i - 1);
    numericValue = Character.getNumericValue(intFromline);
    num += numericValue;
    i--;

   }


  }
  scanner.close();

  return num;
 }
 /*********************************************************************************************************************************************/
 /**
  * @throws InterruptedException 
  * @throws IOException *******************************************************************************************************************************************/
 public static void CheckIn(SingletonReception control) throws InterruptedException, IOException {

  ClearScreen();
  int thisNumOfGuests = -1;

  System.out.println("Check-In \n\n");
  while (thisNumOfGuests <= 0 || thisNumOfGuests > 5) {
   System.out.println("Please Choose number of guests to check in: 1 / 2 / 3 / 4");
   thisNumOfGuests = input.nextInt();
   if (thisNumOfGuests <= 0 || thisNumOfGuests > 5) {
    System.out.println("Please Choose 1 / 2 / 3 / 4 only.");
    TimeUnit.SECONDS.sleep(2);
    ClearScreen();
   }

  }

  String guestString = "-Guest:ID,name,age,sex,religious-";

  Room r = getRoom(thisNumOfGuests);

  if (r != null) {
   switch (thisNumOfGuests) {
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
  } else {
   System.out.println();
   System.out.println("Hotel is full");
   System.out.println();
   //deal with this situation
  }

  //create guests and save them to file using one manipulated string
  for (int i = 0; i < thisNumOfGuests; i++) {
   Guest g = createGuest();
   guestString = guestString.concat(GuesttoString(g));
  }
  guestString = guestString.concat(RoomtoString(r));

  FileWriter writer;
  try {
   writer = new FileWriter(GuestfileName, true);
   writer.write(guestString);
   writer.write('\n');
   writer.flush();
  } catch (IOException e) {
   System.out.println("Error writing room to Guest users file");
   e.printStackTrace();
  }

  TimeUnit.SECONDS.sleep(1);
  ClearScreen();
  System.out.println(thisNumOfGuests + " Guests Checked-In Successfully\nRoom-number: " + Room.roomNumber + "\n\nGoing back to Main Menu.");
  TimeUnit.SECONDS.sleep(4);
  ClearScreen();

 }
 /**
  * @throws IOException 
  * @throws InterruptedException *******************************************************************************************************************************************/
 public static void CheckOut(SingletonReception control) throws IOException, InterruptedException {

  ClearScreen();
  System.out.println("Check-Out \n\n");

  String roomtoCheckout;
  String line;
  String manipulatedString;
  String manipulatedStringValidation;
  String currentLine;
  File tempFile = new File("myTempFile.txt");
  File Gfile = new File(GuestfileName);
  boolean found = false;

  BufferedReader reader = new BufferedReader(new FileReader(GuestfileName));
  BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));


  System.out.print("Please Enter Room-number to Chck-Out: ");
  roomtoCheckout = input.next();
  manipulatedString = "roomtype-" + roomtoCheckout + ",";
  manipulatedStringValidation = manipulatedString;

  while ((currentLine = reader.readLine()) != null) { //while not reached EOF
   if (currentLine.matches("(.*)" + manipulatedString + "(.*)")) {
    line = currentLine;
    found = true; 									//announce room is found
    continue; 										//skip this line (don't copy line to tmp file)
   }
   
   writer.write(currentLine + System.getProperty("line.separator"));
   writer.flush();
  }
  writer.close();
  reader.close();

  boolean successful = tempFile.renameTo(Gfile);

  TimeUnit.SECONDS.sleep(1);
  ClearScreen();
  if (found) { 									//if announced room was found
   System.out.println("Room number " + roomtoCheckout + " Checked-out Successfully ");
   System.out.println("\n***Contacted Ministry of Health and the request for release was approved");
   System.out.println("\nGoing back to Main Menu.");
  } else { 											//else->room was not found in file
   System.out.println("No room Checked-Out: Room number " + roomtoCheckout + " is currently empty and under disinfection process ");
   System.out.println("\nGoing back to Main Menu.");
  }
  TimeUnit.SECONDS.sleep(4);
  ClearScreen();

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

  while (guest.Sex != 1 && guest.Sex != 2) {
   System.out.println("Guest Sex: 1-male, 2-female ");
   guest.Sex = input.nextInt();
   if (guest.Sex != 1 && guest.Sex != 2) {
    System.out.println("Please Choose 1 or 2 only.");
    System.out.println();
   }
  }
  while (guest.Age <= 0 || guest.Age > 120) {
   System.out.println("Guest Age:");
   guest.Age = input.nextInt();
   if (guest.Age <= 0 || guest.Age > 120) {
    System.out.println("Please enter valid age only.");
    System.out.println();
   }
  }
  while (guest.Religious != 1 && guest.Religious != 2) {
   System.out.println("Religious?:  1-Yes, 2-No ");
   guest.Religious = input.nextInt();
   if (guest.Religious != 1 && guest.Religious != 2) {
    System.out.println("Please Choose 1 or 2 only.");
    System.out.println();
   }
  }
  return guest;
 }
 /*********************************************************************************************************************************************/
 public static String GuesttoString(Guest g) {  
  String parsedGuest = g.UID + "," + g.Name + "," + g.Age + "," + g.Sex + "," + g.Religious + ",";
  return parsedGuest;
 }
 /*********************************************************************************************************************************************/
 public static String RoomtoString(Room r) { //overriding toString() method  
  String parsedRoom = "Room:roomNumber,roomtype-" + Room.roomNumber + "," + r.roomtype + ".";
  return parsedRoom;
 }
 /**
  * @throws InterruptedException *******************************************************************************************************************************************/
 public static void Restart(SingletonReception S) throws InterruptedException {
  ClearScreen();
  System.out.println("Thanks for using Corona Hotel Management System.\nsee you soon!\n\nLogging Out.....");
  TimeUnit.SECONDS.sleep(3);
  SingletonReception.restart = true;
  Access.userLoggedIn=0;
 }






}