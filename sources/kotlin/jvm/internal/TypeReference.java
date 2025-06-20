package kotlin.jvm.internal;

import com.dd.plist.ASCIIPropertyListParser;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.SinceKotlin;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001b\n\u0002\b\u0007\b\u0007\u0018\u0000 82\u00020\u0001:\u00019B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bB'\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\n\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u0010*\u00020\u0005H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0016X\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00018\u0000X\u0004¢\u0006\u0012\n\u0004\b%\u0010&\u0012\u0004\b)\u0010*\u001a\u0004\b'\u0010(R \u0010\t\u001a\u00020\b8\u0000X\u0004¢\u0006\u0012\n\u0004\b+\u0010,\u0012\u0004\b.\u0010*\u001a\u0004\b-\u0010\u001aR\u001c\u00102\u001a\u00020\u0010*\u0006\u0012\u0002\b\u00030/8BX\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u001a\u00105\u001a\b\u0012\u0004\u0012\u0002030\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b4\u0010$R\u0014\u0010\r\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b6\u00107¨\u0006:"}, d2 = {"Lkotlin/jvm/internal/TypeReference;", "Lkotlin/reflect/KType;", "Lkotlin/reflect/KClassifier;", "classifier", "", "Lkotlin/reflect/KTypeProjection;", "arguments", "platformTypeUpperBound", "", "flags", "<init>", "(Lkotlin/reflect/KClassifier;Ljava/util/List;Lkotlin/reflect/KType;I)V", "", "isMarkedNullable", "(Lkotlin/reflect/KClassifier;Ljava/util/List;Z)V", "convertPrimitiveToWrapper", "", "o", "(Z)Ljava/lang/String;", "f", "(Lkotlin/reflect/KTypeProjection;)Ljava/lang/String;", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "()Ljava/lang/String;", "s", "Lkotlin/reflect/KClassifier;", "f0", "()Lkotlin/reflect/KClassifier;", "X", "Ljava/util/List;", "c0", "()Ljava/util/List;", "Y", "Lkotlin/reflect/KType;", "C", "()Lkotlin/reflect/KType;", "E", "()V", "Z", "I", "u", "A", "Ljava/lang/Class;", "q", "(Ljava/lang/Class;)Ljava/lang/String;", "arrayClassName", "", "getAnnotations", "annotations", "B", "()Z", "X2", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
@SinceKotlin(version = "1.4")
public final class TypeReference implements KType {
    @NotNull
    public static final Companion X2 = new Companion((DefaultConstructorMarker) null);
    public static final int Y2 = 1;
    public static final int Z2 = 2;
    public static final int a3 = 4;
    @NotNull
    private final List<KTypeProjection> X;
    @Nullable
    private final KType Y;
    private final int Z;
    @NotNull
    private final KClassifier s;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lkotlin/jvm/internal/TypeReference$Companion;", "", "()V", "IS_MARKED_NULLABLE", "", "IS_MUTABLE_COLLECTION_TYPE", "IS_NOTHING_TYPE", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f28973a;

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
                f28973a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.jvm.internal.TypeReference.WhenMappings.<clinit>():void");
        }
    }

    @SinceKotlin(version = "1.6")
    public TypeReference(@NotNull KClassifier kClassifier, @NotNull List<KTypeProjection> list, @Nullable KType kType, int i2) {
        Intrinsics.p(kClassifier, "classifier");
        Intrinsics.p(list, "arguments");
        this.s = kClassifier;
        this.X = list;
        this.Y = kType;
        this.Z = i2;
    }

    @SinceKotlin(version = "1.6")
    public static /* synthetic */ void A() {
    }

    @SinceKotlin(version = "1.6")
    public static /* synthetic */ void E() {
    }

    /* access modifiers changed from: private */
    public final String f(KTypeProjection kTypeProjection) {
        String str;
        StringBuilder sb;
        String str2;
        if (kTypeProjection.h() == null) {
            return "*";
        }
        KType g2 = kTypeProjection.g();
        TypeReference typeReference = g2 instanceof TypeReference ? (TypeReference) g2 : null;
        if (typeReference == null || (str = typeReference.o(true)) == null) {
            str = String.valueOf(kTypeProjection.g());
        }
        int i2 = WhenMappings.f28973a[kTypeProjection.h().ordinal()];
        if (i2 == 1) {
            return str;
        }
        if (i2 == 2) {
            sb = new StringBuilder();
            str2 = "in ";
        } else if (i2 == 3) {
            sb = new StringBuilder();
            str2 = "out ";
        } else {
            throw new NoWhenBranchMatchedException();
        }
        sb.append(str2);
        sb.append(str);
        return sb.toString();
    }

    private final String o(boolean z) {
        String str;
        KClassifier f0 = f0();
        Class cls = null;
        KClass kClass = f0 instanceof KClass ? (KClass) f0 : null;
        if (kClass != null) {
            cls = JvmClassMappingKt.e(kClass);
        }
        if (cls == null) {
            str = f0().toString();
        } else if ((this.Z & 4) != 0) {
            str = "kotlin.Nothing";
        } else if (cls.isArray()) {
            str = q(cls);
        } else if (!z || !cls.isPrimitive()) {
            str = cls.getName();
        } else {
            KClassifier f02 = f0();
            Intrinsics.n(f02, "null cannot be cast to non-null type kotlin.reflect.KClass<*>");
            str = JvmClassMappingKt.g((KClass) f02).getName();
        }
        String str2 = "";
        String j3 = c0().isEmpty() ? str2 : CollectionsKt.j3(c0(), ", ", "<", ">", 0, (CharSequence) null, new TypeReference$asString$args$1(this), 24, (Object) null);
        if (B()) {
            str2 = "?";
        }
        String str3 = str + j3 + str2;
        KType kType = this.Y;
        if (!(kType instanceof TypeReference)) {
            return str3;
        }
        String o = ((TypeReference) kType).o(true);
        if (Intrinsics.g(o, str3)) {
            return str3;
        }
        if (Intrinsics.g(o, str3 + '?')) {
            return str3 + '!';
        }
        return ASCIIPropertyListParser.f18649g + str3 + ".." + o + ASCIIPropertyListParser.f18650h;
    }

    private final String q(Class<?> cls) {
        if (Intrinsics.g(cls, boolean[].class)) {
            return "kotlin.BooleanArray";
        }
        if (Intrinsics.g(cls, char[].class)) {
            return "kotlin.CharArray";
        }
        if (Intrinsics.g(cls, byte[].class)) {
            return "kotlin.ByteArray";
        }
        if (Intrinsics.g(cls, short[].class)) {
            return "kotlin.ShortArray";
        }
        if (Intrinsics.g(cls, int[].class)) {
            return "kotlin.IntArray";
        }
        if (Intrinsics.g(cls, float[].class)) {
            return "kotlin.FloatArray";
        }
        if (Intrinsics.g(cls, long[].class)) {
            return "kotlin.LongArray";
        }
        return Intrinsics.g(cls, double[].class) ? "kotlin.DoubleArray" : "kotlin.Array";
    }

    public boolean B() {
        return (this.Z & 1) != 0;
    }

    @Nullable
    public final KType C() {
        return this.Y;
    }

    @NotNull
    public List<KTypeProjection> c0() {
        return this.X;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof TypeReference) {
            TypeReference typeReference = (TypeReference) obj;
            return Intrinsics.g(f0(), typeReference.f0()) && Intrinsics.g(c0(), typeReference.c0()) && Intrinsics.g(this.Y, typeReference.Y) && this.Z == typeReference.Z;
        }
    }

    @NotNull
    public KClassifier f0() {
        return this.s;
    }

    @NotNull
    public List<Annotation> getAnnotations() {
        return CollectionsKt.E();
    }

    public int hashCode() {
        return (((f0().hashCode() * 31) + c0().hashCode()) * 31) + this.Z;
    }

    @NotNull
    public String toString() {
        return o(false) + " (Kotlin reflection is not available)";
    }

    public final int u() {
        return this.Z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TypeReference(@NotNull KClassifier kClassifier, @NotNull List<KTypeProjection> list, boolean z) {
        this(kClassifier, list, (KType) null, z ? 1 : 0);
        Intrinsics.p(kClassifier, "classifier");
        Intrinsics.p(list, "arguments");
    }
}
