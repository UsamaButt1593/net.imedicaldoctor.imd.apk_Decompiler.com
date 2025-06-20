package com.google.android.gms.internal.common;

import org.jspecify.nullness.NullMarked;

@NullMarked
final class zzai extends zzag {
    static final zzag zza = new zzai(new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    zzai(Object[] objArr, int i2) {
        this.zzb = objArr;
        this.zzc = i2;
    }

    public final Object get(int i2) {
        zzs.zza(i2, this.zzc, "index");
        Object obj = this.zzb[i2];
        obj.getClass();
        return obj;
    }

    public final int size() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i2) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzc);
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final int zzb() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final int zzc() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzf() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zzg() {
        return this.zzb;
    }
}
