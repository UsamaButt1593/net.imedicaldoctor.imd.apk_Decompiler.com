package com.itextpdf.tool.xml.pipeline.ctx;

import com.itextpdf.tool.xml.CustomContext;

public class ObjectContext<T> implements CustomContext {
    private T s;

    public ObjectContext(T t) {
        this.s = t;
    }

    public T a() {
        return this.s;
    }
}
