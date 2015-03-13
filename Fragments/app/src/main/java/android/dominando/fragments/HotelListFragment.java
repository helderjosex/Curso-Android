package android.dominando.fragments;

import android.app.Activity;
import android.support.v4.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mac on 11/03/15.
 */
public class HotelListFragment extends ListFragment {

    List<Hotel> mHoteis;
    ArrayAdapter<Hotel> mAdapter;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mHoteis = carregarHoteis();
        limparBusca();

    }

    private List<Hotel> carregarHoteis(){
        List<Hotel> hotels = new ArrayList<Hotel>();
        hotels.add(new Hotel("New Beach Hotel","Av. Boa Viagem",4.5f));
        hotels.add(new Hotel("Recife Hotel","Av. Boa Viagem",4.0f));
        hotels.add(new Hotel("Canario Hotel","Rua dos Navegantes",3.0f));
        hotels.add(new Hotel("Byanca Beach Hotel","Rua Mamanguape",4.0f));
        hotels.add(new Hotel("Grand Hotel Dor","Av. Benardo",3.5f));
        hotels.add(new Hotel("Hotel Cool","Av. Conselheiro Aguiar",4.0f));
        hotels.add(new Hotel("Hotel Infinito","Rua Ribeiro de Britto",5.0f));
        hotels.add(new Hotel("Hotel Tulipa","Av. Boa Viagem",5.0f));
        return hotels;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Activity activity = getActivity();
        if(activity instanceof AoClicarNoHotel){
            Hotel hotel = (Hotel)l.getItemAtPosition(position);

            AoClicarNoHotel listener = (AoClicarNoHotel)activity;
            listener.clicouNoHotel(hotel);
        }
    }

    public void buscar(String s){
        if (s == null || s.trim().equals("")){
            limparBusca();
            return;
        }

        List<Hotel> hoteisEncontrados = new ArrayList<Hotel>(mHoteis);
        for (int i = hoteisEncontrados.size()-1;i>=0;i--){
            Hotel hotel = hoteisEncontrados.get(i);
            if(!hotel.nome.toUpperCase().contains(s.toUpperCase())){
                hoteisEncontrados.remove(hotel);
            }
        }

        mAdapter = new ArrayAdapter<Hotel>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                hoteisEncontrados);
        setListAdapter(mAdapter);
    }

    public void limparBusca(){
        mAdapter = new ArrayAdapter<Hotel>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                mHoteis);
        setListAdapter(mAdapter);
    }

    public void adicionar(Hotel hotel){
        mHoteis.add(hotel);
        mAdapter.notifyDataSetChanged();
    }

    public interface AoClicarNoHotel {
        void clicouNoHotel(Hotel hotel);
    }
}
