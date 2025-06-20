package androidx.media3.extractor.mkv;

import androidx.media3.common.ParserException;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.ExtractorInput;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@UnstableApi
public interface EbmlProcessor {

    /* renamed from: a  reason: collision with root package name */
    public static final int f13412a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f13413b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f13414c = 2;

    /* renamed from: d  reason: collision with root package name */
    public static final int f13415d = 3;

    /* renamed from: e  reason: collision with root package name */
    public static final int f13416e = 4;

    /* renamed from: f  reason: collision with root package name */
    public static final int f13417f = 5;

    @Documented
    @Target({java.lang.annotation.ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ElementType {
    }

    void a(int i2) throws ParserException;

    int b(int i2);

    boolean c(int i2);

    void d(int i2, String str) throws ParserException;

    void e(int i2, double d2) throws ParserException;

    void f(int i2, int i3, ExtractorInput extractorInput) throws IOException;

    void g(int i2, long j2, long j3) throws ParserException;

    void h(int i2, long j2) throws ParserException;
}
