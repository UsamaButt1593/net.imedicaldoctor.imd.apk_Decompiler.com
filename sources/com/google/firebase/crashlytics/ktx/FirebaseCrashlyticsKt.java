package com.google.firebase.crashlytics.ktx;

import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.ktx.Firebase;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a,\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\"\u0015\u0010\u000b\u001a\u00020\u0000*\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/google/firebase/crashlytics/FirebaseCrashlytics;", "Lkotlin/Function1;", "Lcom/google/firebase/crashlytics/ktx/KeyValueBuilder;", "", "Lkotlin/ExtensionFunctionType;", "init", "b", "(Lcom/google/firebase/crashlytics/FirebaseCrashlytics;Lkotlin/jvm/functions/Function1;)V", "Lcom/google/firebase/ktx/Firebase;", "a", "(Lcom/google/firebase/ktx/Firebase;)Lcom/google/firebase/crashlytics/FirebaseCrashlytics;", "crashlytics", "com.google.firebase-firebase-crashlytics"}, k = 2, mv = {1, 8, 0})
public final class FirebaseCrashlyticsKt {
    @NotNull
    public static final FirebaseCrashlytics a(@NotNull Firebase firebase) {
        Intrinsics.p(firebase, "<this>");
        FirebaseCrashlytics d2 = FirebaseCrashlytics.d();
        Intrinsics.o(d2, "getInstance()");
        return d2;
    }

    @Deprecated(message = "Migrate to use the KTX API from the main module: https://firebase.google.com/docs/android/kotlin-migration.", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public static final void b(@NotNull FirebaseCrashlytics firebaseCrashlytics, @NotNull Function1<? super KeyValueBuilder, Unit> function1) {
        Intrinsics.p(firebaseCrashlytics, "<this>");
        Intrinsics.p(function1, "init");
        function1.f(new KeyValueBuilder(firebaseCrashlytics));
    }
}
