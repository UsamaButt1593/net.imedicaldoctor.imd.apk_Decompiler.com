package com.itextpdf.text;

import com.itextpdf.text.factories.RomanNumberFactory;

public class RomanList extends List {
    public RomanList() {
        super(true);
    }

    public boolean b(Element element) {
        if (element instanceof ListItem) {
            ListItem listItem = (ListItem) element;
            Chunk chunk = new Chunk(this.b3, this.a3.k());
            chunk.J(this.a3.h());
            chunk.a(RomanNumberFactory.c(this.Z2 + this.s.size(), this.Z));
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
        RomanList romanList = new RomanList();
        F(romanList);
        return romanList;
    }

    public RomanList(int i2) {
        super(true, (float) i2);
    }

    public RomanList(boolean z, int i2) {
        super(true, (float) i2);
        this.Z = z;
    }
}
