package mk.finki.ukim.diansproject.PipeAndFilter;

import java.io.IOException;

public interface Filter<I, O> {

    O execute(I input) throws IOException, InterruptedException;

}
