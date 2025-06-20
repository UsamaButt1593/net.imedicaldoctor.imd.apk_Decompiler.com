package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.Enum;
import java.util.Collection;
import java.util.EnumSet;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true, serializable = true)
@ElementTypesAreNonnullByDefault
final class ImmutableEnumSet<E extends Enum<E>> extends ImmutableSet<E> {
    private final transient EnumSet<E> Y2;
    @LazyInit
    private transient int Z2;

    @J2ktIncompatible
    private static class EnumSerializedForm<E extends Enum<E>> implements Serializable {
        private static final long X = 0;
        final EnumSet<E> s;

        EnumSerializedForm(EnumSet<E> enumSet) {
            this.s = enumSet;
        }

        /* access modifiers changed from: package-private */
        public Object a() {
            return new ImmutableEnumSet(this.s.clone());
        }
    }

    private ImmutableEnumSet(EnumSet<E> enumSet) {
        this.Y2 = enumSet;
    }

    static <E extends Enum<E>> ImmutableSet<E> U(EnumSet<E> enumSet) {
        int size = enumSet.size();
        if (size != 0) {
            return size != 1 ? new ImmutableEnumSet(enumSet) : ImmutableSet.L((Enum) Iterables.z(enumSet));
        }
        return ImmutableSet.K();
    }

    @J2ktIncompatible
    private void m(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    /* access modifiers changed from: package-private */
    public boolean I() {
        return true;
    }

    public boolean contains(@CheckForNull Object obj) {
        return this.Y2.contains(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        if (collection instanceof ImmutableEnumSet) {
            collection = ((ImmutableEnumSet) collection).Y2;
        }
        return this.Y2.containsAll(collection);
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ImmutableEnumSet) {
            obj = ((ImmutableEnumSet) obj).Y2;
        }
        return this.Y2.equals(obj);
    }

    public int hashCode() {
        int i2 = this.Z2;
        if (i2 != 0) {
            return i2;
        }
        int hashCode = this.Y2.hashCode();
        this.Z2 = hashCode;
        return hashCode;
    }

    public boolean isEmpty() {
        return this.Y2.isEmpty();
    }

    /* access modifiers changed from: package-private */
    public boolean j() {
        return false;
    }

    /* renamed from: k */
    public UnmodifiableIterator<E> iterator() {
        return Iterators.f0(this.Y2.iterator());
    }

    /* access modifiers changed from: package-private */
    @J2ktIncompatible
    public Object n() {
        return new EnumSerializedForm(this.Y2);
    }

    public int size() {
        return this.Y2.size();
    }

    public String toString() {
        return this.Y2.toString();
    }
}
