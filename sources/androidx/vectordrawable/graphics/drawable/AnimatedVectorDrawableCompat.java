package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.collection.ArrayMap;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class AnimatedVectorDrawableCompat extends VectorDrawableCommon implements Animatable2Compat {
    private static final String b3 = "AnimatedVDCompat";
    private static final String c3 = "animated-vector";
    private static final String d3 = "target";
    private static final boolean e3 = false;
    private AnimatedVectorDrawableCompatState X;
    AnimatedVectorDrawableDelegateState X2;
    private Context Y;
    private Animator.AnimatorListener Y2;
    private ArgbEvaluator Z;
    ArrayList<Animatable2Compat.AnimationCallback> Z2;
    final Drawable.Callback a3;

    private static class AnimatedVectorDrawableCompatState extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        int f16328a;

        /* renamed from: b  reason: collision with root package name */
        VectorDrawableCompat f16329b;

        /* renamed from: c  reason: collision with root package name */
        AnimatorSet f16330c;

        /* renamed from: d  reason: collision with root package name */
        ArrayList<Animator> f16331d;

        /* renamed from: e  reason: collision with root package name */
        ArrayMap<Animator, String> f16332e;

        public AnimatedVectorDrawableCompatState(Context context, AnimatedVectorDrawableCompatState animatedVectorDrawableCompatState, Drawable.Callback callback, Resources resources) {
            if (animatedVectorDrawableCompatState != null) {
                this.f16328a = animatedVectorDrawableCompatState.f16328a;
                VectorDrawableCompat vectorDrawableCompat = animatedVectorDrawableCompatState.f16329b;
                if (vectorDrawableCompat != null) {
                    Drawable.ConstantState constantState = vectorDrawableCompat.getConstantState();
                    this.f16329b = (VectorDrawableCompat) (resources != null ? constantState.newDrawable(resources) : constantState.newDrawable());
                    VectorDrawableCompat vectorDrawableCompat2 = (VectorDrawableCompat) this.f16329b.mutate();
                    this.f16329b = vectorDrawableCompat2;
                    vectorDrawableCompat2.setCallback(callback);
                    this.f16329b.setBounds(animatedVectorDrawableCompatState.f16329b.getBounds());
                    this.f16329b.m(false);
                }
                ArrayList<Animator> arrayList = animatedVectorDrawableCompatState.f16331d;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.f16331d = new ArrayList<>(size);
                    this.f16332e = new ArrayMap<>(size);
                    for (int i2 = 0; i2 < size; i2++) {
                        Animator animator = animatedVectorDrawableCompatState.f16331d.get(i2);
                        Animator clone = animator.clone();
                        String str = animatedVectorDrawableCompatState.f16332e.get(animator);
                        clone.setTarget(this.f16329b.h(str));
                        this.f16331d.add(clone);
                        this.f16332e.put(clone, str);
                    }
                    a();
                }
            }
        }

        public void a() {
            if (this.f16330c == null) {
                this.f16330c = new AnimatorSet();
            }
            this.f16330c.playTogether(this.f16331d);
        }

        public int getChangingConfigurations() {
            return this.f16328a;
        }

        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    @RequiresApi(24)
    private static class AnimatedVectorDrawableDelegateState extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        private final Drawable.ConstantState f16333a;

        public AnimatedVectorDrawableDelegateState(Drawable.ConstantState constantState) {
            this.f16333a = constantState;
        }

        public boolean canApplyTheme() {
            return this.f16333a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f16333a.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
            Drawable newDrawable = this.f16333a.newDrawable();
            animatedVectorDrawableCompat.s = newDrawable;
            newDrawable.setCallback(animatedVectorDrawableCompat.a3);
            return animatedVectorDrawableCompat;
        }

        public Drawable newDrawable(Resources resources) {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
            Drawable newDrawable = this.f16333a.newDrawable(resources);
            animatedVectorDrawableCompat.s = newDrawable;
            newDrawable.setCallback(animatedVectorDrawableCompat.a3);
            return animatedVectorDrawableCompat;
        }

        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
            Drawable newDrawable = this.f16333a.newDrawable(resources, theme);
            animatedVectorDrawableCompat.s = newDrawable;
            newDrawable.setCallback(animatedVectorDrawableCompat.a3);
            return animatedVectorDrawableCompat;
        }
    }

    AnimatedVectorDrawableCompat() {
        this((Context) null, (AnimatedVectorDrawableCompatState) null, (Resources) null);
    }

    public static void a(Drawable drawable) {
        if (drawable instanceof Animatable) {
            if (Build.VERSION.SDK_INT >= 24) {
                ((AnimatedVectorDrawable) drawable).clearAnimationCallbacks();
            } else {
                ((AnimatedVectorDrawableCompat) drawable).c();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0049 A[Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005a A[Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }] */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat e(@androidx.annotation.NonNull android.content.Context r6, @androidx.annotation.DrawableRes int r7) {
        /*
            java.lang.String r0 = "parser error"
            java.lang.String r1 = "AnimatedVDCompat"
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 24
            if (r2 < r3) goto L_0x0030
            androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat r0 = new androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
            r0.<init>(r6)
            android.content.res.Resources r1 = r6.getResources()
            android.content.res.Resources$Theme r6 = r6.getTheme()
            android.graphics.drawable.Drawable r6 = androidx.core.content.res.ResourcesCompat.g(r1, r7, r6)
            r0.s = r6
            android.graphics.drawable.Drawable$Callback r7 = r0.a3
            r6.setCallback(r7)
            androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat$AnimatedVectorDrawableDelegateState r6 = new androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat$AnimatedVectorDrawableDelegateState
            android.graphics.drawable.Drawable r7 = r0.s
            android.graphics.drawable.Drawable$ConstantState r7 = r7.getConstantState()
            r6.<init>(r7)
            r0.X2 = r6
            return r0
        L_0x0030:
            android.content.res.Resources r2 = r6.getResources()
            android.content.res.XmlResourceParser r7 = r2.getXml(r7)     // Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }
            android.util.AttributeSet r2 = android.util.Xml.asAttributeSet(r7)     // Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }
        L_0x003c:
            int r3 = r7.next()     // Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }
            r4 = 2
            if (r3 == r4) goto L_0x0047
            r5 = 1
            if (r3 == r5) goto L_0x0047
            goto L_0x003c
        L_0x0047:
            if (r3 != r4) goto L_0x005a
            android.content.res.Resources r3 = r6.getResources()     // Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }
            android.content.res.Resources$Theme r4 = r6.getTheme()     // Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }
            androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat r6 = f(r6, r3, r7, r2, r4)     // Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }
            return r6
        L_0x0056:
            r6 = move-exception
            goto L_0x0062
        L_0x0058:
            r6 = move-exception
            goto L_0x0062
        L_0x005a:
            org.xmlpull.v1.XmlPullParserException r6 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }
            java.lang.String r7 = "No start tag found"
            r6.<init>(r7)     // Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }
            throw r6     // Catch:{ XmlPullParserException -> 0x0058, IOException -> 0x0056 }
        L_0x0062:
            android.util.Log.e(r1, r0, r6)
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat.e(android.content.Context, int):androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat");
    }

    public static AnimatedVectorDrawableCompat f(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat(context);
        animatedVectorDrawableCompat.inflate(resources, xmlPullParser, attributeSet, theme);
        return animatedVectorDrawableCompat;
    }

    public static void g(Drawable drawable, Animatable2Compat.AnimationCallback animationCallback) {
        if (drawable != null && animationCallback != null && (drawable instanceof Animatable)) {
            if (Build.VERSION.SDK_INT >= 24) {
                h((AnimatedVectorDrawable) drawable, animationCallback);
            } else {
                ((AnimatedVectorDrawableCompat) drawable).b(animationCallback);
            }
        }
    }

    @RequiresApi(23)
    private static void h(@NonNull AnimatedVectorDrawable animatedVectorDrawable, @NonNull Animatable2Compat.AnimationCallback animationCallback) {
        animatedVectorDrawable.registerAnimationCallback(animationCallback.a());
    }

    private void i() {
        Animator.AnimatorListener animatorListener = this.Y2;
        if (animatorListener != null) {
            this.X.f16330c.removeListener(animatorListener);
            this.Y2 = null;
        }
    }

    private void j(String str, Animator animator) {
        animator.setTarget(this.X.f16329b.h(str));
        AnimatedVectorDrawableCompatState animatedVectorDrawableCompatState = this.X;
        if (animatedVectorDrawableCompatState.f16331d == null) {
            animatedVectorDrawableCompatState.f16331d = new ArrayList<>();
            this.X.f16332e = new ArrayMap<>();
        }
        this.X.f16331d.add(animator);
        this.X.f16332e.put(animator, str);
    }

    private void k(Animator animator) {
        ArrayList<Animator> childAnimations;
        if ((animator instanceof AnimatorSet) && (childAnimations = ((AnimatorSet) animator).getChildAnimations()) != null) {
            for (int i2 = 0; i2 < childAnimations.size(); i2++) {
                k(childAnimations.get(i2));
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.Z == null) {
                    this.Z = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.Z);
            }
        }
    }

    public static boolean l(Drawable drawable, Animatable2Compat.AnimationCallback animationCallback) {
        if (drawable == null || animationCallback == null || !(drawable instanceof Animatable)) {
            return false;
        }
        return Build.VERSION.SDK_INT >= 24 ? m((AnimatedVectorDrawable) drawable, animationCallback) : ((AnimatedVectorDrawableCompat) drawable).d(animationCallback);
    }

    @RequiresApi(23)
    private static boolean m(AnimatedVectorDrawable animatedVectorDrawable, Animatable2Compat.AnimationCallback animationCallback) {
        return animatedVectorDrawable.unregisterAnimationCallback(animationCallback.a());
    }

    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.s;
        if (drawable != null) {
            DrawableCompat.a(drawable, theme);
        }
    }

    public void b(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        Drawable drawable = this.s;
        if (drawable != null) {
            h((AnimatedVectorDrawable) drawable, animationCallback);
        } else if (animationCallback != null) {
            if (this.Z2 == null) {
                this.Z2 = new ArrayList<>();
            }
            if (!this.Z2.contains(animationCallback)) {
                this.Z2.add(animationCallback);
                if (this.Y2 == null) {
                    this.Y2 = new AnimatorListenerAdapter() {
                        public void onAnimationEnd(Animator animator) {
                            ArrayList arrayList = new ArrayList(AnimatedVectorDrawableCompat.this.Z2);
                            int size = arrayList.size();
                            for (int i2 = 0; i2 < size; i2++) {
                                ((Animatable2Compat.AnimationCallback) arrayList.get(i2)).b(AnimatedVectorDrawableCompat.this);
                            }
                        }

                        public void onAnimationStart(Animator animator) {
                            ArrayList arrayList = new ArrayList(AnimatedVectorDrawableCompat.this.Z2);
                            int size = arrayList.size();
                            for (int i2 = 0; i2 < size; i2++) {
                                ((Animatable2Compat.AnimationCallback) arrayList.get(i2)).c(AnimatedVectorDrawableCompat.this);
                            }
                        }
                    };
                }
                this.X.f16330c.addListener(this.Y2);
            }
        }
    }

    public void c() {
        Drawable drawable = this.s;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).clearAnimationCallbacks();
            return;
        }
        i();
        ArrayList<Animatable2Compat.AnimationCallback> arrayList = this.Z2;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    public boolean canApplyTheme() {
        Drawable drawable = this.s;
        if (drawable != null) {
            return DrawableCompat.b(drawable);
        }
        return false;
    }

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public boolean d(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        Drawable drawable = this.s;
        if (drawable != null) {
            m((AnimatedVectorDrawable) drawable, animationCallback);
        }
        ArrayList<Animatable2Compat.AnimationCallback> arrayList = this.Z2;
        if (arrayList == null || animationCallback == null) {
            return false;
        }
        boolean remove = arrayList.remove(animationCallback);
        if (this.Z2.size() == 0) {
            i();
        }
        return remove;
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.s;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.X.f16329b.draw(canvas);
        if (this.X.f16330c.isStarted()) {
            invalidateSelf();
        }
    }

    public int getAlpha() {
        Drawable drawable = this.s;
        return drawable != null ? DrawableCompat.d(drawable) : this.X.f16329b.getAlpha();
    }

    public int getChangingConfigurations() {
        Drawable drawable = this.s;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.X.f16328a;
    }

    public ColorFilter getColorFilter() {
        Drawable drawable = this.s;
        return drawable != null ? DrawableCompat.e(drawable) : this.X.f16329b.getColorFilter();
    }

    public Drawable.ConstantState getConstantState() {
        if (this.s == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new AnimatedVectorDrawableDelegateState(this.s.getConstantState());
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public int getIntrinsicHeight() {
        Drawable drawable = this.s;
        return drawable != null ? drawable.getIntrinsicHeight() : this.X.f16329b.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        Drawable drawable = this.s;
        return drawable != null ? drawable.getIntrinsicWidth() : this.X.f16329b.getIntrinsicWidth();
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public int getOpacity() {
        Drawable drawable = this.s;
        return drawable != null ? drawable.getOpacity() : this.X.f16329b.getOpacity();
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        inflate(resources, xmlPullParser, attributeSet, (Resources.Theme) null);
    }

    public boolean isAutoMirrored() {
        Drawable drawable = this.s;
        return drawable != null ? DrawableCompat.h(drawable) : this.X.f16329b.isAutoMirrored();
    }

    public boolean isRunning() {
        Drawable drawable = this.s;
        return drawable != null ? ((AnimatedVectorDrawable) drawable).isRunning() : this.X.f16330c.isRunning();
    }

    public boolean isStateful() {
        Drawable drawable = this.s;
        return drawable != null ? drawable.isStateful() : this.X.f16329b.isStateful();
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public Drawable mutate() {
        Drawable drawable = this.s;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.s;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.X.f16329b.setBounds(rect);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i2) {
        Drawable drawable = this.s;
        return drawable != null ? drawable.setLevel(i2) : this.X.f16329b.setLevel(i2);
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.s;
        return drawable != null ? drawable.setState(iArr) : this.X.f16329b.setState(iArr);
    }

    public void setAlpha(int i2) {
        Drawable drawable = this.s;
        if (drawable != null) {
            drawable.setAlpha(i2);
        } else {
            this.X.f16329b.setAlpha(i2);
        }
    }

    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.s;
        if (drawable != null) {
            DrawableCompat.j(drawable, z);
        } else {
            this.X.f16329b.setAutoMirrored(z);
        }
    }

    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i2) {
        super.setChangingConfigurations(i2);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(int i2, PorterDuff.Mode mode) {
        super.setColorFilter(i2, mode);
    }

    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i2, int i3, int i4, int i5) {
        super.setHotspotBounds(i2, i3, i4, i5);
    }

    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    public void setTint(int i2) {
        Drawable drawable = this.s;
        if (drawable != null) {
            DrawableCompat.n(drawable, i2);
        } else {
            this.X.f16329b.setTint(i2);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.s;
        if (drawable != null) {
            DrawableCompat.o(drawable, colorStateList);
        } else {
            this.X.f16329b.setTintList(colorStateList);
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.s;
        if (drawable != null) {
            DrawableCompat.p(drawable, mode);
        } else {
            this.X.f16329b.setTintMode(mode);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.s;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        this.X.f16329b.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    public void start() {
        Drawable drawable = this.s;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
        } else if (!this.X.f16330c.isStarted()) {
            this.X.f16330c.start();
            invalidateSelf();
        }
    }

    public void stop() {
        Drawable drawable = this.s;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.X.f16330c.end();
        }
    }

    private AnimatedVectorDrawableCompat(@Nullable Context context) {
        this(context, (AnimatedVectorDrawableCompatState) null, (Resources) null);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray obtainAttributes;
        Drawable drawable = this.s;
        if (drawable != null) {
            DrawableCompat.g(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (c3.equals(name)) {
                    obtainAttributes = TypedArrayUtils.s(resources, theme, attributeSet, AndroidResources.M);
                    int resourceId = obtainAttributes.getResourceId(0, 0);
                    if (resourceId != 0) {
                        VectorDrawableCompat e2 = VectorDrawableCompat.e(resources, resourceId, theme);
                        e2.m(false);
                        e2.setCallback(this.a3);
                        VectorDrawableCompat vectorDrawableCompat = this.X.f16329b;
                        if (vectorDrawableCompat != null) {
                            vectorDrawableCompat.setCallback((Drawable.Callback) null);
                        }
                        this.X.f16329b = e2;
                    }
                } else if ("target".equals(name)) {
                    obtainAttributes = resources.obtainAttributes(attributeSet, AndroidResources.O);
                    String string = obtainAttributes.getString(0);
                    int resourceId2 = obtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.Y;
                        if (context != null) {
                            j(string, AnimatorInflaterCompat.j(context, resourceId2));
                        } else {
                            obtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                } else {
                    continue;
                }
                obtainAttributes.recycle();
            }
            eventType = xmlPullParser.next();
        }
        this.X.a();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.s;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.X.f16329b.setColorFilter(colorFilter);
        }
    }

    private AnimatedVectorDrawableCompat(@Nullable Context context, @Nullable AnimatedVectorDrawableCompatState animatedVectorDrawableCompatState, @Nullable Resources resources) {
        this.Z = null;
        this.Y2 = null;
        this.Z2 = null;
        AnonymousClass1 r0 = new Drawable.Callback() {
            public void invalidateDrawable(Drawable drawable) {
                AnimatedVectorDrawableCompat.this.invalidateSelf();
            }

            public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
                AnimatedVectorDrawableCompat.this.scheduleSelf(runnable, j2);
            }

            public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
                AnimatedVectorDrawableCompat.this.unscheduleSelf(runnable);
            }
        };
        this.a3 = r0;
        this.Y = context;
        if (animatedVectorDrawableCompatState != null) {
            this.X = animatedVectorDrawableCompatState;
        } else {
            this.X = new AnimatedVectorDrawableCompatState(context, animatedVectorDrawableCompatState, r0, resources);
        }
    }
}
