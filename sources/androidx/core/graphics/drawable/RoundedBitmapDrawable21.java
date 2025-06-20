package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.Rect;
import android.view.Gravity;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
class RoundedBitmapDrawable21 extends RoundedBitmapDrawable {
    protected RoundedBitmapDrawable21(Resources resources, Bitmap bitmap) {
        super(resources, bitmap);
    }

    /* access modifiers changed from: package-private */
    public void f(int i2, int i3, int i4, Rect rect, Rect rect2) {
        Gravity.apply(i2, i3, i4, rect, rect2, 0);
    }

    public void getOutline(@NonNull Outline outline) {
        t();
        outline.setRoundRect(this.f5920h, c());
    }

    public boolean h() {
        Bitmap bitmap = this.f5913a;
        return bitmap != null && bitmap.hasMipMap();
    }

    public void o(boolean z) {
        Bitmap bitmap = this.f5913a;
        if (bitmap != null) {
            bitmap.setHasMipMap(z);
            invalidateSelf();
        }
    }
}
