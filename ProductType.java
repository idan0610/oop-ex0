/**
 * This class represents a product type. The product type has a name, a store
 * price and a customer price.
 * @author Idan Refaeli
 *
 */
class ProductType {
	
	/**
	 * The name of the product type.
	 */
	String name;
	
	/**
	 * The price the store pays for this product.
	 */
	int storePrice;
	
	/**
	 * The price the customer pays for this product.
	 */
	int customerPrice; 

	/**
	 * Constructs a new type of product with the given parameters.
	 * @param productName The name of the product.
	 * @param ProductStorePrice How much the product costs a store.
	 * @param productCustomerPrice How much the product costs a customer.
	 */
	ProductType(String productName, int ProductStorePrice, 
			int productCustomerPrice) {
		name = productName;
		storePrice = ProductStorePrice;
		customerPrice = productCustomerPrice;
	}
	
	/**
	 * Returns a string representation of this product type, 
	 * while looks like "[name,storePrice,customerPrice]"
	 * @return The string representation of this product type
	 */
	String stringRepresentation() {
		return "[" + name + "," + storePrice + "," + customerPrice + "]";
	}
	
	/**
	 * Returns the profit of this product type calculated by the formula:
	 * profit = customerPrice - storePrice
	 * @return The profit of this product type
	 */
	int profitPerUnit() {
		int profit = customerPrice - storePrice;
		return profit;
	}
	
}