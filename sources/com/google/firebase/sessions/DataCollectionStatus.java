package com.google.firebase.sessions;

import com.dd.plist.ASCIIPropertyListParser;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0010\u0010\f\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u001a\u001a\u0004\b\u001b\u0010\nR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001c\u0010\nR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\f\u0010\u001d\u001a\u0004\b\u001e\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/google/firebase/sessions/DataCollectionStatus;", "", "Lcom/google/firebase/sessions/DataCollectionState;", "performance", "crashlytics", "", "sessionSamplingRate", "<init>", "(Lcom/google/firebase/sessions/DataCollectionState;Lcom/google/firebase/sessions/DataCollectionState;D)V", "a", "()Lcom/google/firebase/sessions/DataCollectionState;", "b", "c", "()D", "d", "(Lcom/google/firebase/sessions/DataCollectionState;Lcom/google/firebase/sessions/DataCollectionState;D)Lcom/google/firebase/sessions/DataCollectionStatus;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/google/firebase/sessions/DataCollectionState;", "g", "f", "D", "h", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0})
public final class DataCollectionStatus {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final DataCollectionState f25054a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final DataCollectionState f25055b;

    /* renamed from: c  reason: collision with root package name */
    private final double f25056c;

    public DataCollectionStatus() {
        this((DataCollectionState) null, (DataCollectionState) null, 0.0d, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ DataCollectionStatus e(DataCollectionStatus dataCollectionStatus, DataCollectionState dataCollectionState, DataCollectionState dataCollectionState2, double d2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            dataCollectionState = dataCollectionStatus.f25054a;
        }
        if ((i2 & 2) != 0) {
            dataCollectionState2 = dataCollectionStatus.f25055b;
        }
        if ((i2 & 4) != 0) {
            d2 = dataCollectionStatus.f25056c;
        }
        return dataCollectionStatus.d(dataCollectionState, dataCollectionState2, d2);
    }

    @NotNull
    public final DataCollectionState a() {
        return this.f25054a;
    }

    @NotNull
    public final DataCollectionState b() {
        return this.f25055b;
    }

    public final double c() {
        return this.f25056c;
    }

    @NotNull
    public final DataCollectionStatus d(@NotNull DataCollectionState dataCollectionState, @NotNull DataCollectionState dataCollectionState2, double d2) {
        Intrinsics.p(dataCollectionState, "performance");
        Intrinsics.p(dataCollectionState2, "crashlytics");
        return new DataCollectionStatus(dataCollectionState, dataCollectionState2, d2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DataCollectionStatus)) {
            return false;
        }
        DataCollectionStatus dataCollectionStatus = (DataCollectionStatus) obj;
        return this.f25054a == dataCollectionStatus.f25054a && this.f25055b == dataCollectionStatus.f25055b && Double.compare(this.f25056c, dataCollectionStatus.f25056c) == 0;
    }

    @NotNull
    public final DataCollectionState f() {
        return this.f25055b;
    }

    @NotNull
    public final DataCollectionState g() {
        return this.f25054a;
    }

    public final double h() {
        return this.f25056c;
    }

    public int hashCode() {
        return (((this.f25054a.hashCode() * 31) + this.f25055b.hashCode()) * 31) + Double.doubleToLongBits(this.f25056c);
    }

    @NotNull
    public String toString() {
        return "DataCollectionStatus(performance=" + this.f25054a + ", crashlytics=" + this.f25055b + ", sessionSamplingRate=" + this.f25056c + ASCIIPropertyListParser.f18650h;
    }

    public DataCollectionStatus(@NotNull DataCollectionState dataCollectionState, @NotNull DataCollectionState dataCollectionState2, double d2) {
        Intrinsics.p(dataCollectionState, "performance");
        Intrinsics.p(dataCollectionState2, "crashlytics");
        this.f25054a = dataCollectionState;
        this.f25055b = dataCollectionState2;
        this.f25056c = d2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DataCollectionStatus(DataCollectionState dataCollectionState, DataCollectionState dataCollectionState2, double d2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? DataCollectionState.COLLECTION_SDK_NOT_INSTALLED : dataCollectionState, (i2 & 2) != 0 ? DataCollectionState.COLLECTION_SDK_NOT_INSTALLED : dataCollectionState2, (i2 & 4) != 0 ? 1.0d : d2);
    }
}
