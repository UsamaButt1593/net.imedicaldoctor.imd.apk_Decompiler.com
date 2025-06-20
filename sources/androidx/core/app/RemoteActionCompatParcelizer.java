package androidx.core.app;

import android.app.PendingIntent;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.VersionedParcel;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(VersionedParcel versionedParcel) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f5569a = (IconCompat) versionedParcel.h0(remoteActionCompat.f5569a, 1);
        remoteActionCompat.f5570b = versionedParcel.w(remoteActionCompat.f5570b, 2);
        remoteActionCompat.f5571c = versionedParcel.w(remoteActionCompat.f5571c, 3);
        remoteActionCompat.f5572d = (PendingIntent) versionedParcel.W(remoteActionCompat.f5572d, 4);
        remoteActionCompat.f5573e = versionedParcel.m(remoteActionCompat.f5573e, 5);
        remoteActionCompat.f5574f = versionedParcel.m(remoteActionCompat.f5574f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, VersionedParcel versionedParcel) {
        versionedParcel.j0(false, false);
        versionedParcel.m1(remoteActionCompat.f5569a, 1);
        versionedParcel.z0(remoteActionCompat.f5570b, 2);
        versionedParcel.z0(remoteActionCompat.f5571c, 3);
        versionedParcel.X0(remoteActionCompat.f5572d, 4);
        versionedParcel.n0(remoteActionCompat.f5573e, 5);
        versionedParcel.n0(remoteActionCompat.f5574f, 6);
    }
}
