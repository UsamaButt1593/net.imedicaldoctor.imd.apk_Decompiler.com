package com.google.android.material.transition.platform;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.transition.Transition;
import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.BlendModeColorFilterCompat;
import androidx.core.graphics.BlendModeCompat;
import com.google.android.material.R;
import com.google.android.material.internal.ContextUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

@RequiresApi(21)
public class MaterialContainerTransformSharedElementCallback extends SharedElementCallback {
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public static WeakReference<View> f22206f;

    /* renamed from: a  reason: collision with root package name */
    private boolean f22207a = true;

    /* renamed from: b  reason: collision with root package name */
    private boolean f22208b = true;

    /* renamed from: c  reason: collision with root package name */
    private boolean f22209c = false;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private Rect f22210d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private ShapeProvider f22211e = new ShapeableViewShapeProvider();

    public interface ShapeProvider {
        @Nullable
        ShapeAppearanceModel a(@NonNull View view);
    }

    public static class ShapeableViewShapeProvider implements ShapeProvider {
        @Nullable
        public ShapeAppearanceModel a(@NonNull View view) {
            if (view instanceof Shapeable) {
                return ((Shapeable) view).getShapeAppearanceModel();
            }
            return null;
        }
    }

    @Nullable
    private static Drawable f(Window window) {
        return window.getDecorView().getBackground();
    }

    /* access modifiers changed from: private */
    public static void i(Window window) {
        Drawable f2 = f(window);
        if (f2 != null) {
            f2.mutate().setColorFilter(BlendModeColorFilterCompat.a(0, BlendModeCompat.CLEAR));
        }
    }

    /* access modifiers changed from: private */
    public static void j(Window window) {
        Drawable f2 = f(window);
        if (f2 != null) {
            f2.mutate().clearColorFilter();
        }
    }

    private void n(final Window window) {
        Transition sharedElementEnterTransition = window.getSharedElementEnterTransition();
        if (sharedElementEnterTransition instanceof MaterialContainerTransform) {
            MaterialContainerTransform materialContainerTransform = (MaterialContainerTransform) sharedElementEnterTransition;
            if (!this.f22209c) {
                window.setSharedElementReenterTransition((Transition) null);
            }
            if (this.f22208b) {
                p(window, materialContainerTransform);
                materialContainerTransform.addListener(new TransitionListenerAdapter() {
                    public void onTransitionEnd(Transition transition) {
                        MaterialContainerTransformSharedElementCallback.j(window);
                    }

                    public void onTransitionStart(Transition transition) {
                        MaterialContainerTransformSharedElementCallback.i(window);
                    }
                });
            }
        }
    }

    private void o(final Activity activity, final Window window) {
        Transition sharedElementReturnTransition = window.getSharedElementReturnTransition();
        if (sharedElementReturnTransition instanceof MaterialContainerTransform) {
            MaterialContainerTransform materialContainerTransform = (MaterialContainerTransform) sharedElementReturnTransition;
            materialContainerTransform.n0(true);
            materialContainerTransform.addListener(new TransitionListenerAdapter() {
                public void onTransitionEnd(Transition transition) {
                    View view;
                    if (!(MaterialContainerTransformSharedElementCallback.f22206f == null || (view = (View) MaterialContainerTransformSharedElementCallback.f22206f.get()) == null)) {
                        view.setAlpha(1.0f);
                        WeakReference unused = MaterialContainerTransformSharedElementCallback.f22206f = null;
                    }
                    activity.finish();
                    activity.overridePendingTransition(0, 0);
                }
            });
            if (this.f22208b) {
                p(window, materialContainerTransform);
                materialContainerTransform.addListener(new TransitionListenerAdapter() {
                    public void onTransitionStart(Transition transition) {
                        MaterialContainerTransformSharedElementCallback.i(window);
                    }
                });
            }
        }
    }

    private static void p(Window window, MaterialContainerTransform materialContainerTransform) {
        if (materialContainerTransform.getDuration() >= 0) {
            window.setTransitionBackgroundFadeDuration(materialContainerTransform.getDuration());
        }
    }

    @Nullable
    public ShapeProvider e() {
        return this.f22211e;
    }

    public boolean g() {
        return this.f22209c;
    }

    public boolean h() {
        return this.f22208b;
    }

    public void k(@Nullable ShapeProvider shapeProvider) {
        this.f22211e = shapeProvider;
    }

    public void l(boolean z) {
        this.f22209c = z;
    }

    public void m(boolean z) {
        this.f22208b = z;
    }

    @Nullable
    public Parcelable onCaptureSharedElementSnapshot(@NonNull View view, @NonNull Matrix matrix, @NonNull RectF rectF) {
        f22206f = new WeakReference<>(view);
        return super.onCaptureSharedElementSnapshot(view, matrix, rectF);
    }

    @Nullable
    public View onCreateSnapshotView(@NonNull Context context, @Nullable Parcelable parcelable) {
        WeakReference<View> weakReference;
        View view;
        ShapeAppearanceModel a2;
        View onCreateSnapshotView = super.onCreateSnapshotView(context, parcelable);
        if (!(onCreateSnapshotView == null || (weakReference = f22206f) == null || this.f22211e == null || (view = weakReference.get()) == null || (a2 = this.f22211e.a(view)) == null)) {
            onCreateSnapshotView.setTag(R.id.s3, a2);
        }
        return onCreateSnapshotView;
    }

    public void onMapSharedElements(@NonNull List<String> list, @NonNull Map<String, View> map) {
        View view;
        Activity a2;
        if (!list.isEmpty() && !map.isEmpty() && (view = map.get(list.get(0))) != null && (a2 = ContextUtils.a(view.getContext())) != null) {
            Window window = a2.getWindow();
            if (this.f22207a) {
                n(window);
            } else {
                o(a2, window);
            }
        }
    }

    public void onSharedElementEnd(@NonNull List<String> list, @NonNull List<View> list2, @NonNull List<View> list3) {
        if (!list2.isEmpty()) {
            int i2 = R.id.s3;
            if (list2.get(0).getTag(i2) instanceof View) {
                list2.get(0).setTag(i2, (Object) null);
            }
        }
        if (!this.f22207a && !list2.isEmpty()) {
            this.f22210d = TransitionUtils.j(list2.get(0));
        }
        this.f22207a = false;
    }

    public void onSharedElementStart(@NonNull List<String> list, @NonNull List<View> list2, @NonNull List<View> list3) {
        if (!list2.isEmpty() && !list3.isEmpty()) {
            list2.get(0).setTag(R.id.s3, list3.get(0));
        }
        if (!this.f22207a && !list2.isEmpty() && this.f22210d != null) {
            View view = list2.get(0);
            view.measure(View.MeasureSpec.makeMeasureSpec(this.f22210d.width(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.f22210d.height(), 1073741824));
            Rect rect = this.f22210d;
            view.layout(rect.left, rect.top, rect.right, rect.bottom);
        }
    }
}
