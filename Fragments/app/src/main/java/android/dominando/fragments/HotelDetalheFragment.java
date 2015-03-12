package android.dominando.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Created by Mac on 11/03/15.
 */
public class HotelDetalheFragment extends Fragment {

    public static final String TAG_DETALHE = "tagDetalhe";
    private static final String EXTRA_HOTEL = "hotel";

    TextView mTextNome;
    TextView mTextEndereco;
    RatingBar mRattingEstrelas;

    Hotel mHotel;

    public static HotelDetalheFragment novaInstancia(Hotel hotel){
        Bundle parametros = new Bundle();
        parametros.putSerializable(EXTRA_HOTEL,hotel);

        HotelDetalheFragment fragment = new HotelDetalheFragment();
        fragment.setArguments(parametros);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHotel = (Hotel) getArguments().getSerializable(EXTRA_HOTEL);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_detalhe_hotel,container,false);
        mTextNome = (TextView) layout.findViewById(R.id.txtNome);
        mTextEndereco = (TextView) layout.findViewById(R.id.txtEndereco);
        mRattingEstrelas = (RatingBar) layout.findViewById(R.id.rtbEstrelas);

        if (mHotel != null){
            mTextNome.setText(mHotel.nome);
            mTextEndereco.setText(mHotel.endereco);
            mRattingEstrelas.setRating(mHotel.estrelas);
        }

        return layout;
    }
}
