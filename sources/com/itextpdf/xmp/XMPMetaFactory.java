package com.itextpdf.xmp;

import com.itextpdf.xmp.impl.XMPMetaImpl;
import com.itextpdf.xmp.impl.XMPMetaParser;
import com.itextpdf.xmp.impl.XMPSchemaRegistryImpl;
import com.itextpdf.xmp.impl.XMPSerializerHelper;
import com.itextpdf.xmp.options.ParseOptions;
import com.itextpdf.xmp.options.SerializeOptions;
import java.io.InputStream;
import java.io.OutputStream;

public final class XMPMetaFactory {

    /* renamed from: a  reason: collision with root package name */
    private static XMPSchemaRegistry f27736a = new XMPSchemaRegistryImpl();

    /* renamed from: b  reason: collision with root package name */
    private static XMPVersionInfo f27737b = null;

    private XMPMetaFactory() {
    }

    private static void a(XMPMeta xMPMeta) {
        if (!(xMPMeta instanceof XMPMetaImpl)) {
            throw new UnsupportedOperationException("The serializing service works onlywith the XMPMeta implementation of this library");
        }
    }

    public static XMPMeta b() {
        return new XMPMetaImpl();
    }

    public static XMPSchemaRegistry c() {
        return f27736a;
    }

    public static synchronized XMPVersionInfo d() {
        XMPVersionInfo xMPVersionInfo;
        synchronized (XMPMetaFactory.class) {
            try {
                if (f27737b == null) {
                    f27737b = new XMPVersionInfo() {
                        public boolean a() {
                            return false;
                        }

                        public String b() {
                            return "Adobe XMP Core 5.1.0-jc003";
                        }

                        public int c() {
                            return 0;
                        }

                        public int d() {
                            return 5;
                        }

                        public int e() {
                            return 1;
                        }

                        public int f() {
                            return 3;
                        }

                        public String toString() {
                            return "Adobe XMP Core 5.1.0-jc003";
                        }
                    };
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
            xMPVersionInfo = f27737b;
        }
        return xMPVersionInfo;
    }

    public static XMPMeta e(InputStream inputStream) throws XMPException {
        return f(inputStream, (ParseOptions) null);
    }

    public static XMPMeta f(InputStream inputStream, ParseOptions parseOptions) throws XMPException {
        return XMPMetaParser.c(inputStream, parseOptions);
    }

    public static XMPMeta g(byte[] bArr) throws XMPException {
        return h(bArr, (ParseOptions) null);
    }

    public static XMPMeta h(byte[] bArr, ParseOptions parseOptions) throws XMPException {
        return XMPMetaParser.c(bArr, parseOptions);
    }

    public static XMPMeta i(String str) throws XMPException {
        return j(str, (ParseOptions) null);
    }

    public static XMPMeta j(String str, ParseOptions parseOptions) throws XMPException {
        return XMPMetaParser.c(str, parseOptions);
    }

    public static void k() {
        f27736a = new XMPSchemaRegistryImpl();
    }

    public static void l(XMPMeta xMPMeta, OutputStream outputStream) throws XMPException {
        m(xMPMeta, outputStream, (SerializeOptions) null);
    }

    public static void m(XMPMeta xMPMeta, OutputStream outputStream, SerializeOptions serializeOptions) throws XMPException {
        a(xMPMeta);
        XMPSerializerHelper.a((XMPMetaImpl) xMPMeta, outputStream, serializeOptions);
    }

    public static byte[] n(XMPMeta xMPMeta, SerializeOptions serializeOptions) throws XMPException {
        a(xMPMeta);
        return XMPSerializerHelper.b((XMPMetaImpl) xMPMeta, serializeOptions);
    }

    public static String o(XMPMeta xMPMeta, SerializeOptions serializeOptions) throws XMPException {
        a(xMPMeta);
        return XMPSerializerHelper.c((XMPMetaImpl) xMPMeta, serializeOptions);
    }
}
