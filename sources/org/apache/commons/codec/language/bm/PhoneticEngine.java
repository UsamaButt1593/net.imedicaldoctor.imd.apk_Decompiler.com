package org.apache.commons.codec.language.bm;

import com.itextpdf.tool.xml.html.HTML;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.apache.commons.codec.language.bm.Languages;
import org.apache.commons.codec.language.bm.Rule;

public class PhoneticEngine {
    private static final int DEFAULT_MAX_PHONEMES = 20;
    private static final Map<NameType, Set<String>> NAME_PREFIXES;
    private final boolean concat;
    private final Lang lang;
    private final int maxPhonemes;
    private final NameType nameType;
    private final RuleType ruleType;

    /* renamed from: org.apache.commons.codec.language.bm.PhoneticEngine$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$codec$language$bm$NameType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                org.apache.commons.codec.language.bm.NameType[] r0 = org.apache.commons.codec.language.bm.NameType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$apache$commons$codec$language$bm$NameType = r0
                org.apache.commons.codec.language.bm.NameType r1 = org.apache.commons.codec.language.bm.NameType.SEPHARDIC     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$apache$commons$codec$language$bm$NameType     // Catch:{ NoSuchFieldError -> 0x001d }
                org.apache.commons.codec.language.bm.NameType r1 = org.apache.commons.codec.language.bm.NameType.ASHKENAZI     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$org$apache$commons$codec$language$bm$NameType     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.apache.commons.codec.language.bm.NameType r1 = org.apache.commons.codec.language.bm.NameType.GENERIC     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.language.bm.PhoneticEngine.AnonymousClass1.<clinit>():void");
        }
    }

    static final class PhonemeBuilder {
        private final Set<Rule.Phoneme> phonemes;

        private PhonemeBuilder(Set<Rule.Phoneme> set) {
            this.phonemes = set;
        }

        public static PhonemeBuilder empty(Languages.LanguageSet languageSet) {
            return new PhonemeBuilder(new Rule.Phoneme((CharSequence) "", languageSet));
        }

        public void append(CharSequence charSequence) {
            for (Rule.Phoneme append : this.phonemes) {
                append.append(charSequence);
            }
        }

        public void apply(Rule.PhonemeExpr phonemeExpr, int i2) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(i2);
            loop0:
            for (Rule.Phoneme next : this.phonemes) {
                Iterator<Rule.Phoneme> it2 = phonemeExpr.getPhonemes().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        Rule.Phoneme next2 = it2.next();
                        Languages.LanguageSet restrictTo = next.getLanguages().restrictTo(next2.getLanguages());
                        if (!restrictTo.isEmpty()) {
                            Rule.Phoneme phoneme = new Rule.Phoneme(next, next2, restrictTo);
                            if (linkedHashSet.size() < i2) {
                                linkedHashSet.add(phoneme);
                                if (linkedHashSet.size() >= i2) {
                                    break loop0;
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                }
            }
            this.phonemes.clear();
            this.phonemes.addAll(linkedHashSet);
        }

        public Set<Rule.Phoneme> getPhonemes() {
            return this.phonemes;
        }

        public String makeString() {
            StringBuilder sb = new StringBuilder();
            for (Rule.Phoneme next : this.phonemes) {
                if (sb.length() > 0) {
                    sb.append("|");
                }
                sb.append(next.getPhonemeText());
            }
            return sb.toString();
        }

        /* synthetic */ PhonemeBuilder(Set set, AnonymousClass1 r2) {
            this((Set<Rule.Phoneme>) set);
        }

        private PhonemeBuilder(Rule.Phoneme phoneme) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            this.phonemes = linkedHashSet;
            linkedHashSet.add(phoneme);
        }
    }

    private static final class RulesApplication {
        private final Map<String, List<Rule>> finalRules;
        private boolean found;

        /* renamed from: i  reason: collision with root package name */
        private int f31460i;
        private final CharSequence input;
        private final int maxPhonemes;
        private final PhonemeBuilder phonemeBuilder;

        public RulesApplication(Map<String, List<Rule>> map, CharSequence charSequence, PhonemeBuilder phonemeBuilder2, int i2, int i3) {
            if (map != null) {
                this.finalRules = map;
                this.phonemeBuilder = phonemeBuilder2;
                this.input = charSequence;
                this.f31460i = i2;
                this.maxPhonemes = i3;
                return;
            }
            throw new NullPointerException("The finalRules argument must not be null");
        }

        public int getI() {
            return this.f31460i;
        }

        public PhonemeBuilder getPhonemeBuilder() {
            return this.phonemeBuilder;
        }

        public RulesApplication invoke() {
            int i2;
            this.found = false;
            Map<String, List<Rule>> map = this.finalRules;
            CharSequence charSequence = this.input;
            int i3 = this.f31460i;
            List list = map.get(charSequence.subSequence(i3, i3 + 1));
            int i4 = 1;
            if (list != null) {
                Iterator it2 = list.iterator();
                i2 = 1;
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    Rule rule = (Rule) it2.next();
                    int length = rule.getPattern().length();
                    if (rule.patternAndContextMatches(this.input, this.f31460i)) {
                        this.phonemeBuilder.apply(rule.getPhoneme(), this.maxPhonemes);
                        this.found = true;
                        i2 = length;
                        break;
                    }
                    i2 = length;
                }
            } else {
                i2 = 1;
            }
            if (this.found) {
                i4 = i2;
            }
            this.f31460i += i4;
            return this;
        }

        public boolean isFound() {
            return this.found;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(NameType.class);
        NAME_PREFIXES = enumMap;
        enumMap.put(NameType.ASHKENAZI, Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"bar", "ben", "da", "de", "van", "von"}))));
        enumMap.put(NameType.SEPHARDIC, Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"al", "el", "da", "dal", "de", HTML.Tag.h0, "dela", "de la", "della", "des", "di", "do", "dos", "du", "van", "von"}))));
        enumMap.put(NameType.GENERIC, Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"da", "dal", "de", HTML.Tag.h0, "dela", "de la", "della", "des", "di", "do", "dos", "du", "van", "von"}))));
    }

    public PhoneticEngine(NameType nameType2, RuleType ruleType2, boolean z) {
        this(nameType2, ruleType2, z, 20);
    }

    private PhonemeBuilder applyFinalRules(PhonemeBuilder phonemeBuilder, Map<String, List<Rule>> map) {
        if (map == null) {
            throw new NullPointerException("finalRules can not be null");
        } else if (map.isEmpty()) {
            return phonemeBuilder;
        } else {
            TreeMap treeMap = new TreeMap(Rule.Phoneme.COMPARATOR);
            for (Rule.Phoneme next : phonemeBuilder.getPhonemes()) {
                PhonemeBuilder empty = PhonemeBuilder.empty(next.getLanguages());
                String charSequence = next.getPhonemeText().toString();
                PhonemeBuilder phonemeBuilder2 = empty;
                int i2 = 0;
                while (i2 < charSequence.length()) {
                    RulesApplication invoke = new RulesApplication(map, charSequence, phonemeBuilder2, i2, this.maxPhonemes).invoke();
                    boolean isFound = invoke.isFound();
                    phonemeBuilder2 = invoke.getPhonemeBuilder();
                    if (!isFound) {
                        phonemeBuilder2.append(charSequence.subSequence(i2, i2 + 1));
                    }
                    i2 = invoke.getI();
                }
                for (Rule.Phoneme next2 : phonemeBuilder2.getPhonemes()) {
                    if (treeMap.containsKey(next2)) {
                        next2 = ((Rule.Phoneme) treeMap.remove(next2)).mergeWithLanguage(next2.getLanguages());
                    }
                    treeMap.put(next2, next2);
                }
            }
            return new PhonemeBuilder(treeMap.keySet(), (AnonymousClass1) null);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x000d, code lost:
        if (r2.hasNext() != false) goto L_0x000f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000f, code lost:
        r0.append(r2.next());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x001c, code lost:
        if (r2.hasNext() == false) goto L_0x0022;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001e, code lost:
        r0.append(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0026, code lost:
        return r0.toString();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String join(java.lang.Iterable<java.lang.String> r2, java.lang.String r3) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.util.Iterator r2 = r2.iterator()
            boolean r1 = r2.hasNext()
            if (r1 == 0) goto L_0x0018
        L_0x000f:
            java.lang.Object r1 = r2.next()
            java.lang.String r1 = (java.lang.String) r1
            r0.append(r1)
        L_0x0018:
            boolean r1 = r2.hasNext()
            if (r1 == 0) goto L_0x0022
            r0.append(r3)
            goto L_0x000f
        L_0x0022:
            java.lang.String r2 = r0.toString()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.language.bm.PhoneticEngine.join(java.lang.Iterable, java.lang.String):java.lang.String");
    }

    public String encode(String str) {
        return encode(str, this.lang.guessLanguages(str));
    }

    public Lang getLang() {
        return this.lang;
    }

    public int getMaxPhonemes() {
        return this.maxPhonemes;
    }

    public NameType getNameType() {
        return this.nameType;
    }

    public RuleType getRuleType() {
        return this.ruleType;
    }

    public boolean isConcat() {
        return this.concat;
    }

    public PhoneticEngine(NameType nameType2, RuleType ruleType2, boolean z, int i2) {
        RuleType ruleType3 = RuleType.RULES;
        if (ruleType2 != ruleType3) {
            this.nameType = nameType2;
            this.ruleType = ruleType2;
            this.concat = z;
            this.lang = Lang.instance(nameType2);
            this.maxPhonemes = i2;
            return;
        }
        throw new IllegalArgumentException("ruleType must not be " + ruleType3);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x015d  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0162  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x017e A[LOOP:2: B:36:0x0178->B:38:0x017e, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String encode(java.lang.String r14, org.apache.commons.codec.language.bm.Languages.LanguageSet r15) {
        /*
            r13 = this;
            org.apache.commons.codec.language.bm.NameType r0 = r13.nameType
            org.apache.commons.codec.language.bm.RuleType r1 = org.apache.commons.codec.language.bm.RuleType.RULES
            java.util.Map r0 = org.apache.commons.codec.language.bm.Rule.getInstanceMap((org.apache.commons.codec.language.bm.NameType) r0, (org.apache.commons.codec.language.bm.RuleType) r1, (org.apache.commons.codec.language.bm.Languages.LanguageSet) r15)
            org.apache.commons.codec.language.bm.NameType r1 = r13.nameType
            org.apache.commons.codec.language.bm.RuleType r2 = r13.ruleType
            java.lang.String r3 = "common"
            java.util.Map r1 = org.apache.commons.codec.language.bm.Rule.getInstanceMap((org.apache.commons.codec.language.bm.NameType) r1, (org.apache.commons.codec.language.bm.RuleType) r2, (java.lang.String) r3)
            org.apache.commons.codec.language.bm.NameType r2 = r13.nameType
            org.apache.commons.codec.language.bm.RuleType r3 = r13.ruleType
            java.util.Map r8 = org.apache.commons.codec.language.bm.Rule.getInstanceMap((org.apache.commons.codec.language.bm.NameType) r2, (org.apache.commons.codec.language.bm.RuleType) r3, (org.apache.commons.codec.language.bm.Languages.LanguageSet) r15)
            java.util.Locale r2 = java.util.Locale.ENGLISH
            java.lang.String r14 = r14.toLowerCase(r2)
            r2 = 45
            r3 = 32
            java.lang.String r14 = r14.replace(r2, r3)
            java.lang.String r14 = r14.trim()
            org.apache.commons.codec.language.bm.NameType r2 = r13.nameType
            org.apache.commons.codec.language.bm.NameType r3 = org.apache.commons.codec.language.bm.NameType.GENERIC
            java.lang.String r4 = " "
            r5 = 0
            r6 = 2
            r7 = 1
            if (r2 != r3) goto L_0x00ed
            int r2 = r14.length()
            java.lang.String r3 = ")"
            java.lang.String r9 = ")-("
            java.lang.String r10 = "("
            if (r2 < r6) goto L_0x0085
            java.lang.String r2 = r14.substring(r5, r6)
            java.lang.String r11 = "d'"
            boolean r2 = r2.equals(r11)
            if (r2 == 0) goto L_0x0085
            java.lang.String r14 = r14.substring(r6)
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r0 = "d"
            r15.append(r0)
            r15.append(r14)
            java.lang.String r15 = r15.toString()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r10)
            java.lang.String r14 = r13.encode(r14)
            r0.append(r14)
            r0.append(r9)
            java.lang.String r14 = r13.encode(r15)
            r0.append(r14)
            r0.append(r3)
            java.lang.String r14 = r0.toString()
            return r14
        L_0x0085:
            java.util.Map<org.apache.commons.codec.language.bm.NameType, java.util.Set<java.lang.String>> r2 = NAME_PREFIXES
            org.apache.commons.codec.language.bm.NameType r11 = r13.nameType
            java.lang.Object r2 = r2.get(r11)
            java.util.Set r2 = (java.util.Set) r2
            java.util.Iterator r2 = r2.iterator()
        L_0x0093:
            boolean r11 = r2.hasNext()
            if (r11 == 0) goto L_0x00ed
            java.lang.Object r11 = r2.next()
            java.lang.String r11 = (java.lang.String) r11
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r11)
            r12.append(r4)
            java.lang.String r12 = r12.toString()
            boolean r12 = r14.startsWith(r12)
            if (r12 == 0) goto L_0x0093
            int r15 = r11.length()
            int r15 = r15 + r7
            java.lang.String r14 = r14.substring(r15)
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            r15.append(r11)
            r15.append(r14)
            java.lang.String r15 = r15.toString()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r10)
            java.lang.String r14 = r13.encode(r14)
            r0.append(r14)
            r0.append(r9)
            java.lang.String r14 = r13.encode(r15)
            r0.append(r14)
            r0.append(r3)
            java.lang.String r14 = r0.toString()
            return r14
        L_0x00ed:
            java.lang.String r2 = "\\s+"
            java.lang.String[] r14 = r14.split(r2)
            java.util.List r14 = java.util.Arrays.asList(r14)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            int[] r3 = org.apache.commons.codec.language.bm.PhoneticEngine.AnonymousClass1.$SwitchMap$org$apache$commons$codec$language$bm$NameType
            org.apache.commons.codec.language.bm.NameType r9 = r13.nameType
            int r9 = r9.ordinal()
            r3 = r3[r9]
            if (r3 == r7) goto L_0x013b
            if (r3 == r6) goto L_0x012a
            r6 = 3
            if (r3 != r6) goto L_0x0111
            r2.addAll(r14)
            goto L_0x0159
        L_0x0111:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r0 = "Unreachable case: "
            r15.append(r0)
            org.apache.commons.codec.language.bm.NameType r0 = r13.nameType
            r15.append(r0)
            java.lang.String r15 = r15.toString()
            r14.<init>(r15)
            throw r14
        L_0x012a:
            r2.addAll(r14)
        L_0x012d:
            java.util.Map<org.apache.commons.codec.language.bm.NameType, java.util.Set<java.lang.String>> r3 = NAME_PREFIXES
            org.apache.commons.codec.language.bm.NameType r6 = r13.nameType
            java.lang.Object r3 = r3.get(r6)
            java.util.Collection r3 = (java.util.Collection) r3
            r2.removeAll(r3)
            goto L_0x0159
        L_0x013b:
            java.util.Iterator r3 = r14.iterator()
        L_0x013f:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto L_0x012d
            java.lang.Object r6 = r3.next()
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r9 = "'"
            java.lang.String[] r6 = r6.split(r9)
            int r9 = r6.length
            int r9 = r9 - r7
            r6 = r6[r9]
            r2.add(r6)
            goto L_0x013f
        L_0x0159:
            boolean r3 = r13.concat
            if (r3 == 0) goto L_0x0162
            java.lang.String r14 = join(r2, r4)
            goto L_0x0172
        L_0x0162:
            int r3 = r2.size()
            if (r3 != r7) goto L_0x01a2
            java.util.Iterator r14 = r14.iterator()
            java.lang.Object r14 = r14.next()
            java.lang.String r14 = (java.lang.String) r14
        L_0x0172:
            org.apache.commons.codec.language.bm.PhoneticEngine$PhonemeBuilder r15 = org.apache.commons.codec.language.bm.PhoneticEngine.PhonemeBuilder.empty(r15)
            r5 = r15
            r6 = 0
        L_0x0178:
            int r15 = r14.length()
            if (r6 >= r15) goto L_0x0195
            org.apache.commons.codec.language.bm.PhoneticEngine$RulesApplication r15 = new org.apache.commons.codec.language.bm.PhoneticEngine$RulesApplication
            int r7 = r13.maxPhonemes
            r2 = r15
            r3 = r0
            r4 = r14
            r2.<init>(r3, r4, r5, r6, r7)
            org.apache.commons.codec.language.bm.PhoneticEngine$RulesApplication r15 = r15.invoke()
            int r6 = r15.getI()
            org.apache.commons.codec.language.bm.PhoneticEngine$PhonemeBuilder r5 = r15.getPhonemeBuilder()
            goto L_0x0178
        L_0x0195:
            org.apache.commons.codec.language.bm.PhoneticEngine$PhonemeBuilder r14 = r13.applyFinalRules(r5, r1)
            org.apache.commons.codec.language.bm.PhoneticEngine$PhonemeBuilder r14 = r13.applyFinalRules(r14, r8)
            java.lang.String r14 = r14.makeString()
            return r14
        L_0x01a2:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.util.Iterator r15 = r2.iterator()
        L_0x01ab:
            boolean r0 = r15.hasNext()
            if (r0 == 0) goto L_0x01c4
            java.lang.Object r0 = r15.next()
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = "-"
            r14.append(r1)
            java.lang.String r0 = r13.encode(r0)
            r14.append(r0)
            goto L_0x01ab
        L_0x01c4:
            java.lang.String r14 = r14.substring(r7)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.language.bm.PhoneticEngine.encode(java.lang.String, org.apache.commons.codec.language.bm.Languages$LanguageSet):java.lang.String");
    }
}
