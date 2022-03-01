package com.github.jonahbaayen.lab05.records;

public class StudentRecord {
    private String studentId = "-";
    private float midterm = 0f;
    private float assignments = 0f;
    private float finalExam = 0f;
    private String letterGrade = "-";

    public StudentRecord(String studentId, float assignments, float midterm, float finalExam) {
        this.studentId = studentId;
        this.assignments = assignments;
        this.midterm = midterm;
        this.finalExam = finalExam;
    }

    public float getFinalMark() {
        return ((30f * midterm)
                + ( 20f * assignments)
                + (50f * finalExam)) /
                (100f);
    }

    public String getLetterGrade() {
        float finalGrade = this.getFinalMark();

        if (finalGrade > 100) {
            return "Error: grade too high!";
        } else if (finalGrade >= 80) {
            return "A";
        } else if (finalGrade >= 70) {
            return "B";
        } else if (finalGrade >= 60) {
            return "C";
        } else if (finalGrade >= 50) {
            return "D";
        } else if (finalGrade >= 0) {
            return "F";
        } else {
            return "Error: negative grade!";
        }
    }

    public String getStudentId() {
        return this.studentId;
    }

    public float getAssignments() {
        return this.assignments;
    }

    public float getMidterm() {
        return this.midterm;
    }

    public float getFinalExam() {
        return this.finalExam;
    }
}
