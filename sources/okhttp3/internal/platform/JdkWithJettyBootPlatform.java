package okhttp3.internal.platform;

import com.itextpdf.tool.xml.html.HTML;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;
import okhttp3.Protocol;
import okhttp3.internal.Util;

class JdkWithJettyBootPlatform extends Platform {

    /* renamed from: e  reason: collision with root package name */
    private final Method f31241e;

    /* renamed from: f  reason: collision with root package name */
    private final Method f31242f;

    /* renamed from: g  reason: collision with root package name */
    private final Method f31243g;

    /* renamed from: h  reason: collision with root package name */
    private final Class<?> f31244h;

    /* renamed from: i  reason: collision with root package name */
    private final Class<?> f31245i;

    private static class JettyNegoProvider implements InvocationHandler {

        /* renamed from: a  reason: collision with root package name */
        private final List<String> f31246a;

        /* renamed from: b  reason: collision with root package name */
        boolean f31247b;

        /* renamed from: c  reason: collision with root package name */
        String f31248c;

        JettyNegoProvider(List<String> list) {
            this.f31246a = list;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            Object obj2;
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = Util.f30971b;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.TRUE;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f31247b = true;
                return null;
            } else if (name.equals("protocols") && objArr.length == 0) {
                return this.f31246a;
            } else {
                if ((name.equals("selectProtocol") || name.equals(HTML.Tag.L0)) && String.class == returnType && objArr.length == 1) {
                    Object obj3 = objArr[0];
                    if (obj3 instanceof List) {
                        List list = (List) obj3;
                        int size = list.size();
                        int i2 = 0;
                        while (true) {
                            if (i2 >= size) {
                                obj2 = this.f31246a.get(0);
                                break;
                            } else if (this.f31246a.contains(list.get(i2))) {
                                obj2 = list.get(i2);
                                break;
                            } else {
                                i2++;
                            }
                        }
                        String str = (String) obj2;
                        this.f31248c = str;
                        return str;
                    }
                }
                if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                    return method.invoke(this, objArr);
                }
                this.f31248c = (String) objArr[0];
                return null;
            }
        }
    }

    JdkWithJettyBootPlatform(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.f31241e = method;
        this.f31242f = method2;
        this.f31243g = method3;
        this.f31244h = cls;
        this.f31245i = cls2;
    }

    public static Platform v() {
        Class<SSLSocket> cls = SSLSocket.class;
        try {
            Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN");
            Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$Provider");
            Class<?> cls4 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$ClientProvider");
            Class<?> cls5 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$ServerProvider");
            return new JdkWithJettyBootPlatform(cls2.getMethod("put", new Class[]{cls, cls3}), cls2.getMethod("get", new Class[]{cls}), cls2.getMethod("remove", new Class[]{cls}), cls4, cls5);
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }

    public void a(SSLSocket sSLSocket) {
        try {
            this.f31243g.invoke((Object) null, new Object[]{sSLSocket});
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw Util.b("unable to remove alpn", e2);
        }
    }

    public void h(SSLSocket sSLSocket, String str, List<Protocol> list) {
        List<String> b2 = Platform.b(list);
        try {
            Object newProxyInstance = Proxy.newProxyInstance(Platform.class.getClassLoader(), new Class[]{this.f31244h, this.f31245i}, new JettyNegoProvider(b2));
            this.f31241e.invoke((Object) null, new Object[]{sSLSocket, newProxyInstance});
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw Util.b("unable to set alpn", e2);
        }
    }

    @Nullable
    public String n(SSLSocket sSLSocket) {
        try {
            JettyNegoProvider jettyNegoProvider = (JettyNegoProvider) Proxy.getInvocationHandler(this.f31242f.invoke((Object) null, new Object[]{sSLSocket}));
            boolean z = jettyNegoProvider.f31247b;
            if (!z && jettyNegoProvider.f31248c == null) {
                Platform.k().r(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", (Throwable) null);
                return null;
            } else if (z) {
                return null;
            } else {
                return jettyNegoProvider.f31248c;
            }
        } catch (InvocationTargetException e2) {
            e = e2;
            throw Util.b("unable to get selected protocol", e);
        } catch (IllegalAccessException e3) {
            e = e3;
            throw Util.b("unable to get selected protocol", e);
        }
    }
}
