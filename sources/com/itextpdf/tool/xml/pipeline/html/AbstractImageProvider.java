package com.itextpdf.tool.xml.pipeline.html;

import com.itextpdf.text.Image;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractImageProvider implements ImageProvider {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, Image> f27726a = new ConcurrentHashMap();

    public void a(String str, Image image) {
        this.f27726a.put(str, image);
    }

    public Image c(String str) {
        return this.f27726a.get(str);
    }

    public void reset() {
        this.f27726a.clear();
    }
}
