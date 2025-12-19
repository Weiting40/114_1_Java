import java.util.Set;

public class ChoiceAnswer extends Answer {
    private Set<String> selectedOptions;

    public ChoiceAnswer(Set<String> selectedOptions) {
        this.selectedOptions = selectedOptions;
    }

    public Set<String> getSelectedOptions() {
        return selectedOptions;
    }
}

