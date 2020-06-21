import java.util.*;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.LinkedList;

public class My_Main {

	public static void main(String[] args) {
		
		
		
		ProductsLinkedList AdminisLinkList = new ProductsLinkedList();
		
		AdminisLinkList.insertFirstLink("soap",1,100,50);
		AdminisLinkList.insertFirstLink("shampoo", 1, 70, 20);
		AdminisLinkList.insertFirstLink("sheets",1,30,0);
		
		AdminisLinkList.adminisRemoveFirst();
		
		AdminisLinkList.adminisDisplay();
		
		AdminisLinkList.adminisNodeFind("soap");
		
		AdminisLinkList.removeAdminisLink("soap");
		System.out.println("***");
		AdminisLinkList.adminisDisplay();
		
		/*
		ProductsLinkedList foodLinkedList =new ProductsLinkedList();
		
		foodLinkedList.insertFirstLink("bamba" , 20 , 10 , 1 , "21/4/23" , true , false  );
		foodLinkedList.insertFirstLink("bread" , 50 , 4 , 1 , "2/2/23" , true , true  );
		foodLinkedList.insertFirstLink("milk" , 40 , 20 , 1 , "2/4/21" , false , false  );
		
		foodLinkedList.foodDisplay();
		/*
		foodLinkedList.foodRemoveFirst();
		System.out.println("\n\n");
		foodLinkedList.foodDisplay();
		*/
		//foodLinkedList.foodNodeFind("bread");
		
		/*
		System.out.println("\n\n\n:)\n");
		foodLinkedList.removeFoodLink("bamba");
		foodLinkedList.foodDisplay();
		
		System.out.println("\n\n ***********************************************************************************");
		*/
		
		
	/*	
		ProductsLinkedList medicalList =new ProductsLinkedList();
	
		medicalList.insertFirstLink("gloves", 50,40 , 1 ,"31/5/22");
		//medicalList.insertFirstLink("senitizer", 60 ,2 ,"4/3/21");
		//medicalList.insertFirstLink("pills", 500 , 3 ,"3/5/25");
		
		medicalList.display();
		
	    System.out.println("\n\n\n*************");
 
	    medicalList.removeFirst();
	    
	    medicalList.display();
		
	    medicalList.find("senitizer");
		
		
		
		*/
		
		
		
		
		
		
		//רשימה מקושרת לפי import
		/*
		medical_examp current;

		medical_examp medicalProduct = new medical_examp(null, 0, null );
		
		LinkedList <medical_examp> medicalList = new LinkedList <>();
		
		medicalList.add(new medical_examp ("gloves",30, "31.5.22" ));
		medicalList.add(new medical_examp ("alcogel",100, "1.6.22" ));
		medicalList.add(new medical_examp ("pills",90, "23.2.24" ));
		
		System.out.println(medicalList );
		
		medicalList.removeFirst();
		
	   // current=medicalList.head;
		*/
		
		
		
	/*
		medical_examp medicalList = new medical_examp();
		
		medicalList.insertFirstLink("gloves" , 20  ,"4/4/25");
		
		medicalList.display();
		
		*/
	
		
		
		
		
		
		
		
		
		
		/*
	
		LinkList theLinkList =new LinkList();
		
		theLinkList.insertFirstLink(" batchen ", 500);
		theLinkList.insertFirstLink(" assaf ", 200);
		theLinkList.insertFirstLink(" adi", 150);
		theLinkList.insertFirstLink(" ortal ", 20);
		
		theLinkList.display();
		
		System.out.println(theLinkList.find ("i lobe my bamba").bookName + "was found");
		
		
		theLinkList.removeFirst();
		
		theLinkList.display();
		 
		System.out.println("\n");
		
		System.out.println(theLinkList.find(" assaf ").bookName + "was found");
		
		
		theLinkList.removeLink(" adi");
		
		theLinkList.display();
		
		
		theLinkList.removeLink(" adi");
		
		theLinkList.display();
		

		
		// LinkedList<Medical> medicalList = new LinkedList<Medical>();
		
		*/
		
		
		
		
		
		
		
		
	
		
		
  }
}
