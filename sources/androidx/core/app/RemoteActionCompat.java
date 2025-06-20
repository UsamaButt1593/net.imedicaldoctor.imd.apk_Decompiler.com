package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.app.RemoteAction;
import android.graphics.drawable.Icon;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.util.Preconditions;
import androidx.versionedparcelable.VersionedParcelable;

public final class RemoteActionCompat implements VersionedParcelable {
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})

    /* renamed from: a  reason: collision with root package name */
    public IconCompat f5569a;
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})

    /* renamed from: b  reason: collision with root package name */
    public CharSequence f5570b;
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})

    /* renamed from: c  reason: collision with root package name */
    public CharSequence f5571c;
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})

    /* renamed from: d  reason: collision with root package name */
    public PendingIntent f5572d;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})

    /* renamed from: e  reason: collision with root package name */
    public boolean f5573e;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})

    /* renamed from: f  reason: collision with root package name */
    public boolean f5574f;

    @RequiresApi(26)
    static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static RemoteAction a(Icon icon, CharSequence charSequence, CharSequence charSequence2, PendingIntent pendingIntent) {
            return new RemoteAction(icon, charSequence, charSequence2, pendingIntent);
        }

        @DoNotInline
        static PendingIntent b(RemoteAction remoteAction) {
            return remoteAction.getActionIntent();
        }

        @DoNotInline
        static CharSequence c(RemoteAction remoteAction) {
            return remoteAction.getContentDescription();
        }

        @DoNotInline
        static Icon d(RemoteAction remoteAction) {
            return remoteAction.getIcon();
        }

        @DoNotInline
        static CharSequence e(RemoteAction remoteAction) {
            return remoteAction.getTitle();
        }

        @DoNotInline
        static boolean f(RemoteAction remoteAction) {
            return remoteAction.isEnabled();
        }

        @DoNotInline
        static void g(RemoteAction remoteAction, boolean z) {
            remoteAction.setEnabled(z);
        }
    }

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static void a(RemoteAction remoteAction, boolean z) {
            remoteAction.setShouldShowIcon(z);
        }

        @DoNotInline
        static boolean b(RemoteAction remoteAction) {
            return remoteAction.shouldShowIcon();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public RemoteActionCompat() {
    }

    @RequiresApi(26)
    @NonNull
    public static RemoteActionCompat a(@NonNull RemoteAction remoteAction) {
        Preconditions.l(remoteAction);
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat(IconCompat.m(Api26Impl.d(remoteAction)), Api26Impl.e(remoteAction), Api26Impl.c(remoteAction), Api26Impl.b(remoteAction));
        remoteActionCompat.m(Api26Impl.f(remoteAction));
        if (Build.VERSION.SDK_INT >= 28) {
            remoteActionCompat.n(Api28Impl.b(remoteAction));
        }
        return remoteActionCompat;
    }

    @NonNull
    public PendingIntent b() {
        return this.f5572d;
    }

    @NonNull
    public CharSequence c() {
        return this.f5571c;
    }

    @NonNull
    public IconCompat i() {
        return this.f5569a;
    }

    @NonNull
    public CharSequence k() {
        return this.f5570b;
    }

    public boolean l() {
        return this.f5573e;
    }

    public void m(boolean z) {
        this.f5573e = z;
    }

    public void n(boolean z) {
        this.f5574f = z;
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public boolean o() {
        return this.f5574f;
    }

    @RequiresApi(26)
    @NonNull
    public RemoteAction p() {
        RemoteAction a2 = Api26Impl.a(this.f5569a.L(), this.f5570b, this.f5571c, this.f5572d);
        Api26Impl.g(a2, l());
        if (Build.VERSION.SDK_INT >= 28) {
            Api28Impl.a(a2, o());
        }
        return a2;
    }

    public RemoteActionCompat(@NonNull RemoteActionCompat remoteActionCompat) {
        Preconditions.l(remoteActionCompat);
        this.f5569a = remoteActionCompat.f5569a;
        this.f5570b = remoteActionCompat.f5570b;
        this.f5571c = remoteActionCompat.f5571c;
        this.f5572d = remoteActionCompat.f5572d;
        this.f5573e = remoteActionCompat.f5573e;
        this.f5574f = remoteActionCompat.f5574f;
    }

    public RemoteActionCompat(@NonNull IconCompat iconCompat, @NonNull CharSequence charSequence, @NonNull CharSequence charSequence2, @NonNull PendingIntent pendingIntent) {
        this.f5569a = (IconCompat) Preconditions.l(iconCompat);
        this.f5570b = (CharSequence) Preconditions.l(charSequence);
        this.f5571c = (CharSequence) Preconditions.l(charSequence2);
        this.f5572d = (PendingIntent) Preconditions.l(pendingIntent);
        this.f5573e = true;
        this.f5574f = true;
    }
}
