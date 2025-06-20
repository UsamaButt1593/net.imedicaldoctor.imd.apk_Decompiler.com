package androidx.core.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.Px;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a9\u0010\u0007\u001a\u00020\u0005*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\b¢\u0006\u0004\b\u0007\u0010\b\u001a9\u0010\t\u001a\u00020\u0005*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\b¢\u0006\u0004\b\t\u0010\b\u001a9\u0010\u000b\u001a\u00020\n*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\b¢\u0006\u0004\b\u000b\u0010\f\u001a9\u0010\r\u001a\u00020\u0005*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\b¢\u0006\u0004\b\r\u0010\b\u001a9\u0010\u000e\u001a\u00020\u0005*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\b¢\u0006\u0004\b\u000e\u0010\b\u001a<\u0010\u0014\u001a\u00020\u0005*\u00020\u00002\b\b\u0003\u0010\u0010\u001a\u00020\u000f2\b\b\u0003\u0010\u0011\u001a\u00020\u000f2\b\b\u0003\u0010\u0012\u001a\u00020\u000f2\b\b\u0003\u0010\u0013\u001a\u00020\u000fH\b¢\u0006\u0004\b\u0014\u0010\u0015\u001a<\u0010\u0018\u001a\u00020\u0005*\u00020\u00002\b\b\u0003\u0010\u0016\u001a\u00020\u000f2\b\b\u0003\u0010\u0011\u001a\u00020\u000f2\b\b\u0003\u0010\u0017\u001a\u00020\u000f2\b\b\u0003\u0010\u0013\u001a\u00020\u000fH\b¢\u0006\u0004\b\u0018\u0010\u0015\u001a\u001e\u0010\u001a\u001a\u00020\u0005*\u00020\u00002\b\b\u0001\u0010\u0019\u001a\u00020\u000fH\b¢\u0006\u0004\b\u001a\u0010\u001b\u001a,\u0010 \u001a\u00020\u001f*\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001c2\u000e\b\u0004\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u001eH\b¢\u0006\u0004\b \u0010!\u001a'\u0010\"\u001a\u00020\u001f*\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001c2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u001e¢\u0006\u0004\b\"\u0010!\u001a\u001b\u0010&\u001a\u00020%*\u00020\u00002\b\b\u0002\u0010$\u001a\u00020#¢\u0006\u0004\b&\u0010'\u001a-\u0010+\u001a\u00020\u0005*\u00020\u00002\u0017\u0010*\u001a\u0013\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00050\u0001¢\u0006\u0002\b)H\b¢\u0006\u0004\b+\u0010\b\u001a9\u0010-\u001a\u00020\u0005\"\n\b\u0000\u0010,\u0018\u0001*\u00020(*\u00020\u00002\u0017\u0010*\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0001¢\u0006\u0002\b)H\b¢\u0006\u0004\b-\u0010\b\"*\u00104\u001a\u00020.*\u00020\u00002\u0006\u0010/\u001a\u00020.8Æ\u0002@Æ\u0002X\u000e¢\u0006\f\u001a\u0004\b0\u00101\"\u0004\b2\u00103\"*\u00107\u001a\u00020.*\u00020\u00002\u0006\u0010/\u001a\u00020.8Æ\u0002@Æ\u0002X\u000e¢\u0006\f\u001a\u0004\b5\u00101\"\u0004\b6\u00103\"*\u0010:\u001a\u00020.*\u00020\u00002\u0006\u0010/\u001a\u00020.8Æ\u0002@Æ\u0002X\u000e¢\u0006\f\u001a\u0004\b8\u00101\"\u0004\b9\u00103\"\u0016\u0010=\u001a\u00020\u000f*\u00020\u00008Æ\u0002¢\u0006\u0006\u001a\u0004\b;\u0010<\"\u0016\u0010?\u001a\u00020\u000f*\u00020\u00008Æ\u0002¢\u0006\u0006\u001a\u0004\b>\u0010<\"\u0016\u0010A\u001a\u00020\u000f*\u00020\u00008Æ\u0002¢\u0006\u0006\u001a\u0004\b@\u0010<\"\u0016\u0010C\u001a\u00020\u000f*\u00020\u00008Æ\u0002¢\u0006\u0006\u001a\u0004\bB\u0010<\"\u0016\u0010E\u001a\u00020\u000f*\u00020\u00008Æ\u0002¢\u0006\u0006\u001a\u0004\bD\u0010<\"\u0016\u0010G\u001a\u00020\u000f*\u00020\u00008Æ\u0002¢\u0006\u0006\u001a\u0004\bF\u0010<\"\u001b\u0010L\u001a\b\u0012\u0004\u0012\u00020I0H*\u00020\u00008F¢\u0006\u0006\u001a\u0004\bJ\u0010K\"\u001b\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00000H*\u00020\u00008F¢\u0006\u0006\u001a\u0004\bM\u0010K¨\u0006O"}, d2 = {"Landroid/view/View;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "view", "", "action", "e", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", "d", "Landroidx/core/view/OneShotPreDrawListener;", "f", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)Landroidx/core/view/OneShotPreDrawListener;", "b", "c", "", "start", "top", "end", "bottom", "E", "(Landroid/view/View;IIII)V", "left", "right", "C", "size", "y", "(Landroid/view/View;I)V", "", "delayInMillis", "Lkotlin/Function0;", "Ljava/lang/Runnable;", "t", "(Landroid/view/View;JLkotlin/jvm/functions/Function0;)Ljava/lang/Runnable;", "u", "Landroid/graphics/Bitmap$Config;", "config", "Landroid/graphics/Bitmap;", "g", "(Landroid/view/View;Landroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;", "Landroid/view/ViewGroup$LayoutParams;", "Lkotlin/ExtensionFunctionType;", "block", "A", "T", "B", "", "value", "s", "(Landroid/view/View;)Z", "z", "(Landroid/view/View;Z)V", "isVisible", "r", "x", "isInvisible", "q", "w", "isGone", "m", "(Landroid/view/View;)I", "marginLeft", "p", "marginTop", "n", "marginRight", "k", "marginBottom", "o", "marginStart", "l", "marginEnd", "Lkotlin/sequences/Sequence;", "Landroid/view/ViewParent;", "j", "(Landroid/view/View;)Lkotlin/sequences/Sequence;", "ancestors", "i", "allViews", "core-ktx_release"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 View.kt\nandroidx/core/view/ViewKt\n+ 2 Bitmap.kt\nandroidx/core/graphics/BitmapKt\n*L\n1#1,414:1\n37#1:415\n53#1:416\n326#1,4:420\n43#2,3:417\n*S KotlinDebug\n*F\n+ 1 View.kt\nandroidx/core/view/ViewKt\n*L\n68#1:415\n68#1:416\n310#1:420,4\n232#1:417,3\n*E\n"})
public final class ViewKt {
    public static final void A(@NotNull View view, @NotNull Function1<? super ViewGroup.LayoutParams, Unit> function1) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            function1.f(layoutParams);
            view.setLayoutParams(layoutParams);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    @JvmName(name = "updateLayoutParamsTyped")
    public static final /* synthetic */ <T extends ViewGroup.LayoutParams> void B(View view, Function1<? super T, Unit> function1) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.y(1, ExifInterface.d5);
        function1.f(layoutParams);
        view.setLayoutParams(layoutParams);
    }

    public static final void C(@NotNull View view, @Px int i2, @Px int i3, @Px int i4, @Px int i5) {
        view.setPadding(i2, i3, i4, i5);
    }

    public static /* synthetic */ void D(View view, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i2 = view.getPaddingLeft();
        }
        if ((i6 & 2) != 0) {
            i3 = view.getPaddingTop();
        }
        if ((i6 & 4) != 0) {
            i4 = view.getPaddingRight();
        }
        if ((i6 & 8) != 0) {
            i5 = view.getPaddingBottom();
        }
        view.setPadding(i2, i3, i4, i5);
    }

    public static final void E(@NotNull View view, @Px int i2, @Px int i3, @Px int i4, @Px int i5) {
        view.setPaddingRelative(i2, i3, i4, i5);
    }

    public static /* synthetic */ void F(View view, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i2 = view.getPaddingStart();
        }
        if ((i6 & 2) != 0) {
            i3 = view.getPaddingTop();
        }
        if ((i6 & 4) != 0) {
            i4 = view.getPaddingEnd();
        }
        if ((i6 & 8) != 0) {
            i5 = view.getPaddingBottom();
        }
        view.setPaddingRelative(i2, i3, i4, i5);
    }

    public static final void b(@NotNull View view, @NotNull Function1<? super View, Unit> function1) {
        if (view.isAttachedToWindow()) {
            function1.f(view);
        } else {
            view.addOnAttachStateChangeListener(new ViewKt$doOnAttach$1(view, function1));
        }
    }

    public static final void c(@NotNull View view, @NotNull Function1<? super View, Unit> function1) {
        if (!view.isAttachedToWindow()) {
            function1.f(view);
        } else {
            view.addOnAttachStateChangeListener(new ViewKt$doOnDetach$1(view, function1));
        }
    }

    public static final void d(@NotNull View view, @NotNull Function1<? super View, Unit> function1) {
        if (!view.isLaidOut() || view.isLayoutRequested()) {
            view.addOnLayoutChangeListener(new ViewKt$doOnLayout$$inlined$doOnNextLayout$1(function1));
        } else {
            function1.f(view);
        }
    }

    public static final void e(@NotNull View view, @NotNull Function1<? super View, Unit> function1) {
        view.addOnLayoutChangeListener(new ViewKt$doOnNextLayout$1(function1));
    }

    @NotNull
    public static final OneShotPreDrawListener f(@NotNull View view, @NotNull Function1<? super View, Unit> function1) {
        return OneShotPreDrawListener.a(view, new ViewKt$doOnPreDraw$1(function1, view));
    }

    @NotNull
    public static final Bitmap g(@NotNull View view, @NotNull Bitmap.Config config) {
        if (view.isLaidOut()) {
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), config);
            Canvas canvas = new Canvas(createBitmap);
            canvas.translate(-((float) view.getScrollX()), -((float) view.getScrollY()));
            view.draw(canvas);
            return createBitmap;
        }
        throw new IllegalStateException("View needs to be laid out before calling drawToBitmap()");
    }

    public static /* synthetic */ Bitmap h(View view, Bitmap.Config config, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        return g(view, config);
    }

    @NotNull
    public static final Sequence<View> i(@NotNull View view) {
        return SequencesKt.b(new ViewKt$allViews$1(view, (Continuation<? super ViewKt$allViews$1>) null));
    }

    @NotNull
    public static final Sequence<ViewParent> j(@NotNull View view) {
        return SequencesKt.l(view.getParent(), ViewKt$ancestors$1.c3);
    }

    public static final int k(@NotNull View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            return marginLayoutParams.bottomMargin;
        }
        return 0;
    }

    public static final int l(@NotNull View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return ((ViewGroup.MarginLayoutParams) layoutParams).getMarginEnd();
        }
        return 0;
    }

    public static final int m(@NotNull View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            return marginLayoutParams.leftMargin;
        }
        return 0;
    }

    public static final int n(@NotNull View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            return marginLayoutParams.rightMargin;
        }
        return 0;
    }

    public static final int o(@NotNull View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return ((ViewGroup.MarginLayoutParams) layoutParams).getMarginStart();
        }
        return 0;
    }

    public static final int p(@NotNull View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            return marginLayoutParams.topMargin;
        }
        return 0;
    }

    public static final boolean q(@NotNull View view) {
        return view.getVisibility() == 8;
    }

    public static final boolean r(@NotNull View view) {
        return view.getVisibility() == 4;
    }

    public static final boolean s(@NotNull View view) {
        return view.getVisibility() == 0;
    }

    @NotNull
    public static final Runnable t(@NotNull View view, long j2, @NotNull Function0<Unit> function0) {
        ViewKt$postDelayed$runnable$1 viewKt$postDelayed$runnable$1 = new ViewKt$postDelayed$runnable$1(function0);
        view.postDelayed(viewKt$postDelayed$runnable$1, j2);
        return viewKt$postDelayed$runnable$1;
    }

    @NotNull
    public static final Runnable u(@NotNull View view, long j2, @NotNull Function0<Unit> function0) {
        L l2 = new L(function0);
        view.postOnAnimationDelayed(l2, j2);
        return l2;
    }

    /* access modifiers changed from: private */
    public static final void v(Function0 function0) {
        function0.o();
    }

    public static final void w(@NotNull View view, boolean z) {
        view.setVisibility(z ? 8 : 0);
    }

    public static final void x(@NotNull View view, boolean z) {
        view.setVisibility(z ? 4 : 0);
    }

    public static final void y(@NotNull View view, @Px int i2) {
        view.setPadding(i2, i2, i2, i2);
    }

    public static final void z(@NotNull View view, boolean z) {
        view.setVisibility(z ? 0 : 8);
    }
}
