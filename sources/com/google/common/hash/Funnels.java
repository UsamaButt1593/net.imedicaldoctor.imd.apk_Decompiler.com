package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@Beta
public final class Funnels {

    private enum ByteArrayFunnel implements Funnel<byte[]> {
        INSTANCE;

        /* renamed from: b */
        public void s0(byte[] bArr, PrimitiveSink primitiveSink) {
            primitiveSink.g(bArr);
        }

        public String toString() {
            return "Funnels.byteArrayFunnel()";
        }
    }

    private enum IntegerFunnel implements Funnel<Integer> {
        INSTANCE;

        /* renamed from: b */
        public void s0(Integer num, PrimitiveSink primitiveSink) {
            primitiveSink.e(num.intValue());
        }

        public String toString() {
            return "Funnels.integerFunnel()";
        }
    }

    private enum LongFunnel implements Funnel<Long> {
        INSTANCE;

        /* renamed from: b */
        public void s0(Long l2, PrimitiveSink primitiveSink) {
            primitiveSink.f(l2.longValue());
        }

        public String toString() {
            return "Funnels.longFunnel()";
        }
    }

    private static class SequentialFunnel<E> implements Funnel<Iterable<? extends E>>, Serializable {
        private final Funnel<E> s;

        SequentialFunnel(Funnel<E> funnel) {
            this.s = (Funnel) Preconditions.E(funnel);
        }

        /* renamed from: a */
        public void s0(Iterable<? extends E> iterable, PrimitiveSink primitiveSink) {
            for (Object s0 : iterable) {
                this.s.s0(s0, primitiveSink);
            }
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof SequentialFunnel) {
                return this.s.equals(((SequentialFunnel) obj).s);
            }
            return false;
        }

        public int hashCode() {
            return SequentialFunnel.class.hashCode() ^ this.s.hashCode();
        }

        public String toString() {
            return "Funnels.sequentialFunnel(" + this.s + ")";
        }
    }

    private static class SinkAsStream extends OutputStream {
        final PrimitiveSink s;

        SinkAsStream(PrimitiveSink primitiveSink) {
            this.s = (PrimitiveSink) Preconditions.E(primitiveSink);
        }

        public String toString() {
            return "Funnels.asOutputStream(" + this.s + ")";
        }

        public void write(int i2) {
            this.s.h((byte) i2);
        }

        public void write(byte[] bArr) {
            this.s.g(bArr);
        }

        public void write(byte[] bArr, int i2, int i3) {
            this.s.j(bArr, i2, i3);
        }
    }

    private static class StringCharsetFunnel implements Funnel<CharSequence>, Serializable {
        private final Charset s;

        private static class SerializedForm implements Serializable {
            private static final long X = 0;
            private final String s;

            SerializedForm(Charset charset) {
                this.s = charset.name();
            }

            private Object a() {
                return Funnels.f(Charset.forName(this.s));
            }
        }

        StringCharsetFunnel(Charset charset) {
            this.s = (Charset) Preconditions.E(charset);
        }

        private void b(ObjectInputStream objectInputStream) throws InvalidObjectException {
            throw new InvalidObjectException("Use SerializedForm");
        }

        /* renamed from: a */
        public void s0(CharSequence charSequence, PrimitiveSink primitiveSink) {
            primitiveSink.m(charSequence, this.s);
        }

        /* access modifiers changed from: package-private */
        public Object c() {
            return new SerializedForm(this.s);
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof StringCharsetFunnel) {
                return this.s.equals(((StringCharsetFunnel) obj).s);
            }
            return false;
        }

        public int hashCode() {
            return StringCharsetFunnel.class.hashCode() ^ this.s.hashCode();
        }

        public String toString() {
            return "Funnels.stringFunnel(" + this.s.name() + ")";
        }
    }

    private enum UnencodedCharsFunnel implements Funnel<CharSequence> {
        INSTANCE;

        /* renamed from: b */
        public void s0(CharSequence charSequence, PrimitiveSink primitiveSink) {
            primitiveSink.i(charSequence);
        }

        public String toString() {
            return "Funnels.unencodedCharsFunnel()";
        }
    }

    private Funnels() {
    }

    public static OutputStream a(PrimitiveSink primitiveSink) {
        return new SinkAsStream(primitiveSink);
    }

    public static Funnel<byte[]> b() {
        return ByteArrayFunnel.INSTANCE;
    }

    public static Funnel<Integer> c() {
        return IntegerFunnel.INSTANCE;
    }

    public static Funnel<Long> d() {
        return LongFunnel.INSTANCE;
    }

    public static <E> Funnel<Iterable<? extends E>> e(Funnel<E> funnel) {
        return new SequentialFunnel(funnel);
    }

    public static Funnel<CharSequence> f(Charset charset) {
        return new StringCharsetFunnel(charset);
    }

    public static Funnel<CharSequence> g() {
        return UnencodedCharsFunnel.INSTANCE;
    }
}
