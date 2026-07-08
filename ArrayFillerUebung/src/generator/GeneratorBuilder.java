package generator;

public interface GeneratorBuilder<T> {

    Generator<T> create();
}
