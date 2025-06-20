package net.lingala.zip4j.crypto.PBKDF2;

class PBKDF2HexFormatter {
    PBKDF2HexFormatter() {
    }

    public boolean a(PBKDF2Parameters pBKDF2Parameters, String str) {
        if (pBKDF2Parameters == null || str == null) {
            return true;
        }
        String[] split = str.split(":");
        if (split.length != 3) {
            return true;
        }
        byte[] c2 = BinTools.c(split[0]);
        int parseInt = Integer.parseInt(split[1]);
        byte[] c3 = BinTools.c(split[2]);
        pBKDF2Parameters.j(c2);
        pBKDF2Parameters.i(parseInt);
        pBKDF2Parameters.f(c3);
        return false;
    }

    public String b(PBKDF2Parameters pBKDF2Parameters) {
        return BinTools.a(pBKDF2Parameters.e()) + ":" + String.valueOf(pBKDF2Parameters.d()) + ":" + BinTools.a(pBKDF2Parameters.a());
    }
}
