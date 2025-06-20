package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.transition.Transition;
import androidx.transition.TransitionUtils;
import java.util.Map;

public class ChangeImageTransform extends Transition {
    private static final String V3 = "android:changeImageTransform:matrix";
    private static final String W3 = "android:changeImageTransform:bounds";
    private static final String[] X3 = {V3, W3};
    private static final TypeEvaluator<Matrix> Y3 = new TypeEvaluator<Matrix>() {
        /* renamed from: a */
        public Matrix evaluate(float f2, Matrix matrix, Matrix matrix2) {
            return null;
        }
    };
    private static final Property<ImageView, Matrix> Z3 = new Property<ImageView, Matrix>(Matrix.class, "animatedTransform") {
        /* renamed from: a */
        public Matrix get(ImageView imageView) {
            return null;
        }

        /* renamed from: b */
        public void set(ImageView imageView, Matrix matrix) {
            ImageViewUtils.a(imageView, matrix);
        }
    };

    /* renamed from: androidx.transition.ChangeImageTransform$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f15979a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                android.widget.ImageView$ScaleType[] r0 = android.widget.ImageView.ScaleType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f15979a = r0
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_XY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f15979a     // Catch:{ NoSuchFieldError -> 0x001d }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.transition.ChangeImageTransform.AnonymousClass3.<clinit>():void");
        }
    }

    private static class Listener extends AnimatorListenerAdapter implements Transition.TransitionListener {
        private final Matrix X;
        private final Matrix Y;
        private boolean Z = true;
        private final ImageView s;

        Listener(ImageView imageView, Matrix matrix, Matrix matrix2) {
            this.s = imageView;
            this.X = matrix;
            this.Y = matrix2;
        }

        private void a() {
            ImageView imageView = this.s;
            int i2 = R.id.f16019h;
            Matrix matrix = (Matrix) imageView.getTag(i2);
            if (matrix != null) {
                ImageViewUtils.a(this.s, matrix);
                this.s.setTag(i2, (Object) null);
            }
        }

        private void c(Matrix matrix) {
            this.s.setTag(R.id.f16019h, matrix);
            ImageViewUtils.a(this.s, this.Y);
        }

        public void b(@NonNull Transition transition) {
        }

        public void f(@NonNull Transition transition) {
            if (this.Z) {
                c(this.X);
            }
        }

        public /* synthetic */ void h(Transition transition, boolean z) {
            e.a(this, transition, z);
        }

        public void k(@NonNull Transition transition) {
        }

        public void onAnimationEnd(Animator animator) {
            this.Z = false;
        }

        public void onAnimationPause(Animator animator) {
            c((Matrix) ((ObjectAnimator) animator).getAnimatedValue());
        }

        public void onAnimationResume(Animator animator) {
            a();
        }

        public void onAnimationStart(Animator animator) {
            this.Z = false;
        }

        public void p(@NonNull Transition transition) {
        }

        public /* synthetic */ void q(Transition transition, boolean z) {
            e.b(this, transition, z);
        }

        public void s(@NonNull Transition transition) {
            a();
        }

        public void onAnimationEnd(@NonNull Animator animator, boolean z) {
            this.Z = z;
        }

        public void onAnimationStart(@NonNull Animator animator, boolean z) {
            this.Z = false;
        }
    }

    public ChangeImageTransform() {
    }

    private void C1(TransitionValues transitionValues, boolean z) {
        View view = transitionValues.f16095b;
        if ((view instanceof ImageView) && view.getVisibility() == 0) {
            ImageView imageView = (ImageView) view;
            if (imageView.getDrawable() != null) {
                Map<String, Object> map = transitionValues.f16094a;
                map.put(W3, new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
                Matrix matrix = z ? (Matrix) imageView.getTag(R.id.f16019h) : null;
                if (matrix == null) {
                    matrix = F1(imageView);
                }
                map.put(V3, matrix);
            }
        }
    }

    private static Matrix D1(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        float width = (float) imageView.getWidth();
        float f2 = (float) intrinsicWidth;
        int intrinsicHeight = drawable.getIntrinsicHeight();
        float height = (float) imageView.getHeight();
        float f3 = (float) intrinsicHeight;
        float max = Math.max(width / f2, height / f3);
        int round = Math.round((width - (f2 * max)) / 2.0f);
        int round2 = Math.round((height - (f3 * max)) / 2.0f);
        Matrix matrix = new Matrix();
        matrix.postScale(max, max);
        matrix.postTranslate((float) round, (float) round2);
        return matrix;
    }

    @NonNull
    private static Matrix F1(@NonNull ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        if (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            return new Matrix(imageView.getImageMatrix());
        }
        int i2 = AnonymousClass3.f15979a[imageView.getScaleType().ordinal()];
        if (i2 != 1) {
            return i2 != 2 ? new Matrix(imageView.getImageMatrix()) : D1(imageView);
        }
        return R1(imageView);
    }

    private ObjectAnimator H1(ImageView imageView, Matrix matrix, Matrix matrix2) {
        return ObjectAnimator.ofObject(imageView, Z3, new TransitionUtils.MatrixEvaluator(), new Matrix[]{matrix, matrix2});
    }

    @NonNull
    private ObjectAnimator O1(@NonNull ImageView imageView) {
        Property<ImageView, Matrix> property = Z3;
        TypeEvaluator<Matrix> typeEvaluator = Y3;
        Matrix matrix = MatrixUtils.f16002a;
        return ObjectAnimator.ofObject(imageView, property, typeEvaluator, new Matrix[]{matrix, matrix});
    }

    private static Matrix R1(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        Matrix matrix = new Matrix();
        matrix.postScale(((float) imageView.getWidth()) / ((float) drawable.getIntrinsicWidth()), ((float) imageView.getHeight()) / ((float) drawable.getIntrinsicHeight()));
        return matrix;
    }

    public void n(@NonNull TransitionValues transitionValues) {
        C1(transitionValues, false);
    }

    public void q(@NonNull TransitionValues transitionValues) {
        C1(transitionValues, true);
    }

    @NonNull
    public String[] r0() {
        return X3;
    }

    @Nullable
    public Animator u(@NonNull ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        if (!(transitionValues == null || transitionValues2 == null)) {
            Rect rect = (Rect) transitionValues.f16094a.get(W3);
            Rect rect2 = (Rect) transitionValues2.f16094a.get(W3);
            if (!(rect == null || rect2 == null)) {
                Matrix matrix = (Matrix) transitionValues.f16094a.get(V3);
                Matrix matrix2 = (Matrix) transitionValues2.f16094a.get(V3);
                boolean z = (matrix == null && matrix2 == null) || (matrix != null && matrix.equals(matrix2));
                if (rect.equals(rect2) && z) {
                    return null;
                }
                ImageView imageView = (ImageView) transitionValues2.f16095b;
                Drawable drawable = imageView.getDrawable();
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
                    return O1(imageView);
                }
                if (matrix == null) {
                    matrix = MatrixUtils.f16002a;
                }
                if (matrix2 == null) {
                    matrix2 = MatrixUtils.f16002a;
                }
                Z3.set(imageView, matrix);
                ObjectAnimator H1 = H1(imageView, matrix, matrix2);
                Listener listener = new Listener(imageView, matrix, matrix2);
                H1.addListener(listener);
                H1.addPauseListener(listener);
                c(listener);
                return H1;
            }
        }
        return null;
    }

    public boolean u0() {
        return true;
    }

    public ChangeImageTransform(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
