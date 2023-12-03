package mk.finki.ukim.diansproject.PipeAndFilter.filterImpl;

import mk.finki.ukim.diansproject.PipeAndFilter.Filter;
import mk.finki.ukim.diansproject.model.CulturalPlace;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class CategoryFilter implements Filter<List<CulturalPlace>, List<CulturalPlace>> {
    private final String category;

    public CategoryFilter(String category) {
        this.category = category;
    }
    @Override
    public List<CulturalPlace> execute(List<CulturalPlace> input) throws IOException {
        return input.stream().parallel().filter(museum -> museum.getCategory().equals(category)).collect(Collectors.toList());
    }
}
