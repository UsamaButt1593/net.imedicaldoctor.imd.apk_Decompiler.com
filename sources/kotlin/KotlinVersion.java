package kotlin;

import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.apache.commons.lang3.ClassUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SinceKotlin(version = "1.1")
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0007\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001%B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\bJ'\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018J%\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0014R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001c\u001a\u0004\b\u001f\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b \u0010\u001c\u001a\u0004\b!\u0010\u0014R\u0014\u0010#\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u001c¨\u0006&"}, d2 = {"Lkotlin/KotlinVersion;", "", "", "major", "minor", "patch", "<init>", "(III)V", "(II)V", "h", "(III)I", "", "toString", "()Ljava/lang/String;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "a", "(Lkotlin/KotlinVersion;)I", "f", "(II)Z", "g", "(III)Z", "s", "I", "b", "X", "c", "Y", "e", "Z", "version", "X2", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public final class KotlinVersion implements Comparable<KotlinVersion> {
    @NotNull
    public static final Companion X2 = new Companion((DefaultConstructorMarker) null);
    public static final int Y2 = 255;
    @NotNull
    @JvmField
    public static final KotlinVersion Z2 = KotlinVersionCurrentValue.a();
    private final int X;
    private final int Y;
    private final int Z;
    private final int s;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lkotlin/KotlinVersion$Companion;", "", "()V", "CURRENT", "Lkotlin/KotlinVersion;", "MAX_COMPONENT_VALUE", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public KotlinVersion(int i2, int i3) {
        this(i2, i3, 0);
    }

    private final int h(int i2, int i3, int i4) {
        if (new IntRange(0, 255).q(i2) && new IntRange(0, 255).q(i3) && new IntRange(0, 255).q(i4)) {
            return (i2 << 16) + (i3 << 8) + i4;
        }
        throw new IllegalArgumentException(("Version components are out of range: " + i2 + ClassUtils.PACKAGE_SEPARATOR_CHAR + i3 + ClassUtils.PACKAGE_SEPARATOR_CHAR + i4).toString());
    }

    /* renamed from: a */
    public int compareTo(@NotNull KotlinVersion kotlinVersion) {
        Intrinsics.p(kotlinVersion, "other");
        return this.Z - kotlinVersion.Z;
    }

    public final int b() {
        return this.s;
    }

    public final int c() {
        return this.X;
    }

    public final int e() {
        return this.Y;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        KotlinVersion kotlinVersion = obj instanceof KotlinVersion ? (KotlinVersion) obj : null;
        return kotlinVersion != null && this.Z == kotlinVersion.Z;
    }

    public final boolean f(int i2, int i3) {
        int i4 = this.s;
        return i4 > i2 || (i4 == i2 && this.X >= i3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
        r2 = r1.X;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean g(int r2, int r3, int r4) {
        /*
            r1 = this;
            int r0 = r1.s
            if (r0 > r2) goto L_0x0013
            if (r0 != r2) goto L_0x0011
            int r2 = r1.X
            if (r2 > r3) goto L_0x0013
            if (r2 != r3) goto L_0x0011
            int r2 = r1.Y
            if (r2 < r4) goto L_0x0011
            goto L_0x0013
        L_0x0011:
            r2 = 0
            goto L_0x0014
        L_0x0013:
            r2 = 1
        L_0x0014:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.KotlinVersion.g(int, int, int):boolean");
    }

    public int hashCode() {
        return this.Z;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.s);
        sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
        sb.append(this.X);
        sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
        sb.append(this.Y);
        return sb.toString();
    }

    public KotlinVersion(int i2, int i3, int i4) {
        this.s = i2;
        this.X = i3;
        this.Y = i4;
        this.Z = h(i2, i3, i4);
    }
}
