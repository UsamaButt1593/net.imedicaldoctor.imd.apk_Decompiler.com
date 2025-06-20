package com.itextpdf.text.pdf.parser.clipper;

import com.itextpdf.text.pdf.parser.clipper.Clipper;
import com.itextpdf.text.pdf.parser.clipper.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PolyNode {

    /* renamed from: a  reason: collision with root package name */
    private PolyNode f27149a;

    /* renamed from: b  reason: collision with root package name */
    private final Path f27150b = new Path();

    /* renamed from: c  reason: collision with root package name */
    private int f27151c;

    /* renamed from: d  reason: collision with root package name */
    private Clipper.JoinType f27152d;

    /* renamed from: e  reason: collision with root package name */
    private Clipper.EndType f27153e;

    /* renamed from: f  reason: collision with root package name */
    protected final List<PolyNode> f27154f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    private boolean f27155g;

    enum NodeType {
        ANY,
        OPEN,
        CLOSED
    }

    private PolyNode h() {
        PolyNode polyNode = this.f27149a;
        if (polyNode == null) {
            return null;
        }
        return this.f27151c == polyNode.f27154f.size() + -1 ? this.f27149a.h() : this.f27149a.f27154f.get(this.f27151c + 1);
    }

    private boolean l() {
        boolean z = true;
        for (PolyNode polyNode = this.f27149a; polyNode != null; polyNode = polyNode.f27149a) {
            z = !z;
        }
        return z;
    }

    public void a(PolyNode polyNode) {
        int size = this.f27154f.size();
        this.f27154f.add(polyNode);
        polyNode.f27149a = this;
        polyNode.f27151c = size;
    }

    public int b() {
        return this.f27154f.size();
    }

    public List<PolyNode> c() {
        return Collections.unmodifiableList(this.f27154f);
    }

    public List<Point.LongPoint> d() {
        return this.f27150b;
    }

    public Clipper.EndType e() {
        return this.f27153e;
    }

    public Clipper.JoinType f() {
        return this.f27152d;
    }

    public PolyNode g() {
        return !this.f27154f.isEmpty() ? this.f27154f.get(0) : h();
    }

    public PolyNode i() {
        return this.f27149a;
    }

    public Path j() {
        return this.f27150b;
    }

    public boolean k() {
        return l();
    }

    public boolean m() {
        return this.f27155g;
    }

    public void n(Clipper.EndType endType) {
        this.f27153e = endType;
    }

    public void o(Clipper.JoinType joinType) {
        this.f27152d = joinType;
    }

    public void p(boolean z) {
        this.f27155g = z;
    }

    public void q(PolyNode polyNode) {
        this.f27149a = polyNode;
    }
}
