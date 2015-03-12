package android.dominando.fragments;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;


public class HotelActivity extends ActionBarActivity implements HotelListFragment.AoClicarNoHotel{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);
    }


    @Override
    public void clicouNoHotel(Hotel hotel) {

        if(isTablet()){
            HotelDetalheFragment fragment = HotelDetalheFragment.novaInstancia(hotel);
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.detalhe,fragment,HotelDetalheFragment.TAG_DETALHE);
            ft.commit();
        }else {

            Intent it = new Intent(this,HotelDelhalheActivity.class);
            it.putExtra(HotelDelhalheActivity.EXTRA_HOTEL,hotel);
            startActivity(it);

        }

    }

    private boolean isTablet(){
        return getResources().getBoolean(R.bool.tablet);
    }
    private boolean isSmartphone(){
        return getResources().getBoolean(R.bool.smartphone);
    }
}
