package design_pattern.behavioural.state;

public class BrushTool implements Tool {
    @Override
    public void mouseDown() {
        System.out.println("Brush tool");
    }

    @Override
    public void mouseUp() {
        System.out.println("Draw a line");
    }
}
