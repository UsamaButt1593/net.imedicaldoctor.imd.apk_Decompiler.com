package androidx.media3.extractor.avi;

import androidx.annotation.Nullable;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableList;

final class StreamFormatChunk implements AviChunk {

    /* renamed from: b  reason: collision with root package name */
    private static final String f13235b = "StreamFormatChunk";

    /* renamed from: a  reason: collision with root package name */
    public final Format f13236a;

    public StreamFormatChunk(Format format) {
        this.f13236a = format;
    }

    @Nullable
    private static String a(int i2) {
        switch (i2) {
            case 808802372:
            case 877677894:
            case 1145656883:
            case 1145656920:
            case 1482049860:
            case 1684633208:
            case 2021026148:
                return MimeTypes.p;
            case 826496577:
            case 828601953:
            case 875967048:
                return MimeTypes.f9235j;
            case 842289229:
                return MimeTypes.A;
            case 859066445:
                return MimeTypes.B;
            case 1196444237:
            case 1735420525:
                return MimeTypes.z;
            default:
                return null;
        }
    }

    @Nullable
    private static String b(int i2) {
        if (i2 == 1) {
            return MimeTypes.N;
        }
        if (i2 == 85) {
            return MimeTypes.I;
        }
        if (i2 == 255) {
            return MimeTypes.F;
        }
        if (i2 == 8192) {
            return MimeTypes.Q;
        }
        if (i2 != 8193) {
            return null;
        }
        return MimeTypes.V;
    }

    @Nullable
    private static AviChunk c(ParsableByteArray parsableByteArray) {
        parsableByteArray.Z(4);
        int w = parsableByteArray.w();
        int w2 = parsableByteArray.w();
        parsableByteArray.Z(4);
        int w3 = parsableByteArray.w();
        String a2 = a(w3);
        if (a2 == null) {
            Log.n(f13235b, "Ignoring track with unsupported compression " + w3);
            return null;
        }
        Format.Builder builder = new Format.Builder();
        builder.r0(w).V(w2).k0(a2);
        return new StreamFormatChunk(builder.I());
    }

    @Nullable
    public static AviChunk d(int i2, ParsableByteArray parsableByteArray) {
        if (i2 == 2) {
            return c(parsableByteArray);
        }
        if (i2 == 1) {
            return e(parsableByteArray);
        }
        Log.n(f13235b, "Ignoring strf box for unsupported track type: " + Util.P0(i2));
        return null;
    }

    @Nullable
    private static AviChunk e(ParsableByteArray parsableByteArray) {
        int D = parsableByteArray.D();
        String b2 = b(D);
        if (b2 == null) {
            Log.n(f13235b, "Ignoring track with unsupported format tag " + D);
            return null;
        }
        int D2 = parsableByteArray.D();
        int w = parsableByteArray.w();
        parsableByteArray.Z(6);
        int C0 = Util.C0(parsableByteArray.R());
        int D3 = parsableByteArray.D();
        byte[] bArr = new byte[D3];
        parsableByteArray.n(bArr, 0, D3);
        Format.Builder builder = new Format.Builder();
        builder.k0(b2).L(D2).l0(w);
        if (MimeTypes.N.equals(b2) && C0 != 0) {
            builder.e0(C0);
        }
        if (MimeTypes.F.equals(b2) && D3 > 0) {
            builder.Y(ImmutableList.K(bArr));
        }
        return new StreamFormatChunk(builder.I());
    }

    public int getType() {
        return AviExtractor.D;
    }
}
