package androidx.media3.extractor.metadata.icy;

import androidx.annotation.Nullable;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.metadata.MetadataInputBuffer;
import androidx.media3.extractor.metadata.SimpleMetadataDecoder;
import com.google.common.base.Ascii;
import com.google.common.base.Charsets;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@UnstableApi
public final class IcyDecoder extends SimpleMetadataDecoder {

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f13350c = Pattern.compile("(.+?)='(.*?)';", 32);

    /* renamed from: d  reason: collision with root package name */
    private static final String f13351d = "streamtitle";

    /* renamed from: e  reason: collision with root package name */
    private static final String f13352e = "streamurl";

    /* renamed from: a  reason: collision with root package name */
    private final CharsetDecoder f13353a = Charsets.f22255c.newDecoder();

    /* renamed from: b  reason: collision with root package name */
    private final CharsetDecoder f13354b = Charsets.f22254b.newDecoder();

    @Nullable
    private String c(ByteBuffer byteBuffer) {
        String charBuffer;
        CharsetDecoder charsetDecoder;
        try {
            charBuffer = this.f13353a.decode(byteBuffer).toString();
            charsetDecoder = this.f13353a;
        } catch (CharacterCodingException unused) {
            this.f13353a.reset();
            byteBuffer.rewind();
            try {
                charBuffer = this.f13354b.decode(byteBuffer).toString();
                charsetDecoder = this.f13354b;
            } catch (CharacterCodingException unused2) {
                this.f13354b.reset();
                byteBuffer.rewind();
                return null;
            } catch (Throwable th) {
                this.f13354b.reset();
                byteBuffer.rewind();
                throw th;
            }
        } catch (Throwable th2) {
            this.f13353a.reset();
            byteBuffer.rewind();
            throw th2;
        }
        charsetDecoder.reset();
        byteBuffer.rewind();
        return charBuffer;
    }

    /* access modifiers changed from: protected */
    public Metadata b(MetadataInputBuffer metadataInputBuffer, ByteBuffer byteBuffer) {
        String c2 = c(byteBuffer);
        byte[] bArr = new byte[byteBuffer.limit()];
        byteBuffer.get(bArr);
        String str = null;
        if (c2 == null) {
            return new Metadata(new IcyInfo(bArr, (String) null, (String) null));
        }
        Matcher matcher = f13350c.matcher(c2);
        String str2 = null;
        for (int i2 = 0; matcher.find(i2); i2 = matcher.end()) {
            String group = matcher.group(1);
            String group2 = matcher.group(2);
            if (group != null) {
                String g2 = Ascii.g(group);
                g2.hashCode();
                if (g2.equals(f13352e)) {
                    str2 = group2;
                } else if (g2.equals(f13351d)) {
                    str = group2;
                }
            }
        }
        return new Metadata(new IcyInfo(bArr, str, str2));
    }
}
