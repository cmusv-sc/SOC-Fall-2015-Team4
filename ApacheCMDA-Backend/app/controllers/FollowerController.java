package controllers;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.persistence.PersistenceException;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;

import models.Follower;
import models.FollowerRepository;
import play.mvc.Controller;
import play.mvc.Result;

@Named
@Singleton
public class FollowerController extends Controller{
	private final FollowerRepository followerRepository;

	@Inject
	public FollowerController(final FollowerRepository followerRepository) {
		this.followerRepository = followerRepository;
	}
	
	public Result addFollower() {
		JsonNode json = request().body().asJson();
		if (json == null) {
			System.out.println("Follower not created, expecting Json data");
			return badRequest("Follower not created, expecting Json data");
		}

		// Parse JSON file
		String userId = json.path("userId").asText();
		String followerId = json.path("followerId").asText();

		try {
			Follower follower = new Follower(Long.valueOf(userId), Long.valueOf(followerId));
			followerRepository.save(follower);
			System.out.println("Follower saved: " + follower.getId());
			return created(new Gson().toJson(follower.getId()));
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			System.out.println("Follower not saved: " + userId + ", follower: " + followerId);
			return badRequest("Follower not saved: " + userId + ", follower: " + followerId);
		}
	}
	
	public Result getAllFollowersByUserId(Long userId, String format) {
		if (userId == null) {
			System.out.println("User id is null or empty!");
			return badRequest("User id is null or empty!");
		}

		List<Follower> allFollowers = followerRepository.findByUserId(userId);

		if (allFollowers.size() == 0) {
			System.out.println("Follower not found with user id: " + userId);
			return notFound("Follower not found with user id: " + userId);
		}
		String result = new String();
		if (format.equals("json")) {
			result = new Gson().toJson(allFollowers);
		}
		return ok(result);
	}
}
