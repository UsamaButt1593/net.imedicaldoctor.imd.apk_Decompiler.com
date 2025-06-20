package com.google.firebase.components;

import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.Set;

public interface ComponentContainer {
    <T> T a(Class<T> cls);

    <T> Provider<T> b(Qualified<T> qualified);

    <T> Provider<T> c(Class<T> cls);

    <T> Provider<Set<T>> e(Class<T> cls);

    <T> Set<T> f(Qualified<T> qualified);

    <T> Provider<Set<T>> g(Qualified<T> qualified);

    <T> T h(Qualified<T> qualified);

    <T> Set<T> i(Class<T> cls);

    <T> Deferred<T> j(Qualified<T> qualified);

    <T> Deferred<T> k(Class<T> cls);
}
