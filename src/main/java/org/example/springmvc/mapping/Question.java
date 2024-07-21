package org.example.springmvc.mapping;

import jakarta.persistence.*;

@Entity
@Table(name="QUESTION")
public class Question {

    @Id
    @Column(name="QUESTION_ID")
    private int questionId;

    @Column(name="QUESTION")
    private String question;

    @OneToOne
    @JoinColumn(name="ANSWER_ID")
    private Answer answer;

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
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
