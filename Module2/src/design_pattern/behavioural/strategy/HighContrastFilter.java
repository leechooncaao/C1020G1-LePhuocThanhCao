package design_pattern.behavioural.strategy;

public class HighContrastFilter implements Filter {
    @Override
    public void apply() {
        System.out.println("Using High Contrast filter");
    }
}
