
public class Food extends Product{

	private String expirationDate;
	private boolean kosherLmehadrin;
	private boolean vegetarian;
	
	public Food secondLink;
	public Food next;
	
	
	public Food(String productName, int productQuantity,int minimumQuantity ,String expirationDate,
			boolean kosherLmehadrin ,boolean vegetarian ){

		super(productName, productQuantity ,minimumQuantity);
		// TODO Auto-generated constructor stub
		
		this.expirationDate = expirationDate;
		this.kosherLmehadrin = kosherLmehadrin;
		this.vegetarian = vegetarian;
		this.minimumQuantity = minimumQuantity;
		getRandomCtalogNUM();
		
		secondLink=null;
		
	}


	//שיטות 
	
	public void printFoodObject()  {
		System.out.println(productName + " : quantity=" + productQuantity + " ,minimum quantity :"+minimumQuantity +" , catalog number: "
				+ productCatalogNum + " , expiration Date :" + expirationDate + " , is kosher Lemehadrin: " +kosherLmehadrin
				+ " , is vegetarian :" +vegetarian);
	}

}
