package reagodjj.example.com.cardviewshow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MessageAdapter extends BaseAdapter {
    private Context context;
    private List<Message> messageList;

    public MessageAdapter(Context context, List<Message> messageList) {
        this.context = context;
        this.messageList = messageList;
    }

    @Override
    public int getCount() {
        return messageList == null ? 0 : messageList.size();
    }

    @Override
    public Message getItem(int position) {
        return messageList == null ? null : messageList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return messageList == null ? -1 : messageList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_message, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Message message = messageList.get(position);
        viewHolder.ivMessage.setImageResource(message.getImgResId());
        viewHolder.tvTitle.setText(message.getTitle());
        viewHolder.tvContent.setText(message.getContent());

        return convertView;
    }

    class ViewHolder {
        private ImageView ivMessage;
        private TextView tvTitle;
        private TextView tvContent;

        ViewHolder(View view) {
            ivMessage = view.findViewById(R.id.iv_message);
            tvTitle = view.findViewById(R.id.tv_title);
            tvContent = view.findViewById(R.id.tv_content);
        }
    }
}
