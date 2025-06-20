package androidx.core.view;

import android.app.Activity;
import android.os.Build;
import android.view.DragAndDropPermissions;
import android.view.DragEvent;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

public final class DragAndDropPermissionsCompat {

    /* renamed from: a  reason: collision with root package name */
    private final DragAndDropPermissions f6376a;

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static void a(DragAndDropPermissions dragAndDropPermissions) {
            dragAndDropPermissions.release();
        }

        @DoNotInline
        static DragAndDropPermissions b(Activity activity, DragEvent dragEvent) {
            return activity.requestDragAndDropPermissions(dragEvent);
        }
    }

    private DragAndDropPermissionsCompat(DragAndDropPermissions dragAndDropPermissions) {
        this.f6376a = dragAndDropPermissions;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static DragAndDropPermissionsCompat b(@NonNull Activity activity, @NonNull DragEvent dragEvent) {
        DragAndDropPermissions b2;
        if (Build.VERSION.SDK_INT < 24 || (b2 = Api24Impl.b(activity, dragEvent)) == null) {
            return null;
        }
        return new DragAndDropPermissionsCompat(b2);
    }

    public void a() {
        if (Build.VERSION.SDK_INT >= 24) {
            Api24Impl.a(this.f6376a);
        }
    }
}
