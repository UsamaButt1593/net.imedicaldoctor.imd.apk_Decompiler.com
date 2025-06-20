package com.google.android.material.sidesheet;

import androidx.annotation.RestrictTo;
import com.google.android.material.motion.MaterialBackHandler;
import com.google.android.material.sidesheet.SheetCallback;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

interface Sheet<C extends SheetCallback> extends MaterialBackHandler {
    public static final int e0 = 1;
    public static final int f0 = 2;
    public static final int g0 = 3;
    public static final int h0 = 5;
    public static final int i0 = 0;
    public static final int j0 = 1;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface SheetEdge {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface SheetState {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface StableSheetState {
    }

    void a(C c2);

    void b(int i2);

    void f(C c2);

    int getState();
}
