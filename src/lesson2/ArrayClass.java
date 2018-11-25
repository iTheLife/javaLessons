package lesson2;

public class ArrayClass {
    private String[][] mass;
    private int sum;

    public int doHomeWork(String[][] massiv) {

        if (!checkSizeArray(massiv)) {
            throw new MyArrayClassException();
        }

        this.mass = massiv;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    sum += Integer.parseInt(mass[i][j]);
                } catch (Exception e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sum;
    }


    private boolean checkSizeArray(String[][] massiv) {
        int length = 4;
        if (massiv.length != length) {
            return false;
        } else {
            for (int i = 0; i < length; i++) {
                if (massiv[i].length != length) {
                    return false;
                }
            }
            return true;
        }
    }

}
