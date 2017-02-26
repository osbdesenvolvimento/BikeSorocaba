package br.com.osbdesenvolvimento.bikesorocaba.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.osbdesenvolvimento.bikesorocaba.R;
import br.com.osbdesenvolvimento.bikesorocaba.dtos.Estacao;

public class EstacaoAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Estacao> lista;
    private static String STATUS_ATIVA = "Ativa";

    public EstacaoAdapter(Context context, ArrayList<Estacao> list) {
        this.context = context;
        this.lista = list;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Estacao estacao = lista.get(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.estacao, null);

        LinearLayout llEstacao = (LinearLayout) layout.findViewById(R.id.llEstacao);
        if (position % 2 == 1) {
            llEstacao.setBackgroundColor(Color.parseColor("#ffffff"));
        } else {
            llEstacao.setBackgroundColor(Color.parseColor("#e5e5e5"));
        }

        TextView tvName = (TextView) layout.findViewById(R.id.tvNome);
        tvName.setText(estacao.getStationNumber() + " - " + estacao.getName());
        if (STATUS_ATIVA.compareToIgnoreCase(estacao.getStatus()) == 0) {
            tvName.setTextColor(Color.parseColor("#75b76f"));
        } else {
            tvName.setTextColor(Color.parseColor("#b76f6f"));
        }

        TextView tvBikesDisponiveis = (TextView) layout.findViewById(R.id.tvBikesDisponiveis);
        TextView tvBaiasDisponiveis = (TextView) layout.findViewById(R.id.tvBaiasDisponiveis);

        String qtdBikes = estacao.getBikes() == null ? "0" : String.valueOf(estacao.getBikes().size());
        String qtdBaias = estacao.getAvailableSlotsSize() == null ? "0" : estacao.getAvailableSlotsSize();

        tvBikesDisponiveis.setText(context.getString(R.string.bikes_disponiveis, qtdBikes));
        tvBaiasDisponiveis.setText(context.getString(R.string.baias_disponiveis, qtdBaias));

        return layout;
    }
}
