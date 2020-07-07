package hit.co.il;

public abstract class Product
{
	protected static final int baseAmountOfProperties = 3;
	protected String productName;
	protected int productCatalogNum; //ID - Unique
	protected int productQuantity;
	protected int minimumQuantity;


	public Product(int productCatalogNum)
	{
		this.productCatalogNum = productCatalogNum;
	}



	/********GETTERS & SETTERS**********/
	public final String getProductName()
	{
		return productName;
	}

	public final void setProductName(String productName)
	{
		this.productName = productName;
	}

	public final int getProductQuantity()
	{
		return productQuantity;
	}

	public final void setProductQuantity(int productQuantity)
	{
		this.productQuantity = productQuantity;
	}




	public void PrintProduct()
	{
		System.out.println("name :" + productName + " , quantity=" + productQuantity + " , minimum quantity=" + minimumQuantity + " , catalog number : " + productCatalogNum);
	}

	public String toString()
	{
		return ("name :" + productName + " , quantity=" + productQuantity + " , minimum quantity=" + minimumQuantity + " , catalog number : " + productCatalogNum);
	}
	/***********************************************************************************/

	public java.lang.Iterable<String> GetProductProperties()
	{
		ArrayList<String> productProperties = new ArrayList<String>();

		productProperties.add(("What is the product name?")); //1 (first question)
		productProperties.add(("What is the product current Quantity")); //2
		productProperties.add(("What is the product minimum Quantity")); //3

		return productProperties;
	}

	public boolean SetProductProperties(String userInput, int i_IndexToSet)
	{
		boolean goodInput = false;
		int integerInput;
		switch (i_IndexToSet)
		{
			case 1:
					this.productName = userInput;
					goodInput = true;

				break;

			case 2:
				tangible.OutObject<Integer> tempOut_integerInput = new tangible.OutObject<Integer>();
				goodInput = tangible.TryParseHelper.tryParseInt(userInput, tempOut_integerInput);
			integerInput = tempOut_integerInput.outArgValue;
				if (goodInput && integerInput >= 0)
				{
					productQuantity = integerInput;
					goodInput = true;
				}
				else
				{
					goodInput = false;
				}

				break;
			//amountOfProperties must be the last, needs change when adding more properties 
			//created for loosly couple between son and base
			case baseAmountOfProperties:
				tangible.OutObject<Integer> tempOut_integerInput2 = new tangible.OutObject<Integer>();
				goodInput = tangible.TryParseHelper.tryParseInt(userInput, tempOut_integerInput2);
			integerInput = tempOut_integerInput2.outArgValue;
				if (goodInput && integerInput >= 0)
				{
					minimumQuantity = integerInput;
					goodInput = true;
				}
				else
				{
					goodInput = false;
				}

				break;

			default:
				break;
		}

		return goodInput;
	}
}

