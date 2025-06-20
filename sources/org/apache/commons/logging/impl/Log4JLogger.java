package org.apache.commons.logging.impl;

import java.io.Serializable;
import org.apache.commons.logging.Log;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Log4JLogger implements Log, Serializable {
    private static final String FQCN;
    static /* synthetic */ Class class$org$apache$commons$logging$impl$Log4JLogger;
    static /* synthetic */ Class class$org$apache$log4j$Level;
    static /* synthetic */ Class class$org$apache$log4j$Priority;
    private static final boolean is12;
    private transient Logger logger;
    private String name;

    static {
        Class cls = class$org$apache$commons$logging$impl$Log4JLogger;
        if (cls == null) {
            cls = class$("org.apache.commons.logging.impl.Log4JLogger");
            class$org$apache$commons$logging$impl$Log4JLogger = cls;
        }
        FQCN = cls.getName();
        Class cls2 = class$org$apache$log4j$Priority;
        if (cls2 == null) {
            cls2 = class$("org.apache.log4j.Priority");
            class$org$apache$log4j$Priority = cls2;
        }
        Class cls3 = class$org$apache$log4j$Level;
        if (cls3 == null) {
            cls3 = class$("org.apache.log4j.Level");
            class$org$apache$log4j$Level = cls3;
        }
        is12 = cls2.isAssignableFrom(cls3);
    }

    public Log4JLogger() {
        this.logger = null;
        this.name = null;
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    public void debug(Object obj) {
        if (is12) {
            getLogger().log(FQCN, Level.DEBUG, obj, (Throwable) null);
        } else {
            getLogger().log(FQCN, Level.DEBUG, obj, (Throwable) null);
        }
    }

    public void error(Object obj) {
        if (is12) {
            getLogger().log(FQCN, Level.ERROR, obj, (Throwable) null);
        } else {
            getLogger().log(FQCN, Level.ERROR, obj, (Throwable) null);
        }
    }

    public void fatal(Object obj) {
        if (is12) {
            getLogger().log(FQCN, Level.FATAL, obj, (Throwable) null);
        } else {
            getLogger().log(FQCN, Level.FATAL, obj, (Throwable) null);
        }
    }

    public Logger getLogger() {
        if (this.logger == null) {
            this.logger = Logger.getLogger(this.name);
        }
        return this.logger;
    }

    public void info(Object obj) {
        if (is12) {
            getLogger().log(FQCN, Level.INFO, obj, (Throwable) null);
        } else {
            getLogger().log(FQCN, Level.INFO, obj, (Throwable) null);
        }
    }

    public boolean isDebugEnabled() {
        return getLogger().isDebugEnabled();
    }

    public boolean isErrorEnabled() {
        return is12 ? getLogger().isEnabledFor(Level.ERROR) : getLogger().isEnabledFor(Level.ERROR);
    }

    public boolean isFatalEnabled() {
        return is12 ? getLogger().isEnabledFor(Level.FATAL) : getLogger().isEnabledFor(Level.FATAL);
    }

    public boolean isInfoEnabled() {
        return getLogger().isInfoEnabled();
    }

    public boolean isTraceEnabled() {
        return getLogger().isDebugEnabled();
    }

    public boolean isWarnEnabled() {
        return is12 ? getLogger().isEnabledFor(Level.WARN) : getLogger().isEnabledFor(Level.WARN);
    }

    public void trace(Object obj) {
        if (is12) {
            getLogger().log(FQCN, Level.DEBUG, obj, (Throwable) null);
        } else {
            getLogger().log(FQCN, Level.DEBUG, obj, (Throwable) null);
        }
    }

    public void warn(Object obj) {
        if (is12) {
            getLogger().log(FQCN, Level.WARN, obj, (Throwable) null);
        } else {
            getLogger().log(FQCN, Level.WARN, obj, (Throwable) null);
        }
    }

    public Log4JLogger(String str) {
        this.logger = null;
        this.name = str;
        this.logger = getLogger();
    }

    public void debug(Object obj, Throwable th) {
        if (is12) {
            getLogger().log(FQCN, Level.DEBUG, obj, th);
        } else {
            getLogger().log(FQCN, Level.DEBUG, obj, th);
        }
    }

    public void error(Object obj, Throwable th) {
        if (is12) {
            getLogger().log(FQCN, Level.ERROR, obj, th);
        } else {
            getLogger().log(FQCN, Level.ERROR, obj, th);
        }
    }

    public void fatal(Object obj, Throwable th) {
        if (is12) {
            getLogger().log(FQCN, Level.FATAL, obj, th);
        } else {
            getLogger().log(FQCN, Level.FATAL, obj, th);
        }
    }

    public void info(Object obj, Throwable th) {
        if (is12) {
            getLogger().log(FQCN, Level.INFO, obj, th);
        } else {
            getLogger().log(FQCN, Level.INFO, obj, th);
        }
    }

    public void trace(Object obj, Throwable th) {
        if (is12) {
            getLogger().log(FQCN, Level.DEBUG, obj, th);
        } else {
            getLogger().log(FQCN, Level.DEBUG, obj, th);
        }
    }

    public void warn(Object obj, Throwable th) {
        if (is12) {
            getLogger().log(FQCN, Level.WARN, obj, th);
        } else {
            getLogger().log(FQCN, Level.WARN, obj, th);
        }
    }

    public Log4JLogger(Logger logger2) {
        this.logger = null;
        this.name = null;
        this.name = logger2.getName();
        this.logger = logger2;
    }
}
