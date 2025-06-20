package com.google.firebase.sessions;

import com.dd.plist.ASCIIPropertyListParser;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000eJ\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u000eJ\u0010\u0010\u0012\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\tHÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015JR\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00072\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\tHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u000eJ\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010 \u001a\u0004\b!\u0010\u000eR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010 \u001a\u0004\b\"\u0010\u000eR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010 \u001a\u0004\b#\u0010\u000eR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010 \u001a\u0004\b$\u0010\u000eR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u0012\u0010%\u001a\u0004\b&\u0010\u0013R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\t8\u0006¢\u0006\f\n\u0004\b\u0014\u0010'\u001a\u0004\b(\u0010\u0015¨\u0006)"}, d2 = {"Lcom/google/firebase/sessions/AndroidApplicationInfo;", "", "", "packageName", "versionName", "appBuildVersion", "deviceManufacturer", "Lcom/google/firebase/sessions/ProcessDetails;", "currentProcessDetails", "", "appProcessDetails", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/firebase/sessions/ProcessDetails;Ljava/util/List;)V", "a", "()Ljava/lang/String;", "b", "c", "d", "e", "()Lcom/google/firebase/sessions/ProcessDetails;", "f", "()Ljava/util/List;", "g", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/firebase/sessions/ProcessDetails;Ljava/util/List;)Lcom/google/firebase/sessions/AndroidApplicationInfo;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "m", "n", "i", "l", "Lcom/google/firebase/sessions/ProcessDetails;", "k", "Ljava/util/List;", "j", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0})
public final class AndroidApplicationInfo {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final String f25001a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final String f25002b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final String f25003c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final String f25004d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final ProcessDetails f25005e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final List<ProcessDetails> f25006f;

    public AndroidApplicationInfo(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull ProcessDetails processDetails, @NotNull List<ProcessDetails> list) {
        Intrinsics.p(str, "packageName");
        Intrinsics.p(str2, "versionName");
        Intrinsics.p(str3, "appBuildVersion");
        Intrinsics.p(str4, "deviceManufacturer");
        Intrinsics.p(processDetails, "currentProcessDetails");
        Intrinsics.p(list, "appProcessDetails");
        this.f25001a = str;
        this.f25002b = str2;
        this.f25003c = str3;
        this.f25004d = str4;
        this.f25005e = processDetails;
        this.f25006f = list;
    }

    public static /* synthetic */ AndroidApplicationInfo h(AndroidApplicationInfo androidApplicationInfo, String str, String str2, String str3, String str4, ProcessDetails processDetails, List<ProcessDetails> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = androidApplicationInfo.f25001a;
        }
        if ((i2 & 2) != 0) {
            str2 = androidApplicationInfo.f25002b;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            str3 = androidApplicationInfo.f25003c;
        }
        String str6 = str3;
        if ((i2 & 8) != 0) {
            str4 = androidApplicationInfo.f25004d;
        }
        String str7 = str4;
        if ((i2 & 16) != 0) {
            processDetails = androidApplicationInfo.f25005e;
        }
        ProcessDetails processDetails2 = processDetails;
        if ((i2 & 32) != 0) {
            list = androidApplicationInfo.f25006f;
        }
        return androidApplicationInfo.g(str, str5, str6, str7, processDetails2, list);
    }

    @NotNull
    public final String a() {
        return this.f25001a;
    }

    @NotNull
    public final String b() {
        return this.f25002b;
    }

    @NotNull
    public final String c() {
        return this.f25003c;
    }

    @NotNull
    public final String d() {
        return this.f25004d;
    }

    @NotNull
    public final ProcessDetails e() {
        return this.f25005e;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AndroidApplicationInfo)) {
            return false;
        }
        AndroidApplicationInfo androidApplicationInfo = (AndroidApplicationInfo) obj;
        return Intrinsics.g(this.f25001a, androidApplicationInfo.f25001a) && Intrinsics.g(this.f25002b, androidApplicationInfo.f25002b) && Intrinsics.g(this.f25003c, androidApplicationInfo.f25003c) && Intrinsics.g(this.f25004d, androidApplicationInfo.f25004d) && Intrinsics.g(this.f25005e, androidApplicationInfo.f25005e) && Intrinsics.g(this.f25006f, androidApplicationInfo.f25006f);
    }

    @NotNull
    public final List<ProcessDetails> f() {
        return this.f25006f;
    }

    @NotNull
    public final AndroidApplicationInfo g(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull ProcessDetails processDetails, @NotNull List<ProcessDetails> list) {
        Intrinsics.p(str, "packageName");
        Intrinsics.p(str2, "versionName");
        Intrinsics.p(str3, "appBuildVersion");
        Intrinsics.p(str4, "deviceManufacturer");
        Intrinsics.p(processDetails, "currentProcessDetails");
        Intrinsics.p(list, "appProcessDetails");
        return new AndroidApplicationInfo(str, str2, str3, str4, processDetails, list);
    }

    public int hashCode() {
        return (((((((((this.f25001a.hashCode() * 31) + this.f25002b.hashCode()) * 31) + this.f25003c.hashCode()) * 31) + this.f25004d.hashCode()) * 31) + this.f25005e.hashCode()) * 31) + this.f25006f.hashCode();
    }

    @NotNull
    public final String i() {
        return this.f25003c;
    }

    @NotNull
    public final List<ProcessDetails> j() {
        return this.f25006f;
    }

    @NotNull
    public final ProcessDetails k() {
        return this.f25005e;
    }

    @NotNull
    public final String l() {
        return this.f25004d;
    }

    @NotNull
    public final String m() {
        return this.f25001a;
    }

    @NotNull
    public final String n() {
        return this.f25002b;
    }

    @NotNull
    public String toString() {
        return "AndroidApplicationInfo(packageName=" + this.f25001a + ", versionName=" + this.f25002b + ", appBuildVersion=" + this.f25003c + ", deviceManufacturer=" + this.f25004d + ", currentProcessDetails=" + this.f25005e + ", appProcessDetails=" + this.f25006f + ASCIIPropertyListParser.f18650h;
    }
}
