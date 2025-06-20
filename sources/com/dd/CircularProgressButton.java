package com.dd;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.StateSet;
import android.view.View;
import android.widget.Button;
import com.dd.circular.progress.button.R;

public class CircularProgressButton extends Button {
    public static final int D3 = 0;
    public static final int E3 = -1;
    public static final int F3 = 100;
    public static final int G3 = 50;
    private final OnAnimationEndListener A3 = new OnAnimationEndListener() {
        public void a() {
            if (CircularProgressButton.this.o3 != 0) {
                CircularProgressButton.this.setText((CharSequence) null);
                CircularProgressButton circularProgressButton = CircularProgressButton.this;
                circularProgressButton.setIcon(circularProgressButton.o3);
            } else {
                CircularProgressButton circularProgressButton2 = CircularProgressButton.this;
                circularProgressButton2.setText(circularProgressButton2.i3);
            }
            CircularProgressButton.this.y3 = false;
            CircularProgressButton.this.g3 = State.COMPLETE;
            CircularProgressButton.this.f3.a(CircularProgressButton.this);
        }
    };
    private final OnAnimationEndListener B3 = new OnAnimationEndListener() {
        public void a() {
            CircularProgressButton.this.J();
            CircularProgressButton circularProgressButton = CircularProgressButton.this;
            circularProgressButton.setText(circularProgressButton.h3);
            CircularProgressButton.this.y3 = false;
            CircularProgressButton.this.g3 = State.IDLE;
            CircularProgressButton.this.f3.a(CircularProgressButton.this);
        }
    };
    private final OnAnimationEndListener C3 = new OnAnimationEndListener() {
        public void a() {
            if (CircularProgressButton.this.p3 != 0) {
                CircularProgressButton.this.setText((CharSequence) null);
                CircularProgressButton circularProgressButton = CircularProgressButton.this;
                circularProgressButton.setIcon(circularProgressButton.p3);
            } else {
                CircularProgressButton circularProgressButton2 = CircularProgressButton.this;
                circularProgressButton2.setText(circularProgressButton2.j3);
            }
            CircularProgressButton.this.y3 = false;
            CircularProgressButton.this.g3 = State.ERROR;
            CircularProgressButton.this.f3.a(CircularProgressButton.this);
        }
    };
    private CircularAnimatedDrawable X2;
    private CircularProgressDrawable Y2;
    private ColorStateList Z2;
    private ColorStateList a3;
    private ColorStateList b3;
    private StateListDrawable c3;
    private StateListDrawable d3;
    private StateListDrawable e3;
    /* access modifiers changed from: private */
    public StateManager f3;
    /* access modifiers changed from: private */
    public State g3;
    /* access modifiers changed from: private */
    public CharSequence h3;
    /* access modifiers changed from: private */
    public CharSequence i3;
    /* access modifiers changed from: private */
    public CharSequence j3;
    private CharSequence k3;
    private int l3;
    private int m3;
    private int n3;
    /* access modifiers changed from: private */
    public int o3;
    /* access modifiers changed from: private */
    public int p3;
    private int q3;
    private int r3;
    private StrokeGradientDrawable s;
    private float s3;
    private boolean t3;
    private boolean u3;
    private final Runnable v3 = new Runnable() {
        public void run() {
            CircularProgressButton circularProgressButton = CircularProgressButton.this;
            circularProgressButton.setProgress(circularProgressButton.x3);
        }
    };
    private int w3;
    /* access modifiers changed from: private */
    public int x3;
    /* access modifiers changed from: private */
    public boolean y3;
    private final OnAnimationEndListener z3 = new OnAnimationEndListener() {
        public void a() {
            CircularProgressButton.this.y3 = false;
            CircularProgressButton.this.g3 = State.PROGRESS;
            CircularProgressButton.this.f3.a(CircularProgressButton.this);
        }
    };

    private enum State {
        PROGRESS,
        IDLE,
        COMPLETE,
        ERROR
    }

    public CircularProgressButton(Context context) {
        super(context);
        v(context, (AttributeSet) null);
    }

    private void B() {
        MorphingAnimation l2 = l();
        l2.g(s(this.a3));
        l2.m(s(this.Z2));
        l2.i(s(this.a3));
        l2.o(s(this.Z2));
        l2.k(this.B3);
        l2.q();
    }

    private void C() {
        MorphingAnimation l2 = l();
        l2.g(s(this.b3));
        l2.m(s(this.Z2));
        l2.i(s(this.b3));
        l2.o(s(this.Z2));
        l2.k(this.B3);
        l2.q();
    }

    private void D() {
        MorphingAnimation l2 = l();
        l2.g(s(this.Z2));
        l2.m(s(this.a3));
        l2.i(s(this.Z2));
        l2.o(s(this.a3));
        l2.k(this.A3);
        l2.q();
    }

    private void E() {
        MorphingAnimation l2 = l();
        l2.g(s(this.Z2));
        l2.m(s(this.b3));
        l2.i(s(this.Z2));
        l2.o(s(this.b3));
        l2.k(this.C3);
        l2.q();
    }

    private void F() {
        MorphingAnimation m2 = m((float) getHeight(), this.s3, getHeight(), getWidth());
        m2.g(this.l3);
        m2.m(s(this.a3));
        m2.i(this.m3);
        m2.o(s(this.a3));
        m2.k(this.A3);
        m2.q();
    }

    private void G() {
        MorphingAnimation m2 = m((float) getHeight(), this.s3, getHeight(), getWidth());
        m2.g(this.l3);
        m2.m(s(this.b3));
        m2.i(this.m3);
        m2.o(s(this.b3));
        m2.k(this.C3);
        m2.q();
    }

    private void H() {
        MorphingAnimation m2 = m((float) getHeight(), this.s3, getHeight(), getWidth());
        m2.g(this.l3);
        m2.m(s(this.Z2));
        m2.i(this.m3);
        m2.o(s(this.Z2));
        m2.k(new OnAnimationEndListener() {
            public void a() {
                CircularProgressButton.this.J();
                CircularProgressButton circularProgressButton = CircularProgressButton.this;
                circularProgressButton.setText(circularProgressButton.h3);
                CircularProgressButton.this.y3 = false;
                CircularProgressButton.this.g3 = State.IDLE;
                CircularProgressButton.this.f3.a(CircularProgressButton.this);
            }
        });
        m2.q();
    }

    private void I() {
        setWidth(getWidth());
        setText(this.k3);
        MorphingAnimation m2 = m(this.s3, (float) getHeight(), getWidth(), getHeight());
        m2.g(s(this.Z2));
        m2.m(this.l3);
        m2.i(s(this.Z2));
        m2.o(this.n3);
        m2.k(this.z3);
        m2.q();
    }

    private StrokeGradientDrawable k(int i2) {
        GradientDrawable gradientDrawable = (GradientDrawable) getResources().getDrawable(R.drawable.f18620a).mutate();
        gradientDrawable.setColor(i2);
        gradientDrawable.setCornerRadius(this.s3);
        StrokeGradientDrawable strokeGradientDrawable = new StrokeGradientDrawable(gradientDrawable);
        strokeGradientDrawable.d(i2);
        strokeGradientDrawable.e(this.q3);
        return strokeGradientDrawable;
    }

    private MorphingAnimation l() {
        int i2 = 1;
        this.y3 = true;
        MorphingAnimation morphingAnimation = new MorphingAnimation(this, this.s);
        morphingAnimation.h(this.s3);
        morphingAnimation.n(this.s3);
        morphingAnimation.j(getWidth());
        morphingAnimation.p(getWidth());
        if (!this.u3) {
            i2 = 400;
        }
        morphingAnimation.f(i2);
        this.u3 = false;
        return morphingAnimation;
    }

    private MorphingAnimation m(float f2, float f4, int i2, int i4) {
        this.y3 = true;
        MorphingAnimation morphingAnimation = new MorphingAnimation(this, this.s);
        morphingAnimation.h(f2);
        morphingAnimation.n(f4);
        morphingAnimation.l((float) this.r3);
        morphingAnimation.j(i2);
        morphingAnimation.p(i4);
        if (this.u3) {
            morphingAnimation.f(1);
        } else {
            morphingAnimation.f(400);
        }
        this.u3 = false;
        return morphingAnimation;
    }

    private void n(Canvas canvas) {
        CircularAnimatedDrawable circularAnimatedDrawable = this.X2;
        if (circularAnimatedDrawable == null) {
            int width = (getWidth() - getHeight()) / 2;
            this.X2 = new CircularAnimatedDrawable(this.m3, (float) this.q3);
            int i2 = this.r3 + width;
            int width2 = (getWidth() - width) - this.r3;
            int height = getHeight();
            int i4 = this.r3;
            this.X2.setBounds(i2, i4, width2, height - i4);
            this.X2.setCallback(this);
            this.X2.start();
            return;
        }
        circularAnimatedDrawable.draw(canvas);
    }

    private void o(Canvas canvas) {
        if (this.Y2 == null) {
            CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(getHeight() - (this.r3 * 2), this.q3, this.m3);
            this.Y2 = circularProgressDrawable;
            int i2 = this.r3;
            int width = ((getWidth() - getHeight()) / 2) + i2;
            circularProgressDrawable.setBounds(width, i2, width, i2);
        }
        this.Y2.d((360.0f / ((float) this.w3)) * ((float) this.x3));
        this.Y2.draw(canvas);
    }

    private int q(ColorStateList colorStateList) {
        return colorStateList.getColorForState(new int[]{-16842910}, 0);
    }

    private int r(ColorStateList colorStateList) {
        return colorStateList.getColorForState(new int[]{16842908}, 0);
    }

    private int s(ColorStateList colorStateList) {
        return colorStateList.getColorForState(new int[]{16842910}, 0);
    }

    /* access modifiers changed from: private */
    public void setIcon(int i2) {
        Drawable drawable = getResources().getDrawable(i2);
        if (drawable != null) {
            setCompoundDrawablesWithIntrinsicBounds(i2, 0, 0, 0);
            setPadding((getWidth() / 2) - (drawable.getIntrinsicWidth() / 2), 0, 0, 0);
        }
    }

    private int t(ColorStateList colorStateList) {
        return colorStateList.getColorForState(new int[]{16842919}, 0);
    }

    private void v(Context context, AttributeSet attributeSet) {
        if (!isInEditMode()) {
            this.q3 = (int) getContext().getResources().getDimension(R.dimen.f18619a);
            w(context, attributeSet);
            this.w3 = 100;
            this.g3 = State.IDLE;
            this.f3 = new StateManager(this);
            setText(this.h3);
            z();
            setBackgroundCompat(this.c3);
        }
    }

    private void w(Context context, AttributeSet attributeSet) {
        TypedArray u = u(context, attributeSet, R.styleable.f18631a);
        if (u != null) {
            try {
                this.h3 = u.getString(R.styleable.f18644n);
                this.i3 = u.getString(R.styleable.f18642l);
                this.j3 = u.getString(R.styleable.f18643m);
                this.k3 = u.getString(R.styleable.o);
                this.o3 = u.getResourceId(R.styleable.f18636f, 0);
                this.p3 = u.getResourceId(R.styleable.f18637g, 0);
                this.s3 = u.getDimension(R.styleable.f18635e, 0.0f);
                this.r3 = u.getDimensionPixelSize(R.styleable.f18638h, 0);
                int p = p(R.color.f18608a);
                int p2 = p(R.color.f18618k);
                int p4 = p(R.color.f18614g);
                this.Z2 = getResources().getColorStateList(u.getResourceId(R.styleable.f18641k, R.color.f18615h));
                this.a3 = getResources().getColorStateList(u.getResourceId(R.styleable.f18639i, R.color.f18610c));
                this.b3 = getResources().getColorStateList(u.getResourceId(R.styleable.f18640j, R.color.f18611d));
                this.l3 = u.getColor(R.styleable.f18634d, p2);
                this.m3 = u.getColor(R.styleable.f18632b, p);
                this.n3 = u.getColor(R.styleable.f18633c, p4);
            } finally {
                u.recycle();
            }
        }
    }

    private void x() {
        StrokeGradientDrawable k2 = k(t(this.a3));
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.d3 = stateListDrawable;
        stateListDrawable.addState(new int[]{16842919}, k2.a());
        this.d3.addState(StateSet.WILD_CARD, this.s.a());
    }

    private void y() {
        StrokeGradientDrawable k2 = k(t(this.b3));
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.e3 = stateListDrawable;
        stateListDrawable.addState(new int[]{16842919}, k2.a());
        this.e3.addState(StateSet.WILD_CARD, this.s.a());
    }

    private void z() {
        int s2 = s(this.Z2);
        int t = t(this.Z2);
        int r = r(this.Z2);
        int q = q(this.Z2);
        if (this.s == null) {
            this.s = k(s2);
        }
        StrokeGradientDrawable k2 = k(q);
        StrokeGradientDrawable k4 = k(r);
        StrokeGradientDrawable k5 = k(t);
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.c3 = stateListDrawable;
        stateListDrawable.addState(new int[]{16842919}, k5.a());
        this.c3.addState(new int[]{16842908}, k4.a());
        this.c3.addState(new int[]{-16842910}, k2.a());
        this.c3.addState(StateSet.WILD_CARD, this.s.a());
    }

    public boolean A() {
        return this.t3;
    }

    /* access modifiers changed from: protected */
    public void J() {
        setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        setPadding(0, 0, 0, 0);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void drawableStateChanged() {
        /*
            r2 = this;
            com.dd.CircularProgressButton$State r0 = r2.g3
            com.dd.CircularProgressButton$State r1 = com.dd.CircularProgressButton.State.COMPLETE
            if (r0 != r1) goto L_0x000f
            r2.x()
            android.graphics.drawable.StateListDrawable r0 = r2.d3
        L_0x000b:
            r2.setBackgroundCompat(r0)
            goto L_0x0023
        L_0x000f:
            com.dd.CircularProgressButton$State r1 = com.dd.CircularProgressButton.State.IDLE
            if (r0 != r1) goto L_0x0019
            r2.z()
            android.graphics.drawable.StateListDrawable r0 = r2.c3
            goto L_0x000b
        L_0x0019:
            com.dd.CircularProgressButton$State r1 = com.dd.CircularProgressButton.State.ERROR
            if (r0 != r1) goto L_0x0023
            r2.y()
            android.graphics.drawable.StateListDrawable r0 = r2.e3
            goto L_0x000b
        L_0x0023:
            com.dd.CircularProgressButton$State r0 = r2.g3
            com.dd.CircularProgressButton$State r1 = com.dd.CircularProgressButton.State.PROGRESS
            if (r0 == r1) goto L_0x002c
            super.drawableStateChanged()
        L_0x002c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dd.CircularProgressButton.drawableStateChanged():void");
    }

    public CharSequence getCompleteText() {
        return this.i3;
    }

    public CharSequence getErrorText() {
        return this.j3;
    }

    public CharSequence getIdleText() {
        return this.h3;
    }

    public int getProgress() {
        return this.x3;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.x3 > 0 && this.g3 == State.PROGRESS && !this.y3) {
            if (this.t3) {
                n(canvas);
            } else {
                o(canvas);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i4, int i5, int i6) {
        super.onLayout(z, i2, i4, i5, i6);
        if (this.u3) {
            post(this.v3);
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.x3 = savedState.Y;
            this.t3 = savedState.s;
            this.u3 = savedState.X;
            parcelable = savedState.getSuperState();
        }
        super.onRestoreInstanceState(parcelable);
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Y = this.x3;
        savedState.s = this.t3;
        savedState.X = true;
        return savedState;
    }

    /* access modifiers changed from: protected */
    public int p(int i2) {
        return getResources().getColor(i2);
    }

    public void setBackgroundColor(int i2) {
        this.s.a().setColor(i2);
    }

    @SuppressLint({"NewApi"})
    public void setBackgroundCompat(Drawable drawable) {
        setBackground(drawable);
    }

    public void setCompleteText(CharSequence charSequence) {
        this.i3 = charSequence;
    }

    public void setErrorText(CharSequence charSequence) {
        this.j3 = charSequence;
    }

    public void setIdleText(CharSequence charSequence) {
        this.h3 = charSequence;
    }

    public void setIndeterminateProgressMode(boolean z) {
        this.t3 = z;
    }

    public void setProgress(int i2) {
        this.x3 = i2;
        if (!this.y3 && getWidth() != 0 && !isInEditMode()) {
            this.f3.d(this);
            int i4 = this.x3;
            if (i4 >= this.w3) {
                State state = this.g3;
                if (state == State.PROGRESS) {
                    F();
                } else if (state == State.IDLE) {
                    D();
                }
            } else if (i4 > 0) {
                State state2 = this.g3;
                if (state2 == State.IDLE) {
                    I();
                } else if (state2 == State.PROGRESS) {
                    invalidate();
                }
            } else if (i4 == -1) {
                State state3 = this.g3;
                if (state3 == State.PROGRESS) {
                    G();
                } else if (state3 == State.IDLE) {
                    E();
                }
            } else if (i4 == 0) {
                State state4 = this.g3;
                if (state4 == State.COMPLETE) {
                    B();
                } else if (state4 == State.PROGRESS) {
                    H();
                } else if (state4 == State.ERROR) {
                    C();
                }
            }
        }
    }

    public void setStrokeColor(int i2) {
        this.s.d(i2);
    }

    /* access modifiers changed from: protected */
    public TypedArray u(Context context, AttributeSet attributeSet, int[] iArr) {
        return context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return drawable == this.X2 || super.verifyDrawable(drawable);
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: b */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        };
        /* access modifiers changed from: private */
        public boolean X;
        /* access modifiers changed from: private */
        public int Y;
        /* access modifiers changed from: private */
        public boolean s;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.Y = parcel.readInt();
            boolean z = false;
            this.s = parcel.readInt() == 1;
            this.X = parcel.readInt() == 1 ? true : z;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.Y);
            parcel.writeInt(this.s ? 1 : 0);
            parcel.writeInt(this.X ? 1 : 0);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public CircularProgressButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        v(context, attributeSet);
    }

    public CircularProgressButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        v(context, attributeSet);
    }
}
