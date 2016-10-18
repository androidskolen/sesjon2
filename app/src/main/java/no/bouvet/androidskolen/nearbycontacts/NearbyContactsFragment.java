package no.bouvet.androidskolen.nearbycontacts;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import no.bouvet.androidskolen.nearbycontacts.models.Contact;
import no.bouvet.androidskolen.nearbycontacts.models.ModelUpdateListener;
import no.bouvet.androidskolen.nearbycontacts.models.NearbyContactsListViewModel;

public class NearbyContactsFragment extends Fragment implements AdapterView.OnItemClickListener, ModelUpdateListener {


    private ContactSelectedListener contactSelectedListener;

    @Override
    public void onModelChanged() {
        updateAdapterModel();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.nearby_contacts_fragment, container, false);

        // TODO oppgave 2
        // Få tak i listview objektet og sett en adapter. Adapteren må ha verdier av typen Contact. Når man klikker på et element i listen
        // skal this.onItemClick(...) bli kalt

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            ContactSelectedListener listener = (ContactSelectedListener) context;
            contactSelectedListener = listener;

        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement ContactSelectedListener");
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        NearbyContactsListViewModel.INSTANCE.setModelUpdateListener(this);
        updateAdapterModel();
    }

    @Override
    public void onPause() {
        super.onPause();

        NearbyContactsListViewModel.INSTANCE.removeModelUpdateListener(this);
    }

    private void updateAdapterModel() {
        List<Contact> contactList = NearbyContactsListViewModel.INSTANCE.getNearbyContacts();

        // TODO oppgave 2
        // Oppdater listview adapteren med den nye listen. Pass på at gui refreshes.
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        // TODO oppgave 2
        // Hent ut valgt Contact objekt fra listview adapteren i stedet for null.
        Contact contact = null;

        if (contactSelectedListener != null) {
            contactSelectedListener.onContactSelected(contact);
        }
    }
}
