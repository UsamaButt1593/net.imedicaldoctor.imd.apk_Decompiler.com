package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R;
import androidx.emoji2.viewsintegration.EmojiTextViewHelper;

class AppCompatEmojiTextHelper {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final TextView f3093a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final EmojiTextViewHelper f3094b;

    AppCompatEmojiTextHelper(@NonNull TextView textView) {
        this.f3093a = textView;
        this.f3094b = new EmojiTextViewHelper(textView, false);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public InputFilter[] a(@NonNull InputFilter[] inputFilterArr) {
        return this.f3094b.a(inputFilterArr);
    }

    public boolean b() {
        return this.f3094b.b();
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public void c(@Nullable AttributeSet attributeSet, int i2) {
        TypedArray obtainStyledAttributes = this.f3093a.getContext().obtainStyledAttributes(attributeSet, R.styleable.v0, i2, 0);
        try {
            int i3 = R.styleable.K0;
            boolean z = true;
            if (obtainStyledAttributes.hasValue(i3)) {
                z = obtainStyledAttributes.getBoolean(i3, true);
            }
            obtainStyledAttributes.recycle();
            e(z);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public void d(boolean z) {
        this.f3094b.c(z);
    }

    /* access modifiers changed from: package-private */
    public void e(boolean z) {
        this.f3094b.d(z);
    }

    @Nullable
    public TransformationMethod f(@Nullable TransformationMethod transformationMethod) {
        return this.f3094b.f(transformationMethod);
    }
}
