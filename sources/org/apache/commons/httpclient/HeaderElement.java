package org.apache.commons.httpclient;

import com.dd.plist.ASCIIPropertyListParser;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.httpclient.util.ParameterParser;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HeaderElement extends NameValuePair {
    private static final Log LOG;
    static /* synthetic */ Class class$org$apache$commons$httpclient$HeaderElement;
    private NameValuePair[] parameters;

    static {
        Class cls = class$org$apache$commons$httpclient$HeaderElement;
        if (cls == null) {
            cls = class$("org.apache.commons.httpclient.HeaderElement");
            class$org$apache$commons$httpclient$HeaderElement = cls;
        }
        LOG = LogFactory.getLog(cls);
    }

    public HeaderElement() {
        this((String) null, (String) null, (NameValuePair[]) null);
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    public static final HeaderElement[] parse(String str) throws HttpException {
        LOG.trace("enter HeaderElement.parse(String)");
        return str == null ? new HeaderElement[0] : parseElements(str.toCharArray());
    }

    public static final HeaderElement[] parseElements(String str) {
        LOG.trace("enter HeaderElement.parseElements(String)");
        return str == null ? new HeaderElement[0] : parseElements(str.toCharArray());
    }

    public NameValuePair getParameterByName(String str) {
        LOG.trace("enter HeaderElement.getParameterByName(String)");
        if (str != null) {
            NameValuePair[] parameters2 = getParameters();
            if (parameters2 != null) {
                for (NameValuePair nameValuePair : parameters2) {
                    if (nameValuePair.getName().equalsIgnoreCase(str)) {
                        return nameValuePair;
                    }
                }
            }
            return null;
        }
        throw new IllegalArgumentException("Name may not be null");
    }

    public NameValuePair[] getParameters() {
        return this.parameters;
    }

    public HeaderElement(String str, String str2) {
        this(str, str2, (NameValuePair[]) null);
    }

    public static final HeaderElement[] parseElements(char[] cArr) {
        HeaderElement headerElement;
        LOG.trace("enter HeaderElement.parseElements(char[])");
        int i2 = 0;
        if (cArr == null) {
            return new HeaderElement[0];
        }
        ArrayList arrayList = new ArrayList();
        int length = cArr.length;
        boolean z = false;
        int i3 = 0;
        while (i2 < length) {
            char c2 = cArr[i2];
            if (c2 == '\"') {
                z = !z;
            }
            if (z || c2 != ',') {
                headerElement = i2 == length + -1 ? new HeaderElement(cArr, i3, length) : null;
            } else {
                headerElement = new HeaderElement(cArr, i3, i2);
                i3 = i2 + 1;
            }
            if (!(headerElement == null || headerElement.getName() == null)) {
                arrayList.add(headerElement);
            }
            i2++;
        }
        return (HeaderElement[]) arrayList.toArray(new HeaderElement[arrayList.size()]);
    }

    public HeaderElement(String str, String str2, NameValuePair[] nameValuePairArr) {
        super(str, str2);
        this.parameters = nameValuePairArr;
    }

    public HeaderElement(char[] cArr) {
        this(cArr, 0, cArr.length);
    }

    public HeaderElement(char[] cArr, int i2, int i3) {
        this();
        if (cArr != null) {
            List parse = new ParameterParser().parse(cArr, i2, i3, ASCIIPropertyListParser.f18655m);
            if (parse.size() > 0) {
                NameValuePair nameValuePair = (NameValuePair) parse.remove(0);
                setName(nameValuePair.getName());
                setValue(nameValuePair.getValue());
                if (parse.size() > 0) {
                    this.parameters = (NameValuePair[]) parse.toArray(new NameValuePair[parse.size()]);
                }
            }
        }
    }
}
