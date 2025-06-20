package org.apache.commons.httpclient.protocol;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import org.apache.commons.httpclient.ConnectTimeoutException;
import org.apache.commons.httpclient.util.TimeoutController;

public final class ControllerThreadSocketFactory {

    public static abstract class SocketTask implements Runnable {
        /* access modifiers changed from: private */
        public IOException exception;
        private Socket socket;

        public abstract void doit() throws IOException;

        /* access modifiers changed from: protected */
        public Socket getSocket() {
            return this.socket;
        }

        public void run() {
            try {
                doit();
            } catch (IOException e2) {
                this.exception = e2;
            }
        }

        /* access modifiers changed from: protected */
        public void setSocket(Socket socket2) {
            this.socket = socket2;
        }
    }

    private ControllerThreadSocketFactory() {
    }

    public static Socket createSocket(SocketTask socketTask, int i2) throws IOException, UnknownHostException, ConnectTimeoutException {
        try {
            TimeoutController.execute((Runnable) socketTask, (long) i2);
            Socket socket = socketTask.getSocket();
            if (socketTask.exception == null) {
                return socket;
            }
            throw socketTask.exception;
        } catch (TimeoutController.TimeoutException unused) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("The host did not accept the connection within timeout of ");
            stringBuffer.append(i2);
            stringBuffer.append(" ms");
            throw new ConnectTimeoutException(stringBuffer.toString());
        }
    }

    public static Socket createSocket(ProtocolSocketFactory protocolSocketFactory, String str, int i2, InetAddress inetAddress, int i3, int i4) throws IOException, UnknownHostException, ConnectTimeoutException {
        final ProtocolSocketFactory protocolSocketFactory2 = protocolSocketFactory;
        final String str2 = str;
        final int i5 = i2;
        final InetAddress inetAddress2 = inetAddress;
        final int i6 = i3;
        AnonymousClass1 r0 = new SocketTask() {
            public void doit() throws IOException {
                setSocket(ProtocolSocketFactory.this.createSocket(str2, i5, inetAddress2, i6));
            }
        };
        try {
            TimeoutController.execute((Runnable) r0, (long) i4);
            Socket socket = r0.getSocket();
            if (r0.exception == null) {
                return socket;
            }
            throw r0.exception;
        } catch (TimeoutController.TimeoutException unused) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("The host did not accept the connection within timeout of ");
            stringBuffer.append(i4);
            stringBuffer.append(" ms");
            throw new ConnectTimeoutException(stringBuffer.toString());
        }
    }
}
