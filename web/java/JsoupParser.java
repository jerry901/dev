import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupParser {
    public static void main(String[] args) {
       String url = "https://finance.naver.com/marketindex/exchangeList.nhn";

        Document doc = null;

        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements element = doc.select("tbody");

        for(Element el : element.select("tr")) {
            System.out.println(String.format("%10s  %-10s",el.select("td.tit").text() ,el.select("td.sale").text()));
        }
    }
}