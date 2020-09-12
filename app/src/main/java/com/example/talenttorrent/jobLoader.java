package com.example.talenttorrent;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import com.example.talenttorrent.adapters.jobAdapter;
import com.example.talenttorrent.models.training;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link jobLoader#newInstance} factory method to
 * create an instance of this fragment.
 */
public class jobLoader extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String key="";


    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail=new HashMap<>();

    public jobLoader(String a) {
        // Required empty public constructor
        this.key=a;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment jobLoader.
     */
    // TODO: Rename and change types and number of parameters
    public static jobLoader newInstance(String param1, String param2) {
        jobLoader fragment = new jobLoader("");
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
        View root = inflater.inflate(R.layout.fragment_job_loader, container, false);


            for(int i=0;i<3;i++) {
                List<String> basketball = new ArrayList();
                basketball.add("We are looking for an iOS developer responsible for the " +
                        "development and maintenance of applications aimed at a range " +
                        "of iOS devices including mobile phones and tablet computers. Your" +
                        " primary focus will be the development of iOS applications and their " +
                        "integration with back-end services. You will be working alongside other " +
                        "engineers and developers working on different layers of the infrastructure. " +
                        "Therefore, a commitment to collaborative problem solving, sophisticated design," +
                        " and the creation of quality products is essential.");
                expandableListDetail.put(
                        "IOS"+i+"<>$500.00<>5 Days remaining<>"+key, basketball);
            }
    ArrayList<training>arr=new ArrayList<>();
    arr.add(new training());


        expandableListView = (ExpandableListView) root.findViewById(R.id.lvTaskCompleted);
        //expandableListDetail = getData("Completed");

        expandableListTitle = new ArrayList(expandableListDetail.keySet());
        expandableListAdapter = new jobAdapter(getActivity(),
                expandableListTitle, expandableListDetail,arr);
        expandableListView.setAdapter(expandableListAdapter);



        return root;
    }
}