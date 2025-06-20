package com.itextpdf.text;

import java.util.List;
import java.util.Properties;

@Deprecated
public class MarkedObject implements Element {
    protected Properties X;
    protected Element s;

    protected MarkedObject() {
        this.X = new Properties();
        this.s = null;
    }

    public boolean V() {
        return true;
    }

    public List<Chunk> Y() {
        return this.s.Y();
    }

    public Properties a() {
        return this.X;
    }

    public void c(String str, String str2) {
        this.X.setProperty(str, str2);
    }

    public boolean t(ElementListener elementListener) {
        try {
            return elementListener.b(this.s);
        } catch (DocumentException unused) {
            return false;
        }
    }

    public int type() {
        return 50;
    }

    public boolean x() {
        return true;
    }

    public MarkedObject(Element element) {
        this.X = new Properties();
        this.s = element;
    }
}
