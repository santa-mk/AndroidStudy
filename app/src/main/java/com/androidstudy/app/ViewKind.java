package com.androidstudy.app;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kosuke.Mita on 2014/05/14.
 */
public enum ViewKind {
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
    WEB_VIEW("WebView");

    private final String name;

    private ViewKind(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static List<String> getNames() {
       List<String> lists = new ArrayList<String>();
        for(ViewKind kind : ViewKind.values()) {
            lists.add(kind.getName());
        }

        return lists;
    }
}
