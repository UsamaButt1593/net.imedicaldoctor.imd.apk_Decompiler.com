package com.itextpdf.tool.xml.parser;

import com.itextpdf.tool.xml.parser.state.AttributeValueState;
import com.itextpdf.tool.xml.parser.state.CdataState;
import com.itextpdf.tool.xml.parser.state.CloseCommentState;
import com.itextpdf.tool.xml.parser.state.CloseStarCommentState;
import com.itextpdf.tool.xml.parser.state.ClosingTagState;
import com.itextpdf.tool.xml.parser.state.CommentState;
import com.itextpdf.tool.xml.parser.state.DocTypeState;
import com.itextpdf.tool.xml.parser.state.DoubleQuotedAttrValueState;
import com.itextpdf.tool.xml.parser.state.InsideTagHTMLState;
import com.itextpdf.tool.xml.parser.state.InsideTagState;
import com.itextpdf.tool.xml.parser.state.ProcessingInstructionEncounteredState;
import com.itextpdf.tool.xml.parser.state.SelfClosingTagState;
import com.itextpdf.tool.xml.parser.state.SingleQuotedAttrValueState;
import com.itextpdf.tool.xml.parser.state.SpecialCharState;
import com.itextpdf.tool.xml.parser.state.StarCommentState;
import com.itextpdf.tool.xml.parser.state.TagAttributeState;
import com.itextpdf.tool.xml.parser.state.TagEncounteredState;
import com.itextpdf.tool.xml.parser.state.UnknownState;
import com.itextpdf.tool.xml.parser.state.UnquotedAttrState;
import com.itextpdf.tool.xml.parser.state.XmlState;

public class StateController {

    /* renamed from: a  reason: collision with root package name */
    private final State f27655a;

    /* renamed from: b  reason: collision with root package name */
    private final State f27656b;

    /* renamed from: c  reason: collision with root package name */
    private final State f27657c;

    /* renamed from: d  reason: collision with root package name */
    private final State f27658d;

    /* renamed from: e  reason: collision with root package name */
    private final State f27659e;

    /* renamed from: f  reason: collision with root package name */
    private final State f27660f;

    /* renamed from: g  reason: collision with root package name */
    private final State f27661g;

    /* renamed from: h  reason: collision with root package name */
    private final State f27662h;

    /* renamed from: i  reason: collision with root package name */
    private final State f27663i;

    /* renamed from: j  reason: collision with root package name */
    private final State f27664j;

    /* renamed from: k  reason: collision with root package name */
    private final State f27665k;

    /* renamed from: l  reason: collision with root package name */
    private final State f27666l;

    /* renamed from: m  reason: collision with root package name */
    private final State f27667m;

    /* renamed from: n  reason: collision with root package name */
    private final State f27668n;
    private final State o;
    private final State p;
    private final State q;
    private final XMLParser r;
    private State s;
    private State t;
    private State u;
    private State v;

    public StateController(XMLParser xMLParser, boolean z) {
        this.r = xMLParser;
        this.f27655a = new UnknownState(xMLParser);
        this.f27656b = new TagEncounteredState(xMLParser);
        this.f27657c = new TagAttributeState(xMLParser);
        this.f27658d = z ? new InsideTagHTMLState(xMLParser) : new InsideTagState(xMLParser);
        this.f27659e = new AttributeValueState(xMLParser);
        this.f27660f = new SingleQuotedAttrValueState(xMLParser);
        this.f27661g = new DoubleQuotedAttrValueState(xMLParser);
        this.f27662h = new SelfClosingTagState(xMLParser);
        this.f27663i = new SpecialCharState(xMLParser);
        this.f27664j = new ClosingTagState(xMLParser);
        this.f27665k = new CommentState(xMLParser);
        this.f27666l = new CloseCommentState(xMLParser);
        this.f27667m = new CdataState(xMLParser);
        this.f27668n = new XmlState(xMLParser);
        this.o = new DocTypeState(xMLParser);
        this.p = new UnquotedAttrState(xMLParser);
        this.q = new ProcessingInstructionEncounteredState(xMLParser);
        this.t = null;
        this.s = null;
        this.u = new StarCommentState(xMLParser);
        this.v = new CloseStarCommentState(xMLParser);
    }

    public XMLParser a() {
        return m(this.f27659e);
    }

    public XMLParser b() {
        return m(this.f27667m);
    }

    public XMLParser c() {
        return m(this.f27666l);
    }

    public XMLParser d() {
        return m(this.v);
    }

    public XMLParser e() {
        return m(this.f27664j);
    }

    public XMLParser f() {
        return m(this.f27665k);
    }

    public XMLParser g() {
        return m(this.o);
    }

    public XMLParser h() {
        return m(this.f27661g);
    }

    public XMLParser i() {
        return m(this.f27658d);
    }

    public XMLParser j() {
        this.r.A(this.t);
        State state = this.s;
        this.s = this.t;
        this.t = state;
        return this.r;
    }

    public XMLParser k() {
        return m(this.q);
    }

    public XMLParser l() {
        return m(this.f27662h);
    }

    public XMLParser m(State state) {
        this.t = this.s;
        this.s = state;
        this.r.A(state);
        return this.r;
    }

    public XMLParser n() {
        return m(this.f27660f);
    }

    public XMLParser o() {
        return m(this.f27663i);
    }

    public XMLParser p() {
        return m(this.u);
    }

    public XMLParser q() {
        return m(this.f27657c);
    }

    public XMLParser r() {
        return m(this.f27656b);
    }

    public XMLParser s() {
        return m(this.f27655a);
    }

    public XMLParser t() {
        return m(this.p);
    }
}
