package day5;

public class BoardingPass {

    private final int row;
    private final int column;
    private final int id;

    private BoardingPass(int row, int column) {
        this.row = row;
        this.column = column;
        this.id = row * 8 + column;
    }

    public static BoardingPass of(String code) {
        char[] codes = code.toCharArray();
        return new BoardingPass(parseRow(codes),  parseColumn(codes));
    }

    private static int parseRow(char[] codes) {
        StringBuilder rowBinairy = new StringBuilder();
        for (int r=0; r<7; r++) {
            if ('F' == codes[r]) {
                rowBinairy.append("0");
            } else {
                rowBinairy.append("1");
            }
        }
        return Integer.parseInt(rowBinairy.toString(), 2);
    }

    private static int parseColumn(char[] codes) {
        StringBuilder columnBinary = new StringBuilder();
        for (int c=7; c<10; c++) {
            if ('L' == codes[c]) {
                columnBinary.append("0");
            } else {
                columnBinary.append("1");
            }
        }
        return Integer.parseInt(columnBinary.toString(), 2);
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "BoardingPass{" +
                "row=" + row +
                ", column=" + column +
                ", id=" + id +
                '}';
    }
}
