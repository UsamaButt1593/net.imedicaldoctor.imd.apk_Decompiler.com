package com.google.android.material.carousel;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.animation.AnimationUtils;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class KeylineState {

    /* renamed from: a  reason: collision with root package name */
    private final float f20948a;

    /* renamed from: b  reason: collision with root package name */
    private final List<Keyline> f20949b;

    /* renamed from: c  reason: collision with root package name */
    private final int f20950c;

    /* renamed from: d  reason: collision with root package name */
    private final int f20951d;

    static final class Builder {

        /* renamed from: j  reason: collision with root package name */
        private static final int f20952j = -1;

        /* renamed from: k  reason: collision with root package name */
        private static final float f20953k = Float.MIN_VALUE;

        /* renamed from: a  reason: collision with root package name */
        private final float f20954a;

        /* renamed from: b  reason: collision with root package name */
        private final float f20955b;

        /* renamed from: c  reason: collision with root package name */
        private final List<Keyline> f20956c = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        private Keyline f20957d;

        /* renamed from: e  reason: collision with root package name */
        private Keyline f20958e;

        /* renamed from: f  reason: collision with root package name */
        private int f20959f = -1;

        /* renamed from: g  reason: collision with root package name */
        private int f20960g = -1;

        /* renamed from: h  reason: collision with root package name */
        private float f20961h = 0.0f;

        /* renamed from: i  reason: collision with root package name */
        private int f20962i = -1;

        Builder(float f2, float f3) {
            this.f20954a = f2;
            this.f20955b = f3;
        }

        private static float j(float f2, float f3, int i2, int i3) {
            return (f2 - (((float) i2) * f3)) + (((float) i3) * f3);
        }

        /* access modifiers changed from: package-private */
        @NonNull
        @CanIgnoreReturnValue
        public Builder a(float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3, float f4) {
            return d(f2, f3, f4, false, true);
        }

        /* access modifiers changed from: package-private */
        @NonNull
        @CanIgnoreReturnValue
        public Builder b(float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3, float f4) {
            return c(f2, f3, f4, false);
        }

        /* access modifiers changed from: package-private */
        @NonNull
        @CanIgnoreReturnValue
        public Builder c(float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3, float f4, boolean z) {
            return d(f2, f3, f4, z, false);
        }

        /* access modifiers changed from: package-private */
        @NonNull
        @CanIgnoreReturnValue
        public Builder d(float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3, float f4, boolean z, boolean z2) {
            float f5;
            float abs;
            float f6 = f4 / 2.0f;
            float f7 = f2 - f6;
            float f8 = f6 + f2;
            float f9 = this.f20955b;
            if (f8 > f9) {
                abs = Math.abs(f8 - Math.max(f8 - f4, f9));
            } else if (f7 < 0.0f) {
                abs = Math.abs(f7 - Math.min(f7 + f4, 0.0f));
            } else {
                f5 = 0.0f;
                return e(f2, f3, f4, z, z2, f5);
            }
            f5 = abs;
            return e(f2, f3, f4, z, z2, f5);
        }

        /* access modifiers changed from: package-private */
        @NonNull
        @CanIgnoreReturnValue
        public Builder e(float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3, float f4, boolean z, boolean z2, float f5) {
            return f(f2, f3, f4, z, z2, f5, 0.0f, 0.0f);
        }

        /* access modifiers changed from: package-private */
        @NonNull
        @CanIgnoreReturnValue
        public Builder f(float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3, float f4, boolean z, boolean z2, float f5, float f6, float f7) {
            if (f4 <= 0.0f) {
                return this;
            }
            if (z2) {
                if (!z) {
                    int i2 = this.f20962i;
                    if (i2 == -1 || i2 == 0) {
                        this.f20962i = this.f20956c.size();
                    } else {
                        throw new IllegalArgumentException("Anchor keylines must be either the first or last keyline.");
                    }
                } else {
                    throw new IllegalArgumentException("Anchor keylines cannot be focal.");
                }
            }
            Keyline keyline = new Keyline(Float.MIN_VALUE, f2, f3, f4, z2, f5, f6, f7);
            Keyline keyline2 = this.f20957d;
            if (z) {
                if (keyline2 == null) {
                    this.f20957d = keyline;
                    this.f20959f = this.f20956c.size();
                }
                if (this.f20960g != -1 && this.f20956c.size() - this.f20960g > 1) {
                    throw new IllegalArgumentException("Keylines marked as focal must be placed next to each other. There cannot be non-focal keylines between focal keylines.");
                } else if (f4 == this.f20957d.f20966d) {
                    this.f20958e = keyline;
                    this.f20960g = this.f20956c.size();
                } else {
                    throw new IllegalArgumentException("Keylines that are marked as focal must all have the same masked item size.");
                }
            } else if (keyline2 == null && keyline.f20966d < this.f20961h) {
                throw new IllegalArgumentException("Keylines before the first focal keyline must be ordered by incrementing masked item size.");
            } else if (this.f20958e != null && keyline.f20966d > this.f20961h) {
                throw new IllegalArgumentException("Keylines after the last focal keyline must be ordered by decreasing masked item size.");
            }
            this.f20961h = keyline.f20966d;
            this.f20956c.add(keyline);
            return this;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        @CanIgnoreReturnValue
        public Builder g(float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3, float f4, int i2) {
            return h(f2, f3, f4, i2, false);
        }

        /* access modifiers changed from: package-private */
        @NonNull
        @CanIgnoreReturnValue
        public Builder h(float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3, float f4, int i2, boolean z) {
            if (i2 > 0 && f4 > 0.0f) {
                for (int i3 = 0; i3 < i2; i3++) {
                    c((((float) i3) * f4) + f2, f3, f4, z);
                }
            }
            return this;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public KeylineState i() {
            if (this.f20957d != null) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < this.f20956c.size(); i2++) {
                    Keyline keyline = this.f20956c.get(i2);
                    arrayList.add(new Keyline(j(this.f20957d.f20964b, this.f20954a, this.f20959f, i2), keyline.f20964b, keyline.f20965c, keyline.f20966d, keyline.f20967e, keyline.f20968f, keyline.f20969g, keyline.f20970h));
                }
                return new KeylineState(this.f20954a, arrayList, this.f20959f, this.f20960g);
            }
            throw new IllegalStateException("There must be a keyline marked as focal.");
        }
    }

    static final class Keyline {

        /* renamed from: a  reason: collision with root package name */
        final float f20963a;

        /* renamed from: b  reason: collision with root package name */
        final float f20964b;

        /* renamed from: c  reason: collision with root package name */
        final float f20965c;

        /* renamed from: d  reason: collision with root package name */
        final float f20966d;

        /* renamed from: e  reason: collision with root package name */
        final boolean f20967e;

        /* renamed from: f  reason: collision with root package name */
        final float f20968f;

        /* renamed from: g  reason: collision with root package name */
        final float f20969g;

        /* renamed from: h  reason: collision with root package name */
        final float f20970h;

        Keyline(float f2, float f3, float f4, float f5) {
            this(f2, f3, f4, f5, false, 0.0f, 0.0f, 0.0f);
        }

        static Keyline a(Keyline keyline, Keyline keyline2, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
            return new Keyline(AnimationUtils.a(keyline.f20963a, keyline2.f20963a, f2), AnimationUtils.a(keyline.f20964b, keyline2.f20964b, f2), AnimationUtils.a(keyline.f20965c, keyline2.f20965c, f2), AnimationUtils.a(keyline.f20966d, keyline2.f20966d, f2));
        }

        Keyline(float f2, float f3, float f4, float f5, boolean z, float f6, float f7, float f8) {
            this.f20963a = f2;
            this.f20964b = f3;
            this.f20965c = f4;
            this.f20966d = f5;
            this.f20967e = z;
            this.f20968f = f6;
            this.f20969g = f7;
            this.f20970h = f8;
        }
    }

    private KeylineState(float f2, List<Keyline> list, int i2, int i3) {
        this.f20948a = f2;
        this.f20949b = Collections.unmodifiableList(list);
        this.f20950c = i2;
        this.f20951d = i3;
    }

    static KeylineState m(KeylineState keylineState, KeylineState keylineState2, float f2) {
        if (keylineState.f() == keylineState2.f()) {
            List<Keyline> g2 = keylineState.g();
            List<Keyline> g3 = keylineState2.g();
            if (g2.size() == g3.size()) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < keylineState.g().size(); i2++) {
                    arrayList.add(Keyline.a(g2.get(i2), g3.get(i2), f2));
                }
                return new KeylineState(keylineState.f(), arrayList, AnimationUtils.c(keylineState.b(), keylineState2.b(), f2), AnimationUtils.c(keylineState.i(), keylineState2.i(), f2));
            }
            throw new IllegalArgumentException("Keylines being linearly interpolated must have the same number of keylines.");
        }
        throw new IllegalArgumentException("Keylines being linearly interpolated must have the same item size.");
    }

    static KeylineState n(KeylineState keylineState, float f2) {
        Builder builder = new Builder(keylineState.f(), f2);
        float f3 = (f2 - keylineState.j().f20964b) - (keylineState.j().f20966d / 2.0f);
        int size = keylineState.g().size() - 1;
        while (size >= 0) {
            Keyline keyline = keylineState.g().get(size);
            builder.d(f3 + (keyline.f20966d / 2.0f), keyline.f20965c, keyline.f20966d, size >= keylineState.b() && size <= keylineState.i(), keyline.f20967e);
            f3 += keyline.f20966d;
            size--;
        }
        return builder.i();
    }

    /* access modifiers changed from: package-private */
    public Keyline a() {
        return this.f20949b.get(this.f20950c);
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.f20950c;
    }

    /* access modifiers changed from: package-private */
    public Keyline c() {
        return this.f20949b.get(0);
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Keyline d() {
        for (int i2 = 0; i2 < this.f20949b.size(); i2++) {
            Keyline keyline = this.f20949b.get(i2);
            if (!keyline.f20967e) {
                return keyline;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public List<Keyline> e() {
        return this.f20949b.subList(this.f20950c, this.f20951d + 1);
    }

    /* access modifiers changed from: package-private */
    public float f() {
        return this.f20948a;
    }

    /* access modifiers changed from: package-private */
    public List<Keyline> g() {
        return this.f20949b;
    }

    /* access modifiers changed from: package-private */
    public Keyline h() {
        return this.f20949b.get(this.f20951d);
    }

    /* access modifiers changed from: package-private */
    public int i() {
        return this.f20951d;
    }

    /* access modifiers changed from: package-private */
    public Keyline j() {
        List<Keyline> list = this.f20949b;
        return list.get(list.size() - 1);
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Keyline k() {
        for (int size = this.f20949b.size() - 1; size >= 0; size--) {
            Keyline keyline = this.f20949b.get(size);
            if (!keyline.f20967e) {
                return keyline;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public int l() {
        int i2 = 0;
        for (Keyline keyline : this.f20949b) {
            if (keyline.f20967e) {
                i2++;
            }
        }
        return this.f20949b.size() - i2;
    }
}
