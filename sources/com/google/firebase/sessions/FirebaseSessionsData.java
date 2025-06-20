package com.google.firebase.sessions;

import com.dd.plist.ASCIIPropertyListParser;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0007J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/google/firebase/sessions/FirebaseSessionsData;", "", "", "sessionId", "<init>", "(Ljava/lang/String;)V", "a", "()Ljava/lang/String;", "b", "(Ljava/lang/String;)Lcom/google/firebase/sessions/FirebaseSessionsData;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "d", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0})
public final class FirebaseSessionsData {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final String f25065a;

    public FirebaseSessionsData(@Nullable String str) {
        this.f25065a = str;
    }

    public static /* synthetic */ FirebaseSessionsData c(FirebaseSessionsData firebaseSessionsData, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = firebaseSessionsData.f25065a;
        }
        return firebaseSessionsData.b(str);
    }

    @Nullable
    public final String a() {
        return this.f25065a;
    }

    @NotNull
    public final FirebaseSessionsData b(@Nullable String str) {
        return new FirebaseSessionsData(str);
    }

    @Nullable
    public final String d() {
        return this.f25065a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FirebaseSessionsData) && Intrinsics.g(this.f25065a, ((FirebaseSessionsData) obj).f25065a);
    }

    public int hashCode() {
        String str = this.f25065a;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    @NotNull
    public String toString() {
        return "FirebaseSessionsData(sessionId=" + this.f25065a + ASCIIPropertyListParser.f18650h;
    }
}
