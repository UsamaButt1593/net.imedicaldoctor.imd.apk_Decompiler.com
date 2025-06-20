package androidx.appcompat.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import android.widget.CompoundButton;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.text.AllCapsTransformationMethod;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.emoji2.text.EmojiCompat;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public class SwitchCompat extends CompoundButton implements EmojiCompatConfigurationView {
    private static final int O3 = 250;
    private static final int P3 = 0;
    private static final int Q3 = 1;
    private static final int R3 = 2;
    private static final String S3 = "android.widget.Switch";
    private static final int T3 = 1;
    private static final int U3 = 2;
    private static final int V3 = 3;
    private static final Property<SwitchCompat, Float> W3 = new Property<SwitchCompat, Float>(Float.class, "thumbPos") {
        /* renamed from: a */
        public Float get(SwitchCompat switchCompat) {
            return Float.valueOf(switchCompat.v3);
        }

        /* renamed from: b */
        public void set(SwitchCompat switchCompat, Float f2) {
            switchCompat.setThumbPosition(f2.floatValue());
        }
    };
    private static final int[] X3 = {16842912};
    private int A3;
    private int B3;
    private int C3;
    private boolean D3;
    private final TextPaint E3;
    private ColorStateList F3;
    private Layout G3;
    private Layout H3;
    @Nullable
    private TransformationMethod I3;
    ObjectAnimator J3;
    private final AppCompatTextHelper K3;
    @NonNull
    private AppCompatEmojiTextHelper L3;
    @Nullable
    private EmojiCompatInitCallback M3;
    private final Rect N3;
    private ColorStateList X2;
    private PorterDuff.Mode Y2;
    private boolean Z2;
    private boolean a3;
    private Drawable b3;
    private ColorStateList c3;
    private PorterDuff.Mode d3;
    private boolean e3;
    private boolean f3;
    private int g3;
    private int h3;
    private int i3;
    private boolean j3;
    private CharSequence k3;
    private CharSequence l3;
    private CharSequence m3;
    private CharSequence n3;
    private boolean o3;
    private int p3;
    private int q3;
    private float r3;
    private Drawable s;
    private float s3;
    private VelocityTracker t3;
    private int u3;
    float v3;
    private int w3;
    private int x3;
    private int y3;
    private int z3;

    static class EmojiCompatInitCallback extends EmojiCompat.InitCallback {

        /* renamed from: a  reason: collision with root package name */
        private final Reference<SwitchCompat> f3278a;

        EmojiCompatInitCallback(SwitchCompat switchCompat) {
            this.f3278a = new WeakReference(switchCompat);
        }

        public void a(@Nullable Throwable th) {
            SwitchCompat switchCompat = this.f3278a.get();
            if (switchCompat != null) {
                switchCompat.k();
            }
        }

        public void b() {
            SwitchCompat switchCompat = this.f3278a.get();
            if (switchCompat != null) {
                switchCompat.k();
            }
        }
    }

    @RequiresApi(29)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final class InspectionCompanion implements android.view.inspector.InspectionCompanion<SwitchCompat> {

        /* renamed from: a  reason: collision with root package name */
        private boolean f3279a = false;

        /* renamed from: b  reason: collision with root package name */
        private int f3280b;

        /* renamed from: c  reason: collision with root package name */
        private int f3281c;

        /* renamed from: d  reason: collision with root package name */
        private int f3282d;

        /* renamed from: e  reason: collision with root package name */
        private int f3283e;

        /* renamed from: f  reason: collision with root package name */
        private int f3284f;

        /* renamed from: g  reason: collision with root package name */
        private int f3285g;

        /* renamed from: h  reason: collision with root package name */
        private int f3286h;

        /* renamed from: i  reason: collision with root package name */
        private int f3287i;

        /* renamed from: j  reason: collision with root package name */
        private int f3288j;

        /* renamed from: k  reason: collision with root package name */
        private int f3289k;

        /* renamed from: l  reason: collision with root package name */
        private int f3290l;

        /* renamed from: m  reason: collision with root package name */
        private int f3291m;

        /* renamed from: n  reason: collision with root package name */
        private int f3292n;

        /* renamed from: a */
        public void readProperties(@NonNull SwitchCompat switchCompat, @NonNull PropertyReader propertyReader) {
            if (this.f3279a) {
                propertyReader.readObject(this.f3280b, switchCompat.getTextOff());
                propertyReader.readObject(this.f3281c, switchCompat.getTextOn());
                propertyReader.readObject(this.f3282d, switchCompat.getThumbDrawable());
                propertyReader.readBoolean(this.f3283e, switchCompat.getShowText());
                propertyReader.readBoolean(this.f3284f, switchCompat.getSplitTrack());
                propertyReader.readInt(this.f3285g, switchCompat.getSwitchMinWidth());
                propertyReader.readInt(this.f3286h, switchCompat.getSwitchPadding());
                propertyReader.readInt(this.f3287i, switchCompat.getThumbTextPadding());
                propertyReader.readObject(this.f3288j, switchCompat.getThumbTintList());
                propertyReader.readObject(this.f3289k, switchCompat.getThumbTintMode());
                propertyReader.readObject(this.f3290l, switchCompat.getTrackDrawable());
                propertyReader.readObject(this.f3291m, switchCompat.getTrackTintList());
                propertyReader.readObject(this.f3292n, switchCompat.getTrackTintMode());
                return;
            }
            throw C0004e.a();
        }

        public void mapProperties(@NonNull PropertyMapper propertyMapper) {
            this.f3280b = propertyMapper.mapObject("textOff", 16843045);
            this.f3281c = propertyMapper.mapObject("textOn", 16843044);
            this.f3282d = propertyMapper.mapObject("thumb", 16843074);
            this.f3283e = propertyMapper.mapBoolean("showText", R.attr.T2);
            this.f3284f = propertyMapper.mapBoolean("splitTrack", R.attr.Z2);
            this.f3285g = propertyMapper.mapInt("switchMinWidth", R.attr.j3);
            this.f3286h = propertyMapper.mapInt("switchPadding", R.attr.k3);
            this.f3287i = propertyMapper.mapInt("thumbTextPadding", R.attr.B3);
            this.f3288j = propertyMapper.mapObject("thumbTint", R.attr.C3);
            this.f3289k = propertyMapper.mapObject("thumbTintMode", R.attr.D3);
            this.f3290l = propertyMapper.mapObject("track", R.attr.Y3);
            this.f3291m = propertyMapper.mapObject("trackTint", R.attr.Z3);
            this.f3292n = propertyMapper.mapObject("trackTintMode", R.attr.a4);
            this.f3279a = true;
        }
    }

    public SwitchCompat(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void a(boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, W3, new float[]{z ? 1.0f : 0.0f});
        this.J3 = ofFloat;
        ofFloat.setDuration(250);
        this.J3.setAutoCancel(true);
        this.J3.start();
    }

    private void c() {
        Drawable drawable = this.s;
        if (drawable == null) {
            return;
        }
        if (this.Z2 || this.a3) {
            Drawable mutate = DrawableCompat.r(drawable).mutate();
            this.s = mutate;
            if (this.Z2) {
                DrawableCompat.o(mutate, this.X2);
            }
            if (this.a3) {
                DrawableCompat.p(this.s, this.Y2);
            }
            if (this.s.isStateful()) {
                this.s.setState(getDrawableState());
            }
        }
    }

    private void d() {
        Drawable drawable = this.b3;
        if (drawable == null) {
            return;
        }
        if (this.e3 || this.f3) {
            Drawable mutate = DrawableCompat.r(drawable).mutate();
            this.b3 = mutate;
            if (this.e3) {
                DrawableCompat.o(mutate, this.c3);
            }
            if (this.f3) {
                DrawableCompat.p(this.b3, this.d3);
            }
            if (this.b3.isStateful()) {
                this.b3.setState(getDrawableState());
            }
        }
    }

    private void e() {
        ObjectAnimator objectAnimator = this.J3;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    private void f(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(3);
        super.onTouchEvent(obtain);
        obtain.recycle();
    }

    private static float g(float f2, float f4, float f5) {
        if (f2 < f4) {
            return f4;
        }
        return f2 > f5 ? f5 : f2;
    }

    @NonNull
    private AppCompatEmojiTextHelper getEmojiTextViewHelper() {
        if (this.L3 == null) {
            this.L3 = new AppCompatEmojiTextHelper(this);
        }
        return this.L3;
    }

    private boolean getTargetCheckedState() {
        return this.v3 > 0.5f;
    }

    private int getThumbOffset() {
        return (int) (((ViewUtils.b(this) ? 1.0f - this.v3 : this.v3) * ((float) getThumbScrollRange())) + 0.5f);
    }

    private int getThumbScrollRange() {
        Drawable drawable = this.b3;
        if (drawable == null) {
            return 0;
        }
        Rect rect = this.N3;
        drawable.getPadding(rect);
        Drawable drawable2 = this.s;
        Rect d2 = drawable2 != null ? DrawableUtils.d(drawable2) : DrawableUtils.f3191c;
        return ((((this.w3 - this.y3) - rect.left) - rect.right) - d2.left) - d2.right;
    }

    @Nullable
    private CharSequence h(@Nullable CharSequence charSequence) {
        TransformationMethod f2 = getEmojiTextViewHelper().f(this.I3);
        return f2 != null ? f2.getTransformation(charSequence, this) : charSequence;
    }

    private boolean i(float f2, float f4) {
        if (this.s == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.s.getPadding(this.N3);
        int i2 = this.A3;
        int i4 = this.q3;
        int i5 = i2 - i4;
        int i6 = (this.z3 + thumbOffset) - i4;
        Rect rect = this.N3;
        return f2 > ((float) i6) && f2 < ((float) ((((this.y3 + i6) + rect.left) + rect.right) + i4)) && f4 > ((float) i5) && f4 < ((float) (this.C3 + i4));
    }

    private Layout j(CharSequence charSequence) {
        TextPaint textPaint = this.E3;
        return new StaticLayout(charSequence, textPaint, charSequence != null ? (int) Math.ceil((double) Layout.getDesiredWidth(charSequence, textPaint)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    private void l() {
        if (Build.VERSION.SDK_INT >= 30) {
            CharSequence charSequence = this.m3;
            if (charSequence == null) {
                charSequence = getResources().getString(R.string.f2654g);
            }
            ViewCompat.A2(this, charSequence);
        }
    }

    private void m() {
        if (Build.VERSION.SDK_INT >= 30) {
            CharSequence charSequence = this.k3;
            if (charSequence == null) {
                charSequence = getResources().getString(R.string.f2655h);
            }
            ViewCompat.A2(this, charSequence);
        }
    }

    private void p(int i2, int i4) {
        o(i2 != 1 ? i2 != 2 ? i2 != 3 ? null : Typeface.MONOSPACE : Typeface.SERIF : Typeface.SANS_SERIF, i4);
    }

    private void q() {
        if (this.M3 == null && this.L3.b() && EmojiCompat.q()) {
            EmojiCompat c2 = EmojiCompat.c();
            int i2 = c2.i();
            if (i2 == 3 || i2 == 0) {
                EmojiCompatInitCallback emojiCompatInitCallback = new EmojiCompatInitCallback(this);
                this.M3 = emojiCompatInitCallback;
                c2.B(emojiCompatInitCallback);
            }
        }
    }

    private void r(MotionEvent motionEvent) {
        this.p3 = 0;
        boolean z = true;
        boolean z2 = motionEvent.getAction() == 1 && isEnabled();
        boolean isChecked = isChecked();
        if (z2) {
            this.t3.computeCurrentVelocity(1000);
            float xVelocity = this.t3.getXVelocity();
            if (Math.abs(xVelocity) <= ((float) this.u3)) {
                z = getTargetCheckedState();
            } else if (!ViewUtils.b(this) ? xVelocity <= 0.0f : xVelocity >= 0.0f) {
                z = false;
            }
        } else {
            z = isChecked;
        }
        if (z != isChecked) {
            playSoundEffect(0);
        }
        setChecked(z);
        f(motionEvent);
    }

    private void setTextOffInternal(CharSequence charSequence) {
        this.m3 = charSequence;
        this.n3 = h(charSequence);
        this.H3 = null;
        if (this.o3) {
            q();
        }
    }

    private void setTextOnInternal(CharSequence charSequence) {
        this.k3 = charSequence;
        this.l3 = h(charSequence);
        this.G3 = null;
        if (this.o3) {
            q();
        }
    }

    public boolean b() {
        return getEmojiTextViewHelper().b();
    }

    public void draw(@NonNull Canvas canvas) {
        int i2;
        int i4;
        Rect rect = this.N3;
        int i5 = this.z3;
        int i6 = this.A3;
        int i7 = this.B3;
        int i8 = this.C3;
        int thumbOffset = getThumbOffset() + i5;
        Drawable drawable = this.s;
        Rect d2 = drawable != null ? DrawableUtils.d(drawable) : DrawableUtils.f3191c;
        Drawable drawable2 = this.b3;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            int i9 = rect.left;
            thumbOffset += i9;
            if (d2 != null) {
                int i10 = d2.left;
                if (i10 > i9) {
                    i5 += i10 - i9;
                }
                int i11 = d2.top;
                int i12 = rect.top;
                i2 = i11 > i12 ? (i11 - i12) + i6 : i6;
                int i13 = d2.right;
                int i14 = rect.right;
                if (i13 > i14) {
                    i7 -= i13 - i14;
                }
                int i15 = d2.bottom;
                int i16 = rect.bottom;
                if (i15 > i16) {
                    i4 = i8 - (i15 - i16);
                    this.b3.setBounds(i5, i2, i7, i4);
                }
            } else {
                i2 = i6;
            }
            i4 = i8;
            this.b3.setBounds(i5, i2, i7, i4);
        }
        Drawable drawable3 = this.s;
        if (drawable3 != null) {
            drawable3.getPadding(rect);
            int i17 = thumbOffset - rect.left;
            int i18 = thumbOffset + this.y3 + rect.right;
            this.s.setBounds(i17, i6, i18, i8);
            Drawable background = getBackground();
            if (background != null) {
                DrawableCompat.l(background, i17, i6, i18, i8);
            }
        }
        super.draw(canvas);
    }

    public void drawableHotspotChanged(float f2, float f4) {
        super.drawableHotspotChanged(f2, f4);
        Drawable drawable = this.s;
        if (drawable != null) {
            DrawableCompat.k(drawable, f2, f4);
        }
        Drawable drawable2 = this.b3;
        if (drawable2 != null) {
            DrawableCompat.k(drawable2, f2, f4);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.s;
        boolean state = (drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState);
        Drawable drawable2 = this.b3;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    public int getCompoundPaddingLeft() {
        if (!ViewUtils.b(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.w3;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.i3 : compoundPaddingLeft;
    }

    public int getCompoundPaddingRight() {
        if (ViewUtils.b(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.w3;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.i3 : compoundPaddingRight;
    }

    @Nullable
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return TextViewCompat.F(super.getCustomSelectionActionModeCallback());
    }

    public boolean getShowText() {
        return this.o3;
    }

    public boolean getSplitTrack() {
        return this.j3;
    }

    public int getSwitchMinWidth() {
        return this.h3;
    }

    public int getSwitchPadding() {
        return this.i3;
    }

    public CharSequence getTextOff() {
        return this.m3;
    }

    public CharSequence getTextOn() {
        return this.k3;
    }

    public Drawable getThumbDrawable() {
        return this.s;
    }

    /* access modifiers changed from: protected */
    @FloatRange(from = 0.0d, to = 1.0d)
    public final float getThumbPosition() {
        return this.v3;
    }

    public int getThumbTextPadding() {
        return this.g3;
    }

    @Nullable
    public ColorStateList getThumbTintList() {
        return this.X2;
    }

    @Nullable
    public PorterDuff.Mode getThumbTintMode() {
        return this.Y2;
    }

    public Drawable getTrackDrawable() {
        return this.b3;
    }

    @Nullable
    public ColorStateList getTrackTintList() {
        return this.c3;
    }

    @Nullable
    public PorterDuff.Mode getTrackTintMode() {
        return this.d3;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.s;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.b3;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.J3;
        if (objectAnimator != null && objectAnimator.isStarted()) {
            this.J3.end();
            this.J3 = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void k() {
        setTextOnInternal(this.k3);
        setTextOffInternal(this.m3);
        requestLayout();
    }

    public void n(Context context, int i2) {
        TintTypedArray E = TintTypedArray.E(context, i2, R.styleable.a6);
        ColorStateList d2 = E.d(R.styleable.e6);
        if (d2 == null) {
            d2 = getTextColors();
        }
        this.F3 = d2;
        int g2 = E.g(R.styleable.b6, 0);
        if (g2 != 0) {
            float f2 = (float) g2;
            if (f2 != this.E3.getTextSize()) {
                this.E3.setTextSize(f2);
                requestLayout();
            }
        }
        p(E.o(R.styleable.c6, -1), E.o(R.styleable.d6, -1));
        this.I3 = E.a(R.styleable.p6, false) ? new AllCapsTransformationMethod(getContext()) : null;
        setTextOnInternal(this.k3);
        setTextOffInternal(this.m3);
        E.I();
    }

    public void o(Typeface typeface, int i2) {
        float f2 = 0.0f;
        boolean z = false;
        if (i2 > 0) {
            Typeface defaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i2) : Typeface.create(typeface, i2);
            setSwitchTypeface(defaultFromStyle);
            int i4 = (~(defaultFromStyle != null ? defaultFromStyle.getStyle() : 0)) & i2;
            TextPaint textPaint = this.E3;
            if ((i4 & 1) != 0) {
                z = true;
            }
            textPaint.setFakeBoldText(z);
            TextPaint textPaint2 = this.E3;
            if ((i4 & 2) != 0) {
                f2 = -0.25f;
            }
            textPaint2.setTextSkewX(f2);
            return;
        }
        this.E3.setFakeBoldText(false);
        this.E3.setTextSkewX(0.0f);
        setSwitchTypeface(typeface);
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, X3);
        }
        return onCreateDrawableState;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i2;
        super.onDraw(canvas);
        Rect rect = this.N3;
        Drawable drawable = this.b3;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i4 = this.A3;
        int i5 = this.C3;
        int i6 = i4 + rect.top;
        int i7 = i5 - rect.bottom;
        Drawable drawable2 = this.s;
        if (drawable != null) {
            if (!this.j3 || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect d2 = DrawableUtils.d(drawable2);
                drawable2.copyBounds(rect);
                rect.left += d2.left;
                rect.right -= d2.right;
                int save = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(save);
            }
        }
        int save2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Layout layout2 = getTargetCheckedState() ? this.G3 : this.H3;
        if (layout2 != null) {
            int[] drawableState = getDrawableState();
            ColorStateList colorStateList = this.F3;
            if (colorStateList != null) {
                this.E3.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            this.E3.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                i2 = bounds.left + bounds.right;
            } else {
                i2 = getWidth();
            }
            canvas.translate((float) ((i2 / 2) - (layout2.getWidth() / 2)), (float) (((i6 + i7) / 2) - (layout2.getHeight() / 2)));
            layout2.draw(canvas);
        }
        canvas.restoreToCount(save2);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(S3);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(S3);
        if (Build.VERSION.SDK_INT < 30) {
            CharSequence charSequence = isChecked() ? this.k3 : this.m3;
            if (!TextUtils.isEmpty(charSequence)) {
                CharSequence text = accessibilityNodeInfo.getText();
                if (TextUtils.isEmpty(text)) {
                    accessibilityNodeInfo.setText(charSequence);
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(text);
                sb.append(' ');
                sb.append(charSequence);
                accessibilityNodeInfo.setText(sb);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        super.onLayout(z, i2, i4, i5, i6);
        int i13 = 0;
        if (this.s != null) {
            Rect rect = this.N3;
            Drawable drawable = this.b3;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect d2 = DrawableUtils.d(this.s);
            i7 = Math.max(0, d2.left - rect.left);
            i13 = Math.max(0, d2.right - rect.right);
        } else {
            i7 = 0;
        }
        if (ViewUtils.b(this)) {
            i9 = getPaddingLeft() + i7;
            i8 = ((this.w3 + i9) - i7) - i13;
        } else {
            i8 = (getWidth() - getPaddingRight()) - i13;
            i9 = (i8 - this.w3) + i7 + i13;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            i12 = this.x3;
            i11 = (((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2) - (i12 / 2);
        } else if (gravity != 80) {
            i11 = getPaddingTop();
            i12 = this.x3;
        } else {
            i10 = getHeight() - getPaddingBottom();
            i11 = i10 - this.x3;
            this.z3 = i9;
            this.A3 = i11;
            this.C3 = i10;
            this.B3 = i8;
        }
        i10 = i12 + i11;
        this.z3 = i9;
        this.A3 = i11;
        this.C3 = i10;
        this.B3 = i8;
    }

    public void onMeasure(int i2, int i4) {
        int i5;
        int i6;
        if (this.o3) {
            if (this.G3 == null) {
                this.G3 = j(this.l3);
            }
            if (this.H3 == null) {
                this.H3 = j(this.n3);
            }
        }
        Rect rect = this.N3;
        Drawable drawable = this.s;
        int i7 = 0;
        if (drawable != null) {
            drawable.getPadding(rect);
            i6 = (this.s.getIntrinsicWidth() - rect.left) - rect.right;
            i5 = this.s.getIntrinsicHeight();
        } else {
            i6 = 0;
            i5 = 0;
        }
        this.y3 = Math.max(this.o3 ? Math.max(this.G3.getWidth(), this.H3.getWidth()) + (this.g3 * 2) : 0, i6);
        Drawable drawable2 = this.b3;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            i7 = this.b3.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int i8 = rect.left;
        int i9 = rect.right;
        Drawable drawable3 = this.s;
        if (drawable3 != null) {
            Rect d2 = DrawableUtils.d(drawable3);
            i8 = Math.max(i8, d2.left);
            i9 = Math.max(i9, d2.right);
        }
        int max = this.D3 ? Math.max(this.h3, (this.y3 * 2) + i8 + i9) : this.h3;
        int max2 = Math.max(i7, i5);
        this.w3 = max;
        this.x3 = max2;
        super.onMeasure(i2, i4);
        if (getMeasuredHeight() < max2) {
            setMeasuredDimension(getMeasuredWidthAndState(), max2);
        }
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.k3 : this.m3;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0012, code lost:
        if (r0 != 3) goto L_0x00b9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            android.view.VelocityTracker r0 = r6.t3
            r0.addMovement(r7)
            int r0 = r7.getActionMasked()
            r1 = 1
            if (r0 == 0) goto L_0x009f
            r2 = 2
            if (r0 == r1) goto L_0x008b
            if (r0 == r2) goto L_0x0016
            r3 = 3
            if (r0 == r3) goto L_0x008b
            goto L_0x00b9
        L_0x0016:
            int r0 = r6.p3
            if (r0 == r1) goto L_0x0057
            if (r0 == r2) goto L_0x001e
            goto L_0x00b9
        L_0x001e:
            float r7 = r7.getX()
            int r0 = r6.getThumbScrollRange()
            float r2 = r6.r3
            float r2 = r7 - r2
            r3 = 1065353216(0x3f800000, float:1.0)
            r4 = 0
            if (r0 == 0) goto L_0x0032
            float r0 = (float) r0
            float r2 = r2 / r0
            goto L_0x003d
        L_0x0032:
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x0039
            r2 = 1065353216(0x3f800000, float:1.0)
            goto L_0x003d
        L_0x0039:
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
        L_0x003d:
            boolean r0 = androidx.appcompat.widget.ViewUtils.b(r6)
            if (r0 == 0) goto L_0x0044
            float r2 = -r2
        L_0x0044:
            float r0 = r6.v3
            float r0 = r0 + r2
            float r0 = g(r0, r4, r3)
            float r2 = r6.v3
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x0056
            r6.r3 = r7
            r6.setThumbPosition(r0)
        L_0x0056:
            return r1
        L_0x0057:
            float r0 = r7.getX()
            float r3 = r7.getY()
            float r4 = r6.r3
            float r4 = r0 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.q3
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 > 0) goto L_0x007d
            float r4 = r6.s3
            float r4 = r3 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.q3
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L_0x00b9
        L_0x007d:
            r6.p3 = r2
            android.view.ViewParent r7 = r6.getParent()
            r7.requestDisallowInterceptTouchEvent(r1)
            r6.r3 = r0
            r6.s3 = r3
            return r1
        L_0x008b:
            int r0 = r6.p3
            if (r0 != r2) goto L_0x0096
            r6.r(r7)
            super.onTouchEvent(r7)
            return r1
        L_0x0096:
            r0 = 0
            r6.p3 = r0
            android.view.VelocityTracker r0 = r6.t3
            r0.clear()
            goto L_0x00b9
        L_0x009f:
            float r0 = r7.getX()
            float r2 = r7.getY()
            boolean r3 = r6.isEnabled()
            if (r3 == 0) goto L_0x00b9
            boolean r3 = r6.i(r0, r2)
            if (r3 == 0) goto L_0x00b9
            r6.p3 = r1
            r6.r3 = r0
            r6.s3 = r2
        L_0x00b9:
            boolean r7 = super.onTouchEvent(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SwitchCompat.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().d(z);
    }

    public void setChecked(boolean z) {
        super.setChecked(z);
        boolean isChecked = isChecked();
        if (isChecked) {
            m();
        } else {
            l();
        }
        if (getWindowToken() == null || !isLaidOut()) {
            e();
            setThumbPosition(isChecked ? 1.0f : 0.0f);
            return;
        }
        a(isChecked);
    }

    public void setCustomSelectionActionModeCallback(@Nullable ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.G(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z) {
        getEmojiTextViewHelper().e(z);
        setTextOnInternal(this.k3);
        setTextOffInternal(this.m3);
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public final void setEnforceSwitchWidth(boolean z) {
        this.D3 = z;
        invalidate();
    }

    public void setFilters(@NonNull InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setShowText(boolean z) {
        if (this.o3 != z) {
            this.o3 = z;
            requestLayout();
            if (z) {
                q();
            }
        }
    }

    public void setSplitTrack(boolean z) {
        this.j3 = z;
        invalidate();
    }

    public void setSwitchMinWidth(int i2) {
        this.h3 = i2;
        requestLayout();
    }

    public void setSwitchPadding(int i2) {
        this.i3 = i2;
        requestLayout();
    }

    public void setSwitchTypeface(Typeface typeface) {
        if ((this.E3.getTypeface() != null && !this.E3.getTypeface().equals(typeface)) || (this.E3.getTypeface() == null && typeface != null)) {
            this.E3.setTypeface(typeface);
            requestLayout();
            invalidate();
        }
    }

    public void setTextOff(CharSequence charSequence) {
        setTextOffInternal(charSequence);
        requestLayout();
        if (!isChecked()) {
            l();
        }
    }

    public void setTextOn(CharSequence charSequence) {
        setTextOnInternal(charSequence);
        requestLayout();
        if (isChecked()) {
            m();
        }
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.s;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.s = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public void setThumbPosition(float f2) {
        this.v3 = f2;
        invalidate();
    }

    public void setThumbResource(int i2) {
        setThumbDrawable(AppCompatResources.b(getContext(), i2));
    }

    public void setThumbTextPadding(int i2) {
        this.g3 = i2;
        requestLayout();
    }

    public void setThumbTintList(@Nullable ColorStateList colorStateList) {
        this.X2 = colorStateList;
        this.Z2 = true;
        c();
    }

    public void setThumbTintMode(@Nullable PorterDuff.Mode mode) {
        this.Y2 = mode;
        this.a3 = true;
        c();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.b3;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.b3 = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i2) {
        setTrackDrawable(AppCompatResources.b(getContext(), i2));
    }

    public void setTrackTintList(@Nullable ColorStateList colorStateList) {
        this.c3 = colorStateList;
        this.e3 = true;
        d();
    }

    public void setTrackTintMode(@Nullable PorterDuff.Mode mode) {
        this.d3 = mode;
        this.f3 = true;
        d();
    }

    public void toggle() {
        setChecked(!isChecked());
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(@NonNull Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.s || drawable == this.b3;
    }

    public SwitchCompat(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.l3);
    }

    public SwitchCompat(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.X2 = null;
        this.Y2 = null;
        this.Z2 = false;
        this.a3 = false;
        this.c3 = null;
        this.d3 = null;
        this.e3 = false;
        this.f3 = false;
        this.t3 = VelocityTracker.obtain();
        this.D3 = true;
        this.N3 = new Rect();
        ThemeUtils.a(this, getContext());
        TextPaint textPaint = new TextPaint(1);
        this.E3 = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        int[] iArr = R.styleable.L5;
        TintTypedArray G = TintTypedArray.G(context, attributeSet, iArr, i2, 0);
        ViewCompat.F1(this, context, iArr, attributeSet, G.B(), i2, 0);
        Drawable h2 = G.h(R.styleable.O5);
        this.s = h2;
        if (h2 != null) {
            h2.setCallback(this);
        }
        Drawable h4 = G.h(R.styleable.X5);
        this.b3 = h4;
        if (h4 != null) {
            h4.setCallback(this);
        }
        setTextOnInternal(G.x(R.styleable.M5));
        setTextOffInternal(G.x(R.styleable.N5));
        this.o3 = G.a(R.styleable.P5, true);
        this.g3 = G.g(R.styleable.U5, 0);
        this.h3 = G.g(R.styleable.R5, 0);
        this.i3 = G.g(R.styleable.S5, 0);
        this.j3 = G.a(R.styleable.Q5, false);
        ColorStateList d2 = G.d(R.styleable.V5);
        if (d2 != null) {
            this.X2 = d2;
            this.Z2 = true;
        }
        PorterDuff.Mode e2 = DrawableUtils.e(G.o(R.styleable.W5, -1), (PorterDuff.Mode) null);
        if (this.Y2 != e2) {
            this.Y2 = e2;
            this.a3 = true;
        }
        if (this.Z2 || this.a3) {
            c();
        }
        ColorStateList d4 = G.d(R.styleable.Y5);
        if (d4 != null) {
            this.c3 = d4;
            this.e3 = true;
        }
        PorterDuff.Mode e4 = DrawableUtils.e(G.o(R.styleable.Z5, -1), (PorterDuff.Mode) null);
        if (this.d3 != e4) {
            this.d3 = e4;
            this.f3 = true;
        }
        if (this.e3 || this.f3) {
            d();
        }
        int u = G.u(R.styleable.T5, 0);
        if (u != 0) {
            n(context, u);
        }
        AppCompatTextHelper appCompatTextHelper = new AppCompatTextHelper(this);
        this.K3 = appCompatTextHelper;
        appCompatTextHelper.m(attributeSet, i2);
        G.I();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.q3 = viewConfiguration.getScaledTouchSlop();
        this.u3 = viewConfiguration.getScaledMinimumFlingVelocity();
        getEmojiTextViewHelper().c(attributeSet, i2);
        refreshDrawableState();
        setChecked(isChecked());
    }
}
