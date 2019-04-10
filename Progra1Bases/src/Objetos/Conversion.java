/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;


import java.io.IOException;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Conversion {
    //para mostrar e web scraping
    public static String Conversion() throws IOException {
        Document doc = Jsoup.connect("http://indi-eco.appspot.com/tcd").get();
        Elements el = doc.select("span#lblRefSellMsg");
        return el.text();
       
    }
    
}
