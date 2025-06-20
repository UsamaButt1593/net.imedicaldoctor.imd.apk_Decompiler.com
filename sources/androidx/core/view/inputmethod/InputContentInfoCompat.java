package androidx.core.view.inputmethod;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.view.inputmethod.InputContentInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public final class InputContentInfoCompat {

    /* renamed from: a  reason: collision with root package name */
    private final InputContentInfoCompatImpl f6733a;

    @RequiresApi(25)
    private static final class InputContentInfoCompatApi25Impl implements InputContentInfoCompatImpl {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        final InputContentInfo f6734a;

        InputContentInfoCompatApi25Impl(@NonNull Uri uri, @NonNull ClipDescription clipDescription, @Nullable Uri uri2) {
            this.f6734a = new InputContentInfo(uri, clipDescription, uri2);
        }

        @Nullable
        public Uri a() {
            return this.f6734a.getLinkUri();
        }

        @NonNull
        public ClipDescription b() {
            return this.f6734a.getDescription();
        }

        @NonNull
        public Uri c() {
            return this.f6734a.getContentUri();
        }

        public void d() {
            this.f6734a.requestPermission();
        }

        @NonNull
        public Object e() {
            return this.f6734a;
        }

        public void f() {
            this.f6734a.releasePermission();
        }

        InputContentInfoCompatApi25Impl(@NonNull Object obj) {
            this.f6734a = (InputContentInfo) obj;
        }
    }

    private static final class InputContentInfoCompatBaseImpl implements InputContentInfoCompatImpl {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final Uri f6735a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        private final ClipDescription f6736b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private final Uri f6737c;

        InputContentInfoCompatBaseImpl(@NonNull Uri uri, @NonNull ClipDescription clipDescription, @Nullable Uri uri2) {
            this.f6735a = uri;
            this.f6736b = clipDescription;
            this.f6737c = uri2;
        }

        @Nullable
        public Uri a() {
            return this.f6737c;
        }

        @NonNull
        public ClipDescription b() {
            return this.f6736b;
        }

        @NonNull
        public Uri c() {
            return this.f6735a;
        }

        public void d() {
        }

        @Nullable
        public Object e() {
            return null;
        }

        public void f() {
        }
    }

    private interface InputContentInfoCompatImpl {
        @Nullable
        Uri a();

        @NonNull
        ClipDescription b();

        @NonNull
        Uri c();

        void d();

        @Nullable
        Object e();

        void f();
    }

    public InputContentInfoCompat(@NonNull Uri uri, @NonNull ClipDescription clipDescription, @Nullable Uri uri2) {
        this.f6733a = Build.VERSION.SDK_INT >= 25 ? new InputContentInfoCompatApi25Impl(uri, clipDescription, uri2) : new InputContentInfoCompatBaseImpl(uri, clipDescription, uri2);
    }

    @Nullable
    public static InputContentInfoCompat g(@Nullable Object obj) {
        if (obj != null && Build.VERSION.SDK_INT >= 25) {
            return new InputContentInfoCompat(new InputContentInfoCompatApi25Impl(obj));
        }
        return null;
    }

    @NonNull
    public Uri a() {
        return this.f6733a.c();
    }

    @NonNull
    public ClipDescription b() {
        return this.f6733a.b();
    }

    @Nullable
    public Uri c() {
        return this.f6733a.a();
    }

    public void d() {
        this.f6733a.f();
    }

    public void e() {
        this.f6733a.d();
    }

    @Nullable
    public Object f() {
        return this.f6733a.e();
    }

    private InputContentInfoCompat(@NonNull InputContentInfoCompatImpl inputContentInfoCompatImpl) {
        this.f6733a = inputContentInfoCompatImpl;
    }
}
