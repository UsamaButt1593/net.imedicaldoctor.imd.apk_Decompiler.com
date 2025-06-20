package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.HashMap;
import java.util.HashSet;

public abstract class MotionKey implements TypedValues {

    /* renamed from: m  reason: collision with root package name */
    public static int f3721m = -1;

    /* renamed from: n  reason: collision with root package name */
    public static final String f3722n = "alpha";
    public static final String o = "elevation";
    public static final String p = "rotationZ";
    public static final String q = "rotationX";
    public static final String r = "transitionPathRotate";
    public static final String s = "scaleX";
    public static final String t = "scaleY";
    public static final String u = "translationX";
    public static final String v = "translationY";
    public static final String w = "CUSTOM";
    public static final String x = "visibility";

    /* renamed from: h  reason: collision with root package name */
    public int f3723h;

    /* renamed from: i  reason: collision with root package name */
    int f3724i;

    /* renamed from: j  reason: collision with root package name */
    String f3725j = null;

    /* renamed from: k  reason: collision with root package name */
    public int f3726k;

    /* renamed from: l  reason: collision with root package name */
    public HashMap<String, CustomVariable> f3727l;

    public MotionKey() {
        int i2 = f3721m;
        this.f3723h = i2;
        this.f3724i = i2;
    }

    public boolean a(int i2, int i3) {
        if (i2 != 100) {
            return false;
        }
        this.f3723h = i3;
        return true;
    }

    public boolean b(int i2, float f2) {
        return false;
    }

    public boolean c(int i2, String str) {
        if (i2 != 101) {
            return false;
        }
        this.f3725j = str;
        return true;
    }

    public boolean d(int i2, boolean z) {
        return false;
    }

    public abstract void f(HashMap<String, SplineSet> hashMap);

    /* renamed from: g */
    public abstract MotionKey clone();

    public MotionKey h(MotionKey motionKey) {
        this.f3723h = motionKey.f3723h;
        this.f3724i = motionKey.f3724i;
        this.f3725j = motionKey.f3725j;
        this.f3726k = motionKey.f3726k;
        return this;
    }

    public abstract void i(HashSet<String> hashSet);

    public int j() {
        return this.f3723h;
    }

    /* access modifiers changed from: package-private */
    public boolean k(String str) {
        String str2 = this.f3725j;
        if (str2 == null || str == null) {
            return false;
        }
        return str.matches(str2);
    }

    public void l(String str, int i2, float f2) {
        this.f3727l.put(str, new CustomVariable(str, i2, f2));
    }

    public void m(String str, int i2, int i3) {
        this.f3727l.put(str, new CustomVariable(str, i2, i3));
    }

    public void n(String str, int i2, String str2) {
        this.f3727l.put(str, new CustomVariable(str, i2, str2));
    }

    public void o(String str, int i2, boolean z) {
        this.f3727l.put(str, new CustomVariable(str, i2, z));
    }

    public void p(int i2) {
        this.f3723h = i2;
    }

    public void q(HashMap<String, Integer> hashMap) {
    }

    public MotionKey r(int i2) {
        this.f3724i = i2;
        return this;
    }

    /* access modifiers changed from: package-private */
    public boolean s(Object obj) {
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : Boolean.parseBoolean(obj.toString());
    }

    /* access modifiers changed from: package-private */
    public float t(Object obj) {
        return obj instanceof Float ? ((Float) obj).floatValue() : Float.parseFloat(obj.toString());
    }

    /* access modifiers changed from: package-private */
    public int u(Object obj) {
        return obj instanceof Integer ? ((Integer) obj).intValue() : Integer.parseInt(obj.toString());
    }
}
