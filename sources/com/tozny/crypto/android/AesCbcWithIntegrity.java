package com.tozny.crypto.android;

import android.os.Build;
import android.os.Process;
import android.util.Base64;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.RendererCapabilities;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.SecureRandomSpi;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class AesCbcWithIntegrity {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f28216a = false;

    /* renamed from: b  reason: collision with root package name */
    private static final String f28217b = "AES/CBC/PKCS5Padding";

    /* renamed from: c  reason: collision with root package name */
    private static final String f28218c = "AES";

    /* renamed from: d  reason: collision with root package name */
    private static final String f28219d = "SHA1PRNG";

    /* renamed from: e  reason: collision with root package name */
    private static final int f28220e = 128;

    /* renamed from: f  reason: collision with root package name */
    private static final int f28221f = 16;

    /* renamed from: g  reason: collision with root package name */
    private static final int f28222g = 10000;

    /* renamed from: h  reason: collision with root package name */
    private static final int f28223h = 128;

    /* renamed from: i  reason: collision with root package name */
    private static final String f28224i = "PBKDF2WithHmacSHA1";

    /* renamed from: j  reason: collision with root package name */
    public static final int f28225j = 2;

    /* renamed from: k  reason: collision with root package name */
    static final AtomicBoolean f28226k = new AtomicBoolean(false);

    /* renamed from: l  reason: collision with root package name */
    private static final String f28227l = "HmacSHA256";

    /* renamed from: m  reason: collision with root package name */
    private static final int f28228m = 256;

    public static class CipherTextIvMac {

        /* renamed from: a  reason: collision with root package name */
        private final byte[] f28229a;

        /* renamed from: b  reason: collision with root package name */
        private final byte[] f28230b;

        /* renamed from: c  reason: collision with root package name */
        private final byte[] f28231c;

        public CipherTextIvMac(String str) {
            String[] split = str.split(":");
            if (split.length == 3) {
                this.f28230b = Base64.decode(split[0], 2);
                this.f28231c = Base64.decode(split[1], 2);
                this.f28229a = Base64.decode(split[2], 2);
                return;
            }
            throw new IllegalArgumentException("Cannot parse iv:ciphertext:mac");
        }

        public static byte[] d(byte[] bArr, byte[] bArr2) {
            byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
            System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
            System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
            return bArr3;
        }

        public byte[] a() {
            return this.f28229a;
        }

        public byte[] b() {
            return this.f28230b;
        }

        public byte[] c() {
            return this.f28231c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            CipherTextIvMac cipherTextIvMac = (CipherTextIvMac) obj;
            return Arrays.equals(this.f28229a, cipherTextIvMac.f28229a) && Arrays.equals(this.f28230b, cipherTextIvMac.f28230b) && Arrays.equals(this.f28231c, cipherTextIvMac.f28231c);
        }

        public int hashCode() {
            return ((((Arrays.hashCode(this.f28229a) + 31) * 31) + Arrays.hashCode(this.f28230b)) * 31) + Arrays.hashCode(this.f28231c);
        }

        public String toString() {
            String encodeToString = Base64.encodeToString(this.f28230b, 2);
            String encodeToString2 = Base64.encodeToString(this.f28229a, 2);
            String encodeToString3 = Base64.encodeToString(this.f28231c, 2);
            return String.format(encodeToString + ":" + encodeToString3 + ":" + encodeToString2, new Object[0]);
        }

        public CipherTextIvMac(byte[] bArr, byte[] bArr2, byte[] bArr3) {
            byte[] bArr4 = new byte[bArr.length];
            this.f28229a = bArr4;
            System.arraycopy(bArr, 0, bArr4, 0, bArr.length);
            byte[] bArr5 = new byte[bArr2.length];
            this.f28230b = bArr5;
            System.arraycopy(bArr2, 0, bArr5, 0, bArr2.length);
            byte[] bArr6 = new byte[bArr3.length];
            this.f28231c = bArr6;
            System.arraycopy(bArr3, 0, bArr6, 0, bArr3.length);
        }
    }

    public static final class PrngFixes {

        /* renamed from: a  reason: collision with root package name */
        private static final int f28232a = 16;

        /* renamed from: b  reason: collision with root package name */
        private static final int f28233b = 18;

        /* renamed from: c  reason: collision with root package name */
        private static final byte[] f28234c = e();

        public static class LinuxPRNGSecureRandom extends SecureRandomSpi {
            private static final File X = new File("/dev/urandom");
            private static OutputStream X2;
            private static final Object Y = new Object();
            private static DataInputStream Z;
            private boolean s;

            private DataInputStream a() {
                DataInputStream dataInputStream;
                synchronized (Y) {
                    if (Z == null) {
                        try {
                            Z = new DataInputStream(new FileInputStream(X));
                        } catch (IOException e2) {
                            throw new SecurityException("Failed to open " + X + " for reading", e2);
                        }
                    }
                    dataInputStream = Z;
                }
                return dataInputStream;
            }

            private OutputStream b() throws IOException {
                OutputStream outputStream;
                synchronized (Y) {
                    try {
                        if (X2 == null) {
                            X2 = new FileOutputStream(X);
                        }
                        outputStream = X2;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return outputStream;
            }

            /* access modifiers changed from: protected */
            public byte[] engineGenerateSeed(int i2) {
                byte[] bArr = new byte[i2];
                engineNextBytes(bArr);
                return bArr;
            }

            /* access modifiers changed from: protected */
            public void engineNextBytes(byte[] bArr) {
                DataInputStream a2;
                if (!this.s) {
                    engineSetSeed(PrngFixes.d());
                }
                try {
                    synchronized (Y) {
                        a2 = a();
                    }
                    synchronized (a2) {
                        a2.readFully(bArr);
                    }
                } catch (IOException e2) {
                    throw new SecurityException("Failed to read from " + X, e2);
                }
            }

            /* access modifiers changed from: protected */
            public void engineSetSeed(byte[] bArr) {
                OutputStream b2;
                try {
                    synchronized (Y) {
                        b2 = b();
                    }
                    b2.write(bArr);
                    b2.flush();
                } catch (IOException unused) {
                    try {
                        String simpleName = PrngFixes.class.getSimpleName();
                        Log.w(simpleName, "Failed to mix seed into " + X);
                    } catch (Throwable th) {
                        this.s = true;
                        throw th;
                    }
                }
                this.s = true;
            }
        }

        private static class LinuxPRNGSecureRandomProvider extends Provider {
            public LinuxPRNGSecureRandomProvider() {
                super("LinuxPRNG", 1.0d, "A Linux-specific random number provider that uses /dev/urandom");
                put("SecureRandom.SHA1PRNG", LinuxPRNGSecureRandom.class.getName());
                put("SecureRandom.SHA1PRNG ImplementedIn", ExifInterface.Y);
            }
        }

        private PrngFixes() {
        }

        public static void b() {
            c();
            g();
        }

        private static void c() throws SecurityException {
        }

        /* access modifiers changed from: private */
        public static byte[] d() {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                dataOutputStream.writeLong(System.currentTimeMillis());
                dataOutputStream.writeLong(System.nanoTime());
                dataOutputStream.writeInt(Process.myPid());
                dataOutputStream.writeInt(Process.myUid());
                dataOutputStream.write(f28234c);
                dataOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            } catch (IOException e2) {
                throw new SecurityException("Failed to generate seed", e2);
            }
        }

        private static byte[] e() {
            StringBuilder sb = new StringBuilder();
            String str = Build.FINGERPRINT;
            if (str != null) {
                sb.append(str);
            }
            String f2 = f();
            if (f2 != null) {
                sb.append(f2);
            }
            try {
                return sb.toString().getBytes("UTF-8");
            } catch (UnsupportedEncodingException unused) {
                throw new RuntimeException("UTF-8 encoding not supported");
            }
        }

        private static String f() {
            try {
                return (String) Build.class.getField("SERIAL").get((Object) null);
            } catch (Exception unused) {
                return null;
            }
        }

        private static void g() throws SecurityException {
        }
    }

    public static class SecretKeys {

        /* renamed from: a  reason: collision with root package name */
        private SecretKey f28235a;

        /* renamed from: b  reason: collision with root package name */
        private SecretKey f28236b;

        public SecretKeys(SecretKey secretKey, SecretKey secretKey2) {
            c(secretKey);
            d(secretKey2);
        }

        public SecretKey a() {
            return this.f28235a;
        }

        public SecretKey b() {
            return this.f28236b;
        }

        public void c(SecretKey secretKey) {
            this.f28235a = secretKey;
        }

        public void d(SecretKey secretKey) {
            this.f28236b = secretKey;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            SecretKeys secretKeys = (SecretKeys) obj;
            return this.f28236b.equals(secretKeys.f28236b) && this.f28235a.equals(secretKeys.f28235a);
        }

        public int hashCode() {
            return ((this.f28235a.hashCode() + 31) * 31) + this.f28236b.hashCode();
        }

        public String toString() {
            return Base64.encodeToString(a().getEncoded(), 2) + ":" + Base64.encodeToString(b().getEncoded(), 2);
        }
    }

    public static boolean a(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return false;
        }
        byte b2 = 0;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            b2 |= bArr[i2] ^ bArr2[i2];
        }
        return b2 == 0;
    }

    private static byte[] b(byte[] bArr, int i2, int i3) {
        int i4 = i3 - i2;
        byte[] bArr2 = new byte[i4];
        System.arraycopy(bArr, i2, bArr2, 0, i4);
        return bArr2;
    }

    public static byte[] c(CipherTextIvMac cipherTextIvMac, SecretKeys secretKeys) throws GeneralSecurityException {
        if (a(p(CipherTextIvMac.d(cipherTextIvMac.b(), cipherTextIvMac.a()), secretKeys.b()), cipherTextIvMac.c())) {
            Cipher instance = Cipher.getInstance(f28217b);
            instance.init(2, secretKeys.a(), new IvParameterSpec(cipherTextIvMac.b()));
            return instance.doFinal(cipherTextIvMac.a());
        }
        throw new GeneralSecurityException("MAC stored in civ does not match computed MAC.");
    }

    public static String d(CipherTextIvMac cipherTextIvMac, SecretKeys secretKeys) throws UnsupportedEncodingException, GeneralSecurityException {
        return e(cipherTextIvMac, secretKeys, "UTF-8");
    }

    public static String e(CipherTextIvMac cipherTextIvMac, SecretKeys secretKeys, String str) throws UnsupportedEncodingException, GeneralSecurityException {
        return new String(c(cipherTextIvMac, secretKeys), str);
    }

    public static CipherTextIvMac f(String str, SecretKeys secretKeys) throws UnsupportedEncodingException, GeneralSecurityException {
        return g(str, secretKeys, "UTF-8");
    }

    public static CipherTextIvMac g(String str, SecretKeys secretKeys, String str2) throws UnsupportedEncodingException, GeneralSecurityException {
        return h(str.getBytes(str2), secretKeys);
    }

    public static CipherTextIvMac h(byte[] bArr, SecretKeys secretKeys) throws GeneralSecurityException {
        byte[] j2 = j();
        Cipher instance = Cipher.getInstance(f28217b);
        instance.init(1, secretKeys.a(), new IvParameterSpec(j2));
        byte[] iv = instance.getIV();
        byte[] doFinal = instance.doFinal(bArr);
        return new CipherTextIvMac(doFinal, iv, p(CipherTextIvMac.d(iv, doFinal), secretKeys.b()));
    }

    private static void i() {
        AtomicBoolean atomicBoolean = f28226k;
        if (!atomicBoolean.get()) {
            synchronized (PrngFixes.class) {
                try {
                    if (!atomicBoolean.get()) {
                        PrngFixes.b();
                        atomicBoolean.set(true);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static byte[] j() throws GeneralSecurityException {
        return t(16);
    }

    public static SecretKeys k() throws GeneralSecurityException {
        i();
        KeyGenerator instance = KeyGenerator.getInstance(f28218c);
        instance.init(128);
        return new SecretKeys(instance.generateKey(), new SecretKeySpec(t(32), f28227l));
    }

    public static SecretKeys l(String str, String str2) throws GeneralSecurityException {
        return m(str, str2, 10000);
    }

    public static SecretKeys m(String str, String str2, int i2) throws GeneralSecurityException {
        return o(str, Base64.decode(str2, 2), i2);
    }

    public static SecretKeys n(String str, byte[] bArr) throws GeneralSecurityException {
        return o(str, bArr, 10000);
    }

    public static SecretKeys o(String str, byte[] bArr, int i2) throws GeneralSecurityException {
        i();
        byte[] encoded = SecretKeyFactory.getInstance(f28224i).generateSecret(new PBEKeySpec(str.toCharArray(), bArr, i2, RendererCapabilities.M)).getEncoded();
        return new SecretKeys(new SecretKeySpec(b(encoded, 0, 16), f28218c), new SecretKeySpec(b(encoded, 16, 48), f28227l));
    }

    public static byte[] p(byte[] bArr, SecretKey secretKey) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac instance = Mac.getInstance(f28227l);
        instance.init(secretKey);
        return instance.doFinal(bArr);
    }

    public static byte[] q() throws GeneralSecurityException {
        return t(128);
    }

    public static String r(SecretKeys secretKeys) {
        return secretKeys.toString();
    }

    public static SecretKeys s(String str) throws InvalidKeyException {
        String[] split = str.split(":");
        if (split.length == 2) {
            byte[] decode = Base64.decode(split[0], 2);
            if (decode.length == 16) {
                byte[] decode2 = Base64.decode(split[1], 2);
                if (decode2.length == 32) {
                    return new SecretKeys(new SecretKeySpec(decode, 0, decode.length, f28218c), new SecretKeySpec(decode2, f28227l));
                }
                throw new InvalidKeyException("Base64 decoded key is not 256 bytes");
            }
            throw new InvalidKeyException("Base64 decoded key is not 128 bytes");
        }
        throw new IllegalArgumentException("Cannot parse aesKey:hmacKey");
    }

    private static byte[] t(int i2) throws GeneralSecurityException {
        i();
        byte[] bArr = new byte[i2];
        SecureRandom.getInstance(f28219d).nextBytes(bArr);
        return bArr;
    }

    public static String u(byte[] bArr) {
        return Base64.encodeToString(bArr, 2);
    }
}
