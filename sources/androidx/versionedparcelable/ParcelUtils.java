package androidx.versionedparcelable;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ParcelUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final String f16405a = "a";

    private ParcelUtils() {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static <T extends VersionedParcelable> T a(InputStream inputStream) {
        return new VersionedParcelStream(inputStream, (OutputStream) null).g0();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static <T extends VersionedParcelable> T b(Parcelable parcelable) {
        if (parcelable instanceof ParcelImpl) {
            return ((ParcelImpl) parcelable).a();
        }
        throw new IllegalArgumentException("Invalid parcel");
    }

    @Nullable
    public static <T extends VersionedParcelable> T c(@NonNull Bundle bundle, @NonNull String str) {
        try {
            Bundle bundle2 = (Bundle) bundle.getParcelable(str);
            if (bundle2 == null) {
                return null;
            }
            bundle2.setClassLoader(ParcelUtils.class.getClassLoader());
            return b(bundle2.getParcelable("a"));
        } catch (RuntimeException unused) {
            return null;
        }
    }

    @Nullable
    public static <T extends VersionedParcelable> List<T> d(Bundle bundle, String str) {
        ArrayList arrayList = new ArrayList();
        try {
            Bundle bundle2 = (Bundle) bundle.getParcelable(str);
            bundle2.setClassLoader(ParcelUtils.class.getClassLoader());
            Iterator it2 = bundle2.getParcelableArrayList("a").iterator();
            while (it2.hasNext()) {
                arrayList.add(b((Parcelable) it2.next()));
            }
            return arrayList;
        } catch (RuntimeException unused) {
            return null;
        }
    }

    public static void e(@NonNull Bundle bundle, @NonNull String str, @Nullable VersionedParcelable versionedParcelable) {
        if (versionedParcelable != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("a", h(versionedParcelable));
            bundle.putParcelable(str, bundle2);
        }
    }

    public static void f(@NonNull Bundle bundle, @NonNull String str, @NonNull List<? extends VersionedParcelable> list) {
        Bundle bundle2 = new Bundle();
        ArrayList arrayList = new ArrayList();
        for (VersionedParcelable h2 : list) {
            arrayList.add(h(h2));
        }
        bundle2.putParcelableArrayList("a", arrayList);
        bundle.putParcelable(str, bundle2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void g(VersionedParcelable versionedParcelable, OutputStream outputStream) {
        VersionedParcelStream versionedParcelStream = new VersionedParcelStream((InputStream) null, outputStream);
        versionedParcelStream.l1(versionedParcelable);
        versionedParcelStream.a();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Parcelable h(VersionedParcelable versionedParcelable) {
        return new ParcelImpl(versionedParcelable);
    }
}
