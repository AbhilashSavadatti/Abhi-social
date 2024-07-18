import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.abhi.models.Chat;
import com.abhi.models.User;
import com.abhi.repository.ChatRepository;
import com.abhi.service.ChatService;

public class ChatServiceImplementation implements ChatService{

	@Autowired
	private ChatRepository chatRepository;
		
	@Override
	public Chat createChat(User reqUser, User user2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Chat findChatById(Integer chatId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Chat> findUsersChat(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
