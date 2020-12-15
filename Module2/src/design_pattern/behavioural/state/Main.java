package design_pattern.behavioural.state;


public class Main {
    public static void main(String[] args) {
        Canvas canvas = new Canvas();

        canvas.setCurrentTool(new EraserTool());

        canvas.mouseDown();
        canvas.mouseUp();
    }
}
