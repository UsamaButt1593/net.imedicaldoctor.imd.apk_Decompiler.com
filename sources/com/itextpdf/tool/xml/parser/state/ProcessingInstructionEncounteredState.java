package com.itextpdf.tool.xml.parser.state;

import com.itextpdf.tool.xml.parser.XMLParser;

public class ProcessingInstructionEncounteredState extends TagAttributeState {

    /* renamed from: b  reason: collision with root package name */
    protected String f27702b = null;

    public ProcessingInstructionEncounteredState(XMLParser xMLParser) {
        super(xMLParser);
    }

    public void a(char c2) {
        String f2 = this.f27707a.f();
        if (this.f27702b != null || !Character.isWhitespace(c2)) {
            if (Character.isWhitespace(c2)) {
                b();
            } else if (c2 == '?') {
                this.f27702b = null;
                b();
                this.f27707a.p();
                this.f27707a.y().l();
                return;
            } else {
                this.f27707a.b(c2);
                return;
            }
        } else if (Character.isWhitespace(c2)) {
            this.f27702b = f2;
            this.f27707a.r().e(this.f27702b);
        } else {
            if (c2 != '?') {
                return;
            }
            this.f27707a.p();
            this.f27707a.y().l();
            return;
        }
        this.f27707a.p();
    }
}
