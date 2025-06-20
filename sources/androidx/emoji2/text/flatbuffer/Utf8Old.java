package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.StandardCharsets;

public class Utf8Old extends Utf8 {

    /* renamed from: b  reason: collision with root package name */
    private static final ThreadLocal<Cache> f7778b = ThreadLocal.withInitial(new b());

    private static class Cache {

        /* renamed from: a  reason: collision with root package name */
        final CharsetEncoder f7779a;

        /* renamed from: b  reason: collision with root package name */
        final CharsetDecoder f7780b;

        /* renamed from: c  reason: collision with root package name */
        CharSequence f7781c = null;

        /* renamed from: d  reason: collision with root package name */
        ByteBuffer f7782d = null;

        Cache() {
            Charset charset = StandardCharsets.UTF_8;
            this.f7779a = charset.newEncoder();
            this.f7780b = charset.newDecoder();
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Cache g() {
        return new Cache();
    }

    public String a(ByteBuffer byteBuffer, int i2, int i3) {
        CharsetDecoder charsetDecoder = f7778b.get().f7780b;
        charsetDecoder.reset();
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.position(i2);
        duplicate.limit(i2 + i3);
        try {
            return charsetDecoder.decode(duplicate).toString();
        } catch (CharacterCodingException e2) {
            throw new IllegalArgumentException("Bad encoding", e2);
        }
    }

    public void b(CharSequence charSequence, ByteBuffer byteBuffer) {
        Cache cache = f7778b.get();
        if (cache.f7781c != charSequence) {
            c(charSequence);
        }
        byteBuffer.put(cache.f7782d);
    }

    public int c(CharSequence charSequence) {
        Cache cache = f7778b.get();
        int length = (int) (((float) charSequence.length()) * cache.f7779a.maxBytesPerChar());
        ByteBuffer byteBuffer = cache.f7782d;
        if (byteBuffer == null || byteBuffer.capacity() < length) {
            cache.f7782d = ByteBuffer.allocate(Math.max(128, length));
        }
        cache.f7782d.clear();
        cache.f7781c = charSequence;
        CoderResult encode = cache.f7779a.encode(charSequence instanceof CharBuffer ? (CharBuffer) charSequence : CharBuffer.wrap(charSequence), cache.f7782d, true);
        if (encode.isError()) {
            try {
                encode.throwException();
            } catch (CharacterCodingException e2) {
                throw new IllegalArgumentException("bad character encoding", e2);
            }
        }
        cache.f7782d.flip();
        return cache.f7782d.remaining();
    }
}
