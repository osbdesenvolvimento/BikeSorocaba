package br.com.osbdesenvolvimento.bikesorocaba.classes;

import android.content.Context;
import android.view.View;
import android.widget.TabHost;

public class TabsFactory implements TabHost.TabContentFactory {

    private final Context mContext;

    public TabsFactory(Context context) {
        mContext = context;
    }

    public View createTabContent(String tag) {
        View v = new View(mContext);
        v.setMinimumWidth(0);
        v.setMinimumHeight(0);
        return v;
    }
}