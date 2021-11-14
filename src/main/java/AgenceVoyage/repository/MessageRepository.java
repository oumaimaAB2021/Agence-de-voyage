package AgenceVoyage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import AgenceVoyage.Model.Message;


@Repository
public interface MessageRepository extends JpaRepository <Message, Long> {
	@Query("Select m from Message m")
	List<Message> findMessages();

}
