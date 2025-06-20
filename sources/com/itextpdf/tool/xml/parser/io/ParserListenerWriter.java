package com.itextpdf.tool.xml.parser.io;

import com.itextpdf.tool.xml.parser.XMLParserListener;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

public class ParserListenerWriter implements XMLParserListener {

    /* renamed from: a  reason: collision with root package name */
    private final Appender f27688a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f27689b;

    public ParserListenerWriter(Appender appender) {
        this(appender, true);
    }

    public void a(String str) {
        this.f27688a.a(str);
    }

    public void b(String str) {
        this.f27688a.a("<!--").a(str).a("-->");
    }

    public void c(String str, String str2) {
        if (str2.length() > 0) {
            str2 = str2 + ":";
        }
        this.f27688a.a("</").a(str2).a(str).append('>');
        if (this.f27689b) {
            this.f27688a.append(13);
        }
    }

    public void close() {
    }

    public void d(String str) {
    }

    public void e() {
    }

    public void f(String str, Map<String, String> map, String str2) {
        Appender a2;
        if (str2.length() > 0) {
            str2 = str2 + ":";
        }
        if (map.size() > 0) {
            this.f27688a.a("<").a(str2).a(str).a(StringUtils.SPACE);
            for (Map.Entry next : map.entrySet()) {
                this.f27688a.a((String) next.getKey()).a("=\"").a((String) next.getValue()).a("\" ");
            }
            a2 = this.f27688a;
        } else {
            a2 = this.f27688a.append('<').a(str2).a(str);
        }
        a2.append('>');
    }

    public ParserListenerWriter(Appender appender, boolean z) {
        this.f27688a = appender;
        this.f27689b = z;
    }
}
