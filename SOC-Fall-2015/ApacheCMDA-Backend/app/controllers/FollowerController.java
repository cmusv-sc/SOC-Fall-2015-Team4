package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.persistence.PersistenceException;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;

import models.Follower;
import models.FollowerRepository;
import models.User;
import models.UserRepository;
import play.mvc.Controller;
import play.mvc.Result;

@Named
@Singleton
public class FollowerController extends Controller{
	private final FollowerRepository followerRepository;
	private final UserRepository userRepository;

	@Inject
	public FollowerController(final FollowerRepository followerRepository, 
			final UserRepository userRepository) {
		this.followerRepository = followerRepository;
		this.userRepository = userRepository;
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
		
		List<User> allUsers = new ArrayList<User>();
		for (int i = 0; i < allFollowers.size(); i++) {
			long followerId = allFollowers.get(i).getFollowerId();
			User follower = userRepository.findOne(followerId);
			allUsers.add(follower);
		}
		
		String result = new String();
		if (format.equals("json")) {
			result = new Gson().toJson(allUsers);
		}
		return ok(result);
	}
	
	public List<Follower> getAllFolloweesByFollowerId(Long followerId) {
		if (followerId == null) {
			System.out.println("Follower id is null or empty!");
			return null;
		}

		List<Follower> allFollowees = followerRepository.findByFollowerId(followerId);

		if (allFollowees.size() == 0) {
			System.out.println("Followee not found with follower id: " + followerId);
			return null;
		}
		return allFollowees;
	}
	
	public Result deleteFollower(Long userId, Long followerId) {
		List<Follower> followers = followerRepository.findByUserId(userId);
		if (followers.size() == 0) {
			System.out.println("User not found with id: " + userId);
			return notFound("User not found with id: " + userId);
		}
		
		for (Follower follower : followers) {
			if (follower.getFollowerId() == followerId) {
				System.out.println("Followee is deleted: "+follower.getFollowerId());
				followerRepository.delete(follower);
				return ok("Followee is deleted");
			}
		}
		
		System.out.println("Followee is not found");
		return badRequest("Followee is not found");
	}
}