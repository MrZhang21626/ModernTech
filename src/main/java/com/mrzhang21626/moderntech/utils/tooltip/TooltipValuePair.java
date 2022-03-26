package com.mrzhang21626.moderntech.utils.tooltip;

public class TooltipValuePair implements ITooltipValue{
    private String abbr;
    private int atomic;
    public TooltipValuePair(String abbr,int atomic){
        this.abbr = abbr;
        this.atomic = atomic;
    }

    public String getAbbr() {
        return this.abbr;
    }

    public int getAtomic() {
        return atomic;
    }
}
