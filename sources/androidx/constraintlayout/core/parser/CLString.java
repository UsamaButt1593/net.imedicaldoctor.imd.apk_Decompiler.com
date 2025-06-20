package androidx.constraintlayout.core.parser;

public class CLString extends CLElement {
    public CLString(char[] cArr) {
        super(cArr);
    }

    public static CLElement G(char[] cArr) {
        return new CLString(cArr);
    }

    /* access modifiers changed from: protected */
    public String D(int i2, int i3) {
        StringBuilder sb = new StringBuilder();
        b(sb, i2);
        sb.append("'");
        sb.append(c());
        sb.append("'");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public String E() {
        return "'" + c() + "'";
    }
}
