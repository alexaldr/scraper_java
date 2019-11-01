package scraper;

//importações
import java.io.IOException;
//import java.util.logging.Level;;
//import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import org.jsoup.select.Elements;

/**
 * @author Alex Almeida Andrade
 */
public class Imdb_filmes_ator {
    // propriedades
    public ArrayList<ArrayList<String>> filmes = new ArrayList<>();
    public String nome, descricao, nascimento, foto;

    // construtor da classe
    public Imdb_filmes_ator(String criterio) {
        String url = criterio;

        // Jsoup object
        Document doc;

        try {
            // get html
            doc = Jsoup.connect(url).get();

            nome = doc.selectFirst("h1.header").text();
            descricao = doc.selectFirst("div.infobar").text();
            nascimento = doc.selectFirst("div#name-born-info").text();
            foto = doc.selectFirst("img#name-poster").absUrl("src");

            // seleciona apenas a lista de filmes
            for (Element row : doc.select("div.filmo-row")) {

                // nome dos filmes
                final String filme = row.selectFirst("a").text();

                // ano do filme
                final String ano = row.selectFirst("span.year_column").text();

                // personagem
                final String personagem = row.ownText().replace("()", "").trim();

                // link absoluto dos filmes (regex exclui o final)
                final String linkfilme = row.selectFirst("a").absUrl("href").replaceAll("\\?ref_=nm_flmg_[A-Za-z0-9_]*", "");

                // debug teste
                // System.out.println("filme: " + filme + "\nano: " + ano + "\npersonagem: " + personagem + "\nlink: " + linkfilme + "\n\n");

                // adiciona à lista
                filmes.add(new ArrayList<>(Arrays.asList(filme, ano, personagem, linkfilme)));
            }
        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        }
        System.out.println((filmes).size() + " filmes!");
        System.out.println("" + filmes + "");
    }
}
