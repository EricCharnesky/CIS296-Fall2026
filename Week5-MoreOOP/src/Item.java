public class Item implements Taxable {

    private final String name;
    private double price;
    private double taxRate;

    /**
     * Item class is amazing
     * @param name - if you don't know what name is you shouldn't code
     * @param price - unit price
     * @param taxRate - should be decimal value
     */
    public Item(String name, double price, double taxRate) {
        this.name = name;
        setPrice(price);
        setTaxRate(taxRate);
    }

    public void setPrice(double price) {
        if ( price <= 0 ){
            throw new IllegalArgumentException("price must be > 0");
        }
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public double getTaxRate() {
        return taxRate;
    }

    @Override
    public double getTotalPrice() {
        return price * (1 + taxRate);
    }

    @Override
    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    @Override
    public boolean equals(Object object){
        if ( this == object){
            return true;
        }

        // old way
//        Item item = (Item)object;
//        if ( item == null ){
//            return false;
//        }
//        return item.name.equals(this.name) && item.price == this.price)



        if ( object instanceof Item otherItem ){
            return otherItem.name.equals(this.name) && otherItem.price == this.price;
        }
        else{
            return false;
        }
    }
}
