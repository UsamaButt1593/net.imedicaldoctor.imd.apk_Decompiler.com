package kotlin.reflect;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b \bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H'¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u000b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0001H¦\u0002¢\u0006\u0004\b\u000b\u0010\tJ\u000f\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u000f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u000f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u001e\u0010\u0019\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00160\u00158&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R \u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001a0\u00158&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0018R\u001e\u0010\u001e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00000\u00158&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0018R\u0016\u0010!\u001a\u0004\u0018\u00018\u00008&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R \u0010(\u001a\b\u0012\u0004\u0012\u00020#0\"8&X§\u0004¢\u0006\f\u0012\u0004\b&\u0010'\u001a\u0004\b$\u0010%R \u0010,\u001a\b\u0012\u0004\u0012\u00020)0\"8&X§\u0004¢\u0006\f\u0012\u0004\b+\u0010'\u001a\u0004\b*\u0010%R(\u0010/\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00000\"8&X§\u0004¢\u0006\f\u0012\u0004\b.\u0010'\u001a\u0004\b-\u0010%R\u001c\u00104\u001a\u0004\u0018\u0001008&X§\u0004¢\u0006\f\u0012\u0004\b3\u0010'\u001a\u0004\b1\u00102R\u001a\u00108\u001a\u00020\u00078&X§\u0004¢\u0006\f\u0012\u0004\b7\u0010'\u001a\u0004\b5\u00106R\u001a\u00109\u001a\u00020\u00078&X§\u0004¢\u0006\f\u0012\u0004\b:\u0010'\u001a\u0004\b9\u00106R\u001a\u0010=\u001a\u00020\u00078&X§\u0004¢\u0006\f\u0012\u0004\b<\u0010'\u001a\u0004\b;\u00106R\u001a\u0010@\u001a\u00020\u00078&X§\u0004¢\u0006\f\u0012\u0004\b?\u0010'\u001a\u0004\b>\u00106R\u001a\u0010C\u001a\u00020\u00078&X§\u0004¢\u0006\f\u0012\u0004\bB\u0010'\u001a\u0004\bA\u00106R\u001a\u0010F\u001a\u00020\u00078&X§\u0004¢\u0006\f\u0012\u0004\bE\u0010'\u001a\u0004\bD\u00106R\u001a\u0010I\u001a\u00020\u00078&X§\u0004¢\u0006\f\u0012\u0004\bH\u0010'\u001a\u0004\bG\u00106R\u001a\u0010L\u001a\u00020\u00078&X§\u0004¢\u0006\f\u0012\u0004\bK\u0010'\u001a\u0004\bJ\u00106R\u001a\u0010O\u001a\u00020\u00078&X§\u0004¢\u0006\f\u0012\u0004\bN\u0010'\u001a\u0004\bM\u00106¨\u0006P"}, d2 = {"Lkotlin/reflect/KClass;", "", "T", "Lkotlin/reflect/KDeclarationContainer;", "Lkotlin/reflect/KAnnotatedElement;", "Lkotlin/reflect/KClassifier;", "value", "", "i0", "(Ljava/lang/Object;)Z", "other", "equals", "", "hashCode", "()I", "", "K", "()Ljava/lang/String;", "simpleName", "m", "qualifiedName", "", "Lkotlin/reflect/KCallable;", "l", "()Ljava/util/Collection;", "members", "Lkotlin/reflect/KFunction;", "w", "constructors", "p", "nestedClasses", "P", "()Ljava/lang/Object;", "objectInstance", "", "Lkotlin/reflect/KTypeParameter;", "h", "()Ljava/util/List;", "getTypeParameters$annotations", "()V", "typeParameters", "Lkotlin/reflect/KType;", "M", "getSupertypes$annotations", "supertypes", "D", "getSealedSubclasses$annotations", "sealedSubclasses", "Lkotlin/reflect/KVisibility;", "b", "()Lkotlin/reflect/KVisibility;", "getVisibility$annotations", "visibility", "d", "()Z", "isFinal$annotations", "isFinal", "isOpen", "isOpen$annotations", "i", "isAbstract$annotations", "isAbstract", "W", "isSealed$annotations", "isSealed", "v0", "isData$annotations", "isData", "J", "isInner$annotations", "isInner", "U", "isCompanion$annotations", "isCompanion", "y", "isFun$annotations", "isFun", "I", "isValue$annotations", "isValue", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public interface KClass<T> extends KDeclarationContainer, KAnnotatedElement, KClassifier {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        @SinceKotlin(version = "1.3")
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

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void g() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void h() {
        }

        @SinceKotlin(version = "1.4")
        public static /* synthetic */ void i() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void j() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void k() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void l() {
        }

        @SinceKotlin(version = "1.5")
        public static /* synthetic */ void m() {
        }
    }

    @NotNull
    List<KClass<? extends T>> D();

    boolean I();

    boolean J();

    @Nullable
    String K();

    @NotNull
    List<KType> M();

    @Nullable
    T P();

    boolean U();

    boolean W();

    @Nullable
    KVisibility b();

    boolean d();

    boolean equals(@Nullable Object obj);

    @NotNull
    List<KTypeParameter> h();

    int hashCode();

    boolean i();

    @SinceKotlin(version = "1.1")
    boolean i0(@Nullable Object obj);

    boolean isOpen();

    @NotNull
    Collection<KCallable<?>> l();

    @Nullable
    String m();

    @NotNull
    Collection<KClass<?>> p();

    boolean v0();

    @NotNull
    Collection<KFunction<T>> w();

    boolean y();
}
