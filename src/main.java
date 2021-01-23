import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class main {
    public static void main(String[] args) throws IOException {
        Tela tela = new Tela();
        tela.criarTela("Loader");
        tela.pullRequest();



    }
}
