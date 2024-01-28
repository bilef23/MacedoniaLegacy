package mk.finki.ukim.diansproject.PipeAndFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Pipe<I, O, P> implements Filter<I, P> {

    private final Filter<I, O> current;
    private final Filter<O, P> succ;

    Pipe(Filter<I, O> current, Filter<O, P> next) {
        this.current = current;
        this.succ = next;
    }

    public P execute(I input) throws IOException, InterruptedException {
        return succ.execute(current.execute(input));
    }

}
