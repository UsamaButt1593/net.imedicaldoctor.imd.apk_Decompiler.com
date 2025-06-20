package com.itextpdf.tool.xml.pipeline.html;

import com.itextpdf.text.Element;
import com.itextpdf.tool.xml.Tag;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StackKeeper {

    /* renamed from: a  reason: collision with root package name */
    private final Tag f27732a;

    /* renamed from: b  reason: collision with root package name */
    private final List<Element> f27733b = new ArrayList();

    public StackKeeper(Tag tag) {
        this.f27732a = tag;
    }

    public void a(Element element) {
        this.f27733b.add(element);
    }

    public void b(Collection<? extends Element> collection) {
        for (Element add : collection) {
            this.f27733b.add(add);
        }
    }

    public List<Element> c() {
        return this.f27733b;
    }

    public Tag d() {
        return this.f27732a;
    }
}
