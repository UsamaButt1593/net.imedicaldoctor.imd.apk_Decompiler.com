package org.threeten.bp.zone;

import java.util.Collections;
import java.util.Iterator;
import java.util.NavigableMap;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.threeten.bp.jdk8.Jdk8Methods;

public abstract class ZoneRulesProvider {

    /* renamed from: a  reason: collision with root package name */
    private static final CopyOnWriteArrayList<ZoneRulesProvider> f31890a = new CopyOnWriteArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private static final ConcurrentMap<String, ZoneRulesProvider> f31891b = new ConcurrentHashMap(512, 0.75f, 2);

    static {
        ZoneRulesInitializer.a();
    }

    protected ZoneRulesProvider() {
    }

    public static Set<String> a() {
        return Collections.unmodifiableSet(f31891b.keySet());
    }

    private static ZoneRulesProvider b(String str) {
        ConcurrentMap<String, ZoneRulesProvider> concurrentMap = f31891b;
        ZoneRulesProvider zoneRulesProvider = concurrentMap.get(str);
        if (zoneRulesProvider != null) {
            return zoneRulesProvider;
        }
        if (concurrentMap.isEmpty()) {
            throw new ZoneRulesException("No time-zone data files registered");
        }
        throw new ZoneRulesException("Unknown time-zone ID: " + str);
    }

    public static ZoneRules c(String str, boolean z) {
        Jdk8Methods.j(str, "zoneId");
        return b(str).f(str, z);
    }

    public static NavigableMap<String, ZoneRules> d(String str) {
        Jdk8Methods.j(str, "zoneId");
        return b(str).g(str);
    }

    public static boolean i() {
        Iterator<ZoneRulesProvider> it2 = f31890a.iterator();
        boolean z = false;
        while (it2.hasNext()) {
            z |= it2.next().e();
        }
        return z;
    }

    public static void j(ZoneRulesProvider zoneRulesProvider) {
        Jdk8Methods.j(zoneRulesProvider, "provider");
        k(zoneRulesProvider);
        f31890a.add(zoneRulesProvider);
    }

    private static void k(ZoneRulesProvider zoneRulesProvider) {
        for (String next : zoneRulesProvider.h()) {
            Jdk8Methods.j(next, "zoneId");
            if (f31891b.putIfAbsent(next, zoneRulesProvider) != null) {
                throw new ZoneRulesException("Unable to register zone as one already registered with that ID: " + next + ", currently loading from provider: " + zoneRulesProvider);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean e() {
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract ZoneRules f(String str, boolean z);

    /* access modifiers changed from: protected */
    public abstract NavigableMap<String, ZoneRules> g(String str);

    /* access modifiers changed from: protected */
    public abstract Set<String> h();
}
