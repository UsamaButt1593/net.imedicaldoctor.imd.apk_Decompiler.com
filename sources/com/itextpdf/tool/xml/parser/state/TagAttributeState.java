package com.itextpdf.tool.xml.parser.state;

import com.itextpdf.tool.xml.parser.State;
import com.itextpdf.tool.xml.parser.XMLParser;

public class TagAttributeState implements State {

    /* renamed from: a  reason: collision with root package name */
    protected final XMLParser f27707a;

    public TagAttributeState(XMLParser xMLParser) {
        this.f27707a = xMLParser;
    }

    public void a(char c2) {
        if (c2 == '/') {
            this.f27707a.y().l();
        } else if (c2 == '=') {
            this.f27707a.r().c(this.f27707a.f());
            this.f27707a.p();
            this.f27707a.y().a();
        } else if (Character.isWhitespace(c2)) {
            c();
        } else if (c2 == '>') {
            b();
            this.f27707a.B();
            this.f27707a.p();
            this.f27707a.y().i();
        } else {
            if (this.f27707a.r().k() && !Character.isWhitespace(c2)) {
                this.f27707a.r().o("");
            }
            this.f27707a.b(c2);
        }
    }

    /* access modifiers changed from: protected */
    public void b() {
        if (c()) {
            this.f27707a.r().o("");
        }
    }

    /* access modifiers changed from: protected */
    public boolean c() {
        String f2 = this.f27707a.f();
        if (f2.length() <= 0) {
            return false;
        }
        this.f27707a.r().c(f2);
        this.f27707a.p();
        return true;
    }
}
