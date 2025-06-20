package org.jsoup.safety;

import com.itextpdf.tool.xml.html.HTML;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.jsoup.helper.Validate;
import org.jsoup.internal.Normalizer;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Element;

public class Whitelist {

    /* renamed from: a  reason: collision with root package name */
    private Set<TagName> f31726a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    private Map<TagName, Set<AttributeKey>> f31727b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private Map<TagName, Map<AttributeKey, AttributeValue>> f31728c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private Map<TagName, Map<AttributeKey, Set<Protocol>>> f31729d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private boolean f31730e = false;

    static class AttributeKey extends TypedValue {
        AttributeKey(String str) {
            super(str);
        }

        static AttributeKey a(String str) {
            return new AttributeKey(str);
        }
    }

    static class AttributeValue extends TypedValue {
        AttributeValue(String str) {
            super(str);
        }

        static AttributeValue a(String str) {
            return new AttributeValue(str);
        }
    }

    static class Protocol extends TypedValue {
        Protocol(String str) {
            super(str);
        }

        static Protocol a(String str) {
            return new Protocol(str);
        }
    }

    static class TagName extends TypedValue {
        TagName(String str) {
            super(str);
        }

        static TagName a(String str) {
            return new TagName(str);
        }
    }

    static abstract class TypedValue {

        /* renamed from: a  reason: collision with root package name */
        private String f31731a;

        TypedValue(String str) {
            Validate.j(str);
            this.f31731a = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            String str = this.f31731a;
            String str2 = ((TypedValue) obj).f31731a;
            if (str == null) {
                if (str2 != null) {
                    return false;
                }
            } else if (!str.equals(str2)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            String str = this.f31731a;
            return 31 + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return this.f31731a;
        }
    }

    public static Whitelist e() {
        return new Whitelist().d("a", "b", "blockquote", "br", HTML.Tag.l0, HTML.Tag.g0, HTML.Tag.t, "dl", HTML.Tag.u, "em", "i", "li", "ol", "p", "pre", HTML.Tag.C0, "small", "span", "strike", "strong", "sub", "sup", "u", "ul").a("a", "href").a("blockquote", HTML.Tag.l0).a(HTML.Tag.C0, HTML.Tag.l0).c("a", "href", "ftp", "http", "https", "mailto").c("blockquote", HTML.Tag.l0, "http", "https").c(HTML.Tag.l0, HTML.Tag.l0, "http", "https").b("a", "rel", "nofollow");
    }

    public static Whitelist f() {
        return e().d("img").a("img", "align", HTML.Attribute.f27590a, "height", "src", "title", "width").c("img", "src", "http", "https");
    }

    private boolean j(String str) {
        return str.startsWith("#") && !str.matches(".*\\s.*");
    }

    public static Whitelist k() {
        return new Whitelist();
    }

    public static Whitelist m() {
        return new Whitelist().d("a", "b", "blockquote", "br", HTML.Tag.f27619g, HTML.Tag.l0, HTML.Tag.g0, "col", "colgroup", HTML.Tag.t, "div", "dl", HTML.Tag.u, "em", "h1", "h2", "h3", "h4", "h5", "h6", "i", "img", "li", "ol", "p", "pre", HTML.Tag.C0, "small", "span", "strike", "strong", "sub", "sup", "table", HTML.Tag.f27615c, "td", HTML.Tag.f27616d, "th", HTML.Tag.f27614b, "tr", "u", "ul").a("a", "href", "title").a("blockquote", HTML.Tag.l0).a("col", "span", "width").a("colgroup", "span", "width").a("img", "align", HTML.Attribute.f27590a, "height", "src", "title", "width").a("ol", "start", "type").a(HTML.Tag.C0, HTML.Tag.l0).a("table", "summary", "width").a("td", HTML.Tag.b0, "axis", "colspan", "rowspan", "width").a("th", HTML.Tag.b0, "axis", "colspan", "rowspan", "scope", "width").a("ul", "type").c("a", "href", "ftp", "http", "https", "mailto").c("blockquote", HTML.Tag.l0, "http", "https").c(HTML.Tag.l0, HTML.Tag.l0, "http", "https").c("img", "src", "http", "https").c(HTML.Tag.C0, HTML.Tag.l0, "http", "https");
    }

    public static Whitelist r() {
        return new Whitelist().d("b", "em", "i", "strong", "u");
    }

    private boolean s(Element element, Attribute attribute, Set<Protocol> set) {
        String a2 = element.a(attribute.getKey());
        if (a2.length() == 0) {
            a2 = attribute.getValue();
        }
        if (!this.f31730e) {
            attribute.setValue(a2);
        }
        for (Protocol typedValue : set) {
            String typedValue2 = typedValue.toString();
            if (!typedValue2.equals("#")) {
                if (Normalizer.a(a2).startsWith(typedValue2 + ":")) {
                    return true;
                }
            } else if (j(a2)) {
                return true;
            }
        }
        return false;
    }

    public Whitelist a(String str, String... strArr) {
        Validate.h(str);
        Validate.j(strArr);
        Validate.e(strArr.length > 0, "No attribute names supplied.");
        TagName a2 = TagName.a(str);
        if (!this.f31726a.contains(a2)) {
            this.f31726a.add(a2);
        }
        HashSet hashSet = new HashSet();
        for (String str2 : strArr) {
            Validate.h(str2);
            hashSet.add(AttributeKey.a(str2));
        }
        if (this.f31727b.containsKey(a2)) {
            this.f31727b.get(a2).addAll(hashSet);
        } else {
            this.f31727b.put(a2, hashSet);
        }
        return this;
    }

    public Whitelist b(String str, String str2, String str3) {
        Validate.h(str);
        Validate.h(str2);
        Validate.h(str3);
        TagName a2 = TagName.a(str);
        if (!this.f31726a.contains(a2)) {
            this.f31726a.add(a2);
        }
        AttributeKey a3 = AttributeKey.a(str2);
        AttributeValue a4 = AttributeValue.a(str3);
        if (this.f31728c.containsKey(a2)) {
            this.f31728c.get(a2).put(a3, a4);
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put(a3, a4);
            this.f31728c.put(a2, hashMap);
        }
        return this;
    }

    public Whitelist c(String str, String str2, String... strArr) {
        Map map;
        Set set;
        Validate.h(str);
        Validate.h(str2);
        Validate.j(strArr);
        TagName a2 = TagName.a(str);
        AttributeKey a3 = AttributeKey.a(str2);
        if (this.f31729d.containsKey(a2)) {
            map = this.f31729d.get(a2);
        } else {
            HashMap hashMap = new HashMap();
            this.f31729d.put(a2, hashMap);
            map = hashMap;
        }
        if (map.containsKey(a3)) {
            set = (Set) map.get(a3);
        } else {
            HashSet hashSet = new HashSet();
            map.put(a3, hashSet);
            set = hashSet;
        }
        for (String str3 : strArr) {
            Validate.h(str3);
            set.add(Protocol.a(str3));
        }
        return this;
    }

    public Whitelist d(String... strArr) {
        Validate.j(strArr);
        for (String str : strArr) {
            Validate.h(str);
            this.f31726a.add(TagName.a(str));
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public Attributes g(String str) {
        Attributes attributes = new Attributes();
        TagName a2 = TagName.a(str);
        if (this.f31728c.containsKey(a2)) {
            for (Map.Entry entry : this.f31728c.get(a2).entrySet()) {
                attributes.D(((AttributeKey) entry.getKey()).toString(), ((AttributeValue) entry.getValue()).toString());
            }
        }
        return attributes;
    }

    /* access modifiers changed from: protected */
    public boolean h(String str, Element element, Attribute attribute) {
        TagName a2 = TagName.a(str);
        AttributeKey a3 = AttributeKey.a(attribute.getKey());
        Set set = this.f31727b.get(a2);
        if (set == null || !set.contains(a3)) {
            if (this.f31728c.get(a2) != null) {
                Attributes g2 = g(str);
                String c2 = attribute.getKey();
                if (g2.x(c2)) {
                    return g2.r(c2).equals(attribute.getValue());
                }
            }
            return !str.equals(":all") && h(":all", element, attribute);
        } else if (!this.f31729d.containsKey(a2)) {
            return true;
        } else {
            Map map = this.f31729d.get(a2);
            return !map.containsKey(a3) || s(element, attribute, (Set) map.get(a3));
        }
    }

    /* access modifiers changed from: protected */
    public boolean i(String str) {
        return this.f31726a.contains(TagName.a(str));
    }

    public Whitelist l(boolean z) {
        this.f31730e = z;
        return this;
    }

    public Whitelist n(String str, String... strArr) {
        Validate.h(str);
        Validate.j(strArr);
        Validate.e(strArr.length > 0, "No attribute names supplied.");
        TagName a2 = TagName.a(str);
        HashSet hashSet = new HashSet();
        for (String str2 : strArr) {
            Validate.h(str2);
            hashSet.add(AttributeKey.a(str2));
        }
        if (this.f31726a.contains(a2) && this.f31727b.containsKey(a2)) {
            Set set = this.f31727b.get(a2);
            set.removeAll(hashSet);
            if (set.isEmpty()) {
                this.f31727b.remove(a2);
            }
        }
        if (str.equals(":all")) {
            for (TagName next : this.f31727b.keySet()) {
                Set set2 = this.f31727b.get(next);
                set2.removeAll(hashSet);
                if (set2.isEmpty()) {
                    this.f31727b.remove(next);
                }
            }
        }
        return this;
    }

    public Whitelist o(String str, String str2) {
        Validate.h(str);
        Validate.h(str2);
        TagName a2 = TagName.a(str);
        if (this.f31726a.contains(a2) && this.f31728c.containsKey(a2)) {
            AttributeKey a3 = AttributeKey.a(str2);
            Map map = this.f31728c.get(a2);
            map.remove(a3);
            if (map.isEmpty()) {
                this.f31728c.remove(a2);
            }
        }
        return this;
    }

    public Whitelist p(String str, String str2, String... strArr) {
        Validate.h(str);
        Validate.h(str2);
        Validate.j(strArr);
        TagName a2 = TagName.a(str);
        AttributeKey a3 = AttributeKey.a(str2);
        Validate.e(this.f31729d.containsKey(a2), "Cannot remove a protocol that is not set.");
        Map map = this.f31729d.get(a2);
        Validate.e(map.containsKey(a3), "Cannot remove a protocol that is not set.");
        Set set = (Set) map.get(a3);
        for (String str3 : strArr) {
            Validate.h(str3);
            set.remove(Protocol.a(str3));
        }
        if (set.isEmpty()) {
            map.remove(a3);
            if (map.isEmpty()) {
                this.f31729d.remove(a2);
            }
        }
        return this;
    }

    public Whitelist q(String... strArr) {
        Validate.j(strArr);
        for (String str : strArr) {
            Validate.h(str);
            TagName a2 = TagName.a(str);
            if (this.f31726a.remove(a2)) {
                this.f31727b.remove(a2);
                this.f31728c.remove(a2);
                this.f31729d.remove(a2);
            }
        }
        return this;
    }
}
