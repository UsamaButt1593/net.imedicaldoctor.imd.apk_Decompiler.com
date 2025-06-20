package com.itextpdf.text;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Anchor extends Phrase {
    private static final long b3 = -852278536049236911L;
    protected String Z2 = null;
    protected String a3 = null;

    public Anchor() {
        super(16.0f);
    }

    public void A1(String str) {
        this.Z2 = str;
    }

    public void C1(String str) {
        this.a3 = str;
    }

    public List<Chunk> Y() {
        String str = this.a3;
        boolean z = true;
        boolean z2 = str != null && str.startsWith("#");
        ArrayList arrayList = new ArrayList();
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            Element element = (Element) it2.next();
            if (element instanceof Chunk) {
                Chunk chunk = (Chunk) element;
                z = u1(chunk, z, z2);
                arrayList.add(chunk);
            } else {
                for (Chunk next : element.Y()) {
                    z = u1(next, z, z2);
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public boolean t(ElementListener elementListener) {
        try {
            String str = this.a3;
            boolean z = str != null && str.startsWith("#");
            boolean z2 = true;
            for (Chunk next : Y()) {
                if (this.Z2 != null && z2 && !next.A()) {
                    next.T(this.Z2);
                    z2 = false;
                }
                if (z) {
                    next.W(this.a3.substring(1));
                }
                elementListener.b(next);
            }
            return true;
        } catch (DocumentException unused) {
            return false;
        }
    }

    public int type() {
        return 17;
    }

    /* access modifiers changed from: protected */
    public boolean u1(Chunk chunk, boolean z, boolean z2) {
        if (this.Z2 != null && z && !chunk.A()) {
            chunk.T(this.Z2);
            z = false;
        }
        if (z2) {
            chunk.W(this.a3.substring(1));
        } else {
            String str = this.a3;
            if (str != null) {
                chunk.F(str);
            }
        }
        return z;
    }

    public String w1() {
        return this.Z2;
    }

    public String y1() {
        return this.a3;
    }

    public URL z1() {
        try {
            return new URL(this.a3);
        } catch (MalformedURLException unused) {
            return null;
        }
    }

    public Anchor(float f2) {
        super(f2);
    }

    public Anchor(float f2, Chunk chunk) {
        super(f2, chunk);
    }

    public Anchor(float f2, String str) {
        super(f2, str);
    }

    public Anchor(float f2, String str, Font font) {
        super(f2, str, font);
    }

    public Anchor(Chunk chunk) {
        super(chunk);
    }

    public Anchor(Phrase phrase) {
        super(phrase);
        if (phrase instanceof Anchor) {
            Anchor anchor = (Anchor) phrase;
            A1(anchor.Z2);
            C1(anchor.a3);
        }
    }

    public Anchor(String str) {
        super(str);
    }

    public Anchor(String str, Font font) {
        super(str, font);
    }
}
