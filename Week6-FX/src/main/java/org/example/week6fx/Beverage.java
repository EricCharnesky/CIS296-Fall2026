package org.example.week6fx;

import java.util.ArrayList;

public class Beverage {


    public static double COFFEE_PRICE = 1.0;
    public static double TEA_PRICE = 1.5;
    public static double ESPRESSO_PRICE = 2.0;
    public static double SOY_MILK_PRICE = .75;
    public static double OAT_MILK_PRICE = .75;
    public static double VANILLA_SYRUP_PRICE = 1.0;

    private final BeverageType type;
    private ArrayList<Addon> addons;

    public Beverage(BeverageType type) {
        this.type = type;
        addons = new ArrayList<>();
    }

    public BeverageType getType() {
        return type;
    }

    public ArrayList<Addon> getAddons() {
        return addons;
    }

    public void addAddon(Addon addon){
        addons.add(addon);
    }

    public void setAddons(ArrayList<Addon> addons) {
        this.addons = addons;
    }

    public double getPrice(){
        double price = 0;
        if (type == BeverageType.COFFEE){
            price = COFFEE_PRICE;
        } else if ( type == BeverageType.TEA){
            price = TEA_PRICE;
        } else if ( type == BeverageType.ESPRESSO){
            price = ESPRESSO_PRICE;
        }

        for ( Addon addon : addons ){
            if ( addon == Addon.OAT_MILK ){
                price += OAT_MILK_PRICE;
            } else if ( addon == Addon.SOY_MILK){
                price += SOY_MILK_PRICE;
            } else if ( addon == Addon.VANILLA_SYRUP){
                price += VANILLA_SYRUP_PRICE;
            }
        }
        return price;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        if (type == BeverageType.COFFEE){
            result = new StringBuilder("Coffee");
        } else if ( type == BeverageType.TEA){
            result = new StringBuilder("Tea");
        } else if ( type == BeverageType.ESPRESSO){
            result = new StringBuilder("Espresso");
        }
        if ( addons.size() > 0 ){
            result.append(" with");
        }
        for ( Addon addon : addons ){

            if ( addon == Addon.WHOLE_MILK ){
                result.append(" whole milk,");
            } else if ( addon == Addon.SKIM_MILK ) {
                result.append(" skim milk,");
            } else if ( addon == Addon.OAT_MILK ){
                result.append(" oat milk,");
            } else if ( addon == Addon.SOY_MILK){
                result.append(" soy milk,");
            } else if ( addon == Addon.VANILLA_SYRUP){
                result.append(" vanilla syrup,");
            }
        }
        result.deleteCharAt(result.length()-1);
        result.append("\n$ ").append(getPrice());
        return result.toString();
    }
}
