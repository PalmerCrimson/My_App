package algonquin1.cst2335.torunes;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Ignore;

import java.util.ArrayList;


public class ChatMessage {

    String message;
    String timeSent;
    boolean isSentButton;
    public ChatMessage(){}
    ChatMessage(String m, String t, boolean sent) {
        message = m;
        timeSent = t;
        isSentButton = sent;
    }

    public String getMessage() {
        return message;
    }
    public String getTimeSent() {
        return timeSent;
    }
    public boolean isSentButton() {
        return isSentButton;
    }
}
