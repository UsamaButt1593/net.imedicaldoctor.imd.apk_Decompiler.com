package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import org.xmlpull.v1.XmlPullParser;

public class ChangeTransform extends Transition {
    private static final String Y3 = "android:changeTransform:matrix";
    private static final String Z3 = "android:changeTransform:transforms";
    private static final String a4 = "android:changeTransform:parent";
    private static final String b4 = "android:changeTransform:parentMatrix";
    private static final String c4 = "android:changeTransform:intermediateParentMatrix";
    private static final String d4 = "android:changeTransform:intermediateMatrix";
    private static final String[] e4 = {Y3, Z3, b4};
    private static final Property<PathAnimatorMatrix, float[]> f4 = new Property<PathAnimatorMatrix, float[]>(float[].class, "nonTranslations") {
        /* renamed from: a */
        public float[] get(PathAnimatorMatrix pathAnimatorMatrix) {
            return null;
        }

        /* renamed from: b */
        public void set(PathAnimatorMatrix pathAnimatorMatrix, float[] fArr) {
            pathAnimatorMatrix.d(fArr);
        }
    };
    private static final Property<PathAnimatorMatrix, PointF> g4 = new Property<PathAnimatorMatrix, PointF>(PointF.class, "translations") {
        /* renamed from: a */
        public PointF get(PathAnimatorMatrix pathAnimatorMatrix) {
            return null;
        }

        /* renamed from: b */
        public void set(PathAnimatorMatrix pathAnimatorMatrix, PointF pointF) {
            pathAnimatorMatrix.c(pointF);
        }
    };
    private static final boolean h4 = true;
    boolean V3 = true;
    private boolean W3 = true;
    private Matrix X3 = new Matrix();

    private static class GhostListener extends TransitionListenerAdapter {
        private GhostView X;
        private View s;

        GhostListener(View view, GhostView ghostView) {
            this.s = view;
            this.X = ghostView;
        }

        public void f(@NonNull Transition transition) {
            this.X.setVisibility(4);
        }

        public void k(@NonNull Transition transition) {
            transition.S0(this);
            GhostViewUtils.b(this.s);
            this.s.setTag(R.id.f16024m, (Object) null);
            this.s.setTag(R.id.f16014c, (Object) null);
        }

        public void s(@NonNull Transition transition) {
            this.X.setVisibility(0);
        }
    }

    private static class Listener extends AnimatorListenerAdapter {
        private final Matrix X = new Matrix();
        private final View X2;
        private final boolean Y;
        private final Transforms Y2;
        private final boolean Z;
        private final PathAnimatorMatrix Z2;
        private final Matrix a3;
        private boolean s;

        Listener(View view, Transforms transforms, PathAnimatorMatrix pathAnimatorMatrix, Matrix matrix, boolean z, boolean z2) {
            this.Y = z;
            this.Z = z2;
            this.X2 = view;
            this.Y2 = transforms;
            this.Z2 = pathAnimatorMatrix;
            this.a3 = matrix;
        }

        private void a(Matrix matrix) {
            this.X.set(matrix);
            this.X2.setTag(R.id.f16024m, this.X);
            this.Y2.a(this.X2);
        }

        public void onAnimationCancel(Animator animator) {
            this.s = true;
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.s) {
                if (!this.Y || !this.Z) {
                    this.X2.setTag(R.id.f16024m, (Object) null);
                    this.X2.setTag(R.id.f16014c, (Object) null);
                } else {
                    a(this.a3);
                }
            }
            ViewUtils.d(this.X2, (Matrix) null);
            this.Y2.a(this.X2);
        }

        public void onAnimationPause(Animator animator) {
            a(this.Z2.a());
        }

        public void onAnimationResume(Animator animator) {
            ChangeTransform.S1(this.X2);
        }
    }

    private static class PathAnimatorMatrix {

        /* renamed from: a  reason: collision with root package name */
        private final Matrix f15980a = new Matrix();

        /* renamed from: b  reason: collision with root package name */
        private final View f15981b;

        /* renamed from: c  reason: collision with root package name */
        private final float[] f15982c;

        /* renamed from: d  reason: collision with root package name */
        private float f15983d;

        /* renamed from: e  reason: collision with root package name */
        private float f15984e;

        PathAnimatorMatrix(View view, float[] fArr) {
            this.f15981b = view;
            float[] fArr2 = (float[]) fArr.clone();
            this.f15982c = fArr2;
            this.f15983d = fArr2[2];
            this.f15984e = fArr2[5];
            b();
        }

        private void b() {
            float[] fArr = this.f15982c;
            fArr[2] = this.f15983d;
            fArr[5] = this.f15984e;
            this.f15980a.setValues(fArr);
            ViewUtils.d(this.f15981b, this.f15980a);
        }

        /* access modifiers changed from: package-private */
        public Matrix a() {
            return this.f15980a;
        }

        /* access modifiers changed from: package-private */
        public void c(PointF pointF) {
            this.f15983d = pointF.x;
            this.f15984e = pointF.y;
            b();
        }

        /* access modifiers changed from: package-private */
        public void d(float[] fArr) {
            System.arraycopy(fArr, 0, this.f15982c, 0, fArr.length);
            b();
        }
    }

    private static class Transforms {

        /* renamed from: a  reason: collision with root package name */
        final float f15985a;

        /* renamed from: b  reason: collision with root package name */
        final float f15986b;

        /* renamed from: c  reason: collision with root package name */
        final float f15987c;

        /* renamed from: d  reason: collision with root package name */
        final float f15988d;

        /* renamed from: e  reason: collision with root package name */
        final float f15989e;

        /* renamed from: f  reason: collision with root package name */
        final float f15990f;

        /* renamed from: g  reason: collision with root package name */
        final float f15991g;

        /* renamed from: h  reason: collision with root package name */
        final float f15992h;

        Transforms(View view) {
            this.f15985a = view.getTranslationX();
            this.f15986b = view.getTranslationY();
            this.f15987c = ViewCompat.D0(view);
            this.f15988d = view.getScaleX();
            this.f15989e = view.getScaleY();
            this.f15990f = view.getRotationX();
            this.f15991g = view.getRotationY();
            this.f15992h = view.getRotation();
        }

        public void a(View view) {
            ChangeTransform.b2(view, this.f15985a, this.f15986b, this.f15987c, this.f15988d, this.f15989e, this.f15990f, this.f15991g, this.f15992h);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Transforms)) {
                return false;
            }
            Transforms transforms = (Transforms) obj;
            return transforms.f15985a == this.f15985a && transforms.f15986b == this.f15986b && transforms.f15987c == this.f15987c && transforms.f15988d == this.f15988d && transforms.f15989e == this.f15989e && transforms.f15990f == this.f15990f && transforms.f15991g == this.f15991g && transforms.f15992h == this.f15992h;
        }

        public int hashCode() {
            float f2 = this.f15985a;
            int i2 = 0;
            int floatToIntBits = (f2 != 0.0f ? Float.floatToIntBits(f2) : 0) * 31;
            float f3 = this.f15986b;
            int floatToIntBits2 = (floatToIntBits + (f3 != 0.0f ? Float.floatToIntBits(f3) : 0)) * 31;
            float f4 = this.f15987c;
            int floatToIntBits3 = (floatToIntBits2 + (f4 != 0.0f ? Float.floatToIntBits(f4) : 0)) * 31;
            float f5 = this.f15988d;
            int floatToIntBits4 = (floatToIntBits3 + (f5 != 0.0f ? Float.floatToIntBits(f5) : 0)) * 31;
            float f6 = this.f15989e;
            int floatToIntBits5 = (floatToIntBits4 + (f6 != 0.0f ? Float.floatToIntBits(f6) : 0)) * 31;
            float f7 = this.f15990f;
            int floatToIntBits6 = (floatToIntBits5 + (f7 != 0.0f ? Float.floatToIntBits(f7) : 0)) * 31;
            float f8 = this.f15991g;
            int floatToIntBits7 = (floatToIntBits6 + (f8 != 0.0f ? Float.floatToIntBits(f8) : 0)) * 31;
            float f9 = this.f15992h;
            if (f9 != 0.0f) {
                i2 = Float.floatToIntBits(f9);
            }
            return floatToIntBits7 + i2;
        }
    }

    public ChangeTransform() {
    }

    private void C1(TransitionValues transitionValues) {
        View view = transitionValues.f16095b;
        if (view.getVisibility() != 8) {
            transitionValues.f16094a.put(a4, view.getParent());
            transitionValues.f16094a.put(Z3, new Transforms(view));
            Matrix matrix = view.getMatrix();
            transitionValues.f16094a.put(Y3, (matrix == null || matrix.isIdentity()) ? null : new Matrix(matrix));
            if (this.W3) {
                Matrix matrix2 = new Matrix();
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                ViewUtils.h(viewGroup, matrix2);
                matrix2.preTranslate((float) (-viewGroup.getScrollX()), (float) (-viewGroup.getScrollY()));
                transitionValues.f16094a.put(b4, matrix2);
                transitionValues.f16094a.put(d4, view.getTag(R.id.f16024m));
                transitionValues.f16094a.put(c4, view.getTag(R.id.f16014c));
            }
        }
    }

    private void D1(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        View view = transitionValues2.f16095b;
        Matrix matrix = new Matrix((Matrix) transitionValues2.f16094a.get(b4));
        ViewUtils.i(viewGroup, matrix);
        GhostView a2 = GhostViewUtils.a(view, viewGroup, matrix);
        if (a2 != null) {
            a2.a((ViewGroup) transitionValues.f16094a.get(a4), transitionValues.f16095b);
            Transition transition = this;
            while (true) {
                Transition transition2 = transition.k3;
                if (transition2 == null) {
                    break;
                }
                transition = transition2;
            }
            transition.c(new GhostListener(view, a2));
            if (h4) {
                View view2 = transitionValues.f16095b;
                if (view2 != transitionValues2.f16095b) {
                    ViewUtils.f(view2, 0.0f);
                }
                ViewUtils.f(view, 1.0f);
            }
        }
    }

    private ObjectAnimator F1(TransitionValues transitionValues, TransitionValues transitionValues2, boolean z) {
        Matrix matrix = (Matrix) transitionValues.f16094a.get(Y3);
        Matrix matrix2 = (Matrix) transitionValues2.f16094a.get(Y3);
        if (matrix == null) {
            matrix = MatrixUtils.f16002a;
        }
        if (matrix2 == null) {
            matrix2 = MatrixUtils.f16002a;
        }
        Matrix matrix3 = matrix2;
        if (matrix.equals(matrix3)) {
            return null;
        }
        View view = transitionValues2.f16095b;
        S1(view);
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        float[] fArr2 = new float[9];
        matrix3.getValues(fArr2);
        PathAnimatorMatrix pathAnimatorMatrix = new PathAnimatorMatrix(view, fArr);
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(pathAnimatorMatrix, new PropertyValuesHolder[]{PropertyValuesHolder.ofObject(f4, new FloatArrayEvaluator(new float[9]), new float[][]{fArr, fArr2}), PropertyValuesHolderUtils.a(g4, b0().a(fArr[2], fArr[5], fArr2[2], fArr2[5]))});
        Listener listener = new Listener(view, (Transforms) transitionValues2.f16094a.get(Z3), pathAnimatorMatrix, matrix3, z, this.V3);
        ofPropertyValuesHolder.addListener(listener);
        ofPropertyValuesHolder.addPauseListener(listener);
        return ofPropertyValuesHolder;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001d, code lost:
        if (r4 == r5) goto L_0x001b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
        if (r5 == r4.f16095b) goto L_0x001b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean R1(android.view.ViewGroup r4, android.view.ViewGroup r5) {
        /*
            r3 = this;
            boolean r0 = r3.y0(r4)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x001d
            boolean r0 = r3.y0(r5)
            if (r0 != 0) goto L_0x000f
            goto L_0x001d
        L_0x000f:
            androidx.transition.TransitionValues r4 = r3.X(r4, r1)
            if (r4 == 0) goto L_0x0020
            android.view.View r4 = r4.f16095b
            if (r5 != r4) goto L_0x001a
            goto L_0x001b
        L_0x001a:
            r1 = 0
        L_0x001b:
            r2 = r1
            goto L_0x0020
        L_0x001d:
            if (r4 != r5) goto L_0x001a
            goto L_0x001b
        L_0x0020:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.ChangeTransform.R1(android.view.ViewGroup, android.view.ViewGroup):boolean");
    }

    static void S1(View view) {
        b2(view, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
    }

    private void T1(TransitionValues transitionValues, TransitionValues transitionValues2) {
        Matrix matrix = (Matrix) transitionValues2.f16094a.get(b4);
        transitionValues2.f16095b.setTag(R.id.f16014c, matrix);
        Matrix matrix2 = this.X3;
        matrix2.reset();
        matrix.invert(matrix2);
        Matrix matrix3 = (Matrix) transitionValues.f16094a.get(Y3);
        if (matrix3 == null) {
            matrix3 = new Matrix();
            transitionValues.f16094a.put(Y3, matrix3);
        }
        matrix3.postConcat((Matrix) transitionValues.f16094a.get(b4));
        matrix3.postConcat(matrix2);
    }

    static void b2(View view, float f2, float f3, float f5, float f6, float f7, float f8, float f9, float f10) {
        view.setTranslationX(f2);
        view.setTranslationY(f3);
        ViewCompat.G2(view, f5);
        view.setScaleX(f6);
        view.setScaleY(f7);
        view.setRotationX(f8);
        view.setRotationY(f9);
        view.setRotation(f10);
    }

    public boolean H1() {
        return this.W3;
    }

    public boolean O1() {
        return this.V3;
    }

    public void U1(boolean z) {
        this.W3 = z;
    }

    public void a2(boolean z) {
        this.V3 = z;
    }

    public void n(@NonNull TransitionValues transitionValues) {
        C1(transitionValues);
    }

    public void q(@NonNull TransitionValues transitionValues) {
        C1(transitionValues);
        if (!h4) {
            ((ViewGroup) transitionValues.f16095b.getParent()).startViewTransition(transitionValues.f16095b);
        }
    }

    @NonNull
    public String[] r0() {
        return e4;
    }

    @Nullable
    public Animator u(@NonNull ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        if (transitionValues == null || transitionValues2 == null || !transitionValues.f16094a.containsKey(a4) || !transitionValues2.f16094a.containsKey(a4)) {
            return null;
        }
        ViewGroup viewGroup2 = (ViewGroup) transitionValues.f16094a.get(a4);
        boolean z = this.W3 && !R1(viewGroup2, (ViewGroup) transitionValues2.f16094a.get(a4));
        Matrix matrix = (Matrix) transitionValues.f16094a.get(d4);
        if (matrix != null) {
            transitionValues.f16094a.put(Y3, matrix);
        }
        Matrix matrix2 = (Matrix) transitionValues.f16094a.get(c4);
        if (matrix2 != null) {
            transitionValues.f16094a.put(b4, matrix2);
        }
        if (z) {
            T1(transitionValues, transitionValues2);
        }
        ObjectAnimator F1 = F1(transitionValues, transitionValues2, z);
        if (z && F1 != null && this.V3) {
            D1(viewGroup, transitionValues, transitionValues2);
        } else if (!h4) {
            viewGroup2.endViewTransition(transitionValues.f16095b);
        }
        return F1;
    }

    public ChangeTransform(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.f16040g);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        this.V3 = TypedArrayUtils.e(obtainStyledAttributes, xmlPullParser, "reparentWithOverlay", 1, true);
        this.W3 = TypedArrayUtils.e(obtainStyledAttributes, xmlPullParser, "reparent", 0, true);
        obtainStyledAttributes.recycle();
    }
}
