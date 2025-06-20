package androidx.emoji2.viewsintegration;

import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.emoji2.text.EmojiCompat;

@RequiresApi(19)
@RestrictTo({RestrictTo.Scope.LIBRARY})
class EmojiTransformationMethod implements TransformationMethod {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final TransformationMethod f7805a;

    EmojiTransformationMethod(@Nullable TransformationMethod transformationMethod) {
        this.f7805a = transformationMethod;
    }

    public TransformationMethod a() {
        return this.f7805a;
    }

    public CharSequence getTransformation(@Nullable CharSequence charSequence, @NonNull View view) {
        if (view.isInEditMode()) {
            return charSequence;
        }
        TransformationMethod transformationMethod = this.f7805a;
        if (transformationMethod != null) {
            charSequence = transformationMethod.getTransformation(charSequence, view);
        }
        return (charSequence == null || EmojiCompat.c().i() != 1) ? charSequence : EmojiCompat.c().x(charSequence);
    }

    public void onFocusChanged(View view, CharSequence charSequence, boolean z, int i2, Rect rect) {
        TransformationMethod transformationMethod = this.f7805a;
        if (transformationMethod != null) {
            transformationMethod.onFocusChanged(view, charSequence, z, i2, rect);
        }
    }
}
