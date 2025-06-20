package com.google.android.gms.internal.common;

import java.util.List;
import javax.annotation.CheckForNull;

final class zzaf extends zzag {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzag zzc;

    zzaf(zzag zzag, int i2, int i3) {
        this.zzc = zzag;
        this.zza = i2;
        this.zzb = i3;
    }

    public final Object get(int i2) {
        zzs.zza(i2, this.zzb, "index");
        return this.zzc.get(i2 + this.zza);
    }

    public final int size() {
        return this.zzb;
    }

    public final /* bridge */ /* synthetic */ List subList(int i2, int i3) {
        return subList(i2, i3);
    }

    /* access modifiers changed from: package-private */
    public final int zzb() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzf() {
        return true;
    }

    /* access modifiers changed from: package-private */
    @CheckForNull
    public final Object[] zzg() {
        return this.zzc.zzg();
    }

    public final zzag zzh(int i2, int i3) {
        zzs.zzc(i2, i3, this.zzb);
        int i4 = this.zza;
        return this.zzc.subList(i2 + i4, i3 + i4);
    }
}
