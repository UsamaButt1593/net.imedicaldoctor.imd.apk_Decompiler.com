package com.itextpdf.tool.xml.pipeline.ctx;

import com.itextpdf.tool.xml.CustomContext;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapContext implements CustomContext {
    private final Map<String, Object> s = new ConcurrentHashMap();

    public Object a(String str) {
        return this.s.get(str);
    }

    public void b(String str, Object obj) {
        this.s.put(str, obj);
    }
}
