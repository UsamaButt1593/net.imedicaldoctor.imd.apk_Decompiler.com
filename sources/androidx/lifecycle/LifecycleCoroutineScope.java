package androidx.lifecycle;

import com.itextpdf.tool.xml.css.CSS;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J;\u0010\u000b\u001a\u00020\n2'\u0010\t\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004¢\u0006\u0002\b\bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ;\u0010\r\u001a\u00020\n2'\u0010\t\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004¢\u0006\u0002\b\bH\u0007ø\u0001\u0000¢\u0006\u0004\b\r\u0010\fJ;\u0010\u000e\u001a\u00020\n2'\u0010\t\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004¢\u0006\u0002\b\bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\fR\u0014\u0010\u0012\u001a\u00020\u000f8 X \u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Landroidx/lifecycle/LifecycleCoroutineScope;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "block", "Lkotlinx/coroutines/Job;", "i", "(Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "l", "k", "Landroidx/lifecycle/Lifecycle;", "h", "()Landroidx/lifecycle/Lifecycle;", "lifecycle", "lifecycle-common"}, k = 1, mv = {1, 8, 0})
public abstract class LifecycleCoroutineScope implements CoroutineScope {
    @NotNull
    public abstract Lifecycle h();

    @NotNull
    @Deprecated(message = "launchWhenCreated is deprecated as it can lead to wasted resources in some cases. Replace with suspending repeatOnLifecycle to run the block whenever the Lifecycle state is at least Lifecycle.State.CREATED.")
    public final Job i(@NotNull Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.p(function2, CSS.Value.v0);
        return BuildersKt__Builders_commonKt.f(this, (CoroutineContext) null, (CoroutineStart) null, new LifecycleCoroutineScope$launchWhenCreated$1(this, function2, (Continuation<? super LifecycleCoroutineScope$launchWhenCreated$1>) null), 3, (Object) null);
    }

    @NotNull
    @Deprecated(message = "launchWhenResumed is deprecated as it can lead to wasted resources in some cases. Replace with suspending repeatOnLifecycle to run the block whenever the Lifecycle state is at least Lifecycle.State.RESUMED.")
    public final Job k(@NotNull Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.p(function2, CSS.Value.v0);
        return BuildersKt__Builders_commonKt.f(this, (CoroutineContext) null, (CoroutineStart) null, new LifecycleCoroutineScope$launchWhenResumed$1(this, function2, (Continuation<? super LifecycleCoroutineScope$launchWhenResumed$1>) null), 3, (Object) null);
    }

    @NotNull
    @Deprecated(message = "launchWhenStarted is deprecated as it can lead to wasted resources in some cases. Replace with suspending repeatOnLifecycle to run the block whenever the Lifecycle state is at least Lifecycle.State.STARTED.")
    public final Job l(@NotNull Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.p(function2, CSS.Value.v0);
        return BuildersKt__Builders_commonKt.f(this, (CoroutineContext) null, (CoroutineStart) null, new LifecycleCoroutineScope$launchWhenStarted$1(this, function2, (Continuation<? super LifecycleCoroutineScope$launchWhenStarted$1>) null), 3, (Object) null);
    }
}
