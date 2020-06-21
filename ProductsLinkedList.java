
public class ProductsLinkedList {

	public Medical firstLink;
	public Food secondLink;
	public Administration thirdLink;

	public ProductsLinkedList() {
		
		firstLink = null;
		secondLink=null;
		thirdLink=null;
	}
	
	/**********************************MEDICAL********************************************/
	//בדיקה אם האיבר הראשון ריק
		public boolean isEmpty(){
			
			return (firstLink==null);
		}
		
		
		//(insert node)linked list for medical 
		public void insertFirstLink (String productName, int productCatalogNum,int productQuantity,int minimumQuantity ,String expirationDate) {
			 
			Medical newLink = new Medical (productName,productCatalogNum,minimumQuantity,expirationDate);
			
			newLink.next = firstLink;
			
			firstLink = newLink;
		}
	
		
		//print medical list
		public void display () {
			
			Medical theLink = firstLink;
			
			while (theLink != null) {

				theLink.printObject();
				System.out.println("Next Link :" + theLink.next);
				theLink = theLink.next;
				System.out.println();
			}				
		}
	 
		
		// remove first node
		public Medical removeFirst() {
			Medical linkReferance = firstLink;
			if(!isEmpty()) {
				firstLink=firstLink.next;
				
				
			}else {
				
				System.out.println("empty linked list");
			}
			
			return linkReferance;
		}
		
		//find specific node by name
		public Medical find(String productName) {
			
			Medical theLink=firstLink;
			if(!isEmpty()) {
				while(theLink.productName != productName) {
					
					if(theLink.next==null) {
						return null;
					}else {
						theLink=theLink.next;
						
				}
			}
		}else {
			System.out.println("empty linked list");
		}
			return theLink;
			
   }
		
		//remove node 
		public Medical removeLink(String productName) {
			Medical currentLink = firstLink;
			Medical previousLink = firstLink;
			
			while(currentLink.productName != productName) {
				
				if(currentLink.next == null) {
					return null;
				}else {
					
					previousLink = currentLink;
					currentLink = currentLink.next;
				}
				
			}
			
			if (currentLink == firstLink) {
				firstLink = firstLink.next;
			}else {
				previousLink.next = currentLink.next;
			}
			
			
			
			return firstLink;
		}
		
		/*****************************FOOD*************************************/
		//בדיקה אם האיבר הראשון ריק
				public boolean FoodisEmpty(){
					
					return (secondLink==null);
				}
				
				
				//(insert node)linked list for food 
				public void insertFirstLink (String productName,int productCatalogNum ,int productQuantity, int minimumQuantity ,String expirationDate,
						boolean kosherLmehadrin ,boolean vegetarian) {
					 
					Food newLink = new Food ( productName,  productQuantity, minimumQuantity , expirationDate,
							 kosherLmehadrin , vegetarian);
					
					newLink.next = secondLink;
					
					secondLink = newLink;
				}
		
	//print food list
	public void foodDisplay() {
					
		Food theLink = secondLink;
					
		while (theLink != null) {

			theLink.printFoodObject();
			System.out.println("Next Link :" + theLink.next);
			theLink = theLink.next;
			System.out.println();
			}
	
		}
				
		// remove first node
		public Food foodRemoveFirst() {
		Food linkReferance = secondLink;
		if(!FoodisEmpty()) {
			secondLink=secondLink.next;
						
						
			}else {
					
			System.out.println("empty linked list");
		}
					
		return linkReferance;
	}
				
				
	//find specific node by name in food list
   public Food foodNodeFind(String productName) {
					
	Food theLink=secondLink;
	if(!FoodisEmpty()) {
	while(theLink.productName != productName) {
							
		if(theLink.next==null) {
				return null;
				}else {
					theLink=theLink.next;
								
				}
				}
			}else {
			System.out.println("empty linked list");
			}
			return theLink;
					
		 }
				
				
	//remove node 
		public Food removeFoodLink(String productName) {
			Food currentLink = secondLink;
			Food previousLink = secondLink;
					
		while(currentLink.productName != productName) {
						
 		if(currentLink.next == null) {
				return null;
		}else {
							
				previousLink = currentLink;
				currentLink = currentLink.next;
				}
						
		}
					
		if (currentLink == secondLink) {
			secondLink = secondLink.next;
			}else {
						previousLink.next = currentLink.next;
				}
					
				
			return secondLink;
		}
			
		
/***********************ADMINISTTRATION ******************************/
		
	
		//בדיקה אם האיבר הראשון ריק
		public boolean adminisIsEmpty(){
			
			return (thirdLink==null);
		}
		
		
		//(insert node)linked list for food 
		public void insertFirstLink (String productName,int productCatalogNum ,int productQuantity, int minimumQuantity) {
			 
			Administration newLink = new Administration ( productName,  productQuantity, minimumQuantity );
			
			newLink.next = thirdLink;
			
			thirdLink = newLink;
		}
		
		//print administration list list
		public void adminisDisplay() {
						
			Administration theLink = thirdLink;
						
			while (theLink != null) {

				theLink.printAdminisObject();
				System.out.println("Next Link :" + theLink.next);
				theLink = theLink.next;
				System.out.println();
				}
		}
		
		
		// remove first node
		public Administration adminisRemoveFirst() {
			Administration linkReferance = thirdLink;
		if(!adminisIsEmpty()) {
			thirdLink=thirdLink.next;
						
						
			}else {
					
			System.out.println("empty linked list");
		}
					
		return linkReferance;
	}
	
		
		//find specific node by name in administration list
		   public Administration adminisNodeFind(String productName) {
							
			   Administration theLink=thirdLink;
			if(!adminisIsEmpty()) {
			while(theLink.productName != productName) {
									
				if(theLink.next==null) {
						return null;
						}else {
							theLink=theLink.next;
										
						}
						}
					}else {
					System.out.println("empty linked list");
					}
					return theLink;
							
				 }
					
		
			//remove node 
			public Administration removeAdminisLink(String productName) {
				Administration currentLink = thirdLink;
				Administration previousLink = thirdLink;
						
			while(currentLink.productName != productName) {
							
	 		if(currentLink.next == null) {
					return null;
			}else {
								
					previousLink = currentLink;
					currentLink = currentLink.next;
					}
							
			}
						
			if (currentLink == thirdLink) {
				thirdLink = thirdLink.next;
				}else {
							previousLink.next = currentLink.next;
					}
						
					
				return thirdLink;
			}
				
		   
		   
}