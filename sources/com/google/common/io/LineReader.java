package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.ArrayDeque;
import java.util.Queue;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
@J2ktIncompatible
public final class LineReader {

    /* renamed from: a  reason: collision with root package name */
    private final Readable f22789a;
    @CheckForNull

    /* renamed from: b  reason: collision with root package name */
    private final Reader f22790b;

    /* renamed from: c  reason: collision with root package name */
    private final CharBuffer f22791c;

    /* renamed from: d  reason: collision with root package name */
    private final char[] f22792d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final Queue<String> f22793e = new ArrayDeque();

    /* renamed from: f  reason: collision with root package name */
    private final LineBuffer f22794f = new LineBuffer() {
        /* access modifiers changed from: protected */
        public void d(String str, String str2) {
            LineReader.this.f22793e.add(str);
        }
    };

    public LineReader(Readable readable) {
        CharBuffer e2 = CharStreams.e();
        this.f22791c = e2;
        this.f22792d = e2.array();
        this.f22789a = (Readable) Preconditions.E(readable);
        this.f22790b = readable instanceof Reader ? (Reader) readable : null;
    }

    @CheckForNull
    @CanIgnoreReturnValue
    public String b() throws IOException {
        int i2;
        while (true) {
            if (this.f22793e.peek() != null) {
                break;
            }
            Java8Compatibility.a(this.f22791c);
            Reader reader = this.f22790b;
            if (reader != null) {
                char[] cArr = this.f22792d;
                i2 = reader.read(cArr, 0, cArr.length);
            } else {
                i2 = this.f22789a.read(this.f22791c);
            }
            if (i2 == -1) {
                this.f22794f.b();
                break;
            }
            this.f22794f.a(this.f22792d, 0, i2);
        }
        return this.f22793e.poll();
    }
}
