package Calculator;

public class Arabic extends Number{
    private int num1;
    private int num2;
    private int answer;

    Arabic(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public void add() {
        this.answer = num1 + num2;
    }

    public void sub() {
        this.answer = num1 - num2;
    }

    public void div() {
        try{
            this.answer = num1 / num2;
        } catch (ArithmeticException e) {
            System.out.print("Деление на 0! ");
        }

    }

    public void mul() {
        this.answer = num1 * num2;
    }

    @Override
    public int getAnswer() {
        return answer;
    }

    @Override
    public String getRomanAnswer() {
        return "" + answer;
    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }
}
