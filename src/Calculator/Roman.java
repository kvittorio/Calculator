package Calculator;

public class Roman extends Number {
    private String romNum1;
    private String romNum2;
    private int romDigit1;
    private int romDigit2;
    private int outcomeDigit;
    private String minus = "";
    private String outcomeRom;
    private final String[] romNumerals = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    Roman(String value1, String value2) {
        this.romNum1 = value1;
        this.romNum2 = value2;
        this.romDigit1 = romToInt(romNum1);
        this.romDigit2 = romToInt(romNum2);
    }
    private String integerToRoman(int num, int module) {
        module = num % 10;
        if (module != 0) {
            try {
                return integerToRoman(num - module, 0) + romNumerals[module - 1];
            } catch (ArrayIndexOutOfBoundsException e) {
                minus = "-";
                return integerToRoman(num - module, 0) + romNumerals[(module + 1) * -1];
            }
        }
        if (num > 0) {
            num -= 10;
            return integerToRoman(num,0) + "X";
        } else if (num < 0) {
            num += 10;
            return integerToRoman(num,0) + "X";
        }   else {
            return minus;
        }
    }

    @Override
    public void add() {
        outcomeDigit = romDigit1 + romDigit2;
        outcomeRom = integerToRoman(outcomeDigit, outcomeDigit);
    }

    @Override
    public void sub() {
        outcomeDigit = romDigit1 - romDigit2;
        outcomeRom = integerToRoman(outcomeDigit, outcomeDigit);
    }

    @Override
    public void div() {
        try {
            outcomeDigit = romDigit1 / romDigit2;
            outcomeRom = integerToRoman(outcomeDigit, outcomeDigit);
        } catch (ArithmeticException e) {
            System.out.print("ArithmeticException. Нельзя вводить арабские и римские цифры одновременно!");
            return;
        }

    }

    @Override
    public void mul() {
        outcomeDigit = romDigit1 * romDigit2;
        outcomeRom = integerToRoman(outcomeDigit, outcomeDigit);
    }

    @Override
    public int getAnswer() {
        return outcomeDigit;
    }
    public String getRomanAnswer() {
        return outcomeRom;
    }

    private int romToInt(String romValue){
        char[] charValues = romValue.toCharArray();
        int[] digitValues = new int[charValues.length];
        for (int i = 0; i < charValues.length; i++) {
            switch (charValues[i]) {
                case 'I':
                    digitValues[i] = 1;
                    break;
                case 'V':
                    digitValues[i] = 5;
                    break;
                case 'X':
                    digitValues[i] = 10;
                    break;

                default:
                    System.out.println("NumberFormatException");
                    System.exit(0);
                    break;
            }
        }
        int digit = digitValues[0];
        for (int i = 0; i < digitValues.length && digitValues.length > i + 1; i++) {
            if (digitValues[i] >= digitValues[i+1]) {
                digit += digitValues[i+1];
            } else if (digitValues[i] < digitValues[i+1]) {
                digit = digit + digitValues[i+1] - 2;
            }
        }
        return digit;
    }

    public String getRomNum1() {
        return romNum1;
    }

    public String getRomNum2() {
        return romNum2;
    }

    public void setRomNum1(String romNum1) {
        this.romNum1 = romNum1;
    }

    public void setRomNum2(String romNum2) {
        this.romNum2 = romNum2;
    }

    public int getRomDigit1() {
        return romDigit1;
    }

    public int getRomDigit2() {
        return romDigit2;
    }

    public void setRomDigit1(int romDigit1) {
        this.romDigit1 = romDigit1;
    }

    public void setRomDigit2(int romDigit2) {
        this.romDigit2 = romDigit2;
    }
}
