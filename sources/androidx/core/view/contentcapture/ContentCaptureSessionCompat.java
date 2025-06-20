package androidx.core.view.contentcapture;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.N;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewStructureCompat;
import androidx.core.view.autofill.AutofillIdCompat;
import java.util.List;
import java.util.Objects;

public class ContentCaptureSessionCompat {

    /* renamed from: c  reason: collision with root package name */
    private static final String f6702c = "TREAT_AS_VIEW_TREE_APPEARING";

    /* renamed from: d  reason: collision with root package name */
    private static final String f6703d = "TREAT_AS_VIEW_TREE_APPEARED";

    /* renamed from: a  reason: collision with root package name */
    private final Object f6704a;

    /* renamed from: b  reason: collision with root package name */
    private final View f6705b;

    @RequiresApi(23)
    private static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        static Bundle a(ViewStructure viewStructure) {
            return viewStructure.getExtras();
        }
    }

    @RequiresApi(29)
    private static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static AutofillId a(ContentCaptureSession contentCaptureSession, AutofillId autofillId, long j2) {
            return contentCaptureSession.newAutofillId(autofillId, j2);
        }

        @DoNotInline
        static ViewStructure b(ContentCaptureSession contentCaptureSession, View view) {
            return contentCaptureSession.newViewStructure(view);
        }

        @DoNotInline
        static ViewStructure c(ContentCaptureSession contentCaptureSession, AutofillId autofillId, long j2) {
            return contentCaptureSession.newVirtualViewStructure(autofillId, j2);
        }

        @DoNotInline
        static void d(ContentCaptureSession contentCaptureSession, ViewStructure viewStructure) {
            contentCaptureSession.notifyViewAppeared(viewStructure);
        }

        @DoNotInline
        public static void e(ContentCaptureSession contentCaptureSession, AutofillId autofillId, CharSequence charSequence) {
            contentCaptureSession.notifyViewTextChanged(autofillId, charSequence);
        }

        @DoNotInline
        static void f(ContentCaptureSession contentCaptureSession, AutofillId autofillId, long[] jArr) {
            contentCaptureSession.notifyViewsDisappeared(autofillId, jArr);
        }
    }

    @RequiresApi(34)
    private static class Api34Impl {
        private Api34Impl() {
        }

        @DoNotInline
        static void a(ContentCaptureSession contentCaptureSession, List<ViewStructure> list) {
            contentCaptureSession.notifyViewsAppeared(list);
        }
    }

    @RequiresApi(29)
    private ContentCaptureSessionCompat(@NonNull ContentCaptureSession contentCaptureSession, @NonNull View view) {
        this.f6704a = contentCaptureSession;
        this.f6705b = view;
    }

    @RequiresApi(29)
    @NonNull
    public static ContentCaptureSessionCompat g(@NonNull ContentCaptureSession contentCaptureSession, @NonNull View view) {
        return new ContentCaptureSessionCompat(contentCaptureSession, view);
    }

    @Nullable
    public AutofillId a(long j2) {
        if (Build.VERSION.SDK_INT < 29) {
            return null;
        }
        ContentCaptureSession a2 = a.a(this.f6704a);
        AutofillIdCompat M = ViewCompat.M(this.f6705b);
        Objects.requireNonNull(M);
        return Api29Impl.a(a2, M.a(), j2);
    }

    @Nullable
    public ViewStructureCompat b(@NonNull AutofillId autofillId, long j2) {
        if (Build.VERSION.SDK_INT >= 29) {
            return ViewStructureCompat.f(Api29Impl.c(a.a(this.f6704a), autofillId, j2));
        }
        return null;
    }

    public void c(@NonNull AutofillId autofillId, @Nullable CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.e(a.a(this.f6704a), autofillId, charSequence);
        }
    }

    public void d(@NonNull List<ViewStructure> list) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 34) {
            Api34Impl.a(a.a(this.f6704a), list);
        } else if (i2 >= 29) {
            ViewStructure b2 = Api29Impl.b(a.a(this.f6704a), this.f6705b);
            Api23Impl.a(b2).putBoolean(f6702c, true);
            Api29Impl.d(a.a(this.f6704a), b2);
            for (int i3 = 0; i3 < list.size(); i3++) {
                Api29Impl.d(a.a(this.f6704a), N.a(list.get(i3)));
            }
            ViewStructure b3 = Api29Impl.b(a.a(this.f6704a), this.f6705b);
            Api23Impl.a(b3).putBoolean(f6703d, true);
            Api29Impl.d(a.a(this.f6704a), b3);
        }
    }

    public void e(@NonNull long[] jArr) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 34) {
            ContentCaptureSession a2 = a.a(this.f6704a);
            AutofillIdCompat M = ViewCompat.M(this.f6705b);
            Objects.requireNonNull(M);
            Api29Impl.f(a2, M.a(), jArr);
        } else if (i2 >= 29) {
            ViewStructure b2 = Api29Impl.b(a.a(this.f6704a), this.f6705b);
            Api23Impl.a(b2).putBoolean(f6702c, true);
            Api29Impl.d(a.a(this.f6704a), b2);
            ContentCaptureSession a3 = a.a(this.f6704a);
            AutofillIdCompat M2 = ViewCompat.M(this.f6705b);
            Objects.requireNonNull(M2);
            Api29Impl.f(a3, M2.a(), jArr);
            ViewStructure b3 = Api29Impl.b(a.a(this.f6704a), this.f6705b);
            Api23Impl.a(b3).putBoolean(f6703d, true);
            Api29Impl.d(a.a(this.f6704a), b3);
        }
    }

    @RequiresApi(29)
    @NonNull
    public ContentCaptureSession f() {
        return a.a(this.f6704a);
    }
}
