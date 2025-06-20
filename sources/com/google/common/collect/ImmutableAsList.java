package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true, serializable = true)
@ElementTypesAreNonnullByDefault
abstract class ImmutableAsList<E> extends ImmutableList<E> {

    @GwtIncompatible
    @J2ktIncompatible
    static class SerializedForm implements Serializable {
        private static final long X = 0;
        final ImmutableCollection<?> s;

        SerializedForm(ImmutableCollection<?> immutableCollection) {
            this.s = immutableCollection;
        }

        /* access modifiers changed from: package-private */
        public Object a() {
            return this.s.b();
        }
    }

    ImmutableAsList() {
    }

    @GwtIncompatible
    @J2ktIncompatible
    private void m(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public boolean contains(@CheckForNull Object obj) {
        return e0().contains(obj);
    }

    /* access modifiers changed from: package-private */
    public abstract ImmutableCollection<E> e0();

    public boolean isEmpty() {
        return e0().isEmpty();
    }

    /* access modifiers changed from: package-private */
    public boolean j() {
        return e0().j();
    }

    /* access modifiers changed from: package-private */
    @GwtIncompatible
    @J2ktIncompatible
    public Object n() {
        return new SerializedForm(e0());
    }

    public int size() {
        return e0().size();
    }
}
