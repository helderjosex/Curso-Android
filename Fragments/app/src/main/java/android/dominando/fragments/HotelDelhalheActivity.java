package android.dominando.fragments;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class HotelDelhalheActivity extends ActionBarActivity {

    public static final String EXTRA_HOTEL = "hotel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_delhalhe);

        Intent intent = getIntent();
        Hotel hotel = (Hotel) intent.getSerializableExtra(EXTRA_HOTEL);

        HotelDetalheFragment fragment = HotelDetalheFragment.novaInstancia(hotel);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.detalhe, fragment, HotelDetalheFragment.TAG_DETALHE);

        ft.commit();
    }


}
