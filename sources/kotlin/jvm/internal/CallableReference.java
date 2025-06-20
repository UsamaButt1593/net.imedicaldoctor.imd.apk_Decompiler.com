package kotlin.jvm.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import kotlin.SinceKotlin;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.reflect.KCallable;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KParameter;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;

public abstract class CallableReference implements KCallable, Serializable {
    @SinceKotlin(version = "1.1")
    public static final Object Z2 = NoReceiver.s;
    @SinceKotlin(version = "1.1")
    protected final Object X;
    @SinceKotlin(version = "1.4")
    private final String X2;
    @SinceKotlin(version = "1.4")
    private final Class Y;
    @SinceKotlin(version = "1.4")
    private final boolean Y2;
    @SinceKotlin(version = "1.4")
    private final String Z;
    private transient KCallable s;

    @SinceKotlin(version = "1.2")
    private static class NoReceiver implements Serializable {
        /* access modifiers changed from: private */
        public static final NoReceiver s = new NoReceiver();

        private NoReceiver() {
        }

        private Object b() throws ObjectStreamException {
            return s;
        }
    }

    public CallableReference() {
        this(Z2);
    }

    /* access modifiers changed from: protected */
    @SinceKotlin(version = "1.1")
    public KCallable A0() {
        KCallable w0 = w0();
        if (w0 != this) {
            return w0;
        }
        throw new KotlinReflectionNotSupportedError();
    }

    public String B0() {
        return this.X2;
    }

    public Object S(Map map) {
        return A0().S(map);
    }

    @SinceKotlin(version = "1.1")
    public KVisibility b() {
        return A0().b();
    }

    @SinceKotlin(version = "1.1")
    public boolean d() {
        return A0().d();
    }

    public List<KParameter> g() {
        return A0().g();
    }

    public List<Annotation> getAnnotations() {
        return A0().getAnnotations();
    }

    public String getName() {
        return this.Z;
    }

    @SinceKotlin(version = "1.1")
    public List<KTypeParameter> h() {
        return A0().h();
    }

    @SinceKotlin(version = "1.1")
    public boolean i() {
        return A0().i();
    }

    @SinceKotlin(version = "1.1")
    public boolean isOpen() {
        return A0().isOpen();
    }

    @SinceKotlin(version = "1.3")
    public boolean k() {
        return A0().k();
    }

    public KType n0() {
        return A0().n0();
    }

    public Object u0(Object... objArr) {
        return A0().u0(objArr);
    }

    @SinceKotlin(version = "1.1")
    public KCallable w0() {
        KCallable kCallable = this.s;
        if (kCallable != null) {
            return kCallable;
        }
        KCallable x0 = x0();
        this.s = x0;
        return x0;
    }

    /* access modifiers changed from: protected */
    public abstract KCallable x0();

    @SinceKotlin(version = "1.1")
    public Object y0() {
        return this.X;
    }

    public KDeclarationContainer z0() {
        Class cls = this.Y;
        if (cls == null) {
            return null;
        }
        return this.Y2 ? Reflection.g(cls) : Reflection.d(cls);
    }

    @SinceKotlin(version = "1.1")
    protected CallableReference(Object obj) {
        this(obj, (Class) null, (String) null, (String) null, false);
    }

    @SinceKotlin(version = "1.4")
    protected CallableReference(Object obj, Class cls, String str, String str2, boolean z) {
        this.X = obj;
        this.Y = cls;
        this.Z = str;
        this.X2 = str2;
        this.Y2 = z;
    }
}
