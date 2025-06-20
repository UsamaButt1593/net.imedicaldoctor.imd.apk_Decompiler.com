package androidx.activity.contextaware;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuation;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nContextAware.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContextAware.kt\nandroidx/activity/contextaware/ContextAwareKt$withContextAvailable$2$listener$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,94:1\n1#2:95\n*E\n"})
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"androidx/activity/contextaware/ContextAwareKt$withContextAvailable$2$listener$1", "Landroidx/activity/contextaware/OnContextAvailableListener;", "Landroid/content/Context;", "context", "", "a", "(Landroid/content/Context;)V", "activity_release"}, k = 1, mv = {1, 8, 0})
public final class ContextAwareKt$withContextAvailable$2$listener$1 implements OnContextAvailableListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CancellableContinuation<R> f2462a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Function1<Context, R> f2463b;

    public ContextAwareKt$withContextAvailable$2$listener$1(CancellableContinuation<R> cancellableContinuation, Function1<Context, R> function1) {
        this.f2462a = cancellableContinuation;
        this.f2463b = function1;
    }

    public void a(@NotNull Context context) {
        Object obj;
        Intrinsics.p(context, "context");
        CancellableContinuation<R> cancellableContinuation = this.f2462a;
        Function1<Context, R> function1 = this.f2463b;
        try {
            Result.Companion companion = Result.X;
            obj = Result.b(function1.f(context));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.X;
            obj = Result.b(ResultKt.a(th));
        }
        cancellableContinuation.w(obj);
    }
}
