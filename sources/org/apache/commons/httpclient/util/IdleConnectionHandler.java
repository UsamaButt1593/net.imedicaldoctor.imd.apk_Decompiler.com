package org.apache.commons.httpclient.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.httpclient.HttpConnection;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class IdleConnectionHandler {
    private static final Log LOG;
    static /* synthetic */ Class class$org$apache$commons$httpclient$util$IdleConnectionHandler;
    private Map connectionToAdded = new HashMap();

    static {
        Class cls = class$org$apache$commons$httpclient$util$IdleConnectionHandler;
        if (cls == null) {
            cls = class$("org.apache.commons.httpclient.util.IdleConnectionHandler");
            class$org$apache$commons$httpclient$util$IdleConnectionHandler = cls;
        }
        LOG = LogFactory.getLog(cls);
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    public void add(HttpConnection httpConnection) {
        Long l2 = new Long(System.currentTimeMillis());
        Log log = LOG;
        if (log.isDebugEnabled()) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Adding connection at: ");
            stringBuffer.append(l2);
            log.debug(stringBuffer.toString());
        }
        this.connectionToAdded.put(httpConnection, l2);
    }

    public void closeIdleConnections(long j2) {
        long currentTimeMillis = System.currentTimeMillis() - j2;
        Log log = LOG;
        if (log.isDebugEnabled()) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Checking for connections, idleTimeout: ");
            stringBuffer.append(currentTimeMillis);
            log.debug(stringBuffer.toString());
        }
        Iterator it2 = this.connectionToAdded.keySet().iterator();
        while (it2.hasNext()) {
            HttpConnection httpConnection = (HttpConnection) it2.next();
            Long l2 = (Long) this.connectionToAdded.get(httpConnection);
            if (l2.longValue() <= currentTimeMillis) {
                Log log2 = LOG;
                if (log2.isDebugEnabled()) {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("Closing connection, connection time: ");
                    stringBuffer2.append(l2);
                    log2.debug(stringBuffer2.toString());
                }
                it2.remove();
                httpConnection.close();
            }
        }
    }

    public void remove(HttpConnection httpConnection) {
        this.connectionToAdded.remove(httpConnection);
    }

    public void removeAll() {
        this.connectionToAdded.clear();
    }
}
