package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
public final class CharStreams {

    /* renamed from: a  reason: collision with root package name */
    private static final int f22775a = 2048;

    private static final class NullWriter extends Writer {
        /* access modifiers changed from: private */
        public static final NullWriter s = new NullWriter();

        private NullWriter() {
        }

        public Writer append(char c2) {
            return this;
        }

        public void close() {
        }

        public void flush() {
        }

        public String toString() {
            return "CharStreams.nullWriter()";
        }

        public void write(int i2) {
        }

        public Writer append(@CheckForNull CharSequence charSequence) {
            return this;
        }

        public void write(String str) {
            Preconditions.E(str);
        }

        public Writer append(@CheckForNull CharSequence charSequence, int i2, int i3) {
            Preconditions.f0(i2, i3, charSequence == null ? 4 : charSequence.length());
            return this;
        }

        public void write(String str, int i2, int i3) {
            Preconditions.f0(i2, i3 + i2, str.length());
        }

        public void write(char[] cArr) {
            Preconditions.E(cArr);
        }

        public void write(char[] cArr, int i2, int i3) {
            Preconditions.f0(i2, i3 + i2, cArr.length);
        }
    }

    private CharStreams() {
    }

    public static Writer a(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new AppendableWriter(appendable);
    }

    @CanIgnoreReturnValue
    public static long b(Readable readable, Appendable appendable) throws IOException {
        if (readable instanceof Reader) {
            Reader reader = (Reader) readable;
            return appendable instanceof StringBuilder ? c(reader, (StringBuilder) appendable) : d(reader, a(appendable));
        }
        Preconditions.E(readable);
        Preconditions.E(appendable);
        CharBuffer e2 = e();
        long j2 = 0;
        while (readable.read(e2) != -1) {
            Java8Compatibility.b(e2);
            appendable.append(e2);
            j2 += (long) e2.remaining();
            Java8Compatibility.a(e2);
        }
        return j2;
    }

    @CanIgnoreReturnValue
    static long c(Reader reader, StringBuilder sb) throws IOException {
        Preconditions.E(reader);
        Preconditions.E(sb);
        char[] cArr = new char[2048];
        long j2 = 0;
        while (true) {
            int read = reader.read(cArr);
            if (read == -1) {
                return j2;
            }
            sb.append(cArr, 0, read);
            j2 += (long) read;
        }
    }

    @CanIgnoreReturnValue
    static long d(Reader reader, Writer writer) throws IOException {
        Preconditions.E(reader);
        Preconditions.E(writer);
        char[] cArr = new char[2048];
        long j2 = 0;
        while (true) {
            int read = reader.read(cArr);
            if (read == -1) {
                return j2;
            }
            writer.write(cArr, 0, read);
            j2 += (long) read;
        }
    }

    static CharBuffer e() {
        return CharBuffer.allocate(2048);
    }

    @CanIgnoreReturnValue
    public static long f(Readable readable) throws IOException {
        CharBuffer e2 = e();
        long j2 = 0;
        while (true) {
            long read = (long) readable.read(e2);
            if (read == -1) {
                return j2;
            }
            j2 += read;
            Java8Compatibility.a(e2);
        }
    }

    public static Writer g() {
        return NullWriter.s;
    }

    @CanIgnoreReturnValue
    @ParametricNullness
    public static <T> T h(Readable readable, LineProcessor<T> lineProcessor) throws IOException {
        String b2;
        Preconditions.E(readable);
        Preconditions.E(lineProcessor);
        LineReader lineReader = new LineReader(readable);
        do {
            b2 = lineReader.b();
            if (b2 == null || !lineProcessor.b(b2)) {
            }
            b2 = lineReader.b();
            break;
        } while (!lineProcessor.b(b2));
        return lineProcessor.a();
    }

    public static List<String> i(Readable readable) throws IOException {
        ArrayList arrayList = new ArrayList();
        LineReader lineReader = new LineReader(readable);
        while (true) {
            String b2 = lineReader.b();
            if (b2 == null) {
                return arrayList;
            }
            arrayList.add(b2);
        }
    }

    public static void j(Reader reader, long j2) throws IOException {
        Preconditions.E(reader);
        while (j2 > 0) {
            long skip = reader.skip(j2);
            if (skip != 0) {
                j2 -= skip;
            } else {
                throw new EOFException();
            }
        }
    }

    public static String k(Readable readable) throws IOException {
        return l(readable).toString();
    }

    private static StringBuilder l(Readable readable) throws IOException {
        StringBuilder sb = new StringBuilder();
        if (readable instanceof Reader) {
            c((Reader) readable, sb);
        } else {
            b(readable, sb);
        }
        return sb;
    }
}
