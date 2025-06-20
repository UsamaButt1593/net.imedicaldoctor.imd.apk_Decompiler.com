package com.google.android.gms.internal.common;

import java.io.IOException;
import java.util.Iterator;

final class zzv implements Iterable {
    final /* synthetic */ CharSequence zza;
    final /* synthetic */ zzx zzb;

    zzv(zzx zzx, CharSequence charSequence) {
        this.zzb = zzx;
        this.zza = charSequence;
    }

    public final Iterator iterator() {
        return this.zzb.zzh(this.zza);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        Iterator it2 = iterator();
        try {
            if (it2.hasNext()) {
                CharSequence zza2 = zzq.zza(it2.next(), ", ");
                while (true) {
                    sb.append(zza2);
                    if (!it2.hasNext()) {
                        break;
                    }
                    sb.append(", ");
                    zza2 = zzq.zza(it2.next(), ", ");
                }
            }
            sb.append(']');
            return sb.toString();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }
}
