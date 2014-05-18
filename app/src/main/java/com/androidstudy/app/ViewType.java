package com.androidstudy.app;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kosuke.Mita on 2014/05/14.
 */
public enum ViewType {
    LINEAR_LAYOUT("LinearLayout"),
    RELATIVE_LAYOUT("RelativeLayout"),
    TABLE_LAYOUT("TableLayout"),
    DATE_PICKER("DatePicker"),
    TIME_PICKER("TimePicker"),
    FORM_STUFF("FormStuff"),
    SPINNER("Spinner"),
    AUTO_COMPLETE("AutoComplete"),
    LIST_VIEW("ListView"),
    GRID_VIEW("GridView"),
    GARALLEY("Gallery"),
    TAB_WIDGET("TabWidget"),
    MAP_VIEW("MapView"),
    WEB_VIEW("WebView"),
    PREFERENCE("Preference"),
    UNKNOWN("Unknown");

    private final String name;

    private ViewType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static List<String> getNames() {
       List<String> lists = new ArrayList<String>();
        for(ViewType type : ViewType.values()) {
            lists.add(type.getName());
        }
        lists.remove(UNKNOWN.getName());
        return lists;
    }

    public static ViewType getType(String name) {
        for (ViewType type : ViewType.values()) {
            if(name.equals(type.getName())) {
                return type;
            }
        }

        return UNKNOWN;
    }
}
