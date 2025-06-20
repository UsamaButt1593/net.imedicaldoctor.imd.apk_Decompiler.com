package org.apache.commons.httpclient.protocol;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import org.apache.commons.httpclient.ConnectTimeoutException;

public final class ReflectionSocketFactory {
    private static Constructor INETSOCKETADDRESS_CONSTRUCTOR = null;
    private static boolean REFLECTION_FAILED = false;
    private static Method SOCKETBIND_METHOD;
    private static Method SOCKETCONNECT_METHOD;
    private static Class SOCKETTIMEOUTEXCEPTION_CLASS;
    static /* synthetic */ Class class$java$net$InetAddress;
    static /* synthetic */ Class class$java$net$Socket;

    private ReflectionSocketFactory() {
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    public static Socket createSocket(String str, String str2, int i2, InetAddress inetAddress, int i3, int i4) throws IOException, UnknownHostException, ConnectTimeoutException {
        if (REFLECTION_FAILED) {
            return null;
        }
        try {
            Class<?> cls = Class.forName(str);
            Socket socket = (Socket) cls.getMethod("createSocket", (Class[]) null).invoke(cls.getMethod("getDefault", (Class[]) null).invoke((Object) null, (Object[]) null), (Object[]) null);
            if (INETSOCKETADDRESS_CONSTRUCTOR == null) {
                Class<?> cls2 = Class.forName("java.net.InetSocketAddress");
                Class cls3 = class$java$net$InetAddress;
                if (cls3 == null) {
                    cls3 = class$("java.net.InetAddress");
                    class$java$net$InetAddress = cls3;
                }
                INETSOCKETADDRESS_CONSTRUCTOR = cls2.getConstructor(new Class[]{cls3, Integer.TYPE});
            }
            Object newInstance = INETSOCKETADDRESS_CONSTRUCTOR.newInstance(new Object[]{InetAddress.getByName(str2), new Integer(i2)});
            Object newInstance2 = INETSOCKETADDRESS_CONSTRUCTOR.newInstance(new Object[]{inetAddress, new Integer(i3)});
            if (SOCKETCONNECT_METHOD == null) {
                Class cls4 = class$java$net$Socket;
                if (cls4 == null) {
                    cls4 = class$("java.net.Socket");
                    class$java$net$Socket = cls4;
                }
                SOCKETCONNECT_METHOD = cls4.getMethod("connect", new Class[]{Class.forName("java.net.SocketAddress"), Integer.TYPE});
            }
            if (SOCKETBIND_METHOD == null) {
                Class cls5 = class$java$net$Socket;
                if (cls5 == null) {
                    cls5 = class$("java.net.Socket");
                    class$java$net$Socket = cls5;
                }
                SOCKETBIND_METHOD = cls5.getMethod("bind", new Class[]{Class.forName("java.net.SocketAddress")});
            }
            SOCKETBIND_METHOD.invoke(socket, new Object[]{newInstance2});
            SOCKETCONNECT_METHOD.invoke(socket, new Object[]{newInstance, new Integer(i4)});
            return socket;
        } catch (InvocationTargetException e2) {
            Throwable targetException = e2.getTargetException();
            if (SOCKETTIMEOUTEXCEPTION_CLASS == null) {
                try {
                    SOCKETTIMEOUTEXCEPTION_CLASS = Class.forName("java.net.SocketTimeoutException");
                } catch (ClassNotFoundException unused) {
                    REFLECTION_FAILED = true;
                    return null;
                }
            }
            if (SOCKETTIMEOUTEXCEPTION_CLASS.isInstance(targetException)) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("The host did not accept the connection within timeout of ");
                stringBuffer.append(i4);
                stringBuffer.append(" ms");
                throw new ConnectTimeoutException(stringBuffer.toString(), targetException);
            } else if (!(targetException instanceof IOException)) {
                return null;
            } else {
                throw ((IOException) targetException);
            }
        } catch (Exception unused2) {
            REFLECTION_FAILED = true;
            return null;
        }
    }
}
