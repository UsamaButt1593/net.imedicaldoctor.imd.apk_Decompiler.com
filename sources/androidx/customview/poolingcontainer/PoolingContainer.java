package androidx.customview.poolingcontainer;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.ViewGroupKt;
import androidx.core.view.ViewKt;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0006\u0010\u0005\u001a\u0011\u0010\u0007\u001a\u00020\u0003*\u00020\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u0011\u0010\n\u001a\u00020\u0003*\u00020\t¢\u0006\u0004\b\n\u0010\u000b\"\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\r\"\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\r\"(\u0010\u0016\u001a\u00020\u0010*\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00108F@FX\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\"\u0015\u0010\u0018\u001a\u00020\u0010*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0013\"\u0018\u0010\u001c\u001a\u00020\u0019*\u00020\u00008BX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Landroid/view/View;", "Landroidx/customview/poolingcontainer/PoolingContainerListener;", "listener", "", "a", "(Landroid/view/View;Landroidx/customview/poolingcontainer/PoolingContainerListener;)V", "g", "b", "(Landroid/view/View;)V", "Landroid/view/ViewGroup;", "c", "(Landroid/view/ViewGroup;)V", "", "I", "PoolingContainerListenerHolderTag", "IsPoolingContainerTag", "", "value", "e", "(Landroid/view/View;)Z", "h", "(Landroid/view/View;Z)V", "isPoolingContainer", "f", "isWithinPoolingContainer", "Landroidx/customview/poolingcontainer/PoolingContainerListenerHolder;", "d", "(Landroid/view/View;)Landroidx/customview/poolingcontainer/PoolingContainerListenerHolder;", "poolingContainerListenerHolder", "customview-poolingcontainer_release"}, k = 2, mv = {1, 6, 0})
@JvmName(name = "PoolingContainer")
public final class PoolingContainer {

    /* renamed from: a  reason: collision with root package name */
    private static final int f6863a = R.id.f6867b;

    /* renamed from: b  reason: collision with root package name */
    private static final int f6864b = R.id.f6866a;

    @SuppressLint({"ExecutorRegistration"})
    public static final void a(@NotNull View view, @NotNull PoolingContainerListener poolingContainerListener) {
        Intrinsics.p(view, "<this>");
        Intrinsics.p(poolingContainerListener, ServiceSpecificExtraArgs.CastExtraArgs.f20260a);
        d(view).a(poolingContainerListener);
    }

    public static final void b(@NotNull View view) {
        Intrinsics.p(view, "<this>");
        for (View d2 : ViewKt.i(view)) {
            d(d2).b();
        }
    }

    public static final void c(@NotNull ViewGroup viewGroup) {
        Intrinsics.p(viewGroup, "<this>");
        for (View d2 : ViewGroupKt.e(viewGroup)) {
            d(d2).b();
        }
    }

    private static final PoolingContainerListenerHolder d(View view) {
        int i2 = f6863a;
        PoolingContainerListenerHolder poolingContainerListenerHolder = (PoolingContainerListenerHolder) view.getTag(i2);
        if (poolingContainerListenerHolder != null) {
            return poolingContainerListenerHolder;
        }
        PoolingContainerListenerHolder poolingContainerListenerHolder2 = new PoolingContainerListenerHolder();
        view.setTag(i2, poolingContainerListenerHolder2);
        return poolingContainerListenerHolder2;
    }

    public static final boolean e(@NotNull View view) {
        Intrinsics.p(view, "<this>");
        Object tag = view.getTag(f6864b);
        Boolean bool = tag instanceof Boolean ? (Boolean) tag : null;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static final boolean f(@NotNull View view) {
        Intrinsics.p(view, "<this>");
        for (ViewParent next : ViewKt.j(view)) {
            if ((next instanceof View) && e((View) next)) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"ExecutorRegistration"})
    public static final void g(@NotNull View view, @NotNull PoolingContainerListener poolingContainerListener) {
        Intrinsics.p(view, "<this>");
        Intrinsics.p(poolingContainerListener, ServiceSpecificExtraArgs.CastExtraArgs.f20260a);
        d(view).c(poolingContainerListener);
    }

    public static final void h(@NotNull View view, boolean z) {
        Intrinsics.p(view, "<this>");
        view.setTag(f6864b, Boolean.valueOf(z));
    }
}
