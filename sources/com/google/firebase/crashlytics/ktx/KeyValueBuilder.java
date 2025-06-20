package com.google.firebase.crashlytics.ktx;

import com.google.firebase.crashlytics.FirebaseCrashlytics;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0016H\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/google/firebase/crashlytics/ktx/KeyValueBuilder;", "", "Lcom/google/firebase/crashlytics/FirebaseCrashlytics;", "crashlytics", "<init>", "(Lcom/google/firebase/crashlytics/FirebaseCrashlytics;)V", "", "key", "", "value", "", "f", "(Ljava/lang/String;Z)V", "", "a", "(Ljava/lang/String;D)V", "", "b", "(Ljava/lang/String;F)V", "", "c", "(Ljava/lang/String;I)V", "", "d", "(Ljava/lang/String;J)V", "e", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/google/firebase/crashlytics/FirebaseCrashlytics;", "com.google.firebase-firebase-crashlytics"}, k = 1, mv = {1, 8, 0})
@Deprecated(message = "Use `com.google.firebase.crashlytics.KeyValueBuilder` from the main module.")
public final class KeyValueBuilder {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final FirebaseCrashlytics f24321a;

    public KeyValueBuilder(@NotNull FirebaseCrashlytics firebaseCrashlytics) {
        Intrinsics.p(firebaseCrashlytics, "crashlytics");
        this.f24321a = firebaseCrashlytics;
    }

    @Deprecated(message = "Use `com.google.firebase.crashlytics.KeyValueBuilder.key(key, value)` from the main module.", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public final void a(@NotNull String str, double d2) {
        Intrinsics.p(str, "key");
        this.f24321a.k(str, d2);
    }

    @Deprecated(message = "Use `com.google.firebase.crashlytics.KeyValueBuilder.key(key, value)` from the main module.", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public final void b(@NotNull String str, float f2) {
        Intrinsics.p(str, "key");
        this.f24321a.l(str, f2);
    }

    @Deprecated(message = "Use `com.google.firebase.crashlytics.KeyValueBuilder.key(key, value)` from the main module.", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public final void c(@NotNull String str, int i2) {
        Intrinsics.p(str, "key");
        this.f24321a.m(str, i2);
    }

    @Deprecated(message = "Use `com.google.firebase.crashlytics.KeyValueBuilder.key(key, value)` from the main module.", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public final void d(@NotNull String str, long j2) {
        Intrinsics.p(str, "key");
        this.f24321a.n(str, j2);
    }

    @Deprecated(message = "Use `com.google.firebase.crashlytics.KeyValueBuilder.key(key, value)` from the main module.", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public final void e(@NotNull String str, @NotNull String str2) {
        Intrinsics.p(str, "key");
        Intrinsics.p(str2, "value");
        this.f24321a.o(str, str2);
    }

    @Deprecated(message = "Use `com.google.firebase.crashlytics.KeyValueBuilder.key(key, value)` from the main module.", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public final void f(@NotNull String str, boolean z) {
        Intrinsics.p(str, "key");
        this.f24321a.p(str, z);
    }
}
