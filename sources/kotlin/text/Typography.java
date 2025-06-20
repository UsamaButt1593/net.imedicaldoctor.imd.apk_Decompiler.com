package kotlin.text;

import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\bT\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0007\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\u0006R\u0014\u0010\r\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b\f\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b\u000e\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0013\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b\u0012\u0010\u0006R\u0014\u0010\u0015\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b\u0014\u0010\u0006R\u0014\u0010\u0017\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b\u0016\u0010\u0006R\u0014\u0010\u0019\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b\u0018\u0010\u0006R\u0014\u0010\u001b\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b\u001a\u0010\u0006R\u001a\u0010\u001e\u001a\u00020\u00048\u0006XT¢\u0006\f\n\u0004\b\u001c\u0010\u0006\u0012\u0004\b\u001d\u0010\u0003R\u001a\u0010 \u001a\u00020\u00048\u0006XT¢\u0006\f\n\u0004\b\u001f\u0010\u0006\u0012\u0004\b\b\u0010\u0003R\u0014\u0010\"\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b!\u0010\u0006R\u0014\u0010$\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b#\u0010\u0006R\u0014\u0010&\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b%\u0010\u0006R\u0014\u0010(\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b'\u0010\u0006R\u0014\u0010*\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b)\u0010\u0006R\u0014\u0010,\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b+\u0010\u0006R\u0014\u0010.\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b-\u0010\u0006R\u0014\u00100\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b/\u0010\u0006R\u0014\u00102\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b1\u0010\u0006R\u0014\u00104\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b3\u0010\u0006R\u0014\u00106\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b5\u0010\u0006R\u0014\u00108\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b7\u0010\u0006R\u0014\u0010:\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b9\u0010\u0006R\u0014\u0010<\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b;\u0010\u0006R\u0014\u0010=\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0006R\u0014\u0010?\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b>\u0010\u0006R\u0014\u0010A\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b@\u0010\u0006R\u0014\u0010C\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\bB\u0010\u0006R\u0014\u0010E\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\bD\u0010\u0006R\u0014\u0010G\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\bF\u0010\u0006R\u0014\u0010I\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\bH\u0010\u0006R\u0014\u0010K\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\bJ\u0010\u0006R\u0014\u0010M\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\bL\u0010\u0006R\u0014\u0010O\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\bN\u0010\u0006R\u0014\u0010Q\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\bP\u0010\u0006R\u0014\u0010S\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\bR\u0010\u0006R\u001a\u0010U\u001a\u00020\u00048\u0006XT¢\u0006\f\n\u0004\bT\u0010\u0006\u0012\u0004\b\u0005\u0010\u0003R\u001a\u0010W\u001a\u00020\u00048\u0006XT¢\u0006\f\n\u0004\bV\u0010\u0006\u0012\u0004\b\n\u0010\u0003¨\u0006X"}, d2 = {"Lkotlin/text/Typography;", "", "<init>", "()V", "", "b", "C", "quote", "c", "dollar", "d", "amp", "e", "less", "f", "greater", "g", "nbsp", "h", "times", "i", "cent", "j", "pound", "k", "section", "l", "copyright", "m", "a", "leftGuillemet", "n", "rightGuillemet", "o", "registered", "p", "degree", "q", "plusMinus", "r", "paragraph", "s", "middleDot", "t", "half", "u", "ndash", "v", "mdash", "w", "leftSingleQuote", "x", "rightSingleQuote", "y", "lowSingleQuote", "z", "leftDoubleQuote", "A", "rightDoubleQuote", "B", "lowDoubleQuote", "dagger", "D", "doubleDagger", "E", "bullet", "F", "ellipsis", "G", "prime", "H", "doublePrime", "I", "euro", "J", "tm", "K", "almostEqual", "L", "notEqual", "M", "lessOrEqual", "N", "greaterOrEqual", "O", "leftGuillemete", "P", "rightGuillemete", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public final class Typography {
    public static final char A = '”';
    public static final char B = '„';
    public static final char C = '†';
    public static final char D = '‡';
    public static final char E = '•';
    public static final char F = '…';
    public static final char G = '′';
    public static final char H = '″';
    public static final char I = '€';
    public static final char J = '™';
    public static final char K = '≈';
    public static final char L = '≠';
    public static final char M = '≤';
    public static final char N = '≥';
    public static final char O = '«';
    public static final char P = '»';
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final Typography f29114a = new Typography();

    /* renamed from: b  reason: collision with root package name */
    public static final char f29115b = '\"';

    /* renamed from: c  reason: collision with root package name */
    public static final char f29116c = '$';

    /* renamed from: d  reason: collision with root package name */
    public static final char f29117d = '&';

    /* renamed from: e  reason: collision with root package name */
    public static final char f29118e = '<';

    /* renamed from: f  reason: collision with root package name */
    public static final char f29119f = '>';

    /* renamed from: g  reason: collision with root package name */
    public static final char f29120g = ' ';

    /* renamed from: h  reason: collision with root package name */
    public static final char f29121h = '×';

    /* renamed from: i  reason: collision with root package name */
    public static final char f29122i = '¢';

    /* renamed from: j  reason: collision with root package name */
    public static final char f29123j = '£';

    /* renamed from: k  reason: collision with root package name */
    public static final char f29124k = '§';

    /* renamed from: l  reason: collision with root package name */
    public static final char f29125l = '©';

    /* renamed from: m  reason: collision with root package name */
    public static final char f29126m = '«';

    /* renamed from: n  reason: collision with root package name */
    public static final char f29127n = '»';
    public static final char o = '®';
    public static final char p = '°';
    public static final char q = '±';
    public static final char r = '¶';
    public static final char s = '·';
    public static final char t = '½';
    public static final char u = '–';
    public static final char v = '—';
    public static final char w = '‘';
    public static final char x = '’';
    public static final char y = '‚';
    public static final char z = '“';

    private Typography() {
    }

    @SinceKotlin(version = "1.6")
    public static /* synthetic */ void a() {
    }

    @Deprecated(message = "This constant has a typo in the name. Use leftGuillemet instead.", replaceWith = @ReplaceWith(expression = "Typography.leftGuillemet", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.6")
    public static /* synthetic */ void b() {
    }

    @SinceKotlin(version = "1.6")
    public static /* synthetic */ void c() {
    }

    @Deprecated(message = "This constant has a typo in the name. Use rightGuillemet instead.", replaceWith = @ReplaceWith(expression = "Typography.rightGuillemet", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.6")
    public static /* synthetic */ void d() {
    }
}
