import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exam {
    private String title;
    private List<Question> questions = new ArrayList<>();

    public Exam(String title) {
        this.title = title;
    }

    public void addQuestion(Question q) {
        if (q != null) {
            questions.add(q);
        }
    }

    public List<Question> getQuestions() {
        return Collections.unmodifiableList(questions);
    }

    public String getTitle() {
        return title;
    }
}

