import java.io.IOException;

public class SingletonReception {

 static SingletonReception mySingleton;
 static boolean restart = false;

 private SingletonReception() {}

 public static SingletonReception getMySingleton() {
  if (mySingleton == null)
   mySingleton = new SingletonReception();
  return mySingleton;
 }

 public void Controller(SingletonReception control) throws InterruptedException, IOException {
  Model.ClearScreen();
  Model.getVars(); //get last checked in room-number from Variables file to continue check-in operations from the last room number 


  restart = false;

  while (true) {
   int action = 0;

   System.out.println("Debug info:  * Controller took control of the system * ");
   System.out.println();
   System.out.println();

   while (action > 0 || action < 5) {
    System.out.println("\nEnter your choice :\n1.Check-In \n2.Check-Out \n3.Order to room\n4.Exit\n");
    action = Model.input.nextInt();

    switch (action) // associate user actions to the right flow when logged in to the system
    {
     case 1:
      Model.CheckIn(control);
      break;
     case 2:
      Model.CheckOut(control);
      break;
     case 3:
      break;
     case 4:
      Model.Restart(control);
      break;

    }
    if (restart) break;
   }
   if (restart) break;

  }

 }
}