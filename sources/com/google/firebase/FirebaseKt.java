package com.google.firebase;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.components.Component;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import java.lang.annotation.Annotation;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\b\u001a\u0004\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t\u001a!\u0010\f\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\r\u001a)\u0010\u000e\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u000e\u0010\u000f\u001a\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\"\n\b\u0000\u0010\u0011\u0018\u0001*\u00020\u0010H\b¢\u0006\u0004\b\u0014\u0010\u0015\"\u0015\u0010\u0018\u001a\u00020\u0003*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\"\u0015\u0010\u000b\u001a\u00020\n*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/google/firebase/Firebase;", "", "name", "Lcom/google/firebase/FirebaseApp;", "a", "(Lcom/google/firebase/Firebase;Ljava/lang/String;)Lcom/google/firebase/FirebaseApp;", "Landroid/content/Context;", "context", "e", "(Lcom/google/firebase/Firebase;Landroid/content/Context;)Lcom/google/firebase/FirebaseApp;", "Lcom/google/firebase/FirebaseOptions;", "options", "f", "(Lcom/google/firebase/Firebase;Landroid/content/Context;Lcom/google/firebase/FirebaseOptions;)Lcom/google/firebase/FirebaseApp;", "g", "(Lcom/google/firebase/Firebase;Landroid/content/Context;Lcom/google/firebase/FirebaseOptions;Ljava/lang/String;)Lcom/google/firebase/FirebaseApp;", "", "T", "Lcom/google/firebase/components/Component;", "Lkotlinx/coroutines/CoroutineDispatcher;", "b", "()Lcom/google/firebase/components/Component;", "c", "(Lcom/google/firebase/Firebase;)Lcom/google/firebase/FirebaseApp;", "app", "d", "(Lcom/google/firebase/Firebase;)Lcom/google/firebase/FirebaseOptions;", "com.google.firebase-firebase-common"}, k = 2, mv = {1, 8, 0})
public final class FirebaseKt {
    @NotNull
    public static final FirebaseApp a(@NotNull Firebase firebase, @NotNull String str) {
        Intrinsics.p(firebase, "<this>");
        Intrinsics.p(str, "name");
        FirebaseApp q = FirebaseApp.q(str);
        Intrinsics.o(q, "getInstance(name)");
        return q;
    }

    private static final /* synthetic */ <T extends Annotation> Component<CoroutineDispatcher> b() {
        Intrinsics.y(4, ExifInterface.d5);
        Class<Annotation> cls = Annotation.class;
        Component.Builder<Annotation> f2 = Component.f(Qualified.a(cls, CoroutineDispatcher.class));
        Intrinsics.y(4, ExifInterface.d5);
        Component.Builder<Annotation> b2 = f2.b(Dependency.l(Qualified.a(cls, Executor.class)));
        Intrinsics.w();
        Component<Annotation> d2 = b2.f(FirebaseKt$coroutineDispatcher$1.f23320a).d();
        Intrinsics.o(d2, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        return d2;
    }

    @NotNull
    public static final FirebaseApp c(@NotNull Firebase firebase) {
        Intrinsics.p(firebase, "<this>");
        FirebaseApp p = FirebaseApp.p();
        Intrinsics.o(p, "getInstance()");
        return p;
    }

    @NotNull
    public static final FirebaseOptions d(@NotNull Firebase firebase) {
        Intrinsics.p(firebase, "<this>");
        FirebaseOptions s = c(Firebase.f23274a).s();
        Intrinsics.o(s, "Firebase.app.options");
        return s;
    }

    @Nullable
    public static final FirebaseApp e(@NotNull Firebase firebase, @NotNull Context context) {
        Intrinsics.p(firebase, "<this>");
        Intrinsics.p(context, "context");
        return FirebaseApp.x(context);
    }

    @NotNull
    public static final FirebaseApp f(@NotNull Firebase firebase, @NotNull Context context, @NotNull FirebaseOptions firebaseOptions) {
        Intrinsics.p(firebase, "<this>");
        Intrinsics.p(context, "context");
        Intrinsics.p(firebaseOptions, "options");
        FirebaseApp y = FirebaseApp.y(context, firebaseOptions);
        Intrinsics.o(y, "initializeApp(context, options)");
        return y;
    }

    @NotNull
    public static final FirebaseApp g(@NotNull Firebase firebase, @NotNull Context context, @NotNull FirebaseOptions firebaseOptions, @NotNull String str) {
        Intrinsics.p(firebase, "<this>");
        Intrinsics.p(context, "context");
        Intrinsics.p(firebaseOptions, "options");
        Intrinsics.p(str, "name");
        FirebaseApp z = FirebaseApp.z(context, firebaseOptions, str);
        Intrinsics.o(z, "initializeApp(context, options, name)");
        return z;
    }
}
