package kotlin.reflect;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ(\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\fR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001b\u0010\u000e¨\u0006\u001e"}, d2 = {"Lkotlin/reflect/KTypeProjection;", "", "Lkotlin/reflect/KVariance;", "variance", "Lkotlin/reflect/KType;", "type", "<init>", "(Lkotlin/reflect/KVariance;Lkotlin/reflect/KType;)V", "", "toString", "()Ljava/lang/String;", "a", "()Lkotlin/reflect/KVariance;", "b", "()Lkotlin/reflect/KType;", "d", "(Lkotlin/reflect/KVariance;Lkotlin/reflect/KType;)Lkotlin/reflect/KTypeProjection;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lkotlin/reflect/KVariance;", "h", "Lkotlin/reflect/KType;", "g", "c", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
@SinceKotlin(version = "1.1")
public final class KTypeProjection {
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f28988c = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @JvmField

    /* renamed from: d  reason: collision with root package name */
    public static final KTypeProjection f28989d = new KTypeProjection((KVariance) null, (KType) null);
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final KVariance f28990a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final KType f28991b;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\n\u0010\bR\u001a\u0010\u000b\u001a\u00020\u00068\u0000X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u0012\u0004\b\r\u0010\u0003R\u0011\u0010\u0010\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lkotlin/reflect/KTypeProjection$Companion;", "", "<init>", "()V", "Lkotlin/reflect/KType;", "type", "Lkotlin/reflect/KTypeProjection;", "e", "(Lkotlin/reflect/KType;)Lkotlin/reflect/KTypeProjection;", "a", "b", "star", "Lkotlin/reflect/KTypeProjection;", "d", "c", "()Lkotlin/reflect/KTypeProjection;", "STAR", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        private Companion() {
        }

        @PublishedApi
        public static /* synthetic */ void d() {
        }

        @JvmStatic
        @NotNull
        public final KTypeProjection a(@NotNull KType kType) {
            Intrinsics.p(kType, "type");
            return new KTypeProjection(KVariance.IN, kType);
        }

        @JvmStatic
        @NotNull
        public final KTypeProjection b(@NotNull KType kType) {
            Intrinsics.p(kType, "type");
            return new KTypeProjection(KVariance.OUT, kType);
        }

        @NotNull
        public final KTypeProjection c() {
            return KTypeProjection.f28989d;
        }

        @JvmStatic
        @NotNull
        public final KTypeProjection e(@NotNull KType kType) {
            Intrinsics.p(kType, "type");
            return new KTypeProjection(KVariance.INVARIANT, kType);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f28992a;

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
                f28992a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.KTypeProjection.WhenMappings.<clinit>():void");
        }
    }

    public KTypeProjection(@Nullable KVariance kVariance, @Nullable KType kType) {
        String str;
        this.f28990a = kVariance;
        this.f28991b = kType;
        if ((kVariance == null) != (kType == null)) {
            if (kVariance == null) {
                str = "Star projection must have no type specified.";
            } else {
                str = "The projection variance " + kVariance + " requires type to be specified.";
            }
            throw new IllegalArgumentException(str.toString());
        }
    }

    @JvmStatic
    @NotNull
    public static final KTypeProjection c(@NotNull KType kType) {
        return f28988c.a(kType);
    }

    public static /* synthetic */ KTypeProjection e(KTypeProjection kTypeProjection, KVariance kVariance, KType kType, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            kVariance = kTypeProjection.f28990a;
        }
        if ((i2 & 2) != 0) {
            kType = kTypeProjection.f28991b;
        }
        return kTypeProjection.d(kVariance, kType);
    }

    @JvmStatic
    @NotNull
    public static final KTypeProjection f(@NotNull KType kType) {
        return f28988c.b(kType);
    }

    @JvmStatic
    @NotNull
    public static final KTypeProjection i(@NotNull KType kType) {
        return f28988c.e(kType);
    }

    @Nullable
    public final KVariance a() {
        return this.f28990a;
    }

    @Nullable
    public final KType b() {
        return this.f28991b;
    }

    @NotNull
    public final KTypeProjection d(@Nullable KVariance kVariance, @Nullable KType kType) {
        return new KTypeProjection(kVariance, kType);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KTypeProjection)) {
            return false;
        }
        KTypeProjection kTypeProjection = (KTypeProjection) obj;
        return this.f28990a == kTypeProjection.f28990a && Intrinsics.g(this.f28991b, kTypeProjection.f28991b);
    }

    @Nullable
    public final KType g() {
        return this.f28991b;
    }

    @Nullable
    public final KVariance h() {
        return this.f28990a;
    }

    public int hashCode() {
        KVariance kVariance = this.f28990a;
        int i2 = 0;
        int hashCode = (kVariance == null ? 0 : kVariance.hashCode()) * 31;
        KType kType = this.f28991b;
        if (kType != null) {
            i2 = kType.hashCode();
        }
        return hashCode + i2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb;
        String str;
        KVariance kVariance = this.f28990a;
        int i2 = kVariance == null ? -1 : WhenMappings.f28992a[kVariance.ordinal()];
        if (i2 == -1) {
            return "*";
        }
        if (i2 == 1) {
            return String.valueOf(this.f28991b);
        }
        if (i2 == 2) {
            sb = new StringBuilder();
            str = "in ";
        } else if (i2 == 3) {
            sb = new StringBuilder();
            str = "out ";
        } else {
            throw new NoWhenBranchMatchedException();
        }
        sb.append(str);
        sb.append(this.f28991b);
        return sb.toString();
    }
}
