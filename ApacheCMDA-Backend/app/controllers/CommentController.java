package controllers;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.persistence.PersistenceException;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;

import models.Comment;
import models.CommentRepository;
import play.mvc.Controller;
import play.mvc.Result;

@Named
@Singleton
public class CommentController extends Controller{
	private final CommentRepository commentRepository;

	@Inject
	public CommentController(final CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}
	
	public Result addComment() {
		JsonNode json = request().body().asJson();
		if (json == null) {
			System.out.println("Comment not created, expecting Json data");
			return badRequest("Comment not created, expecting Json data");
		}

		// Parse JSON file
		String text = json.path("text").asText();
		String postId = json.path("postId").asText();
		String commentUserId = json.path("commentUserId").asText();

		try {
			Comment comment = new Comment(text, Long.valueOf(postId), Long.valueOf(commentUserId));
			commentRepository.save(comment);
			System.out.println("Comment saved: " + comment.getId());
			return created(new Gson().toJson(comment.getId()));
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			System.out.println("Comment not saved: " + commentUserId + ", " + postId + ": " + text);
			return badRequest("Comment not saved: " + commentUserId + ", " + postId + ": " + text);
		}
	}
	
	public Result getAllCommentsByPostId(Long postId, String format) {
		if (postId == null) {
			System.out.println("Comment id is null or empty!");
			return badRequest("Comment id is null or empty!");
		}

		List<Comment> allComments = commentRepository.findByPostId(postId);

		if (allComments.size() == 0) {
			System.out.println("Comment not found with id: " + postId);
			return notFound("Comment not found with id: " + postId);
		}
		String result = new String();
		if (format.equals("json")) {
			result = new Gson().toJson(allComments);
		}

		return ok(result);
	}
}
