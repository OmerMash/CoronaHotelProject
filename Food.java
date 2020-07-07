package hit.co.il;
import java.util.*; 

public class Food extends Product
{

	private String expirationDate; //בת חן הייתי ממליץ לך להשתמש במחלקה שיודעת לבצע מניפולציות על תאריך (Date)
	private String kosherType;
	private String dietType;

	public Food(int productCatalogNum)
	{
		super(productCatalogNum);

	}

	public final void printFoodObject()
	{
		super.PrintProduct();
		System.out.println(" , expiration Date :" + expirationDate + " , kosher type: " + kosherType + " , diet type :" + dietType);
	}

	public String toString()
	{
		return super.toString() + " , expiration Date :" + expirationDate + " , kosher type : " + kosherType + " , diet type :" + dietType;
	}
	
	public java.lang.Iterable<String> GetProductProperties()
	{
		ArrayList<String> productProperties = super.GetProductProperties().ToList();

		productProperties.add(("What is the food product expirationDate?"));
		productProperties.add(("What is the food product kosher type?"));
		productProperties.add(("What is the food product expirationDate?"));

		return productProperties;
	}

	public boolean SetProductProperties(String userInput, int i_IndexToSet)
	{
		if (i_IndexToSet >= 1 && i_IndexToSet <= baseAmountOfProperties)
		{
			return super.SetProductProperties(userInput, i_IndexToSet);
		}

		boolean goodInput = false;
		int integerInput;
		switch (i_IndexToSet)
		{
			case baseAmountOfProperties + 1:
				this.expirationDate = userInput;
				goodInput = true;

				break;
			case baseAmountOfProperties + 2:
				this.kosherType = userInput;
				goodInput = true;

				break;
			case baseAmountOfProperties + 3:
				this.dietType = userInput;
				goodInput = true;

				break;

			default:
				break;
		}

		return goodInput;
	}
}

