package exam.francys.appagenda.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import exam.francys.appagenda.Adapter.AdapterUser;
import exam.francys.appagenda.DataBase.CRUD_Diary;
import exam.francys.appagenda.DataBase.Diary;
import exam.francys.appagenda.Models.Usuario;
import exam.francys.appagenda.R;

import static exam.francys.appagenda.DataBase.CRUD_Diary.getall;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShowUsers extends Fragment {

    private Diary diary;
    private RecyclerView recyclerView;
    private  RecyclerView.LayoutManager imager;
    private  RecyclerView.Adapter adapter;


    public ShowUsers() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_show_users, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        diary = new Diary(view.getContext());

        List<Usuario> list= CRUD_Diary.getall(diary);

        recyclerView =(RecyclerView) view.findViewById(R.id.recycle);
        imager =new LinearLayoutManager(this.getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(imager);


        adapter = new AdapterUser(list);
        recyclerView.setAdapter(adapter);




    }
}
