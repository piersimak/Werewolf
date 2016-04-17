package com.example.bot.pluggable.genge.storage;

import java.util.function.BiFunction;

public interface KeyValueStorage<V> {
    void save(Class<?> klass, String key, V i);

    V load(Class<?> klass, String key);

    V compute(Class<?> klass, String key,
              BiFunction<? super String, ? super V, ? extends V> remappingFunction);
}
