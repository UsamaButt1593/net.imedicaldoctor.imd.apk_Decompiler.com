package com.itextpdf.text.io;

import com.itextpdf.text.pdf.PdfObject;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;

public class TempFileCache {

    /* renamed from: a  reason: collision with root package name */
    private String f25802a;

    /* renamed from: b  reason: collision with root package name */
    private RandomAccessFile f25803b;

    /* renamed from: c  reason: collision with root package name */
    private ByteArrayOutputStream f25804c;

    /* renamed from: d  reason: collision with root package name */
    private byte[] f25805d;

    public class ObjectPosition {

        /* renamed from: a  reason: collision with root package name */
        long f25806a;

        /* renamed from: b  reason: collision with root package name */
        int f25807b;

        ObjectPosition(long j2, int i2) {
            this.f25806a = j2;
            this.f25807b = i2;
        }
    }

    public TempFileCache(String str) throws IOException {
        this.f25802a = str;
        File parentFile = new File(str).getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        this.f25803b = new RandomAccessFile(str, "rw");
        this.f25804c = new ByteArrayOutputStream();
    }

    private byte[] c(int i2) {
        byte[] bArr = this.f25805d;
        if (bArr == null || bArr.length < i2) {
            this.f25805d = new byte[i2];
        }
        return this.f25805d;
    }

    public void a() throws IOException {
        this.f25803b.close();
        this.f25803b = null;
        new File(this.f25802a).delete();
    }

    public PdfObject b(ObjectPosition objectPosition) throws IOException, ClassNotFoundException {
        if (objectPosition == null) {
            return null;
        }
        this.f25803b.seek(objectPosition.f25806a);
        this.f25803b.read(c(objectPosition.f25807b), 0, objectPosition.f25807b);
        ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(c(objectPosition.f25807b)));
        try {
            return (PdfObject) objectInputStream.readObject();
        } finally {
            objectInputStream.close();
        }
    }

    public ObjectPosition d(PdfObject pdfObject) throws IOException {
        this.f25804c.reset();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(this.f25804c);
        long length = this.f25803b.length();
        objectOutputStream.writeObject(pdfObject);
        this.f25803b.seek(length);
        this.f25803b.write(this.f25804c.toByteArray());
        return new ObjectPosition(length, (int) (this.f25803b.length() - length));
    }
}
