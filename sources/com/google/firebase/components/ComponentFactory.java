package com.google.firebase.components;

public interface ComponentFactory<T> {
    T a(ComponentContainer componentContainer);
}
