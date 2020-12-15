package design_pattern.behavioural.strategy;

public class BlackAndWhiteFilter implements Filter {
    @Override
    public void apply() {
        System.out.println("Using B&W filter");
    }
}
