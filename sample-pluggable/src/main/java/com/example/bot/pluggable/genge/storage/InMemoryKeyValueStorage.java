package com.example.bot.pluggable.genge.storage;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;

public class InMemoryKeyValueStorage<V> implements KeyValueStorage<V> {
    private ConcurrentHashMap<String, V> storage;

    public InMemoryKeyValueStorage() {
        this.storage = new ConcurrentHashMap<>();
    }

    @Override
    public void save(Class<?> klass, String key, V i) {
        this.storage.put(klass.getCanonicalName() + "#" + key, i);
    }

    @Override
    public V load(Class<?> klass, String key) {
        return this.storage.get(klass.getCanonicalName() + "#" + key);
    }

    @Override
    public V compute(Class<?> klass, String key,
                     BiFunction<? super String, ? super V, ? extends V> remappingFunction) {
        return this.storage.compute(klass.getCanonicalName() + "#" + key,
                remappingFunction);
    }
}
