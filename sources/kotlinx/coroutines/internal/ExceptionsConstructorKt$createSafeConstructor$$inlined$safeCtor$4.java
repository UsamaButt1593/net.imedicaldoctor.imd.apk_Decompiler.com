package kotlinx.coroutines.internal;

import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0003\n\u0002\b\u0004\u0010\u0002\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"", "e", "b", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "kotlinx/coroutines/internal/ExceptionsConstructorKt$safeCtor$1"}, k = 3, mv = {1, 6, 0})
public final class ExceptionsConstructorKt$createSafeConstructor$$inlined$safeCtor$4 extends Lambda implements Function1<Throwable, Throwable> {
    final /* synthetic */ Constructor X;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExceptionsConstructorKt$createSafeConstructor$$inlined$safeCtor$4(Constructor constructor) {
        super(1);
        this.X = constructor;
    }

    @Nullable
    /* renamed from: b */
    public final Throwable f(@NotNull Throwable th) {
        Object obj;
        Throwable th2 = null;
        try {
            Result.Companion companion = Result.X;
            Object newInstance = this.X.newInstance((Object[]) null);
            if (newInstance != null) {
                Throwable th3 = (Throwable) newInstance;
                th3.initCause(th);
                obj = Result.b(th3);
                if (!Result.i(obj)) {
                    th2 = obj;
                }
                return th2;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
        } catch (Throwable th4) {
            Result.Companion companion2 = Result.X;
            obj = Result.b(ResultKt.a(th4));
        }
    }
}
