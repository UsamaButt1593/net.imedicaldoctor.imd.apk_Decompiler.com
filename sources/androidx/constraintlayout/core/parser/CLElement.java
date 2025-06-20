package androidx.constraintlayout.core.parser;

import java.io.PrintStream;

public class CLElement {
    protected static int Y2 = 80;
    protected static int Z2 = 2;
    protected long X = -1;
    private int X2;
    protected long Y = Long.MAX_VALUE;
    protected CLContainer Z;
    private final char[] s;

    public CLElement(char[] cArr) {
        this.s = cArr;
    }

    public void B(int i2) {
        this.X2 = i2;
    }

    public void C(long j2) {
        this.X = j2;
    }

    /* access modifiers changed from: protected */
    public String D(int i2, int i3) {
        return "";
    }

    /* access modifiers changed from: protected */
    public String E() {
        return "";
    }

    /* access modifiers changed from: protected */
    public void b(StringBuilder sb, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append(' ');
        }
    }

    public String c() {
        String str = new String(this.s);
        long j2 = this.Y;
        if (j2 != Long.MAX_VALUE) {
            long j3 = this.X;
            if (j2 >= j3) {
                return str.substring((int) j3, ((int) j2) + 1);
            }
        }
        long j4 = this.X;
        return str.substring((int) j4, ((int) j4) + 1);
    }

    public CLElement d() {
        return this.Z;
    }

    /* access modifiers changed from: protected */
    public String g() {
        if (!CLParser.f4065d) {
            return "";
        }
        return o() + " -> ";
    }

    public long h() {
        return this.Y;
    }

    public float j() {
        if (this instanceof CLNumber) {
            return ((CLNumber) this).j();
        }
        return Float.NaN;
    }

    public int k() {
        if (this instanceof CLNumber) {
            return ((CLNumber) this).k();
        }
        return 0;
    }

    public int m() {
        return this.X2;
    }

    public long n() {
        return this.X;
    }

    /* access modifiers changed from: protected */
    public String o() {
        String cls = getClass().toString();
        return cls.substring(cls.lastIndexOf(46) + 1);
    }

    public boolean q() {
        return this.Y != Long.MAX_VALUE;
    }

    public boolean r() {
        return this.X > -1;
    }

    public boolean t() {
        return this.X == -1;
    }

    public String toString() {
        long j2 = this.X;
        long j3 = this.Y;
        if (j2 > j3 || j3 == Long.MAX_VALUE) {
            return getClass() + " (INVALID, " + this.X + "-" + this.Y + ")";
        }
        String substring = new String(this.s).substring((int) this.X, ((int) this.Y) + 1);
        return o() + " (" + this.X + " : " + this.Y + ") <<" + substring + ">>";
    }

    public void x(CLContainer cLContainer) {
        this.Z = cLContainer;
    }

    public void z(long j2) {
        if (this.Y == Long.MAX_VALUE) {
            this.Y = j2;
            if (CLParser.f4065d) {
                PrintStream printStream = System.out;
                printStream.println("closing " + hashCode() + " -> " + this);
            }
            CLContainer cLContainer = this.Z;
            if (cLContainer != null) {
                cLContainer.G(this);
            }
        }
    }
}
