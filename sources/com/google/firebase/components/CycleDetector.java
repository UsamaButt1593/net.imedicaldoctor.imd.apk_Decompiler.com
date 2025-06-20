package com.google.firebase.components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class CycleDetector {

    private static class ComponentNode {

        /* renamed from: a  reason: collision with root package name */
        private final Component<?> f23398a;

        /* renamed from: b  reason: collision with root package name */
        private final Set<ComponentNode> f23399b = new HashSet();

        /* renamed from: c  reason: collision with root package name */
        private final Set<ComponentNode> f23400c = new HashSet();

        ComponentNode(Component<?> component) {
            this.f23398a = component;
        }

        /* access modifiers changed from: package-private */
        public void a(ComponentNode componentNode) {
            this.f23399b.add(componentNode);
        }

        /* access modifiers changed from: package-private */
        public void b(ComponentNode componentNode) {
            this.f23400c.add(componentNode);
        }

        /* access modifiers changed from: package-private */
        public Component<?> c() {
            return this.f23398a;
        }

        /* access modifiers changed from: package-private */
        public Set<ComponentNode> d() {
            return this.f23399b;
        }

        /* access modifiers changed from: package-private */
        public boolean e() {
            return this.f23399b.isEmpty();
        }

        /* access modifiers changed from: package-private */
        public boolean f() {
            return this.f23400c.isEmpty();
        }

        /* access modifiers changed from: package-private */
        public void g(ComponentNode componentNode) {
            this.f23400c.remove(componentNode);
        }
    }

    private static class Dep {

        /* renamed from: a  reason: collision with root package name */
        private final Qualified<?> f23401a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final boolean f23402b;

        private Dep(Qualified<?> qualified, boolean z) {
            this.f23401a = qualified;
            this.f23402b = z;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Dep)) {
                return false;
            }
            Dep dep = (Dep) obj;
            return dep.f23401a.equals(this.f23401a) && dep.f23402b == this.f23402b;
        }

        public int hashCode() {
            return ((this.f23401a.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.f23402b).hashCode();
        }
    }

    CycleDetector() {
    }

    static void a(List<Component<?>> list) {
        Set<ComponentNode> c2 = c(list);
        Set<ComponentNode> b2 = b(c2);
        int i2 = 0;
        while (!b2.isEmpty()) {
            ComponentNode next = b2.iterator().next();
            b2.remove(next);
            i2++;
            for (ComponentNode next2 : next.d()) {
                next2.g(next);
                if (next2.f()) {
                    b2.add(next2);
                }
            }
        }
        if (i2 != list.size()) {
            ArrayList arrayList = new ArrayList();
            for (ComponentNode next3 : c2) {
                if (!next3.f() && !next3.e()) {
                    arrayList.add(next3.c());
                }
            }
            throw new DependencyCycleException(arrayList);
        }
    }

    private static Set<ComponentNode> b(Set<ComponentNode> set) {
        HashSet hashSet = new HashSet();
        for (ComponentNode next : set) {
            if (next.f()) {
                hashSet.add(next);
            }
        }
        return hashSet;
    }

    private static Set<ComponentNode> c(List<Component<?>> list) {
        Set<ComponentNode> set;
        HashMap hashMap = new HashMap(list.size());
        for (Component next : list) {
            ComponentNode componentNode = new ComponentNode(next);
            Iterator it2 = next.m().iterator();
            while (true) {
                if (it2.hasNext()) {
                    Qualified qualified = (Qualified) it2.next();
                    Dep dep = new Dep(qualified, !next.v());
                    if (!hashMap.containsKey(dep)) {
                        hashMap.put(dep, new HashSet());
                    }
                    Set set2 = (Set) hashMap.get(dep);
                    if (set2.isEmpty() || dep.f23402b) {
                        set2.add(componentNode);
                    } else {
                        throw new IllegalArgumentException(String.format("Multiple components provide %s.", new Object[]{qualified}));
                    }
                }
            }
        }
        for (Set<ComponentNode> it3 : hashMap.values()) {
            for (ComponentNode componentNode2 : it3) {
                for (Dependency next2 : componentNode2.c().j()) {
                    if (next2.f() && (set = (Set) hashMap.get(new Dep(next2.d(), next2.h()))) != null) {
                        for (ComponentNode componentNode3 : set) {
                            componentNode2.a(componentNode3);
                            componentNode3.b(componentNode2);
                        }
                    }
                }
            }
        }
        HashSet hashSet = new HashSet();
        for (Set addAll : hashMap.values()) {
            hashSet.addAll(addAll);
        }
        return hashSet;
    }
}
