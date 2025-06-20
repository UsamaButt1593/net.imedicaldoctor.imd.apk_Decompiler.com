package com.google.android.material.animation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.Property;
import androidx.annotation.AnimatorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleableRes;
import androidx.collection.SimpleArrayMap;
import com.dd.plist.ASCIIPropertyListParser;
import java.util.ArrayList;
import java.util.List;

public class MotionSpec {

    /* renamed from: c  reason: collision with root package name */
    private static final String f20779c = "MotionSpec";

    /* renamed from: a  reason: collision with root package name */
    private final SimpleArrayMap<String, MotionTiming> f20780a = new SimpleArrayMap<>();

    /* renamed from: b  reason: collision with root package name */
    private final SimpleArrayMap<String, PropertyValuesHolder[]> f20781b = new SimpleArrayMap<>();

    private static void a(@NonNull MotionSpec motionSpec, Animator animator) {
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            motionSpec.l(objectAnimator.getPropertyName(), objectAnimator.getValues());
            motionSpec.m(objectAnimator.getPropertyName(), MotionTiming.b(objectAnimator));
            return;
        }
        throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + animator);
    }

    @NonNull
    private PropertyValuesHolder[] b(@NonNull PropertyValuesHolder[] propertyValuesHolderArr) {
        PropertyValuesHolder[] propertyValuesHolderArr2 = new PropertyValuesHolder[propertyValuesHolderArr.length];
        for (int i2 = 0; i2 < propertyValuesHolderArr.length; i2++) {
            propertyValuesHolderArr2[i2] = propertyValuesHolderArr[i2].clone();
        }
        return propertyValuesHolderArr2;
    }

    @Nullable
    public static MotionSpec c(@NonNull Context context, @NonNull TypedArray typedArray, @StyleableRes int i2) {
        int resourceId;
        if (!typedArray.hasValue(i2) || (resourceId = typedArray.getResourceId(i2, 0)) == 0) {
            return null;
        }
        return d(context, resourceId);
    }

    @Nullable
    public static MotionSpec d(@NonNull Context context, @AnimatorRes int i2) {
        try {
            Animator loadAnimator = AnimatorInflater.loadAnimator(context, i2);
            if (loadAnimator instanceof AnimatorSet) {
                return e(((AnimatorSet) loadAnimator).getChildAnimations());
            }
            if (loadAnimator == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(loadAnimator);
            return e(arrayList);
        } catch (Exception e2) {
            Log.w(f20779c, "Can't load animation resource ID #0x" + Integer.toHexString(i2), e2);
            return null;
        }
    }

    @NonNull
    private static MotionSpec e(@NonNull List<Animator> list) {
        MotionSpec motionSpec = new MotionSpec();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            a(motionSpec, list.get(i2));
        }
        return motionSpec;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MotionSpec)) {
            return false;
        }
        return this.f20780a.equals(((MotionSpec) obj).f20780a);
    }

    @NonNull
    public <T> ObjectAnimator f(@NonNull String str, @NonNull T t, @NonNull Property<T, ?> property) {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(t, g(str));
        ofPropertyValuesHolder.setProperty(property);
        h(str).a(ofPropertyValuesHolder);
        return ofPropertyValuesHolder;
    }

    @NonNull
    public PropertyValuesHolder[] g(String str) {
        if (j(str)) {
            return b(this.f20781b.get(str));
        }
        throw new IllegalArgumentException();
    }

    public MotionTiming h(String str) {
        if (k(str)) {
            return this.f20780a.get(str);
        }
        throw new IllegalArgumentException();
    }

    public int hashCode() {
        return this.f20780a.hashCode();
    }

    public long i() {
        int size = this.f20780a.size();
        long j2 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            MotionTiming m2 = this.f20780a.m(i2);
            j2 = Math.max(j2, m2.c() + m2.d());
        }
        return j2;
    }

    public boolean j(String str) {
        return this.f20781b.get(str) != null;
    }

    public boolean k(String str) {
        return this.f20780a.get(str) != null;
    }

    public void l(String str, PropertyValuesHolder[] propertyValuesHolderArr) {
        this.f20781b.put(str, propertyValuesHolderArr);
    }

    public void m(String str, @Nullable MotionTiming motionTiming) {
        this.f20780a.put(str, motionTiming);
    }

    @NonNull
    public String toString() {
        return 10 + getClass().getName() + ASCIIPropertyListParser.f18652j + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.f20780a + "}\n";
    }
}
