package androidx.constraintlayout.core.parser;

public class CLParser {

    /* renamed from: d  reason: collision with root package name */
    static boolean f4065d = false;

    /* renamed from: a  reason: collision with root package name */
    private String f4066a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f4067b = false;

    /* renamed from: c  reason: collision with root package name */
    private int f4068c;

    /* renamed from: androidx.constraintlayout.core.parser.CLParser$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f4069a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.constraintlayout.core.parser.CLParser$TYPE[] r0 = androidx.constraintlayout.core.parser.CLParser.TYPE.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f4069a = r0
                androidx.constraintlayout.core.parser.CLParser$TYPE r1 = androidx.constraintlayout.core.parser.CLParser.TYPE.OBJECT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f4069a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.core.parser.CLParser$TYPE r1 = androidx.constraintlayout.core.parser.CLParser.TYPE.ARRAY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f4069a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.core.parser.CLParser$TYPE r1 = androidx.constraintlayout.core.parser.CLParser.TYPE.STRING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f4069a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.core.parser.CLParser$TYPE r1 = androidx.constraintlayout.core.parser.CLParser.TYPE.NUMBER     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f4069a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.constraintlayout.core.parser.CLParser$TYPE r1 = androidx.constraintlayout.core.parser.CLParser.TYPE.KEY     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f4069a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.constraintlayout.core.parser.CLParser$TYPE r1 = androidx.constraintlayout.core.parser.CLParser.TYPE.TOKEN     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.parser.CLParser.AnonymousClass1.<clinit>():void");
        }
    }

    enum TYPE {
        UNKNOWN,
        OBJECT,
        ARRAY,
        NUMBER,
        STRING,
        KEY,
        TOKEN
    }

    public CLParser(String str) {
        this.f4066a = str;
    }

    private CLElement a(CLElement cLElement, int i2, TYPE type, boolean z, char[] cArr) {
        CLElement cLElement2;
        if (f4065d) {
            System.out.println("CREATE " + type + " at " + cArr[i2]);
        }
        switch (AnonymousClass1.f4069a[type.ordinal()]) {
            case 1:
                cLElement2 = CLObject.k0(cArr);
                break;
            case 2:
                cLElement2 = CLArray.H(cArr);
                break;
            case 3:
                cLElement2 = CLString.G(cArr);
                break;
            case 4:
                cLElement2 = CLNumber.G(cArr);
                break;
            case 5:
                cLElement2 = CLKey.H(cArr);
                break;
            case 6:
                cLElement2 = CLToken.G(cArr);
                break;
            default:
                cLElement2 = null;
                break;
        }
        i2++;
        if (cLElement2 == null) {
            return null;
        }
        cLElement2.B(this.f4068c);
        if (z) {
            cLElement2.C((long) i2);
        }
        if (cLElement instanceof CLContainer) {
            cLElement2.x((CLContainer) cLElement);
        }
        return cLElement2;
    }

    private CLElement b(int i2, char c2, CLElement cLElement, char[] cArr) throws CLParsingException {
        if (c2 == 9 || c2 == 10 || c2 == 13 || c2 == ' ') {
            return cLElement;
        }
        if (c2 == '\"' || c2 == '\'') {
            if (cLElement instanceof CLObject) {
                return a(cLElement, i2, TYPE.KEY, true, cArr);
            }
            return a(cLElement, i2, TYPE.STRING, true, cArr);
        } else if (c2 != '[') {
            if (c2 != ']') {
                if (c2 == '{') {
                    return a(cLElement, i2, TYPE.OBJECT, true, cArr);
                } else if (c2 != '}') {
                    switch (c2) {
                        case '+':
                        case '-':
                        case '.':
                        case '0':
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                        case '8':
                        case '9':
                            return a(cLElement, i2, TYPE.NUMBER, true, cArr);
                        case ',':
                        case ':':
                            return cLElement;
                        case '/':
                            int i3 = i2 + 1;
                            if (i3 >= cArr.length || cArr[i3] != '/') {
                                return cLElement;
                            }
                            this.f4067b = true;
                            return cLElement;
                        default:
                            if (!(cLElement instanceof CLContainer) || (cLElement instanceof CLObject)) {
                                return a(cLElement, i2, TYPE.KEY, true, cArr);
                            }
                            CLElement a2 = a(cLElement, i2, TYPE.TOKEN, true, cArr);
                            CLToken cLToken = (CLToken) a2;
                            if (cLToken.L(c2, (long) i2)) {
                                return a2;
                            }
                            throw new CLParsingException("incorrect token <" + c2 + "> at line " + this.f4068c, cLToken);
                    }
                }
            }
            cLElement.z((long) (i2 - 1));
            CLElement d2 = cLElement.d();
            d2.z((long) i2);
            return d2;
        } else {
            return a(cLElement, i2, TYPE.ARRAY, true, cArr);
        }
    }

    public static CLObject d(String str) throws CLParsingException {
        return new CLParser(str).c();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005f, code lost:
        if (r9 == '}') goto L_0x007c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0068, code lost:
        if (r9 == ']') goto L_0x007c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.constraintlayout.core.parser.CLObject c() throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            r16 = this;
            r0 = r16
            java.lang.String r1 = r0.f4066a
            char[] r1 = r1.toCharArray()
            int r2 = r1.length
            r3 = 1
            r0.f4068c = r3
            r4 = 0
            r5 = 0
        L_0x000e:
            r6 = 10
            r7 = -1
            if (r5 >= r2) goto L_0x0024
            char r8 = r1[r5]
            r9 = 123(0x7b, float:1.72E-43)
            if (r8 != r9) goto L_0x001a
            goto L_0x0025
        L_0x001a:
            if (r8 != r6) goto L_0x0021
            int r6 = r0.f4068c
            int r6 = r6 + r3
            r0.f4068c = r6
        L_0x0021:
            int r5 = r5 + 1
            goto L_0x000e
        L_0x0024:
            r5 = -1
        L_0x0025:
            if (r5 == r7) goto L_0x0173
            androidx.constraintlayout.core.parser.CLObject r7 = androidx.constraintlayout.core.parser.CLObject.k0(r1)
            int r8 = r0.f4068c
            r7.B(r8)
            long r8 = (long) r5
            r7.C(r8)
            int r5 = r5 + r3
            r8 = r7
        L_0x0036:
            if (r5 >= r2) goto L_0x0132
            char r9 = r1[r5]
            if (r9 != r6) goto L_0x0041
            int r10 = r0.f4068c
            int r10 = r10 + r3
            r0.f4068c = r10
        L_0x0041:
            boolean r10 = r0.f4067b
            if (r10 == 0) goto L_0x0049
            if (r9 != r6) goto L_0x012c
            r0.f4067b = r4
        L_0x0049:
            if (r8 != 0) goto L_0x004d
            goto L_0x0132
        L_0x004d:
            boolean r10 = r8.q()
            if (r10 == 0) goto L_0x0059
        L_0x0053:
            androidx.constraintlayout.core.parser.CLElement r8 = r0.b(r5, r9, r8, r1)
            goto L_0x0113
        L_0x0059:
            boolean r10 = r8 instanceof androidx.constraintlayout.core.parser.CLObject
            r11 = 125(0x7d, float:1.75E-43)
            if (r10 == 0) goto L_0x0062
            if (r9 != r11) goto L_0x0053
        L_0x0061:
            goto L_0x007c
        L_0x0062:
            boolean r10 = r8 instanceof androidx.constraintlayout.core.parser.CLArray
            r12 = 93
            if (r10 == 0) goto L_0x006b
            if (r9 != r12) goto L_0x0053
            goto L_0x0061
        L_0x006b:
            boolean r10 = r8 instanceof androidx.constraintlayout.core.parser.CLString
            r13 = 1
            if (r10 == 0) goto L_0x0084
            long r10 = r8.X
            int r12 = (int) r10
            char r12 = r1[r12]
            if (r12 != r9) goto L_0x0113
            long r10 = r10 + r13
            r8.C(r10)
        L_0x007c:
            int r9 = r5 + -1
            long r9 = (long) r9
            r8.z(r9)
            goto L_0x0113
        L_0x0084:
            boolean r15 = r8 instanceof androidx.constraintlayout.core.parser.CLToken
            if (r15 == 0) goto L_0x00b8
            r15 = r8
            androidx.constraintlayout.core.parser.CLToken r15 = (androidx.constraintlayout.core.parser.CLToken) r15
            long r3 = (long) r5
            boolean r3 = r15.L(r9, r3)
            if (r3 == 0) goto L_0x0093
            goto L_0x00b8
        L_0x0093:
            androidx.constraintlayout.core.parser.CLParsingException r1 = new androidx.constraintlayout.core.parser.CLParsingException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "parsing incorrect token "
            r2.append(r3)
            java.lang.String r3 = r15.c()
            r2.append(r3)
            java.lang.String r3 = " at line "
            r2.append(r3)
            int r3 = r0.f4068c
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2, r15)
            throw r1
        L_0x00b8:
            boolean r3 = r8 instanceof androidx.constraintlayout.core.parser.CLKey
            if (r3 != 0) goto L_0x00be
            if (r10 == 0) goto L_0x00d7
        L_0x00be:
            long r3 = r8.X
            int r10 = (int) r3
            char r10 = r1[r10]
            r15 = 39
            if (r10 == r15) goto L_0x00cb
            r15 = 34
            if (r10 != r15) goto L_0x00d7
        L_0x00cb:
            if (r10 != r9) goto L_0x00d7
            long r3 = r3 + r13
            r8.C(r3)
            int r3 = r5 + -1
            long r3 = (long) r3
            r8.z(r3)
        L_0x00d7:
            boolean r3 = r8.q()
            if (r3 != 0) goto L_0x0113
            if (r9 == r11) goto L_0x00f7
            if (r9 == r12) goto L_0x00f7
            r3 = 44
            if (r9 == r3) goto L_0x00f7
            r3 = 32
            if (r9 == r3) goto L_0x00f7
            r3 = 9
            if (r9 == r3) goto L_0x00f7
            r3 = 13
            if (r9 == r3) goto L_0x00f7
            if (r9 == r6) goto L_0x00f7
            r3 = 58
            if (r9 != r3) goto L_0x0113
        L_0x00f7:
            int r3 = r5 + -1
            long r3 = (long) r3
            r8.z(r3)
            if (r9 == r11) goto L_0x0101
            if (r9 != r12) goto L_0x0113
        L_0x0101:
            androidx.constraintlayout.core.parser.CLElement r8 = r8.d()
            r8.z(r3)
            boolean r9 = r8 instanceof androidx.constraintlayout.core.parser.CLKey
            if (r9 == 0) goto L_0x0113
            androidx.constraintlayout.core.parser.CLElement r8 = r8.d()
            r8.z(r3)
        L_0x0113:
            boolean r3 = r8.q()
            if (r3 == 0) goto L_0x012c
            boolean r3 = r8 instanceof androidx.constraintlayout.core.parser.CLKey
            if (r3 == 0) goto L_0x0128
            r3 = r8
            androidx.constraintlayout.core.parser.CLKey r3 = (androidx.constraintlayout.core.parser.CLKey) r3
            java.util.ArrayList<androidx.constraintlayout.core.parser.CLElement> r3 = r3.a3
            int r3 = r3.size()
            if (r3 <= 0) goto L_0x012c
        L_0x0128:
            androidx.constraintlayout.core.parser.CLElement r8 = r8.d()
        L_0x012c:
            int r5 = r5 + 1
            r3 = 1
            r4 = 0
            goto L_0x0036
        L_0x0132:
            if (r8 == 0) goto L_0x0154
            boolean r1 = r8.q()
            if (r1 != 0) goto L_0x0154
            boolean r1 = r8 instanceof androidx.constraintlayout.core.parser.CLString
            if (r1 == 0) goto L_0x0148
            long r3 = r8.X
            int r1 = (int) r3
            r3 = 1
            int r1 = r1 + r3
            long r4 = (long) r1
            r8.C(r4)
            goto L_0x0149
        L_0x0148:
            r3 = 1
        L_0x0149:
            int r1 = r2 + -1
            long r4 = (long) r1
            r8.z(r4)
            androidx.constraintlayout.core.parser.CLElement r8 = r8.d()
            goto L_0x0132
        L_0x0154:
            boolean r1 = f4065d
            if (r1 == 0) goto L_0x0172
            java.io.PrintStream r1 = java.lang.System.out
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Root: "
            r2.append(r3)
            java.lang.String r3 = r7.E()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.println(r2)
        L_0x0172:
            return r7
        L_0x0173:
            androidx.constraintlayout.core.parser.CLParsingException r1 = new androidx.constraintlayout.core.parser.CLParsingException
            java.lang.String r2 = "invalid json content"
            r3 = 0
            r1.<init>(r2, r3)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.parser.CLParser.c():androidx.constraintlayout.core.parser.CLObject");
    }
}
