package com.itextpdf.tool.xml.css;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class CssRule implements Comparable<CssRule> {
    private static final Pattern Z = Pattern.compile(".*!\\s*important$");
    private Map<String, String> X;
    private Map<String, String> Y = new LinkedHashMap();
    private CssSelector s;

    public CssRule(List<CssSelectorItem> list, Map<String, String> map) {
        this.s = new CssSelector(list);
        this.X = map;
        for (Map.Entry next : this.X.entrySet()) {
            int indexOf = ((String) next.getValue()).indexOf(33);
            if (indexOf > 0 && Z.matcher((CharSequence) next.getValue()).matches()) {
                this.Y.put(next.getKey(), ((String) next.getValue()).substring(0, indexOf).trim());
            }
        }
        for (String remove : this.Y.keySet()) {
            this.X.remove(remove);
        }
    }

    /* renamed from: a */
    public int compareTo(CssRule cssRule) {
        return this.s.a() - cssRule.s.a();
    }

    public Map<String, String> b() {
        return this.Y;
    }

    public Map<String, String> c() {
        return this.X;
    }

    public CssSelector e() {
        return this.s;
    }

    public String toString() {
        return String.format("%s { count: %d } #spec:%d", new Object[]{this.s.toString(), Integer.valueOf(this.X.size() + this.Y.size()), Integer.valueOf(this.s.a())});
    }
}
