package com.mrzhang21626.moderntech.utils.tooltip;

public class TooltipValue implements ITooltipValue{
    private String abbr;
    public TooltipValue(String abbr){
        this.abbr = abbr;
    }

    public String getAbbr() {
        return this.abbr;
    }

    @Override
    public int getAtomic() {
        return 0;
    }
}
