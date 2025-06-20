package com.google.android.gms.internal.common;

final class zzt extends zzw {
    final /* synthetic */ zzu zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzt(zzu zzu, zzx zzx, CharSequence charSequence) {
        super(zzx, charSequence);
        this.zza = zzu;
    }

    /* access modifiers changed from: package-private */
    public final int zzc(int i2) {
        return i2 + 1;
    }

    /* access modifiers changed from: package-private */
    public final int zzd(int i2) {
        CharSequence charSequence = this.zzb;
        int length = charSequence.length();
        zzs.zzb(i2, length, "index");
        while (i2 < length) {
            zzu zzu = this.zza;
            if (zzu.zza.zza(charSequence.charAt(i2))) {
                return i2;
            }
            i2++;
        }
        return -1;
    }
}
