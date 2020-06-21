import java.util.Random;

public class Medical extends Product {


	private String expirationDate;
		
	public Medical next;
	
	public Medical firstLink;
	
	

	
	
	public Medical(String productName, int productQuantity,int minimumQuantity ,String expirationDate) {
		super(productName, productQuantity ,minimumQuantity);
		this.expirationDate = expirationDate;
		getRandomCtalogNUM();
		firstLink = null;
		
	}




	
	


	/*********************************** methods ******************************************/
	
	
	public void printObject() {
		System.out.println(productName + ": quantity = " + productQuantity 
				+"  ,minimum quantity = "+minimumQuantity +" ,catalog number :"
				+ productCatalogNum + ", expiration Date :" + expirationDate);
	}
	
	
	
	
		
		
		
}
