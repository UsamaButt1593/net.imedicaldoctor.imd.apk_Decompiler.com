package com.nineoldandroids.animation;

import android.view.View;
import androidx.constraintlayout.motion.widget.Key;
import com.nineoldandroids.util.Property;
import com.nineoldandroids.view.animation.AnimatorProxy;
import java.util.HashMap;
import java.util.Map;

public final class ObjectAnimator extends ValueAnimator {
    private static final boolean J3 = false;
    private static final Map<String, Property> K3;
    private Object G3;
    private String H3;
    private Property I3;

    static {
        HashMap hashMap = new HashMap();
        K3 = hashMap;
        hashMap.put("alpha", PreHoneycombCompat.f27887a);
        hashMap.put("pivotX", PreHoneycombCompat.f27888b);
        hashMap.put("pivotY", PreHoneycombCompat.f27889c);
        hashMap.put("translationX", PreHoneycombCompat.f27890d);
        hashMap.put("translationY", PreHoneycombCompat.f27891e);
        hashMap.put(Key.f4369i, PreHoneycombCompat.f27892f);
        hashMap.put("rotationX", PreHoneycombCompat.f27893g);
        hashMap.put("rotationY", PreHoneycombCompat.f27894h);
        hashMap.put("scaleX", PreHoneycombCompat.f27895i);
        hashMap.put("scaleY", PreHoneycombCompat.f27896j);
        hashMap.put("scrollX", PreHoneycombCompat.f27897k);
        hashMap.put("scrollY", PreHoneycombCompat.f27898l);
        hashMap.put("x", PreHoneycombCompat.f27899m);
        hashMap.put("y", PreHoneycombCompat.f27900n);
    }

    public ObjectAnimator() {
    }

    public static <T> ObjectAnimator R0(T t, Property<T, Float> property, float... fArr) {
        ObjectAnimator objectAnimator = new ObjectAnimator(t, property);
        objectAnimator.y0(fArr);
        return objectAnimator;
    }

    public static ObjectAnimator S0(Object obj, String str, float... fArr) {
        ObjectAnimator objectAnimator = new ObjectAnimator(obj, str);
        objectAnimator.y0(fArr);
        return objectAnimator;
    }

    public static <T> ObjectAnimator W0(T t, Property<T, Integer> property, int... iArr) {
        ObjectAnimator objectAnimator = new ObjectAnimator(t, property);
        objectAnimator.C0(iArr);
        return objectAnimator;
    }

    public static ObjectAnimator Y0(Object obj, String str, int... iArr) {
        ObjectAnimator objectAnimator = new ObjectAnimator(obj, str);
        objectAnimator.C0(iArr);
        return objectAnimator;
    }

    public static <T, V> ObjectAnimator b1(T t, Property<T, V> property, TypeEvaluator<V> typeEvaluator, V... vArr) {
        ObjectAnimator objectAnimator = new ObjectAnimator(t, property);
        objectAnimator.D0(vArr);
        objectAnimator.w0(typeEvaluator);
        return objectAnimator;
    }

    public static ObjectAnimator c1(Object obj, String str, TypeEvaluator typeEvaluator, Object... objArr) {
        ObjectAnimator objectAnimator = new ObjectAnimator(obj, str);
        objectAnimator.D0(objArr);
        objectAnimator.w0(typeEvaluator);
        return objectAnimator;
    }

    public static ObjectAnimator d1(Object obj, PropertyValuesHolder... propertyValuesHolderArr) {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        objectAnimator.G3 = obj;
        objectAnimator.G0(propertyValuesHolderArr);
        return objectAnimator;
    }

    public void C0(int... iArr) {
        PropertyValuesHolder[] propertyValuesHolderArr = this.l3;
        if (propertyValuesHolderArr == null || propertyValuesHolderArr.length == 0) {
            Property property = this.I3;
            if (property != null) {
                G0(PropertyValuesHolder.l(property, iArr));
                return;
            }
            G0(PropertyValuesHolder.m(this.H3, iArr));
            return;
        }
        super.C0(iArr);
    }

    public void D0(Object... objArr) {
        PropertyValuesHolder[] propertyValuesHolderArr = this.l3;
        if (propertyValuesHolderArr == null || propertyValuesHolderArr.length == 0) {
            Property property = this.I3;
            if (property != null) {
                G0(PropertyValuesHolder.p(property, (TypeEvaluator) null, objArr));
                return;
            }
            G0(PropertyValuesHolder.q(this.H3, (TypeEvaluator) null, objArr));
            return;
        }
        super.D0(objArr);
    }

    /* access modifiers changed from: package-private */
    public void G(float f2) {
        super.G(f2);
        for (PropertyValuesHolder r : this.l3) {
            r.r(this.G3);
        }
    }

    /* renamed from: L0 */
    public ObjectAnimator clone() {
        return (ObjectAnimator) super.clone();
    }

    public String M0() {
        return this.H3;
    }

    public Object O0() {
        return this.G3;
    }

    /* renamed from: e1 */
    public ObjectAnimator v0(long j2) {
        super.m(j2);
        return this;
    }

    public void g1(Property property) {
        PropertyValuesHolder[] propertyValuesHolderArr = this.l3;
        if (propertyValuesHolderArr != null) {
            PropertyValuesHolder propertyValuesHolder = propertyValuesHolderArr[0];
            String f2 = propertyValuesHolder.f();
            propertyValuesHolder.x(property);
            this.m3.remove(f2);
            this.m3.put(this.H3, propertyValuesHolder);
        }
        if (this.I3 != null) {
            this.H3 = property.b();
        }
        this.I3 = property;
        this.e3 = false;
    }

    public void h1(String str) {
        PropertyValuesHolder[] propertyValuesHolderArr = this.l3;
        if (propertyValuesHolderArr != null) {
            PropertyValuesHolder propertyValuesHolder = propertyValuesHolderArr[0];
            String f2 = propertyValuesHolder.f();
            propertyValuesHolder.y(str);
            this.m3.remove(f2);
            this.m3.put(str, propertyValuesHolder);
        }
        this.H3 = str;
        this.e3 = false;
    }

    /* access modifiers changed from: package-private */
    public void k0() {
        if (!this.e3) {
            if (this.I3 == null && AnimatorProxy.j3 && (this.G3 instanceof View)) {
                Map<String, Property> map = K3;
                if (map.containsKey(this.H3)) {
                    g1(map.get(this.H3));
                }
            }
            for (PropertyValuesHolder D : this.l3) {
                D.D(this.G3);
            }
            super.k0();
        }
    }

    public void p(Object obj) {
        Object obj2 = this.G3;
        if (obj2 != obj) {
            this.G3 = obj;
            if (obj2 == null || obj == null || obj2.getClass() != obj.getClass()) {
                this.e3 = false;
            }
        }
    }

    public void q() {
        k0();
        for (PropertyValuesHolder z : this.l3) {
            z.z(this.G3);
        }
    }

    public void r() {
        k0();
        for (PropertyValuesHolder F : this.l3) {
            F.F(this.G3);
        }
    }

    public void s() {
        super.s();
    }

    public String toString() {
        String str = "ObjectAnimator@" + Integer.toHexString(hashCode()) + ", target " + this.G3;
        if (this.l3 != null) {
            for (int i2 = 0; i2 < this.l3.length; i2++) {
                str = str + "\n    " + this.l3[i2].toString();
            }
        }
        return str;
    }

    public void y0(float... fArr) {
        PropertyValuesHolder[] propertyValuesHolderArr = this.l3;
        if (propertyValuesHolderArr == null || propertyValuesHolderArr.length == 0) {
            Property property = this.I3;
            if (property != null) {
                G0(PropertyValuesHolder.h(property, fArr));
                return;
            }
            G0(PropertyValuesHolder.i(this.H3, fArr));
            return;
        }
        super.y0(fArr);
    }

    private <T> ObjectAnimator(T t, Property<T, ?> property) {
        this.G3 = t;
        g1(property);
    }

    private ObjectAnimator(Object obj, String str) {
        this.G3 = obj;
        h1(str);
    }
}
