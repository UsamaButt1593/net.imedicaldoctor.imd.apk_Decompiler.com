package com.itextpdf.tool.xml;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Tag implements Iterable<Tag> {
    private final String X;
    private final List<Tag> X2;
    private final Map<String, String> Y;
    private final String Y2;
    private Map<String, String> Z;
    private Object Z2;
    private Tag s;

    public Tag(String str) {
        this(str, new LinkedHashMap(0), new LinkedHashMap(0), "");
    }

    private Tag D(Tag tag, String str, String str2, boolean z) {
        Tag D;
        Iterator<Tag> it2 = tag.iterator();
        while (it2.hasNext()) {
            Tag next = it2.next();
            if (next.X.equals(str) && next.Y2.equals(str2)) {
                return next;
            }
            if (z && (D = D(next, str, str2, z)) != null) {
                return D;
            }
        }
        return null;
    }

    private boolean E(Tag tag, String str, String str2, boolean z) {
        Iterator<Tag> it2 = tag.iterator();
        while (it2.hasNext()) {
            Tag next = it2.next();
            if (next.X.equals(str) && next.Y2.equals(str2)) {
                return true;
            }
            if (z && E(next, str, str2, z)) {
                return true;
            }
        }
        return false;
    }

    public boolean B() {
        return k().size() != 0;
    }

    public boolean C() {
        return r() != null;
    }

    public void G(Map<String, String> map) {
        if (map != null) {
            this.Z = map;
        } else {
            this.Z.clear();
        }
    }

    public void H(Object obj) {
        this.Z2 = obj;
    }

    public void I(Tag tag) {
        this.s = tag;
    }

    public void b(Tag tag) {
        tag.I(this);
        this.X2.add(tag);
    }

    public boolean c(Tag tag) {
        if (this == tag) {
            return true;
        }
        if (tag == null) {
            return false;
        }
        String str = this.Y2;
        if (str == null) {
            if (tag.Y2 != null) {
                return false;
            }
        } else if (!str.equals(tag.Y2)) {
            return false;
        }
        String str2 = this.X;
        String str3 = tag.X;
        if (str2 == null) {
            if (str3 != null) {
                return false;
            }
        } else if (!str2.equals(str3)) {
            return false;
        }
        return true;
    }

    public Map<String, String> d() {
        return this.Y;
    }

    public Map<String, String> g() {
        return this.Z;
    }

    public Tag h(String str, String str2) {
        return j(str, str2, false);
    }

    public Iterator<Tag> iterator() {
        return this.X2.iterator();
    }

    public Tag j(String str, String str2, boolean z) {
        return D(this, str, str2, z);
    }

    public List<Tag> k() {
        return this.X2;
    }

    public List<Tag> m(String str) {
        LinkedList linkedList = new LinkedList();
        for (Tag next : this.X2) {
            if (next.o().equals(str)) {
                linkedList.add(next);
            }
        }
        return linkedList;
    }

    public Object n() {
        return this.Z2;
    }

    public String o() {
        return this.X;
    }

    public String q() {
        return this.Y2;
    }

    public Tag r() {
        return this.s;
    }

    @Deprecated
    public String t() {
        return this.X;
    }

    public String toString() {
        if ("".equalsIgnoreCase(this.Y2)) {
            return String.format("%s", new Object[]{this.X});
        }
        return String.format("%s:%s", new Object[]{this.Y2, this.X});
    }

    public boolean x(String str, String str2) {
        return z(str, str2, false);
    }

    public boolean z(String str, String str2, boolean z) {
        return E(this, str, str2, z);
    }

    public Tag(String str, String str2) {
        this(str, new LinkedHashMap(0), new LinkedHashMap(0), str2);
    }

    public Tag(String str, Map<String, String> map) {
        this(str, map, new LinkedHashMap(0), "");
    }

    public Tag(String str, Map<String, String> map, String str2) {
        this(str, map, new LinkedHashMap(0), str2);
    }

    public Tag(String str, Map<String, String> map, Map<String, String> map2, String str2) {
        this.Z2 = null;
        this.X = str;
        this.Y = map;
        this.Z = map2;
        this.X2 = new LinkedList();
        if (str2 != null) {
            this.Y2 = str2;
            return;
        }
        throw new NullPointerException("NS cannot be null");
    }
}
