package androidx.media3.extractor.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.media3.common.Format;
import androidx.media3.common.G;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@UnstableApi
public final class SlowMotionData implements Metadata.Entry {
    public static final Parcelable.Creator<SlowMotionData> CREATOR = new Parcelable.Creator<SlowMotionData>() {
        /* renamed from: a */
        public SlowMotionData createFromParcel(Parcel parcel) {
            ArrayList arrayList = new ArrayList();
            parcel.readList(arrayList, Segment.class.getClassLoader());
            return new SlowMotionData(arrayList);
        }

        /* renamed from: b */
        public SlowMotionData[] newArray(int i2) {
            return new SlowMotionData[i2];
        }
    };
    public final List<Segment> s;

    public static final class Segment implements Parcelable {
        public static final Parcelable.Creator<Segment> CREATOR = new Parcelable.Creator<Segment>() {
            /* renamed from: a */
            public Segment createFromParcel(Parcel parcel) {
                return new Segment(parcel.readLong(), parcel.readLong(), parcel.readInt());
            }

            /* renamed from: b */
            public Segment[] newArray(int i2) {
                return new Segment[i2];
            }
        };
        public static final Comparator<Segment> Z = new a();
        public final long X;
        public final int Y;
        public final long s;

        public Segment(long j2, long j3, int i2) {
            Assertions.a(j2 < j3);
            this.s = j2;
            this.X = j3;
            this.Y = i2;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Segment.class != obj.getClass()) {
                return false;
            }
            Segment segment = (Segment) obj;
            return this.s == segment.s && this.X == segment.X && this.Y == segment.Y;
        }

        public int hashCode() {
            return Objects.b(Long.valueOf(this.s), Long.valueOf(this.X), Integer.valueOf(this.Y));
        }

        public String toString() {
            return Util.S("Segment: startTimeMs=%d, endTimeMs=%d, speedDivisor=%d", Long.valueOf(this.s), Long.valueOf(this.X), Integer.valueOf(this.Y));
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeLong(this.s);
            parcel.writeLong(this.X);
            parcel.writeInt(this.Y);
        }
    }

    public SlowMotionData(List<Segment> list) {
        this.s = list;
        Assertions.a(!a(list));
    }

    private static boolean a(List<Segment> list) {
        if (list.isEmpty()) {
            return false;
        }
        long j2 = list.get(0).X;
        for (int i2 = 1; i2 < list.size(); i2++) {
            if (list.get(i2).s < j2) {
                return true;
            }
            j2 = list.get(i2).X;
        }
        return false;
    }

    public /* synthetic */ byte[] J() {
        return G.a(this);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SlowMotionData.class != obj.getClass()) {
            return false;
        }
        return this.s.equals(((SlowMotionData) obj).s);
    }

    public int hashCode() {
        return this.s.hashCode();
    }

    public /* synthetic */ Format n() {
        return G.b(this);
    }

    public /* synthetic */ void q(MediaMetadata.Builder builder) {
        G.c(this, builder);
    }

    public String toString() {
        return "SlowMotion: segments=" + this.s;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeList(this.s);
    }
}
