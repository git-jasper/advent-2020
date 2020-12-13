package day4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.regex.Pattern;

import static day4.Passport.Details.byr;
import static day4.Passport.Details.ecl;
import static day4.Passport.Details.eyr;
import static day4.Passport.Details.hcl;
import static day4.Passport.Details.hgt;
import static day4.Passport.Details.iyr;
import static day4.Passport.Details.pid;

public class Passport {

    private static Map<String, Predicate<String>> detailsMap = new HashMap<>();
    static {
        detailsMap.put(byr.name(), s -> {
            int i = Integer.parseInt(s);
            return 1920 <= i && i <= 2002;
        });
        detailsMap.put(iyr.name(), s -> {
            int i = Integer.parseInt(s);
            return 2010 <= i && i <= 2020;
        });
        detailsMap.put(eyr.name(), s -> {
            int i = Integer.parseInt(s);
            return 2020 <= i && i <= 2030;
        });
        detailsMap.put(hgt.name(), s -> {
            int length = s.length();
            if (s.endsWith("cm")) {
                int value = Integer.parseInt(s.substring(0, length - 2));
                return 150 <= value && value <= 193;
            } else if (s.endsWith("in")) {
                int value = Integer.parseInt(s.substring(0, length - 2));
                return 59 <= value && value <= 76;
            } else {
                return false;
            }
        });
        detailsMap.put(hcl.name(), s -> {
            Pattern pattern = Pattern.compile("#[a-f0-9]{6}");
            return pattern.matcher(s).matches();
        });
        detailsMap.put(ecl.name(), s -> s.equals("amb") || s.equals("blu") || s.equals("brn") ||
                    s.equals("gry") || s.equals("grn") || s.equals("hzl") || s.equals("oth"));
        detailsMap.put(pid.name(), s -> {
            Pattern pattern = Pattern.compile("\\d{9}");
            return pattern.matcher(s).matches();
        });
    }

    private String info;

    public Passport(String info) {
        this.info = info;
    }

    public boolean isValidPartOne() {
        return info.contains("byr:") &&
                info.contains("iyr:") &&
                info.contains("eyr:") &&
                info.contains("hgt:") &&
                info.contains("hcl:") &&
                info.contains("ecl:") &&
                info.contains("pid:");
    }

    public boolean isValidPartTwo() {
        Set<Details> detailsSet = new HashSet<>();
        String[] details = this.info.split(":| ");
        for (int i=0; i<details.length; i+=2) {
            String detail = details[i];
            Predicate<String> predicate = detailsMap.get(detail);
            if (predicate == null) {
                continue;
            }
            if (predicate.test(details[i+1])) {
                detailsSet.add(Details.valueOf(detail));
            }
        }
        return detailsSet.size() == 7;
    }


    public enum Details {
        byr,
        iyr,
        eyr,
        hgt,
        hcl,
        ecl,
        pid
    }
}
