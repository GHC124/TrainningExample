package android.ghc.com.trainningexample;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class DialogFragmentExample extends DialogFragment {
    private int mNum;
    /**
     * Create a new instance of MyDialogFragment, providing "num"
     * as an argument.
     */
    static DialogFragmentExample newInstance(int num) {
        DialogFragmentExample f = new DialogFragmentExample();

        // Supply num input as an argument.
        Bundle args = new Bundle();
        args.putInt("num", num);
        f.setArguments(args);

        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNum = getArguments().getInt("num");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_dialog, container, false);
        View tv = v.findViewById(R.id.text);
        ((TextView)tv).setText("Dialog #" + mNum);

        // Watch for button clicks.
        Button button = (Button)v.findViewById(R.id.btnShowDialog);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // When button is clicked, call up to owning activity.
                ((MainActivity)getActivity()).showDialog();
            }
        });
        Button btnClose = (Button)v.findViewById(R.id.btnCloseAllDialog);
        btnClose.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // When button is clicked, call up to owning activity.
                ((MainActivity)getActivity()).closeAllDialog();
            }
        });

       getDialog().setTitle("Dialog #" + mNum);

        return v;
    }

    public void close(){
        getDialog().dismiss();
    }
}
