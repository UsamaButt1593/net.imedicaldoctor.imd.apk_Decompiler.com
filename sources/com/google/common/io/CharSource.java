package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
public abstract class CharSource {

    private final class AsByteSource extends ByteSource {

        /* renamed from: a  reason: collision with root package name */
        final Charset f22769a;

        AsByteSource(Charset charset) {
            this.f22769a = (Charset) Preconditions.E(charset);
        }

        public CharSource a(Charset charset) {
            return charset.equals(this.f22769a) ? CharSource.this : super.a(charset);
        }

        public InputStream m() throws IOException {
            return new ReaderInputStream(CharSource.this.m(), this.f22769a, 8192);
        }

        public String toString() {
            return CharSource.this.toString() + ".asByteSource(" + this.f22769a + ")";
        }
    }

    private static class CharSequenceCharSource extends CharSource {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public static final Splitter f22771b = Splitter.l("\r\n|\n|\r");

        /* renamed from: a  reason: collision with root package name */
        protected final CharSequence f22772a;

        protected CharSequenceCharSource(CharSequence charSequence) {
            this.f22772a = (CharSequence) Preconditions.E(charSequence);
        }

        private Iterator<String> t() {
            return new AbstractIterator<String>() {
                Iterator<String> Y;

                {
                    this.Y = CharSequenceCharSource.f22771b.n(CharSequenceCharSource.this.f22772a).iterator();
                }

                /* access modifiers changed from: protected */
                @CheckForNull
                /* renamed from: d */
                public String a() {
                    if (this.Y.hasNext()) {
                        String next = this.Y.next();
                        if (this.Y.hasNext() || !next.isEmpty()) {
                            return next;
                        }
                    }
                    return (String) b();
                }
            };
        }

        public boolean i() {
            return this.f22772a.length() == 0;
        }

        public long j() {
            return (long) this.f22772a.length();
        }

        public Optional<Long> k() {
            return Optional.f(Long.valueOf((long) this.f22772a.length()));
        }

        public Reader m() {
            return new CharSequenceReader(this.f22772a);
        }

        public String n() {
            return this.f22772a.toString();
        }

        @CheckForNull
        public String o() {
            Iterator<String> t = t();
            if (t.hasNext()) {
                return t.next();
            }
            return null;
        }

        public ImmutableList<String> p() {
            return ImmutableList.C(t());
        }

        /* JADX WARNING: Removed duplicated region for block: B:1:0x0004 A[LOOP:0: B:1:0x0004->B:4:0x0014, LOOP_START] */
        @com.google.common.io.ParametricNullness
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public <T> T q(com.google.common.io.LineProcessor<T> r3) throws java.io.IOException {
            /*
                r2 = this;
                java.util.Iterator r0 = r2.t()
            L_0x0004:
                boolean r1 = r0.hasNext()
                if (r1 == 0) goto L_0x0016
                java.lang.Object r1 = r0.next()
                java.lang.String r1 = (java.lang.String) r1
                boolean r1 = r3.b(r1)
                if (r1 != 0) goto L_0x0004
            L_0x0016:
                java.lang.Object r3 = r3.a()
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.io.CharSource.CharSequenceCharSource.q(com.google.common.io.LineProcessor):java.lang.Object");
        }

        public String toString() {
            return "CharSource.wrap(" + Ascii.k(this.f22772a, 30, "...") + ")";
        }
    }

    private static final class ConcatenatedCharSource extends CharSource {

        /* renamed from: a  reason: collision with root package name */
        private final Iterable<? extends CharSource> f22773a;

        ConcatenatedCharSource(Iterable<? extends CharSource> iterable) {
            this.f22773a = (Iterable) Preconditions.E(iterable);
        }

        public boolean i() throws IOException {
            for (CharSource i2 : this.f22773a) {
                if (!i2.i()) {
                    return false;
                }
            }
            return true;
        }

        public long j() throws IOException {
            long j2 = 0;
            for (CharSource j3 : this.f22773a) {
                j2 += j3.j();
            }
            return j2;
        }

        public Optional<Long> k() {
            long j2 = 0;
            for (CharSource k2 : this.f22773a) {
                Optional<Long> k3 = k2.k();
                if (!k3.e()) {
                    return Optional.a();
                }
                j2 += k3.d().longValue();
            }
            return Optional.f(Long.valueOf(j2));
        }

        public Reader m() throws IOException {
            return new MultiReader(this.f22773a.iterator());
        }

        public String toString() {
            return "CharSource.concat(" + this.f22773a + ")";
        }
    }

    private static final class EmptyCharSource extends StringCharSource {
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public static final EmptyCharSource f22774c = new EmptyCharSource();

        private EmptyCharSource() {
            super("");
        }

        public String toString() {
            return "CharSource.empty()";
        }
    }

    private static class StringCharSource extends CharSequenceCharSource {
        protected StringCharSource(String str) {
            super(str);
        }

        public long e(CharSink charSink) throws IOException {
            Preconditions.E(charSink);
            Closer b2 = Closer.b();
            try {
                ((Writer) b2.c(charSink.b())).write((String) this.f22772a);
                long length = (long) this.f22772a.length();
                b2.close();
                return length;
            } catch (Throwable th) {
                b2.close();
                throw th;
            }
        }

        public long f(Appendable appendable) throws IOException {
            appendable.append(this.f22772a);
            return (long) this.f22772a.length();
        }

        public Reader m() {
            return new StringReader((String) this.f22772a);
        }
    }

    protected CharSource() {
    }

    public static CharSource b(Iterable<? extends CharSource> iterable) {
        return new ConcatenatedCharSource(iterable);
    }

    public static CharSource c(Iterator<? extends CharSource> it2) {
        return b(ImmutableList.C(it2));
    }

    public static CharSource d(CharSource... charSourceArr) {
        return b(ImmutableList.D(charSourceArr));
    }

    private long g(Reader reader) throws IOException {
        long j2 = 0;
        while (true) {
            long skip = reader.skip(Long.MAX_VALUE);
            if (skip == 0) {
                return j2;
            }
            j2 += skip;
        }
    }

    public static CharSource h() {
        return EmptyCharSource.f22774c;
    }

    public static CharSource r(CharSequence charSequence) {
        return charSequence instanceof String ? new StringCharSource((String) charSequence) : new CharSequenceCharSource(charSequence);
    }

    public ByteSource a(Charset charset) {
        return new AsByteSource(charset);
    }

    @CanIgnoreReturnValue
    public long e(CharSink charSink) throws IOException {
        Preconditions.E(charSink);
        Closer b2 = Closer.b();
        try {
            long b3 = CharStreams.b((Reader) b2.c(m()), (Writer) b2.c(charSink.b()));
            b2.close();
            return b3;
        } catch (Throwable th) {
            b2.close();
            throw th;
        }
    }

    @CanIgnoreReturnValue
    public long f(Appendable appendable) throws IOException {
        Preconditions.E(appendable);
        Closer b2 = Closer.b();
        try {
            long b3 = CharStreams.b((Reader) b2.c(m()), appendable);
            b2.close();
            return b3;
        } catch (Throwable th) {
            b2.close();
            throw th;
        }
    }

    public boolean i() throws IOException {
        Optional<Long> k2 = k();
        boolean z = false;
        if (k2.e()) {
            return k2.d().longValue() == 0;
        }
        Closer b2 = Closer.b();
        try {
            if (((Reader) b2.c(m())).read() == -1) {
                z = true;
            }
            b2.close();
            return z;
        } catch (Throwable th) {
            b2.close();
            throw th;
        }
    }

    public long j() throws IOException {
        Optional<Long> k2 = k();
        if (k2.e()) {
            return k2.d().longValue();
        }
        Closer b2 = Closer.b();
        try {
            long g2 = g((Reader) b2.c(m()));
            b2.close();
            return g2;
        } catch (Throwable th) {
            b2.close();
            throw th;
        }
    }

    public Optional<Long> k() {
        return Optional.a();
    }

    public BufferedReader l() throws IOException {
        Reader m2 = m();
        return m2 instanceof BufferedReader ? (BufferedReader) m2 : new BufferedReader(m2);
    }

    public abstract Reader m() throws IOException;

    public String n() throws IOException {
        Closer b2 = Closer.b();
        try {
            String k2 = CharStreams.k((Reader) b2.c(m()));
            b2.close();
            return k2;
        } catch (Throwable th) {
            b2.close();
            throw th;
        }
    }

    @CheckForNull
    public String o() throws IOException {
        Closer b2 = Closer.b();
        try {
            String readLine = ((BufferedReader) b2.c(l())).readLine();
            b2.close();
            return readLine;
        } catch (Throwable th) {
            b2.close();
            throw th;
        }
    }

    public ImmutableList<String> p() throws IOException {
        Closer b2 = Closer.b();
        try {
            BufferedReader bufferedReader = (BufferedReader) b2.c(l());
            ArrayList q = Lists.q();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    q.add(readLine);
                } else {
                    ImmutableList<String> B = ImmutableList.B(q);
                    b2.close();
                    return B;
                }
            }
        } catch (Throwable th) {
            b2.close();
            throw th;
        }
    }

    @CanIgnoreReturnValue
    @ParametricNullness
    public <T> T q(LineProcessor<T> lineProcessor) throws IOException {
        Preconditions.E(lineProcessor);
        Closer b2 = Closer.b();
        try {
            T h2 = CharStreams.h((Reader) b2.c(m()), lineProcessor);
            b2.close();
            return h2;
        } catch (Throwable th) {
            b2.close();
            throw th;
        }
    }
}
