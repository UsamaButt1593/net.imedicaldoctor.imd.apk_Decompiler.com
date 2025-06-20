package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.resources.TextAppearanceFontCallback;
import java.lang.ref.WeakReference;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class TextDrawableHelper {

    /* renamed from: a  reason: collision with root package name */
    private final TextPaint f21566a = new TextPaint(1);

    /* renamed from: b  reason: collision with root package name */
    private final TextAppearanceFontCallback f21567b = new TextAppearanceFontCallback() {
        public void a(int i2) {
            boolean unused = TextDrawableHelper.this.f21570e = true;
            TextDrawableDelegate textDrawableDelegate = (TextDrawableDelegate) TextDrawableHelper.this.f21571f.get();
            if (textDrawableDelegate != null) {
                textDrawableDelegate.a();
            }
        }

        public void b(@NonNull Typeface typeface, boolean z) {
            if (!z) {
                boolean unused = TextDrawableHelper.this.f21570e = true;
                TextDrawableDelegate textDrawableDelegate = (TextDrawableDelegate) TextDrawableHelper.this.f21571f.get();
                if (textDrawableDelegate != null) {
                    textDrawableDelegate.a();
                }
            }
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private float f21568c;

    /* renamed from: d  reason: collision with root package name */
    private float f21569d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f21570e = true;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public WeakReference<TextDrawableDelegate> f21571f = new WeakReference<>((Object) null);
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private TextAppearance f21572g;

    public interface TextDrawableDelegate {
        void a();

        @NonNull
        int[] getState();

        boolean onStateChange(int[] iArr);
    }

    public TextDrawableHelper(@Nullable TextDrawableDelegate textDrawableDelegate) {
        k(textDrawableDelegate);
    }

    private float c(@Nullable String str) {
        if (str == null) {
            return 0.0f;
        }
        return Math.abs(this.f21566a.getFontMetrics().ascent);
    }

    private float d(@Nullable CharSequence charSequence) {
        if (charSequence == null) {
            return 0.0f;
        }
        return this.f21566a.measureText(charSequence, 0, charSequence.length());
    }

    private void j(String str) {
        this.f21568c = d(str);
        this.f21569d = c(str);
        this.f21570e = false;
    }

    @Nullable
    public TextAppearance e() {
        return this.f21572g;
    }

    public float f(@Nullable String str) {
        if (!this.f21570e) {
            return this.f21569d;
        }
        j(str);
        return this.f21569d;
    }

    @NonNull
    public TextPaint g() {
        return this.f21566a;
    }

    public float h(String str) {
        if (!this.f21570e) {
            return this.f21568c;
        }
        j(str);
        return this.f21568c;
    }

    public boolean i() {
        return this.f21570e;
    }

    public void k(@Nullable TextDrawableDelegate textDrawableDelegate) {
        this.f21571f = new WeakReference<>(textDrawableDelegate);
    }

    public void l(@Nullable TextAppearance textAppearance, Context context) {
        if (this.f21572g != textAppearance) {
            this.f21572g = textAppearance;
            if (textAppearance != null) {
                textAppearance.o(context, this.f21566a, this.f21567b);
                TextDrawableDelegate textDrawableDelegate = this.f21571f.get();
                if (textDrawableDelegate != null) {
                    this.f21566a.drawableState = textDrawableDelegate.getState();
                }
                textAppearance.n(context, this.f21566a, this.f21567b);
                this.f21570e = true;
            }
            TextDrawableDelegate textDrawableDelegate2 = this.f21571f.get();
            if (textDrawableDelegate2 != null) {
                textDrawableDelegate2.a();
                textDrawableDelegate2.onStateChange(textDrawableDelegate2.getState());
            }
        }
    }

    public void m(boolean z) {
        this.f21570e = z;
    }

    public void n(boolean z) {
        this.f21570e = z;
    }

    public void o(Context context) {
        this.f21572g.n(context, this.f21566a, this.f21567b);
    }
}
