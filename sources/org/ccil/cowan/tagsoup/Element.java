package org.ccil.cowan.tagsoup;

public class Element {

    /* renamed from: a  reason: collision with root package name */
    private ElementType f31469a;

    /* renamed from: b  reason: collision with root package name */
    private AttributesImpl f31470b;

    /* renamed from: c  reason: collision with root package name */
    private Element f31471c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f31472d;

    public Element(ElementType elementType, boolean z) {
        this.f31469a = elementType;
        if (z) {
            this.f31470b = new AttributesImpl(elementType.a());
        } else {
            this.f31470b = new AttributesImpl();
        }
        this.f31471c = null;
        this.f31472d = false;
    }

    public void a() {
        for (int length = this.f31470b.getLength() - 1; length >= 0; length--) {
            if (this.f31470b.getType(length).equals("ID") || this.f31470b.getQName(length).equals("name")) {
                this.f31470b.e(length);
            }
        }
    }

    public AttributesImpl b() {
        return this.f31470b;
    }

    public boolean c(Element element) {
        return this.f31469a.b(element.f31469a);
    }

    public void d() {
        for (int length = this.f31470b.getLength() - 1; length >= 0; length--) {
            String localName = this.f31470b.getLocalName(length);
            if (this.f31470b.getValue(length) == null || localName == null || localName.length() == 0) {
                this.f31470b.e(length);
            }
        }
    }

    public int e() {
        return this.f31469a.c();
    }

    public boolean f() {
        return this.f31472d;
    }

    public String g() {
        return this.f31469a.d();
    }

    public int h() {
        return this.f31469a.f();
    }

    public int i() {
        return this.f31469a.g();
    }

    public String j() {
        return this.f31469a.h();
    }

    public String k() {
        return this.f31469a.i();
    }

    public Element l() {
        return this.f31471c;
    }

    public ElementType m() {
        return this.f31469a.l();
    }

    public void n() {
        this.f31472d = true;
    }

    public void o(String str, String str2, String str3) {
        this.f31469a.o(this.f31470b, str, str2, str3);
    }

    public void p(Element element) {
        this.f31471c = element;
    }

    public ElementType q() {
        return this.f31469a;
    }
}
