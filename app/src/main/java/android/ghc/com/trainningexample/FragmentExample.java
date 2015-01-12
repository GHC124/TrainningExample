package android.ghc.com.trainningexample;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

public class FragmentExample extends Activity implements AdapterView.OnItemClickListener {
    private ListView mLvItems;
    private FrameLayout mFmContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_layout);

        populateListView();
    }

    private void populateListView(){
        String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
                "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
                "Linux", "OS/2" };
        // use your custom layout
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.row_layout, R.id.txtItemTitle, values);
        mLvItems = (ListView)findViewById(R.id.ltItems);
        mLvItems.setAdapter(adapter);

        mLvItems.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String value = (String) mLvItems.getAdapter().getItem(position);

        FragmentTransaction fr = getFragmentManager().beginTransaction();
        FragmentContent fragmentContent = new FragmentContent();

        Bundle bundle = new Bundle();
        bundle.putString(FragmentContent.TEXT_ARG, value);

        fragmentContent.setArguments(bundle);

        fr.replace(R.id.frContent, fragmentContent);
        fr.commit();
    }
}
