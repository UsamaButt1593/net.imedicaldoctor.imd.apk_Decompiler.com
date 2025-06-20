package com.itextpdf.tool.xml.parser.state;

import com.dd.plist.ASCIIPropertyListParser;
import com.itextpdf.text.xml.simpleparser.EntitiesToUnicode;
import com.itextpdf.tool.xml.parser.State;
import com.itextpdf.tool.xml.parser.XMLParser;
import kotlin.text.Typography;

public class SpecialCharState implements State {

    /* renamed from: a  reason: collision with root package name */
    private final XMLParser f27705a;

    public SpecialCharState(XMLParser xMLParser) {
        this.f27705a = xMLParser;
    }

    public void a(char c2) {
        StringBuilder d2 = this.f27705a.r().d();
        if (c2 == ';') {
            char a2 = EntitiesToUnicode.a(d2.toString());
            if (a2 == 0) {
                this.f27705a.b(Typography.f29117d).c(d2.toString()).b(ASCIIPropertyListParser.f18655m);
                this.f27705a.r().m(ASCIIPropertyListParser.f18655m);
            } else {
                this.f27705a.c(Character.toString(a2));
                this.f27705a.r().m(a2);
            }
        } else if ((c2 == '#' || ((c2 >= '0' && c2 <= '9') || ((c2 >= 'a' && c2 <= 'z') || (c2 >= 'A' && c2 <= 'Z')))) && d2.length() < 7) {
            d2.append(c2);
            return;
        } else {
            this.f27705a.b(Typography.f29117d).c(d2.toString()).b(c2);
        }
        this.f27705a.y().j();
        this.f27705a.r().d().setLength(0);
    }
}
