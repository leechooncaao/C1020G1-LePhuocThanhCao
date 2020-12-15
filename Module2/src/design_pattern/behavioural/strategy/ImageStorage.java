package design_pattern.behavioural.strategy;

public class ImageStorage {
    private Compressor compressor;
    private Filter filter;

    public ImageStorage(Compressor compressor, Filter filter) {
        this.compressor = compressor;
        this.filter = filter;
    }

    public void store(String fileName){
        compressor.compress();
        filter.apply();
    }


    public void setCompressor(Compressor compressor) {
        this.compressor = compressor;
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }
}
