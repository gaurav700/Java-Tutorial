class MealOrder{
    private Hamburger hamburger;
    private Item drink;
    private Item sideItem;

    public MealOrder(Hamburger hamburger, Item drink, Item sideItem) {
        this.Hamburger = hamburger;
        this.drink = drink;
        this.sideItem = sideItem;
    }

    public void addToppings(){

    }

    public void setDrinkSize(){

    }

    public void printItemizedList(){

    }

    public void printTotal(){

    }

}

class Item{
    private String name;
    private Stirng type;
    private String size;
    private double price;

    public Item(String name, String type, String size, double price) {
        this.name = name;
        this.type = type;
        this.size = size;
        this.price = price;
    }

    public doouble getBasePrice(){

    }

    public double getAdjustedPrice(){

    }

    public void printItem(){

    }
}



class Hamburger{
    private Item extra1;
    private Item extra2;
    private Item extra3;

    public Hamburger(Item extra1, Item extra2, Item extra3) {
        this.extra1 = extra1;
        this.extra2 = extra2;
        this.extra3 = extra3;
    }

    public void addTopping(){
        
    }
}


public class Main {
    
}
