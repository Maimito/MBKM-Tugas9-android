package com.mbkm.tugas9_gits;

import android.app.Notification;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.dd.processbutton.iml.ActionProcessButton;
import com.google.android.material.textfield.TextInputEditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private TextInputEditText mNamaLengkap;
    private TextInputEditText mEmail;
    private TextInputEditText mPassword;
    private ActionProcessButton mDeleteAll;
    private Handler handler;




    public AddFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddFragment newInstance(String param1, String param2) {
        AddFragment fragment = new AddFragment();
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
        View root = inflater.inflate(R.layout.fragment_add, container, false);

        mNamaLengkap = (TextInputEditText) root.findViewById(R.id.namaLengkap);
        mEmail = (TextInputEditText) root.findViewById(R.id.email);
        mPassword = (TextInputEditText) root.findViewById(R.id.password);
        mDeleteAll = (ActionProcessButton) root.findViewById(R.id.deleteAll);
        handler = new Handler();

        ActionProcessButton deleteAll = (ActionProcessButton) root.findViewById(R.id.deleteAll);
        deleteAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteAllData();
            }
        });

        return root;
    }

    public void deleteAllData(){
        mDeleteAll.setMode(ActionProcessButton.Mode.PROGRESS);
        mDeleteAll.setProgress(0);
        mNamaLengkap.setText("");
        mEmail.setText("");
        mPassword.setText("");
        mDeleteAll.setProgress(100);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mDeleteAll.setProgress(0);
            }
        }, 2000);
    }
}