package models;

import java.util.List;

import javax.inject.Named;
import javax.inject.Singleton;

import org.springframework.data.repository.CrudRepository;

@Named
@Singleton
public interface SharePostRepository extends CrudRepository<SharePost, Long> {
	List<SharePost> findByUserId(long userId);

}
