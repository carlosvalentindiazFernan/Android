package exam.francys.appagenda.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import exam.francys.appagenda.Adapter.AdapterUsers;
import exam.francys.appagenda.DataBase.CRUD_Diary;
import exam.francys.appagenda.DataBase.Diarys;
import exam.francys.appagenda.Models.Usuario;
import exam.francys.appagenda.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShowUsers extends Fragment {

    private Diarys diary;
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

        diary = new Diarys(view.getContext());

        List<Usuario> list= CRUD_Diary.getall(diary);

        recyclerView =(RecyclerView) view.findViewById(R.id.recycle);
        imager =new LinearLayoutManager(this.getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(imager);


        adapter = new AdapterUsers(list);
        recyclerView.setAdapter(adapter);




    }
}
