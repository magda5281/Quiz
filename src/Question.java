//this class creates object with properties of question and answer;
// it is a template for question object
// public means it is available in the application???

public class Question {
    String prompt;
    String answer;
    public Question(String prompt, String answer){
        this.prompt=prompt;
        this.answer=answer;
    }
}
