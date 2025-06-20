package com.google.firebase.crashlytics;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/google/firebase/crashlytics/KeyValueBuilder;", "", "Lcom/google/firebase/crashlytics/FirebaseCrashlytics;", "crashlytics", "<init>", "(Lcom/google/firebase/crashlytics/FirebaseCrashlytics;)V", "", "key", "", "value", "", "f", "(Ljava/lang/String;Z)V", "", "a", "(Ljava/lang/String;D)V", "", "b", "(Ljava/lang/String;F)V", "", "c", "(Ljava/lang/String;I)V", "", "d", "(Ljava/lang/String;J)V", "e", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/google/firebase/crashlytics/FirebaseCrashlytics;", "com.google.firebase-firebase-crashlytics"}, k = 1, mv = {1, 8, 0})
public final class KeyValueBuilder {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final FirebaseCrashlytics f23485a;

    public KeyValueBuilder(@NotNull FirebaseCrashlytics firebaseCrashlytics) {
        Intrinsics.p(firebaseCrashlytics, "crashlytics");
        this.f23485a = firebaseCrashlytics;
    }

    public final void a(@NotNull String str, double d2) {
        Intrinsics.p(str, "key");
        this.f23485a.k(str, d2);
    }

    public final void b(@NotNull String str, float f2) {
        Intrinsics.p(str, "key");
        this.f23485a.l(str, f2);
    }

    public final void c(@NotNull String str, int i2) {
        Intrinsics.p(str, "key");
        this.f23485a.m(str, i2);
    }

    public final void d(@NotNull String str, long j2) {
        Intrinsics.p(str, "key");
        this.f23485a.n(str, j2);
    }

    public final void e(@NotNull String str, @NotNull String str2) {
        Intrinsics.p(str, "key");
        Intrinsics.p(str2, "value");
        this.f23485a.o(str, str2);
    }

    public final void f(@NotNull String str, boolean z) {
        Intrinsics.p(str, "key");
        this.f23485a.p(str, z);
    }
}
