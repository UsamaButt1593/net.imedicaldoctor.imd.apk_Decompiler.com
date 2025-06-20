package com.google.firebase.crashlytics.internal.common;

import com.dd.plist.ASCIIPropertyListParser;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ(\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\bJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\bR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0016\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/google/firebase/crashlytics/internal/common/FirebaseInstallationId;", "", "", "fid", "authToken", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "a", "()Ljava/lang/String;", "b", "c", "(Ljava/lang/String;Ljava/lang/String;)Lcom/google/firebase/crashlytics/internal/common/FirebaseInstallationId;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "f", "e", "com.google.firebase-firebase-crashlytics"}, k = 1, mv = {1, 8, 0})
public final class FirebaseInstallationId {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final String f23653a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final String f23654b;

    public FirebaseInstallationId(@Nullable String str, @Nullable String str2) {
        this.f23653a = str;
        this.f23654b = str2;
    }

    public static /* synthetic */ FirebaseInstallationId d(FirebaseInstallationId firebaseInstallationId, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = firebaseInstallationId.f23653a;
        }
        if ((i2 & 2) != 0) {
            str2 = firebaseInstallationId.f23654b;
        }
        return firebaseInstallationId.c(str, str2);
    }

    @Nullable
    public final String a() {
        return this.f23653a;
    }

    @Nullable
    public final String b() {
        return this.f23654b;
    }

    @NotNull
    public final FirebaseInstallationId c(@Nullable String str, @Nullable String str2) {
        return new FirebaseInstallationId(str, str2);
    }

    @Nullable
    public final String e() {
        return this.f23654b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FirebaseInstallationId)) {
            return false;
        }
        FirebaseInstallationId firebaseInstallationId = (FirebaseInstallationId) obj;
        return Intrinsics.g(this.f23653a, firebaseInstallationId.f23653a) && Intrinsics.g(this.f23654b, firebaseInstallationId.f23654b);
    }

    @Nullable
    public final String f() {
        return this.f23653a;
    }

    public int hashCode() {
        String str = this.f23653a;
        int i2 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f23654b;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    @NotNull
    public String toString() {
        return "FirebaseInstallationId(fid=" + this.f23653a + ", authToken=" + this.f23654b + ASCIIPropertyListParser.f18650h;
    }
}
