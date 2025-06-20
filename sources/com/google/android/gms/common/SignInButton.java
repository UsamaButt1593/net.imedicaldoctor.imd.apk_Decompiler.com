package com.google.android.gms.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.base.R;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zaaa;
import com.google.android.gms.common.internal.zaz;
import com.google.android.gms.dynamic.RemoteCreator;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class SignInButton extends FrameLayout implements View.OnClickListener {
    public static final int a3 = 0;
    public static final int b3 = 1;
    public static final int c3 = 2;
    public static final int d3 = 0;
    public static final int e3 = 1;
    public static final int f3 = 2;
    private int X2;
    private View Y2;
    @Nullable
    private View.OnClickListener Z2;
    private int s;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ButtonSize {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ColorScheme {
    }

    public SignInButton(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private final void c(Context context) {
        View view = this.Y2;
        if (view != null) {
            removeView(view);
        }
        try {
            this.Y2 = zaz.c(context, this.s, this.X2);
        } catch (RemoteCreator.RemoteCreatorException unused) {
            Log.w("SignInButton", "Sign in button not found, using placeholder instead");
            int i2 = this.s;
            int i3 = this.X2;
            zaaa zaaa = new zaaa(context, (AttributeSet) null);
            zaaa.a(context.getResources(), i2, i3);
            this.Y2 = zaaa;
        }
        addView(this.Y2);
        this.Y2.setEnabled(isEnabled());
        this.Y2.setOnClickListener(this);
    }

    public void a(int i2, int i3) {
        this.s = i2;
        this.X2 = i3;
        c(getContext());
    }

    @Deprecated
    public void b(int i2, int i3, @NonNull Scope[] scopeArr) {
        a(i2, i3);
    }

    public void onClick(@NonNull View view) {
        View.OnClickListener onClickListener = this.Z2;
        if (onClickListener != null && view == this.Y2) {
            onClickListener.onClick(this);
        }
    }

    public void setColorScheme(int i2) {
        a(this.s, i2);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.Y2.setEnabled(z);
    }

    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.Z2 = onClickListener;
        View view = this.Y2;
        if (view != null) {
            view.setOnClickListener(this);
        }
    }

    @Deprecated
    public void setScopes(@NonNull Scope[] scopeArr) {
        a(this.s, this.X2);
    }

    public void setSize(int i2) {
        a(i2, this.X2);
    }

    public SignInButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: finally extract failed */
    public SignInButton(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.Z2 = null;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.f19796e, 0, 0);
        try {
            this.s = obtainStyledAttributes.getInt(R.styleable.f19797f, 0);
            this.X2 = obtainStyledAttributes.getInt(R.styleable.f19798g, 2);
            obtainStyledAttributes.recycle();
            a(this.s, this.X2);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }
}
