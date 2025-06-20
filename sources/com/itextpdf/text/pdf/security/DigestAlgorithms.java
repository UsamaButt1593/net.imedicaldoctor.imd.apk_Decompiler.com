package com.itextpdf.text.pdf.security;

import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.HashMap;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

public class DigestAlgorithms {

    /* renamed from: a  reason: collision with root package name */
    public static final String f27271a = "SHA-1";

    /* renamed from: b  reason: collision with root package name */
    public static final String f27272b = "SHA-256";

    /* renamed from: c  reason: collision with root package name */
    public static final String f27273c = "SHA-384";

    /* renamed from: d  reason: collision with root package name */
    public static final String f27274d = "SHA-512";

    /* renamed from: e  reason: collision with root package name */
    public static final String f27275e = "RIPEMD160";

    /* renamed from: f  reason: collision with root package name */
    private static final HashMap<String, String> f27276f;

    /* renamed from: g  reason: collision with root package name */
    private static final HashMap<String, String> f27277g;

    /* renamed from: h  reason: collision with root package name */
    private static final HashMap<String, String> f27278h;

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        f27276f = hashMap;
        HashMap<String, String> hashMap2 = new HashMap<>();
        f27277g = hashMap2;
        HashMap<String, String> hashMap3 = new HashMap<>();
        f27278h = hashMap3;
        hashMap.put("1.2.840.113549.2.5", "MD5");
        hashMap.put("1.2.840.113549.2.2", MessageDigestAlgorithms.MD2);
        hashMap.put("1.3.14.3.2.26", SecurityConstants.o);
        hashMap.put("2.16.840.1.101.3.4.2.4", "SHA224");
        hashMap.put("2.16.840.1.101.3.4.2.1", "SHA256");
        hashMap.put("2.16.840.1.101.3.4.2.2", "SHA384");
        hashMap.put("2.16.840.1.101.3.4.2.3", "SHA512");
        hashMap.put("1.3.36.3.2.2", "RIPEMD128");
        hashMap.put("1.3.36.3.2.1", f27275e);
        hashMap.put("1.3.36.3.2.3", "RIPEMD256");
        hashMap.put("1.2.840.113549.1.1.4", "MD5");
        hashMap.put("1.2.840.113549.1.1.2", MessageDigestAlgorithms.MD2);
        hashMap.put("1.2.840.113549.1.1.5", SecurityConstants.o);
        hashMap.put("1.2.840.113549.1.1.14", "SHA224");
        hashMap.put("1.2.840.113549.1.1.11", "SHA256");
        hashMap.put("1.2.840.113549.1.1.12", "SHA384");
        hashMap.put("1.2.840.113549.1.1.13", "SHA512");
        hashMap.put("1.2.840.113549.2.5", "MD5");
        hashMap.put("1.2.840.113549.2.2", MessageDigestAlgorithms.MD2);
        hashMap.put("1.2.840.10040.4.3", SecurityConstants.o);
        hashMap.put("2.16.840.1.101.3.4.3.1", "SHA224");
        hashMap.put("2.16.840.1.101.3.4.3.2", "SHA256");
        hashMap.put("2.16.840.1.101.3.4.3.3", "SHA384");
        hashMap.put("2.16.840.1.101.3.4.3.4", "SHA512");
        hashMap.put("1.3.36.3.3.1.3", "RIPEMD128");
        hashMap.put("1.3.36.3.3.1.2", f27275e);
        hashMap.put("1.3.36.3.3.1.4", "RIPEMD256");
        hashMap.put("1.2.643.2.2.9", "GOST3411");
        hashMap2.put("SHA256", "SHA-256");
        hashMap2.put("SHA384", "SHA-384");
        hashMap2.put("SHA512", "SHA-512");
        hashMap3.put(MessageDigestAlgorithms.MD2, "1.2.840.113549.2.2");
        hashMap3.put("MD-2", "1.2.840.113549.2.2");
        hashMap3.put("MD5", "1.2.840.113549.2.5");
        hashMap3.put("MD-5", "1.2.840.113549.2.5");
        Object obj = "1.3.14.3.2.26";
        hashMap3.put(SecurityConstants.o, obj);
        hashMap3.put("SHA-1", obj);
        Object obj2 = "2.16.840.1.101.3.4.2.4";
        hashMap3.put("SHA224", obj2);
        hashMap3.put(MessageDigestAlgorithms.SHA_224, obj2);
        Object obj3 = "2.16.840.1.101.3.4.2.1";
        hashMap3.put("SHA256", obj3);
        hashMap3.put("SHA-256", obj3);
        Object obj4 = "2.16.840.1.101.3.4.2.2";
        hashMap3.put("SHA384", obj4);
        hashMap3.put("SHA-384", obj4);
        Object obj5 = "2.16.840.1.101.3.4.2.3";
        hashMap3.put("SHA512", obj5);
        hashMap3.put("SHA-512", obj5);
        Object obj6 = "1.3.36.3.2.2";
        hashMap3.put("RIPEMD128", obj6);
        hashMap3.put("RIPEMD-128", obj6);
        Object obj7 = "1.3.36.3.2.1";
        hashMap3.put(f27275e, obj7);
        hashMap3.put("RIPEMD-160", obj7);
        Object obj8 = "1.3.36.3.2.3";
        hashMap3.put("RIPEMD256", obj8);
        hashMap3.put("RIPEMD-256", obj8);
        hashMap3.put("GOST3411", "1.2.643.2.2.9");
    }

    public static byte[] a(InputStream inputStream, String str, String str2) throws GeneralSecurityException, IOException {
        return b(inputStream, e(str, str2));
    }

    public static byte[] b(InputStream inputStream, MessageDigest messageDigest) throws GeneralSecurityException, IOException {
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= 0) {
                return messageDigest.digest();
            }
            messageDigest.update(bArr, 0, read);
        }
    }

    public static String c(String str) {
        return f27278h.get(str.toUpperCase());
    }

    public static String d(String str) {
        String str2 = f27276f.get(str);
        return str2 == null ? str : str2;
    }

    public static MessageDigest e(String str, String str2) throws NoSuchAlgorithmException, NoSuchProviderException {
        return (str2 == null || str2.startsWith("SunPKCS11") || str2.startsWith("SunMSCAPI")) ? MessageDigest.getInstance(g(str)) : MessageDigest.getInstance(str, str2);
    }

    public static MessageDigest f(String str, String str2) throws NoSuchAlgorithmException, NoSuchProviderException {
        return e(d(str), str2);
    }

    public static String g(String str) {
        HashMap<String, String> hashMap = f27277g;
        return hashMap.containsKey(str) ? hashMap.get(str) : str;
    }
}
