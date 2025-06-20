package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

class ActionBarBackgroundDrawable extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    final ActionBarContainer f2994a;

    @RequiresApi(21)
    private static class Api21Impl {
        private Api21Impl() {
        }

        public static void a(Drawable drawable, Outline outline) {
            drawable.getOutline(outline);
        }
    }

    public ActionBarBackgroundDrawable(ActionBarContainer actionBarContainer) {
        this.f2994a = actionBarContainer;
    }

    public void draw(@NonNull Canvas canvas) {
        ActionBarContainer actionBarContainer = this.f2994a;
        if (actionBarContainer.d3) {
            Drawable drawable = actionBarContainer.c3;
            if (drawable != null) {
                drawable.draw(canvas);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.a3;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        ActionBarContainer actionBarContainer2 = this.f2994a;
        Drawable drawable3 = actionBarContainer2.b3;
        if (drawable3 != null && actionBarContainer2.e3) {
            drawable3.draw(canvas);
        }
    }

    public int getOpacity() {
        return 0;
    }

    @RequiresApi(21)
    public void getOutline(@NonNull Outline outline) {
        Drawable drawable;
        ActionBarContainer actionBarContainer = this.f2994a;
        if (!actionBarContainer.d3) {
            drawable = actionBarContainer.a3;
            if (drawable == null) {
                return;
            }
        } else if (actionBarContainer.c3 != null) {
            drawable = actionBarContainer.a3;
        } else {
            return;
        }
        Api21Impl.a(drawable, outline);
    }

    public void setAlpha(int i2) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}
