package androidx.constraintlayout.core.parser;

import com.itextpdf.text.pdf.PdfBoolean;

public class CLToken extends CLElement {
    int a3 = 0;
    Type b3 = Type.UNKNOWN;
    char[] c3 = PdfBoolean.l3.toCharArray();
    char[] d3 = "false".toCharArray();
    char[] e3 = "null".toCharArray();

    /* renamed from: androidx.constraintlayout.core.parser.CLToken$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f4070a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                androidx.constraintlayout.core.parser.CLToken$Type[] r0 = androidx.constraintlayout.core.parser.CLToken.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f4070a = r0
                androidx.constraintlayout.core.parser.CLToken$Type r1 = androidx.constraintlayout.core.parser.CLToken.Type.TRUE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f4070a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.core.parser.CLToken$Type r1 = androidx.constraintlayout.core.parser.CLToken.Type.FALSE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f4070a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.core.parser.CLToken$Type r1 = androidx.constraintlayout.core.parser.CLToken.Type.NULL     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f4070a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.core.parser.CLToken$Type r1 = androidx.constraintlayout.core.parser.CLToken.Type.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.parser.CLToken.AnonymousClass1.<clinit>():void");
        }
    }

    enum Type {
        UNKNOWN,
        TRUE,
        FALSE,
        NULL
    }

    public CLToken(char[] cArr) {
        super(cArr);
    }

    public static CLElement G(char[] cArr) {
        return new CLToken(cArr);
    }

    /* access modifiers changed from: protected */
    public String D(int i2, int i3) {
        StringBuilder sb = new StringBuilder();
        b(sb, i2);
        sb.append(c());
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public String E() {
        if (!CLParser.f4065d) {
            return c();
        }
        return "<" + c() + ">";
    }

    public boolean H() throws CLParsingException {
        Type type = this.b3;
        if (type == Type.TRUE) {
            return true;
        }
        if (type == Type.FALSE) {
            return false;
        }
        throw new CLParsingException("this token is not a boolean: <" + c() + ">", this);
    }

    public Type I() {
        return this.b3;
    }

    public boolean K() throws CLParsingException {
        if (this.b3 == Type.NULL) {
            return true;
        }
        throw new CLParsingException("this token is not a null: <" + c() + ">", this);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0045, code lost:
        if ((r3 + 1) == r0.length) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0058, code lost:
        if ((r3 + 1) == r0.length) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0068, code lost:
        if ((r3 + 1) == r0.length) goto L_0x0047;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean L(char r6, long r7) {
        /*
            r5 = this;
            int[] r0 = androidx.constraintlayout.core.parser.CLToken.AnonymousClass1.f4070a
            androidx.constraintlayout.core.parser.CLToken$Type r1 = r5.b3
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 1
            r2 = 0
            if (r0 == r1) goto L_0x005b
            r3 = 2
            if (r0 == r3) goto L_0x004b
            r3 = 3
            if (r0 == r3) goto L_0x0038
            r7 = 4
            if (r0 == r7) goto L_0x0018
            goto L_0x006b
        L_0x0018:
            char[] r7 = r5.c3
            int r8 = r5.a3
            char r7 = r7[r8]
            if (r7 != r6) goto L_0x0026
            androidx.constraintlayout.core.parser.CLToken$Type r6 = androidx.constraintlayout.core.parser.CLToken.Type.TRUE
        L_0x0022:
            r5.b3 = r6
            r2 = 1
            goto L_0x006b
        L_0x0026:
            char[] r7 = r5.d3
            char r7 = r7[r8]
            if (r7 != r6) goto L_0x002f
            androidx.constraintlayout.core.parser.CLToken$Type r6 = androidx.constraintlayout.core.parser.CLToken.Type.FALSE
            goto L_0x0022
        L_0x002f:
            char[] r7 = r5.e3
            char r7 = r7[r8]
            if (r7 != r6) goto L_0x006b
            androidx.constraintlayout.core.parser.CLToken$Type r6 = androidx.constraintlayout.core.parser.CLToken.Type.NULL
            goto L_0x0022
        L_0x0038:
            char[] r0 = r5.e3
            int r3 = r5.a3
            char r4 = r0[r3]
            if (r4 != r6) goto L_0x0041
            r2 = 1
        L_0x0041:
            if (r2 == 0) goto L_0x006b
            int r3 = r3 + r1
            int r6 = r0.length
            if (r3 != r6) goto L_0x006b
        L_0x0047:
            r5.z(r7)
            goto L_0x006b
        L_0x004b:
            char[] r0 = r5.d3
            int r3 = r5.a3
            char r4 = r0[r3]
            if (r4 != r6) goto L_0x0054
            r2 = 1
        L_0x0054:
            if (r2 == 0) goto L_0x006b
            int r3 = r3 + r1
            int r6 = r0.length
            if (r3 != r6) goto L_0x006b
            goto L_0x0047
        L_0x005b:
            char[] r0 = r5.c3
            int r3 = r5.a3
            char r4 = r0[r3]
            if (r4 != r6) goto L_0x0064
            r2 = 1
        L_0x0064:
            if (r2 == 0) goto L_0x006b
            int r3 = r3 + r1
            int r6 = r0.length
            if (r3 != r6) goto L_0x006b
            goto L_0x0047
        L_0x006b:
            int r6 = r5.a3
            int r6 = r6 + r1
            r5.a3 = r6
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.parser.CLToken.L(char, long):boolean");
    }
}
