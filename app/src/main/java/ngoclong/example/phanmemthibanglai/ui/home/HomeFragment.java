package ngoclong.example.phanmemthibanglai.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import ngoclong.example.phanmemthibanglai.R;
import ngoclong.example.phanmemthibanglai.ui.bienbao.BienBaoActivity;
import ngoclong.example.phanmemthibanglai.ui.caccauhaysai.CacCauHaySaiActivity;
import ngoclong.example.phanmemthibanglai.ui.hoclythuyet.HocLyThuyetActivity;
import ngoclong.example.phanmemthibanglai.ui.meothikqcao.MeoThiKQCao;
import ngoclong.example.phanmemthibanglai.ui.thisathach.ThiSatHachActivity;
import ngoclong.example.phanmemthibanglai.ui.tracuuluat.TraCuuLuatActivity;

public class HomeFragment extends Fragment {

    private GridView gridView;

    String[] items = {"THI SÁT HẠCH", "HỌC LÝ THUYẾT",
            " BIỂN BÁO \nĐƯỜNG BỘ", " MẸO THI \nKẾT QUẢ CAO",
            "TRA CỨU LUẬT", "CÁC CÂU HAY SAI"};

    int[] icons = {R.drawable.shbl, R.drawable.bookne1,
            R.drawable.bienbao1, R.drawable.brain2,
            R.drawable.bua2, R.drawable.ghich2};


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle
            savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        gridView = view.findViewById(R.id.gridViewMenu);

        CustomAdapter customAdapter = new CustomAdapter();
        gridView.setAdapter(customAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id)
            {

                switch (position)
                {
                    case 0:
                    {
                        Intent intent = new Intent(getActivity(), ThiSatHachActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case 1:
                    {
                        Intent intent = new Intent(getActivity(), HocLyThuyetActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case 2:
                    {
                        Intent intent = new Intent(getActivity(), BienBaoActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case 3:
                    {
                        Intent intent = new Intent(getActivity(), MeoThiKQCao.class);
                        startActivity(intent);
                        break;
                    }
                    case 4:
                    {
                        Intent intent = new Intent(getActivity(), TraCuuLuatActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case 5:
                    {
                        Intent intent = new Intent(getActivity(), CacCauHaySaiActivity.class);
                        startActivity(intent);
                        break;
                    }
                    default:
                    {
                        break;
                    }
                }
            }
        });
    }

    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return icons.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view1 = getLayoutInflater().inflate(R.layout.grid_item,null);
            TextView name = view1.findViewById(R.id.txtView);
            ImageView image = view1.findViewById(R.id.imgView);
            name.setText(items[i]);
            image.setImageResource(icons[i]);
            return view1;
        }
    }

}
