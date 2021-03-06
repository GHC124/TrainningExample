package android.ghc.com.trainningexample;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {
    private int mStackLevel = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnShowFragment = (Button)findViewById(R.id.btnShowFragment);
        btnShowFragment.setOnClickListener(this);

        Button btnShowDialog = (Button)findViewById(R.id.btnShowDialog);
        btnShowDialog.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    public void showDialog(){
        mStackLevel++;
        // DialogFragment.show() will take care of adding the fragment
        // in a transaction.  We also want to remove any currently showing
        // dialog, so make our own transaction and take care of that here.
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        // Create and show the dialog.
        DialogFragment newFragment = DialogFragmentExample.newInstance(mStackLevel);
        newFragment.show(ft, "dialog" + mStackLevel);
    }

    public void closeAllDialog(){
        FragmentManager fragmentManager = getFragmentManager();
        for(int i = 1;i <= mStackLevel; i++) {
            DialogFragmentExample fragment = (DialogFragmentExample) fragmentManager.findFragmentByTag("dialog" + i);
            if (fragment != null) {
                fragment.close();
            }
        }
    }

    private void showFragment(){
        Intent intent = new Intent(this, FragmentExample.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnShowDialog:
                showDialog();
                break;
            case R.id.btnShowFragment:
                showFragment();
                break;
        }
    }
}
