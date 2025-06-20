package com.google.android.gms.common.data;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.NoSuchElementException;

@KeepForSdk
public class SingleRefDataBufferIterator<T> extends DataBufferIterator<T> {
    private T Y;

    public SingleRefDataBufferIterator(@NonNull DataBuffer<T> dataBuffer) {
        super(dataBuffer);
    }

    @NonNull
    public final T next() {
        if (hasNext()) {
            int i2 = this.X + 1;
            this.X = i2;
            if (i2 == 0) {
                T r = Preconditions.r(this.s.get(0));
                this.Y = r;
                if (!(r instanceof DataBufferRef)) {
                    String valueOf = String.valueOf(r.getClass());
                    StringBuilder sb = new StringBuilder(valueOf.length() + 44);
                    sb.append("DataBuffer reference of type ");
                    sb.append(valueOf);
                    sb.append(" is not movable");
                    throw new IllegalStateException(sb.toString());
                }
            } else {
                ((DataBufferRef) Preconditions.r(this.Y)).n(this.X);
            }
            return this.Y;
        }
        int i3 = this.X;
        StringBuilder sb2 = new StringBuilder(46);
        sb2.append("Cannot advance the iterator beyond ");
        sb2.append(i3);
        throw new NoSuchElementException(sb2.toString());
    }
}
