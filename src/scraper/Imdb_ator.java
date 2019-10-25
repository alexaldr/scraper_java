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
import java.util.Iterator;
import javax.swing.JOptionPane;
import org.jsoup.select.Elements;

/**
 * @author Alex Almeida Andrade
 */
public class Imdb_ator {

    // propriedades
    public ArrayList<ArrayList<String>> atores = new ArrayList<>();

    // construtor da classe
    public Imdb_ator(String criterio) {
        String url = "https://www.imdb.com/find?q=#_._#&s=nm&ref_=fn_al_nm_mr".replace("#_._#", criterio);

        ArrayList<String> img_list = new ArrayList<>();
        ArrayList<String> name_list = new ArrayList<>();
        ArrayList<String> link_list = new ArrayList<>();

        // Jsoup object
        Document doc;

        //TODO
//        Element image = document.select("img").first();
//        String url = image.absUrl("src");

        /*
        TEXT AND IMAGE: "tr.findResult"
        TEXT: "td.result_text a"
        IMAGE: "td.primary_photo img"
        Icon icon_name = new ImageIcon(new URL("https://www.cleverpetproducts.com/wp-content/uploads/2018/03/tardar.jpg"));
         */
//        try {
//            // get html
//            doc = Jsoup.connect(url).get();
//            // seleciona apenas a lista de filmes
//            for (Element row : doc.select("td.result_text a")) {
//                // filtra pelos atores
//                if (row.absUrl("href").contains("www.imdb.com/name/")) {
//                    // link absoluto dos filmes (regex exclui o final)
//                    final String link = row.absUrl("href").replaceAll("\\?ref_=fn_nm_nm_[0-9]*", "");
//                    // texto da tag <a>
//                    final String nome = row.text();
//                    // debug teste
//                    System.out.println("" + nome + " - " + link + "");
//                    // 
//                    atores.add(new ArrayList<>(Arrays.asList(nome, link)));
//                }
//
//            }
//        } catch (IOException ex) {
//            System.out.println("Error: " + ex);
//        }
//        System.out.println((atores).size() + " resultados!");
//        System.out.println("" + atores + "");
        //dados com imagem
        try {
            // get html
            doc = Jsoup.connect(url).get();
            doc.select("small").remove();

            Elements images = doc.select("td.primary_photo img");
            Elements names = doc.select("td.result_text a");
            Elements links = doc.select("td.result_text a");
//            links.select("small a").remove();

            if (names.size() == 0) {
                JOptionPane.showMessageDialog(null,
                        "Nada encontrado!",
                        "Atenção", JOptionPane.INFORMATION_MESSAGE);

            } else {
                for (Element img : images) {
                    img_list.add(img.attr("src"));
//                System.out.println(img.attr("src"));
                }
                for (Element name : names) {
                    name_list.add(name.text());
//                System.out.println(name.text());
                }
                for (Element link : links) {
                    link_list.add(link.absUrl("href").replaceAll("\\?ref_=fn_nm_nm_[0-9]*", ""));
//                System.out.println(link.absUrl("href").replaceAll("\\?ref_=fn_nm_nm_[0-9]*", ""));
                }
//                System.out.println("img:\t" + img_list.size());
//                System.out.println("name:\t" + name_list.size());
//                System.out.println("link:\t" + link_list.size());

                // iterador para percorrer multiplos collections ao mesmo tempo
                Iterator<String> img_iter = img_list.iterator();
                Iterator<String> name_iter = name_list.iterator();
                Iterator<String> link_iter = link_list.iterator();
                
                if (img_list.size() == name_list.size() && img_list.size() == link_list.size()) {
                    int i = 0;
                    while (img_iter.hasNext() && i<25) {
                        i++;
                        atores.add(new ArrayList<>(Arrays.asList(img_iter.next(), name_iter.next(), link_iter.next())));
                    }
                }
                System.out.println("link:\t" + atores.get(0).get(0)+"\nSize: "+atores.size());
            }
            // exception    
        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        }
//        System.out.println((atores).size() + " resultados!");
//        System.out.println("" + atores + "");
    }
}
