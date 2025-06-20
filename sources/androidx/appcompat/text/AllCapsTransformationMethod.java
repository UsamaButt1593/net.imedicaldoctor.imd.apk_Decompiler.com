package androidx.appcompat.text;

import android.content.Context;
import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import androidx.annotation.RestrictTo;
import java.util.Locale;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class AllCapsTransformationMethod implements TransformationMethod {

    /* renamed from: a  reason: collision with root package name */
    private Locale f2904a;

    public AllCapsTransformationMethod(Context context) {
        this.f2904a = context.getResources().getConfiguration().locale;
    }

    public CharSequence getTransformation(CharSequence charSequence, View view) {
        if (charSequence != null) {
            return charSequence.toString().toUpperCase(this.f2904a);
        }
        return null;
    }

    public void onFocusChanged(View view, CharSequence charSequence, boolean z, int i2, Rect rect) {
    }
}
