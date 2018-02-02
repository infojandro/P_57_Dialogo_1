package com.example.alu.p_57_dialogo_1;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

/**
 * Created by alu on 02/02/2018.
 */
public class MiDialogo extends DialogFragment {

    public interface MiDialogoListener {
        public void onDialogPositiveClick(String devuelto);
        //public void onDialogNegativeClick(int escogido);
    }

    MiDialogoListener miEscuchador;

    // Sobreescribimos el método onAttach() para instanciar el
//escuchador
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            miEscuchador = (MiDialogoListener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString()
                    + " must implement MiDialogoListener");
        }
    }
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Desea Realmente finalizar la aplicación")
                .setMessage("Pulsa ok para finalizar")
                .setPositiveButton(android.R.string.ok,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                miEscuchador.onDialogPositiveClick("SI");
                            }
                        })
                .setNegativeButton(android.R.string.cancel,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Toast.makeText(getActivity(),"Has pulsado Cancel", Toast.LENGTH_LONG).show();
                            }
                        });
        return builder.create();
    }
    @Override
    public void onDetach () {
        super.onDetach();
        miEscuchador=null;
    }
}