package com.google.android.material.carousel;

import androidx.annotation.NonNull;
import androidx.core.math.MathUtils;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.carousel.KeylineState;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class KeylineStateList {

    /* renamed from: h  reason: collision with root package name */
    private static final int f20971h = -1;

    /* renamed from: a  reason: collision with root package name */
    private final KeylineState f20972a;

    /* renamed from: b  reason: collision with root package name */
    private final List<KeylineState> f20973b;

    /* renamed from: c  reason: collision with root package name */
    private final List<KeylineState> f20974c;

    /* renamed from: d  reason: collision with root package name */
    private final float[] f20975d;

    /* renamed from: e  reason: collision with root package name */
    private final float[] f20976e;

    /* renamed from: f  reason: collision with root package name */
    private final float f20977f;

    /* renamed from: g  reason: collision with root package name */
    private final float f20978g;

    private KeylineStateList(@NonNull KeylineState keylineState, List<KeylineState> list, List<KeylineState> list2) {
        this.f20972a = keylineState;
        this.f20973b = Collections.unmodifiableList(list);
        this.f20974c = Collections.unmodifiableList(list2);
        float f2 = list.get(list.size() - 1).c().f20963a - keylineState.c().f20963a;
        this.f20977f = f2;
        float f3 = keylineState.j().f20963a - list2.get(list2.size() - 1).j().f20963a;
        this.f20978g = f3;
        this.f20975d = m(f2, list, true);
        this.f20976e = m(f3, list2, false);
    }

    private KeylineState a(List<KeylineState> list, float f2, float[] fArr) {
        float[] o = o(list, f2, fArr);
        return list.get((int) (o[0] >= 0.5f ? o[2] : o[1]));
    }

    private static int b(KeylineState keylineState, float f2) {
        for (int i2 = keylineState.i(); i2 < keylineState.g().size(); i2++) {
            if (f2 == keylineState.g().get(i2).f20965c) {
                return i2;
            }
        }
        return keylineState.g().size() - 1;
    }

    private static int c(KeylineState keylineState) {
        for (int i2 = 0; i2 < keylineState.g().size(); i2++) {
            if (!keylineState.g().get(i2).f20967e) {
                return i2;
            }
        }
        return -1;
    }

    private static int d(KeylineState keylineState, float f2) {
        for (int b2 = keylineState.b() - 1; b2 >= 0; b2--) {
            if (f2 == keylineState.g().get(b2).f20965c) {
                return b2;
            }
        }
        return 0;
    }

    private static int e(KeylineState keylineState) {
        for (int size = keylineState.g().size() - 1; size >= 0; size--) {
            if (!keylineState.g().get(size).f20967e) {
                return size;
            }
        }
        return -1;
    }

    static KeylineStateList f(Carousel carousel, KeylineState keylineState, float f2, float f3, float f4) {
        return new KeylineStateList(keylineState, p(carousel, keylineState, f2, f3), n(carousel, keylineState, f2, f4));
    }

    private static float[] m(float f2, List<KeylineState> list, boolean z) {
        int size = list.size();
        float[] fArr = new float[size];
        int i2 = 1;
        while (i2 < size) {
            int i3 = i2 - 1;
            KeylineState keylineState = list.get(i3);
            KeylineState keylineState2 = list.get(i2);
            fArr[i2] = i2 == size + -1 ? 1.0f : fArr[i3] + ((z ? keylineState2.c().f20963a - keylineState.c().f20963a : keylineState.j().f20963a - keylineState2.j().f20963a) / f2);
            i2++;
        }
        return fArr;
    }

    private static List<KeylineState> n(Carousel carousel, KeylineState keylineState, float f2, float f3) {
        KeylineState keylineState2 = keylineState;
        float f4 = f2;
        float f5 = f3;
        ArrayList arrayList = new ArrayList();
        arrayList.add(keylineState2);
        int e2 = e(keylineState);
        float c2 = (float) (carousel.g() ? carousel.c() : carousel.d());
        if (r(carousel, keylineState) || e2 == -1) {
            if (f5 > 0.0f) {
                arrayList.add(u(keylineState2, f5, c2, false, f4));
            }
            return arrayList;
        }
        int i2 = e2 - keylineState.i();
        float f6 = keylineState.c().f20964b - (keylineState.c().f20966d / 2.0f);
        if (i2 > 0 || keylineState.h().f20968f <= 0.0f) {
            float f7 = 0.0f;
            int i3 = 0;
            while (i3 < i2) {
                KeylineState keylineState3 = (KeylineState) arrayList.get(arrayList.size() - 1);
                int i4 = e2 - i3;
                float f8 = f7 + keylineState.g().get(i4).f20968f;
                int i5 = i4 + 1;
                int i6 = i3;
                KeylineState t = t(keylineState3, e2, i5 < keylineState.g().size() ? d(keylineState3, keylineState.g().get(i5).f20965c) + 1 : 0, f6 - f8, keylineState.b() + i3 + 1, keylineState.i() + i3 + 1, c2);
                if (i6 == i2 - 1 && f5 > 0.0f) {
                    t = u(t, f5, c2, false, f4);
                }
                arrayList.add(t);
                i3 = i6 + 1;
                f7 = f8;
            }
            return arrayList;
        }
        arrayList.add(v(keylineState2, f6 - keylineState.h().f20968f, c2));
        return arrayList;
    }

    private static float[] o(List<KeylineState> list, float f2, float[] fArr) {
        int size = list.size();
        float f3 = fArr[0];
        int i2 = 1;
        while (i2 < size) {
            float f4 = fArr[i2];
            if (f2 <= f4) {
                return new float[]{AnimationUtils.b(0.0f, 1.0f, f3, f4, f2), (float) (i2 - 1), (float) i2};
            }
            i2++;
            f3 = f4;
        }
        return new float[]{0.0f, 0.0f, 0.0f};
    }

    private static List<KeylineState> p(Carousel carousel, KeylineState keylineState, float f2, float f3) {
        KeylineState keylineState2 = keylineState;
        float f4 = f2;
        float f5 = f3;
        ArrayList arrayList = new ArrayList();
        arrayList.add(keylineState2);
        int c2 = c(keylineState);
        float c3 = (float) (carousel.g() ? carousel.c() : carousel.d());
        int i2 = 1;
        if (q(keylineState) || c2 == -1) {
            if (f5 > 0.0f) {
                arrayList.add(u(keylineState2, f5, c3, true, f4));
            }
            return arrayList;
        }
        int b2 = keylineState.b() - c2;
        float f6 = keylineState.c().f20964b - (keylineState.c().f20966d / 2.0f);
        if (b2 > 0 || keylineState.a().f20968f <= 0.0f) {
            float f7 = 0.0f;
            int i3 = 0;
            while (i3 < b2) {
                KeylineState keylineState3 = (KeylineState) arrayList.get(arrayList.size() - i2);
                int i4 = c2 + i3;
                int size = keylineState.g().size() - i2;
                float f8 = f7 + keylineState.g().get(i4).f20968f;
                int i5 = i4 - i2;
                int b3 = i5 >= 0 ? b(keylineState3, keylineState.g().get(i5).f20965c) - i2 : size;
                int i6 = i3;
                KeylineState t = t(keylineState3, c2, b3, f6 + f8, (keylineState.b() - i3) - 1, (keylineState.i() - i3) - 1, c3);
                if (i6 == b2 - 1 && f5 > 0.0f) {
                    t = u(t, f5, c3, true, f4);
                }
                arrayList.add(t);
                i3 = i6 + 1;
                f7 = f8;
                i2 = 1;
            }
            return arrayList;
        }
        arrayList.add(v(keylineState2, f6 + keylineState.a().f20968f, c3));
        return arrayList;
    }

    private static boolean q(KeylineState keylineState) {
        return keylineState.a().f20964b - (keylineState.a().f20966d / 2.0f) >= 0.0f && keylineState.a() == keylineState.d();
    }

    private static boolean r(Carousel carousel, KeylineState keylineState) {
        int d2 = carousel.d();
        if (carousel.g()) {
            d2 = carousel.c();
        }
        return keylineState.h().f20964b + (keylineState.h().f20966d / 2.0f) <= ((float) d2) && keylineState.h() == keylineState.k();
    }

    private static KeylineState s(List<KeylineState> list, float f2, float[] fArr) {
        float[] o = o(list, f2, fArr);
        return KeylineState.m(list.get((int) o[1]), list.get((int) o[2]), o[0]);
    }

    private static KeylineState t(KeylineState keylineState, int i2, int i3, float f2, int i4, int i5, float f3) {
        ArrayList arrayList = new ArrayList(keylineState.g());
        arrayList.add(i3, (KeylineState.Keyline) arrayList.remove(i2));
        KeylineState.Builder builder = new KeylineState.Builder(keylineState.f(), f3);
        int i6 = 0;
        while (i6 < arrayList.size()) {
            KeylineState.Keyline keyline = (KeylineState.Keyline) arrayList.get(i6);
            float f4 = keyline.f20966d;
            builder.e(f2 + (f4 / 2.0f), keyline.f20965c, f4, i6 >= i4 && i6 <= i5, keyline.f20967e, keyline.f20968f);
            f2 += keyline.f20966d;
            i6++;
        }
        return builder.i();
    }

    private static KeylineState u(KeylineState keylineState, float f2, float f3, boolean z, float f4) {
        ArrayList arrayList = new ArrayList(keylineState.g());
        KeylineState.Builder builder = new KeylineState.Builder(keylineState.f(), f3);
        float l2 = f2 / ((float) keylineState.l());
        float f5 = z ? f2 : 0.0f;
        int i2 = 0;
        while (i2 < arrayList.size()) {
            KeylineState.Keyline keyline = (KeylineState.Keyline) arrayList.get(i2);
            if (keyline.f20967e) {
                builder.e(keyline.f20964b, keyline.f20965c, keyline.f20966d, false, true, keyline.f20968f);
            } else {
                boolean z2 = i2 >= keylineState.b() && i2 <= keylineState.i();
                float f6 = keyline.f20966d - l2;
                float b2 = CarouselStrategy.b(f6, keylineState.f(), f4);
                float f7 = (f6 / 2.0f) + f5;
                float f8 = f7 - keyline.f20964b;
                builder.f(f7, b2, f6, z2, false, keyline.f20968f, z ? f8 : 0.0f, z ? 0.0f : f8);
                f5 += f6;
            }
            i2++;
        }
        return builder.i();
    }

    private static KeylineState v(KeylineState keylineState, float f2, float f3) {
        return t(keylineState, 0, 0, f2, keylineState.b(), keylineState.i(), f3);
    }

    /* access modifiers changed from: package-private */
    public KeylineState g() {
        return this.f20972a;
    }

    /* access modifiers changed from: package-private */
    public KeylineState h() {
        List<KeylineState> list = this.f20974c;
        return list.get(list.size() - 1);
    }

    /* access modifiers changed from: package-private */
    public Map<Integer, KeylineState> i(int i2, int i3, int i4, boolean z) {
        float f2 = this.f20972a.f();
        HashMap hashMap = new HashMap();
        int i5 = 0;
        int i6 = 0;
        while (true) {
            int i7 = -1;
            if (i5 >= i2) {
                break;
            }
            int i8 = z ? (i2 - i5) - 1 : i5;
            float f3 = ((float) i8) * f2;
            if (!z) {
                i7 = 1;
            }
            if (f3 * ((float) i7) > ((float) i4) - this.f20978g || i5 >= i2 - this.f20974c.size()) {
                Integer valueOf = Integer.valueOf(i8);
                List<KeylineState> list = this.f20974c;
                hashMap.put(valueOf, list.get(MathUtils.e(i6, 0, list.size() - 1)));
                i6++;
            }
            i5++;
        }
        int i9 = 0;
        for (int i10 = i2 - 1; i10 >= 0; i10--) {
            int i11 = z ? (i2 - i10) - 1 : i10;
            if (((float) i11) * f2 * ((float) (z ? -1 : 1)) < ((float) i3) + this.f20977f || i10 < this.f20973b.size()) {
                Integer valueOf2 = Integer.valueOf(i11);
                List<KeylineState> list2 = this.f20973b;
                hashMap.put(valueOf2, list2.get(MathUtils.e(i9, 0, list2.size() - 1)));
                i9++;
            }
        }
        return hashMap;
    }

    public KeylineState j(float f2, float f3, float f4) {
        return k(f2, f3, f4, false);
    }

    /* access modifiers changed from: package-private */
    public KeylineState k(float f2, float f3, float f4, boolean z) {
        float[] fArr;
        List<KeylineState> list;
        float f5;
        float f6 = this.f20977f + f3;
        float f7 = f4 - this.f20978g;
        float f8 = l().a().f20969g;
        float f9 = h().h().f20970h;
        if (this.f20977f == f8) {
            f6 += f8;
        }
        if (this.f20978g == f9) {
            f7 -= f9;
        }
        if (f2 < f6) {
            f5 = AnimationUtils.b(1.0f, 0.0f, f3, f6, f2);
            list = this.f20973b;
            fArr = this.f20975d;
        } else if (f2 <= f7) {
            return this.f20972a;
        } else {
            f5 = AnimationUtils.b(0.0f, 1.0f, f7, f4, f2);
            list = this.f20974c;
            fArr = this.f20976e;
        }
        return z ? a(list, f5, fArr) : s(list, f5, fArr);
    }

    /* access modifiers changed from: package-private */
    public KeylineState l() {
        List<KeylineState> list = this.f20973b;
        return list.get(list.size() - 1);
    }
}
