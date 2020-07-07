package hit.co.il;
import java.util.*;


public class ConsoleUI
{

	private ProductsHash productsCollection = new ProductsHash();

	public final void MainProcess()
	{
		boolean userWantToExit = false;
		char firstMenuChosen;
		do
		{
			firstMenuChosen = Character.Parse(firstMenu());
			Runtime.getRuntime().exec("cls");
			switch (firstMenuChosen)
			{
				case '1':
					insertNewProduct();
					break;
				case '2':
					showListOfProductsByType();
					break;
				case '3':
					changeAmountOfProduct();
					break;
				case '4':
					showCompleteDataOfProduct();
					break;

				case '8':
					userWantToExit = true;
					break;
			}
		} while (userWantToExit == false);
	}


	private void showCompleteDataOfProduct()
	{
		int catalogNumber;
		catalogNumber = askFromeUserCatalogNum();
		if (productsCollection.IsProductExist(catalogNumber))
		{
			System.out.printf("%1$s - full  details:" + "\r\n", catalogNumber);
			System.out.println(productsCollection.ShowProductDetails(catalogNumber));
		}
		else
		{
			System.out.println("There is no such product");
		}
	}

	public final void changeAmountOfProduct()
	{
		int catalogNum;
		catalogNum = askFromeUserCatalogNum();
		if (productsCollection.IsProductExist(catalogNum))
		{
			try
			{
				int amountToAdd = askFromUserToChooseAndCheckHim("What the amount you want to add?", 1, Integer.MAX_VALUE);
				productsCollection.changeAmount(productsCollection.GetProduct(catalogNum).getProductQuantity() + amountToAdd, catalogNum);
				System.out.printf("product - %1$s, amount was changed to %2$s." + "\r\n", catalogNum, productsCollection.GetProduct(catalogNum).getProductQuantity());
			}
			catch (IllegalArgumentException ex)
			{
				System.out.println(ex.getMessage());
			}
		}
		else
		{
			System.out.println("There is no such product");
		}
	}

	public final void showListOfProductsByType()
	{
		ArrayList<Product> licenseNumbersList;
		eProductType enumSelectedCondition;
		enumSelectedCondition = askFromeUserProductType();
		licenseNumbersList = productsCollection.GetListOfProducts(enumSelectedCondition);
		System.out.printf("List of %1$s product'%1$s' :" + "\r\n", enumSelectedCondition);

		for (Product product : licenseNumbersList)
		{
			//can also add catalog number and minimum amount..
			System.out.println(product.getProductName() + " , currently amount - " + product.getProductQuantity());
		}
	}

	private eProductType askFromeUserProductType()
	{
		eProductType productType;

		productType = eProductType.valueOf(this.String.valueOf(enumAskAndUserSelection<eProductType>("What is the product type?")));
		return productType;
	}

	private void insertNewProduct()
	{
		//eProductType enumProductType;
		int productCatalogNum;
		eProductType productType;
		Product product;
		try
		{
			//need to do check for user input
			productCatalogNum = (int)askFromeUserCatalogNum();
			if (productsCollection.IsProductExist(productCatalogNum))
			{
				System.out.println("this product is already exist");
			}
			else
			{
				//get from user type of product to insert
				productType = eProductType.valueOf(this.String.valueOf(enumAskAndUserSelection<eProductType>("What kind of product ? ")));

				productsCollection.InsertNewProductModel(productType, productCatalogNum);
				product = productsCollection.GetProduct(productCatalogNum);
				askForUniqueProperties(product);
				System.out.println("Product has been added successfully");
			}
		}
		catch (RuntimeException ex)
		{
			System.out.println(ex.getMessage());
		}
	}

   private <TEnum extends IConvertible> int enumAskAndUserSelection(String i_StringToPrint)
	{
		int i;
		System.out.println(i_StringToPrint);
		i = 1;

		for (TEnum val : TEnum.values())
		{
			System.out.printf("%1$s. %2$s" + "\r\n", i, val);
			i++;
		}

		return askFromUserToChooseAndCheckHim(1, tangible.EnumHelper.getNames(TEnum.class).length);
	}

	private void askForUniqueProperties(Product product)
	{
		boolean goodInput;
		int indexToSet = 1;
		String userInput;
		java.lang.Iterable<String> productProperties = product.GetProductProperties();

		for (String uniqueFeature : productProperties)
		{
			do
			{
				System.out.printf("%1$s" + "\r\n", uniqueFeature);
				userInput = new Scanner(System.in).nextLine();
				goodInput = product.SetProductProperties(userInput, indexToSet);
				if (goodInput)
				{
					indexToSet++;
				}
				else
				{
					System.out.println("Bad input, try again...");
				}
			} while (!goodInput);
		}
	}

	private int askFromeUserCatalogNum()
	 {
				System.out.println("Please enter product catalog number");
				// need to check user input(check if int - you can use tryParse)
				return Integer.parseInt(new Scanner(System.in).nextLine());
	 }

			private String firstMenu()
			{
				String firstMenu = "Corona project:" + "\r\n" + 
	"\r\n" + 
	"1. Insert a new product" + "\r\n" + 
	"\r\n" + 
	"2. Show list of products by type" + "\r\n" + 
	"\r\n" + 
	"3. Change the amount of a product" + "\r\n" + 
	"\r\n" + 
	"4. Show complete data of product" + "\r\n" + 
	"\r\n" + 
	"\r\n" + 
	"8. Exit";
				return String.valueOf(askFromUserToChooseAndCheckHim(firstMenu, 1, 8));
			}

			private int askFromUserToChooseAndCheckHim(String i_StringToPrint, int i_From, int i_To)
			{
				boolean validTryParse;
				int intMenuChosen;
				String stringMenuChosen;
				boolean validInput = true;

				do
				{
					System.out.println(i_StringToPrint);
					if (validInput == false)
					{
						System.out.printf("wrong...please choose again (%1$s-%2$s)" + "\r\n", i_From, i_To);
					}

					stringMenuChosen = new Scanner(System.in).nextLine();
					tangible.OutObject<Integer> tempOut_intMenuChosen = new tangible.OutObject<Integer>();
					validTryParse = tangible.TryParseHelper.tryParseInt(stringMenuChosen, tempOut_intMenuChosen);
					intMenuChosen = tempOut_intMenuChosen.outArgValue;
					if (intMenuChosen <= i_To && intMenuChosen >= i_From && validTryParse)
					{
						validInput = true;
					}
					else
					{
						validInput = false;
					}
				} while (!validInput);

				return intMenuChosen;
			}

			private int askFromUserToChooseAndCheckHim(int i_From, int i_To)
			{
				boolean validTryParse;
				int intMenuChosen;
				String stringMenuChosen;
				boolean validInput = true;
				do
				{
					if (validInput == false)
					{
						System.out.printf("wrong...please choose again (%1$s-%2$s)" + "\r\n", i_From, i_To);
					}

					stringMenuChosen = new Scanner(System.in).nextLine();
					tangible.OutObject<Integer> tempOut_intMenuChosen = new tangible.OutObject<Integer>();
					validTryParse = tangible.TryParseHelper.tryParseInt(stringMenuChosen, tempOut_intMenuChosen);
					intMenuChosen = tempOut_intMenuChosen.outArgValue;
					if (intMenuChosen <= i_To && intMenuChosen >= i_From && validTryParse)
					{
						validInput = true;
					}
					else
					{
						validInput = false;
					}
				} while (!validInput);

				return intMenuChosen;
			}
		}
	}


