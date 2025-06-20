package kotlin.random;

import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lkotlin/random/FallbackThreadLocalRandom;", "Lkotlin/random/AbstractPlatformRandom;", "<init>", "()V", "kotlin/random/FallbackThreadLocalRandom$implStorage$1", "Y", "Lkotlin/random/FallbackThreadLocalRandom$implStorage$1;", "implStorage", "Ljava/util/Random;", "r", "()Ljava/util/Random;", "impl", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public final class FallbackThreadLocalRandom extends AbstractPlatformRandom {
    @NotNull
    private final FallbackThreadLocalRandom$implStorage$1 Y = new FallbackThreadLocalRandom$implStorage$1();

    @NotNull
    public Random r() {
        Object obj = this.Y.get();
        Intrinsics.o(obj, "implStorage.get()");
        return (Random) obj;
    }
}
