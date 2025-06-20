package androidx.media3.extractor.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.C;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
public final class TimeSignalCommand extends SpliceCommand {
    public static final Parcelable.Creator<TimeSignalCommand> CREATOR = new Parcelable.Creator<TimeSignalCommand>() {
        /* renamed from: a */
        public TimeSignalCommand createFromParcel(Parcel parcel) {
            return new TimeSignalCommand(parcel.readLong(), parcel.readLong());
        }

        /* renamed from: b */
        public TimeSignalCommand[] newArray(int i2) {
            return new TimeSignalCommand[i2];
        }
    };
    public final long X;
    public final long s;

    private TimeSignalCommand(long j2, long j3) {
        this.s = j2;
        this.X = j3;
    }

    static TimeSignalCommand a(ParsableByteArray parsableByteArray, long j2, TimestampAdjuster timestampAdjuster) {
        long b2 = b(parsableByteArray, j2);
        return new TimeSignalCommand(b2, timestampAdjuster.b(b2));
    }

    static long b(ParsableByteArray parsableByteArray, long j2) {
        long L = (long) parsableByteArray.L();
        return (128 & L) != 0 ? 8589934591L & ((((L & 1) << 32) | parsableByteArray.N()) + j2) : C.f9084b;
    }

    public String toString() {
        return "SCTE-35 TimeSignalCommand { ptsTime=" + this.s + ", playbackPositionUs= " + this.X + " }";
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.s);
        parcel.writeLong(this.X);
    }
}
