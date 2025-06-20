package com.itextpdf.text.html.simpleparser;

import com.itextpdf.text.html.HtmlUtilities;
import com.itextpdf.tool.xml.css.CSS;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Deprecated
public class ChainedProperties {

    /* renamed from: a  reason: collision with root package name */
    public List<TagAttributes> f25763a = new ArrayList();

    private static final class TagAttributes {

        /* renamed from: a  reason: collision with root package name */
        final String f25764a;

        /* renamed from: b  reason: collision with root package name */
        final Map<String, String> f25765b;

        TagAttributes(String str, Map<String, String> map) {
            this.f25764a = str;
            this.f25765b = map;
        }
    }

    public void a(String str, Map<String, String> map) {
        b(map);
        this.f25763a.add(new TagAttributes(str, map));
    }

    /* access modifiers changed from: protected */
    public void b(Map<String, String> map) {
        String str = map.get("size");
        if (str != null) {
            map.put("size", str.endsWith(CSS.Value.l0) ? str.substring(0, str.length() - 2) : Integer.toString(HtmlUtilities.d(str, c("size"))));
        }
    }

    public String c(String str) {
        for (int size = this.f25763a.size() - 1; size >= 0; size--) {
            String str2 = this.f25763a.get(size).f25765b.get(str);
            if (str2 != null) {
                return str2;
            }
        }
        return null;
    }

    public boolean d(String str) {
        for (int size = this.f25763a.size() - 1; size >= 0; size--) {
            if (this.f25763a.get(size).f25765b.containsKey(str)) {
                return true;
            }
        }
        return false;
    }

    public void e(String str) {
        for (int size = this.f25763a.size() - 1; size >= 0; size--) {
            if (str.equals(this.f25763a.get(size).f25764a)) {
                this.f25763a.remove(size);
                return;
            }
        }
    }
}
