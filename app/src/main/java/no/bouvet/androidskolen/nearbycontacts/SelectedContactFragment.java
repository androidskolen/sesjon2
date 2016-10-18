package no.bouvet.androidskolen.nearbycontacts;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import no.bouvet.androidskolen.nearbycontacts.models.ModelUpdateListener;
import no.bouvet.androidskolen.nearbycontacts.models.OwnContactViewModel;
import no.bouvet.androidskolen.nearbycontacts.models.Contact;
import no.bouvet.androidskolen.nearbycontacts.models.SelectedContactViewModel;

public class SelectedContactFragment extends Fragment implements ModelUpdateListener, View.OnClickListener {

    private static final String TAG = SelectedContactFragment.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.selected_contact_fragment, container, false);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        SelectedContactViewModel.INSTANCE.setModelUpdateListener(this);
        updateGui(SelectedContactViewModel.INSTANCE.getContact());
    }

    @Override
    public void onModelChanged() {
        updateGui(SelectedContactViewModel.INSTANCE.getContact());
    }


    private void updateGui(Contact contact) {
        if (contact != null) {
            Log.d(TAG, "Contact selected: " + contact.getName());
        }
    }

    @Override
    public void onClick(View view) {

        Contact contact = SelectedContactViewModel.INSTANCE.getContact();

        if (contact != null) {
            // TODO oppgave 3
            // Lag en intent som skal lagre en ny kontakt i androids innebygde kontakt-funksjonalitet.
            // Den skal startes slik at man får et resultat om man lagred eller ikke tilbake. HINT: onActivityResult(..
            // https://developer.android.com/training/contacts-provider/modify-data.html
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                Toast.makeText(getActivity(), "Added Contact", Toast.LENGTH_SHORT).show();
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(getActivity(), "Cancelled Added Contact", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
