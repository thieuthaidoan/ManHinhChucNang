package com.example.model;

public class Question {
    public Question(int _id, String question, String ans_a, String ans_b, String ans_c, String ans_d, String result, String num, String image) {
        this._id = _id;
        this.question = question;
        this.ans_a = ans_a;
        this.ans_b = ans_b;
        this.ans_c = ans_c;
        this.ans_d = ans_d;
        this.result = result;
        this.num = num;
        this.image = image;
    }

    private int _id;
    private String question;
    private String ans_a;
    private String ans_b;
    private String ans_c;
    private String ans_d;
    private String result;
    private String num;
    private String image;

    public Question() {

    }
}
