package androidx.appcompat.graphics.drawable;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.graphics.drawable.DrawableContainerCompat;
import androidx.appcompat.graphics.drawable.StateListDrawableCompat;
import androidx.appcompat.resources.Compatibility;
import androidx.appcompat.resources.R;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.util.ObjectsCompat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class AnimatedStateListDrawableCompat extends StateListDrawableCompat implements TintAwareDrawable {
    private static final String r3 = "AnimatedStateListDrawableCompat";
    private static final String s3 = "transition";
    private static final String t3 = "item";
    private static final String u3 = ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable";
    private static final String v3 = ": <transition> tag requires 'fromId' & 'toId' attributes";
    private static final String w3 = ": <item> tag requires a 'drawable' attribute or child tag defining a drawable";
    private AnimatedStateListState m3;
    private Transition n3;
    private int o3;
    private int p3;
    private boolean q3;

    private static class AnimatableTransition extends Transition {

        /* renamed from: a  reason: collision with root package name */
        private final Animatable f2854a;

        AnimatableTransition(Animatable animatable) {
            super();
            this.f2854a = animatable;
        }

        public void c() {
            this.f2854a.start();
        }

        public void d() {
            this.f2854a.stop();
        }
    }

    static class AnimatedStateListState extends StateListDrawableCompat.StateListState {
        private static final long M = 4294967296L;
        private static final long N = 8589934592L;
        LongSparseArray<Long> K;
        SparseArrayCompat<Integer> L;

        AnimatedStateListState(@Nullable AnimatedStateListState animatedStateListState, @NonNull AnimatedStateListDrawableCompat animatedStateListDrawableCompat, @Nullable Resources resources) {
            super(animatedStateListState, animatedStateListDrawableCompat, resources);
            SparseArrayCompat<Integer> sparseArrayCompat;
            if (animatedStateListState != null) {
                this.K = animatedStateListState.K;
                sparseArrayCompat = animatedStateListState.L;
            } else {
                this.K = new LongSparseArray<>();
                sparseArrayCompat = new SparseArrayCompat<>();
            }
            this.L = sparseArrayCompat;
        }

        private static long H(int i2, int i3) {
            return ((long) i3) | (((long) i2) << 32);
        }

        /* access modifiers changed from: package-private */
        public int F(@NonNull int[] iArr, @NonNull Drawable drawable, int i2) {
            int D = super.D(iArr, drawable);
            this.L.p(D, Integer.valueOf(i2));
            return D;
        }

        /* access modifiers changed from: package-private */
        public int G(int i2, int i3, @NonNull Drawable drawable, boolean z) {
            int a2 = super.a(drawable);
            long H = H(i2, i3);
            long j2 = z ? N : 0;
            long j3 = (long) a2;
            this.K.a(H, Long.valueOf(j3 | j2));
            if (z) {
                this.K.a(H(i3, i2), Long.valueOf(M | j3 | j2));
            }
            return a2;
        }

        /* access modifiers changed from: package-private */
        public int I(int i2) {
            if (i2 < 0) {
                return 0;
            }
            return this.L.i(i2, 0).intValue();
        }

        /* access modifiers changed from: package-private */
        public int J(@NonNull int[] iArr) {
            int E = super.E(iArr);
            return E >= 0 ? E : super.E(StateSet.WILD_CARD);
        }

        /* access modifiers changed from: package-private */
        public int K(int i2, int i3) {
            return (int) this.K.i(H(i2, i3), -1L).longValue();
        }

        /* access modifiers changed from: package-private */
        public boolean L(int i2, int i3) {
            return (this.K.i(H(i2, i3), -1L).longValue() & M) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean M(int i2, int i3) {
            return (this.K.i(H(i2, i3), -1L).longValue() & N) != 0;
        }

        @NonNull
        public Drawable newDrawable() {
            return new AnimatedStateListDrawableCompat(this, (Resources) null);
        }

        /* access modifiers changed from: package-private */
        public void v() {
            this.K = this.K.clone();
            this.L = this.L.clone();
        }

        @NonNull
        public Drawable newDrawable(Resources resources) {
            return new AnimatedStateListDrawableCompat(this, resources);
        }
    }

    private static class AnimatedVectorDrawableTransition extends Transition {

        /* renamed from: a  reason: collision with root package name */
        private final AnimatedVectorDrawableCompat f2855a;

        AnimatedVectorDrawableTransition(AnimatedVectorDrawableCompat animatedVectorDrawableCompat) {
            super();
            this.f2855a = animatedVectorDrawableCompat;
        }

        public void c() {
            this.f2855a.start();
        }

        public void d() {
            this.f2855a.stop();
        }
    }

    private static class AnimationDrawableTransition extends Transition {

        /* renamed from: a  reason: collision with root package name */
        private final ObjectAnimator f2856a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f2857b;

        AnimationDrawableTransition(AnimationDrawable animationDrawable, boolean z, boolean z2) {
            super();
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i2 = 0;
            int i3 = z ? numberOfFrames - 1 : 0;
            i2 = !z ? numberOfFrames - 1 : i2;
            FrameInterpolator frameInterpolator = new FrameInterpolator(animationDrawable, z);
            ObjectAnimator ofInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", new int[]{i3, i2});
            ofInt.setAutoCancel(true);
            ofInt.setDuration((long) frameInterpolator.a());
            ofInt.setInterpolator(frameInterpolator);
            this.f2857b = z2;
            this.f2856a = ofInt;
        }

        public boolean a() {
            return this.f2857b;
        }

        public void b() {
            this.f2856a.reverse();
        }

        public void c() {
            this.f2856a.start();
        }

        public void d() {
            this.f2856a.cancel();
        }
    }

    private static class FrameInterpolator implements TimeInterpolator {

        /* renamed from: a  reason: collision with root package name */
        private int[] f2858a;

        /* renamed from: b  reason: collision with root package name */
        private int f2859b;

        /* renamed from: c  reason: collision with root package name */
        private int f2860c;

        FrameInterpolator(AnimationDrawable animationDrawable, boolean z) {
            b(animationDrawable, z);
        }

        /* access modifiers changed from: package-private */
        public int a() {
            return this.f2860c;
        }

        /* access modifiers changed from: package-private */
        public int b(AnimationDrawable animationDrawable, boolean z) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.f2859b = numberOfFrames;
            int[] iArr = this.f2858a;
            if (iArr == null || iArr.length < numberOfFrames) {
                this.f2858a = new int[numberOfFrames];
            }
            int[] iArr2 = this.f2858a;
            int i2 = 0;
            for (int i3 = 0; i3 < numberOfFrames; i3++) {
                int duration = animationDrawable.getDuration(z ? (numberOfFrames - i3) - 1 : i3);
                iArr2[i3] = duration;
                i2 += duration;
            }
            this.f2860c = i2;
            return i2;
        }

        public float getInterpolation(float f2) {
            int i2 = (int) ((f2 * ((float) this.f2860c)) + 0.5f);
            int i3 = this.f2859b;
            int[] iArr = this.f2858a;
            int i4 = 0;
            while (i4 < i3) {
                int i5 = iArr[i4];
                if (i2 < i5) {
                    break;
                }
                i2 -= i5;
                i4++;
            }
            return (((float) i4) / ((float) i3)) + (i4 < i3 ? ((float) i2) / ((float) this.f2860c) : 0.0f);
        }
    }

    private static abstract class Transition {
        private Transition() {
        }

        public boolean a() {
            return false;
        }

        public void b() {
        }

        public abstract void c();

        public abstract void d();
    }

    public AnimatedStateListDrawableCompat() {
        this((AnimatedStateListState) null, (Resources) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0024 A[Catch:{ XmlPullParserException -> 0x0022, IOException -> 0x0020 }] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001b A[Catch:{ XmlPullParserException -> 0x0022, IOException -> 0x0020 }] */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat B(@androidx.annotation.NonNull android.content.Context r6, @androidx.annotation.DrawableRes int r7, @androidx.annotation.Nullable android.content.res.Resources.Theme r8) {
        /*
            java.lang.String r0 = "parser error"
            android.content.res.Resources r1 = r6.getResources()     // Catch:{ XmlPullParserException -> 0x0022, IOException -> 0x0020 }
            android.content.res.XmlResourceParser r7 = r1.getXml(r7)     // Catch:{ XmlPullParserException -> 0x0022, IOException -> 0x0020 }
            android.util.AttributeSet r2 = android.util.Xml.asAttributeSet(r7)     // Catch:{ XmlPullParserException -> 0x0022, IOException -> 0x0020 }
        L_0x000e:
            int r3 = r7.next()     // Catch:{ XmlPullParserException -> 0x0022, IOException -> 0x0020 }
            r4 = 2
            if (r3 == r4) goto L_0x0019
            r5 = 1
            if (r3 == r5) goto L_0x0019
            goto L_0x000e
        L_0x0019:
            if (r3 != r4) goto L_0x0024
            androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat r6 = C(r6, r1, r7, r2, r8)     // Catch:{ XmlPullParserException -> 0x0022, IOException -> 0x0020 }
            return r6
        L_0x0020:
            r6 = move-exception
            goto L_0x002c
        L_0x0022:
            r6 = move-exception
            goto L_0x002c
        L_0x0024:
            org.xmlpull.v1.XmlPullParserException r6 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ XmlPullParserException -> 0x0022, IOException -> 0x0020 }
            java.lang.String r7 = "No start tag found"
            r6.<init>(r7)     // Catch:{ XmlPullParserException -> 0x0022, IOException -> 0x0020 }
            throw r6     // Catch:{ XmlPullParserException -> 0x0022, IOException -> 0x0020 }
        L_0x002c:
            java.lang.String r7 = r3
            android.util.Log.e(r7, r0, r6)
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.B(android.content.Context, int, android.content.res.Resources$Theme):androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat");
    }

    @NonNull
    public static AnimatedStateListDrawableCompat C(@NonNull Context context, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws IOException, XmlPullParserException {
        String name = xmlPullParser.getName();
        if (name.equals("animated-selector")) {
            AnimatedStateListDrawableCompat animatedStateListDrawableCompat = new AnimatedStateListDrawableCompat();
            animatedStateListDrawableCompat.v(context, resources, xmlPullParser, attributeSet, theme);
            return animatedStateListDrawableCompat;
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + name);
    }

    private void D() {
        onStateChange(getState());
    }

    private int E(@NonNull Context context, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray s = TypedArrayUtils.s(resources, theme, attributeSet, R.styleable.f2897h);
        int resourceId = s.getResourceId(R.styleable.f2898i, 0);
        int resourceId2 = s.getResourceId(R.styleable.f2899j, -1);
        Drawable j2 = resourceId2 > 0 ? ResourceManagerInternal.h().j(context, resourceId2) : null;
        s.recycle();
        int[] p = p(attributeSet);
        if (j2 == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next == 2) {
                j2 = xmlPullParser.getName().equals("vector") ? VectorDrawableCompat.f(resources, xmlPullParser, attributeSet, theme) : Compatibility.Api21Impl.a(resources, xmlPullParser, attributeSet, theme);
            } else {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + w3);
            }
        }
        if (j2 != null) {
            return this.m3.F(p, j2, resourceId);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + w3);
    }

    private int F(@NonNull Context context, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray s = TypedArrayUtils.s(resources, theme, attributeSet, R.styleable.f2900k);
        int resourceId = s.getResourceId(R.styleable.f2903n, -1);
        int resourceId2 = s.getResourceId(R.styleable.f2902m, -1);
        int resourceId3 = s.getResourceId(R.styleable.f2901l, -1);
        Drawable j2 = resourceId3 > 0 ? ResourceManagerInternal.h().j(context, resourceId3) : null;
        boolean z = s.getBoolean(R.styleable.o, false);
        s.recycle();
        if (j2 == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next == 2) {
                j2 = xmlPullParser.getName().equals("animated-vector") ? AnimatedVectorDrawableCompat.f(context, resources, xmlPullParser, attributeSet, theme) : Compatibility.Api21Impl.a(resources, xmlPullParser, attributeSet, theme);
            } else {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + u3);
            }
        }
        if (j2 == null) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + u3);
        } else if (resourceId != -1 && resourceId2 != -1) {
            return this.m3.G(resourceId, resourceId2, j2, z);
        } else {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + v3);
        }
    }

    private boolean G(int i2) {
        int i3;
        int K;
        Transition transition;
        Transition transition2 = this.n3;
        if (transition2 == null) {
            i3 = d();
        } else if (i2 == this.o3) {
            return true;
        } else {
            if (i2 != this.p3 || !transition2.a()) {
                i3 = this.o3;
                transition2.d();
            } else {
                transition2.b();
                this.o3 = this.p3;
                this.p3 = i2;
                return true;
            }
        }
        this.n3 = null;
        this.p3 = -1;
        this.o3 = -1;
        AnimatedStateListState animatedStateListState = this.m3;
        int I = animatedStateListState.I(i3);
        int I2 = animatedStateListState.I(i2);
        if (I2 == 0 || I == 0 || (K = animatedStateListState.K(I, I2)) < 0) {
            return false;
        }
        boolean M = animatedStateListState.M(I, I2);
        h(K);
        Drawable current = getCurrent();
        if (current instanceof AnimationDrawable) {
            transition = new AnimationDrawableTransition((AnimationDrawable) current, animatedStateListState.L(I, I2), M);
        } else if (current instanceof AnimatedVectorDrawableCompat) {
            transition = new AnimatedVectorDrawableTransition((AnimatedVectorDrawableCompat) current);
        } else {
            if (current instanceof Animatable) {
                transition = new AnimatableTransition((Animatable) current);
            }
            return false;
        }
        transition.c();
        this.n3 = transition;
        this.p3 = i3;
        this.o3 = i2;
        return true;
    }

    private void w(@NonNull Context context, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next != 1) {
                int depth2 = xmlPullParser.getDepth();
                if (depth2 < depth && next == 3) {
                    return;
                }
                if (next == 2 && depth2 <= depth) {
                    if (xmlPullParser.getName().equals(t3)) {
                        E(context, resources, xmlPullParser, attributeSet, theme);
                    } else if (xmlPullParser.getName().equals(s3)) {
                        F(context, resources, xmlPullParser, attributeSet, theme);
                    }
                }
            } else {
                return;
            }
        }
    }

    private void x(TypedArray typedArray) {
        AnimatedStateListState animatedStateListState = this.m3;
        animatedStateListState.f2864d |= Compatibility.Api21Impl.b(typedArray);
        animatedStateListState.B(typedArray.getBoolean(R.styleable.f2893d, animatedStateListState.f2869i));
        animatedStateListState.x(typedArray.getBoolean(R.styleable.f2894e, animatedStateListState.f2872l));
        animatedStateListState.y(typedArray.getInt(R.styleable.f2895f, animatedStateListState.A));
        animatedStateListState.z(typedArray.getInt(R.styleable.f2896g, animatedStateListState.B));
        setDither(typedArray.getBoolean(R.styleable.f2891b, animatedStateListState.x));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: A */
    public AnimatedStateListState o() {
        return new AnimatedStateListState(this.m3, this, (Resources) null);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        super.b();
        this.q3 = false;
    }

    /* access modifiers changed from: package-private */
    public void i(@NonNull DrawableContainerCompat.DrawableContainerState drawableContainerState) {
        super.i(drawableContainerState);
        if (drawableContainerState instanceof AnimatedStateListState) {
            this.m3 = (AnimatedStateListState) drawableContainerState;
        }
    }

    public boolean isStateful() {
        return true;
    }

    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        Transition transition = this.n3;
        if (transition != null) {
            transition.d();
            this.n3 = null;
            h(this.o3);
            this.o3 = -1;
            this.p3 = -1;
        }
    }

    @NonNull
    public Drawable mutate() {
        if (!this.q3 && super.mutate() == this) {
            this.m3.v();
            this.q3 = true;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(@NonNull int[] iArr) {
        int J = this.m3.J(iArr);
        boolean z = J != d() && (G(J) || h(J));
        Drawable current = getCurrent();
        return current != null ? z | current.setState(iArr) : z;
    }

    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        Transition transition = this.n3;
        if (transition != null && (visible || z2)) {
            if (z) {
                transition.c();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }

    public void v(@NonNull Context context, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray s = TypedArrayUtils.s(resources, theme, attributeSet, R.styleable.f2890a);
        setVisible(s.getBoolean(R.styleable.f2892c, true), true);
        x(s);
        m(resources);
        s.recycle();
        w(context, resources, xmlPullParser, attributeSet, theme);
        D();
    }

    public void y(@NonNull int[] iArr, @NonNull Drawable drawable, int i2) {
        ObjectsCompat.d(drawable);
        this.m3.F(iArr, drawable, i2);
        onStateChange(getState());
    }

    public <T extends Drawable & Animatable> void z(int i2, int i3, @NonNull T t, boolean z) {
        ObjectsCompat.d(t);
        this.m3.G(i2, i3, t, z);
    }

    AnimatedStateListDrawableCompat(@Nullable AnimatedStateListState animatedStateListState, @Nullable Resources resources) {
        super((StateListDrawableCompat.StateListState) null);
        this.o3 = -1;
        this.p3 = -1;
        i(new AnimatedStateListState(animatedStateListState, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }
}
