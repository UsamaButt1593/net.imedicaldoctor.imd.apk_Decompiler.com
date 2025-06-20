package org.apache.commons.httpclient;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

class AutoCloseInputStream extends FilterInputStream {
    private boolean selfClosed = false;
    private boolean streamOpen = true;
    private ResponseConsumedWatcher watcher;

    public AutoCloseInputStream(InputStream inputStream, ResponseConsumedWatcher responseConsumedWatcher) {
        super(inputStream);
        this.watcher = responseConsumedWatcher;
    }

    private void checkClose(int i2) throws IOException {
        if (i2 == -1) {
            notifyWatcher();
        }
    }

    private boolean isReadAllowed() throws IOException {
        boolean z = this.streamOpen;
        if (z || !this.selfClosed) {
            return z;
        }
        throw new IOException("Attempted read on closed stream.");
    }

    private void notifyWatcher() throws IOException {
        if (this.streamOpen) {
            super.close();
            this.streamOpen = false;
            ResponseConsumedWatcher responseConsumedWatcher = this.watcher;
            if (responseConsumedWatcher != null) {
                responseConsumedWatcher.responseConsumed();
            }
        }
    }

    public int available() throws IOException {
        if (isReadAllowed()) {
            return super.available();
        }
        return 0;
    }

    public void close() throws IOException {
        if (!this.selfClosed) {
            this.selfClosed = true;
            notifyWatcher();
        }
    }

    public int read() throws IOException {
        if (!isReadAllowed()) {
            return -1;
        }
        int read = super.read();
        checkClose(read);
        return read;
    }

    public int read(byte[] bArr) throws IOException {
        if (!isReadAllowed()) {
            return -1;
        }
        int read = super.read(bArr);
        checkClose(read);
        return read;
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        if (!isReadAllowed()) {
            return -1;
        }
        int read = super.read(bArr, i2, i3);
        checkClose(read);
        return read;
    }
}
