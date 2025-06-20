package com.google.firebase.sessions;

import com.dd.plist.ASCIIPropertyListParser;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0019\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J8\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\fJ\u0010\u0010\u0015\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000eJ\u001a\u0010\u0017\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\u000eR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001b\u001a\u0004\b\u001d\u0010\u000eR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b\u001f\u0010\u0011¨\u0006 "}, d2 = {"Lcom/google/firebase/sessions/ProcessDetails;", "", "", "processName", "", "pid", "importance", "", "isDefaultProcess", "<init>", "(Ljava/lang/String;IIZ)V", "a", "()Ljava/lang/String;", "b", "()I", "c", "d", "()Z", "e", "(Ljava/lang/String;IIZ)Lcom/google/firebase/sessions/ProcessDetails;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "i", "I", "h", "g", "Z", "j", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0})
public final class ProcessDetails {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final String f25070a;

    /* renamed from: b  reason: collision with root package name */
    private final int f25071b;

    /* renamed from: c  reason: collision with root package name */
    private final int f25072c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f25073d;

    public ProcessDetails(@NotNull String str, int i2, int i3, boolean z) {
        Intrinsics.p(str, "processName");
        this.f25070a = str;
        this.f25071b = i2;
        this.f25072c = i3;
        this.f25073d = z;
    }

    public static /* synthetic */ ProcessDetails f(ProcessDetails processDetails, String str, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = processDetails.f25070a;
        }
        if ((i4 & 2) != 0) {
            i2 = processDetails.f25071b;
        }
        if ((i4 & 4) != 0) {
            i3 = processDetails.f25072c;
        }
        if ((i4 & 8) != 0) {
            z = processDetails.f25073d;
        }
        return processDetails.e(str, i2, i3, z);
    }

    @NotNull
    public final String a() {
        return this.f25070a;
    }

    public final int b() {
        return this.f25071b;
    }

    public final int c() {
        return this.f25072c;
    }

    public final boolean d() {
        return this.f25073d;
    }

    @NotNull
    public final ProcessDetails e(@NotNull String str, int i2, int i3, boolean z) {
        Intrinsics.p(str, "processName");
        return new ProcessDetails(str, i2, i3, z);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProcessDetails)) {
            return false;
        }
        ProcessDetails processDetails = (ProcessDetails) obj;
        return Intrinsics.g(this.f25070a, processDetails.f25070a) && this.f25071b == processDetails.f25071b && this.f25072c == processDetails.f25072c && this.f25073d == processDetails.f25073d;
    }

    public final int g() {
        return this.f25072c;
    }

    public final int h() {
        return this.f25071b;
    }

    public int hashCode() {
        int hashCode = ((((this.f25070a.hashCode() * 31) + this.f25071b) * 31) + this.f25072c) * 31;
        boolean z = this.f25073d;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    @NotNull
    public final String i() {
        return this.f25070a;
    }

    public final boolean j() {
        return this.f25073d;
    }

    @NotNull
    public String toString() {
        return "ProcessDetails(processName=" + this.f25070a + ", pid=" + this.f25071b + ", importance=" + this.f25072c + ", isDefaultProcess=" + this.f25073d + ASCIIPropertyListParser.f18650h;
    }
}
