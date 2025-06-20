package com.google.firebase.sessions;

import android.os.SystemClock;
import kotlin.Metadata;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0005\u001a\u00020\u0004H\u0016ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078\u0002XT¢\u0006\u0006\n\u0004\b\b\u0010\t\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lcom/google/firebase/sessions/WallClock;", "Lcom/google/firebase/sessions/TimeProvider;", "<init>", "()V", "Lkotlin/time/Duration;", "a", "()J", "", "b", "J", "US_PER_MILLIS", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0})
public final class WallClock implements TimeProvider {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final WallClock f25138a = new WallClock();

    /* renamed from: b  reason: collision with root package name */
    private static final long f25139b = 1000;

    private WallClock() {
    }

    public long a() {
        Duration.Companion companion = Duration.X;
        return DurationKt.n0(SystemClock.elapsedRealtime(), DurationUnit.MILLISECONDS);
    }

    public long b() {
        return System.currentTimeMillis() * 1000;
    }
}
