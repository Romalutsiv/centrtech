package com.myproject.centrtech.enums;

public enum OrderType {
    NEW                     ("danger"),
    FOR_PERFORMANCE         ("warning"),
    TO_PAY                  ("success"),
    PAID                    ("dark");

    private final String style;

    OrderType (String style){
        this.style = style;
    }

    public String getStyle(){
        return style;
    }
}
