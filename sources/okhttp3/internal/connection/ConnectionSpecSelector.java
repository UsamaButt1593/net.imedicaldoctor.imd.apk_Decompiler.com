package okhttp3.internal.connection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;
import okhttp3.ConnectionSpec;
import okhttp3.internal.Internal;

public final class ConnectionSpecSelector {

    /* renamed from: a  reason: collision with root package name */
    private final List<ConnectionSpec> f31027a;

    /* renamed from: b  reason: collision with root package name */
    private int f31028b = 0;

    /* renamed from: c  reason: collision with root package name */
    private boolean f31029c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f31030d;

    public ConnectionSpecSelector(List<ConnectionSpec> list) {
        this.f31027a = list;
    }

    private boolean c(SSLSocket sSLSocket) {
        for (int i2 = this.f31028b; i2 < this.f31027a.size(); i2++) {
            if (this.f31027a.get(i2).c(sSLSocket)) {
                return true;
            }
        }
        return false;
    }

    public ConnectionSpec a(SSLSocket sSLSocket) throws IOException {
        ConnectionSpec connectionSpec;
        int i2 = this.f31028b;
        int size = this.f31027a.size();
        while (true) {
            if (i2 >= size) {
                connectionSpec = null;
                break;
            }
            connectionSpec = this.f31027a.get(i2);
            i2++;
            if (connectionSpec.c(sSLSocket)) {
                this.f31028b = i2;
                break;
            }
        }
        if (connectionSpec != null) {
            this.f31029c = c(sSLSocket);
            Internal.f30969a.c(connectionSpec, sSLSocket, this.f31030d);
            return connectionSpec;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f31030d + ", modes=" + this.f31027a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
    }

    public boolean b(IOException iOException) {
        this.f31030d = true;
        if (!this.f31029c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z = iOException instanceof SSLHandshakeException;
        if ((!z || !(iOException.getCause() instanceof CertificateException)) && !(iOException instanceof SSLPeerUnverifiedException)) {
            return z || (iOException instanceof SSLProtocolException) || (iOException instanceof SSLException);
        }
        return false;
    }
}
