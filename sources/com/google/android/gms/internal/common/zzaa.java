package com.google.android.gms.internal.common;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;

class zzaa extends zzab {
    Object[] zza = new Object[4];
    int zzb = 0;
    boolean zzc;

    zzaa(int i2) {
    }

    @CanIgnoreReturnValue
    public final zzaa zza(Object obj) {
        obj.getClass();
        int i2 = this.zzb;
        int i3 = i2 + 1;
        Object[] objArr = this.zza;
        int length = objArr.length;
        if (length < i3) {
            int i4 = length + (length >> 1) + 1;
            if (i4 < i3) {
                int highestOneBit = Integer.highestOneBit(i2);
                i4 = highestOneBit + highestOneBit;
            }
            if (i4 < 0) {
                i4 = Integer.MAX_VALUE;
            }
            this.zza = Arrays.copyOf(objArr, i4);
        } else {
            if (this.zzc) {
                this.zza = (Object[]) objArr.clone();
            }
            Object[] objArr2 = this.zza;
            int i5 = this.zzb;
            this.zzb = i5 + 1;
            objArr2[i5] = obj;
            return this;
        }
        this.zzc = false;
        Object[] objArr22 = this.zza;
        int i52 = this.zzb;
        this.zzb = i52 + 1;
        objArr22[i52] = obj;
        return this;
    }
}
