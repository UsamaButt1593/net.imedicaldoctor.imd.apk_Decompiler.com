package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcel;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public class IconCompatParcelizer {
    public static IconCompat read(VersionedParcel versionedParcel) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f5902a = versionedParcel.M(iconCompat.f5902a, 1);
        iconCompat.f5904c = versionedParcel.t(iconCompat.f5904c, 2);
        iconCompat.f5905d = versionedParcel.W(iconCompat.f5905d, 3);
        iconCompat.f5906e = versionedParcel.M(iconCompat.f5906e, 4);
        iconCompat.f5907f = versionedParcel.M(iconCompat.f5907f, 5);
        iconCompat.f5908g = (ColorStateList) versionedParcel.W(iconCompat.f5908g, 6);
        iconCompat.f5910i = versionedParcel.d0(iconCompat.f5910i, 7);
        iconCompat.f5911j = versionedParcel.d0(iconCompat.f5911j, 8);
        iconCompat.a();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, VersionedParcel versionedParcel) {
        versionedParcel.j0(true, true);
        iconCompat.b(versionedParcel.i());
        int i2 = iconCompat.f5902a;
        if (-1 != i2) {
            versionedParcel.M0(i2, 1);
        }
        byte[] bArr = iconCompat.f5904c;
        if (bArr != null) {
            versionedParcel.u0(bArr, 2);
        }
        Parcelable parcelable = iconCompat.f5905d;
        if (parcelable != null) {
            versionedParcel.X0(parcelable, 3);
        }
        int i3 = iconCompat.f5906e;
        if (i3 != 0) {
            versionedParcel.M0(i3, 4);
        }
        int i4 = iconCompat.f5907f;
        if (i4 != 0) {
            versionedParcel.M0(i4, 5);
        }
        ColorStateList colorStateList = iconCompat.f5908g;
        if (colorStateList != null) {
            versionedParcel.X0(colorStateList, 6);
        }
        String str = iconCompat.f5910i;
        if (str != null) {
            versionedParcel.f1(str, 7);
        }
        String str2 = iconCompat.f5911j;
        if (str2 != null) {
            versionedParcel.f1(str2, 8);
        }
    }
}
