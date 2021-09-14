package com.mbkm.tugas9_gits;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recylerViewLayoutManager;

    String[] judul = {"Kucing", "Anjing"};
    String[] imageurl = {"https://instagram.fcgk27-1.fna.fbcdn.net/v/t51.2885-15/sh0.08/e35/p640x640/241729582_395739688625845_2212968315757942974_n.jpg?_nc_ht=instagram.fcgk27-1.fna.fbcdn.net&_nc_cat=1&_nc_ohc=0nQOhqIym5cAX_yFnvB&edm=AP_V10EBAAAA&ccb=7-4&oh=c65f844d76b4034066a24b0bdf2f7b25&oe=61450E89&_nc_sid=4f375e",
            "https://instagram.fcgk27-1.fna.fbcdn.net/v/t51.2885-15/e15/241732934_282002370094692_2628944308032810694_n.jpg?_nc_ht=instagram.fcgk27-1.fna.fbcdn.net&_nc_cat=100&_nc_ohc=T34KjQi3uP4AX_3fLdU&edm=AP_V10EBAAAA&ccb=7-4&oh=e19cb0a255fd4bf01e7716f11912c8b3&oe=6147D1F8&_nc_sid=4f375e"};
    String[] link = {"https://id.wikipedia.org/wiki/Kucing",
                    "https://id.wikipedia.org/wiki/Anjing"};

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = (RecyclerView) root.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recylerViewLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(recylerViewLayoutManager);
        ArrayList daftar = Data();
        recyclerViewAdapter = new AdapterRecyclerView(getActivity(),daftar);
        recyclerView.setAdapter(recyclerViewAdapter);

        return root;
    }

    private ArrayList Data(){
        ArrayList arrayList = new ArrayList<>();
        for(int i = 0; i < judul.length; i++){
            Daftar daftar = new Daftar();
            daftar.setNama(judul[i]);
            daftar.setUrl(imageurl[i]);
            daftar.setLink(link[i]);
            arrayList.add(daftar);
        }
        return arrayList;
    }
}