package com.google.firebase.components;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.inject.Provider;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ComponentDiscovery<T> {

    /* renamed from: c  reason: collision with root package name */
    static final String f23378c = "ComponentDiscovery";

    /* renamed from: d  reason: collision with root package name */
    private static final String f23379d = "com.google.firebase.components.ComponentRegistrar";

    /* renamed from: e  reason: collision with root package name */
    private static final String f23380e = "com.google.firebase.components:";

    /* renamed from: a  reason: collision with root package name */
    private final T f23381a;

    /* renamed from: b  reason: collision with root package name */
    private final RegistrarNameRetriever<T> f23382b;

    private static class MetadataRegistrarNameRetriever implements RegistrarNameRetriever<Context> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<? extends Service> f23383a;

        private MetadataRegistrarNameRetriever(Class<? extends Service> cls) {
            this.f23383a = cls;
        }

        private Bundle b(Context context) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    Log.w(ComponentDiscovery.f23378c, "Context has no PackageManager.");
                    return null;
                }
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, this.f23383a), 128);
                if (serviceInfo != null) {
                    return serviceInfo.metaData;
                }
                Log.w(ComponentDiscovery.f23378c, this.f23383a + " has no service info.");
                return null;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w(ComponentDiscovery.f23378c, "Application info not found.");
                return null;
            }
        }

        /* renamed from: c */
        public List<String> a(Context context) {
            Bundle b2 = b(context);
            if (b2 == null) {
                Log.w(ComponentDiscovery.f23378c, "Could not retrieve metadata, returning empty list of registrars.");
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (String next : b2.keySet()) {
                if (ComponentDiscovery.f23379d.equals(b2.get(next)) && next.startsWith(ComponentDiscovery.f23380e)) {
                    arrayList.add(next.substring(31));
                }
            }
            return arrayList;
        }
    }

    @VisibleForTesting
    interface RegistrarNameRetriever<T> {
        List<String> a(T t);
    }

    @VisibleForTesting
    ComponentDiscovery(T t, RegistrarNameRetriever<T> registrarNameRetriever) {
        this.f23381a = t;
        this.f23382b = registrarNameRetriever;
    }

    public static ComponentDiscovery<Context> d(Context context, Class<? extends Service> cls) {
        return new ComponentDiscovery<>(context, new MetadataRegistrarNameRetriever(cls));
    }

    /* access modifiers changed from: private */
    @Nullable
    public static ComponentRegistrar e(String str) {
        try {
            Class<?> cls = Class.forName(str);
            if (ComponentRegistrar.class.isAssignableFrom(cls)) {
                return (ComponentRegistrar) cls.getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
            }
            throw new InvalidRegistrarException(String.format("Class %s is not an instance of %s", new Object[]{str, f23379d}));
        } catch (ClassNotFoundException unused) {
            Log.w(f23378c, String.format("Class %s is not an found.", new Object[]{str}));
            return null;
        } catch (IllegalAccessException e2) {
            throw new InvalidRegistrarException(String.format("Could not instantiate %s.", new Object[]{str}), e2);
        } catch (InstantiationException e3) {
            throw new InvalidRegistrarException(String.format("Could not instantiate %s.", new Object[]{str}), e3);
        } catch (NoSuchMethodException e4) {
            throw new InvalidRegistrarException(String.format("Could not instantiate %s", new Object[]{str}), e4);
        } catch (InvocationTargetException e5) {
            throw new InvalidRegistrarException(String.format("Could not instantiate %s", new Object[]{str}), e5);
        }
    }

    @Deprecated
    public List<ComponentRegistrar> b() {
        ArrayList arrayList = new ArrayList();
        for (String e2 : this.f23382b.a(this.f23381a)) {
            try {
                ComponentRegistrar e3 = e(e2);
                if (e3 != null) {
                    arrayList.add(e3);
                }
            } catch (InvalidRegistrarException e4) {
                Log.w(f23378c, "Invalid component registrar.", e4);
            }
        }
        return arrayList;
    }

    public List<Provider<ComponentRegistrar>> c() {
        ArrayList arrayList = new ArrayList();
        for (String gVar : this.f23382b.a(this.f23381a)) {
            arrayList.add(new g(gVar));
        }
        return arrayList;
    }
}
