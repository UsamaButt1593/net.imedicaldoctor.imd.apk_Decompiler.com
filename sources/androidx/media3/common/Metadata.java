package androidx.media3.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.google.common.primitives.Longs;
import java.util.Arrays;
import java.util.List;

@UnstableApi
public final class Metadata implements Parcelable {
    public static final Parcelable.Creator<Metadata> CREATOR = new Parcelable.Creator<Metadata>() {
        /* renamed from: a */
        public Metadata createFromParcel(Parcel parcel) {
            return new Metadata(parcel);
        }

        /* renamed from: b */
        public Metadata[] newArray(int i2) {
            return new Metadata[i2];
        }
    };
    public final long X;
    private final Entry[] s;

    public interface Entry extends Parcelable {
        @Nullable
        byte[] J();

        @Nullable
        Format n();

        void q(MediaMetadata.Builder builder);
    }

    public Metadata(long j2, List<? extends Entry> list) {
        this(j2, (Entry[]) list.toArray(new Entry[0]));
    }

    public Metadata a(Entry... entryArr) {
        return entryArr.length == 0 ? this : new Metadata(this.X, (Entry[]) Util.N1(this.s, entryArr));
    }

    public Metadata b(@Nullable Metadata metadata) {
        return metadata == null ? this : a(metadata.s);
    }

    public Metadata c(long j2) {
        return this.X == j2 ? this : new Metadata(j2, this.s);
    }

    public Entry d(int i2) {
        return this.s[i2];
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Metadata.class != obj.getClass()) {
            return false;
        }
        Metadata metadata = (Metadata) obj;
        return Arrays.equals(this.s, metadata.s) && this.X == metadata.X;
    }

    public int g() {
        return this.s.length;
    }

    public int hashCode() {
        return (Arrays.hashCode(this.s) * 31) + Longs.l(this.X);
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("entries=");
        sb.append(Arrays.toString(this.s));
        if (this.X == C.f9084b) {
            str = "";
        } else {
            str = ", presentationTimeUs=" + this.X;
        }
        sb.append(str);
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.s.length);
        for (Entry writeParcelable : this.s) {
            parcel.writeParcelable(writeParcelable, 0);
        }
        parcel.writeLong(this.X);
    }

    public Metadata(long j2, Entry... entryArr) {
        this.X = j2;
        this.s = entryArr;
    }

    Metadata(Parcel parcel) {
        this.s = new Entry[parcel.readInt()];
        int i2 = 0;
        while (true) {
            Entry[] entryArr = this.s;
            if (i2 < entryArr.length) {
                entryArr[i2] = (Entry) parcel.readParcelable(Entry.class.getClassLoader());
                i2++;
            } else {
                this.X = parcel.readLong();
                return;
            }
        }
    }

    public Metadata(List<? extends Entry> list) {
        this((Entry[]) list.toArray(new Entry[0]));
    }

    public Metadata(Entry... entryArr) {
        this((long) C.f9084b, entryArr);
    }
}
