/**
 * This class represents the customer. The customer has a name, address,
 * balance (how much money the customer has) and log of purchases.
 * @author Idan Refaeli
 * @see ProductType
 */
class Customer {
	
	/**
	 * The name of the customer.
	 */
	String name;
	/**
	 * The address of the customer.
	 */
	String address;
	/**
	 * The balance of the customer.
	 */
	int balance;
	/**
	 * The log of previous purchases of the customer.
	 */
	String log;

	/**
	 * Constructs a new Customer with the given parameters.
	 * @param customerName The name of the customer.
	 * @param customerAddress The address of the customer.
	 * @param customerBalance The balance of the customer.
	 */
	Customer(String customerName, String customerAddress, int customerBalance){
		name = customerName;
		address = customerAddress;
		balance = customerBalance;
		log = "Shopping log for customer: " + name;
	}
	
	/**
	 * Returns a string representation of this customer, which looks like
	 * "[name,address,balance]"
	 * @return The string representation of this customer.
	 */
	String stringRepresentation() {
		return "[" + name + "," + address + "," + balance + "]";
	}
	
	/**
	 * This method checks if the customer can afford to buy the given product 
	 * type units equals to the given quantity.
	 * @param quantity The quantity of units of the product type.
	 * @param productType The product type.
	 * @return true if the customer can buy the given product type units
	 * equals to the given quantity, false otherwise.
	 */
	boolean canAfford(int quantity, ProductType productType) {
		int totalPrice = quantity * productType.customerPrice;
		if (totalPrice <= balance) {
			return true;
		}
		return false;
	}

	/**
	 * Returns the maximum amount of units the customer can afford to buy of
	 * the given product Type.
	 * @param productType The product type.
	 * @return The maximum affordable quantity.
	 */
	int maximumAffordableQuantity(ProductType productType){
		return balance / productType.customerPrice;
	}
	
	/**
	 * Returns the log of purchases of this customer.
	 * @return The log of purchases.
	 */
	String getPurchaseLog() {
		return log;
	}
	
	/**
	 * This method makes a purchase for the customer of the given quantity
	 * of units of the given product type.
	 * @param quantity The quantity of units of the product type.
	 * @param productType The product type.
	 */
	void makePurchase(int quantity, ProductType productType) {
		if (quantity <= 0) {
			// If the given quantity of units is non-positive, nothing will
			// happen and the method ends
			return;
		}
		
		if (canAfford(quantity, productType)) {
			// If the customer can afford to buy quantity of units of the
			// product type (using canAfford()), reduce the total price from
			// the customer balance and add the purchase to the log
			int totalPrice = quantity * productType.customerPrice;
			balance -= totalPrice;
			log += "\n" + quantity + " " + productType.name;
		}
	}
	
}
