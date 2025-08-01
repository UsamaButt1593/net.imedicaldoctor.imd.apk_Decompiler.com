package org.apache.commons.httpclient;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HeaderGroup {
    private List headers = new ArrayList();

    public void addHeader(Header header) {
        this.headers.add(header);
    }

    public void clear() {
        this.headers.clear();
    }

    public boolean containsHeader(String str) {
        for (Header name : this.headers) {
            if (name.getName().equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public Header[] getAllHeaders() {
        List list = this.headers;
        return (Header[]) list.toArray(new Header[list.size()]);
    }

    public Header getCondensedHeader(String str) {
        Header[] headers2 = getHeaders(str);
        if (headers2.length == 0) {
            return null;
        }
        if (headers2.length == 1) {
            return new Header(headers2[0].getName(), headers2[0].getValue());
        }
        StringBuffer stringBuffer = new StringBuffer(headers2[0].getValue());
        for (int i2 = 1; i2 < headers2.length; i2++) {
            stringBuffer.append(", ");
            stringBuffer.append(headers2[i2].getValue());
        }
        return new Header(str.toLowerCase(), stringBuffer.toString());
    }

    public Header getFirstHeader(String str) {
        for (Header header : this.headers) {
            if (header.getName().equalsIgnoreCase(str)) {
                return header;
            }
        }
        return null;
    }

    public Header[] getHeaders(String str) {
        ArrayList arrayList = new ArrayList();
        for (Header header : this.headers) {
            if (header.getName().equalsIgnoreCase(str)) {
                arrayList.add(header);
            }
        }
        return (Header[]) arrayList.toArray(new Header[arrayList.size()]);
    }

    public Iterator getIterator() {
        return this.headers.iterator();
    }

    public Header getLastHeader(String str) {
        for (int size = this.headers.size() - 1; size >= 0; size--) {
            Header header = (Header) this.headers.get(size);
            if (header.getName().equalsIgnoreCase(str)) {
                return header;
            }
        }
        return null;
    }

    public void removeHeader(Header header) {
        this.headers.remove(header);
    }

    public void setHeaders(Header[] headerArr) {
        clear();
        for (Header addHeader : headerArr) {
            addHeader(addHeader);
        }
    }
}
