package com.itextpdf.tool.xml.css.parser;

import com.itextpdf.tool.xml.css.CssFile;
import com.itextpdf.tool.xml.css.CssUtils;
import com.itextpdf.tool.xml.css.parser.state.CommentEnd;
import com.itextpdf.tool.xml.css.parser.state.CommentInside;
import com.itextpdf.tool.xml.css.parser.state.CommentStart;
import com.itextpdf.tool.xml.css.parser.state.Properties;
import com.itextpdf.tool.xml.css.parser.state.Rule;
import com.itextpdf.tool.xml.css.parser.state.Unknown;
import java.util.LinkedHashMap;

public class CssStateController {

    /* renamed from: a  reason: collision with root package name */
    private State f27551a;

    /* renamed from: b  reason: collision with root package name */
    private State f27552b;

    /* renamed from: c  reason: collision with root package name */
    private final State f27553c = new CommentEnd(this);

    /* renamed from: d  reason: collision with root package name */
    private final State f27554d = new CommentStart(this);

    /* renamed from: e  reason: collision with root package name */
    private final State f27555e = new CommentInside(this);

    /* renamed from: f  reason: collision with root package name */
    private final StringBuilder f27556f = new StringBuilder();

    /* renamed from: g  reason: collision with root package name */
    private final State f27557g;

    /* renamed from: h  reason: collision with root package name */
    private final State f27558h;

    /* renamed from: i  reason: collision with root package name */
    private String f27559i;

    /* renamed from: j  reason: collision with root package name */
    private final State f27560j;

    /* renamed from: k  reason: collision with root package name */
    private final CssUtils f27561k = CssUtils.g();

    /* renamed from: l  reason: collision with root package name */
    private final CssFile f27562l;

    public CssStateController(CssFile cssFile) {
        this.f27562l = cssFile;
        Unknown unknown = new Unknown(this);
        this.f27558h = unknown;
        this.f27557g = new Properties(this);
        this.f27560j = new Rule(this);
        this.f27551a = unknown;
    }

    private void d(String str) {
        String[] split = str.split(";");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String split2 : split) {
            String[] split3 = split2.split(":");
            if (split3.length == 2) {
                linkedHashMap.put(this.f27561k.y(split3[0]), this.f27561k.x(split3[1]));
            }
        }
        if (this.f27559i.contains(",")) {
            String[] split4 = this.f27559i.split(",");
            int i2 = 0;
            while (i2 < split4.length) {
                String x = this.f27561k.x(split4[i2]);
                split4[i2] = x;
                if (x.length() != 0) {
                    i2++;
                } else {
                    return;
                }
            }
            for (String c2 : split4) {
                if (!this.f27562l.c(c2, linkedHashMap)) {
                    linkedHashMap.clear();
                }
            }
            return;
        }
        this.f27562l.c(this.f27561k.x(this.f27559i), linkedHashMap);
    }

    private void e() {
        this.f27552b = this.f27551a;
    }

    private void f(State state) {
        this.f27551a = state;
    }

    public void a(char c2) {
        this.f27556f.append(c2);
    }

    public void b() {
        this.f27551a = this.f27552b;
    }

    public void c(char c2) {
        this.f27551a.a(c2);
    }

    public void g() {
        f(this.f27553c);
    }

    public void h() {
        f(this.f27555e);
    }

    public void i() {
        e();
        f(this.f27554d);
    }

    public void j() {
        this.f27552b = this.f27551a;
        f(this.f27557g);
    }

    public void k() {
        f(this.f27560j);
    }

    public void l() {
        f(this.f27558h);
    }

    public void m() {
        d(this.f27556f.toString());
        this.f27556f.setLength(0);
    }

    public void n() {
        this.f27559i = this.f27556f.toString();
        this.f27556f.setLength(0);
    }
}
