package kotlin.jvm.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVariance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nTypeParameterReference.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeParameterReference.kt\nkotlin/jvm/internal/TypeParameterReference\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,58:1\n1#2:59\n*E\n"})
@SinceKotlin(version = "1.4")
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u001a\b\u0007\u0018\u0000 -2\u00020\u0001:\u0001.B)\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u0010\u001a\u00020\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0019R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0004¢\u0006\f\n\u0004\b#\u0010#\u001a\u0004\b$\u0010%R\u001e\u0010(\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010'R \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8VX\u0004¢\u0006\f\u0012\u0004\b+\u0010,\u001a\u0004\b)\u0010*¨\u0006/"}, d2 = {"Lkotlin/jvm/internal/TypeParameterReference;", "Lkotlin/reflect/KTypeParameter;", "", "container", "", "name", "Lkotlin/reflect/KVariance;", "variance", "", "isReified", "<init>", "(Ljava/lang/Object;Ljava/lang/String;Lkotlin/reflect/KVariance;Z)V", "", "Lkotlin/reflect/KType;", "upperBounds", "", "c", "(Ljava/util/List;)V", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", "s", "Ljava/lang/Object;", "X", "Ljava/lang/String;", "getName", "Y", "Lkotlin/reflect/KVariance;", "f", "()Lkotlin/reflect/KVariance;", "Z", "e", "()Z", "X2", "Ljava/util/List;", "bounds", "getUpperBounds", "()Ljava/util/List;", "a", "()V", "Y2", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public final class TypeParameterReference implements KTypeParameter {
    @NotNull
    public static final Companion Y2 = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final String X;
    @Nullable
    private volatile List<? extends KType> X2;
    @NotNull
    private final KVariance Y;
    private final boolean Z;
    @Nullable
    private final Object s;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lkotlin/jvm/internal/TypeParameterReference$Companion;", "", "<init>", "()V", "Lkotlin/reflect/KTypeParameter;", "typeParameter", "", "a", "(Lkotlin/reflect/KTypeParameter;)Ljava/lang/String;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ int[] f28972a;

            /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
            static {
                /*
                    kotlin.reflect.KVariance[] r0 = kotlin.reflect.KVariance.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    kotlin.reflect.KVariance r1 = kotlin.reflect.KVariance.INVARIANT     // Catch:{ NoSuchFieldError -> 0x0010 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                    r2 = 1
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                L_0x0010:
                    kotlin.reflect.KVariance r1 = kotlin.reflect.KVariance.IN     // Catch:{ NoSuchFieldError -> 0x0019 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                    r2 = 2
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                L_0x0019:
                    kotlin.reflect.KVariance r1 = kotlin.reflect.KVariance.OUT     // Catch:{ NoSuchFieldError -> 0x0022 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                    r2 = 3
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
                L_0x0022:
                    f28972a = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.jvm.internal.TypeParameterReference.Companion.WhenMappings.<clinit>():void");
            }
        }

        private Companion() {
        }

        @NotNull
        public final String a(@NotNull KTypeParameter kTypeParameter) {
            String str;
            Intrinsics.p(kTypeParameter, "typeParameter");
            StringBuilder sb = new StringBuilder();
            int i2 = WhenMappings.f28972a[kTypeParameter.f().ordinal()];
            if (i2 != 2) {
                if (i2 == 3) {
                    str = "out ";
                }
                sb.append(kTypeParameter.getName());
                String sb2 = sb.toString();
                Intrinsics.o(sb2, "StringBuilder().apply(builderAction).toString()");
                return sb2;
            }
            str = "in ";
            sb.append(str);
            sb.append(kTypeParameter.getName());
            String sb22 = sb.toString();
            Intrinsics.o(sb22, "StringBuilder().apply(builderAction).toString()");
            return sb22;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public TypeParameterReference(@Nullable Object obj, @NotNull String str, @NotNull KVariance kVariance, boolean z) {
        Intrinsics.p(str, "name");
        Intrinsics.p(kVariance, "variance");
        this.s = obj;
        this.X = str;
        this.Y = kVariance;
        this.Z = z;
    }

    public static /* synthetic */ void a() {
    }

    public final void c(@NotNull List<? extends KType> list) {
        Intrinsics.p(list, "upperBounds");
        if (this.X2 == null) {
            this.X2 = list;
            return;
        }
        throw new IllegalStateException(("Upper bounds of type parameter '" + this + "' have already been initialized.").toString());
    }

    public boolean e() {
        return this.Z;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof TypeParameterReference) {
            TypeParameterReference typeParameterReference = (TypeParameterReference) obj;
            return Intrinsics.g(this.s, typeParameterReference.s) && Intrinsics.g(getName(), typeParameterReference.getName());
        }
    }

    @NotNull
    public KVariance f() {
        return this.Y;
    }

    @NotNull
    public String getName() {
        return this.X;
    }

    @NotNull
    public List<KType> getUpperBounds() {
        List<? extends KType> list = this.X2;
        if (list != null) {
            return list;
        }
        List<? extends KType> k2 = CollectionsKt.k(Reflection.n(Object.class));
        this.X2 = k2;
        return k2;
    }

    public int hashCode() {
        Object obj = this.s;
        return ((obj != null ? obj.hashCode() : 0) * 31) + getName().hashCode();
    }

    @NotNull
    public String toString() {
        return Y2.a(this);
    }
}
