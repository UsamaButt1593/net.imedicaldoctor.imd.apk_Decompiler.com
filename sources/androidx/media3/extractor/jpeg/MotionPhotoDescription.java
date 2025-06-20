package androidx.media3.extractor.jpeg;

import androidx.annotation.Nullable;
import androidx.media3.common.MimeTypes;
import androidx.media3.extractor.metadata.mp4.MotionPhotoMetadata;
import java.util.List;

final class MotionPhotoDescription {

    /* renamed from: a  reason: collision with root package name */
    public final long f13331a;

    /* renamed from: b  reason: collision with root package name */
    public final List<ContainerItem> f13332b;

    public static final class ContainerItem {

        /* renamed from: a  reason: collision with root package name */
        public final String f13333a;

        /* renamed from: b  reason: collision with root package name */
        public final String f13334b;

        /* renamed from: c  reason: collision with root package name */
        public final long f13335c;

        /* renamed from: d  reason: collision with root package name */
        public final long f13336d;

        public ContainerItem(String str, String str2, long j2, long j3) {
            this.f13333a = str;
            this.f13334b = str2;
            this.f13335c = j2;
            this.f13336d = j3;
        }
    }

    public MotionPhotoDescription(long j2, List<ContainerItem> list) {
        this.f13331a = j2;
        this.f13332b = list;
    }

    @Nullable
    public MotionPhotoMetadata a(long j2) {
        long j3;
        if (this.f13332b.size() < 2) {
            return null;
        }
        long j4 = j2;
        long j5 = -1;
        long j6 = -1;
        long j7 = -1;
        long j8 = -1;
        boolean z = false;
        for (int size = this.f13332b.size() - 1; size >= 0; size--) {
            ContainerItem containerItem = this.f13332b.get(size);
            boolean equals = MimeTypes.f9231f.equals(containerItem.f13333a) | z;
            if (size == 0) {
                j4 -= containerItem.f13336d;
                j3 = 0;
            } else {
                j3 = j4 - containerItem.f13335c;
            }
            long j9 = j4;
            j4 = j3;
            long j10 = j9;
            if (!equals || j4 == j10) {
                z = equals;
            } else {
                j8 = j10 - j4;
                j7 = j4;
                z = false;
            }
            if (size == 0) {
                j5 = j4;
                j6 = j10;
            }
        }
        if (j7 == -1 || j8 == -1 || j5 == -1 || j6 == -1) {
            return null;
        }
        return new MotionPhotoMetadata(j5, j6, this.f13331a, j7, j8);
    }
}
