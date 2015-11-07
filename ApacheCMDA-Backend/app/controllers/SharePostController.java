package controllers;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.persistence.PersistenceException;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;

import models.SharePost;
import models.SharePostRepository;
import play.mvc.Controller;
import play.mvc.Result;

@Named
@Singleton
public class SharePostController extends Controller{
	private final SharePostRepository sharePostRepository;

	@Inject
	public SharePostController(final SharePostRepository sharePostRepository) {
		this.sharePostRepository = sharePostRepository;
	}
	
	public Result addSharePost() {
		JsonNode json = request().body().asJson();
		if (json == null) {
			System.out.println("SharePost not created, expecting Json data");
			return badRequest("SharePost not created, expecting Json data");
		}

		// Parse JSON file
		String postId = json.path("postId").asText();
		String userId = json.path("userId").asText();

		try {
			SharePost sharePost= new SharePost(Long.valueOf(postId), Long.valueOf(userId));
			sharePostRepository.save(sharePost);
			System.out.println("SharePost saved: " + sharePost.getId());
			return created(new Gson().toJson(sharePost.getId()));
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			System.out.println("SharePost not saved: " + userId + ", " + postId);
			return badRequest("SharePost not saved: " + userId + ", " + postId);
		}
	}
}
