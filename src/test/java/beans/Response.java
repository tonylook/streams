package beans;

public class Response {
    private final String userId;
    private final Integer answeredIndex;
    private final String questionId;

    public Response(String userId, Integer answeredIndex, String questionId) {
        this.userId = userId;
        this.answeredIndex = answeredIndex;
        this.questionId = questionId;
    }

    public String getUserId() {
        return userId;
    }

    public Integer getAnsweredIndex() {
        return answeredIndex;
    }

    public String getQuestionId() {
        return questionId;
    }

    @Override
    public String toString() {
        return "Response{" +
                "userId='" + userId + '\'' +
                ", answeredIndex=" + answeredIndex +
                ", questionId='" + questionId + '\'' +
                '}';
    }
}
