package org.apache.commons.lang3.event;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.commons.lang3.Validate;

public class EventListenerSupport<L> implements Serializable {
    private static final long serialVersionUID = 3593265990380473632L;
    /* access modifiers changed from: private */
    public List<L> listeners;
    private transient L[] prototypeArray;
    private transient L proxy;

    protected class ProxyInvocationHandler implements InvocationHandler {
        protected ProxyInvocationHandler() {
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            for (Object invoke : EventListenerSupport.this.listeners) {
                method.invoke(invoke, objArr);
            }
            return null;
        }
    }

    private EventListenerSupport() {
        this.listeners = new CopyOnWriteArrayList();
    }

    public static <T> EventListenerSupport<T> create(Class<T> cls) {
        return new EventListenerSupport<>(cls);
    }

    private void createProxy(Class<L> cls, ClassLoader classLoader) {
        this.proxy = cls.cast(Proxy.newProxyInstance(classLoader, new Class[]{cls}, createInvocationHandler()));
    }

    private void initializeTransientFields(Class<L> cls, ClassLoader classLoader) {
        this.prototypeArray = (Object[]) Array.newInstance(cls, 0);
        createProxy(cls, classLoader);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        Object[] objArr = (Object[]) objectInputStream.readObject();
        this.listeners = new CopyOnWriteArrayList(objArr);
        initializeTransientFields(objArr.getClass().getComponentType(), Thread.currentThread().getContextClassLoader());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        ArrayList arrayList = new ArrayList();
        ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new ByteArrayOutputStream());
        for (L next : this.listeners) {
            try {
                objectOutputStream2.writeObject(next);
                arrayList.add(next);
            } catch (IOException unused) {
                objectOutputStream2 = new ObjectOutputStream(new ByteArrayOutputStream());
            }
        }
        objectOutputStream.writeObject(arrayList.toArray(this.prototypeArray));
    }

    public void addListener(L l2) {
        Validate.notNull(l2, "Listener object cannot be null.", new Object[0]);
        this.listeners.add(l2);
    }

    /* access modifiers changed from: protected */
    public InvocationHandler createInvocationHandler() {
        return new ProxyInvocationHandler();
    }

    public L fire() {
        return this.proxy;
    }

    /* access modifiers changed from: package-private */
    public int getListenerCount() {
        return this.listeners.size();
    }

    public L[] getListeners() {
        return this.listeners.toArray(this.prototypeArray);
    }

    public void removeListener(L l2) {
        Validate.notNull(l2, "Listener object cannot be null.", new Object[0]);
        this.listeners.remove(l2);
    }

    public EventListenerSupport(Class<L> cls) {
        this(cls, Thread.currentThread().getContextClassLoader());
    }

    public EventListenerSupport(Class<L> cls, ClassLoader classLoader) {
        this();
        Validate.notNull(cls, "Listener interface cannot be null.", new Object[0]);
        Validate.notNull(classLoader, "ClassLoader cannot be null.", new Object[0]);
        Validate.isTrue(cls.isInterface(), "Class {0} is not an interface", cls.getName());
        initializeTransientFields(cls, classLoader);
    }
}
