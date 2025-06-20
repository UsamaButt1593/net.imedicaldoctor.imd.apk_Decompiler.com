package com.nineoldandroids.animation;

public class IntEvaluator implements TypeEvaluator<Integer> {
    /* renamed from: a */
    public Integer evaluate(float f2, Integer num, Integer num2) {
        int intValue = num.intValue();
        return Integer.valueOf((int) (((float) intValue) + (f2 * ((float) (num2.intValue() - intValue)))));
    }
}
