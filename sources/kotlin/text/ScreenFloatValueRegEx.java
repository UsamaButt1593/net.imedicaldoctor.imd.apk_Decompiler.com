package kotlin.text;

import com.dd.plist.ASCIIPropertyListParser;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lkotlin/text/ScreenFloatValueRegEx;", "", "<init>", "()V", "Lkotlin/text/Regex;", "b", "Lkotlin/text/Regex;", "value", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
final class ScreenFloatValueRegEx {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final ScreenFloatValueRegEx f29107a = new ScreenFloatValueRegEx();
    @NotNull
    @JvmField

    /* renamed from: b  reason: collision with root package name */
    public static final Regex f29108b;

    static {
        String str = "[eE][+-]?" + "(\\p{Digit}+)";
        f29108b = new Regex("[\\x00-\\x20]*[+-]?(NaN|Infinity|((" + (ASCIIPropertyListParser.f18649g + "(\\p{Digit}+)" + "(\\.)?(" + "(\\p{Digit}+)" + "?)(" + str + ")?)|(\\.(" + "(\\p{Digit}+)" + ")(" + str + ")?)|((" + ("(0[xX]" + "(\\p{XDigit}+)" + "(\\.)?)|(0[xX]" + "(\\p{XDigit}+)" + "?(\\.)" + "(\\p{XDigit}+)" + ASCIIPropertyListParser.f18650h) + ")[pP][+-]?" + "(\\p{Digit}+)" + ASCIIPropertyListParser.f18650h) + ")[fFdD]?))[\\x00-\\x20]*");
    }

    private ScreenFloatValueRegEx() {
    }
}
