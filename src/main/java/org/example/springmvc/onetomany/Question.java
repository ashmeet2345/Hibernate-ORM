package org.example.springmvc.onetomany;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="QUESTION")
public class Question {

    @Id
    @Column(name="QUESTION_ID")
    private int questionId;

    @Column(name="QUESTION")
    private String question;

    @OneToMany(mappedBy = "question")
    private List<Answer> answer;

    public List<Answer> getAnswer() {
        return answer;
    }

    public void setAnswer(List<Answer> answer) {
        this.answer = answer;
    }

    public Question(int questionId, String question) {
        this.questionId = questionId;
        this.question = question;
    }

    public Question() {
        super();
    }

    public int getId() {
        return questionId;
    }

    public void setId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
