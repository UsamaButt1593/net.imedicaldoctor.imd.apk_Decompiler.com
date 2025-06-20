package androidx.media3.extractor.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
public final class SpliceNullCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceNullCommand> CREATOR = new Parcelable.Creator<SpliceNullCommand>() {
        /* renamed from: a */
        public SpliceNullCommand createFromParcel(Parcel parcel) {
            return new SpliceNullCommand();
        }

        /* renamed from: b */
        public SpliceNullCommand[] newArray(int i2) {
            return new SpliceNullCommand[i2];
        }
    };

    public void writeToParcel(Parcel parcel, int i2) {
    }
}
