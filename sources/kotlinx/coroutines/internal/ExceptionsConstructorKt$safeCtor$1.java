package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0003\n\u0002\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "e", "b", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;"}, k = 3, mv = {1, 6, 0})
public final class ExceptionsConstructorKt$safeCtor$1 extends Lambda implements Function1<Throwable, Throwable> {
    final /* synthetic */ Function1<Throwable, Throwable> X;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExceptionsConstructorKt$safeCtor$1(Function1<? super Throwable, ? extends Throwable> function1) {
        super(1);
        this.X = function1;
    }

    @Nullable
    /* renamed from: b */
    public final Throwable f(@NotNull Throwable th) {
        Object obj;
        Function1<Throwable, Throwable> function1 = this.X;
        try {
            Result.Companion companion = Result.X;
            obj = Result.b(function1.f(th));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.X;
            obj = Result.b(ResultKt.a(th2));
        }
        if (Result.i(obj)) {
            obj = null;
        }
        return (Throwable) obj;
    }
}
