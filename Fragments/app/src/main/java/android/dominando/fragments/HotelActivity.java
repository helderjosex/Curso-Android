package android.dominando.fragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;

import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.SearchView;
import android.widget.Switch;


public class HotelActivity extends ActionBarActivity implements HotelListFragment.AoClicarNoHotel,SearchView.OnQueryTextListener,MenuItemCompat.OnActionExpandListener{

    private FragmentManager mFragmentManager;
    private HotelListFragment mListFragment;
    private SearchView mSearchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);

        mFragmentManager = getSupportFragmentManager();
        mListFragment = (HotelListFragment) mFragmentManager.findFragmentById(R.id.fragmentLista);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_hotel,menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        mSearchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        //mSearchView.setOnQueryTextListener(this);
        //mSearchView.setQueryHint(getString(R.string.hint_busca));
        //MenuItemCompat.setOnActionExpandListener(searchItem,this);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.action_info:
                GenericDialogFragment dialog = GenericDialogFragment.newDialog(
                        0,
                        R.string.sobre_titulo,
                        R.string.sobre_mensagem,
                        new int[] { android.R.string.ok,R.string.sobre_botao_site}

                );
                dialog.abrir(mFragmentManager);
        }

        return super.onOptionsItemSelected(item);
    }

    public void aoClicar(int id, int button){
        if(button == DialogInterface.BUTTON_NEGATIVE){
            Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("http://nglauber.blogspot.com"));
            startActivity(it);
        }
    }

    @Override
    public void clicouNoHotel(Hotel hotel) {

        if(isTablet()){
            HotelDetalheFragment fragment = HotelDetalheFragment.novaInstancia(hotel);

            FragmentTransaction ft = mFragmentManager.beginTransaction();
            ft.replace(R.id.detalhe,fragment,HotelDetalheFragment.TAG_DETALHE);
            ft.commit();
        }else {

            Intent it = new Intent(this,HotelDelhalheActivity.class);
            it.putExtra(HotelDelhalheActivity.EXTRA_HOTEL,hotel);
            startActivity(it);

        }

    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return true;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        mListFragment.buscar(s);
        return false;
    }

    @Override
    public boolean onMenuItemActionExpand(MenuItem item) {
        return true; // para expandir a view
    }

    @Override
    public boolean onMenuItemActionCollapse(MenuItem item) {
        mListFragment.limparBusca();
        return true; // para voltar ao normal
    }

    private boolean isTablet(){
        return getResources().getBoolean(R.bool.tablet);
    }
    private boolean isSmartphone(){
        return getResources().getBoolean(R.bool.smartphone);
    }
}
