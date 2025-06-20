package com.itextpdf.tool.xml.parser.state;

import com.itextpdf.tool.xml.parser.State;
import com.itextpdf.tool.xml.parser.XMLParser;

public class TagEncounteredState implements State {

    /* renamed from: a  reason: collision with root package name */
    private final XMLParser f27708a;

    public TagEncounteredState(XMLParser xMLParser) {
        this.f27708a = xMLParser;
    }

    public void a(char c2) {
        String f2 = this.f27708a.f();
        if (Character.isWhitespace(c2) || c2 == '>' || c2 == '/' || c2 == ':' || c2 == '?' || f2.equals("!--") || (f2.equals("![CDATA") && c2 == '[')) {
            if (f2.length() > 0) {
                if (f2.equals("!--")) {
                    this.f27708a.p();
                    this.f27708a.r().a().setLength(0);
                    this.f27708a.y().f();
                    if (c2 == '-') {
                        this.f27708a.r().a().append(c2);
                        return;
                    }
                } else if (f2.equals("![CDATA") && c2 == '[') {
                    this.f27708a.p();
                    this.f27708a.y().b();
                    return;
                } else if (f2.equals("!DOCTYPE")) {
                    this.f27708a.p();
                    this.f27708a.y().g();
                } else if (Character.isWhitespace(c2)) {
                    this.f27708a.r().e(this.f27708a.f());
                    this.f27708a.p();
                    this.f27708a.y().q();
                    return;
                } else if (c2 == '>') {
                    this.f27708a.r().e(f2);
                    this.f27708a.p();
                    this.f27708a.B();
                    this.f27708a.y().i();
                    return;
                } else if (c2 == '/') {
                    this.f27708a.r().e(f2);
                    this.f27708a.p();
                    this.f27708a.y().l();
                    return;
                } else if (c2 == ':') {
                    this.f27708a.r().n(f2);
                    this.f27708a.p();
                    return;
                } else {
                    return;
                }
            } else if (c2 == '/') {
                this.f27708a.y().e();
                return;
            } else if (c2 == '?') {
                this.f27708a.b(c2);
                this.f27708a.y().k();
                return;
            } else {
                return;
            }
        }
        this.f27708a.b(c2);
    }
}
