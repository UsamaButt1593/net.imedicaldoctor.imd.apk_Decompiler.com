package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.hash.Funnels;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
public abstract class ByteSource {

    class AsCharSource extends CharSource {

        /* renamed from: a  reason: collision with root package name */
        final Charset f22754a;

        AsCharSource(Charset charset) {
            this.f22754a = (Charset) Preconditions.E(charset);
        }

        public ByteSource a(Charset charset) {
            return charset.equals(this.f22754a) ? ByteSource.this : super.a(charset);
        }

        public Reader m() throws IOException {
            return new InputStreamReader(ByteSource.this.m(), this.f22754a);
        }

        public String n() throws IOException {
            return new String(ByteSource.this.o(), this.f22754a);
        }

        public String toString() {
            return ByteSource.this.toString() + ".asCharSource(" + this.f22754a + ")";
        }
    }

    private static class ByteArrayByteSource extends ByteSource {

        /* renamed from: a  reason: collision with root package name */
        final byte[] f22756a;

        /* renamed from: b  reason: collision with root package name */
        final int f22757b;

        /* renamed from: c  reason: collision with root package name */
        final int f22758c;

        ByteArrayByteSource(byte[] bArr) {
            this(bArr, 0, bArr.length);
        }

        public long g(OutputStream outputStream) throws IOException {
            outputStream.write(this.f22756a, this.f22757b, this.f22758c);
            return (long) this.f22758c;
        }

        public HashCode j(HashFunction hashFunction) throws IOException {
            return hashFunction.j(this.f22756a, this.f22757b, this.f22758c);
        }

        public boolean k() {
            return this.f22758c == 0;
        }

        public InputStream l() {
            return m();
        }

        public InputStream m() {
            return new ByteArrayInputStream(this.f22756a, this.f22757b, this.f22758c);
        }

        @ParametricNullness
        public <T> T n(ByteProcessor<T> byteProcessor) throws IOException {
            byteProcessor.b(this.f22756a, this.f22757b, this.f22758c);
            return byteProcessor.a();
        }

        public byte[] o() {
            byte[] bArr = this.f22756a;
            int i2 = this.f22757b;
            return Arrays.copyOfRange(bArr, i2, this.f22758c + i2);
        }

        public long p() {
            return (long) this.f22758c;
        }

        public Optional<Long> q() {
            return Optional.f(Long.valueOf((long) this.f22758c));
        }

        public ByteSource r(long j2, long j3) {
            boolean z = false;
            Preconditions.p(j2 >= 0, "offset (%s) may not be negative", j2);
            if (j3 >= 0) {
                z = true;
            }
            Preconditions.p(z, "length (%s) may not be negative", j3);
            long min = Math.min(j2, (long) this.f22758c);
            return new ByteArrayByteSource(this.f22756a, this.f22757b + ((int) min), (int) Math.min(j3, ((long) this.f22758c) - min));
        }

        public String toString() {
            return "ByteSource.wrap(" + Ascii.k(BaseEncoding.a().m(this.f22756a, this.f22757b, this.f22758c), 30, "...") + ")";
        }

        ByteArrayByteSource(byte[] bArr, int i2, int i3) {
            this.f22756a = bArr;
            this.f22757b = i2;
            this.f22758c = i3;
        }
    }

    private static final class ConcatenatedByteSource extends ByteSource {

        /* renamed from: a  reason: collision with root package name */
        final Iterable<? extends ByteSource> f22759a;

        ConcatenatedByteSource(Iterable<? extends ByteSource> iterable) {
            this.f22759a = (Iterable) Preconditions.E(iterable);
        }

        public boolean k() throws IOException {
            for (ByteSource k2 : this.f22759a) {
                if (!k2.k()) {
                    return false;
                }
            }
            return true;
        }

        public InputStream m() throws IOException {
            return new MultiInputStream(this.f22759a.iterator());
        }

        public long p() throws IOException {
            long j2 = 0;
            for (ByteSource p : this.f22759a) {
                j2 += p.p();
                if (j2 < 0) {
                    return Long.MAX_VALUE;
                }
            }
            return j2;
        }

        public Optional<Long> q() {
            long valueOf;
            Iterable<? extends ByteSource> iterable = this.f22759a;
            if (!(iterable instanceof Collection)) {
                return Optional.a();
            }
            Iterator<? extends ByteSource> it2 = iterable.iterator();
            long j2 = 0;
            while (true) {
                if (!it2.hasNext()) {
                    valueOf = Long.valueOf(j2);
                    break;
                }
                Optional<Long> q = ((ByteSource) it2.next()).q();
                if (q.e()) {
                    j2 += q.d().longValue();
                    if (j2 < 0) {
                        valueOf = Long.MAX_VALUE;
                        break;
                    }
                } else {
                    return Optional.a();
                }
            }
            return Optional.f(valueOf);
        }

        public String toString() {
            return "ByteSource.concat(" + this.f22759a + ")";
        }
    }

    private static final class EmptyByteSource extends ByteArrayByteSource {

        /* renamed from: d  reason: collision with root package name */
        static final EmptyByteSource f22760d = new EmptyByteSource();

        EmptyByteSource() {
            super(new byte[0]);
        }

        public CharSource a(Charset charset) {
            Preconditions.E(charset);
            return CharSource.h();
        }

        public byte[] o() {
            return this.f22756a;
        }

        public String toString() {
            return "ByteSource.empty()";
        }
    }

    private final class SlicedByteSource extends ByteSource {

        /* renamed from: a  reason: collision with root package name */
        final long f22761a;

        /* renamed from: b  reason: collision with root package name */
        final long f22762b;

        SlicedByteSource(long j2, long j3) {
            boolean z = false;
            Preconditions.p(j2 >= 0, "offset (%s) may not be negative", j2);
            Preconditions.p(j3 >= 0 ? true : z, "length (%s) may not be negative", j3);
            this.f22761a = j2;
            this.f22762b = j3;
        }

        private InputStream t(InputStream inputStream) throws IOException {
            Closer b2;
            long j2 = this.f22761a;
            if (j2 > 0) {
                try {
                    if (ByteStreams.t(inputStream, j2) < this.f22761a) {
                        inputStream.close();
                        return new ByteArrayInputStream(new byte[0]);
                    }
                } catch (Throwable th) {
                    b2.close();
                    throw th;
                }
            }
            return ByteStreams.f(inputStream, this.f22762b);
        }

        public boolean k() throws IOException {
            return this.f22762b == 0 || ByteSource.super.k();
        }

        public InputStream l() throws IOException {
            return t(ByteSource.this.l());
        }

        public InputStream m() throws IOException {
            return t(ByteSource.this.m());
        }

        public Optional<Long> q() {
            Optional<Long> q = ByteSource.this.q();
            if (!q.e()) {
                return Optional.a();
            }
            long longValue = q.d().longValue();
            return Optional.f(Long.valueOf(Math.min(this.f22762b, longValue - Math.min(this.f22761a, longValue))));
        }

        public ByteSource r(long j2, long j3) {
            boolean z = false;
            Preconditions.p(j2 >= 0, "offset (%s) may not be negative", j2);
            if (j3 >= 0) {
                z = true;
            }
            Preconditions.p(z, "length (%s) may not be negative", j3);
            long j4 = this.f22762b - j2;
            return j4 <= 0 ? ByteSource.i() : ByteSource.this.r(this.f22761a + j2, Math.min(j3, j4));
        }

        public String toString() {
            return ByteSource.this.toString() + ".slice(" + this.f22761a + ", " + this.f22762b + ")";
        }
    }

    protected ByteSource() {
    }

    public static ByteSource b(Iterable<? extends ByteSource> iterable) {
        return new ConcatenatedByteSource(iterable);
    }

    public static ByteSource c(Iterator<? extends ByteSource> it2) {
        return b(ImmutableList.C(it2));
    }

    public static ByteSource d(ByteSource... byteSourceArr) {
        return b(ImmutableList.D(byteSourceArr));
    }

    private long h(InputStream inputStream) throws IOException {
        long j2 = 0;
        while (true) {
            long t = ByteStreams.t(inputStream, 2147483647L);
            if (t <= 0) {
                return j2;
            }
            j2 += t;
        }
    }

    public static ByteSource i() {
        return EmptyByteSource.f22760d;
    }

    public static ByteSource s(byte[] bArr) {
        return new ByteArrayByteSource(bArr);
    }

    public CharSource a(Charset charset) {
        return new AsCharSource(charset);
    }

    public boolean e(ByteSource byteSource) throws IOException {
        int n2;
        Preconditions.E(byteSource);
        byte[] d2 = ByteStreams.d();
        byte[] d3 = ByteStreams.d();
        Closer b2 = Closer.b();
        try {
            InputStream inputStream = (InputStream) b2.c(m());
            InputStream inputStream2 = (InputStream) b2.c(byteSource.m());
            do {
                n2 = ByteStreams.n(inputStream, d2, 0, d2.length);
                if (n2 == ByteStreams.n(inputStream2, d3, 0, d3.length)) {
                    if (!Arrays.equals(d2, d3)) {
                    }
                }
                b2.close();
                return false;
            } while (n2 == d2.length);
            b2.close();
            return true;
        } catch (Throwable th) {
            b2.close();
            throw th;
        }
    }

    @CanIgnoreReturnValue
    public long f(ByteSink byteSink) throws IOException {
        Preconditions.E(byteSink);
        Closer b2 = Closer.b();
        try {
            long b3 = ByteStreams.b((InputStream) b2.c(m()), (OutputStream) b2.c(byteSink.c()));
            b2.close();
            return b3;
        } catch (Throwable th) {
            b2.close();
            throw th;
        }
    }

    @CanIgnoreReturnValue
    public long g(OutputStream outputStream) throws IOException {
        Preconditions.E(outputStream);
        Closer b2 = Closer.b();
        try {
            long b3 = ByteStreams.b((InputStream) b2.c(m()), outputStream);
            b2.close();
            return b3;
        } catch (Throwable th) {
            b2.close();
            throw th;
        }
    }

    public HashCode j(HashFunction hashFunction) throws IOException {
        Hasher b2 = hashFunction.b();
        g(Funnels.a(b2));
        return b2.o();
    }

    public boolean k() throws IOException {
        Optional<Long> q = q();
        boolean z = false;
        if (q.e()) {
            return q.d().longValue() == 0;
        }
        Closer b2 = Closer.b();
        try {
            if (((InputStream) b2.c(m())).read() == -1) {
                z = true;
            }
            b2.close();
            return z;
        } catch (Throwable th) {
            b2.close();
            throw th;
        }
    }

    public InputStream l() throws IOException {
        InputStream m2 = m();
        return m2 instanceof BufferedInputStream ? (BufferedInputStream) m2 : new BufferedInputStream(m2);
    }

    public abstract InputStream m() throws IOException;

    @CanIgnoreReturnValue
    @ParametricNullness
    public <T> T n(ByteProcessor<T> byteProcessor) throws IOException {
        Preconditions.E(byteProcessor);
        Closer b2 = Closer.b();
        try {
            T o = ByteStreams.o((InputStream) b2.c(m()), byteProcessor);
            b2.close();
            return o;
        } catch (Throwable th) {
            b2.close();
            throw th;
        }
    }

    public byte[] o() throws IOException {
        Closer b2 = Closer.b();
        try {
            InputStream inputStream = (InputStream) b2.c(m());
            Optional<Long> q = q();
            byte[] v = q.e() ? ByteStreams.v(inputStream, q.d().longValue()) : ByteStreams.u(inputStream);
            b2.close();
            return v;
        } catch (Throwable th) {
            b2.close();
            throw th;
        }
    }

    public long p() throws IOException {
        Closer b2;
        Optional<Long> q = q();
        if (q.e()) {
            return q.d().longValue();
        }
        Closer b3 = Closer.b();
        try {
            long h2 = h((InputStream) b3.c(m()));
            b3.close();
            return h2;
        } catch (IOException unused) {
            b3.close();
            b2 = Closer.b();
            long e2 = ByteStreams.e((InputStream) b2.c(m()));
            b2.close();
            return e2;
        } catch (Throwable th) {
            try {
                throw b2.d(th);
            } catch (Throwable th2) {
                b2.close();
                throw th2;
            }
        }
    }

    public Optional<Long> q() {
        return Optional.a();
    }

    public ByteSource r(long j2, long j3) {
        return new SlicedByteSource(j2, j3);
    }
}
