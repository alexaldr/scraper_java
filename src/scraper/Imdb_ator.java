package scraper;

//importações
import java.io.IOException;
//import java.util.logging.Level;;
//import java.util.logging.Logger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Alex Almeida Andrade
 */
public class Imdb_ator {

    public ArrayList<ArrayList<String>> atores = new ArrayList<>();
    
    public Imdb_ator(String criterio) {
        String url = "https://www.imdb.com/find?q=#_._#&s=nm&ref_=fn_al_nm_mr".replace("#_._#", criterio);

        Document doc;

        try {
            //obtem a página
            doc = Jsoup.connect(url).get();
            //seleciona apenas a lista de filmes
            for (Element row : doc.select("td.result_text a")) {

                //salta os títulos que não são atores
                if (row.absUrl("href").contains("www.imdb.com/name/")) {
                    //obtém o link absoluto dos filmes (usa regex para excluir o final)
                    final String link = row.absUrl("href").replaceAll("\\?ref_=fn_nm_nm_[0-9]*", "");
                    //obtém o texto do nome
                    final String nome = row.text();
                    // debug teste
                    System.out.println("" + nome + " - " + link + "");

                    atores.add(new ArrayList<>(Arrays.asList(nome, link)));
                }

            }
        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        }
        System.out.println((atores).size() + " atores!");
        System.out.println("" + atores + "");
    }
}
