package android.ghc.com.trainningexample;

import android.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentContent extends Fragment {
    public static final String TEXT_ARG = "text_arg";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_content_layout, container, false);

        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bundle arg = getArguments();
        if(arg != null){
            String text = arg.getString(TEXT_ARG);

            TextView tvContent = (TextView) getView().findViewById(R.id.txtContent);
            if(TextUtils.isEmpty(text)){
                tvContent.setText(getActivity().getString(R.string.no_text));
            }else{
                tvContent.setText(text);
            }
        }
    }
}
