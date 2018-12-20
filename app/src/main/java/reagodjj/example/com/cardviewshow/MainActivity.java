package reagodjj.example.com.cardviewshow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lvMessage;
    private List<Message> messageList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMessage = findViewById(R.id.lv_message);

        messageList.addAll(MessageLab.generateMessageList());

        lvMessage.setAdapter(new MessageAdapter(this, messageList));
    }
}
