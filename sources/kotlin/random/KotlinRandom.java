package kotlin.random;

import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\b\u0002\u0018\u0000 (2\u00020\u0001:\u0001)B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001f\u0010 R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lkotlin/random/KotlinRandom;", "Ljava/util/Random;", "Lkotlin/random/Random;", "impl", "<init>", "(Lkotlin/random/Random;)V", "", "bits", "next", "(I)I", "nextInt", "()I", "bound", "", "nextBoolean", "()Z", "", "nextLong", "()J", "", "nextFloat", "()F", "", "nextDouble", "()D", "", "bytes", "", "nextBytes", "([B)V", "seed", "setSeed", "(J)V", "s", "Lkotlin/random/Random;", "a", "()Lkotlin/random/Random;", "X", "Z", "seedInitialized", "Y", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
final class KotlinRandom extends Random {
    @NotNull
    private static final Companion Y = new Companion((DefaultConstructorMarker) null);
    private static final long Z = 0;
    private boolean X;
    @NotNull
    private final Random s;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lkotlin/random/KotlinRandom$Companion;", "", "()V", "serialVersionUID", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public KotlinRandom(@NotNull Random random) {
        Intrinsics.p(random, "impl");
        this.s = random;
    }

    @NotNull
    public final Random a() {
        return this.s;
    }

    /* access modifiers changed from: protected */
    public int next(int i2) {
        return this.s.b(i2);
    }

    public boolean nextBoolean() {
        return this.s.c();
    }

    public void nextBytes(@NotNull byte[] bArr) {
        Intrinsics.p(bArr, "bytes");
        this.s.e(bArr);
    }

    public double nextDouble() {
        return this.s.h();
    }

    public float nextFloat() {
        return this.s.k();
    }

    public int nextInt() {
        return this.s.l();
    }

    public long nextLong() {
        return this.s.o();
    }

    public void setSeed(long j2) {
        if (!this.X) {
            this.X = true;
            return;
        }
        throw new UnsupportedOperationException("Setting seed is not supported.");
    }

    public int nextInt(int i2) {
        return this.s.m(i2);
    }
}
