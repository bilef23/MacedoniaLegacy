package mk.finki.ukim.diansproject.PipeAndFilter;

import java.io.IOException;


public class Pipeline<I, O> {

    private final Filter<I, O> curr;

    public Pipeline(Filter<I, O> current) {
        this.curr = current;
    }

    public <P> Pipeline<I, P> chain(Filter<O, P> curr) {
        return new Pipeline<>(new Pipe<>(this.curr, curr));
    }

    public O process(I input) throws IOException, InterruptedException {
        return curr.execute(input);
    }
}
