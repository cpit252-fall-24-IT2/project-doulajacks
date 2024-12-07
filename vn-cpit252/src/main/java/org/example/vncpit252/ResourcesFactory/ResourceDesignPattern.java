package org.example.vncpit252.ResourcesFactory;

public enum ResourceDesignPattern {
    Singleton, Prototype, Adapter, Builder, Proxy, Flyweight, Decorator, Observer;

    @Override
    public String toString() {
        return name();
    }
}
