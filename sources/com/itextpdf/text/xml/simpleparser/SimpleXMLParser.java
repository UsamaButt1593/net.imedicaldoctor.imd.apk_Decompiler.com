package com.itextpdf.text.xml.simpleparser;

import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.xml.XMLUtil;
import com.itextpdf.text.xml.simpleparser.handler.HTMLNewLineHandler;
import com.itextpdf.text.xml.simpleparser.handler.NeverNewLineHandler;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Stack;

public final class SimpleXMLParser {
    private static final int A = 6;
    private static final int B = 7;
    private static final int C = 8;
    private static final int D = 9;
    private static final int E = 10;
    private static final int F = 11;
    private static final int G = 12;
    private static final int H = 13;
    private static final int I = 14;
    private static final int u = 0;
    private static final int v = 1;
    private static final int w = 2;
    private static final int x = 3;
    private static final int y = 4;
    private static final int z = 5;

    /* renamed from: a  reason: collision with root package name */
    private final Stack<Integer> f27380a;

    /* renamed from: b  reason: collision with root package name */
    private int f27381b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f27382c = -1;

    /* renamed from: d  reason: collision with root package name */
    private int f27383d = 1;

    /* renamed from: e  reason: collision with root package name */
    private int f27384e = 0;

    /* renamed from: f  reason: collision with root package name */
    private boolean f27385f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f27386g = false;

    /* renamed from: h  reason: collision with root package name */
    private int f27387h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f27388i;

    /* renamed from: j  reason: collision with root package name */
    private final StringBuffer f27389j = new StringBuffer();

    /* renamed from: k  reason: collision with root package name */
    private final StringBuffer f27390k = new StringBuffer();

    /* renamed from: l  reason: collision with root package name */
    private String f27391l = null;

    /* renamed from: m  reason: collision with root package name */
    private HashMap<String, String> f27392m = null;

    /* renamed from: n  reason: collision with root package name */
    private final SimpleXMLDocHandler f27393n;
    private final SimpleXMLDocHandlerComment o;
    private int p = 0;
    private int q = 34;
    private String r = null;
    private String s = null;
    private NewLineHandler t;

    private SimpleXMLParser(SimpleXMLDocHandler simpleXMLDocHandler, SimpleXMLDocHandlerComment simpleXMLDocHandlerComment, boolean z2) {
        this.f27393n = simpleXMLDocHandler;
        this.o = simpleXMLDocHandlerComment;
        this.f27388i = z2;
        this.t = z2 ? new HTMLNewLineHandler() : new NeverNewLineHandler();
        this.f27380a = new Stack<>();
        this.f27387h = z2 ? 1 : 0;
    }

    private void a() {
        if (this.f27391l == null) {
            this.f27391l = this.f27389j.toString();
        }
        if (this.f27388i) {
            this.f27391l = this.f27391l.toLowerCase();
        }
        this.f27389j.setLength(0);
    }

    @Deprecated
    public static String b(String str, boolean z2) {
        return XMLUtil.a(str, z2);
    }

    private void c() {
        int i2 = this.f27387h;
        if (i2 != 1) {
            if (i2 != 14) {
                if (i2 != 7) {
                    if (i2 == 8) {
                        SimpleXMLDocHandlerComment simpleXMLDocHandlerComment = this.o;
                        if (simpleXMLDocHandlerComment != null) {
                            simpleXMLDocHandlerComment.b(this.f27389j.toString());
                        }
                    } else if (i2 != 11) {
                        if (i2 == 12) {
                            String stringBuffer = this.f27389j.toString();
                            this.r = stringBuffer;
                            if (this.f27388i) {
                                this.r = stringBuffer.toLowerCase();
                            }
                        }
                    }
                    this.f27389j.setLength(0);
                }
            }
            String stringBuffer2 = this.f27389j.toString();
            this.s = stringBuffer2;
            this.f27392m.put(this.r, stringBuffer2);
            this.f27389j.setLength(0);
        }
        if (this.f27389j.length() > 0) {
            this.f27393n.a(this.f27389j.toString());
        }
        this.f27389j.setLength(0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003a, code lost:
        r3 = r3 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String d(java.lang.String r5) {
        /*
            r0 = 0
            if (r5 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.String r1 = "encoding"
            int r1 = r5.indexOf(r1)
            if (r1 >= 0) goto L_0x000d
            return r0
        L_0x000d:
            r2 = 34
            int r3 = r5.indexOf(r2, r1)
            r4 = 39
            int r1 = r5.indexOf(r4, r1)
            if (r3 != r1) goto L_0x001c
            return r0
        L_0x001c:
            if (r3 >= 0) goto L_0x0020
            if (r1 > 0) goto L_0x0024
        L_0x0020:
            if (r1 <= 0) goto L_0x0032
            if (r1 >= r3) goto L_0x0032
        L_0x0024:
            int r1 = r1 + 1
            int r2 = r5.indexOf(r4, r1)
            if (r2 >= 0) goto L_0x002d
            return r0
        L_0x002d:
            java.lang.String r5 = r5.substring(r1, r2)
            return r5
        L_0x0032:
            if (r1 >= 0) goto L_0x0036
            if (r3 > 0) goto L_0x003a
        L_0x0036:
            if (r3 <= 0) goto L_0x0048
            if (r3 >= r1) goto L_0x0048
        L_0x003a:
            int r3 = r3 + 1
            int r1 = r5.indexOf(r2, r3)
            if (r1 >= 0) goto L_0x0043
            return r0
        L_0x0043:
            java.lang.String r5 = r5.substring(r3, r1)
            return r5
        L_0x0048:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.xml.simpleparser.SimpleXMLParser.d(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x016e, code lost:
        r4 = r0.f27389j;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0170, code lost:
        r4.append((char) r0.f27381b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x019b, code lost:
        r0.f27390k.setLength(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x0235, code lost:
        if (r0.f27389j.toString().endsWith("--") != false) goto L_0x0237;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x0237, code lost:
        r4 = r0.f27389j;
        r4.setLength(r4.length() - 2);
        c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x0257, code lost:
        if (r0.f27389j.toString().endsWith("]]") != false) goto L_0x0237;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x0347, code lost:
        r4 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:0x0018, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ab, code lost:
        c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00ae, code lost:
        j(true);
        f();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00b4, code lost:
        r4 = k();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00b8, code lost:
        r0.f27387h = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00c8, code lost:
        r0.f27387h = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00d2, code lost:
        m(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00de, code lost:
        r0.f27387h = 14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00f3, code lost:
        r0.f27389j.setLength(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0102, code lost:
        r0.f27387h = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x010b, code lost:
        r0.f27389j.append((char) r0.f27381b);
        r0.f27387h = 12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0137, code lost:
        if (r4 == 62) goto L_0x00f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x013a, code lost:
        r0.f27389j.append((char) r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0162, code lost:
        r0.f27387h = 4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void e(java.io.Reader r17) throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = 0
            r3 = 1
            boolean r4 = r1 instanceof java.io.BufferedReader
            if (r4 == 0) goto L_0x000d
            java.io.BufferedReader r1 = (java.io.BufferedReader) r1
            goto L_0x0013
        L_0x000d:
            java.io.BufferedReader r4 = new java.io.BufferedReader
            r4.<init>(r1)
            r1 = r4
        L_0x0013:
            com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler r4 = r0.f27393n
            r4.startDocument()
        L_0x0018:
            int r4 = r0.f27382c
            r5 = -1
            if (r4 != r5) goto L_0x0024
            int r4 = r1.read()
            r0.f27381b = r4
            goto L_0x0028
        L_0x0024:
            r0.f27381b = r4
            r0.f27382c = r5
        L_0x0028:
            int r4 = r0.f27381b
            if (r4 != r5) goto L_0x004b
            boolean r1 = r0.f27388i
            if (r1 == 0) goto L_0x003f
            if (r1 == 0) goto L_0x0039
            int r1 = r0.f27387h
            if (r1 != r3) goto L_0x0039
            r16.c()
        L_0x0039:
            com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler r1 = r0.f27393n
            r1.endDocument()
            goto L_0x004a
        L_0x003f:
            java.lang.String r1 = "missing.end.tag"
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r1 = com.itextpdf.text.error_messages.MessageLocalization.b(r1, r2)
            r0.m(r1)
        L_0x004a:
            return
        L_0x004b:
            r5 = 10
            if (r4 != r5) goto L_0x0056
            boolean r6 = r0.f27385f
            if (r6 == 0) goto L_0x0056
            r0.f27385f = r2
            goto L_0x0018
        L_0x0056:
            boolean r6 = r0.f27385f
            r7 = 13
            if (r6 == 0) goto L_0x005f
            r0.f27385f = r2
            goto L_0x0075
        L_0x005f:
            if (r4 != r5) goto L_0x0069
        L_0x0061:
            int r4 = r0.f27383d
            int r4 = r4 + r3
            r0.f27383d = r4
            r0.f27384e = r2
            goto L_0x0075
        L_0x0069:
            if (r4 != r7) goto L_0x0070
            r0.f27385f = r3
            r0.f27381b = r5
            goto L_0x0061
        L_0x0070:
            int r4 = r0.f27384e
            int r4 = r4 + r3
            r0.f27384e = r4
        L_0x0075:
            int r4 = r0.f27387h
            r10 = 12
            r11 = 14
            r12 = 61
            java.lang.String r13 = "error.in.attribute.processing"
            r14 = 4
            r15 = 6
            r8 = 38
            r6 = 47
            r9 = 32
            r5 = 62
            switch(r4) {
                case 0: goto L_0x0399;
                case 1: goto L_0x0339;
                case 2: goto L_0x031e;
                case 3: goto L_0x02b6;
                case 4: goto L_0x02a3;
                case 5: goto L_0x0287;
                case 6: goto L_0x025a;
                case 7: goto L_0x0247;
                case 8: goto L_0x0225;
                case 9: goto L_0x0215;
                case 10: goto L_0x01a2;
                case 11: goto L_0x0142;
                case 12: goto L_0x011e;
                case 13: goto L_0x00da;
                case 14: goto L_0x008d;
                default: goto L_0x008c;
            }
        L_0x008c:
            goto L_0x0018
        L_0x008d:
            int r4 = r0.f27381b
            r6 = 34
            r7 = 11
            if (r4 == r6) goto L_0x00d7
            r6 = 39
            if (r4 != r6) goto L_0x009a
            goto L_0x00d7
        L_0x009a:
            char r4 = (char) r4
            boolean r4 = java.lang.Character.isWhitespace(r4)
            if (r4 == 0) goto L_0x00a3
            goto L_0x0018
        L_0x00a3:
            boolean r4 = r0.f27388i
            if (r4 == 0) goto L_0x00bc
            int r6 = r0.f27381b
            if (r6 != r5) goto L_0x00bc
        L_0x00ab:
            r16.c()
        L_0x00ae:
            r0.j(r3)
            r16.f()
        L_0x00b4:
            int r4 = r16.k()
        L_0x00b8:
            r0.f27387h = r4
            goto L_0x0018
        L_0x00bc:
            if (r4 == 0) goto L_0x00cc
            java.lang.StringBuffer r4 = r0.f27389j
            int r5 = r0.f27381b
            char r5 = (char) r5
            r4.append(r5)
            r0.q = r9
        L_0x00c8:
            r0.f27387h = r7
            goto L_0x0018
        L_0x00cc:
            java.lang.Object[] r4 = new java.lang.Object[r2]
            java.lang.String r4 = com.itextpdf.text.error_messages.MessageLocalization.b(r13, r4)
        L_0x00d2:
            r0.m(r4)
            goto L_0x0018
        L_0x00d7:
            r0.q = r4
            goto L_0x00c8
        L_0x00da:
            int r4 = r0.f27381b
            if (r4 != r12) goto L_0x00e2
        L_0x00de:
            r0.f27387h = r11
            goto L_0x0018
        L_0x00e2:
            char r4 = (char) r4
            boolean r4 = java.lang.Character.isWhitespace(r4)
            if (r4 == 0) goto L_0x00eb
            goto L_0x0018
        L_0x00eb:
            boolean r4 = r0.f27388i
            if (r4 == 0) goto L_0x00f9
            int r7 = r0.f27381b
            if (r7 != r5) goto L_0x00f9
        L_0x00f3:
            java.lang.StringBuffer r4 = r0.f27389j
            r4.setLength(r2)
            goto L_0x00ae
        L_0x00f9:
            if (r4 == 0) goto L_0x0106
            int r5 = r0.f27381b
            if (r5 != r6) goto L_0x0106
            r16.c()
        L_0x0102:
            r0.f27387h = r15
            goto L_0x0018
        L_0x0106:
            if (r4 == 0) goto L_0x0117
            r16.c()
        L_0x010b:
            java.lang.StringBuffer r4 = r0.f27389j
            int r5 = r0.f27381b
            char r5 = (char) r5
            r4.append(r5)
            r0.f27387h = r10
            goto L_0x0018
        L_0x0117:
            java.lang.Object[] r4 = new java.lang.Object[r2]
            java.lang.String r4 = com.itextpdf.text.error_messages.MessageLocalization.b(r13, r4)
            goto L_0x00d2
        L_0x011e:
            int r4 = r0.f27381b
            char r4 = (char) r4
            boolean r4 = java.lang.Character.isWhitespace(r4)
            if (r4 == 0) goto L_0x012b
            r16.c()
            goto L_0x00c8
        L_0x012b:
            int r4 = r0.f27381b
            if (r4 != r12) goto L_0x0133
            r16.c()
            goto L_0x00de
        L_0x0133:
            boolean r6 = r0.f27388i
            if (r6 == 0) goto L_0x013a
            if (r4 != r5) goto L_0x013a
            goto L_0x00f3
        L_0x013a:
            java.lang.StringBuffer r5 = r0.f27389j
            char r4 = (char) r4
            r5.append(r4)
            goto L_0x0018
        L_0x0142:
            boolean r4 = r0.f27388i
            if (r4 == 0) goto L_0x0150
            int r6 = r0.q
            if (r6 != r9) goto L_0x0150
            int r6 = r0.f27381b
            if (r6 != r5) goto L_0x0150
            goto L_0x00ab
        L_0x0150:
            if (r4 == 0) goto L_0x0166
            int r4 = r0.q
            if (r4 != r9) goto L_0x0166
            int r4 = r0.f27381b
            char r4 = (char) r4
            boolean r4 = java.lang.Character.isWhitespace(r4)
            if (r4 == 0) goto L_0x0166
        L_0x015f:
            r16.c()
        L_0x0162:
            r0.f27387h = r14
            goto L_0x0018
        L_0x0166:
            boolean r4 = r0.f27388i
            if (r4 == 0) goto L_0x0178
            int r4 = r0.q
            if (r4 != r9) goto L_0x0178
        L_0x016e:
            java.lang.StringBuffer r4 = r0.f27389j
        L_0x0170:
            int r5 = r0.f27381b
            char r5 = (char) r5
            r4.append(r5)
            goto L_0x0018
        L_0x0178:
            int r4 = r0.f27381b
            int r5 = r0.q
            if (r4 != r5) goto L_0x017f
            goto L_0x015f
        L_0x017f:
            java.lang.String r5 = " \r\n\t"
            int r4 = r5.indexOf(r4)
            if (r4 < 0) goto L_0x018e
            java.lang.StringBuffer r4 = r0.f27389j
            r4.append(r9)
            goto L_0x0018
        L_0x018e:
            int r4 = r0.f27381b
            if (r4 != r8) goto L_0x013a
            int r4 = r0.f27387h
            r0.l(r4)
            r4 = 10
            r0.f27387h = r4
        L_0x019b:
            java.lang.StringBuffer r4 = r0.f27390k
            r4.setLength(r2)
            goto L_0x0018
        L_0x01a2:
            int r4 = r0.f27381b
            r5 = 59
            if (r4 != r5) goto L_0x01d3
            int r4 = r16.k()
            r0.f27387h = r4
            java.lang.StringBuffer r4 = r0.f27390k
            java.lang.String r4 = r4.toString()
            java.lang.StringBuffer r6 = r0.f27390k
            r6.setLength(r2)
            char r6 = com.itextpdf.text.xml.simpleparser.EntitiesToUnicode.a(r4)
            if (r6 != 0) goto L_0x01cc
            java.lang.StringBuffer r6 = r0.f27389j
            r6.append(r8)
            r6.append(r4)
            r6.append(r5)
            goto L_0x0018
        L_0x01cc:
            java.lang.StringBuffer r4 = r0.f27389j
            r4.append(r6)
            goto L_0x0018
        L_0x01d3:
            r5 = 35
            if (r4 == r5) goto L_0x01ef
            r5 = 48
            if (r4 < r5) goto L_0x01df
            r5 = 57
            if (r4 <= r5) goto L_0x01ef
        L_0x01df:
            r5 = 97
            if (r4 < r5) goto L_0x01e7
            r5 = 122(0x7a, float:1.71E-43)
            if (r4 <= r5) goto L_0x01ef
        L_0x01e7:
            r5 = 65
            if (r4 < r5) goto L_0x01f8
            r5 = 90
            if (r4 > r5) goto L_0x01f8
        L_0x01ef:
            java.lang.StringBuffer r4 = r0.f27390k
            int r4 = r4.length()
            r5 = 7
            if (r4 < r5) goto L_0x0211
        L_0x01f8:
            int r4 = r16.k()
            r0.f27387h = r4
            int r4 = r0.f27381b
            r0.f27382c = r4
            java.lang.StringBuffer r4 = r0.f27389j
            r4.append(r8)
            java.lang.StringBuffer r5 = r0.f27390k
            java.lang.String r5 = r5.toString()
            r4.append(r5)
            goto L_0x019b
        L_0x0211:
            java.lang.StringBuffer r4 = r0.f27390k
            goto L_0x0170
        L_0x0215:
            int r4 = r0.f27381b
            if (r4 != r5) goto L_0x0018
            int r4 = r16.k()
            r0.f27387h = r4
            if (r4 != r3) goto L_0x0018
            r0.f27387h = r2
            goto L_0x0018
        L_0x0225:
            int r4 = r0.f27381b
            if (r4 != r5) goto L_0x016e
            java.lang.StringBuffer r4 = r0.f27389j
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "--"
            boolean r4 = r4.endsWith(r5)
            if (r4 == 0) goto L_0x016e
        L_0x0237:
            java.lang.StringBuffer r4 = r0.f27389j
            int r5 = r4.length()
            r6 = 2
            int r5 = r5 - r6
            r4.setLength(r5)
            r16.c()
            goto L_0x00b4
        L_0x0247:
            int r4 = r0.f27381b
            if (r4 != r5) goto L_0x016e
            java.lang.StringBuffer r4 = r0.f27389j
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "]]"
            boolean r4 = r4.endsWith(r5)
            if (r4 == 0) goto L_0x016e
            goto L_0x0237
        L_0x025a:
            int r4 = r0.f27381b
            if (r4 == r5) goto L_0x026d
            java.lang.String r4 = r0.f27391l
            java.lang.Object[] r5 = new java.lang.Object[r3]
            r5[r2] = r4
            java.lang.String r4 = "expected.gt.for.tag.lt.1.gt"
            java.lang.String r4 = com.itextpdf.text.error_messages.MessageLocalization.b(r4, r5)
            r0.m(r4)
        L_0x026d:
            r16.a()
            r0.j(r3)
            r0.j(r2)
            r16.f()
            boolean r4 = r0.f27388i
            if (r4 != 0) goto L_0x00b4
            int r4 = r0.p
            if (r4 != 0) goto L_0x00b4
            com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler r1 = r0.f27393n
            r1.endDocument()
            return
        L_0x0287:
            int r4 = r0.f27381b
            if (r4 != r5) goto L_0x029a
            r16.a()
            r0.j(r2)
            boolean r4 = r0.f27388i
            if (r4 != 0) goto L_0x00b4
            int r4 = r0.p
            if (r4 != 0) goto L_0x00b4
            return
        L_0x029a:
            char r4 = (char) r4
            boolean r4 = java.lang.Character.isWhitespace(r4)
            if (r4 != 0) goto L_0x0018
            goto L_0x016e
        L_0x02a3:
            int r4 = r0.f27381b
            if (r4 != r5) goto L_0x02a9
            goto L_0x00ae
        L_0x02a9:
            if (r4 != r6) goto L_0x02ad
        L_0x02ab:
            goto L_0x0102
        L_0x02ad:
            char r4 = (char) r4
            boolean r4 = java.lang.Character.isWhitespace(r4)
            if (r4 == 0) goto L_0x010b
            goto L_0x0018
        L_0x02b6:
            int r4 = r0.f27381b
            if (r4 != r5) goto L_0x02bf
            r16.a()
            goto L_0x00ae
        L_0x02bf:
            if (r4 != r6) goto L_0x02c2
            goto L_0x02ab
        L_0x02c2:
            r5 = 45
            if (r4 != r5) goto L_0x02db
            java.lang.StringBuffer r4 = r0.f27389j
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "!-"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x02db
            r16.c()
            r4 = 8
            goto L_0x00b8
        L_0x02db:
            int r4 = r0.f27381b
            r5 = 91
            if (r4 != r5) goto L_0x02f5
            java.lang.StringBuffer r4 = r0.f27389j
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "![CDATA"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x02f5
            r16.c()
            r4 = 7
            goto L_0x00b8
        L_0x02f5:
            int r4 = r0.f27381b
            r5 = 69
            if (r4 != r5) goto L_0x0310
            java.lang.StringBuffer r4 = r0.f27389j
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "!DOCTYP"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0310
            r16.c()
        L_0x030c:
            r4 = 9
            goto L_0x00b8
        L_0x0310:
            int r4 = r0.f27381b
            char r4 = (char) r4
            boolean r4 = java.lang.Character.isWhitespace(r4)
            if (r4 == 0) goto L_0x016e
            r16.a()
            goto L_0x0162
        L_0x031e:
            r16.f()
            int r4 = r0.f27381b
            if (r4 != r6) goto L_0x0328
            r4 = 5
            goto L_0x00b8
        L_0x0328:
            r5 = 63
            if (r4 != r5) goto L_0x0330
            r16.k()
            goto L_0x030c
        L_0x0330:
            java.lang.StringBuffer r5 = r0.f27389j
            char r4 = (char) r4
            r5.append(r4)
            r4 = 3
            goto L_0x00b8
        L_0x0339:
            int r5 = r0.f27381b
            r6 = 60
            if (r5 != r6) goto L_0x034a
            r16.c()
            int r4 = r0.f27387h
            r0.l(r4)
        L_0x0347:
            r4 = 2
            goto L_0x00b8
        L_0x034a:
            if (r5 != r8) goto L_0x035c
            r0.l(r4)
            java.lang.StringBuffer r4 = r0.f27390k
            r4.setLength(r2)
            r4 = 10
            r0.f27387h = r4
        L_0x0358:
            r0.f27386g = r3
            goto L_0x0018
        L_0x035c:
            if (r5 != r9) goto L_0x037a
            boolean r4 = r0.f27388i
            if (r4 == 0) goto L_0x036f
            boolean r4 = r0.f27386g
            if (r4 == 0) goto L_0x036f
            java.lang.StringBuffer r4 = r0.f27389j
            r4.append(r9)
        L_0x036b:
            r0.f27386g = r2
            goto L_0x0018
        L_0x036f:
            boolean r4 = r0.f27386g
            if (r4 == 0) goto L_0x036b
            java.lang.StringBuffer r4 = r0.f27389j
        L_0x0375:
            char r5 = (char) r5
            r4.append(r5)
            goto L_0x036b
        L_0x037a:
            char r4 = (char) r5
            boolean r4 = java.lang.Character.isWhitespace(r4)
            if (r4 == 0) goto L_0x0390
            boolean r4 = r0.f27388i
            if (r4 == 0) goto L_0x0387
            goto L_0x0018
        L_0x0387:
            boolean r4 = r0.f27386g
            if (r4 == 0) goto L_0x036b
            java.lang.StringBuffer r4 = r0.f27389j
            int r5 = r0.f27381b
            goto L_0x0375
        L_0x0390:
            java.lang.StringBuffer r4 = r0.f27389j
            int r5 = r0.f27381b
            char r5 = (char) r5
            r4.append(r5)
            goto L_0x0358
        L_0x0399:
            int r4 = r0.f27381b
            r5 = 60
            if (r4 != r5) goto L_0x0018
            r0.l(r3)
            goto L_0x0347
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.xml.simpleparser.SimpleXMLParser.e(java.io.Reader):void");
    }

    private void f() {
        this.f27391l = null;
        this.f27392m = new HashMap<>();
    }

    public static void g(SimpleXMLDocHandler simpleXMLDocHandler, SimpleXMLDocHandlerComment simpleXMLDocHandlerComment, Reader reader, boolean z2) throws IOException {
        new SimpleXMLParser(simpleXMLDocHandler, simpleXMLDocHandlerComment, z2).e(reader);
    }

    public static void h(SimpleXMLDocHandler simpleXMLDocHandler, InputStream inputStream) throws IOException {
        String str;
        String d2;
        byte[] bArr = new byte[4];
        if (inputStream.read(bArr) == 4) {
            String c2 = XMLUtil.c(bArr);
            if (c2.equals("UTF-8")) {
                StringBuffer stringBuffer = new StringBuffer();
                while (true) {
                    int read = inputStream.read();
                    if (read == -1 || read == 62) {
                        str = stringBuffer.toString();
                    } else {
                        stringBuffer.append((char) read);
                    }
                }
                str = stringBuffer.toString();
            } else if (c2.equals("CP037")) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int read2 = inputStream.read();
                    if (read2 == -1 || read2 == 110) {
                        str = new String(byteArrayOutputStream.toByteArray(), "CP037");
                    } else {
                        byteArrayOutputStream.write(read2);
                    }
                }
                str = new String(byteArrayOutputStream.toByteArray(), "CP037");
            } else {
                str = null;
            }
            if (!(str == null || (d2 = d(str)) == null)) {
                c2 = d2;
            }
            i(simpleXMLDocHandler, new InputStreamReader(inputStream, IanaEncodings.a(c2)));
            return;
        }
        throw new IOException(MessageLocalization.b("insufficient.length", new Object[0]));
    }

    public static void i(SimpleXMLDocHandler simpleXMLDocHandler, Reader reader) throws IOException {
        g(simpleXMLDocHandler, (SimpleXMLDocHandlerComment) null, reader, false);
    }

    private void j(boolean z2) {
        if (z2) {
            this.p++;
            this.f27393n.e(this.f27391l, this.f27392m);
            return;
        }
        if (this.t.a(this.f27391l)) {
            this.f27386g = false;
        }
        this.p--;
        this.f27393n.d(this.f27391l);
    }

    private int k() {
        if (!this.f27380a.empty()) {
            return this.f27380a.pop().intValue();
        }
        return 0;
    }

    private void l(int i2) {
        this.f27380a.push(Integer.valueOf(i2));
    }

    private void m(String str) throws IOException {
        throw new IOException(MessageLocalization.b("1.near.line.2.column.3", str, String.valueOf(this.f27383d), String.valueOf(this.f27384e)));
    }
}
