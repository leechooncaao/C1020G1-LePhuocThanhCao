package design_pattern.behavioural.state;

public class SelectionTool implements Tool {
    @Override
    public void mouseDown() {
        System.out.println("Selection tool");
    }

    @Override
    public void mouseUp() {
        System.out.println("Draw a dash-rectangle");
    }
}
