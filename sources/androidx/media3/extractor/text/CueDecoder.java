package androidx.media3.extractor.text;

import android.os.Bundle;
import android.os.Parcel;
import androidx.media3.common.text.c;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.BundleCollectionUtil;
import androidx.media3.common.util.UnstableApi;
import java.util.ArrayList;

@UnstableApi
public final class CueDecoder {

    /* renamed from: a  reason: collision with root package name */
    static final String f13766a = "c";

    /* renamed from: b  reason: collision with root package name */
    static final String f13767b = "d";

    public CuesWithTiming a(long j2, byte[] bArr) {
        return b(j2, bArr, 0, bArr.length);
    }

    public CuesWithTiming b(long j2, byte[] bArr, int i2, int i3) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, i2, i3);
        obtain.setDataPosition(0);
        Bundle readBundle = obtain.readBundle(Bundle.class.getClassLoader());
        obtain.recycle();
        return new CuesWithTiming(BundleCollectionUtil.d(new c(), (ArrayList) Assertions.g(readBundle.getParcelableArrayList(f13766a))), j2, readBundle.getLong("d"));
    }
}
