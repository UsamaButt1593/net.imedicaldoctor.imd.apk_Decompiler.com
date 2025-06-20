package com.google.android.datatransport.runtime.backends;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
class MetadataBackendRegistry implements BackendRegistry {

    /* renamed from: d  reason: collision with root package name */
    private static final String f19478d = "BackendRegistry";

    /* renamed from: e  reason: collision with root package name */
    private static final String f19479e = "backend:";

    /* renamed from: a  reason: collision with root package name */
    private final BackendFactoryProvider f19480a;

    /* renamed from: b  reason: collision with root package name */
    private final CreationContextFactory f19481b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, TransportBackend> f19482c;

    static class BackendFactoryProvider {

        /* renamed from: a  reason: collision with root package name */
        private final Context f19483a;

        /* renamed from: b  reason: collision with root package name */
        private Map<String, String> f19484b = null;

        BackendFactoryProvider(Context context) {
            this.f19483a = context;
        }

        private Map<String, String> a(Context context) {
            Bundle d2 = d(context);
            if (d2 == null) {
                Log.w(MetadataBackendRegistry.f19478d, "Could not retrieve metadata, returning empty list of transport backends.");
                return Collections.emptyMap();
            }
            HashMap hashMap = new HashMap();
            for (String next : d2.keySet()) {
                Object obj = d2.get(next);
                if ((obj instanceof String) && next.startsWith(MetadataBackendRegistry.f19479e)) {
                    for (String trim : ((String) obj).split(",", -1)) {
                        String trim2 = trim.trim();
                        if (!trim2.isEmpty()) {
                            hashMap.put(trim2, next.substring(8));
                        }
                    }
                }
            }
            return hashMap;
        }

        private Map<String, String> c() {
            if (this.f19484b == null) {
                this.f19484b = a(this.f19483a);
            }
            return this.f19484b;
        }

        private static Bundle d(Context context) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    Log.w(MetadataBackendRegistry.f19478d, "Context has no PackageManager.");
                    return null;
                }
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, TransportBackendDiscovery.class), 128);
                if (serviceInfo != null) {
                    return serviceInfo.metaData;
                }
                Log.w(MetadataBackendRegistry.f19478d, "TransportBackendDiscovery has no service info.");
                return null;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w(MetadataBackendRegistry.f19478d, "Application info not found.");
                return null;
            }
        }

        /* access modifiers changed from: package-private */
        @Nullable
        public BackendFactory b(String str) {
            String str2;
            String str3;
            String str4 = c().get(str);
            if (str4 == null) {
                return null;
            }
            try {
                return (BackendFactory) Class.forName(str4).asSubclass(BackendFactory.class).getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
            } catch (ClassNotFoundException e2) {
                e = e2;
                str3 = String.format("Class %s is not found.", new Object[]{str4});
                Log.w(MetadataBackendRegistry.f19478d, str3, e);
                return null;
            } catch (IllegalAccessException e3) {
                e = e3;
                str2 = String.format("Could not instantiate %s.", new Object[]{str4});
                Log.w(MetadataBackendRegistry.f19478d, str2, e);
                return null;
            } catch (InstantiationException e4) {
                e = e4;
                str2 = String.format("Could not instantiate %s.", new Object[]{str4});
                Log.w(MetadataBackendRegistry.f19478d, str2, e);
                return null;
            } catch (NoSuchMethodException e5) {
                e = e5;
                str3 = String.format("Could not instantiate %s", new Object[]{str4});
                Log.w(MetadataBackendRegistry.f19478d, str3, e);
                return null;
            } catch (InvocationTargetException e6) {
                e = e6;
                str3 = String.format("Could not instantiate %s", new Object[]{str4});
                Log.w(MetadataBackendRegistry.f19478d, str3, e);
                return null;
            }
        }
    }

    @Inject
    MetadataBackendRegistry(Context context, CreationContextFactory creationContextFactory) {
        this(new BackendFactoryProvider(context), creationContextFactory);
    }

    @Nullable
    public synchronized TransportBackend i(String str) {
        if (this.f19482c.containsKey(str)) {
            return this.f19482c.get(str);
        }
        BackendFactory b2 = this.f19480a.b(str);
        if (b2 == null) {
            return null;
        }
        TransportBackend create = b2.create(this.f19481b.a(str));
        this.f19482c.put(str, create);
        return create;
    }

    MetadataBackendRegistry(BackendFactoryProvider backendFactoryProvider, CreationContextFactory creationContextFactory) {
        this.f19482c = new HashMap();
        this.f19480a = backendFactoryProvider;
        this.f19481b = creationContextFactory;
    }
}
