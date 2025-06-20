package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Equivalence;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.MapMakerInternalMap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
public final class MapMaker {

    /* renamed from: g  reason: collision with root package name */
    private static final int f22430g = 16;

    /* renamed from: h  reason: collision with root package name */
    private static final int f22431h = 4;

    /* renamed from: i  reason: collision with root package name */
    static final int f22432i = -1;

    /* renamed from: a  reason: collision with root package name */
    boolean f22433a;

    /* renamed from: b  reason: collision with root package name */
    int f22434b = -1;

    /* renamed from: c  reason: collision with root package name */
    int f22435c = -1;
    @CheckForNull

    /* renamed from: d  reason: collision with root package name */
    MapMakerInternalMap.Strength f22436d;
    @CheckForNull

    /* renamed from: e  reason: collision with root package name */
    MapMakerInternalMap.Strength f22437e;
    @CheckForNull

    /* renamed from: f  reason: collision with root package name */
    Equivalence<Object> f22438f;

    enum Dummy {
        VALUE
    }

    @CanIgnoreReturnValue
    public MapMaker a(int i2) {
        int i3 = this.f22435c;
        boolean z = false;
        Preconditions.n0(i3 == -1, "concurrency level was already set to %s", i3);
        if (i2 > 0) {
            z = true;
        }
        Preconditions.d(z);
        this.f22435c = i2;
        return this;
    }

    /* access modifiers changed from: package-private */
    public int b() {
        int i2 = this.f22435c;
        if (i2 == -1) {
            return 4;
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    public int c() {
        int i2 = this.f22434b;
        if (i2 == -1) {
            return 16;
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    public Equivalence<Object> d() {
        return (Equivalence) MoreObjects.a(this.f22438f, e().b());
    }

    /* access modifiers changed from: package-private */
    public MapMakerInternalMap.Strength e() {
        return (MapMakerInternalMap.Strength) MoreObjects.a(this.f22436d, MapMakerInternalMap.Strength.STRONG);
    }

    /* access modifiers changed from: package-private */
    public MapMakerInternalMap.Strength f() {
        return (MapMakerInternalMap.Strength) MoreObjects.a(this.f22437e, MapMakerInternalMap.Strength.STRONG);
    }

    @CanIgnoreReturnValue
    public MapMaker g(int i2) {
        int i3 = this.f22434b;
        boolean z = false;
        Preconditions.n0(i3 == -1, "initial capacity was already set to %s", i3);
        if (i2 >= 0) {
            z = true;
        }
        Preconditions.d(z);
        this.f22434b = i2;
        return this;
    }

    /* access modifiers changed from: package-private */
    @GwtIncompatible
    @CanIgnoreReturnValue
    public MapMaker h(Equivalence<Object> equivalence) {
        Equivalence<Object> equivalence2 = this.f22438f;
        Preconditions.x0(equivalence2 == null, "key equivalence was already set to %s", equivalence2);
        this.f22438f = (Equivalence) Preconditions.E(equivalence);
        this.f22433a = true;
        return this;
    }

    public <K, V> ConcurrentMap<K, V> i() {
        return !this.f22433a ? new ConcurrentHashMap(c(), 0.75f, b()) : MapMakerInternalMap.c(this);
    }

    /* access modifiers changed from: package-private */
    public MapMaker j(MapMakerInternalMap.Strength strength) {
        MapMakerInternalMap.Strength strength2 = this.f22436d;
        Preconditions.x0(strength2 == null, "Key strength was already set to %s", strength2);
        this.f22436d = (MapMakerInternalMap.Strength) Preconditions.E(strength);
        if (strength != MapMakerInternalMap.Strength.STRONG) {
            this.f22433a = true;
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public MapMaker k(MapMakerInternalMap.Strength strength) {
        MapMakerInternalMap.Strength strength2 = this.f22437e;
        Preconditions.x0(strength2 == null, "Value strength was already set to %s", strength2);
        this.f22437e = (MapMakerInternalMap.Strength) Preconditions.E(strength);
        if (strength != MapMakerInternalMap.Strength.STRONG) {
            this.f22433a = true;
        }
        return this;
    }

    @GwtIncompatible
    @CanIgnoreReturnValue
    public MapMaker l() {
        return j(MapMakerInternalMap.Strength.WEAK);
    }

    @GwtIncompatible
    @CanIgnoreReturnValue
    public MapMaker m() {
        return k(MapMakerInternalMap.Strength.WEAK);
    }

    public String toString() {
        MoreObjects.ToStringHelper c2 = MoreObjects.c(this);
        int i2 = this.f22434b;
        if (i2 != -1) {
            c2.d("initialCapacity", i2);
        }
        int i3 = this.f22435c;
        if (i3 != -1) {
            c2.d("concurrencyLevel", i3);
        }
        MapMakerInternalMap.Strength strength = this.f22436d;
        if (strength != null) {
            c2.f("keyStrength", Ascii.g(strength.toString()));
        }
        MapMakerInternalMap.Strength strength2 = this.f22437e;
        if (strength2 != null) {
            c2.f("valueStrength", Ascii.g(strength2.toString()));
        }
        if (this.f22438f != null) {
            c2.s("keyEquivalence");
        }
        return c2.toString();
    }
}
