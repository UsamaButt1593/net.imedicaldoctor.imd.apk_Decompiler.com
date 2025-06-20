package androidx.media3.exoplayer.offline;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.StreamKey;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@UnstableApi
public final class DownloadRequest implements Parcelable {
    public static final Parcelable.Creator<DownloadRequest> CREATOR = new Parcelable.Creator<DownloadRequest>() {
        /* renamed from: a */
        public DownloadRequest createFromParcel(Parcel parcel) {
            return new DownloadRequest(parcel);
        }

        /* renamed from: b */
        public DownloadRequest[] newArray(int i2) {
            return new DownloadRequest[i2];
        }
    };
    public final Uri X;
    @Nullable
    public final byte[] X2;
    @Nullable
    public final String Y;
    @Nullable
    public final String Y2;
    public final List<StreamKey> Z;
    public final byte[] Z2;
    public final String s;

    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final String f11820a;

        /* renamed from: b  reason: collision with root package name */
        private final Uri f11821b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private String f11822c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private List<StreamKey> f11823d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        private byte[] f11824e;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        private String f11825f;
        @Nullable

        /* renamed from: g  reason: collision with root package name */
        private byte[] f11826g;

        public Builder(String str, Uri uri) {
            this.f11820a = str;
            this.f11821b = uri;
        }

        public DownloadRequest a() {
            String str = this.f11820a;
            Uri uri = this.f11821b;
            String str2 = this.f11822c;
            List list = this.f11823d;
            if (list == null) {
                list = ImmutableList.I();
            }
            return new DownloadRequest(str, uri, str2, list, this.f11824e, this.f11825f, this.f11826g);
        }

        @CanIgnoreReturnValue
        public Builder b(@Nullable String str) {
            this.f11825f = str;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder c(@Nullable byte[] bArr) {
            this.f11826g = bArr;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder d(@Nullable byte[] bArr) {
            this.f11824e = bArr;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder e(@Nullable String str) {
            this.f11822c = MimeTypes.u(str);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder f(@Nullable List<StreamKey> list) {
            this.f11823d = list;
            return this;
        }
    }

    public static class UnsupportedRequestException extends IOException {
    }

    DownloadRequest(Parcel parcel) {
        this.s = (String) Util.o(parcel.readString());
        this.X = Uri.parse((String) Util.o(parcel.readString()));
        this.Y = parcel.readString();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add((StreamKey) parcel.readParcelable(StreamKey.class.getClassLoader()));
        }
        this.Z = Collections.unmodifiableList(arrayList);
        this.X2 = parcel.createByteArray();
        this.Y2 = parcel.readString();
        this.Z2 = (byte[]) Util.o(parcel.createByteArray());
    }

    public DownloadRequest a(String str) {
        return new DownloadRequest(str, this.X, this.Y, this.Z, this.X2, this.Y2, this.Z2);
    }

    public DownloadRequest b(@Nullable byte[] bArr) {
        return new DownloadRequest(this.s, this.X, this.Y, this.Z, bArr, this.Y2, this.Z2);
    }

    public DownloadRequest c(DownloadRequest downloadRequest) {
        List emptyList;
        Assertions.a(this.s.equals(downloadRequest.s));
        if (this.Z.isEmpty() || downloadRequest.Z.isEmpty()) {
            emptyList = Collections.emptyList();
        } else {
            emptyList = new ArrayList(this.Z);
            for (int i2 = 0; i2 < downloadRequest.Z.size(); i2++) {
                StreamKey streamKey = downloadRequest.Z.get(i2);
                if (!emptyList.contains(streamKey)) {
                    emptyList.add(streamKey);
                }
            }
        }
        return new DownloadRequest(this.s, downloadRequest.X, downloadRequest.Y, emptyList, downloadRequest.X2, downloadRequest.Y2, downloadRequest.Z2);
    }

    public MediaItem d() {
        return new MediaItem.Builder().E(this.s).M(this.X).l(this.Y2).G(this.Y).I(this.Z).a();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof DownloadRequest)) {
            return false;
        }
        DownloadRequest downloadRequest = (DownloadRequest) obj;
        return this.s.equals(downloadRequest.s) && this.X.equals(downloadRequest.X) && Util.g(this.Y, downloadRequest.Y) && this.Z.equals(downloadRequest.Z) && Arrays.equals(this.X2, downloadRequest.X2) && Util.g(this.Y2, downloadRequest.Y2) && Arrays.equals(this.Z2, downloadRequest.Z2);
    }

    public final int hashCode() {
        int hashCode = ((this.s.hashCode() * 961) + this.X.hashCode()) * 31;
        String str = this.Y;
        int i2 = 0;
        int hashCode2 = (((((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.Z.hashCode()) * 31) + Arrays.hashCode(this.X2)) * 31;
        String str2 = this.Y2;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return ((hashCode2 + i2) * 31) + Arrays.hashCode(this.Z2);
    }

    public String toString() {
        return this.Y + ":" + this.s;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.s);
        parcel.writeString(this.X.toString());
        parcel.writeString(this.Y);
        parcel.writeInt(this.Z.size());
        for (int i3 = 0; i3 < this.Z.size(); i3++) {
            parcel.writeParcelable(this.Z.get(i3), 0);
        }
        parcel.writeByteArray(this.X2);
        parcel.writeString(this.Y2);
        parcel.writeByteArray(this.Z2);
    }

    private DownloadRequest(String str, Uri uri, @Nullable String str2, List<StreamKey> list, @Nullable byte[] bArr, @Nullable String str3, @Nullable byte[] bArr2) {
        int b1 = Util.b1(uri, str2);
        boolean z = true;
        if (b1 == 0 || b1 == 2 || b1 == 1) {
            z = str3 != null ? false : z;
            Assertions.b(z, "customCacheKey must be null for type: " + b1);
        }
        this.s = str;
        this.X = uri;
        this.Y = str2;
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList);
        this.Z = Collections.unmodifiableList(arrayList);
        this.X2 = bArr != null ? Arrays.copyOf(bArr, bArr.length) : null;
        this.Y2 = str3;
        this.Z2 = bArr2 != null ? Arrays.copyOf(bArr2, bArr2.length) : Util.f9651f;
    }
}
