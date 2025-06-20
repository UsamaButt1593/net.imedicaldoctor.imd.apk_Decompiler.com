package org.apache.commons.logging.impl;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogConfigurationException;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;

public final class Log4jFactory extends LogFactory {
    private Hashtable attributes = new Hashtable();
    private Hashtable instances = new Hashtable();

    public Object getAttribute(String str) {
        return this.attributes.get(str);
    }

    public String[] getAttributeNames() {
        Vector vector = new Vector();
        Enumeration keys = this.attributes.keys();
        while (keys.hasMoreElements()) {
            vector.addElement((String) keys.nextElement());
        }
        int size = vector.size();
        String[] strArr = new String[size];
        for (int i2 = 0; i2 < size; i2++) {
            strArr[i2] = (String) vector.elementAt(i2);
        }
        return strArr;
    }

    public Log getInstance(Class cls) throws LogConfigurationException {
        Log log = (Log) this.instances.get(cls);
        if (log != null) {
            return log;
        }
        Log4JLogger log4JLogger = new Log4JLogger(Logger.getLogger(cls));
        this.instances.put(cls, log4JLogger);
        return log4JLogger;
    }

    public void release() {
        this.instances.clear();
    }

    public void removeAttribute(String str) {
        this.attributes.remove(str);
    }

    public void setAttribute(String str, Object obj) {
        if (obj == null) {
            this.attributes.remove(str);
        } else {
            this.attributes.put(str, obj);
        }
    }

    public Log getInstance(String str) throws LogConfigurationException {
        Log log = (Log) this.instances.get(str);
        if (log != null) {
            return log;
        }
        Log4JLogger log4JLogger = new Log4JLogger(Logger.getLogger(str));
        this.instances.put(str, log4JLogger);
        return log4JLogger;
    }
}
