package _Bloch.builder;

public class Solution {
    public static void main(String[] args) {
        NutritionFacts nutritionFacts = new NutritionFacts.Builder(156, 456)
                .calories(45).carbohydrate(12).build();

        NyPizza nyPizza = new NyPizza.Builder(NyPizza.Size.MEDIUM)
                .addTopping(Pizza.Topping.PEPPER).addTopping(Pizza.Topping.SAUSAGE).build();
        Calzone calzone = new Calzone.Builder(true).addTopping(Pizza.Topping.ONION)
                .addTopping(Pizza.Topping.HAM).build();


    }
}
