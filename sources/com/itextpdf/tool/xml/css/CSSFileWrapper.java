package com.itextpdf.tool.xml.css;

import com.itextpdf.tool.xml.Tag;
import java.util.List;
import java.util.Map;

public class CSSFileWrapper implements CssFile {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f27486a;

    /* renamed from: b  reason: collision with root package name */
    private final CssFile f27487b;

    public CSSFileWrapper(CssFile cssFile, boolean z) {
        this.f27487b = cssFile;
        this.f27486a = z;
    }

    public List<CssRule> a(Tag tag) {
        return this.f27487b.a(tag);
    }

    public void b(boolean z) {
        throw new UnsupportedOperationException();
    }

    public boolean c(String str, Map<String, String> map) {
        throw new UnsupportedOperationException();
    }

    public boolean d() {
        return this.f27486a;
    }
}
