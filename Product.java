import java.util.Random;

public class Product {

	protected String productName ;	
	protected int productCatalogNum;
	protected int productQuantity;
	protected int minimumQuantity;
	
	public Product firstLink;
	
	
	Random r = new Random();//קריאה למספר רמנדומלי 

	public Product(String productName,int productQuantity,int minimumQuantity) {
		super();
		this.productName = productName;
		//this.productCatalogNum = productCatalogNum;
		this.productQuantity = productQuantity;
		this.minimumQuantity = minimumQuantity;
		//firstLink = null;
	
		getRandomCtalogNUM();
		
	}

	
	/********GETTERS & SETTERS**********/
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public int getprodutCatalogNum() {
		return productCatalogNum;
	}
	/***********************************/
	
	
	//פונקציה שנותת מספר ראנדומלי למק"ט המוצר
	protected int getRandomCtalogNUM() {
		productCatalogNum=r.nextInt(999)+999;	
		return productCatalogNum;
	}
	
/***********************************************************************************/
	
	


	
	

}
