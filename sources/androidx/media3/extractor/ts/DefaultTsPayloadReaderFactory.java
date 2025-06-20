package androidx.media3.extractor.ts;

import android.util.SparseArray;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.CodecSpecificDataUtil;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.ts.TsPayloadReader;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.SignedBytes;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

@UnstableApi
public final class DefaultTsPayloadReaderFactory implements TsPayloadReader.Factory {

    /* renamed from: c  reason: collision with root package name */
    public static final int f14233c = 1;

    /* renamed from: d  reason: collision with root package name */
    public static final int f14234d = 2;

    /* renamed from: e  reason: collision with root package name */
    public static final int f14235e = 4;

    /* renamed from: f  reason: collision with root package name */
    public static final int f14236f = 8;

    /* renamed from: g  reason: collision with root package name */
    public static final int f14237g = 16;

    /* renamed from: h  reason: collision with root package name */
    public static final int f14238h = 32;

    /* renamed from: i  reason: collision with root package name */
    public static final int f14239i = 64;

    /* renamed from: j  reason: collision with root package name */
    private static final int f14240j = 134;

    /* renamed from: a  reason: collision with root package name */
    private final int f14241a;

    /* renamed from: b  reason: collision with root package name */
    private final List<Format> f14242b;

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public DefaultTsPayloadReaderFactory() {
        this(0);
    }

    private SeiReader c(TsPayloadReader.EsInfo esInfo) {
        return new SeiReader(e(esInfo));
    }

    private UserDataReader d(TsPayloadReader.EsInfo esInfo) {
        return new UserDataReader(e(esInfo));
    }

    private List<Format> e(TsPayloadReader.EsInfo esInfo) {
        String str;
        int i2;
        List<byte[]> list;
        if (f(32)) {
            return this.f14242b;
        }
        ParsableByteArray parsableByteArray = new ParsableByteArray(esInfo.f14544e);
        List<Format> list2 = this.f14242b;
        while (parsableByteArray.a() > 0) {
            int L = parsableByteArray.L();
            int f2 = parsableByteArray.f() + parsableByteArray.L();
            if (L == 134) {
                list2 = new ArrayList<>();
                int L2 = parsableByteArray.L() & 31;
                for (int i3 = 0; i3 < L2; i3++) {
                    String I = parsableByteArray.I(3);
                    int L3 = parsableByteArray.L();
                    boolean z = true;
                    boolean z2 = (L3 & 128) != 0;
                    if (z2) {
                        i2 = L3 & 63;
                        str = MimeTypes.x0;
                    } else {
                        str = MimeTypes.w0;
                        i2 = 1;
                    }
                    byte L4 = (byte) parsableByteArray.L();
                    parsableByteArray.Z(1);
                    if (z2) {
                        if ((L4 & SignedBytes.f22967a) == 0) {
                            z = false;
                        }
                        list = CodecSpecificDataUtil.b(z);
                    } else {
                        list = null;
                    }
                    list2.add(new Format.Builder().k0(str).b0(I).J(i2).Y(list).I());
                }
            }
            parsableByteArray.Y(f2);
        }
        return list2;
    }

    private boolean f(int i2) {
        return (i2 & this.f14241a) != 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0063, code lost:
        return new androidx.media3.extractor.ts.PesReader(new androidx.media3.extractor.ts.Ac3Reader(r6.f14541b, r6.a()));
     */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.media3.extractor.ts.TsPayloadReader a(int r5, androidx.media3.extractor.ts.TsPayloadReader.EsInfo r6) {
        /*
            r4 = this;
            r0 = 2
            if (r5 == r0) goto L_0x0141
            r1 = 3
            if (r5 == r1) goto L_0x0130
            r1 = 4
            if (r5 == r1) goto L_0x0130
            r2 = 21
            if (r5 == r2) goto L_0x0125
            r2 = 27
            r3 = 0
            if (r5 == r2) goto L_0x0104
            r1 = 36
            if (r5 == r1) goto L_0x00f5
            r1 = 89
            if (r5 == r1) goto L_0x00e8
            r1 = 172(0xac, float:2.41E-43)
            if (r5 == r1) goto L_0x00d7
            r1 = 257(0x101, float:3.6E-43)
            if (r5 == r1) goto L_0x00ca
            r1 = 138(0x8a, float:1.93E-43)
            if (r5 == r1) goto L_0x00b7
            r1 = 139(0x8b, float:1.95E-43)
            if (r5 == r1) goto L_0x00a4
            switch(r5) {
                case 15: goto L_0x008b;
                case 16: goto L_0x007c;
                case 17: goto L_0x0064;
                default: goto L_0x002d;
            }
        L_0x002d:
            switch(r5) {
                case 128: goto L_0x0141;
                case 129: goto L_0x0053;
                case 130: goto L_0x004a;
                default: goto L_0x0030;
            }
        L_0x0030:
            switch(r5) {
                case 134: goto L_0x0034;
                case 135: goto L_0x0053;
                case 136: goto L_0x00b7;
                default: goto L_0x0033;
            }
        L_0x0033:
            return r3
        L_0x0034:
            r5 = 16
            boolean r5 = r4.f(r5)
            if (r5 == 0) goto L_0x003d
            goto L_0x0049
        L_0x003d:
            androidx.media3.extractor.ts.SectionReader r3 = new androidx.media3.extractor.ts.SectionReader
            androidx.media3.extractor.ts.PassthroughSectionPayloadReader r5 = new androidx.media3.extractor.ts.PassthroughSectionPayloadReader
            java.lang.String r6 = "application/x-scte35"
            r5.<init>(r6)
            r3.<init>(r5)
        L_0x0049:
            return r3
        L_0x004a:
            r5 = 64
            boolean r5 = r4.f(r5)
            if (r5 != 0) goto L_0x00b7
            return r3
        L_0x0053:
            androidx.media3.extractor.ts.PesReader r5 = new androidx.media3.extractor.ts.PesReader
            androidx.media3.extractor.ts.Ac3Reader r0 = new androidx.media3.extractor.ts.Ac3Reader
            java.lang.String r1 = r6.f14541b
            int r6 = r6.a()
            r0.<init>(r1, r6)
            r5.<init>(r0)
            return r5
        L_0x0064:
            boolean r5 = r4.f(r0)
            if (r5 == 0) goto L_0x006b
            goto L_0x007b
        L_0x006b:
            androidx.media3.extractor.ts.PesReader r3 = new androidx.media3.extractor.ts.PesReader
            androidx.media3.extractor.ts.LatmReader r5 = new androidx.media3.extractor.ts.LatmReader
            java.lang.String r0 = r6.f14541b
            int r6 = r6.a()
            r5.<init>(r0, r6)
            r3.<init>(r5)
        L_0x007b:
            return r3
        L_0x007c:
            androidx.media3.extractor.ts.PesReader r5 = new androidx.media3.extractor.ts.PesReader
            androidx.media3.extractor.ts.H263Reader r0 = new androidx.media3.extractor.ts.H263Reader
            androidx.media3.extractor.ts.UserDataReader r6 = r4.d(r6)
            r0.<init>(r6)
            r5.<init>(r0)
            return r5
        L_0x008b:
            boolean r5 = r4.f(r0)
            if (r5 == 0) goto L_0x0092
            goto L_0x00a3
        L_0x0092:
            androidx.media3.extractor.ts.PesReader r3 = new androidx.media3.extractor.ts.PesReader
            androidx.media3.extractor.ts.AdtsReader r5 = new androidx.media3.extractor.ts.AdtsReader
            java.lang.String r0 = r6.f14541b
            int r6 = r6.a()
            r1 = 0
            r5.<init>(r1, r0, r6)
            r3.<init>(r5)
        L_0x00a3:
            return r3
        L_0x00a4:
            androidx.media3.extractor.ts.PesReader r5 = new androidx.media3.extractor.ts.PesReader
            androidx.media3.extractor.ts.DtsReader r0 = new androidx.media3.extractor.ts.DtsReader
            java.lang.String r1 = r6.f14541b
            int r6 = r6.a()
            r2 = 5408(0x1520, float:7.578E-42)
            r0.<init>(r1, r6, r2)
            r5.<init>(r0)
            return r5
        L_0x00b7:
            androidx.media3.extractor.ts.PesReader r5 = new androidx.media3.extractor.ts.PesReader
            androidx.media3.extractor.ts.DtsReader r0 = new androidx.media3.extractor.ts.DtsReader
            java.lang.String r1 = r6.f14541b
            int r6 = r6.a()
            r2 = 4096(0x1000, float:5.74E-42)
            r0.<init>(r1, r6, r2)
            r5.<init>(r0)
            return r5
        L_0x00ca:
            androidx.media3.extractor.ts.SectionReader r5 = new androidx.media3.extractor.ts.SectionReader
            androidx.media3.extractor.ts.PassthroughSectionPayloadReader r6 = new androidx.media3.extractor.ts.PassthroughSectionPayloadReader
            java.lang.String r0 = "application/vnd.dvb.ait"
            r6.<init>(r0)
            r5.<init>(r6)
            return r5
        L_0x00d7:
            androidx.media3.extractor.ts.PesReader r5 = new androidx.media3.extractor.ts.PesReader
            androidx.media3.extractor.ts.Ac4Reader r0 = new androidx.media3.extractor.ts.Ac4Reader
            java.lang.String r1 = r6.f14541b
            int r6 = r6.a()
            r0.<init>(r1, r6)
            r5.<init>(r0)
            return r5
        L_0x00e8:
            androidx.media3.extractor.ts.PesReader r5 = new androidx.media3.extractor.ts.PesReader
            androidx.media3.extractor.ts.DvbSubtitleReader r0 = new androidx.media3.extractor.ts.DvbSubtitleReader
            java.util.List<androidx.media3.extractor.ts.TsPayloadReader$DvbSubtitleInfo> r6 = r6.f14543d
            r0.<init>(r6)
            r5.<init>(r0)
            return r5
        L_0x00f5:
            androidx.media3.extractor.ts.PesReader r5 = new androidx.media3.extractor.ts.PesReader
            androidx.media3.extractor.ts.H265Reader r0 = new androidx.media3.extractor.ts.H265Reader
            androidx.media3.extractor.ts.SeiReader r6 = r4.c(r6)
            r0.<init>(r6)
            r5.<init>(r0)
            return r5
        L_0x0104:
            boolean r5 = r4.f(r1)
            if (r5 == 0) goto L_0x010b
            goto L_0x0124
        L_0x010b:
            androidx.media3.extractor.ts.PesReader r3 = new androidx.media3.extractor.ts.PesReader
            androidx.media3.extractor.ts.H264Reader r5 = new androidx.media3.extractor.ts.H264Reader
            androidx.media3.extractor.ts.SeiReader r6 = r4.c(r6)
            r0 = 1
            boolean r0 = r4.f(r0)
            r1 = 8
            boolean r1 = r4.f(r1)
            r5.<init>(r6, r0, r1)
            r3.<init>(r5)
        L_0x0124:
            return r3
        L_0x0125:
            androidx.media3.extractor.ts.PesReader r5 = new androidx.media3.extractor.ts.PesReader
            androidx.media3.extractor.ts.Id3Reader r6 = new androidx.media3.extractor.ts.Id3Reader
            r6.<init>()
            r5.<init>(r6)
            return r5
        L_0x0130:
            androidx.media3.extractor.ts.PesReader r5 = new androidx.media3.extractor.ts.PesReader
            androidx.media3.extractor.ts.MpegAudioReader r0 = new androidx.media3.extractor.ts.MpegAudioReader
            java.lang.String r1 = r6.f14541b
            int r6 = r6.a()
            r0.<init>(r1, r6)
            r5.<init>(r0)
            return r5
        L_0x0141:
            androidx.media3.extractor.ts.PesReader r5 = new androidx.media3.extractor.ts.PesReader
            androidx.media3.extractor.ts.H262Reader r0 = new androidx.media3.extractor.ts.H262Reader
            androidx.media3.extractor.ts.UserDataReader r6 = r4.d(r6)
            r0.<init>(r6)
            r5.<init>(r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.ts.DefaultTsPayloadReaderFactory.a(int, androidx.media3.extractor.ts.TsPayloadReader$EsInfo):androidx.media3.extractor.ts.TsPayloadReader");
    }

    public SparseArray<TsPayloadReader> b() {
        return new SparseArray<>();
    }

    public DefaultTsPayloadReaderFactory(int i2) {
        this(i2, ImmutableList.I());
    }

    public DefaultTsPayloadReaderFactory(int i2, List<Format> list) {
        this.f14241a = i2;
        this.f14242b = list;
    }
}
