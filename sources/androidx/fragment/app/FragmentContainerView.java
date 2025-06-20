package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.annotation.RequiresApi;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.R;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.tool.xml.html.HTML;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001OB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0004\u0010\nB!\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0004\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0015\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0017¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0017¢\u0006\u0004\b\u001f\u0010\u001eJ\u0017\u0010\"\u001a\u00020\u00102\u0006\u0010!\u001a\u00020 H\u0014¢\u0006\u0004\b\"\u0010#J'\u0010(\u001a\u00020'2\u0006\u0010!\u001a\u00020 2\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020%H\u0014¢\u0006\u0004\b(\u0010)J\u0017\u0010+\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\u000eH\u0016¢\u0006\u0004\b+\u0010\u0012J\u0017\u0010,\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\u000eH\u0016¢\u0006\u0004\b,\u0010\u0012J\u0017\u0010.\u001a\u00020\u00102\u0006\u0010-\u001a\u00020'H\u0001¢\u0006\u0004\b.\u0010/J)\u00103\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\b2\b\u00102\u001a\u0004\u0018\u000101H\u0016¢\u0006\u0004\b3\u00104J\u0017\u00105\u001a\u00020\u00102\u0006\u00100\u001a\u00020\bH\u0016¢\u0006\u0004\b5\u00106J\u0017\u00107\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\u000eH\u0016¢\u0006\u0004\b7\u0010\u0012J\u0017\u00108\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\u000eH\u0016¢\u0006\u0004\b8\u0010\u0012J\u001f\u0010;\u001a\u00020\u00102\u0006\u00109\u001a\u00020\b2\u0006\u0010:\u001a\u00020\bH\u0016¢\u0006\u0004\b;\u0010<J\u001f\u0010=\u001a\u00020\u00102\u0006\u00109\u001a\u00020\b2\u0006\u0010:\u001a\u00020\bH\u0016¢\u0006\u0004\b=\u0010<J\u000f\u0010>\u001a\u00020\u0010H\u0016¢\u0006\u0004\b>\u0010?J\u0019\u0010B\u001a\u00028\u0000\"\n\b\u0000\u0010A*\u0004\u0018\u00010@¢\u0006\u0004\bB\u0010CR\u001a\u0010G\u001a\b\u0012\u0004\u0012\u00020\u000e0D8\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u001a\u0010I\u001a\b\u0012\u0004\u0012\u00020\u000e0D8\u0002X\u0004¢\u0006\u0006\n\u0004\bH\u0010FR\u0018\u0010L\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010-\u001a\u00020'8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bM\u0010N¨\u0006P"}, d2 = {"Landroidx/fragment/app/FragmentContainerView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroidx/fragment/app/FragmentManager;", "fm", "(Landroid/content/Context;Landroid/util/AttributeSet;Landroidx/fragment/app/FragmentManager;)V", "Landroid/view/View;", "v", "", "a", "(Landroid/view/View;)V", "Landroid/animation/LayoutTransition;", "transition", "setLayoutTransition", "(Landroid/animation/LayoutTransition;)V", "Landroid/view/View$OnApplyWindowInsetsListener;", "listener", "setOnApplyWindowInsetsListener", "(Landroid/view/View$OnApplyWindowInsetsListener;)V", "Landroid/view/WindowInsets;", "insets", "onApplyWindowInsets", "(Landroid/view/WindowInsets;)Landroid/view/WindowInsets;", "dispatchApplyWindowInsets", "Landroid/graphics/Canvas;", "canvas", "dispatchDraw", "(Landroid/graphics/Canvas;)V", "child", "", "drawingTime", "", "drawChild", "(Landroid/graphics/Canvas;Landroid/view/View;J)Z", "view", "startViewTransition", "endViewTransition", "drawDisappearingViewsFirst", "setDrawDisappearingViewsLast", "(Z)V", "index", "Landroid/view/ViewGroup$LayoutParams;", "params", "addView", "(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V", "removeViewAt", "(I)V", "removeViewInLayout", "removeView", "start", "count", "removeViews", "(II)V", "removeViewsInLayout", "removeAllViewsInLayout", "()V", "Landroidx/fragment/app/Fragment;", "F", "getFragment", "()Landroidx/fragment/app/Fragment;", "", "s", "Ljava/util/List;", "disappearingFragmentChildren", "X2", "transitioningFragmentViews", "Y2", "Landroid/view/View$OnApplyWindowInsetsListener;", "applyWindowInsetsListener", "Z2", "Z", "Api20Impl", "fragment_release"}, k = 1, mv = {1, 6, 0})
public final class FragmentContainerView extends FrameLayout {
    @NotNull
    private final List<View> X2;
    @Nullable
    private View.OnApplyWindowInsetsListener Y2;
    private boolean Z2;
    @NotNull
    private final List<View> s;

    @RequiresApi(20)
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/fragment/app/FragmentContainerView$Api20Impl;", "", "<init>", "()V", "Landroid/view/View$OnApplyWindowInsetsListener;", "onApplyWindowInsetsListener", "Landroid/view/View;", "v", "Landroid/view/WindowInsets;", "insets", "a", "(Landroid/view/View$OnApplyWindowInsetsListener;Landroid/view/View;Landroid/view/WindowInsets;)Landroid/view/WindowInsets;", "fragment_release"}, k = 1, mv = {1, 6, 0})
    public static final class Api20Impl {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public static final Api20Impl f7900a = new Api20Impl();

        private Api20Impl() {
        }

        @NotNull
        public final WindowInsets a(@NotNull View.OnApplyWindowInsetsListener onApplyWindowInsetsListener, @NotNull View view, @NotNull WindowInsets windowInsets) {
            Intrinsics.p(onApplyWindowInsetsListener, "onApplyWindowInsetsListener");
            Intrinsics.p(view, "v");
            Intrinsics.p(windowInsets, "insets");
            WindowInsets onApplyWindowInsets = onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            Intrinsics.o(onApplyWindowInsets, "onApplyWindowInsetsListe…lyWindowInsets(v, insets)");
            return onApplyWindowInsets;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(@NotNull Context context) {
        super(context);
        Intrinsics.p(context, "context");
        this.s = new ArrayList();
        this.X2 = new ArrayList();
        this.Z2 = true;
    }

    private final void a(View view) {
        if (this.X2.contains(view)) {
            this.s.add(view);
        }
    }

    public void addView(@NotNull View view, int i2, @Nullable ViewGroup.LayoutParams layoutParams) {
        Intrinsics.p(view, "child");
        if (FragmentManager.Q0(view) != null) {
            super.addView(view, i2, layoutParams);
            return;
        }
        throw new IllegalStateException(("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.").toString());
    }

    @RequiresApi(20)
    @NotNull
    public WindowInsets dispatchApplyWindowInsets(@NotNull WindowInsets windowInsets) {
        WindowInsetsCompat windowInsetsCompat;
        Intrinsics.p(windowInsets, "insets");
        WindowInsetsCompat K = WindowInsetsCompat.K(windowInsets);
        Intrinsics.o(K, "toWindowInsetsCompat(insets)");
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.Y2;
        if (onApplyWindowInsetsListener != null) {
            Api20Impl api20Impl = Api20Impl.f7900a;
            Intrinsics.m(onApplyWindowInsetsListener);
            windowInsetsCompat = WindowInsetsCompat.K(api20Impl.a(onApplyWindowInsetsListener, this, windowInsets));
        } else {
            windowInsetsCompat = ViewCompat.k1(this, K);
        }
        Intrinsics.o(windowInsetsCompat, "if (applyWindowInsetsLis…, insetsCompat)\n        }");
        if (!windowInsetsCompat.A()) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                ViewCompat.p(getChildAt(i2), windowInsetsCompat);
            }
        }
        return windowInsets;
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(@NotNull Canvas canvas) {
        Intrinsics.p(canvas, HTML.Tag.K);
        if (this.Z2) {
            for (View drawChild : this.s) {
                super.drawChild(canvas, drawChild, getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(@NotNull Canvas canvas, @NotNull View view, long j2) {
        Intrinsics.p(canvas, HTML.Tag.K);
        Intrinsics.p(view, "child");
        if (!this.Z2 || !(!this.s.isEmpty()) || !this.s.contains(view)) {
            return super.drawChild(canvas, view, j2);
        }
        return false;
    }

    public void endViewTransition(@NotNull View view) {
        Intrinsics.p(view, "view");
        this.X2.remove(view);
        if (this.s.remove(view)) {
            this.Z2 = true;
        }
        super.endViewTransition(view);
    }

    public final <F extends Fragment> F getFragment() {
        return FragmentManager.u0(this).r0(getId());
    }

    @RequiresApi(20)
    @NotNull
    public WindowInsets onApplyWindowInsets(@NotNull WindowInsets windowInsets) {
        Intrinsics.p(windowInsets, "insets");
        return windowInsets;
    }

    public void removeAllViewsInLayout() {
        int childCount = getChildCount();
        while (true) {
            childCount--;
            if (-1 < childCount) {
                View childAt = getChildAt(childCount);
                Intrinsics.o(childAt, "view");
                a(childAt);
            } else {
                super.removeAllViewsInLayout();
                return;
            }
        }
    }

    public void removeView(@NotNull View view) {
        Intrinsics.p(view, "view");
        a(view);
        super.removeView(view);
    }

    public void removeViewAt(int i2) {
        View childAt = getChildAt(i2);
        Intrinsics.o(childAt, "view");
        a(childAt);
        super.removeViewAt(i2);
    }

    public void removeViewInLayout(@NotNull View view) {
        Intrinsics.p(view, "view");
        a(view);
        super.removeViewInLayout(view);
    }

    public void removeViews(int i2, int i3) {
        int i4 = i2 + i3;
        for (int i5 = i2; i5 < i4; i5++) {
            View childAt = getChildAt(i5);
            Intrinsics.o(childAt, "view");
            a(childAt);
        }
        super.removeViews(i2, i3);
    }

    public void removeViewsInLayout(int i2, int i3) {
        int i4 = i2 + i3;
        for (int i5 = i2; i5 < i4; i5++) {
            View childAt = getChildAt(i5);
            Intrinsics.o(childAt, "view");
            a(childAt);
        }
        super.removeViewsInLayout(i2, i3);
    }

    @JvmName(name = "setDrawDisappearingViewsLast")
    public final void setDrawDisappearingViewsLast(boolean z) {
        this.Z2 = z;
    }

    public void setLayoutTransition(@Nullable LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    public void setOnApplyWindowInsetsListener(@NotNull View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        Intrinsics.p(onApplyWindowInsetsListener, ServiceSpecificExtraArgs.CastExtraArgs.f20260a);
        this.Y2 = onApplyWindowInsetsListener;
    }

    public void startViewTransition(@NotNull View view) {
        Intrinsics.p(view, "view");
        if (view.getParent() == this) {
            this.X2.add(view);
        }
        super.startViewTransition(view);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FragmentContainerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.p(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FragmentContainerView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        String str;
        Intrinsics.p(context, "context");
        this.s = new ArrayList();
        this.X2 = new ArrayList();
        this.Z2 = true;
        if (attributeSet != null) {
            String classAttribute = attributeSet.getClassAttribute();
            int[] iArr = R.styleable.f7846e;
            Intrinsics.o(iArr, "FragmentContainerView");
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
            if (classAttribute == null) {
                classAttribute = obtainStyledAttributes.getString(R.styleable.f7847f);
                str = "android:name";
            } else {
                str = "class";
            }
            obtainStyledAttributes.recycle();
            if (classAttribute != null && !isInEditMode()) {
                throw new UnsupportedOperationException("FragmentContainerView must be within a FragmentActivity to use " + str + "=\"" + classAttribute + '\"');
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FragmentContainerView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(@NotNull Context context, @NotNull AttributeSet attributeSet, @NotNull FragmentManager fragmentManager) {
        super(context, attributeSet);
        String str;
        Intrinsics.p(context, "context");
        Intrinsics.p(attributeSet, "attrs");
        Intrinsics.p(fragmentManager, "fm");
        this.s = new ArrayList();
        this.X2 = new ArrayList();
        this.Z2 = true;
        String classAttribute = attributeSet.getClassAttribute();
        int[] iArr = R.styleable.f7846e;
        Intrinsics.o(iArr, "FragmentContainerView");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
        classAttribute = classAttribute == null ? obtainStyledAttributes.getString(R.styleable.f7847f) : classAttribute;
        String string = obtainStyledAttributes.getString(R.styleable.f7848g);
        obtainStyledAttributes.recycle();
        int id = getId();
        Fragment r0 = fragmentManager.r0(id);
        if (classAttribute != null && r0 == null) {
            if (id == -1) {
                if (string != null) {
                    str = " with tag " + string;
                } else {
                    str = "";
                }
                throw new IllegalStateException("FragmentContainerView must have an android:id to add Fragment " + classAttribute + str);
            }
            Fragment a2 = fragmentManager.G0().a(context.getClassLoader(), classAttribute);
            Intrinsics.o(a2, "fm.fragmentFactory.insta…ontext.classLoader, name)");
            a2.c1(context, attributeSet, (Bundle) null);
            fragmentManager.u().Q(true).j(this, a2, string).t();
        }
        fragmentManager.o1(this);
    }
}
