package com.example.kiemtrafirebase_351;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CayThuocAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<CayThuoc> list;

    public CayThuocAdapter(Context context, int layout, List<CayThuoc> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout,null);

        // ánh xạ
        TextView tv_Ten = view.findViewById(R.id.Ten);
        TextView tv_TenTG = view.findViewById(R.id.tenTG);
        TextView tv_boPhan = view.findViewById(R.id.boPhanDung);

        // gán giá trị
        CayThuoc cayThuoc = list.get(i);
        tv_Ten.setText("Tên: " + cayThuoc.getTenKH());
        tv_TenTG.setText("Nghệ Danh: "+cayThuoc.getTenTG());
        tv_boPhan.setText("Màu sắc: "+cayThuoc.getBoPhanDung());

        return view;
    }
}
