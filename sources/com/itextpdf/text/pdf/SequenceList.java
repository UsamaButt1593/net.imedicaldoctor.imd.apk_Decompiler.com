package com.itextpdf.text.pdf;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class SequenceList {

    /* renamed from: j  reason: collision with root package name */
    protected static final int f26390j = 1;

    /* renamed from: k  reason: collision with root package name */
    protected static final int f26391k = 2;

    /* renamed from: l  reason: collision with root package name */
    protected static final int f26392l = 3;

    /* renamed from: m  reason: collision with root package name */
    protected static final int f26393m = 4;

    /* renamed from: n  reason: collision with root package name */
    protected static final int f26394n = 5;
    protected static final int o = 6;
    protected static final char p = '￿';
    private static final int q = 0;
    private static final int r = 1;
    private static final int s = 2;
    private static final int t = 3;
    private static final String u = "-,!0123456789";

    /* renamed from: a  reason: collision with root package name */
    protected char[] f26395a;

    /* renamed from: b  reason: collision with root package name */
    protected int f26396b = 0;

    /* renamed from: c  reason: collision with root package name */
    protected int f26397c;

    /* renamed from: d  reason: collision with root package name */
    protected String f26398d;

    /* renamed from: e  reason: collision with root package name */
    protected int f26399e;

    /* renamed from: f  reason: collision with root package name */
    protected int f26400f;

    /* renamed from: g  reason: collision with root package name */
    protected boolean f26401g;

    /* renamed from: h  reason: collision with root package name */
    protected boolean f26402h;

    /* renamed from: i  reason: collision with root package name */
    protected boolean f26403i;

    protected SequenceList(String str) {
        this.f26395a = str.toCharArray();
    }

    public static List<Integer> a(String str, int i2) {
        int i3;
        int i4;
        SequenceList sequenceList = new SequenceList(str);
        LinkedList linkedList = new LinkedList();
        boolean z = false;
        while (!z) {
            z = sequenceList.b();
            int i5 = sequenceList.f26399e;
            int i6 = -1;
            if (i5 != -1 || sequenceList.f26400f != -1 || sequenceList.f26402h || sequenceList.f26401g) {
                int i7 = 1;
                if (i5 < 1) {
                    sequenceList.f26399e = 1;
                }
                int i8 = sequenceList.f26400f;
                if (i8 < 1 || i8 > i2) {
                    sequenceList.f26400f = i2;
                }
                if (sequenceList.f26399e > i2) {
                    sequenceList.f26399e = i2;
                }
                if (sequenceList.f26403i) {
                    int i9 = sequenceList.f26399e;
                    int i10 = sequenceList.f26400f;
                    if (i9 > i10) {
                        sequenceList.f26399e = i10;
                        sequenceList.f26400f = i9;
                    }
                    ListIterator listIterator = linkedList.listIterator();
                    while (listIterator.hasNext()) {
                        int intValue = ((Integer) listIterator.next()).intValue();
                        if ((!sequenceList.f26402h || (intValue & 1) != 1) && ((!sequenceList.f26401g || (intValue & 1) != 0) && intValue >= sequenceList.f26399e && intValue <= sequenceList.f26400f)) {
                            listIterator.remove();
                        }
                    }
                } else {
                    int i11 = sequenceList.f26399e;
                    if (i11 > sequenceList.f26400f) {
                        if (sequenceList.f26401g || sequenceList.f26402h) {
                            if (sequenceList.f26402h) {
                                i4 = i11 & -2;
                            } else {
                                if ((i11 & 1) == 1) {
                                    i7 = 0;
                                }
                                i4 = i11 - i7;
                            }
                            sequenceList.f26399e = i4;
                            i6 = -2;
                        }
                        for (int i12 = sequenceList.f26399e; i12 >= sequenceList.f26400f; i12 += i6) {
                            linkedList.add(Integer.valueOf(i12));
                        }
                    } else {
                        boolean z2 = sequenceList.f26401g;
                        if (z2 || sequenceList.f26402h) {
                            if (z2) {
                                i3 = i11 | 1;
                            } else {
                                if ((i11 & 1) != 1) {
                                    i7 = 0;
                                }
                                i3 = i11 + i7;
                            }
                            sequenceList.f26399e = i3;
                            i7 = 2;
                        }
                        for (int i13 = sequenceList.f26399e; i13 <= sequenceList.f26400f; i13 += i7) {
                            linkedList.add(Integer.valueOf(i13));
                        }
                    }
                }
            }
        }
        return linkedList;
    }

    private void e() {
        if (this.f26398d.equals("odd") || this.f26398d.equals("o")) {
            this.f26401g = true;
            this.f26402h = false;
        } else if (this.f26398d.equals("even") || this.f26398d.equals("e")) {
            this.f26401g = false;
            this.f26402h = true;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0028, code lost:
        e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002e, code lost:
        r7.f26400f = r2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0059  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean b() {
        /*
            r7 = this;
            r0 = -1
            r7.f26399e = r0
            r7.f26400f = r0
            r0 = 0
            r7.f26403i = r0
            r7.f26402h = r0
            r7.f26401g = r0
            r1 = 2
        L_0x000d:
            r2 = 2
        L_0x000e:
            int r3 = r7.c()
            r4 = 6
            r5 = 1
            if (r3 == r4) goto L_0x0057
            if (r3 != r5) goto L_0x0019
            goto L_0x0057
        L_0x0019:
            r4 = 3
            if (r2 == r5) goto L_0x0049
            r6 = 5
            if (r2 == r1) goto L_0x0034
            if (r2 == r4) goto L_0x0022
            goto L_0x000e
        L_0x0022:
            if (r3 == r1) goto L_0x000e
            if (r3 == r4) goto L_0x0031
            if (r3 == r6) goto L_0x002c
        L_0x0028:
            r7.e()
            goto L_0x000d
        L_0x002c:
            int r2 = r7.f26397c
        L_0x002e:
            r7.f26400f = r2
            goto L_0x000d
        L_0x0031:
            r7.f26403i = r5
            goto L_0x000d
        L_0x0034:
            if (r3 == r1) goto L_0x0047
            if (r3 == r4) goto L_0x0044
            if (r3 != r6) goto L_0x0040
            int r2 = r7.f26397c
            r7.f26399e = r2
            r2 = 1
            goto L_0x000e
        L_0x0040:
            r7.e()
            goto L_0x000e
        L_0x0044:
            r7.f26403i = r5
            goto L_0x000e
        L_0x0047:
            r2 = 3
            goto L_0x000e
        L_0x0049:
            if (r3 == r1) goto L_0x0047
            if (r3 == r4) goto L_0x0052
            int r2 = r7.f26399e
            r7.f26400f = r2
            goto L_0x0028
        L_0x0052:
            r7.f26403i = r5
            int r2 = r7.f26399e
            goto L_0x002e
        L_0x0057:
            if (r2 != r5) goto L_0x005d
            int r1 = r7.f26399e
            r7.f26400f = r1
        L_0x005d:
            if (r3 != r4) goto L_0x0060
            r0 = 1
        L_0x0060:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.SequenceList.b():boolean");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0015, code lost:
        r0 = r0.toString();
        r9.f26398d = r0;
        r9.f26397c = java.lang.Integer.parseInt(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0021, code lost:
        return 5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int c() {
        /*
            r9 = this;
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            r1 = 0
        L_0x0006:
            char r2 = r9.d()
            r3 = 65535(0xffff, float:9.1834E-41)
            r4 = 4
            r5 = 5
            r6 = 2
            r7 = 1
            if (r2 != r3) goto L_0x0031
            if (r1 != r7) goto L_0x0022
        L_0x0015:
            java.lang.String r0 = r0.toString()
            r9.f26398d = r0
            int r0 = java.lang.Integer.parseInt(r0)
            r9.f26397c = r0
            return r5
        L_0x0022:
            if (r1 != r6) goto L_0x002f
        L_0x0024:
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = r0.toLowerCase()
            r9.f26398d = r0
            return r4
        L_0x002f:
            r0 = 6
            return r0
        L_0x0031:
            r3 = 57
            r8 = 48
            if (r1 == 0) goto L_0x0055
            if (r1 == r7) goto L_0x004c
            if (r1 == r6) goto L_0x003c
            goto L_0x0006
        L_0x003c:
            java.lang.String r3 = "-,!0123456789"
            int r3 = r3.indexOf(r2)
            if (r3 >= 0) goto L_0x0048
        L_0x0044:
            r0.append(r2)
            goto L_0x0006
        L_0x0048:
            r9.f()
            goto L_0x0024
        L_0x004c:
            if (r2 < r8) goto L_0x0051
            if (r2 > r3) goto L_0x0051
            goto L_0x0044
        L_0x0051:
            r9.f()
            goto L_0x0015
        L_0x0055:
            r1 = 33
            if (r2 == r1) goto L_0x006e
            r1 = 44
            if (r2 == r1) goto L_0x006d
            r1 = 45
            if (r2 == r1) goto L_0x006c
            r0.append(r2)
            if (r2 < r8) goto L_0x006a
            if (r2 > r3) goto L_0x006a
            r1 = 1
            goto L_0x0006
        L_0x006a:
            r1 = 2
            goto L_0x0006
        L_0x006c:
            return r6
        L_0x006d:
            return r7
        L_0x006e:
            r0 = 3
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.SequenceList.c():int");
    }

    /* access modifiers changed from: protected */
    public char d() {
        char c2;
        do {
            int i2 = this.f26396b;
            char[] cArr = this.f26395a;
            if (i2 >= cArr.length) {
                return 65535;
            }
            this.f26396b = i2 + 1;
            c2 = cArr[i2];
        } while (c2 <= ' ');
        return c2;
    }

    /* access modifiers changed from: protected */
    public void f() {
        int i2 = this.f26396b - 1;
        this.f26396b = i2;
        if (i2 < 0) {
            this.f26396b = 0;
        }
    }
}
