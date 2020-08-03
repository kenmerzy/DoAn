package ngoclong.example.phanmemthibanglai.ui.bienbao;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;

import ngoclong.example.phanmemthibanglai.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BienBaoCamFragment extends Fragment {

    private SearchView searchView = null;
    private SearchView.OnQueryTextListener queryTextListener;
    private BienBaoDAO bb;
    private ArrayList<BienBao> arrBienBaoCam;//


    TextView tvTenBienBao;
    TextView tvMoTa;
    ImageView imvHinhBienBao;
    ListView listView;
    int count;

    public BienBaoCamFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bien_bao_cam, container, false);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bb = new BienBaoDAO(getContext());
        arrBienBaoCam = new ArrayList<BienBao>();
        count = bb.getSoBienBaoCam();
        setHasOptionsMenu(true);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        super.onViewCreated(view, savedInstanceState);
        listView = view.findViewById(R.id.listV_BaoCam);
        loadAllBBC();
    }
    private void loadAllBBC() {
        arrBienBaoCam = bb.getAllBienBaoCam();
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
    }//

    private void loadBBCTheoSearch(String search) {
        arrBienBaoCam = bb.getBienBaoCamBySearch(search);
        if(arrBienBaoCam.size() > 0) {
            CustomAdapter customAdapter = new CustomAdapter();
            listView.setAdapter(customAdapter);
            listView.setVisibility(View.VISIBLE);
        }
        else
            listView.setVisibility(View.GONE);
    }//



    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_bien_bao, menu);
        MenuItem searchItem = menu.findItem(R.id.searchView);
        SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        if (searchItem != null){
            searchView = (SearchView) searchItem.getActionView();
        }
        if (searchView != null) {
            searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));
            queryTextListener = new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String s) {
                    if(s.length() != 0)
                        loadBBCTheoSearch(s);
                    else
                        loadAllBBC();
                    return true;
                }

                @Override
                public boolean onQueryTextChange(String s) {
                    if(s.length() != 0)
                        loadBBCTheoSearch(s);
                    else
                        loadAllBBC();

                    return true;
                }
            };
            searchView.setOnQueryTextListener(queryTextListener);
        }

        super.onCreateOptionsMenu(menu, inflater);
    }

    private class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return arrBienBaoCam.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup parent) {
            View view1 = getLayoutInflater().inflate(R.layout.item_bien_bao, null);
            tvTenBienBao = view1.findViewById(R.id.tvTenBienBao);
            tvMoTa = view1.findViewById(R.id.tvMoTaBienBao);
            imvHinhBienBao = view1.findViewById(R.id.imvBienBao);

            tvTenBienBao.setText(arrBienBaoCam.get(i).getTenBB());
            tvMoTa.setText(arrBienBaoCam.get(i).getNoiDung());
            String url = "file:///android_asset/images/"+arrBienBaoCam.get(i).getHinh();
            Picasso.with(getContext()).load(url).into(imvHinhBienBao);
            return view1;
        }
    }
}
