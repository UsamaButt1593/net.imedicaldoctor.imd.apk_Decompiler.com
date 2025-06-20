package com.nineoldandroids.animation;

import android.view.animation.Interpolator;

public abstract class Keyframe implements Cloneable {
    Class X;
    private Interpolator Y = null;
    boolean Z = false;
    float s;

    static class FloatKeyframe extends Keyframe {
        float X2;

        FloatKeyframe(float f2) {
            this.s = f2;
            this.X = Float.TYPE;
        }

        public Object e() {
            return Float.valueOf(this.X2);
        }

        public void q(Object obj) {
            if (obj != null && obj.getClass() == Float.class) {
                this.X2 = ((Float) obj).floatValue();
                this.Z = true;
            }
        }

        /* renamed from: r */
        public FloatKeyframe clone() {
            FloatKeyframe floatKeyframe = new FloatKeyframe(b(), this.X2);
            floatKeyframe.p(c());
            return floatKeyframe;
        }

        public float s() {
            return this.X2;
        }

        FloatKeyframe(float f2, float f3) {
            this.s = f2;
            this.X2 = f3;
            this.X = Float.TYPE;
            this.Z = true;
        }
    }

    static class IntKeyframe extends Keyframe {
        int X2;

        IntKeyframe(float f2) {
            this.s = f2;
            this.X = Integer.TYPE;
        }

        public Object e() {
            return Integer.valueOf(this.X2);
        }

        public void q(Object obj) {
            if (obj != null && obj.getClass() == Integer.class) {
                this.X2 = ((Integer) obj).intValue();
                this.Z = true;
            }
        }

        /* renamed from: r */
        public IntKeyframe clone() {
            IntKeyframe intKeyframe = new IntKeyframe(b(), this.X2);
            intKeyframe.p(c());
            return intKeyframe;
        }

        public int s() {
            return this.X2;
        }

        IntKeyframe(float f2, int i2) {
            this.s = f2;
            this.X2 = i2;
            this.X = Integer.TYPE;
            this.Z = true;
        }
    }

    static class ObjectKeyframe extends Keyframe {
        Object X2;

        ObjectKeyframe(float f2, Object obj) {
            this.s = f2;
            this.X2 = obj;
            boolean z = obj != null;
            this.Z = z;
            this.X = z ? obj.getClass() : Object.class;
        }

        public Object e() {
            return this.X2;
        }

        public void q(Object obj) {
            this.X2 = obj;
            this.Z = obj != null;
        }

        /* renamed from: r */
        public ObjectKeyframe clone() {
            ObjectKeyframe objectKeyframe = new ObjectKeyframe(b(), this.X2);
            objectKeyframe.p(c());
            return objectKeyframe;
        }
    }

    public static Keyframe g(float f2) {
        return new FloatKeyframe(f2);
    }

    public static Keyframe h(float f2, float f3) {
        return new FloatKeyframe(f2, f3);
    }

    public static Keyframe i(float f2) {
        return new IntKeyframe(f2);
    }

    public static Keyframe l(float f2, int i2) {
        return new IntKeyframe(f2, i2);
    }

    public static Keyframe m(float f2) {
        return new ObjectKeyframe(f2, (Object) null);
    }

    public static Keyframe n(float f2, Object obj) {
        return new ObjectKeyframe(f2, obj);
    }

    /* renamed from: a */
    public abstract Keyframe clone();

    public float b() {
        return this.s;
    }

    public Interpolator c() {
        return this.Y;
    }

    public Class d() {
        return this.X;
    }

    public abstract Object e();

    public boolean f() {
        return this.Z;
    }

    public void o(float f2) {
        this.s = f2;
    }

    public void p(Interpolator interpolator) {
        this.Y = interpolator;
    }

    public abstract void q(Object obj);
}
