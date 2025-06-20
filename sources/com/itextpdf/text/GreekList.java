package com.itextpdf.text;

import com.itextpdf.text.factories.GreekAlphabetFactory;

public class GreekList extends List {
    public GreekList() {
        super(true);
        T();
    }

    /* access modifiers changed from: protected */
    public void T() {
        this.a3.O(FontFactory.d("Symbol", this.a3.k().m(), 0));
    }

    public boolean b(Element element) {
        if (element instanceof ListItem) {
            ListItem listItem = (ListItem) element;
            Chunk chunk = new Chunk(this.b3, this.a3.k());
            chunk.J(this.a3.h());
            chunk.a(GreekAlphabetFactory.c(this.Z2 + this.s.size(), this.Z));
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
        GreekList greekList = new GreekList();
        F(greekList);
        return greekList;
    }

    public GreekList(int i2) {
        super(true, (float) i2);
        T();
    }

    public GreekList(boolean z, int i2) {
        super(true, (float) i2);
        this.Z = z;
        T();
    }
}
