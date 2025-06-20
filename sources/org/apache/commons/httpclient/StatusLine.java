package org.apache.commons.httpclient;

public class StatusLine {
    private final String httpVersion;
    private final String reasonPhrase;
    private final int statusCode;
    private final String statusLine;

    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r2 = new java.lang.StringBuffer();
        r2.append("Unable to parse status code from status line: '");
        r2.append(r8);
        r2.append("'");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0086, code lost:
        throw new org.apache.commons.httpclient.ProtocolException(r2.toString());
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x006d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public StatusLine(java.lang.String r8) throws org.apache.commons.httpclient.HttpException {
        /*
            r7 = this;
            java.lang.String r0 = " "
            java.lang.String r1 = "Status-Line '"
            r7.<init>()
            int r2 = r8.length()
            r3 = 0
            r4 = 0
        L_0x000d:
            char r5 = r8.charAt(r3)     // Catch:{ StringIndexOutOfBoundsException -> 0x00bb }
            boolean r5 = java.lang.Character.isWhitespace(r5)     // Catch:{ StringIndexOutOfBoundsException -> 0x00bb }
            if (r5 == 0) goto L_0x001c
            int r3 = r3 + 1
            int r4 = r4 + 1
            goto L_0x000d
        L_0x001c:
            java.lang.String r5 = "HTTP"
            int r6 = r3 + 4
            java.lang.String r3 = r8.substring(r3, r6)     // Catch:{ StringIndexOutOfBoundsException -> 0x00bb }
            boolean r3 = r5.equals(r3)     // Catch:{ StringIndexOutOfBoundsException -> 0x00bb }
            if (r3 == 0) goto L_0x00a1
            int r3 = r8.indexOf(r0, r6)     // Catch:{ StringIndexOutOfBoundsException -> 0x00bb }
            java.lang.String r5 = "'"
            if (r3 <= 0) goto L_0x0087
            java.lang.String r4 = r8.substring(r4, r3)     // Catch:{ StringIndexOutOfBoundsException -> 0x00bb }
            java.lang.String r4 = r4.toUpperCase()     // Catch:{ StringIndexOutOfBoundsException -> 0x00bb }
            r7.httpVersion = r4     // Catch:{ StringIndexOutOfBoundsException -> 0x00bb }
        L_0x003c:
            char r4 = r8.charAt(r3)     // Catch:{ StringIndexOutOfBoundsException -> 0x00bb }
            r6 = 32
            if (r4 != r6) goto L_0x0047
            int r3 = r3 + 1
            goto L_0x003c
        L_0x0047:
            int r0 = r8.indexOf(r0, r3)     // Catch:{ StringIndexOutOfBoundsException -> 0x00bb }
            if (r0 >= 0) goto L_0x004e
            r0 = r2
        L_0x004e:
            java.lang.String r3 = r8.substring(r3, r0)     // Catch:{ NumberFormatException -> 0x006d }
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ NumberFormatException -> 0x006d }
            r7.statusCode = r3     // Catch:{ NumberFormatException -> 0x006d }
            int r0 = r0 + 1
            if (r0 >= r2) goto L_0x0067
            java.lang.String r0 = r8.substring(r0)     // Catch:{ StringIndexOutOfBoundsException -> 0x00bb }
            java.lang.String r0 = r0.trim()     // Catch:{ StringIndexOutOfBoundsException -> 0x00bb }
        L_0x0064:
            r7.reasonPhrase = r0     // Catch:{ StringIndexOutOfBoundsException -> 0x00bb }
            goto L_0x006a
        L_0x0067:
            java.lang.String r0 = ""
            goto L_0x0064
        L_0x006a:
            r7.statusLine = r8
            return
        L_0x006d:
            org.apache.commons.httpclient.ProtocolException r0 = new org.apache.commons.httpclient.ProtocolException     // Catch:{ StringIndexOutOfBoundsException -> 0x00bb }
            java.lang.StringBuffer r2 = new java.lang.StringBuffer     // Catch:{ StringIndexOutOfBoundsException -> 0x00bb }
            r2.<init>()     // Catch:{ StringIndexOutOfBoundsException -> 0x00bb }
            java.lang.String r3 = "Unable to parse status code from status line: '"
            r2.append(r3)     // Catch:{ StringIndexOutOfBoundsException -> 0x00bb }
            r2.append(r8)     // Catch:{ StringIndexOutOfBoundsException -> 0x00bb }
            r2.append(r5)     // Catch:{ StringIndexOutOfBoundsException -> 0x00bb }
            java.lang.String r2 = r2.toString()     // Catch:{ StringIndexOutOfBoundsException -> 0x00bb }
            r0.<init>(r2)     // Catch:{ StringIndexOutOfBoundsException -> 0x00bb }
            throw r0     // Catch:{ StringIndexOutOfBoundsException -> 0x00bb }
        L_0x0087:
            org.apache.commons.httpclient.ProtocolException r0 = new org.apache.commons.httpclient.ProtocolException     // Catch:{ StringIndexOutOfBoundsException -> 0x00bb }
            java.lang.StringBuffer r2 = new java.lang.StringBuffer     // Catch:{ StringIndexOutOfBoundsException -> 0x00bb }
            r2.<init>()     // Catch:{ StringIndexOutOfBoundsException -> 0x00bb }
            java.lang.String r3 = "Unable to parse HTTP-Version from the status line: '"
            r2.append(r3)     // Catch:{ StringIndexOutOfBoundsException -> 0x00bb }
            r2.append(r8)     // Catch:{ StringIndexOutOfBoundsException -> 0x00bb }
            r2.append(r5)     // Catch:{ StringIndexOutOfBoundsException -> 0x00bb }
            java.lang.String r2 = r2.toString()     // Catch:{ StringIndexOutOfBoundsException -> 0x00bb }
            r0.<init>(r2)     // Catch:{ StringIndexOutOfBoundsException -> 0x00bb }
            throw r0     // Catch:{ StringIndexOutOfBoundsException -> 0x00bb }
        L_0x00a1:
            org.apache.commons.httpclient.HttpException r0 = new org.apache.commons.httpclient.HttpException     // Catch:{ StringIndexOutOfBoundsException -> 0x00bb }
            java.lang.StringBuffer r2 = new java.lang.StringBuffer     // Catch:{ StringIndexOutOfBoundsException -> 0x00bb }
            r2.<init>()     // Catch:{ StringIndexOutOfBoundsException -> 0x00bb }
            r2.append(r1)     // Catch:{ StringIndexOutOfBoundsException -> 0x00bb }
            r2.append(r8)     // Catch:{ StringIndexOutOfBoundsException -> 0x00bb }
            java.lang.String r3 = "' does not start with HTTP"
            r2.append(r3)     // Catch:{ StringIndexOutOfBoundsException -> 0x00bb }
            java.lang.String r2 = r2.toString()     // Catch:{ StringIndexOutOfBoundsException -> 0x00bb }
            r0.<init>(r2)     // Catch:{ StringIndexOutOfBoundsException -> 0x00bb }
            throw r0     // Catch:{ StringIndexOutOfBoundsException -> 0x00bb }
        L_0x00bb:
            org.apache.commons.httpclient.HttpException r0 = new org.apache.commons.httpclient.HttpException
            java.lang.StringBuffer r2 = new java.lang.StringBuffer
            r2.<init>()
            r2.append(r1)
            r2.append(r8)
            java.lang.String r8 = "' is not valid"
            r2.append(r8)
            java.lang.String r8 = r2.toString()
            r0.<init>(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.httpclient.StatusLine.<init>(java.lang.String):void");
    }

    public static boolean startsWithHTTP(String str) {
        int i2 = 0;
        while (Character.isWhitespace(str.charAt(i2))) {
            try {
                i2++;
            } catch (StringIndexOutOfBoundsException unused) {
                return false;
            }
        }
        return "HTTP".equals(str.substring(i2, i2 + 4));
    }

    public final String getHttpVersion() {
        return this.httpVersion;
    }

    public final String getReasonPhrase() {
        return this.reasonPhrase;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final String toString() {
        return this.statusLine;
    }
}
