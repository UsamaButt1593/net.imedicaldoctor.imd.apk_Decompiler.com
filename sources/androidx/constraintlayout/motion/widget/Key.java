package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.util.HashMap;
import java.util.HashSet;

public abstract class Key {
    public static final String A = "motionProgress";
    public static final String B = "transitionEasing";
    public static final String C = "visibility";

    /* renamed from: f  reason: collision with root package name */
    public static int f4366f = -1;

    /* renamed from: g  reason: collision with root package name */
    public static final String f4367g = "alpha";

    /* renamed from: h  reason: collision with root package name */
    public static final String f4368h = "elevation";

    /* renamed from: i  reason: collision with root package name */
    public static final String f4369i = "rotation";

    /* renamed from: j  reason: collision with root package name */
    public static final String f4370j = "rotationX";

    /* renamed from: k  reason: collision with root package name */
    public static final String f4371k = "rotationY";

    /* renamed from: l  reason: collision with root package name */
    public static final String f4372l = "transformPivotX";

    /* renamed from: m  reason: collision with root package name */
    public static final String f4373m = "transformPivotY";

    /* renamed from: n  reason: collision with root package name */
    public static final String f4374n = "transitionPathRotate";
    public static final String o = "scaleX";
    public static final String p = "scaleY";
    public static final String q = "wavePeriod";
    public static final String r = "waveOffset";
    public static final String s = "wavePhase";
    public static final String t = "waveVariesBy";
    public static final String u = "translationX";
    public static final String v = "translationY";
    public static final String w = "translationZ";
    public static final String x = "progress";
    public static final String y = "CUSTOM";
    public static final String z = "curveFit";

    /* renamed from: a  reason: collision with root package name */
    int f4375a;

    /* renamed from: b  reason: collision with root package name */
    int f4376b;

    /* renamed from: c  reason: collision with root package name */
    String f4377c = null;

    /* renamed from: d  reason: collision with root package name */
    protected int f4378d;

    /* renamed from: e  reason: collision with root package name */
    HashMap<String, ConstraintAttribute> f4379e;

    public Key() {
        int i2 = f4366f;
        this.f4375a = i2;
        this.f4376b = i2;
    }

    public abstract void a(HashMap<String, ViewSpline> hashMap);

    /* renamed from: b */
    public abstract Key clone();

    public Key c(Key key) {
        this.f4375a = key.f4375a;
        this.f4376b = key.f4376b;
        this.f4377c = key.f4377c;
        this.f4378d = key.f4378d;
        this.f4379e = key.f4379e;
        return this;
    }

    /* access modifiers changed from: package-private */
    public abstract void d(HashSet<String> hashSet);

    public int e() {
        return this.f4375a;
    }

    /* access modifiers changed from: package-private */
    public abstract void f(Context context, AttributeSet attributeSet);

    /* access modifiers changed from: package-private */
    public boolean g(String str) {
        String str2 = this.f4377c;
        if (str2 == null || str == null) {
            return false;
        }
        return str.matches(str2);
    }

    public void h(int i2) {
        this.f4375a = i2;
    }

    public void i(HashMap<String, Integer> hashMap) {
    }

    public abstract void j(String str, Object obj);

    public Key k(int i2) {
        this.f4376b = i2;
        return this;
    }

    /* access modifiers changed from: package-private */
    public boolean l(Object obj) {
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : Boolean.parseBoolean(obj.toString());
    }

    /* access modifiers changed from: package-private */
    public float m(Object obj) {
        return obj instanceof Float ? ((Float) obj).floatValue() : Float.parseFloat(obj.toString());
    }

    /* access modifiers changed from: package-private */
    public int n(Object obj) {
        return obj instanceof Integer ? ((Integer) obj).intValue() : Integer.parseInt(obj.toString());
    }
}
