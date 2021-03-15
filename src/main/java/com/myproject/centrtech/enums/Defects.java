package com.myproject.centrtech.enums;

public enum Defects {
    CHARGER                 ("зарядний пристрій"),
    VISUALDEFECTS           ("візуальні дефекти"),
    SPALLS                  ("відколи"),
    CRACKS                  ("тріщини"),
    FAULT                   ("розломи"),
    BODYSCATTERS            ("подряпини корпусу"),
    SCREENCATTERS           ("подряпини екрану"),
    INTEGRITYOFPORTS        ("цілісність портів"),
    OPENTRACES              ("сліди відкриття"),
    FOLLOWINGTRACKS         ("сліди залиття"),
    AVAILABLEBATTERY        ("наявність АКБ");

    private final String ukrName;

    Defects (String ukrName){
        this.ukrName = ukrName;
    }

    public String getUkrName(){
        return ukrName;
    }
}
