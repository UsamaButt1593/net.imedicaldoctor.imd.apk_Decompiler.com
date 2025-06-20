package com.google.firebase.installations.ktx;

import com.google.firebase.FirebaseApp;
import com.google.firebase.installations.FirebaseInstallations;
import com.google.firebase.ktx.Firebase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\"\u0015\u0010\b\u001a\u00020\u0003*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/google/firebase/ktx/Firebase;", "Lcom/google/firebase/FirebaseApp;", "app", "Lcom/google/firebase/installations/FirebaseInstallations;", "b", "(Lcom/google/firebase/ktx/Firebase;Lcom/google/firebase/FirebaseApp;)Lcom/google/firebase/installations/FirebaseInstallations;", "a", "(Lcom/google/firebase/ktx/Firebase;)Lcom/google/firebase/installations/FirebaseInstallations;", "installations", "com.google.firebase-firebase-installations"}, k = 2, mv = {1, 8, 0})
public final class InstallationsKt {
    @NotNull
    public static final FirebaseInstallations a(@NotNull Firebase firebase) {
        Intrinsics.p(firebase, "<this>");
        FirebaseInstallations u = FirebaseInstallations.u();
        Intrinsics.o(u, "getInstance()");
        return u;
    }

    @NotNull
    public static final FirebaseInstallations b(@NotNull Firebase firebase, @NotNull FirebaseApp firebaseApp) {
        Intrinsics.p(firebase, "<this>");
        Intrinsics.p(firebaseApp, "app");
        FirebaseInstallations v = FirebaseInstallations.v(firebaseApp);
        Intrinsics.o(v, "getInstance(app)");
        return v;
    }
}
