package creatingdsls


public class PizzaShop {
	public void setSize(Size size) {}
	public void setCrust(Crust crust) {}
	public void setTopping(String... topping) {}
	public void setAddress(String address) {}
	public int setCard(CardType cardType, String cardNumber) {
		return 25;
	}
}

public enum Size {
	LARGE
}

public enum Crust {
	THIN
}

public enum CardType {
	VISA
}

def getPizza(closure) {
	PizzaShop pizzaShop = new PizzaShop()
	closure.delegate = pizzaShop
	closure()
}

time = getPizza {
	setSize Size.LARGE
	setCrust Crust.THIN
	setTopping "Olives", "Onions", "Bell Pepper"
	setAddress "101 Main St., ..."
	setCard(CardType.VISA, "1234-1234-1234-1234")
}

printf "Pizza will arrive in %d minutes\n", time

