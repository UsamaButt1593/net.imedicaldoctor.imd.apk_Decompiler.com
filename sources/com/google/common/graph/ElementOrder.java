package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.errorprone.annotations.Immutable;
import java.util.Comparator;
import java.util.Map;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@Immutable
@Beta
public final class ElementOrder<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Type f22598a;
    @CheckForNull

    /* renamed from: b  reason: collision with root package name */
    private final Comparator<T> f22599b;

    /* renamed from: com.google.common.graph.ElementOrder$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f22600a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.google.common.graph.ElementOrder$Type[] r0 = com.google.common.graph.ElementOrder.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f22600a = r0
                com.google.common.graph.ElementOrder$Type r1 = com.google.common.graph.ElementOrder.Type.UNORDERED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f22600a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.common.graph.ElementOrder$Type r1 = com.google.common.graph.ElementOrder.Type.INSERTION     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f22600a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.common.graph.ElementOrder$Type r1 = com.google.common.graph.ElementOrder.Type.STABLE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f22600a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.common.graph.ElementOrder$Type r1 = com.google.common.graph.ElementOrder.Type.SORTED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.graph.ElementOrder.AnonymousClass1.<clinit>():void");
        }
    }

    public enum Type {
        UNORDERED,
        STABLE,
        INSERTION,
        SORTED
    }

    private ElementOrder(Type type, @CheckForNull Comparator<T> comparator) {
        this.f22598a = (Type) Preconditions.E(type);
        this.f22599b = comparator;
        Preconditions.g0((type == Type.SORTED) == (comparator != null));
    }

    public static <S> ElementOrder<S> d() {
        return new ElementOrder<>(Type.INSERTION, (Comparator) null);
    }

    public static <S extends Comparable<? super S>> ElementOrder<S> e() {
        return new ElementOrder<>(Type.SORTED, Ordering.z());
    }

    public static <S> ElementOrder<S> f(Comparator<S> comparator) {
        return new ElementOrder<>(Type.SORTED, (Comparator) Preconditions.E(comparator));
    }

    public static <S> ElementOrder<S> g() {
        return new ElementOrder<>(Type.STABLE, (Comparator) null);
    }

    public static <S> ElementOrder<S> i() {
        return new ElementOrder<>(Type.UNORDERED, (Comparator) null);
    }

    /* access modifiers changed from: package-private */
    public <T1 extends T> ElementOrder<T1> a() {
        return this;
    }

    public Comparator<T> b() {
        Comparator<T> comparator = this.f22599b;
        if (comparator != null) {
            return comparator;
        }
        throw new UnsupportedOperationException("This ordering does not define a comparator.");
    }

    /* access modifiers changed from: package-private */
    public <K extends T, V> Map<K, V> c(int i2) {
        int i3 = AnonymousClass1.f22600a[this.f22598a.ordinal()];
        if (i3 == 1) {
            return Maps.a0(i2);
        }
        if (i3 == 2 || i3 == 3) {
            return Maps.e0(i2);
        }
        if (i3 == 4) {
            return Maps.g0(b());
        }
        throw new AssertionError();
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ElementOrder)) {
            return false;
        }
        ElementOrder elementOrder = (ElementOrder) obj;
        return this.f22598a == elementOrder.f22598a && Objects.a(this.f22599b, elementOrder.f22599b);
    }

    public Type h() {
        return this.f22598a;
    }

    public int hashCode() {
        return Objects.b(this.f22598a, this.f22599b);
    }

    public String toString() {
        MoreObjects.ToStringHelper f2 = MoreObjects.c(this).f("type", this.f22598a);
        Comparator<T> comparator = this.f22599b;
        if (comparator != null) {
            f2.f("comparator", comparator);
        }
        return f2.toString();
    }
}
