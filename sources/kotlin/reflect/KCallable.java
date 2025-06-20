package kotlin.reflect;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.IntrinsicConstEvaluation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\r\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002J'\u0010\u0006\u001a\u00028\u00002\u0016\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040\u0003\"\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\n\u001a\u00028\u00002\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00040\bH&¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0011\u001a\u00020\f8&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u00128&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R \u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00128&X§\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u0010\u001a\u0004\b\u001b\u0010\u0014R\u001c\u0010\"\u001a\u0004\u0018\u00010\u001e8&X§\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0010\u001a\u0004\b\u001f\u0010 R\u001a\u0010'\u001a\u00020#8&X§\u0004¢\u0006\f\u0012\u0004\b&\u0010\u0010\u001a\u0004\b$\u0010%R\u001a\u0010(\u001a\u00020#8&X§\u0004¢\u0006\f\u0012\u0004\b)\u0010\u0010\u001a\u0004\b(\u0010%R\u001a\u0010,\u001a\u00020#8&X§\u0004¢\u0006\f\u0012\u0004\b+\u0010\u0010\u001a\u0004\b*\u0010%R\u001a\u0010/\u001a\u00020#8&X§\u0004¢\u0006\f\u0012\u0004\b.\u0010\u0010\u001a\u0004\b-\u0010%¨\u00060"}, d2 = {"Lkotlin/reflect/KCallable;", "R", "Lkotlin/reflect/KAnnotatedElement;", "", "", "args", "u0", "([Ljava/lang/Object;)Ljava/lang/Object;", "", "Lkotlin/reflect/KParameter;", "S", "(Ljava/util/Map;)Ljava/lang/Object;", "", "getName", "()Ljava/lang/String;", "getName$annotations", "()V", "name", "", "g", "()Ljava/util/List;", "parameters", "Lkotlin/reflect/KType;", "n0", "()Lkotlin/reflect/KType;", "returnType", "Lkotlin/reflect/KTypeParameter;", "h", "getTypeParameters$annotations", "typeParameters", "Lkotlin/reflect/KVisibility;", "b", "()Lkotlin/reflect/KVisibility;", "getVisibility$annotations", "visibility", "", "d", "()Z", "isFinal$annotations", "isFinal", "isOpen", "isOpen$annotations", "i", "isAbstract$annotations", "isAbstract", "k", "isSuspend$annotations", "isSuspend", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public interface KCallable<R> extends KAnnotatedElement {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        @IntrinsicConstEvaluation
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

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void f() {
        }

        @SinceKotlin(version = "1.3")
        public static /* synthetic */ void g() {
        }
    }

    R S(@NotNull Map<KParameter, ? extends Object> map);

    @Nullable
    KVisibility b();

    boolean d();

    @NotNull
    List<KParameter> g();

    @NotNull
    String getName();

    @NotNull
    List<KTypeParameter> h();

    boolean i();

    boolean isOpen();

    boolean k();

    @NotNull
    KType n0();

    R u0(@NotNull Object... objArr);
}
