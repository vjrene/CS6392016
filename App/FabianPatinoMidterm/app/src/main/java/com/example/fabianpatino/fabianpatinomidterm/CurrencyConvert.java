package com.example.fabianpatino.fabianpatinomidterm;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CurrencyConvert.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CurrencyConvert#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CurrencyConvert extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "dollar";
    private static final String ARG_PARAM2 = "francs";

    // TODO: Rename and change types of parameters
    private double dollar;
    private double francs =0;

    private OnFragmentInteractionListener mListener;

    public CurrencyConvert() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CurrencyConvert.
     */
    // TODO: Rename and change types and number of parameters
    public static CurrencyConvert newInstance(double dollar) {
        CurrencyConvert fragment = new CurrencyConvert();
        Bundle args = new Bundle();
        args.putDouble(ARG_PARAM1, dollar);
        //args.putDouble(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {


        }
    }

    public double convert(double dollar){
        dollar = getArguments().getDouble(ARG_PARAM1);
        francs= dollar * 586.84;
        return francs;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_currency_convert, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Double dollar) {
        if (mListener != null) {
           // mListener.onFragmentInteraction();
            convert(dollar);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
