package edu.cnm.deepdive.criminalintent.controller;

import android.support.v4.app.Fragment;
import edu.cnm.deepdive.criminalintent.CrimeListFragment;
import edu.cnm.deepdive.criminalintent.SingleFragmentActivity;

public class CrimeListActivity extends SingleFragmentActivity {

  @Override
  protected Fragment createFragment() {
    return new CrimeListFragment();

  }
}
