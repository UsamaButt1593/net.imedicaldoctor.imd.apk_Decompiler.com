package org.apache.commons.lang3.concurrent;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ExecutorService;

public class MultiBackgroundInitializer extends BackgroundInitializer<MultiBackgroundInitializerResults> {
    private final Map<String, BackgroundInitializer<?>> childInitializers = new HashMap();

    public static class MultiBackgroundInitializerResults {
        private final Map<String, ConcurrentException> exceptions;
        private final Map<String, BackgroundInitializer<?>> initializers;
        private final Map<String, Object> resultObjects;

        private MultiBackgroundInitializerResults(Map<String, BackgroundInitializer<?>> map, Map<String, Object> map2, Map<String, ConcurrentException> map3) {
            this.initializers = map;
            this.resultObjects = map2;
            this.exceptions = map3;
        }

        private BackgroundInitializer<?> checkName(String str) {
            BackgroundInitializer<?> backgroundInitializer = this.initializers.get(str);
            if (backgroundInitializer != null) {
                return backgroundInitializer;
            }
            throw new NoSuchElementException("No child initializer with name " + str);
        }

        public ConcurrentException getException(String str) {
            checkName(str);
            return this.exceptions.get(str);
        }

        public BackgroundInitializer<?> getInitializer(String str) {
            return checkName(str);
        }

        public Object getResultObject(String str) {
            checkName(str);
            return this.resultObjects.get(str);
        }

        public Set<String> initializerNames() {
            return Collections.unmodifiableSet(this.initializers.keySet());
        }

        public boolean isException(String str) {
            checkName(str);
            return this.exceptions.containsKey(str);
        }

        public boolean isSuccessful() {
            return this.exceptions.isEmpty();
        }
    }

    public MultiBackgroundInitializer() {
    }

    public void addInitializer(String str, BackgroundInitializer<?> backgroundInitializer) {
        if (str == null) {
            throw new IllegalArgumentException("Name of child initializer must not be null!");
        } else if (backgroundInitializer != null) {
            synchronized (this) {
                try {
                    if (!isStarted()) {
                        this.childInitializers.put(str, backgroundInitializer);
                    } else {
                        throw new IllegalStateException("addInitializer() must not be called after start()!");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } else {
            throw new IllegalArgumentException("Child initializer must not be null!");
        }
    }

    /* access modifiers changed from: protected */
    public int getTaskCount() {
        int i2 = 1;
        for (BackgroundInitializer<?> taskCount : this.childInitializers.values()) {
            i2 += taskCount.getTaskCount();
        }
        return i2;
    }

    public MultiBackgroundInitializer(ExecutorService executorService) {
        super(executorService);
    }

    /* access modifiers changed from: protected */
    public MultiBackgroundInitializerResults initialize() throws Exception {
        HashMap hashMap;
        synchronized (this) {
            hashMap = new HashMap(this.childInitializers);
        }
        ExecutorService activeExecutor = getActiveExecutor();
        for (BackgroundInitializer backgroundInitializer : hashMap.values()) {
            if (backgroundInitializer.getExternalExecutor() == null) {
                backgroundInitializer.setExternalExecutor(activeExecutor);
            }
            backgroundInitializer.start();
        }
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        for (Map.Entry entry : hashMap.entrySet()) {
            try {
                hashMap2.put(entry.getKey(), ((BackgroundInitializer) entry.getValue()).get());
            } catch (ConcurrentException e2) {
                hashMap3.put(entry.getKey(), e2);
            }
        }
        return new MultiBackgroundInitializerResults(hashMap, hashMap2, hashMap3);
    }
}
