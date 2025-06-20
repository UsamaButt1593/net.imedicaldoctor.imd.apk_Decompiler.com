package androidx.media3.extractor.ts;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.ExtractorOutput;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collections;
import java.util.List;

@UnstableApi
public interface TsPayloadReader {

    /* renamed from: a  reason: collision with root package name */
    public static final int f14530a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static final int f14531b = 2;

    /* renamed from: c  reason: collision with root package name */
    public static final int f14532c = 4;

    public static final class DvbSubtitleInfo {

        /* renamed from: a  reason: collision with root package name */
        public final String f14533a;

        /* renamed from: b  reason: collision with root package name */
        public final int f14534b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f14535c;

        public DvbSubtitleInfo(String str, int i2, byte[] bArr) {
            this.f14533a = str;
            this.f14534b = i2;
            this.f14535c = bArr;
        }
    }

    public static final class EsInfo {

        /* renamed from: f  reason: collision with root package name */
        public static final int f14536f = 0;

        /* renamed from: g  reason: collision with root package name */
        public static final int f14537g = 1;

        /* renamed from: h  reason: collision with root package name */
        public static final int f14538h = 2;

        /* renamed from: i  reason: collision with root package name */
        public static final int f14539i = 3;

        /* renamed from: a  reason: collision with root package name */
        public final int f14540a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        public final String f14541b;

        /* renamed from: c  reason: collision with root package name */
        public final int f14542c;

        /* renamed from: d  reason: collision with root package name */
        public final List<DvbSubtitleInfo> f14543d;

        /* renamed from: e  reason: collision with root package name */
        public final byte[] f14544e;

        @Documented
        @Target({ElementType.TYPE_USE})
        @Retention(RetentionPolicy.SOURCE)
        public @interface AudioType {
        }

        public EsInfo(int i2, @Nullable String str, int i3, @Nullable List<DvbSubtitleInfo> list, byte[] bArr) {
            this.f14540a = i2;
            this.f14541b = str;
            this.f14542c = i3;
            this.f14543d = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
            this.f14544e = bArr;
        }

        public int a() {
            int i2 = this.f14542c;
            if (i2 != 2) {
                return i2 != 3 ? 0 : 512;
            }
            return 2048;
        }
    }

    public interface Factory {
        @Nullable
        TsPayloadReader a(int i2, EsInfo esInfo);

        SparseArray<TsPayloadReader> b();
    }

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public static final class TrackIdGenerator {

        /* renamed from: f  reason: collision with root package name */
        private static final int f14545f = Integer.MIN_VALUE;

        /* renamed from: a  reason: collision with root package name */
        private final String f14546a;

        /* renamed from: b  reason: collision with root package name */
        private final int f14547b;

        /* renamed from: c  reason: collision with root package name */
        private final int f14548c;

        /* renamed from: d  reason: collision with root package name */
        private int f14549d;

        /* renamed from: e  reason: collision with root package name */
        private String f14550e;

        public TrackIdGenerator(int i2, int i3) {
            this(Integer.MIN_VALUE, i2, i3);
        }

        private void d() {
            if (this.f14549d == Integer.MIN_VALUE) {
                throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
            }
        }

        public void a() {
            int i2 = this.f14549d;
            this.f14549d = i2 == Integer.MIN_VALUE ? this.f14547b : i2 + this.f14548c;
            this.f14550e = this.f14546a + this.f14549d;
        }

        public String b() {
            d();
            return this.f14550e;
        }

        public int c() {
            d();
            return this.f14549d;
        }

        public TrackIdGenerator(int i2, int i3, int i4) {
            String str;
            if (i2 != Integer.MIN_VALUE) {
                str = i2 + "/";
            } else {
                str = "";
            }
            this.f14546a = str;
            this.f14547b = i3;
            this.f14548c = i4;
            this.f14549d = Integer.MIN_VALUE;
            this.f14550e = "";
        }
    }

    void a();

    void b(ParsableByteArray parsableByteArray, int i2) throws ParserException;

    void c(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TrackIdGenerator trackIdGenerator);
}
