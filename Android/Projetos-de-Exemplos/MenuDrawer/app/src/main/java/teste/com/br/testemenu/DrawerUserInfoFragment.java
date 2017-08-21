package teste.com.br.testemenu;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DrawerUserInfoFragment extends Fragment {

    public DrawerUserInfoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_drawer_user_info, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        loadUser();
    }

    private void loadUser() {
        TextView textNome = getView().findViewById(R.id.nav_header_nome);
        CircleImageView imagePerfil = getView().findViewById(R.id.nav_header_foto);
        textNome.setText("Wallace");
        Glide.with(this).load(R.mipmap.ic_launcher_round).into(imagePerfil);
    }

}
