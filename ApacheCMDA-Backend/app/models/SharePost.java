package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SharePost {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private long postId;
	private long userId;
	
	public SharePost() {
	}

	public SharePost(long postId, long userId) {
		super();
		this.postId = postId;
		this.userId = userId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPostId() {
		return postId;
	}

	public void setPostId(long postId) {
		this.postId = postId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "SharePost [id=" + id + ", postId=" + postId + ", userId="
				+ userId + "]";
	}
}
