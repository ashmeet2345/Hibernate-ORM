package org.example.springmvc.onetomany;

import jakarta.persistence.*;

@Entity
@Table(name="ANSWER")
public class Answer {

    @Id
    @Column(name="ANSWER_ID")
    private int answerId;

    private String answer;

    @ManyToOne
    private Question question;

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Answer(int answerId, String answer) {
        this.answerId = answerId;
        this.answer = answer;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Answer(){
        super();
    }
}
