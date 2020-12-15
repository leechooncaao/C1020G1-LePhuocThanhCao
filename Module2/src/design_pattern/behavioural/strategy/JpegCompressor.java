package design_pattern.behavioural.strategy;

public class JpegCompressor implements Compressor {
    @Override
    public void compress() {
        System.out.println("Compressing using JPEG");
    }
}
