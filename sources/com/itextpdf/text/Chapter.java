package com.itextpdf.text;

import java.util.ArrayList;

public class Chapter extends Section {
    private static final long k3 = 1791000695779357361L;

    public Chapter(int i2) {
        super((Paragraph) null, 1);
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.d3 = arrayList;
        arrayList.add(Integer.valueOf(i2));
        this.b3 = true;
    }

    public int type() {
        return 16;
    }

    public boolean x() {
        return false;
    }

    public Chapter(Paragraph paragraph, int i2) {
        super(paragraph, 1);
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.d3 = arrayList;
        arrayList.add(Integer.valueOf(i2));
        this.b3 = true;
    }

    public Chapter(String str, int i2) {
        this(new Paragraph(str), i2);
    }
}
