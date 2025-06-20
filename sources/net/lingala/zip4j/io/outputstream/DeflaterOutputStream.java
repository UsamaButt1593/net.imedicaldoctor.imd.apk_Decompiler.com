package net.lingala.zip4j.io.outputstream;

import java.io.IOException;
import java.util.zip.Deflater;
import net.lingala.zip4j.model.enums.CompressionLevel;

class DeflaterOutputStream extends CompressedOutputStream {
    private byte[] X = new byte[4096];
    protected Deflater Y;

    public DeflaterOutputStream(CipherOutputStream cipherOutputStream, CompressionLevel compressionLevel) {
        super(cipherOutputStream);
        this.Y = new Deflater(compressionLevel.a(), true);
    }

    private void d() throws IOException {
        Deflater deflater = this.Y;
        byte[] bArr = this.X;
        int deflate = deflater.deflate(bArr, 0, bArr.length);
        if (deflate > 0) {
            super.write(this.X, 0, deflate);
        }
    }

    public void b() throws IOException {
        if (!this.Y.finished()) {
            this.Y.finish();
            while (!this.Y.finished()) {
                d();
            }
        }
        this.Y.end();
        super.b();
    }

    public void write(int i2) throws IOException {
        write(new byte[]{(byte) i2}, 0, 1);
    }

    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i2, int i3) throws IOException {
        this.Y.setInput(bArr, i2, i3);
        while (!this.Y.needsInput()) {
            d();
        }
    }
}
