package org.jsoup.nodes;

import java.io.IOException;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Document;

public class DocumentType extends Node {
    public static final String Z2 = "PUBLIC";
    public static final String a3 = "SYSTEM";
    private static final String b3 = "name";
    private static final String c3 = "pubSysKey";
    private static final String d3 = "publicId";
    private static final String e3 = "systemId";

    public DocumentType(String str, String str2, String str3, String str4) {
        super(str4);
        h("name", str);
        h(d3, str2);
        if (v0(d3)) {
            h(c3, Z2);
        }
        h(e3, str3);
    }

    private boolean v0(String str) {
        return !StringUtil.d(g(str));
    }

    public String F() {
        return "#doctype";
    }

    /* access modifiers changed from: package-private */
    public void L(Appendable appendable, int i2, Document.OutputSettings outputSettings) throws IOException {
        appendable.append((outputSettings.p() != Document.OutputSettings.Syntax.s || v0(d3) || v0(e3)) ? "<!DOCTYPE" : "<!doctype");
        if (v0("name")) {
            appendable.append(StringUtils.SPACE).append(g("name"));
        }
        if (v0(c3)) {
            appendable.append(StringUtils.SPACE).append(g(c3));
        }
        if (v0(d3)) {
            appendable.append(" \"").append(g(d3)).append('\"');
        }
        if (v0(e3)) {
            appendable.append(" \"").append(g(e3)).append('\"');
        }
        appendable.append('>');
    }

    /* access modifiers changed from: package-private */
    public void M(Appendable appendable, int i2, Document.OutputSettings outputSettings) {
    }

    public DocumentType(String str, String str2, String str3, String str4, String str5) {
        super(str5);
        h("name", str);
        if (str2 != null) {
            h(c3, str2);
        }
        h(d3, str3);
        h(e3, str4);
    }
}
