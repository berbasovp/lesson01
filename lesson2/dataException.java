package lesson2;

public class dataException extends MassivException {
    public dataException (int row, int col) {
        super(String.format("Заполнено не верно, на [%d, %d] не число", row, col));
    }
}
