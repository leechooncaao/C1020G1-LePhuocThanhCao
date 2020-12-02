package abstractclass_interface.thuc_hanh.animal_edible;

public class Chicken extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "Chicken : cuc cuc cuc tac";
    }

    @Override
    public String howToEat() {
        return "need to be fried" ;
    }
}
