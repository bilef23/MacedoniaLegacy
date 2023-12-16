package mk.finki.ukim.diansproject.PipeAndFilter;

import mk.finki.ukim.diansproject.model.CulturalPlace;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WebScraperArcheologicalPlace{
    public static Elements scrapeElements() throws IOException {
        String snapshotUrl = "https://zk.mk/search/?what=археолошки+наоѓалишта";


            // Make an HTTP GET request
            Document doc = Jsoup.connect(snapshotUrl).get();

            // Select elements using different classes
            Elements elements = doc.select(".detailresult");

            return elements;


    }

}
