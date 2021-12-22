package ru.vsu.cs.edge;

public abstract class AbstractBaseEdge<V> implements Edge<V> {
    protected V source;
    protected V dest;
    protected double weight;

    public AbstractBaseEdge() {
    }

//    public AbstractBaseEdge(V source, V dest) {
//        this.source = source;
//        this.dest = dest;
//    }
//
//    public AbstractBaseEdge(V source, V dest, double weight) {
//        this.source = source;
//        this.dest = dest;
//        this.weight = weight;
//    }

    @Override
    public V source() {
        return source;
    }

    @Override
    public V dest() {
        return dest;
    }

    @Override
    public double weight() {
        return weight;
    }
}
