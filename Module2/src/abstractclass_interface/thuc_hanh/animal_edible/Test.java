package abstractclass_interface.thuc_hanh.animal_edible;

import java.sql.Timestamp;

public class Test {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();

        for(var animal : animals){
            System.out.println(animal.makeSound());

            if(animal instanceof Chicken){
                Chicken chicken = (Chicken) animal;
                System.out.println(chicken.howToEat());
            }
        }



    }
}
