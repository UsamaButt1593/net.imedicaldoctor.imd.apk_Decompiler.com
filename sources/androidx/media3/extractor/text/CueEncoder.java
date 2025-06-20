package androidx.media3.extractor.text;

import android.os.Bundle;
import android.os.Parcel;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.BundleCollectionUtil;
import androidx.media3.common.util.UnstableApi;
import java.util.ArrayList;
import java.util.List;

@UnstableApi
public final class CueEncoder {
    public byte[] a(List<Cue> list, long j2) {
        ArrayList<Bundle> i2 = BundleCollectionUtil.i(list, new a());
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("c", i2);
        bundle.putLong("d", j2);
        Parcel obtain = Parcel.obtain();
        obtain.writeBundle(bundle);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }
}
