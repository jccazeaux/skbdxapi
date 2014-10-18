package models;

import java.util.List;

import net.vz.mongodb.jackson.Id;
import net.vz.mongodb.jackson.JacksonDBCollection;
import net.vz.mongodb.jackson.ObjectId;
import play.modules.mongodb.jackson.MongoDB;

public class Technique {

	
	
	@Id
	@ObjectId
	public String id;

	public String nom;
	public String famille;
	public String grade;
	public String description;
	public String garde;
	public String gardeAttaquant;
	public String gardeDefenseur;
	public String sousFamille;

	private static JacksonDBCollection<Technique, String> coll = MongoDB
			.getCollection("tasks", Technique.class, String.class);

	public Technique() {

	}

	public Technique(String famille, String grade, String description,
			String sousFamille) {
		super();
		this.famille = famille;
		this.grade = grade;
		this.description = description;
		this.sousFamille = sousFamille;
	}

	public static List<Technique> all() {
		return Technique.coll.find().toArray();
	}

	public static void create(Technique techniques) {
		Technique.coll.save(techniques);
	}

	public static void delete(String id) {
		Technique task = Technique.coll.findOneById(id);
		if (task != null)
			Technique.coll.remove(task);
	}

	public static void removeAll() {
		Technique.coll.drop();
	}

}