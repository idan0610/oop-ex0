/**
 * This class represents the store. The store can have 5 product types at most.
 * @author Idan Refaeli
 * @see ProductType, Customer
 */
class Store {
	
	/**
	 * The maximal number of product types this store can hold.
	 */
	final int MAX_NUM_OF_PRODUCT_TYPES = 5;
	/**
	 * The balance of this store.
	 */
	int balance;
	/**
	 * The array of products this store hold.
	 */
	ProductType[] productTypeArray;

	/**
	 * Constructs a new Store object.
	 */
	Store() {
		balance = 0;
		productTypeArray = new ProductType[MAX_NUM_OF_PRODUCT_TYPES];
	}
	
	/**
	 * Returns a string representation of this store containing the balance
	 * of the store and list of products the store holds in their string
	 * representation.
	 * @return The string representation of this Store.
	 */
	String stringRepresentation() {
		// First initiating the string with a line containing the balance of
		// the store
		String storeString = "Store has a balance of " + balance + ", and the"
				+ " following products:";
		for (int i = 0; i < MAX_NUM_OF_PRODUCT_TYPES; i++) {
			if (productTypeArray[i] != null) {
				// For each item on productTypeArray, if it is not null, add
				// the product type to the string representation of the store.
				storeString += "\n" +
						productTypeArray[i].stringRepresentation();
			}
		}
		
		return storeString;
	}
	
	/**
	 * Attempts to add the given product type to the array of product types
	 * the store holds.
	 * @param productType
	 * @return true if adding the product type was successful, false otherwise.
	 */
	boolean addProductType(ProductType productType) {
		for (int i = 0; i < MAX_NUM_OF_PRODUCT_TYPES; i++) {
			if (productTypeArray[i] == null) {
				// For each item on productTypeArray, if it is null add the
				// given product type to the array on the same index of the
				// item, return true for success and end the method running.
				productTypeArray[i] = productType;
				return true;
			}
		}
		
		// Return false if no null item was found on productTypeArray, means
		// the array is full of products.
		return false;
	}
	
	/**
	 * Checks if this store sells a product with the given product type name.
	 * @param productTypeName The product type name requested to check
	 * @return true if there is a product in the store with the given product
	 * type name, false otherwise.
	 */
	boolean sellsProductsOfType(String productTypeName) {
		for (int i = 0; i < MAX_NUM_OF_PRODUCT_TYPES; i++) {
			if (productTypeArray[i] != null) {
				if (productTypeArray[i].name == productTypeName) {
					// For each item on productTypeArray, if the item is not
					// null and the product name is the same as
					// productTypeName, return true and end the method running
					return true;
				}
			}
		}
		
		// If no product with the name as the same as productTypeName was
		// found, return false
		return false;
	}
	
	/**
	 * Attempts to find and remove a product type from store where its name is
	 * the same as given product type name. 
	 * @param productTypeName The product type name requested to remove
	 * @return true if a product with the given product type name was found
	 * and removed, false otherwise.
	 */
	boolean removeProductTypeFromStore(String productTypeName) {
		for (int i = 0; i < MAX_NUM_OF_PRODUCT_TYPES; i++) {
			if (productTypeArray[i] != null) {
				if (productTypeArray[i].name == productTypeName) {
					// For each item on productTypeArray, if the item is not
					// null and the product name is the same as
					// productTypeName, remove the product from the array,
					// return true and end the method running.
					productTypeArray[i] = null;
					return true;
					// In this way, even if more then 1 products that has the
					// name as the given product name, only 1 will be removed
				}
			}
		}
		
		// If no product with the name as the same as productTypeName was
		// found, return false
		return false;
	}
	
	/**
	 * This method makes a purchase for the given customer of the given
	 * quantity of units of product type where its name is the same as the 
	 * given product type name, if exists, and if the customer can afford to
	 * buy this purchase.
	 * @param customer The customers wishes to make this purchase
	 * @param productTypeName The product type name the custome wishes to buy
	 * @param quantity The number of units to customer wishes to buy
	 * @return The actual number of units sold to the customer
	 */
	int makePurchase(Customer customer, String productTypeName, int quantity) {
		for (int i = 0; i < MAX_NUM_OF_PRODUCT_TYPES; i++) {
			if (productTypeArray[i] != null) {
				if (productTypeArray[i].name == productTypeName) {
					// For each item in productTypeArray, if the item is not
					// null and the product name is the same as
					// productTypeName
					if (customer.canAfford(quantity, productTypeArray[i]) 
							== false) {
						// If the customer can't afford to buy the amount of
						// units of the product as quantity, change quantity
						// to the maximum affordable quantity.
						quantity = customer.maximumAffordableQuantity(
								productTypeArray[i]);
					}
					// Call makePurchase() of Customer class to change the
					// balance and log of the customer, and change the balance
					// of the Store. Then return quantity and end.
					customer.makePurchase(quantity, productTypeArray[i]);
					balance += quantity * productTypeArray[i].profitPerUnit();
					return quantity;
				}
			}
		}
		// If no product type with the name as productTypeName was found,
		// return 0 because no purchase really happened.
		return 0;
	}
}
