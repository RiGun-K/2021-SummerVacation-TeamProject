package com.example.teamprojectt;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class NoticeListAdapter extends BaseAdapter {

    private Context context;
    private List<Notice> noticeList, noticeList2;

    public NoticeListAdapter(Context context, List<Notice> noticeList) {
        this.context = context;
        this.noticeList = noticeList;
        this.noticeList2 = noticeList2;
    }

    @Override
    public int getCount() { return noticeList.size();

    }


    @Override
    public Object getItem(int i) { return noticeList.get(i);

    }

    @Override
    public long getItemId(int i) { return i;

    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        View view = View.inflate(context, R.layout.notice, null);
        TextView noticeText = (TextView) view.findViewById(R.id.noticeText);
        TextView nameText = (TextView) view.findViewById(R.id.nameText);
        TextView dateText = (TextView) view.findViewById(R.id.dateText);

//        이상한 오류로 로그인에서 안넘어 가서 주석처리함 ..
        noticeText.setText(noticeList.get(i).getNotice());
        nameText.setText(noticeList.get(i).getName());
        dateText.setText(noticeList.get(i).getDate());

        view.setTag(noticeList.get(i).getNotice());
        return view;
    }
}
