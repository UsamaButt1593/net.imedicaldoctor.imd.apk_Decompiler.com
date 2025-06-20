package com.google.firebase.sessions.settings;

import com.dd.plist.ASCIIPropertyListParser;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0012J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015JL\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001e\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010 \u001a\u0004\b!\u0010\u000eR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u000f\u0010\"\u001a\u0004\b#\u0010\u0010R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0011\u0010$\u001a\u0004\b%\u0010\u0012R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0013\u0010$\u001a\u0004\b&\u0010\u0012R\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u0014\u0010'\u001a\u0004\b(\u0010\u0015¨\u0006)"}, d2 = {"Lcom/google/firebase/sessions/settings/SessionConfigs;", "", "", "sessionEnabled", "", "sessionSamplingRate", "", "sessionRestartTimeout", "cacheDuration", "", "cacheUpdatedTime", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;)V", "a", "()Ljava/lang/Boolean;", "b", "()Ljava/lang/Double;", "c", "()Ljava/lang/Integer;", "d", "e", "()Ljava/lang/Long;", "f", "(Ljava/lang/Boolean;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;)Lcom/google/firebase/sessions/settings/SessionConfigs;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Boolean;", "j", "Ljava/lang/Double;", "l", "Ljava/lang/Integer;", "k", "h", "Ljava/lang/Long;", "i", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0})
public final class SessionConfigs {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final Boolean f25167a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final Double f25168b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final Integer f25169c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final Integer f25170d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final Long f25171e;

    public SessionConfigs(@Nullable Boolean bool, @Nullable Double d2, @Nullable Integer num, @Nullable Integer num2, @Nullable Long l2) {
        this.f25167a = bool;
        this.f25168b = d2;
        this.f25169c = num;
        this.f25170d = num2;
        this.f25171e = l2;
    }

    public static /* synthetic */ SessionConfigs g(SessionConfigs sessionConfigs, Boolean bool, Double d2, Integer num, Integer num2, Long l2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bool = sessionConfigs.f25167a;
        }
        if ((i2 & 2) != 0) {
            d2 = sessionConfigs.f25168b;
        }
        Double d3 = d2;
        if ((i2 & 4) != 0) {
            num = sessionConfigs.f25169c;
        }
        Integer num3 = num;
        if ((i2 & 8) != 0) {
            num2 = sessionConfigs.f25170d;
        }
        Integer num4 = num2;
        if ((i2 & 16) != 0) {
            l2 = sessionConfigs.f25171e;
        }
        return sessionConfigs.f(bool, d3, num3, num4, l2);
    }

    @Nullable
    public final Boolean a() {
        return this.f25167a;
    }

    @Nullable
    public final Double b() {
        return this.f25168b;
    }

    @Nullable
    public final Integer c() {
        return this.f25169c;
    }

    @Nullable
    public final Integer d() {
        return this.f25170d;
    }

    @Nullable
    public final Long e() {
        return this.f25171e;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SessionConfigs)) {
            return false;
        }
        SessionConfigs sessionConfigs = (SessionConfigs) obj;
        return Intrinsics.g(this.f25167a, sessionConfigs.f25167a) && Intrinsics.g(this.f25168b, sessionConfigs.f25168b) && Intrinsics.g(this.f25169c, sessionConfigs.f25169c) && Intrinsics.g(this.f25170d, sessionConfigs.f25170d) && Intrinsics.g(this.f25171e, sessionConfigs.f25171e);
    }

    @NotNull
    public final SessionConfigs f(@Nullable Boolean bool, @Nullable Double d2, @Nullable Integer num, @Nullable Integer num2, @Nullable Long l2) {
        return new SessionConfigs(bool, d2, num, num2, l2);
    }

    @Nullable
    public final Integer h() {
        return this.f25170d;
    }

    public int hashCode() {
        Boolean bool = this.f25167a;
        int i2 = 0;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Double d2 = this.f25168b;
        int hashCode2 = (hashCode + (d2 == null ? 0 : d2.hashCode())) * 31;
        Integer num = this.f25169c;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.f25170d;
        int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Long l2 = this.f25171e;
        if (l2 != null) {
            i2 = l2.hashCode();
        }
        return hashCode4 + i2;
    }

    @Nullable
    public final Long i() {
        return this.f25171e;
    }

    @Nullable
    public final Boolean j() {
        return this.f25167a;
    }

    @Nullable
    public final Integer k() {
        return this.f25169c;
    }

    @Nullable
    public final Double l() {
        return this.f25168b;
    }

    @NotNull
    public String toString() {
        return "SessionConfigs(sessionEnabled=" + this.f25167a + ", sessionSamplingRate=" + this.f25168b + ", sessionRestartTimeout=" + this.f25169c + ", cacheDuration=" + this.f25170d + ", cacheUpdatedTime=" + this.f25171e + ASCIIPropertyListParser.f18650h;
    }
}
