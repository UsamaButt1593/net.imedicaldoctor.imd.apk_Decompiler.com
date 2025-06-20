package androidx.media3.datasource;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketTimeoutException;

@UnstableApi
public final class UdpDataSource extends BaseDataSource {
    public static final int o = 2000;
    public static final int p = 8000;
    public static final int q = -1;

    /* renamed from: f  reason: collision with root package name */
    private final int f9907f;

    /* renamed from: g  reason: collision with root package name */
    private final byte[] f9908g;

    /* renamed from: h  reason: collision with root package name */
    private final DatagramPacket f9909h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private Uri f9910i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private DatagramSocket f9911j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private MulticastSocket f9912k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private InetAddress f9913l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f9914m;

    /* renamed from: n  reason: collision with root package name */
    private int f9915n;

    public static final class UdpDataSourceException extends DataSourceException {
        public UdpDataSourceException(Throwable th, int i2) {
            super(th, i2);
        }
    }

    public UdpDataSource() {
        this(2000);
    }

    public long a(DataSpec dataSpec) throws UdpDataSourceException {
        Uri uri = dataSpec.f9779a;
        this.f9910i = uri;
        String str = (String) Assertions.g(uri.getHost());
        int port = this.f9910i.getPort();
        v(dataSpec);
        try {
            this.f9913l = InetAddress.getByName(str);
            InetSocketAddress inetSocketAddress = new InetSocketAddress(this.f9913l, port);
            if (this.f9913l.isMulticastAddress()) {
                MulticastSocket multicastSocket = new MulticastSocket(inetSocketAddress);
                this.f9912k = multicastSocket;
                multicastSocket.joinGroup(this.f9913l);
                this.f9911j = this.f9912k;
            } else {
                this.f9911j = new DatagramSocket(inetSocketAddress);
            }
            this.f9911j.setSoTimeout(this.f9907f);
            this.f9914m = true;
            w(dataSpec);
            return -1;
        } catch (SecurityException e2) {
            throw new UdpDataSourceException(e2, PlaybackException.g3);
        } catch (IOException e3) {
            throw new UdpDataSourceException(e3, PlaybackException.b3);
        }
    }

    @Nullable
    public Uri c() {
        return this.f9910i;
    }

    public void close() {
        this.f9910i = null;
        MulticastSocket multicastSocket = this.f9912k;
        if (multicastSocket != null) {
            try {
                multicastSocket.leaveGroup((InetAddress) Assertions.g(this.f9913l));
            } catch (IOException unused) {
            }
            this.f9912k = null;
        }
        DatagramSocket datagramSocket = this.f9911j;
        if (datagramSocket != null) {
            datagramSocket.close();
            this.f9911j = null;
        }
        this.f9913l = null;
        this.f9915n = 0;
        if (this.f9914m) {
            this.f9914m = false;
            u();
        }
    }

    public int read(byte[] bArr, int i2, int i3) throws UdpDataSourceException {
        if (i3 == 0) {
            return 0;
        }
        if (this.f9915n == 0) {
            try {
                ((DatagramSocket) Assertions.g(this.f9911j)).receive(this.f9909h);
                int length = this.f9909h.getLength();
                this.f9915n = length;
                t(length);
            } catch (SocketTimeoutException e2) {
                throw new UdpDataSourceException(e2, PlaybackException.c3);
            } catch (IOException e3) {
                throw new UdpDataSourceException(e3, PlaybackException.b3);
            }
        }
        int length2 = this.f9909h.getLength();
        int i4 = this.f9915n;
        int min = Math.min(i4, i3);
        System.arraycopy(this.f9908g, length2 - i4, bArr, i2, min);
        this.f9915n -= min;
        return min;
    }

    public int x() {
        DatagramSocket datagramSocket = this.f9911j;
        if (datagramSocket == null) {
            return -1;
        }
        return datagramSocket.getLocalPort();
    }

    public UdpDataSource(int i2) {
        this(i2, 8000);
    }

    public UdpDataSource(int i2, int i3) {
        super(true);
        this.f9907f = i3;
        byte[] bArr = new byte[i2];
        this.f9908g = bArr;
        this.f9909h = new DatagramPacket(bArr, 0, i2);
    }
}
