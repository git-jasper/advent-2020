package day6;

public class Form {

    private char[] answers = new char[26];
    private int sum;

    public Form(String form) {
        this(form, 1);
    }

    public Form(String form, int persons) {
        for (char c : form.toCharArray()) {
            int index = c - 97;
            if (answers[index] == persons - 1) {
                sum++;
            }
            answers[index]++;
        }
    }

    public int getSum() {
        return sum;
    }
}
