package kotlin.random;

import java.util.Random;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0004\u001a\u00020\u0000*\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0010\u0010\u0006\u001a\u00020\u0000H\b¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0000¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lkotlin/random/Random;", "Ljava/util/Random;", "a", "(Lkotlin/random/Random;)Ljava/util/Random;", "b", "(Ljava/util/Random;)Lkotlin/random/Random;", "c", "()Lkotlin/random/Random;", "", "hi26", "low27", "", "d", "(II)D", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0})
public final class PlatformRandomKt {
    @NotNull
    @SinceKotlin(version = "1.3")
    public static final Random a(@NotNull Random random) {
        Random r;
        Intrinsics.p(random, "<this>");
        AbstractPlatformRandom abstractPlatformRandom = random instanceof AbstractPlatformRandom ? (AbstractPlatformRandom) random : null;
        return (abstractPlatformRandom == null || (r = abstractPlatformRandom.r()) == null) ? new KotlinRandom(random) : r;
    }

    @NotNull
    @SinceKotlin(version = "1.3")
    public static final Random b(@NotNull Random random) {
        Random a2;
        Intrinsics.p(random, "<this>");
        KotlinRandom kotlinRandom = random instanceof KotlinRandom ? (KotlinRandom) random : null;
        return (kotlinRandom == null || (a2 = kotlinRandom.a()) == null) ? new PlatformRandom(random) : a2;
    }

    @InlineOnly
    private static final Random c() {
        return PlatformImplementationsKt.f28815a.b();
    }

    public static final double d(int i2, int i3) {
        return ((double) ((((long) i2) << 27) + ((long) i3))) / 9.007199254740992E15d;
    }
}
