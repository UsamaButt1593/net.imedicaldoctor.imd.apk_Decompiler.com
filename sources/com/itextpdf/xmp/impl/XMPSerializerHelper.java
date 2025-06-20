package com.itextpdf.xmp.impl;

import com.itextpdf.xmp.XMPException;
import com.itextpdf.xmp.options.SerializeOptions;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public class XMPSerializerHelper {
    public static void a(XMPMetaImpl xMPMetaImpl, OutputStream outputStream, SerializeOptions serializeOptions) throws XMPException {
        if (serializeOptions == null) {
            serializeOptions = new SerializeOptions();
        }
        if (serializeOptions.C()) {
            xMPMetaImpl.v2();
        }
        new XMPSerializerRDF().i(xMPMetaImpl, outputStream, serializeOptions);
    }

    public static byte[] b(XMPMetaImpl xMPMetaImpl, SerializeOptions serializeOptions) throws XMPException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(2048);
        a(xMPMetaImpl, byteArrayOutputStream, serializeOptions);
        return byteArrayOutputStream.toByteArray();
    }

    public static String c(XMPMetaImpl xMPMetaImpl, SerializeOptions serializeOptions) throws XMPException {
        if (serializeOptions == null) {
            serializeOptions = new SerializeOptions();
        }
        serializeOptions.G(true);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(2048);
        a(xMPMetaImpl, byteArrayOutputStream, serializeOptions);
        try {
            return byteArrayOutputStream.toString(serializeOptions.s());
        } catch (UnsupportedEncodingException unused) {
            return byteArrayOutputStream.toString();
        }
    }
}
