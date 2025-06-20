package kotlin.reflect;

import kotlin.Function;
import kotlin.Metadata;
import kotlin.SinceKotlin;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003R\u001a\u0010\t\u001a\u00020\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\f\u001a\u00020\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\b\u001a\u0004\b\r\u0010\u0006R\u001a\u0010\u0012\u001a\u00020\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\b\u001a\u0004\b\u0010\u0010\u0006R\u001a\u0010\u0015\u001a\u00020\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\b\u001a\u0004\b\u0013\u0010\u0006¨\u0006\u0016"}, d2 = {"Lkotlin/reflect/KFunction;", "R", "Lkotlin/reflect/KCallable;", "Lkotlin/Function;", "", "n", "()Z", "isInline$annotations", "()V", "isInline", "t", "isExternal$annotations", "isExternal", "L", "isOperator$annotations", "isOperator", "t0", "isInfix$annotations", "isInfix", "k", "isSuspend$annotations", "isSuspend", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public interface KFunction<R> extends KCallable<R>, Function<R> {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void a() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void b() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void c() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void d() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void e() {
        }
    }

    boolean L();

    boolean k();

    boolean n();

    boolean t();

    boolean t0();
}
