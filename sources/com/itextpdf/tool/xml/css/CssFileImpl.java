package com.itextpdf.tool.xml.css;

import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.css.parser.CssSelectorParser;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CssFileImpl implements CssFile {

    /* renamed from: a  reason: collision with root package name */
    private final List<CssRule> f27488a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private boolean f27489b = false;

    public List<CssRule> a(Tag tag) {
        ArrayList arrayList = new ArrayList();
        for (CssRule next : this.f27488a) {
            if (next.e().b(tag)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public void b(boolean z) {
        this.f27489b = z;
    }

    public boolean c(String str, Map<String, String> map) {
        List<CssSelectorItem> a2 = CssSelectorParser.a(str);
        if (a2 == null) {
            return false;
        }
        this.f27488a.add(new CssRule(a2, map));
        return true;
    }

    public boolean d() {
        return this.f27489b;
    }
}
