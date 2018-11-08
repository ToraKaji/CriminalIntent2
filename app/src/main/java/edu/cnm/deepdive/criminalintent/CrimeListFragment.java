package edu.cnm.deepdive.criminalintent;


import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.RecyclerViewAccessibilityDelegate;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.TextView;
import android.widget.Toast;
import edu.cnm.deepdive.criminalintent.model.Crime;
import edu.cnm.deepdive.criminalintent.model.CrimeLab;
import java.util.List;

public class CrimeListFragment extends Fragment {
  private RecyclerView mCrimeRecyclerView;
  private CrimeAdapter adapter;

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_crime_list, container,false);


    mCrimeRecyclerView = (RecyclerView) view.findViewById(R.id.list_item_recycler);

    mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    updateUI();
    return view;
  }
  public void updateUI(){
    CrimeLab crimeLab = CrimeLab.get(getActivity());
    List<Crime> crimes = crimeLab.getmCrimes();

    adapter = new CrimeAdapter(crimes);
    mCrimeRecyclerView.setAdapter(adapter);
  }
  private class CrimeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView mTitleTextView;
    private TextView mDateTextView;
    private Crime mCrime;
    public CrimeHolder(LayoutInflater inflater, ViewGroup parent){
      super(inflater.inflate(R.layout.list_item_crime, parent, false));
      itemView.setOnClickListener(this);
      mTitleTextView = itemView.findViewById(R.id.crime_title);
      mDateTextView = itemView.findViewById(R.id.crime_date);
    }
    public void bind(Crime crime){
      mCrime = crime;
      mTitleTextView.setText(mCrime.getmTitle());
      mDateTextView.setText(mCrime.getmDate().toString());
    }

    @Override
    public void onClick(View v) {
      Toast.makeText(getContext(), mCrime.getmTitle() + " clicked!", Toast.LENGTH_SHORT).show();
    }
  }


  private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder>{
    private List<Crime> mCrimes;

    @Override
    public void onBindViewHolder(@NonNull CrimeHolder holder, int position,
        @NonNull List<Object> payloads) {
      Crime crime = mCrimes.get(position);
      holder.bind(crime);
    }

    public CrimeAdapter(List<Crime> crimes){
      mCrimes = crimes;
    }

    @NonNull
    @Override
    public CrimeHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
      LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
      return new CrimeHolder(layoutInflater,viewGroup);
    }

    @Override
    public void onBindViewHolder(@NonNull CrimeHolder crimeHolder, int i) {

    }

    @Override
    public int getItemCount() {
      return mCrimes.size();
    }
  }
}
