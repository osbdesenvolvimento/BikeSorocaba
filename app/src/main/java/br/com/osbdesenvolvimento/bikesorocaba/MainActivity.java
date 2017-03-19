package br.com.osbdesenvolvimento.bikesorocaba;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

import br.com.osbdesenvolvimento.bikesorocaba.activities.MatheusActivity;
import br.com.osbdesenvolvimento.bikesorocaba.activities.PauloActivity;
import br.com.osbdesenvolvimento.bikesorocaba.adapters.TabsAdapter;
import br.com.osbdesenvolvimento.bikesorocaba.classes.TabsFactory;

public class MainActivity extends AppCompatActivity  implements TabHost.OnTabChangeListener, ViewPager.OnPageChangeListener{
    TabHost mTabHost;
    ViewPager mViewPager;
    TabsAdapter mTabsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mTabHost = (TabHost) findViewById(android.R.id.tabhost);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);

        // inicia a TabHost
        mTabHost.setup();

        // cria as tabs
        this.AddTab( this, this.mTabHost, "Mapa", R.drawable.ic_map_marker_radius );
        this.AddTab( this, this.mTabHost, "Lista", R.drawable.ic_format_list_bulleted );
        this.AddTab( this, this.mTabHost, "Informações", R.drawable.ic_information_outline );


        if (savedInstanceState != null) {
            int pos = this.mTabHost.getCurrentTab();
            mTabHost.setCurrentTabByTag(String.valueOf(savedInstanceState.getInt(String.valueOf(pos))));
        }

        // cria um novo adapter dos Fragments/Tabs
        mTabsAdapter = new TabsAdapter(getSupportFragmentManager());
        // seta o adapter criado no viewpager
        mViewPager.setAdapter(mTabsAdapter);

        // seta o listener
        mTabHost.setOnTabChangedListener(this);
        mViewPager.addOnPageChangeListener(this);
        mViewPager.setOffscreenPageLimit(2);

    }

    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("tab", mTabHost.getCurrentTabTag()); //save the tab selected
        super.onSaveInstanceState(outState);
    }

    // Method to add a TabHost
    private void AddTab(MainActivity activity, TabHost tabHost, String nome, int Icon) {
        View view = LayoutInflater.from(activity).inflate(R.layout.tabhost_tab, tabHost.getTabWidget(), false);
        view.setBackgroundResource(R.drawable.tab_selector);

        TextView tituloAba = (TextView) view.findViewById(R.id.title);
        tituloAba.setText(nome);

        ImageView icon = (ImageView) view.findViewById(R.id.icon);
        icon.setImageResource(Icon);

        TabHost.TabSpec spec = tabHost.newTabSpec(nome).setIndicator(view).setContent(new TabsFactory(activity));
        tabHost.addTab(spec);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        int pos = this.mViewPager.getCurrentItem();
        this.mTabHost.setCurrentTab(pos);
    }

    @Override
    public void onPageSelected(int position) {
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

    @Override
    public void onTabChanged(String s) {
        int pos = this.mTabHost.getCurrentTab();
        this.mViewPager.setCurrentItem(pos);
    }
}
