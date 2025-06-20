package androidx.datastore.preferences.protobuf;

import com.dd.plist.ASCIIPropertyListParser;

final class TextFormatEscaper {

    private interface ByteSequence {
        byte a(int i2);

        int size();
    }

    private TextFormatEscaper() {
    }

    static String a(final ByteString byteString) {
        return b(new ByteSequence() {
            public byte a(int i2) {
                return byteString.h(i2);
            }

            public int size() {
                return byteString.size();
            }
        });
    }

    static String b(ByteSequence byteSequence) {
        String str;
        StringBuilder sb = new StringBuilder(byteSequence.size());
        for (int i2 = 0; i2 < byteSequence.size(); i2++) {
            int a2 = byteSequence.a(i2);
            if (a2 == 34) {
                str = "\\\"";
            } else if (a2 == 39) {
                str = "\\'";
            } else if (a2 != 92) {
                switch (a2) {
                    case 7:
                        str = "\\a";
                        break;
                    case 8:
                        str = "\\b";
                        break;
                    case 9:
                        str = "\\t";
                        break;
                    case 10:
                        str = "\\n";
                        break;
                    case 11:
                        str = "\\v";
                        break;
                    case 12:
                        str = "\\f";
                        break;
                    case 13:
                        str = "\\r";
                        break;
                    default:
                        if (a2 < 32 || a2 > 126) {
                            sb.append(ASCIIPropertyListParser.p);
                            sb.append((char) (((a2 >>> 6) & 3) + 48));
                            sb.append((char) (((a2 >>> 3) & 7) + 48));
                            a2 = (a2 & 7) + 48;
                        }
                        sb.append((char) a2);
                        continue;
                }
            } else {
                str = "\\\\";
            }
            sb.append(str);
        }
        return sb.toString();
    }

    static String c(final byte[] bArr) {
        return b(new ByteSequence() {
            public byte a(int i2) {
                return bArr[i2];
            }

            public int size() {
                return bArr.length;
            }
        });
    }

    static String d(String str) {
        return str.replace("\\", "\\\\").replace("\"", "\\\"");
    }

    static String e(String str) {
        return a(ByteString.B(str));
    }
}
