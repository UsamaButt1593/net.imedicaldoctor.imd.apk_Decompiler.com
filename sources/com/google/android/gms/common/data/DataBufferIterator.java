package com.google.android.gms.common.data;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import java.util.NoSuchElementException;

@KeepForSdk
public class DataBufferIterator<T> implements Iterator<T> {
    protected int X = -1;
    @NonNull
    protected final DataBuffer<T> s;

    public DataBufferIterator(@NonNull DataBuffer<T> dataBuffer) {
        this.s = (DataBuffer) Preconditions.r(dataBuffer);
    }

    public final boolean hasNext() {
        return this.X < this.s.getCount() + -1;
    }

    @NonNull
    public T next() {
        if (hasNext()) {
            DataBuffer<T> dataBuffer = this.s;
            int i2 = this.X + 1;
            this.X = i2;
            return dataBuffer.get(i2);
        }
        int i3 = this.X;
        StringBuilder sb = new StringBuilder(46);
        sb.append("Cannot advance the iterator beyond ");
        sb.append(i3);
        throw new NoSuchElementException(sb.toString());
    }

    public final void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
