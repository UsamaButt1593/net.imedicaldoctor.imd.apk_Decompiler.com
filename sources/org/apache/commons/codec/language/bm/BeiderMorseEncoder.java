package org.apache.commons.codec.language.bm;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

public class BeiderMorseEncoder implements StringEncoder {
    private PhoneticEngine engine = new PhoneticEngine(NameType.GENERIC, RuleType.APPROX, true);

    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof String) {
            return encode((String) obj);
        }
        throw new EncoderException("BeiderMorseEncoder encode parameter is not of type String");
    }

    public NameType getNameType() {
        return this.engine.getNameType();
    }

    public RuleType getRuleType() {
        return this.engine.getRuleType();
    }

    public boolean isConcat() {
        return this.engine.isConcat();
    }

    public void setConcat(boolean z) {
        this.engine = new PhoneticEngine(this.engine.getNameType(), this.engine.getRuleType(), z, this.engine.getMaxPhonemes());
    }

    public void setMaxPhonemes(int i2) {
        this.engine = new PhoneticEngine(this.engine.getNameType(), this.engine.getRuleType(), this.engine.isConcat(), i2);
    }

    public void setNameType(NameType nameType) {
        this.engine = new PhoneticEngine(nameType, this.engine.getRuleType(), this.engine.isConcat(), this.engine.getMaxPhonemes());
    }

    public void setRuleType(RuleType ruleType) {
        this.engine = new PhoneticEngine(this.engine.getNameType(), ruleType, this.engine.isConcat(), this.engine.getMaxPhonemes());
    }

    public String encode(String str) throws EncoderException {
        if (str == null) {
            return null;
        }
        return this.engine.encode(str);
    }
}
