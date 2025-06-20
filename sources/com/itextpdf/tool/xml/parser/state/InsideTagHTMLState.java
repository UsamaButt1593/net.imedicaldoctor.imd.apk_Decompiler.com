package com.itextpdf.tool.xml.parser.state;

import com.itextpdf.tool.xml.html.HTML;
import com.itextpdf.tool.xml.parser.State;
import com.itextpdf.tool.xml.parser.TagState;
import com.itextpdf.tool.xml.parser.XMLParser;
import java.util.ArrayList;
import java.util.List;

public class InsideTagHTMLState implements State {

    /* renamed from: a  reason: collision with root package name */
    private final XMLParser f27698a;

    /* renamed from: b  reason: collision with root package name */
    private final List<String> f27699b;

    /* renamed from: c  reason: collision with root package name */
    private final List<String> f27700c;

    public InsideTagHTMLState(XMLParser xMLParser) {
        ArrayList arrayList = new ArrayList(1);
        this.f27699b = arrayList;
        ArrayList arrayList2 = new ArrayList(9);
        this.f27700c = arrayList2;
        this.f27698a = xMLParser;
        arrayList.add("pre");
        arrayList2.add("p");
        arrayList2.add("div");
        arrayList2.add("h1");
        arrayList2.add("h2");
        arrayList2.add("h3");
        arrayList2.add("h4");
        arrayList2.add("h5");
        arrayList2.add("h6");
        arrayList2.add("td");
        arrayList2.add("th");
        arrayList2.add("ul");
        arrayList2.add("ol");
        arrayList2.add("li");
        arrayList2.add(HTML.Tag.t);
        arrayList2.add(HTML.Tag.u);
        arrayList2.add("hr");
        arrayList2.add("br");
    }

    public void a(char c2) {
        if (c2 == '<') {
            if (this.f27698a.e() > 0) {
                XMLParser xMLParser = this.f27698a;
                xMLParser.C(xMLParser.i());
            }
            this.f27698a.p();
            this.f27698a.y().r();
        } else if (c2 == '&') {
            this.f27698a.y().o();
        } else if (c2 == '*' && this.f27698a.r().l() == '/') {
            this.f27698a.y().p();
            this.f27698a.r().b().deleteCharAt(this.f27698a.r().b().lastIndexOf("/"));
            if (this.f27698a.e() > 0) {
                this.f27698a.r().q(this.f27698a.i());
            }
            this.f27698a.p();
        } else {
            String k2 = this.f27698a.k();
            TagState l2 = this.f27698a.l();
            if (!this.f27699b.contains(k2) || TagState.OPEN != l2) {
                if (this.f27698a.r().r().length() != 0) {
                    if (this.f27700c.contains(this.f27698a.r().r().toLowerCase())) {
                        this.f27698a.r().m(' ');
                    }
                    this.f27698a.r().s("");
                }
                boolean isWhitespace = Character.isWhitespace(this.f27698a.r().l());
                boolean z = !Character.isWhitespace(c2);
                if (!isWhitespace || (isWhitespace && z)) {
                    XMLParser xMLParser2 = this.f27698a;
                    if (z) {
                        xMLParser2.b(c2);
                    } else {
                        xMLParser2.b(' ');
                    }
                }
                this.f27698a.r().m(c2);
                return;
            }
            this.f27698a.b(c2);
        }
    }
}
