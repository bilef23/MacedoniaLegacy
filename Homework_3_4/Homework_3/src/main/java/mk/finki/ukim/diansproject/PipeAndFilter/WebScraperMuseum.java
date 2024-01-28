package mk.finki.ukim.diansproject.PipeAndFilter;

import mk.finki.ukim.diansproject.model.CulturalPlace;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WebScraperMuseum {
    public static Elements scrapeElements() throws IOException {
        String baseUrl = "https://zk.mk/search/?what=музеи&page=3&filter_sort=rating";


            Elements elements = new Elements();
            // Make an HTTP GET request
            for (int page = 0; page <= 100; page+=20) {

                String pageUrl = baseUrl + "&skip=" + page;
                Document doc= Jsoup.connect(pageUrl).get();
                elements.addAll(doc.select(".detailresult"));

            }
            return elements;

    }

}
