package com.itextpdf.tool.xml.css;

import com.itextpdf.tool.xml.css.parser.CssStateController;
import com.itextpdf.tool.xml.net.ReadingProcessor;

public class CssFileProcessor implements ReadingProcessor {

    /* renamed from: a  reason: collision with root package name */
    private final CssFile f27490a;

    /* renamed from: b  reason: collision with root package name */
    private final CssStateController f27491b;

    public CssFileProcessor() {
        CssFileImpl cssFileImpl = new CssFileImpl();
        this.f27490a = cssFileImpl;
        this.f27491b = new CssStateController(cssFileImpl);
    }

    public void a(int i2) {
        this.f27491b.c((char) i2);
    }

    public CssFile b() {
        return this.f27490a;
    }
}
