package net.lingala.zip4j.crypto.PBKDF2;

interface PRF {
    byte[] a(byte[] bArr);

    int b();

    void c(byte[] bArr);
}
