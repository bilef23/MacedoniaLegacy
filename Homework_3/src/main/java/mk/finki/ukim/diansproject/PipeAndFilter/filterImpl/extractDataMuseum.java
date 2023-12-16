package mk.finki.ukim.diansproject.PipeAndFilter.filterImpl;

import mk.finki.ukim.diansproject.PipeAndFilter.Filter;
import mk.finki.ukim.diansproject.model.CulturalPlace;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class extractDataMuseum implements Filter<Elements, List<CulturalPlace>> {
    private final Elements elements;

    public extractDataMuseum(Elements elements) {
        this.elements = elements;
    }

    @Override
    public List<CulturalPlace> execute(Elements input) throws IOException {
        List<CulturalPlace>museums=new ArrayList<>();

        for (Element element : elements) {
            String name = element.select(".companyName").select("span").attr("itemprop","name").text();
            String category = element.select(".shortdescription").select("a").text();
            String location=element.select(".h4efd8293a5270db14490d2fba73e0d16").select("span").attr("itemprop","addressLocality").text();
            String phoneNumber=element.select(".callme").attr("href");
            museums.add(new CulturalPlace(name,category,phoneNumber,location));
        }

        return museums;
    }
}
