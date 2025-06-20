package org.jsoup.nodes;

import com.dd.plist.ASCIIPropertyListParser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.text.Typography;
import org.jsoup.SerializationException;
import org.jsoup.helper.DataUtil;
import org.jsoup.nodes.Document;
import org.jsoup.parser.CharacterReader;
import org.jsoup.parser.Parser;

public class Entities {

    /* renamed from: a  reason: collision with root package name */
    private static final int f31612a = -1;

    /* renamed from: b  reason: collision with root package name */
    private static final String f31613b = "";

    /* renamed from: c  reason: collision with root package name */
    static final int f31614c = 36;

    /* renamed from: d  reason: collision with root package name */
    private static final HashMap<String, String> f31615d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private static final char[] f31616e = {ASCIIPropertyListParser.f18651i, ASCIIPropertyListParser.f18655m};

    /* renamed from: org.jsoup.nodes.Entities$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f31617a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                org.jsoup.nodes.Entities$CoreCharset[] r0 = org.jsoup.nodes.Entities.CoreCharset.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f31617a = r0
                org.jsoup.nodes.Entities$CoreCharset r1 = org.jsoup.nodes.Entities.CoreCharset.ascii     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f31617a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jsoup.nodes.Entities$CoreCharset r1 = org.jsoup.nodes.Entities.CoreCharset.utf     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.nodes.Entities.AnonymousClass1.<clinit>():void");
        }
    }

    private enum CoreCharset {
        ascii,
        utf,
        fallback;

        /* access modifiers changed from: private */
        public static CoreCharset b(String str) {
            if (str.equals("US-ASCII")) {
                return ascii;
            }
            return str.startsWith("UTF-") ? utf : fallback;
        }
    }

    public enum EscapeMode {
        xhtml("entities-xhtml.properties", 4),
        base("entities-base.properties", 106),
        extended("entities-full.properties", 2125);
        
        /* access modifiers changed from: private */
        public int[] X;
        /* access modifiers changed from: private */
        public int[] Y;
        /* access modifiers changed from: private */
        public String[] Z;
        /* access modifiers changed from: private */
        public String[] s;

        private EscapeMode(String str, int i2) {
            Entities.k(this, str, i2);
        }

        private int l() {
            return this.s.length;
        }

        /* access modifiers changed from: package-private */
        public int j(String str) {
            int binarySearch = Arrays.binarySearch(this.s, str);
            if (binarySearch >= 0) {
                return this.X[binarySearch];
            }
            return -1;
        }

        /* access modifiers changed from: package-private */
        public String k(int i2) {
            int binarySearch = Arrays.binarySearch(this.Y, i2);
            if (binarySearch < 0) {
                return "";
            }
            String[] strArr = this.Z;
            if (binarySearch < strArr.length - 1) {
                int i3 = binarySearch + 1;
                if (this.Y[i3] == i2) {
                    return strArr[i3];
                }
            }
            return strArr[binarySearch];
        }
    }

    private Entities() {
    }

    private static void b(Appendable appendable, EscapeMode escapeMode, int i2) throws IOException {
        Appendable append;
        String k2 = escapeMode.k(i2);
        if (k2 != "") {
            append = appendable.append(Typography.f29117d);
        } else {
            append = appendable.append("&#x");
            k2 = Integer.toHexString(i2);
        }
        append.append(k2).append(ASCIIPropertyListParser.f18655m);
    }

    private static boolean c(CoreCharset coreCharset, char c2, CharsetEncoder charsetEncoder) {
        int i2 = AnonymousClass1.f31617a[coreCharset.ordinal()];
        if (i2 == 1) {
            return c2 < 128;
        }
        if (i2 != 2) {
            return charsetEncoder.canEncode(c2);
        }
        return true;
    }

    public static int d(String str, int[] iArr) {
        String str2 = f31615d.get(str);
        if (str2 != null) {
            iArr[0] = str2.codePointAt(0);
            iArr[1] = str2.codePointAt(1);
            return 2;
        }
        int j2 = EscapeMode.extended.j(str);
        if (j2 == -1) {
            return 0;
        }
        iArr[0] = j2;
        return 1;
    }

    static String e(String str, Document.OutputSettings outputSettings) {
        StringBuilder sb = new StringBuilder(str.length() * 2);
        try {
            f(sb, str, outputSettings, false, false, false);
            return sb.toString();
        } catch (IOException e2) {
            throw new SerializationException((Throwable) e2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0059, code lost:
        if (c(r1, r8, r12) != false) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0093, code lost:
        if (r12.canEncode(r8) != false) goto L_0x0069;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void f(java.lang.Appendable r10, java.lang.String r11, org.jsoup.nodes.Document.OutputSettings r12, boolean r13, boolean r14, boolean r15) throws java.io.IOException {
        /*
            org.jsoup.nodes.Entities$EscapeMode r0 = r12.g()
            java.nio.charset.CharsetEncoder r12 = r12.e()
            java.nio.charset.Charset r1 = r12.charset()
            java.lang.String r1 = r1.name()
            org.jsoup.nodes.Entities$CoreCharset r1 = org.jsoup.nodes.Entities.CoreCharset.b(r1)
            int r2 = r11.length()
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
        L_0x001c:
            if (r4 >= r2) goto L_0x009c
            int r7 = r11.codePointAt(r4)
            if (r14 == 0) goto L_0x003c
            boolean r8 = org.jsoup.helper.StringUtil.f(r7)
            r9 = 1
            if (r8 == 0) goto L_0x003a
            if (r15 == 0) goto L_0x002f
            if (r5 == 0) goto L_0x0096
        L_0x002f:
            if (r6 == 0) goto L_0x0033
            goto L_0x0096
        L_0x0033:
            r6 = 32
            r10.append(r6)
            r6 = 1
            goto L_0x0096
        L_0x003a:
            r5 = 1
            r6 = 0
        L_0x003c:
            r8 = 65536(0x10000, float:9.18355E-41)
            if (r7 >= r8) goto L_0x0086
            char r8 = (char) r7
            r9 = 34
            if (r8 == r9) goto L_0x0081
            r9 = 38
            if (r8 == r9) goto L_0x007e
            r9 = 60
            if (r8 == r9) goto L_0x0075
            r9 = 62
            if (r8 == r9) goto L_0x0070
            r9 = 160(0xa0, float:2.24E-43)
            if (r8 == r9) goto L_0x0063
            boolean r9 = c(r1, r8, r12)
            if (r9 == 0) goto L_0x005f
        L_0x005b:
            r10.append(r8)
            goto L_0x0096
        L_0x005f:
            b(r10, r0, r7)
            goto L_0x0096
        L_0x0063:
            org.jsoup.nodes.Entities$EscapeMode r8 = org.jsoup.nodes.Entities.EscapeMode.xhtml
            if (r0 == r8) goto L_0x006d
            java.lang.String r8 = "&nbsp;"
        L_0x0069:
            r10.append(r8)
            goto L_0x0096
        L_0x006d:
            java.lang.String r8 = "&#xa0;"
            goto L_0x0069
        L_0x0070:
            if (r13 != 0) goto L_0x005b
            java.lang.String r8 = "&gt;"
            goto L_0x0069
        L_0x0075:
            if (r13 == 0) goto L_0x007b
            org.jsoup.nodes.Entities$EscapeMode r9 = org.jsoup.nodes.Entities.EscapeMode.xhtml
            if (r0 != r9) goto L_0x005b
        L_0x007b:
            java.lang.String r8 = "&lt;"
            goto L_0x0069
        L_0x007e:
            java.lang.String r8 = "&amp;"
            goto L_0x0069
        L_0x0081:
            if (r13 == 0) goto L_0x005b
            java.lang.String r8 = "&quot;"
            goto L_0x0069
        L_0x0086:
            java.lang.String r8 = new java.lang.String
            char[] r9 = java.lang.Character.toChars(r7)
            r8.<init>(r9)
            boolean r9 = r12.canEncode(r8)
            if (r9 == 0) goto L_0x005f
            goto L_0x0069
        L_0x0096:
            int r7 = java.lang.Character.charCount(r7)
            int r4 = r4 + r7
            goto L_0x001c
        L_0x009c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.nodes.Entities.f(java.lang.Appendable, java.lang.String, org.jsoup.nodes.Document$OutputSettings, boolean, boolean, boolean):void");
    }

    public static String g(String str) {
        String str2 = f31615d.get(str);
        if (str2 != null) {
            return str2;
        }
        int j2 = EscapeMode.extended.j(str);
        return j2 != -1 ? new String(new int[]{j2}, 0, 1) : "";
    }

    public static Character h(String str) {
        return Character.valueOf((char) EscapeMode.extended.j(str));
    }

    public static boolean i(String str) {
        return EscapeMode.base.j(str) != -1;
    }

    public static boolean j(String str) {
        return EscapeMode.extended.j(str) != -1;
    }

    /* access modifiers changed from: private */
    public static void k(EscapeMode escapeMode, String str, int i2) {
        int i3;
        String[] unused = escapeMode.s = new String[i2];
        int[] unused2 = escapeMode.X = new int[i2];
        int[] unused3 = escapeMode.Y = new int[i2];
        String[] unused4 = escapeMode.Z = new String[i2];
        Class<Entities> cls = Entities.class;
        InputStream resourceAsStream = cls.getResourceAsStream(str);
        if (resourceAsStream != null) {
            try {
                CharacterReader characterReader = new CharacterReader(Charset.forName("ascii").decode(DataUtil.l(resourceAsStream, 0)).toString());
                int i4 = 0;
                while (!characterReader.r()) {
                    String k2 = characterReader.k(ASCIIPropertyListParser.f18654l);
                    characterReader.a();
                    int parseInt = Integer.parseInt(characterReader.m(f31616e), 36);
                    char q = characterReader.q();
                    characterReader.a();
                    if (q == ',') {
                        i3 = Integer.parseInt(characterReader.k(ASCIIPropertyListParser.f18655m), 36);
                        characterReader.a();
                    } else {
                        i3 = -1;
                    }
                    String k3 = characterReader.k(10);
                    if (k3.charAt(k3.length() - 1) == 13) {
                        k3 = k3.substring(0, k3.length() - 1);
                    }
                    int parseInt2 = Integer.parseInt(k3, 36);
                    characterReader.a();
                    escapeMode.s[i4] = k2;
                    escapeMode.X[i4] = parseInt;
                    escapeMode.Y[parseInt2] = parseInt;
                    escapeMode.Z[parseInt2] = k2;
                    if (i3 != -1) {
                        f31615d.put(k2, new String(new int[]{parseInt, i3}, 0, 2));
                    }
                    i4++;
                }
            } catch (IOException unused5) {
                throw new IllegalStateException("Error reading resource " + str);
            }
        } else {
            throw new IllegalStateException("Could not read resource " + str + ". Make sure you copy resources for " + cls.getCanonicalName());
        }
    }

    static String l(String str) {
        return m(str, false);
    }

    static String m(String str, boolean z) {
        return Parser.p(str, z);
    }
}
