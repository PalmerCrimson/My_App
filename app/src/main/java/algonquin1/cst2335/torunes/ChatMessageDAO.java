package algonquin1.cst2335.torunes;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ChatMessageDAO {
    @Insert
    void insertMessage(ChatMessage m);
    @Query("Select* FROM ChatMessage")
    List<ChatMessage> getAllMessages();
    @Delete
    void deleteMessage(ChatMessage m );
}
