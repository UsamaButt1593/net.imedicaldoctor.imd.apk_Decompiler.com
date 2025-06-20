package org.apache.commons.lang3.concurrent;

import java.lang.Thread;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public class BasicThreadFactory implements ThreadFactory {
    private final Boolean daemonFlag;
    private final String namingPattern;
    private final Integer priority;
    private final AtomicLong threadCounter;
    private final Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
    private final ThreadFactory wrappedFactory;

    public static class Builder implements org.apache.commons.lang3.builder.Builder<BasicThreadFactory> {
        /* access modifiers changed from: private */
        public Boolean daemonFlag;
        /* access modifiers changed from: private */
        public Thread.UncaughtExceptionHandler exceptionHandler;
        /* access modifiers changed from: private */
        public String namingPattern;
        /* access modifiers changed from: private */
        public Integer priority;
        /* access modifiers changed from: private */
        public ThreadFactory wrappedFactory;

        public Builder daemon(boolean z) {
            this.daemonFlag = Boolean.valueOf(z);
            return this;
        }

        public Builder namingPattern(String str) {
            if (str != null) {
                this.namingPattern = str;
                return this;
            }
            throw new NullPointerException("Naming pattern must not be null!");
        }

        public Builder priority(int i2) {
            this.priority = Integer.valueOf(i2);
            return this;
        }

        public void reset() {
            this.wrappedFactory = null;
            this.exceptionHandler = null;
            this.namingPattern = null;
            this.priority = null;
            this.daemonFlag = null;
        }

        public Builder uncaughtExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            if (uncaughtExceptionHandler != null) {
                this.exceptionHandler = uncaughtExceptionHandler;
                return this;
            }
            throw new NullPointerException("Uncaught exception handler must not be null!");
        }

        public Builder wrappedFactory(ThreadFactory threadFactory) {
            if (threadFactory != null) {
                this.wrappedFactory = threadFactory;
                return this;
            }
            throw new NullPointerException("Wrapped ThreadFactory must not be null!");
        }

        public BasicThreadFactory build() {
            BasicThreadFactory basicThreadFactory = new BasicThreadFactory(this);
            reset();
            return basicThreadFactory;
        }
    }

    private BasicThreadFactory(Builder builder) {
        this.wrappedFactory = builder.wrappedFactory == null ? Executors.defaultThreadFactory() : builder.wrappedFactory;
        this.namingPattern = builder.namingPattern;
        this.priority = builder.priority;
        this.daemonFlag = builder.daemonFlag;
        this.uncaughtExceptionHandler = builder.exceptionHandler;
        this.threadCounter = new AtomicLong();
    }

    private void initializeThread(Thread thread) {
        if (getNamingPattern() != null) {
            Long valueOf = Long.valueOf(this.threadCounter.incrementAndGet());
            thread.setName(String.format(getNamingPattern(), new Object[]{valueOf}));
        }
        if (getUncaughtExceptionHandler() != null) {
            thread.setUncaughtExceptionHandler(getUncaughtExceptionHandler());
        }
        if (getPriority() != null) {
            thread.setPriority(getPriority().intValue());
        }
        if (getDaemonFlag() != null) {
            thread.setDaemon(getDaemonFlag().booleanValue());
        }
    }

    public final Boolean getDaemonFlag() {
        return this.daemonFlag;
    }

    public final String getNamingPattern() {
        return this.namingPattern;
    }

    public final Integer getPriority() {
        return this.priority;
    }

    public long getThreadCount() {
        return this.threadCounter.get();
    }

    public final Thread.UncaughtExceptionHandler getUncaughtExceptionHandler() {
        return this.uncaughtExceptionHandler;
    }

    public final ThreadFactory getWrappedFactory() {
        return this.wrappedFactory;
    }

    public Thread newThread(Runnable runnable) {
        Thread newThread = getWrappedFactory().newThread(runnable);
        initializeThread(newThread);
        return newThread;
    }
}
