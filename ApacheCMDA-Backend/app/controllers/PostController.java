package controllers;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.persistence.PersistenceException;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;

import models.Post;
import models.PostRepository;
import play.mvc.Controller;
import play.mvc.Result;

@Named
@Singleton
public class PostController extends Controller{
	private final PostRepository postRepository;

	@Inject
	public PostController(final PostRepository postRepository) {
		this.postRepository = postRepository;
	}
	
	public Result addPost() {
		JsonNode json = request().body().asJson();
		if (json == null) {
			System.out.println("Post not created, expecting Json data");
			return badRequest("Post not created, expecting Json data");
		}

		// Parse JSON file
		String visibility = json.path("visibility").asText();
		String text = json.path("text").asText();
		String likes = json.path("likes").asText();
		String location = json.path("location").asText();
		String postUserId = json.path("postUserId").asText();

		
		try {
			Post post = new Post(visibility, text, Integer.valueOf(likes), location, Long.valueOf(postUserId));
			postRepository.save(post);
			System.out.println("Post saved: " + post.getId());
			return created(new Gson().toJson(post.getId()));
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			System.out.println("Post not saved: " + postUserId + ": " + text);
			return badRequest("Post not saved: " + postUserId + ": " + text);
		}
	}
	
	public Result deletePost(Long id) {
		Post deletePost = postRepository.findOne(id);
		if (deletePost == null) {
			System.out.println("Post not found with id: " + id);
			return notFound("Post not found with id: " + id);
		}

		postRepository.delete(deletePost);
		System.out.println("Post is deleted: " + id);
		return ok("Post is deleted: " + id);
	}
}
