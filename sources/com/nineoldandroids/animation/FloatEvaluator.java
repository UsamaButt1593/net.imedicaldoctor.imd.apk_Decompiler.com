package com.nineoldandroids.animation;

public class FloatEvaluator implements TypeEvaluator<Number> {
    /* renamed from: a */
    public Float evaluate(float f2, Number number, Number number2) {
        float floatValue = number.floatValue();
        return Float.valueOf(floatValue + (f2 * (number2.floatValue() - floatValue)));
    }
}
