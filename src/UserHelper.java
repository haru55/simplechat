package project.simplechat;


public class UserHelper {

	public static String toJson(User user) {
		StringBuilder builder = new StringBuilder();
		toJson(user, builder);
		return builder.toString();
	}
	
	public static void toJson(User user, StringBuilder builder) {
		builder.append("{");
		builder.append("\"name\":\"").append(user.getName()).append("\"");
		builder.append("}");
	}
	
}
