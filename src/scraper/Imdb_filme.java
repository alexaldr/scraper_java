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

/**
 * @author Alex Almeida Andrade
 */
public class Imdb_filme {

    // propriedades
    public ArrayList<ArrayList<String>> filmes = new ArrayList<>();

    // construtor da classe
    public Imdb_filme(String criterio) {
        String url = "https://www.imdb.com/find?q=#_._#&s=nm&ref_=fn_al_nm_mr".replace("#_._#", criterio);

        // Jsoup object
        Document doc;

        try {
            // get html
            doc = Jsoup.connect(url).get();
            // seleciona apenas a lista de filmes
            for (Element row : doc.select("td.result_text a")) {
                // filtra pelos atores
                if (row.absUrl("href").contains("www.imdb.com/name/")) {
                    // link absoluto dos filmes (regex exclui o final)
                    final String link = row.absUrl("href").replaceAll("\\?ref_=fn_nm_nm_[0-9]*", "");
                    // texto da tag <a>
                    final String nome = row.text();
                    // debug teste
                    System.out.println("" + nome + " - " + link + "");
                    // 
                    filmes.add(new ArrayList<>(Arrays.asList(nome, link)));
                }

            }
        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        }
        System.out.println((filmes).size() + " atores!");
        System.out.println("" + filmes + "");
    }

    public static void main(String[] args) {

        String url_ator = "https://www.imdb.com/find?q=#_._#&s=nm&ref_=fn_al_nm_mr";

        String url = "https://www.imdb.com/name/nm0000115/";

        final Document doc;
        ArrayList<String> filmes = new ArrayList<>();

        try {
            //obtem a página
            doc = Jsoup.connect(url).get();

            //seleciona apenas a lista de filmes
            for (Element row : doc.select("[id^='actor-'] a:first-child")) {
                //obtém o link absoluto dos filmes (usa regex para excluir o final)
                final String title = row.absUrl("href").replaceAll("\\?ref_=nm_flmg_act_[0-9]*", "");
                System.out.println(title);
                filmes.add(title);
            }
        } catch (IOException ex) {
            System.out.println("Error: " + ex);
//            Logger.getLogger(Scraper_java.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println((filmes).size() + " filmes!");

    }
}
