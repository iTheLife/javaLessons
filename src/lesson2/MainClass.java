package lesson2;


public class MainClass {
    public static void main(String[] args) {

        int sum = 0;
        String[][] mas = {
                {"-9","1","0","1"},
                {"4","1","1","1"},
                {"-2","2","-1","1"},
                {"-1","1","1","a"}
        };

        ArrayClass arrayClass = new ArrayClass();
        try {
            sum = arrayClass.doHomeWork(mas);
        }
        catch(MyArrayClassException e){
            System.out.println("Получен массив недопустимого размера");
        }
        catch(MyArrayDataException e){
            System.out.println(String.format("Произошел сбой в ячейке %d %d",e.getX(),e.getY()));
        }
        System.out.println("Сумма массива: " + sum);
    }
//    public static void main(String[] args) {
//        FileOutputStream out = null;
//        try {
//            out = new FileOutputStream("1.txt");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                out.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        // try-with-resources
//        try(FileOutputStream out2 = new FileOutputStream("2.txt")){
//
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//
//        try{
//
//        }catch (ArithmeticException | NullPointerException | NumberFormatException e){
//
//        }
//
//
//
////        JFrame jf = new JFrame();
////        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
////        jf.setTitle("Report Maker");
////        jf.setBounds(1200,400,400,400);
////        JButton jButton = new JButton("Save Report");
////        jButton.addActionListener(e -> {
////            try {
////                ReportMaker.makeReport("Report1", "Z:/1.pdf");
////            } catch (IOException e1) {
////                JOptionPane.showMessageDialog(null, "Ошибка при сохранение отчета");
////            }
////        });
////        jf.add(jButton, BorderLayout.SOUTH);
////        jf.setVisible(true);
//    }

//    public static void main(String[] args) {
//        try {
//            a();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void a() throws IOException {
//        FileOutputStream out = new FileOutputStream("1.txt");
//        out.close();
//    }

//    static class Person {
//        int age;
//
//        public Person(int age) {
//            this.age = age;
//            if (age < 14) throw new RuntimeException("Невозможно создать сотрудника с возрастом меньше 14");
//
//        }
//    }
//
//    public static void main(String[] args) {
//        Person p = new Person(5);
//        System.out.println(p.age);
//
//    }

    // public static void main(String[] args) {

    //System.out.println(sqrt(-10));
//        try {
//            int[] q = new int[5];
//            int x = 10 / 0;
//            q[20] = 20;
//        }
//        catch(ArrayIndexOutOfBoundsException e){
//            System.out.println("AIOOBE");
//        }
//        catch(RuntimeException e){
//            System.out.println("RE");
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("END");


//        try {
//            FileInputStream in = new FileInputStream("1.txt");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

    // }
//    public static int sqrt (int n){
//        if(n>=0){
//            return n / 2;
//        }
//        throw new ArithmeticException("Невозможно взять квадратный корень из отрицательного числа!");
//    }
}
