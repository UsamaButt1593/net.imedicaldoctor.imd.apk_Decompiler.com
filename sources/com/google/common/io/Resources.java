package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
public final class Resources {

    private static final class UrlByteSource extends ByteSource {

        /* renamed from: a  reason: collision with root package name */
        private final URL f22798a;

        private UrlByteSource(URL url) {
            this.f22798a = (URL) Preconditions.E(url);
        }

        public InputStream m() throws IOException {
            return this.f22798a.openStream();
        }

        public String toString() {
            return "Resources.asByteSource(" + this.f22798a + ")";
        }
    }

    private Resources() {
    }

    public static ByteSource a(URL url) {
        return new UrlByteSource(url);
    }

    public static CharSource b(URL url, Charset charset) {
        return a(url).a(charset);
    }

    public static void c(URL url, OutputStream outputStream) throws IOException {
        a(url).g(outputStream);
    }

    @CanIgnoreReturnValue
    public static URL d(Class<?> cls, String str) {
        URL resource = cls.getResource(str);
        Preconditions.y(resource != null, "resource %s relative to %s not found.", str, cls.getName());
        return resource;
    }

    @CanIgnoreReturnValue
    public static URL e(String str) {
        URL resource = ((ClassLoader) MoreObjects.a(Thread.currentThread().getContextClassLoader(), Resources.class.getClassLoader())).getResource(str);
        Preconditions.u(resource != null, "resource %s not found.", str);
        return resource;
    }

    @CanIgnoreReturnValue
    @ParametricNullness
    public static <T> T f(URL url, Charset charset, LineProcessor<T> lineProcessor) throws IOException {
        return b(url, charset).q(lineProcessor);
    }

    public static List<String> g(URL url, Charset charset) throws IOException {
        return (List) f(url, charset, new LineProcessor<List<String>>() {

            /* renamed from: a  reason: collision with root package name */
            final List<String> f22797a = Lists.q();

            public boolean b(String str) {
                this.f22797a.add(str);
                return true;
            }

            /* renamed from: c */
            public List<String> a() {
                return this.f22797a;
            }
        });
    }

    public static byte[] h(URL url) throws IOException {
        return a(url).o();
    }

    public static String i(URL url, Charset charset) throws IOException {
        return b(url, charset).n();
    }
}
