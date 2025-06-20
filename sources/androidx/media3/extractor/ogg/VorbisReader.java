package androidx.media3.extractor.ogg;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.VorbisUtil;
import androidx.media3.extractor.ogg.StreamReader;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

final class VorbisReader extends StreamReader {
    @Nullable
    private VorbisSetup r;
    private int s;
    private boolean t;
    @Nullable
    private VorbisUtil.VorbisIdHeader u;
    @Nullable
    private VorbisUtil.CommentHeader v;

    static final class VorbisSetup {

        /* renamed from: a  reason: collision with root package name */
        public final VorbisUtil.VorbisIdHeader f13758a;

        /* renamed from: b  reason: collision with root package name */
        public final VorbisUtil.CommentHeader f13759b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f13760c;

        /* renamed from: d  reason: collision with root package name */
        public final VorbisUtil.Mode[] f13761d;

        /* renamed from: e  reason: collision with root package name */
        public final int f13762e;

        public VorbisSetup(VorbisUtil.VorbisIdHeader vorbisIdHeader, VorbisUtil.CommentHeader commentHeader, byte[] bArr, VorbisUtil.Mode[] modeArr, int i2) {
            this.f13758a = vorbisIdHeader;
            this.f13759b = commentHeader;
            this.f13760c = bArr;
            this.f13761d = modeArr;
            this.f13762e = i2;
        }
    }

    VorbisReader() {
    }

    @VisibleForTesting
    static void n(ParsableByteArray parsableByteArray, long j2) {
        if (parsableByteArray.b() < parsableByteArray.g() + 4) {
            parsableByteArray.V(Arrays.copyOf(parsableByteArray.e(), parsableByteArray.g() + 4));
        } else {
            parsableByteArray.X(parsableByteArray.g() + 4);
        }
        byte[] e2 = parsableByteArray.e();
        e2[parsableByteArray.g() - 4] = (byte) ((int) (j2 & 255));
        e2[parsableByteArray.g() - 3] = (byte) ((int) ((j2 >>> 8) & 255));
        e2[parsableByteArray.g() - 2] = (byte) ((int) ((j2 >>> 16) & 255));
        e2[parsableByteArray.g() - 1] = (byte) ((int) ((j2 >>> 24) & 255));
    }

    private static int o(byte b2, VorbisSetup vorbisSetup) {
        return !vorbisSetup.f13761d[p(b2, vorbisSetup.f13762e, 1)].f13154a ? vorbisSetup.f13758a.f13164g : vorbisSetup.f13758a.f13165h;
    }

    @VisibleForTesting
    static int p(byte b2, int i2, int i3) {
        return (b2 >> i3) & (255 >>> (8 - i2));
    }

    public static boolean r(ParsableByteArray parsableByteArray) {
        try {
            return VorbisUtil.o(1, parsableByteArray, true);
        } catch (ParserException unused) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void e(long j2) {
        super.e(j2);
        int i2 = 0;
        this.t = j2 != 0;
        VorbisUtil.VorbisIdHeader vorbisIdHeader = this.u;
        if (vorbisIdHeader != null) {
            i2 = vorbisIdHeader.f13164g;
        }
        this.s = i2;
    }

    /* access modifiers changed from: protected */
    public long f(ParsableByteArray parsableByteArray) {
        int i2 = 0;
        if ((parsableByteArray.e()[0] & 1) == 1) {
            return -1;
        }
        int o = o(parsableByteArray.e()[0], (VorbisSetup) Assertions.k(this.r));
        if (this.t) {
            i2 = (this.s + o) / 4;
        }
        long j2 = (long) i2;
        n(parsableByteArray, j2);
        this.t = true;
        this.s = o;
        return j2;
    }

    /* access modifiers changed from: protected */
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public boolean h(ParsableByteArray parsableByteArray, long j2, StreamReader.SetupData setupData) throws IOException {
        if (this.r != null) {
            Assertions.g(setupData.f13756a);
            return false;
        }
        VorbisSetup q = q(parsableByteArray);
        this.r = q;
        if (q == null) {
            return true;
        }
        VorbisUtil.VorbisIdHeader vorbisIdHeader = q.f13758a;
        ArrayList arrayList = new ArrayList();
        arrayList.add(vorbisIdHeader.f13167j);
        arrayList.add(q.f13760c);
        setupData.f13756a = new Format.Builder().k0(MimeTypes.Z).K(vorbisIdHeader.f13162e).f0(vorbisIdHeader.f13161d).L(vorbisIdHeader.f13159b).l0(vorbisIdHeader.f13160c).Y(arrayList).d0(VorbisUtil.d(ImmutableList.D(q.f13759b.f13152b))).I();
        return true;
    }

    /* access modifiers changed from: protected */
    public void l(boolean z) {
        super.l(z);
        if (z) {
            this.r = null;
            this.u = null;
            this.v = null;
        }
        this.s = 0;
        this.t = false;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    @Nullable
    public VorbisSetup q(ParsableByteArray parsableByteArray) throws IOException {
        VorbisUtil.VorbisIdHeader vorbisIdHeader = this.u;
        if (vorbisIdHeader == null) {
            this.u = VorbisUtil.l(parsableByteArray);
            return null;
        }
        VorbisUtil.CommentHeader commentHeader = this.v;
        if (commentHeader == null) {
            this.v = VorbisUtil.j(parsableByteArray);
            return null;
        }
        byte[] bArr = new byte[parsableByteArray.g()];
        System.arraycopy(parsableByteArray.e(), 0, bArr, 0, parsableByteArray.g());
        VorbisUtil.Mode[] m2 = VorbisUtil.m(parsableByteArray, vorbisIdHeader.f13159b);
        return new VorbisSetup(vorbisIdHeader, commentHeader, bArr, m2, VorbisUtil.b(m2.length - 1));
    }
}
