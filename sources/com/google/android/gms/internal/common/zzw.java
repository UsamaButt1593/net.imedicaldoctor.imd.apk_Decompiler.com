package com.google.android.gms.internal.common;

abstract class zzw extends zzj {
    final CharSequence zzb;
    final zzo zzc;
    final boolean zzd;
    int zze = 0;
    int zzf;

    protected zzw(zzx zzx, CharSequence charSequence) {
        this.zzc = zzx.zza;
        this.zzd = zzx.zzb;
        this.zzf = Integer.MAX_VALUE;
        this.zzb = charSequence;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002e, code lost:
        if (r0 >= r1) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0030, code lost:
        r5.zzb.charAt(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0035, code lost:
        if (r0 >= r1) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0037, code lost:
        r5.zzb.charAt(r1 - 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0040, code lost:
        if (r5.zzd == false) goto L_0x0045;
     */
    @javax.annotation.CheckForNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ java.lang.Object zza() {
        /*
            r5 = this;
        L_0x0000:
            int r0 = r5.zze
        L_0x0002:
            int r1 = r5.zze
            r2 = -1
            if (r1 == r2) goto L_0x006a
            int r1 = r5.zzd(r1)
            if (r1 != r2) goto L_0x0017
            java.lang.CharSequence r1 = r5.zzb
            int r1 = r1.length()
            r5.zze = r2
            r3 = -1
            goto L_0x001d
        L_0x0017:
            int r3 = r5.zzc(r1)
            r5.zze = r3
        L_0x001d:
            if (r3 != r0) goto L_0x002e
            int r3 = r3 + 1
            r5.zze = r3
            java.lang.CharSequence r1 = r5.zzb
            int r1 = r1.length()
            if (r3 <= r1) goto L_0x0002
            r5.zze = r2
            goto L_0x0002
        L_0x002e:
            if (r0 >= r1) goto L_0x0035
            java.lang.CharSequence r3 = r5.zzb
            r3.charAt(r0)
        L_0x0035:
            if (r0 >= r1) goto L_0x003e
            java.lang.CharSequence r3 = r5.zzb
            int r4 = r1 + -1
            r3.charAt(r4)
        L_0x003e:
            boolean r3 = r5.zzd
            if (r3 == 0) goto L_0x0045
            if (r0 != r1) goto L_0x0045
            goto L_0x0000
        L_0x0045:
            int r3 = r5.zzf
            r4 = 1
            if (r3 != r4) goto L_0x005c
            java.lang.CharSequence r1 = r5.zzb
            int r1 = r1.length()
            r5.zze = r2
            if (r1 <= r0) goto L_0x005f
            java.lang.CharSequence r2 = r5.zzb
            int r3 = r1 + -1
            r2.charAt(r3)
            goto L_0x005f
        L_0x005c:
            int r3 = r3 + r2
            r5.zzf = r3
        L_0x005f:
            java.lang.CharSequence r2 = r5.zzb
            java.lang.CharSequence r0 = r2.subSequence(r0, r1)
            java.lang.String r0 = r0.toString()
            goto L_0x006e
        L_0x006a:
            r5.zzb()
            r0 = 0
        L_0x006e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.common.zzw.zza():java.lang.Object");
    }

    /* access modifiers changed from: package-private */
    public abstract int zzc(int i2);

    /* access modifiers changed from: package-private */
    public abstract int zzd(int i2);
}
