package androidx.media3.extractor.text.ssa;

final class SsaDialogueFormat {

    /* renamed from: a  reason: collision with root package name */
    public final int f13938a;

    /* renamed from: b  reason: collision with root package name */
    public final int f13939b;

    /* renamed from: c  reason: collision with root package name */
    public final int f13940c;

    /* renamed from: d  reason: collision with root package name */
    public final int f13941d;

    /* renamed from: e  reason: collision with root package name */
    public final int f13942e;

    private SsaDialogueFormat(int i2, int i3, int i4, int i5, int i6) {
        this.f13938a = i2;
        this.f13939b = i3;
        this.f13940c = i4;
        this.f13941d = i5;
        this.f13942e = i6;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.media3.extractor.text.ssa.SsaDialogueFormat a(java.lang.String r10) {
        /*
            r0 = 1
            java.lang.String r1 = "Format:"
            boolean r1 = r10.startsWith(r1)
            androidx.media3.common.util.Assertions.a(r1)
            r1 = 7
            java.lang.String r10 = r10.substring(r1)
            java.lang.String r1 = ","
            java.lang.String[] r10 = android.text.TextUtils.split(r10, r1)
            r1 = -1
            r2 = 0
            r3 = 0
            r5 = -1
            r6 = -1
            r7 = -1
            r8 = -1
        L_0x001c:
            int r4 = r10.length
            if (r3 >= r4) goto L_0x006d
            r4 = r10[r3]
            java.lang.String r4 = r4.trim()
            java.lang.String r4 = com.google.common.base.Ascii.g(r4)
            r4.hashCode()
            int r9 = r4.hashCode()
            switch(r9) {
                case 100571: goto L_0x0056;
                case 3556653: goto L_0x004b;
                case 109757538: goto L_0x0040;
                case 109780401: goto L_0x0035;
                default: goto L_0x0033;
            }
        L_0x0033:
            r4 = -1
            goto L_0x0060
        L_0x0035:
            java.lang.String r9 = "style"
            boolean r4 = r4.equals(r9)
            if (r4 != 0) goto L_0x003e
            goto L_0x0033
        L_0x003e:
            r4 = 3
            goto L_0x0060
        L_0x0040:
            java.lang.String r9 = "start"
            boolean r4 = r4.equals(r9)
            if (r4 != 0) goto L_0x0049
            goto L_0x0033
        L_0x0049:
            r4 = 2
            goto L_0x0060
        L_0x004b:
            java.lang.String r9 = "text"
            boolean r4 = r4.equals(r9)
            if (r4 != 0) goto L_0x0054
            goto L_0x0033
        L_0x0054:
            r4 = 1
            goto L_0x0060
        L_0x0056:
            java.lang.String r9 = "end"
            boolean r4 = r4.equals(r9)
            if (r4 != 0) goto L_0x005f
            goto L_0x0033
        L_0x005f:
            r4 = 0
        L_0x0060:
            switch(r4) {
                case 0: goto L_0x006a;
                case 1: goto L_0x0068;
                case 2: goto L_0x0066;
                case 3: goto L_0x0064;
                default: goto L_0x0063;
            }
        L_0x0063:
            goto L_0x006b
        L_0x0064:
            r7 = r3
            goto L_0x006b
        L_0x0066:
            r5 = r3
            goto L_0x006b
        L_0x0068:
            r8 = r3
            goto L_0x006b
        L_0x006a:
            r6 = r3
        L_0x006b:
            int r3 = r3 + r0
            goto L_0x001c
        L_0x006d:
            if (r5 == r1) goto L_0x007b
            if (r6 == r1) goto L_0x007b
            if (r8 == r1) goto L_0x007b
            androidx.media3.extractor.text.ssa.SsaDialogueFormat r0 = new androidx.media3.extractor.text.ssa.SsaDialogueFormat
            int r9 = r10.length
            r4 = r0
            r4.<init>(r5, r6, r7, r8, r9)
            goto L_0x007c
        L_0x007b:
            r0 = 0
        L_0x007c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.ssa.SsaDialogueFormat.a(java.lang.String):androidx.media3.extractor.text.ssa.SsaDialogueFormat");
    }
}
