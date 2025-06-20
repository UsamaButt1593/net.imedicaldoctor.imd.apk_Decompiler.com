package androidx.media3.exoplayer.dash.manifest;

import androidx.media3.common.util.UnstableApi;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@UnstableApi
public final class UrlTemplate {

    /* renamed from: d  reason: collision with root package name */
    private static final String f11218d = "RepresentationID";

    /* renamed from: e  reason: collision with root package name */
    private static final String f11219e = "Number";

    /* renamed from: f  reason: collision with root package name */
    private static final String f11220f = "Bandwidth";

    /* renamed from: g  reason: collision with root package name */
    private static final String f11221g = "Time";

    /* renamed from: h  reason: collision with root package name */
    private static final String f11222h = "$$";

    /* renamed from: i  reason: collision with root package name */
    private static final String f11223i = "%01d";

    /* renamed from: j  reason: collision with root package name */
    private static final int f11224j = 1;

    /* renamed from: k  reason: collision with root package name */
    private static final int f11225k = 2;

    /* renamed from: l  reason: collision with root package name */
    private static final int f11226l = 3;

    /* renamed from: m  reason: collision with root package name */
    private static final int f11227m = 4;

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f11228a;

    /* renamed from: b  reason: collision with root package name */
    private final List<Integer> f11229b;

    /* renamed from: c  reason: collision with root package name */
    private final List<String> f11230c;

    private UrlTemplate(List<String> list, List<Integer> list2, List<String> list3) {
        this.f11228a = list;
        this.f11229b = list2;
        this.f11230c = list3;
    }

    public static UrlTemplate b(String str) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        c(str, arrayList, arrayList2, arrayList3);
        return new UrlTemplate(arrayList, arrayList2, arrayList3);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0132, code lost:
        r5 = java.lang.Integer.valueOf(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0136, code lost:
        r13.add(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0141, code lost:
        r14.set(r13.size() - 1, r8);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void c(java.lang.String r11, java.util.List<java.lang.String> r12, java.util.List<java.lang.Integer> r13, java.util.List<java.lang.String> r14) {
        /*
            r0 = -1
            r1 = 2
            r2 = 1
            java.lang.String r3 = ""
            r12.add(r3)
            r4 = 0
            r5 = 0
        L_0x000a:
            int r6 = r11.length()
            if (r5 >= r6) goto L_0x0150
            java.lang.String r6 = "$"
            int r7 = r11.indexOf(r6, r5)
            if (r7 != r0) goto L_0x0041
            int r6 = r13.size()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            int r8 = r13.size()
            java.lang.Object r8 = r12.get(r8)
            java.lang.String r8 = (java.lang.String) r8
            r7.append(r8)
            java.lang.String r5 = r11.substring(r5)
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            r12.set(r6, r5)
            int r5 = r11.length()
            goto L_0x000a
        L_0x0041:
            if (r7 == r5) goto L_0x0069
            int r6 = r13.size()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            int r9 = r13.size()
            java.lang.Object r9 = r12.get(r9)
            java.lang.String r9 = (java.lang.String) r9
            r8.append(r9)
            java.lang.String r5 = r11.substring(r5, r7)
            r8.append(r5)
            java.lang.String r5 = r8.toString()
            r12.set(r6, r5)
            r5 = r7
            goto L_0x000a
        L_0x0069:
            java.lang.String r7 = "$$"
            boolean r7 = r11.startsWith(r7, r5)
            if (r7 == 0) goto L_0x0094
            int r7 = r13.size()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            int r9 = r13.size()
            java.lang.Object r9 = r12.get(r9)
            java.lang.String r9 = (java.lang.String) r9
            r8.append(r9)
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            r12.set(r7, r6)
            int r5 = r5 + r1
            goto L_0x000a
        L_0x0094:
            r14.add(r3)
            int r5 = r5 + r2
            int r6 = r11.indexOf(r6, r5)
            java.lang.String r5 = r11.substring(r5, r6)
            java.lang.String r7 = "RepresentationID"
            boolean r7 = r5.equals(r7)
            if (r7 == 0) goto L_0x00b1
            java.lang.Integer r5 = java.lang.Integer.valueOf(r2)
            r13.add(r5)
            goto L_0x0149
        L_0x00b1:
            java.lang.String r7 = "%0"
            int r7 = r5.indexOf(r7)
            if (r7 == r0) goto L_0x00e9
            java.lang.String r8 = r5.substring(r7)
            java.lang.String r9 = "d"
            boolean r10 = r8.endsWith(r9)
            if (r10 != 0) goto L_0x00e4
            java.lang.String r10 = "x"
            boolean r10 = r8.endsWith(r10)
            if (r10 != 0) goto L_0x00e4
            java.lang.String r10 = "X"
            boolean r10 = r8.endsWith(r10)
            if (r10 != 0) goto L_0x00e4
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r8)
            r10.append(r9)
            java.lang.String r8 = r10.toString()
        L_0x00e4:
            java.lang.String r5 = r5.substring(r4, r7)
            goto L_0x00eb
        L_0x00e9:
            java.lang.String r8 = "%01d"
        L_0x00eb:
            r5.hashCode()
            int r7 = r5.hashCode()
            switch(r7) {
                case -1950496919: goto L_0x010d;
                case 2606829: goto L_0x0102;
                case 38199441: goto L_0x00f7;
                default: goto L_0x00f5;
            }
        L_0x00f5:
            r5 = -1
            goto L_0x0117
        L_0x00f7:
            java.lang.String r7 = "Bandwidth"
            boolean r5 = r5.equals(r7)
            if (r5 != 0) goto L_0x0100
            goto L_0x00f5
        L_0x0100:
            r5 = 2
            goto L_0x0117
        L_0x0102:
            java.lang.String r7 = "Time"
            boolean r5 = r5.equals(r7)
            if (r5 != 0) goto L_0x010b
            goto L_0x00f5
        L_0x010b:
            r5 = 1
            goto L_0x0117
        L_0x010d:
            java.lang.String r7 = "Number"
            boolean r5 = r5.equals(r7)
            if (r5 != 0) goto L_0x0116
            goto L_0x00f5
        L_0x0116:
            r5 = 0
        L_0x0117:
            switch(r5) {
                case 0: goto L_0x013c;
                case 1: goto L_0x013a;
                case 2: goto L_0x0131;
                default: goto L_0x011a;
            }
        L_0x011a:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = "Invalid template: "
            r13.append(r14)
            r13.append(r11)
            java.lang.String r11 = r13.toString()
            r12.<init>(r11)
            throw r12
        L_0x0131:
            r5 = 3
        L_0x0132:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
        L_0x0136:
            r13.add(r5)
            goto L_0x0141
        L_0x013a:
            r5 = 4
            goto L_0x0132
        L_0x013c:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r1)
            goto L_0x0136
        L_0x0141:
            int r5 = r13.size()
            int r5 = r5 - r2
            r14.set(r5, r8)
        L_0x0149:
            r12.add(r3)
            int r6 = r6 + r2
            r5 = r6
            goto L_0x000a
        L_0x0150:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.dash.manifest.UrlTemplate.c(java.lang.String, java.util.List, java.util.List, java.util.List):void");
    }

    public String a(String str, long j2, int i2, long j3) {
        String format;
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < this.f11229b.size(); i3++) {
            sb.append(this.f11228a.get(i3));
            if (this.f11229b.get(i3).intValue() == 1) {
                sb.append(str);
            } else {
                if (this.f11229b.get(i3).intValue() == 2) {
                    format = String.format(Locale.US, this.f11230c.get(i3), new Object[]{Long.valueOf(j2)});
                } else if (this.f11229b.get(i3).intValue() == 3) {
                    format = String.format(Locale.US, this.f11230c.get(i3), new Object[]{Integer.valueOf(i2)});
                } else if (this.f11229b.get(i3).intValue() == 4) {
                    format = String.format(Locale.US, this.f11230c.get(i3), new Object[]{Long.valueOf(j3)});
                }
                sb.append(format);
            }
        }
        sb.append(this.f11228a.get(this.f11229b.size()));
        return sb.toString();
    }
}
