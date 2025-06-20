package com.itextpdf.tool.xml.pipeline;

import com.itextpdf.text.Element;
import com.itextpdf.tool.xml.Writable;
import java.util.ArrayList;
import java.util.List;

public class WritableElement implements Writable {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<Element> f27713a;

    public WritableElement() {
        this.f27713a = new ArrayList<>();
    }

    public void a(Element element) {
        this.f27713a.add(element);
    }

    public void b(List<Element> list) {
        this.f27713a.addAll(list);
    }

    public List<Element> c() {
        return this.f27713a;
    }

    public WritableElement(Element element) {
        this();
        this.f27713a.add(element);
    }
}
