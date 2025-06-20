package com.itextpdf.text.pdf;

public class Glyph {

    /* renamed from: a  reason: collision with root package name */
    public final int f26064a;

    /* renamed from: b  reason: collision with root package name */
    public final int f26065b;

    /* renamed from: c  reason: collision with root package name */
    public final String f26066c;

    public Glyph(int i2, int i3, String str) {
        this.f26064a = i2;
        this.f26065b = i3;
        this.f26066c = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Glyph glyph = (Glyph) obj;
        String str = this.f26066c;
        if (str == null) {
            if (glyph.f26066c != null) {
                return false;
            }
        } else if (!str.equals(glyph.f26066c)) {
            return false;
        }
        return this.f26064a == glyph.f26064a && this.f26065b == glyph.f26065b;
    }

    public int hashCode() {
        String str = this.f26066c;
        return (((((str == null ? 0 : str.hashCode()) + 31) * 31) + this.f26064a) * 31) + this.f26065b;
    }

    public String toString() {
        return Glyph.class.getSimpleName() + " [id=" + this.f26064a + ", width=" + this.f26065b + ", chars=" + this.f26066c + "]";
    }
}
