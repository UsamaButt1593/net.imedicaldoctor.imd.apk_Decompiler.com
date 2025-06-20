package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TypeEvaluator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

class TransitionUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final int f16089a = 1048576;

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f16090b = (Build.VERSION.SDK_INT >= 28);

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static Bitmap a(Picture picture) {
            return Bitmap.createBitmap(picture);
        }
    }

    static class MatrixEvaluator implements TypeEvaluator<Matrix> {

        /* renamed from: a  reason: collision with root package name */
        final float[] f16091a = new float[9];

        /* renamed from: b  reason: collision with root package name */
        final float[] f16092b = new float[9];

        /* renamed from: c  reason: collision with root package name */
        final Matrix f16093c = new Matrix();

        MatrixEvaluator() {
        }

        /* renamed from: a */
        public Matrix evaluate(float f2, Matrix matrix, Matrix matrix2) {
            matrix.getValues(this.f16091a);
            matrix2.getValues(this.f16092b);
            for (int i2 = 0; i2 < 9; i2++) {
                float[] fArr = this.f16092b;
                float f3 = fArr[i2];
                float f4 = this.f16091a[i2];
                fArr[i2] = f4 + ((f3 - f4) * f2);
            }
            this.f16093c.setValues(this.f16092b);
            return this.f16093c;
        }
    }

    private TransitionUtils() {
    }

    static View a(ViewGroup viewGroup, View view, View view2) {
        Matrix matrix = new Matrix();
        matrix.setTranslate((float) (-view2.getScrollX()), (float) (-view2.getScrollY()));
        ViewUtils.h(view, matrix);
        ViewUtils.i(viewGroup, matrix);
        RectF rectF = new RectF(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
        matrix.mapRect(rectF);
        int round = Math.round(rectF.left);
        int round2 = Math.round(rectF.top);
        int round3 = Math.round(rectF.right);
        int round4 = Math.round(rectF.bottom);
        ImageView imageView = new ImageView(view.getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Bitmap b2 = b(view, matrix, rectF, viewGroup);
        if (b2 != null) {
            imageView.setImageBitmap(b2);
        }
        imageView.measure(View.MeasureSpec.makeMeasureSpec(round3 - round, 1073741824), View.MeasureSpec.makeMeasureSpec(round4 - round2, 1073741824));
        imageView.layout(round, round2, round3, round4);
        return imageView;
    }

    private static Bitmap b(View view, Matrix matrix, RectF rectF, ViewGroup viewGroup) {
        ViewGroup viewGroup2;
        boolean z = true;
        boolean z2 = !view.isAttachedToWindow();
        int i2 = 0;
        if (viewGroup == null || !viewGroup.isAttachedToWindow()) {
            z = false;
        }
        Bitmap bitmap = null;
        if (!z2) {
            viewGroup2 = null;
        } else if (!z) {
            return null;
        } else {
            viewGroup2 = (ViewGroup) view.getParent();
            i2 = viewGroup2.indexOfChild(view);
            viewGroup.getOverlay().add(view);
        }
        int round = Math.round(rectF.width());
        int round2 = Math.round(rectF.height());
        if (round > 0 && round2 > 0) {
            float min = Math.min(1.0f, 1048576.0f / ((float) (round * round2)));
            int round3 = Math.round(((float) round) * min);
            int round4 = Math.round(((float) round2) * min);
            matrix.postTranslate(-rectF.left, -rectF.top);
            matrix.postScale(min, min);
            if (f16090b) {
                Picture picture = new Picture();
                Canvas beginRecording = picture.beginRecording(round3, round4);
                beginRecording.concat(matrix);
                view.draw(beginRecording);
                picture.endRecording();
                bitmap = Api28Impl.a(picture);
            } else {
                bitmap = Bitmap.createBitmap(round3, round4, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                canvas.concat(matrix);
                view.draw(canvas);
            }
        }
        if (z2) {
            viewGroup.getOverlay().remove(view);
            viewGroup2.addView(view, i2);
        }
        return bitmap;
    }

    static Animator c(Animator animator, Animator animator2) {
        if (animator == null) {
            return animator2;
        }
        if (animator2 == null) {
            return animator;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{animator, animator2});
        return animatorSet;
    }
}
