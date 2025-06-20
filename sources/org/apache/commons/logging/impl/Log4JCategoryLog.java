package org.apache.commons.logging.impl;

import org.apache.commons.logging.Log;
import org.apache.log4j.Category;
import org.apache.log4j.Level;

public final class Log4JCategoryLog implements Log {
    private static final String FQCN;
    static /* synthetic */ Class class$org$apache$commons$logging$impl$Log4JCategoryLog;
    private Category category;

    static {
        Class cls = class$org$apache$commons$logging$impl$Log4JCategoryLog;
        if (cls == null) {
            cls = class$("org.apache.commons.logging.impl.Log4JCategoryLog");
            class$org$apache$commons$logging$impl$Log4JCategoryLog = cls;
        }
        FQCN = cls.getName();
    }

    public Log4JCategoryLog() {
        this.category = null;
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    public void debug(Object obj) {
        this.category.log(FQCN, Level.DEBUG, obj, (Throwable) null);
    }

    public void error(Object obj) {
        this.category.log(FQCN, Level.ERROR, obj, (Throwable) null);
    }

    public void fatal(Object obj) {
        this.category.log(FQCN, Level.FATAL, obj, (Throwable) null);
    }

    public Category getCategory() {
        return this.category;
    }

    public void info(Object obj) {
        this.category.log(FQCN, Level.INFO, obj, (Throwable) null);
    }

    public boolean isDebugEnabled() {
        return this.category.isDebugEnabled();
    }

    public boolean isErrorEnabled() {
        return this.category.isEnabledFor(Level.ERROR);
    }

    public boolean isFatalEnabled() {
        return this.category.isEnabledFor(Level.FATAL);
    }

    public boolean isInfoEnabled() {
        return this.category.isInfoEnabled();
    }

    public boolean isTraceEnabled() {
        return this.category.isDebugEnabled();
    }

    public boolean isWarnEnabled() {
        return this.category.isEnabledFor(Level.WARN);
    }

    public void trace(Object obj) {
        this.category.log(FQCN, Level.DEBUG, obj, (Throwable) null);
    }

    public void warn(Object obj) {
        this.category.log(FQCN, Level.WARN, obj, (Throwable) null);
    }

    public Log4JCategoryLog(String str) {
        this.category = null;
        this.category = Category.getInstance(str);
    }

    public void debug(Object obj, Throwable th) {
        this.category.log(FQCN, Level.DEBUG, obj, th);
    }

    public void error(Object obj, Throwable th) {
        this.category.log(FQCN, Level.ERROR, obj, th);
    }

    public void fatal(Object obj, Throwable th) {
        this.category.log(FQCN, Level.FATAL, obj, th);
    }

    public void info(Object obj, Throwable th) {
        this.category.log(FQCN, Level.INFO, obj, th);
    }

    public void trace(Object obj, Throwable th) {
        this.category.log(FQCN, Level.DEBUG, obj, th);
    }

    public void warn(Object obj, Throwable th) {
        this.category.log(FQCN, Level.WARN, obj, th);
    }

    public Log4JCategoryLog(Category category2) {
        this.category = category2;
    }
}
