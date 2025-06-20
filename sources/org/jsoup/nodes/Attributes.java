package org.jsoup.nodes;

import java.io.IOException;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.SerializationException;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;

public class Attributes implements Iterable<Attribute>, Cloneable {
    protected static final String X = "data-";
    /* access modifiers changed from: private */
    public LinkedHashMap<String, Attribute> s = null;

    private class Dataset extends AbstractMap<String, String> {

        private class DatasetIterator implements Iterator<Map.Entry<String, String>> {
            private Attribute X;
            private Iterator<Attribute> s;

            private DatasetIterator() {
                this.s = Attributes.this.s.values().iterator();
            }

            /* renamed from: a */
            public Map.Entry<String, String> next() {
                return new Attribute(this.X.getKey().substring(5), this.X.getValue());
            }

            public boolean hasNext() {
                while (this.s.hasNext()) {
                    Attribute next = this.s.next();
                    this.X = next;
                    if (next.h()) {
                        return true;
                    }
                }
                return false;
            }

            public void remove() {
                Attributes.this.s.remove(this.X.getKey());
            }
        }

        private class EntrySet extends AbstractSet<Map.Entry<String, String>> {
            private EntrySet() {
            }

            public Iterator<Map.Entry<String, String>> iterator() {
                return new DatasetIterator();
            }

            public int size() {
                int i2 = 0;
                while (new DatasetIterator().hasNext()) {
                    i2++;
                }
                return i2;
            }
        }

        private Dataset() {
            if (Attributes.this.s == null) {
                LinkedHashMap unused = Attributes.this.s = new LinkedHashMap(2);
            }
        }

        /* renamed from: a */
        public String put(String str, String str2) {
            String d2 = Attributes.n(str);
            String d3 = Attributes.this.t(d2) ? ((Attribute) Attributes.this.s.get(d2)).getValue() : null;
            Attributes.this.s.put(d2, new Attribute(d2, str2));
            return d3;
        }

        public Set<Map.Entry<String, String>> entrySet() {
            return new EntrySet();
        }
    }

    /* access modifiers changed from: private */
    public static String n(String str) {
        return X + str;
    }

    /* access modifiers changed from: package-private */
    public void B(Appendable appendable, Document.OutputSettings outputSettings) throws IOException {
        LinkedHashMap<String, Attribute> linkedHashMap = this.s;
        if (linkedHashMap != null) {
            for (Map.Entry<String, Attribute> value : linkedHashMap.entrySet()) {
                appendable.append(StringUtils.SPACE);
                ((Attribute) value.getValue()).f(appendable, outputSettings);
            }
        }
    }

    public void D(String str, String str2) {
        G(new Attribute(str, str2));
    }

    public void E(String str, boolean z) {
        if (z) {
            G(new BooleanAttribute(str));
        } else {
            K(str);
        }
    }

    public void G(Attribute attribute) {
        Validate.j(attribute);
        if (this.s == null) {
            this.s = new LinkedHashMap<>(2);
        }
        this.s.put(attribute.getKey(), attribute);
    }

    public void K(String str) {
        Validate.h(str);
        LinkedHashMap<String, Attribute> linkedHashMap = this.s;
        if (linkedHashMap != null) {
            linkedHashMap.remove(str);
        }
    }

    public void L(String str) {
        Validate.h(str);
        LinkedHashMap<String, Attribute> linkedHashMap = this.s;
        if (linkedHashMap != null) {
            Iterator<String> it2 = linkedHashMap.keySet().iterator();
            while (it2.hasNext()) {
                if (it2.next().equalsIgnoreCase(str)) {
                    it2.remove();
                }
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Attributes)) {
            return false;
        }
        LinkedHashMap<String, Attribute> linkedHashMap = this.s;
        LinkedHashMap<String, Attribute> linkedHashMap2 = ((Attributes) obj).s;
        if (linkedHashMap != null) {
            return linkedHashMap.equals(linkedHashMap2);
        }
        if (linkedHashMap2 == null) {
            return true;
        }
    }

    public void g(Attributes attributes) {
        if (attributes.size() != 0) {
            if (this.s == null) {
                this.s = new LinkedHashMap<>(attributes.size());
            }
            this.s.putAll(attributes.s);
        }
    }

    public List<Attribute> h() {
        if (this.s == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(this.s.size());
        for (Map.Entry<String, Attribute> value : this.s.entrySet()) {
            arrayList.add(value.getValue());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public int hashCode() {
        LinkedHashMap<String, Attribute> linkedHashMap = this.s;
        if (linkedHashMap != null) {
            return linkedHashMap.hashCode();
        }
        return 0;
    }

    public Iterator<Attribute> iterator() {
        LinkedHashMap<String, Attribute> linkedHashMap = this.s;
        return (linkedHashMap == null || linkedHashMap.isEmpty()) ? Collections.emptyList().iterator() : this.s.values().iterator();
    }

    /* renamed from: m */
    public Attributes clone() {
        if (this.s == null) {
            return new Attributes();
        }
        try {
            Attributes attributes = (Attributes) super.clone();
            attributes.s = new LinkedHashMap<>(this.s.size());
            Iterator<Attribute> it2 = iterator();
            while (it2.hasNext()) {
                Attribute next = it2.next();
                attributes.s.put(next.getKey(), next.clone());
            }
            return attributes;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    public Map<String, String> o() {
        return new Dataset();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000a, code lost:
        r3 = r0.get(r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String q(java.lang.String r3) {
        /*
            r2 = this;
            org.jsoup.helper.Validate.h(r3)
            java.util.LinkedHashMap<java.lang.String, org.jsoup.nodes.Attribute> r0 = r2.s
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            java.lang.Object r3 = r0.get(r3)
            org.jsoup.nodes.Attribute r3 = (org.jsoup.nodes.Attribute) r3
            if (r3 == 0) goto L_0x0016
            java.lang.String r1 = r3.getValue()
        L_0x0016:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.nodes.Attributes.q(java.lang.String):java.lang.String");
    }

    public String r(String str) {
        Validate.h(str);
        LinkedHashMap<String, Attribute> linkedHashMap = this.s;
        if (linkedHashMap == null) {
            return "";
        }
        Attribute attribute = linkedHashMap.get(str);
        if (attribute != null) {
            return attribute.getValue();
        }
        for (String next : this.s.keySet()) {
            if (next.equalsIgnoreCase(str)) {
                return this.s.get(next).getValue();
            }
        }
        return "";
    }

    public int size() {
        LinkedHashMap<String, Attribute> linkedHashMap = this.s;
        if (linkedHashMap == null) {
            return 0;
        }
        return linkedHashMap.size();
    }

    public boolean t(String str) {
        LinkedHashMap<String, Attribute> linkedHashMap = this.s;
        return linkedHashMap != null && linkedHashMap.containsKey(str);
    }

    public String toString() {
        return z();
    }

    public boolean x(String str) {
        LinkedHashMap<String, Attribute> linkedHashMap = this.s;
        if (linkedHashMap == null) {
            return false;
        }
        for (String equalsIgnoreCase : linkedHashMap.keySet()) {
            if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public String z() {
        StringBuilder sb = new StringBuilder();
        try {
            B(sb, new Document("").z3());
            return sb.toString();
        } catch (IOException e2) {
            throw new SerializationException((Throwable) e2);
        }
    }
}
