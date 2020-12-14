package day6;

import util.ReaderUtil;

import java.util.ArrayList;
import java.util.List;

public class DaySix {

    public static void main(String[] args) {
        DaySix daySix = new DaySix();
        List<String> lines = ReaderUtil.read("days/src/main/resources/day6/input.txt");
        System.out.println("Part one:");
        System.out.println(daySix.partOne(lines));
        System.out.println("----------");
        System.out.println("Part two:");
        System.out.println(daySix.partTwo(lines));
    }

    public int partOne(List<String> lines) {
        List<Form> forms = new ArrayList<>();
        String form = "";
        for (String line : lines) {
            form = form.concat(line);
            if (line.isEmpty()) {
                forms.add(new Form(form));
                form = "";
            }
        }
        forms.add(new Form(form));
        return forms.stream().mapToInt(Form::getSum).sum();
    }

    public int partTwo(List<String> lines) {
        List<Form> forms = new ArrayList<>();
        int persons = 0;
        String form = "";
        for (String line : lines) {
            form = form.concat(line);
            if (line.isEmpty()) {
                forms.add(new Form(form, persons));
                form = "";
                persons = -1;
            }
            persons++;
        }
        forms.add(new Form(form, persons));
        return forms.stream().mapToInt(Form::getSum).sum();
    }

}
