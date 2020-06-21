
public class Administration extends Product{

	public Administration next;
	public Administration thirdLink;
	
	public Administration(String productName, int productQuantity,int minimumQuantity) {
		super(productName, productQuantity ,minimumQuantity);
		getRandomCtalogNUM();
		thirdLink=null;
	}
	

	void printAdminisObject() {
		
		System.out.println("name :" +productName+ " , quantity=" +productQuantity+ " , minimum quantity=" +minimumQuantity
				+ " , catalog number : " +productCatalogNum);
	}


}
