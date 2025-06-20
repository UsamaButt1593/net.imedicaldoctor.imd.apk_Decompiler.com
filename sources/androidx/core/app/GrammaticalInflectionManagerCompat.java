package androidx.core.app;

import android.app.GrammaticalInflectionManager;
import android.content.Context;
import android.os.Build;
import androidx.annotation.AnyThread;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.os.BuildCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class GrammaticalInflectionManagerCompat {

    /* renamed from: a  reason: collision with root package name */
    public static final int f5257a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f5258b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f5259c = 2;

    /* renamed from: d  reason: collision with root package name */
    public static final int f5260d = 3;

    @RequiresApi(34)
    static class Api34Impl {
        private Api34Impl() {
        }

        @DoNotInline
        static int a(Context context) {
            return b(context).getApplicationGrammaticalGender();
        }

        private static GrammaticalInflectionManager b(Context context) {
            return (GrammaticalInflectionManager) context.getSystemService(GrammaticalInflectionManager.class);
        }

        @DoNotInline
        static void c(Context context, int i2) {
            b(context).setRequestedApplicationGrammaticalGender(i2);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface GrammaticalGender {
    }

    private GrammaticalInflectionManagerCompat() {
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    @AnyThread
    public static int a(@NonNull Context context) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.a(context);
        }
        return 0;
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    @AnyThread
    public static void b(@NonNull Context context, int i2) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34Impl.c(context, i2);
        }
    }
}
