package androidx.vectordrawable.graphics.drawable;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

public interface Animatable2Compat extends Animatable {

    public static abstract class AnimationCallback {

        /* renamed from: a  reason: collision with root package name */
        Animatable2.AnimationCallback f16326a;

        /* access modifiers changed from: package-private */
        @RequiresApi(23)
        public Animatable2.AnimationCallback a() {
            if (this.f16326a == null) {
                this.f16326a = new Animatable2.AnimationCallback() {
                    public void onAnimationEnd(Drawable drawable) {
                        AnimationCallback.this.b(drawable);
                    }

                    public void onAnimationStart(Drawable drawable) {
                        AnimationCallback.this.c(drawable);
                    }
                };
            }
            return this.f16326a;
        }

        public void b(Drawable drawable) {
        }

        public void c(Drawable drawable) {
        }
    }

    void b(@NonNull AnimationCallback animationCallback);

    void c();

    boolean d(@NonNull AnimationCallback animationCallback);
}
