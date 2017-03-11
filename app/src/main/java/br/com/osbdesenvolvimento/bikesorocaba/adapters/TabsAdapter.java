package br.com.osbdesenvolvimento.bikesorocaba.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import br.com.osbdesenvolvimento.bikesorocaba.fragments.InformacoesFragment;
import br.com.osbdesenvolvimento.bikesorocaba.fragments.MapFragment;
import br.com.osbdesenvolvimento.bikesorocaba.fragments.Temp1Fragment;

public class TabsAdapter extends FragmentPagerAdapter {

    public TabsAdapter(FragmentManager fm) {

        super(fm);
    }

    @Override
    public Fragment getItem(int index) {

        switch (index) {
            case 0:
                MapFragment rFragment1 = new MapFragment();
                return rFragment1;
            case 1:
                Temp1Fragment rFragment2 = new Temp1Fragment();
                return rFragment2;
            case 2:
                InformacoesFragment rFragment3 = new InformacoesFragment();
                return rFragment3;
        }
        return null;
    }

    @Override
    public int getCount() {

        return 3;
    }

}