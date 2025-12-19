import java.util.HashMap;
import java.util.Map;

public class ExamSession {
    private Exam exam;
    private Student student;
    private Map<Question, Answer> answers = new HashMap<>();

    public ExamSession(Exam exam, Student student) {
        this.exam = exam;
        this.student = student;
    }

    public void submitAnswer(Question q, Answer a) {
        if (q != null) {
            answers.put(q, a);
        }
    }

    public double calculateScore() {
        double total = 0;
        for (Question q : exam.getQuestions()) {
            Answer a = answers.get(q);
            try {
                total += q.grade(a);
            } catch (Exception e) {
                // if any grading throws, treat as 0 for robustness
            }
        }
        return total;
    }

    public Student getStudent() {
        return student;
    }
}

