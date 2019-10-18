/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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


/**
 * @author Alex Almeida Andrade
 */
public class Imdb_filme {

    public static void main(String[] args) {
        
        String url_ator = "https://www.imdb.com/find?q=#_._#&s=nm&ref_=fn_al_nm_mr";
        
        
        
        String url = "https://www.imdb.com/name/nm0000115/";

        final Document doc;
        List<String> filmes = new ArrayList<>();

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
        
        System.out.println((filmes).size()+" filmes!");
        
        
    }
}
