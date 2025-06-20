package com.itextpdf.text;

import com.dd.plist.ASCIIPropertyListParser;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.Barcode128;

public class SpecialSymbol {
    public static Chunk a(char c2, Font font) {
        char b2 = b(c2);
        if (b2 == ' ') {
            return new Chunk(String.valueOf(c2), font);
        }
        return new Chunk(String.valueOf(b2), new Font(Font.FontFamily.SYMBOL, font.m(), font.n(), font.i()));
    }

    public static char b(char c2) {
        switch (c2) {
            case 913:
                return 'A';
            case 914:
                return ASCIIPropertyListParser.u;
            case 915:
                return 'G';
            case 916:
                return ASCIIPropertyListParser.t;
            case 917:
                return 'E';
            case 918:
                return ASCIIPropertyListParser.D;
            case 919:
                return 'H';
            case 920:
                return 'Q';
            case 921:
                return ASCIIPropertyListParser.x;
            case 922:
                return 'K';
            case 923:
                return 'L';
            case 924:
                return 'M';
            case 925:
                return ASCIIPropertyListParser.w;
            case 926:
                return 'X';
            case 927:
                return 'O';
            case 928:
                return 'P';
            case 929:
                return ASCIIPropertyListParser.y;
            default:
                switch (c2) {
                    case 931:
                        return 'S';
                    case 932:
                        return ASCIIPropertyListParser.C;
                    case 933:
                        return 'U';
                    case 934:
                        return 'F';
                    case 935:
                        return 'C';
                    case 936:
                        return ASCIIPropertyListParser.v;
                    case 937:
                        return 'W';
                    default:
                        switch (c2) {
                            case 945:
                                return 'a';
                            case 946:
                                return 'b';
                            case 947:
                                return Barcode128.J;
                            case 948:
                                return Barcode128.G;
                            case 949:
                                return Barcode128.H;
                            case 950:
                                return 'z';
                            case 951:
                                return Barcode128.K;
                            case 952:
                                return 'q';
                            case 953:
                                return Barcode128.L;
                            case 954:
                                return 'k';
                            case 955:
                                return 'l';
                            case 956:
                                return 'm';
                            case 957:
                                return 'n';
                            case 958:
                                return 'x';
                            case 959:
                                return 'o';
                            case 960:
                                return 'p';
                            case 961:
                                return 'r';
                            case 962:
                                return 'V';
                            case 963:
                                return 's';
                            case 964:
                                return 't';
                            case 965:
                                return 'u';
                            case 966:
                                return Barcode128.I;
                            case 967:
                                return Barcode128.F;
                            case 968:
                                return 'y';
                            case 969:
                                return 'w';
                            default:
                                return ' ';
                        }
                }
        }
    }

    public static int c(String str) {
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (b(str.charAt(i2)) != ' ') {
                return i2;
            }
        }
        return -1;
    }
}
