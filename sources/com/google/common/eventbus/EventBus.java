package com.google.common.eventbus;

import com.dd.plist.ASCIIPropertyListParser;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.httpclient.cookie.CookiePolicy;

@ElementTypesAreNonnullByDefault
public class EventBus {

    /* renamed from: f  reason: collision with root package name */
    private static final Logger f22556f = Logger.getLogger(EventBus.class.getName());

    /* renamed from: a  reason: collision with root package name */
    private final String f22557a;

    /* renamed from: b  reason: collision with root package name */
    private final Executor f22558b;

    /* renamed from: c  reason: collision with root package name */
    private final SubscriberExceptionHandler f22559c;

    /* renamed from: d  reason: collision with root package name */
    private final SubscriberRegistry f22560d;

    /* renamed from: e  reason: collision with root package name */
    private final Dispatcher f22561e;

    static final class LoggingHandler implements SubscriberExceptionHandler {

        /* renamed from: a  reason: collision with root package name */
        static final LoggingHandler f22562a = new LoggingHandler();

        LoggingHandler() {
        }

        private static Logger b(SubscriberExceptionContext subscriberExceptionContext) {
            return Logger.getLogger(EventBus.class.getName() + "." + subscriberExceptionContext.b().c());
        }

        private static String c(SubscriberExceptionContext subscriberExceptionContext) {
            Method d2 = subscriberExceptionContext.d();
            return "Exception thrown by subscriber method " + d2.getName() + ASCIIPropertyListParser.f18649g + d2.getParameterTypes()[0].getName() + ASCIIPropertyListParser.f18650h + " on subscriber " + subscriberExceptionContext.c() + " when dispatching event: " + subscriberExceptionContext.a();
        }

        public void a(Throwable th, SubscriberExceptionContext subscriberExceptionContext) {
            Logger b2 = b(subscriberExceptionContext);
            Level level = Level.SEVERE;
            if (b2.isLoggable(level)) {
                b2.log(level, c(subscriberExceptionContext), th);
            }
        }
    }

    public EventBus() {
        this(CookiePolicy.DEFAULT);
    }

    /* access modifiers changed from: package-private */
    public final Executor a() {
        return this.f22558b;
    }

    /* access modifiers changed from: package-private */
    public void b(Throwable th, SubscriberExceptionContext subscriberExceptionContext) {
        Preconditions.E(th);
        Preconditions.E(subscriberExceptionContext);
        try {
            this.f22559c.a(th, subscriberExceptionContext);
        } catch (Throwable th2) {
            f22556f.log(Level.SEVERE, String.format(Locale.ROOT, "Exception %s thrown while handling exception: %s", new Object[]{th2, th}), th2);
        }
    }

    public final String c() {
        return this.f22557a;
    }

    public void d(Object obj) {
        Iterator<Subscriber> f2 = this.f22560d.f(obj);
        if (f2.hasNext()) {
            this.f22561e.a(obj, f2);
        } else if (!(obj instanceof DeadEvent)) {
            d(new DeadEvent(this, obj));
        }
    }

    public void e(Object obj) {
        this.f22560d.h(obj);
    }

    public void f(Object obj) {
        this.f22560d.i(obj);
    }

    public String toString() {
        return MoreObjects.c(this).s(this.f22557a).toString();
    }

    public EventBus(SubscriberExceptionHandler subscriberExceptionHandler) {
        this(CookiePolicy.DEFAULT, MoreExecutors.c(), Dispatcher.d(), subscriberExceptionHandler);
    }

    public EventBus(String str) {
        this(str, MoreExecutors.c(), Dispatcher.d(), LoggingHandler.f22562a);
    }

    EventBus(String str, Executor executor, Dispatcher dispatcher, SubscriberExceptionHandler subscriberExceptionHandler) {
        this.f22560d = new SubscriberRegistry(this);
        this.f22557a = (String) Preconditions.E(str);
        this.f22558b = (Executor) Preconditions.E(executor);
        this.f22561e = (Dispatcher) Preconditions.E(dispatcher);
        this.f22559c = (SubscriberExceptionHandler) Preconditions.E(subscriberExceptionHandler);
    }
}
