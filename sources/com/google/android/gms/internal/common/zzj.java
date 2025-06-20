package com.google.android.gms.internal.common;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;
import org.jspecify.nullness.NullMarked;

@NullMarked
abstract class zzj implements Iterator {
    @CheckForNull
    private Object zza;
    private int zzb = 2;

    protected zzj() {
    }

    public final boolean hasNext() {
        int i2 = this.zzb;
        if (i2 != 4) {
            int i3 = i2 - 1;
            if (i2 == 0) {
                throw null;
            } else if (i3 == 0) {
                return true;
            } else {
                if (i3 != 2) {
                    this.zzb = 4;
                    this.zza = zza();
                    if (this.zzb != 3) {
                        this.zzb = 1;
                        return true;
                    }
                }
                return false;
            }
        } else {
            throw new IllegalStateException();
        }
    }

    public final Object next() {
        if (hasNext()) {
            this.zzb = 2;
            Object obj = this.zza;
            this.zza = null;
            return obj;
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public abstract Object zza();

    /* access modifiers changed from: protected */
    @CheckForNull
    @CanIgnoreReturnValue
    public final Object zzb() {
        this.zzb = 3;
        return null;
    }
}
