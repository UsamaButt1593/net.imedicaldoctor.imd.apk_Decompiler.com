package org.jsoup.nodes;

import com.itextpdf.tool.xml.css.CSS;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.jsoup.SerializationException;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;

public class Attribute implements Map.Entry<String, String>, Cloneable {
    private static final String[] Y = {"allowfullscreen", "async", "autofocus", "checked", "compact", "declare", CookiePolicy.DEFAULT, "defer", "disabled", "formnovalidate", CSS.Value.f27476e, "inert", "ismap", "itemscope", "multiple", "muted", "nohref", "noresize", "noshade", "novalidate", "nowrap", TtmlNode.B0, "readonly", "required", "reversed", "seamless", "selected", "sortable", "truespeed", "typemustmatch"};
    private String X;
    private String s;

    public Attribute(String str, String str2) {
        Validate.j(str);
        Validate.j(str2);
        this.s = str.trim();
        Validate.h(str);
        this.X = str2;
    }

    public static Attribute b(String str, String str2) {
        return new Attribute(str, Entities.m(str2, true));
    }

    /* renamed from: a */
    public Attribute clone() {
        try {
            return (Attribute) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* renamed from: c */
    public String getKey() {
        return this.s;
    }

    /* renamed from: d */
    public String getValue() {
        return this.X;
    }

    public String e() {
        StringBuilder sb = new StringBuilder();
        try {
            f(sb, new Document("").z3());
            return sb.toString();
        } catch (IOException e2) {
            throw new SerializationException((Throwable) e2);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Attribute)) {
            return false;
        }
        Attribute attribute = (Attribute) obj;
        String str = this.s;
        if (str == null ? attribute.s != null : !str.equals(attribute.s)) {
            return false;
        }
        String str2 = this.X;
        String str3 = attribute.X;
        if (str2 != null) {
            return str2.equals(str3);
        }
        if (str3 == null) {
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void f(Appendable appendable, Document.OutputSettings outputSettings) throws IOException {
        appendable.append(this.s);
        if (!m(outputSettings)) {
            appendable.append("=\"");
            Entities.f(appendable, this.X, outputSettings, true, false, false);
            appendable.append('\"');
        }
    }

    /* access modifiers changed from: protected */
    public boolean g() {
        return Arrays.binarySearch(Y, this.s) >= 0;
    }

    /* access modifiers changed from: protected */
    public boolean h() {
        return this.s.startsWith("data-") && this.s.length() > 5;
    }

    public int hashCode() {
        String str = this.s;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.X;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public void i(String str) {
        Validate.h(str);
        this.s = str.trim();
    }

    /* renamed from: l */
    public String setValue(String str) {
        Validate.j(str);
        String str2 = this.X;
        this.X = str;
        return str2;
    }

    /* access modifiers changed from: protected */
    public final boolean m(Document.OutputSettings outputSettings) {
        return ("".equals(this.X) || this.X.equalsIgnoreCase(this.s)) && outputSettings.p() == Document.OutputSettings.Syntax.s && g();
    }

    public String toString() {
        return e();
    }
}
