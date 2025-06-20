package com.itextpdf.text;

import org.apache.commons.lang3.StringUtils;

public class ZapfDingbatsList extends List {
    protected int p3;

    public ZapfDingbatsList(int i2) {
        super(true);
        this.p3 = i2;
        this.a3.O(FontFactory.d("ZapfDingbats", this.a3.k().m(), 0));
        this.c3 = StringUtils.SPACE;
    }

    public int T() {
        return this.p3;
    }

    public void W(int i2) {
        this.p3 = i2;
    }

    public void X(BaseColor baseColor) {
        this.a3.O(FontFactory.e("ZapfDingbats", this.a3.k().m(), 0, baseColor));
    }

    public boolean b(Element element) {
        if (element instanceof ListItem) {
            ListItem listItem = (ListItem) element;
            Chunk chunk = new Chunk(this.b3, this.a3.k());
            chunk.J(this.a3.h());
            chunk.a(String.valueOf((char) this.p3));
            chunk.a(this.c3);
            listItem.n2(chunk);
            listItem.m2(this.f3, this.X2);
            listItem.B(0.0f);
            this.s.add(listItem);
            return false;
        } else if (!(element instanceof List)) {
            return false;
        } else {
            List list = (List) element;
            list.g(list.m() + this.f3);
            this.Z2--;
            return this.s.add(list);
        }
    }

    public List c() {
        ZapfDingbatsList zapfDingbatsList = new ZapfDingbatsList(this.p3);
        F(zapfDingbatsList);
        return zapfDingbatsList;
    }

    public ZapfDingbatsList(int i2, int i3) {
        super(true, (float) i3);
        this.p3 = i2;
        this.a3.O(FontFactory.d("ZapfDingbats", this.a3.k().m(), 0));
        this.c3 = StringUtils.SPACE;
    }

    public ZapfDingbatsList(int i2, int i3, BaseColor baseColor) {
        super(true, (float) i3);
        this.p3 = i2;
        this.a3.O(FontFactory.e("ZapfDingbats", this.a3.k().m(), 0, baseColor));
        this.c3 = StringUtils.SPACE;
    }
}
