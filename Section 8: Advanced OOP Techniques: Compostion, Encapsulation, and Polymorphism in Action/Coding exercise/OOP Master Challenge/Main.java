class Item {
    private String name;
    private String type;
    private String size = "MEDIUM";
    private double price;

    public Item(String name, String type, double price) {
        this.name = name.toUpperCase();
        this.type = type.toUpperCase();
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public String getSize() {
        if (type.equals("SIDE") || type.equals("DRINK")) {
            return size + " " + name;
        }
        return this.size;
    }

    public double getBasePrice() {
        return this.price;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getAdjustedPrice() {
        return switch (size) {
            case "SMALL" -> getBasePrice() - 0.5;
            case "LARGE" -> getBasePrice() + 1;
            default -> getBasePrice();
        };
    }

    public static void printItem(String name, double price) {
        System.out.printf("%20s:%6.2f%n", name, price);
    }

    public void printItem() {
        printItem(getName(), getAdjustedPrice());
    }
}

class Burger extends Item {
    private Item extra1;
    private Item extra2;
    private Item extra3;

    public Burger(String name, double price) {
        super(name, "BURGER", price);
    }

    @Override
    public String getName() {
        return super.getName() + " BURGER";
    }

    @Override
    public double getAdjustedPrice() {
        return getBasePrice()
                + (extra1 == null ? 0 : extra1.getAdjustedPrice())
                + (extra2 == null ? 0 : extra2.getAdjustedPrice())
                + (extra3 == null ? 0 : extra3.getAdjustedPrice());
    }

    public double getExtraPrice(String toppingName) {
        return switch (toppingName.toUpperCase()) {
            case "AVACADO", "CHEESE" -> 1.0;
            case "BACON", "HAM", "SALAMI" -> 1.5;
            default -> 0.0;
        };
    }

    public void addToppings(String extra1, String extra2, String extra3) {
        this.extra1 = new Item(extra1, "TOPPING", getExtraPrice(extra1));
        this.extra2 = new Item(extra2, "TOPPING", getExtraPrice(extra2));
        this.extra3 = new Item(extra3, "TOPPING", getExtraPrice(extra3));
    }

    public void printItemizedList() {
        printItem("BASE BURGER", getBasePrice());
        if (extra1 != null) extra1.printItem();
        if (extra2 != null) extra2.printItem();
        if (extra3 != null) extra3.printItem();
    }

    @Override
    public void printItem() {
        printItemizedList();
        System.out.println("-".repeat(30));
        super.printItem();
    }
}

class DeluxBurger extends Burger {
    private Item delux1;
    private Item delux2;

    public DeluxBurger(String name, double price) {
        super(name, price);
    }

    public void addToppings(String extra1, String extra2, String extra3, String extra4, String extra5) {
        super.addToppings(extra1, extra2, extra3);
        delux1 = new Item(extra4, "TOPPING", 0); // Free
        delux2 = new Item(extra5, "TOPPING", 0); // Free
    }

    @Override
    public void printItemizedList() {
        super.printItemizedList();
        if (delux1 != null) delux1.printItem();
        if (delux2 != null) delux2.printItem();
    }

    @Override
    public double getExtraPrice(String toppingName) {
        return 0; // All toppings free in DeluxBurger
    }
}

class MealOrder {
    private Burger burger;
    private Item drink;
    private Item side;

    public MealOrder() {
        this("regular", "coke", "fries");
    }

    public MealOrder(String burgerType, String drinkType, String sideType) {
        if (burgerType.equalsIgnoreCase("delux")) {
            this.burger = new DeluxBurger("delux", 8.5);
        } else {
            this.burger = new Burger(burgerType, 4.0);
        }
        drink = new Item(drinkType, "DRINK", 1.0);
        side = new Item(sideType, "SIDE", 1.5);
    }

    public double getTotalPrice() {
        if (burger instanceof DeluxBurger) {
            return burger.getAdjustedPrice();
        }
        return burger.getAdjustedPrice() + drink.getAdjustedPrice() + side.getAdjustedPrice();
    }

    public void printOrder() {
        burger.printItem();
        if (burger instanceof DeluxBurger) {
            Item.printItem(drink.getName(), 0);
            Item.printItem(side.getName(), 0);
        } else {
            drink.printItem();
            side.printItem();
        }
        System.out.println("-".repeat(30));
        Item.printItem("TOTAL PRICE", getTotalPrice());
    }

    public void addBurgerToppings(String extra1, String extra2, String extra3) {
        burger.addToppings(extra1, extra2, extra3);
    }

    public void addBurgerToppings(String extra1, String extra2, String extra3, String extra4, String extra5) {
        if (burger instanceof DeluxBurger db) {
            db.addToppings(extra1, extra2, extra3, extra4, extra5);
        } else {
            burger.addToppings(extra1, extra2, extra3);
        }
    }

    public void setDrinkSize(String size) {
        drink.setSize(size);
    }

    public void setSideSize(String size) {
        side.setSize(size);
    }
}

public class Main {
    public static void main(String[] args) {
        MealOrder reguMealOrder = new MealOrder();
        reguMealOrder.addBurgerToppings("BACON", "CHEESE", "MAYO");
        reguMealOrder.setDrinkSize("LARGE");
        reguMealOrder.setSideSize("LARGE");
        reguMealOrder.printOrder();

        System.out.println();
        System.out.println();

        MealOrder deluxMealOrder = new MealOrder("delux", "coke", "fries");
        deluxMealOrder.addBurgerToppings("BACON", "CHEESE", "MAYO", "AVACADO", "SALAMI");
        deluxMealOrder.setDrinkSize("SMALL");
        deluxMealOrder.setSideSize("SMALL");
        deluxMealOrder.printOrder();
    }
}
