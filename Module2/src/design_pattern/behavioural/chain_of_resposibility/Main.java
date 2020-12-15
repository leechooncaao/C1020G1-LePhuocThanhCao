package design_pattern.behavioural.chain_of_resposibility;

public class Main {
    public static void main(String[] args) {
        // Authenticator -> logger -> compressor
        var compressor = new Compressor(null);
        var logger = new Logger(compressor);
        var authenticator = new Authenticator(logger);
        var server = new WebServer(authenticator);

        server.handle(new HttpRequest("-","1234"));
    }
}
