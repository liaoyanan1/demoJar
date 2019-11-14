package demo;

public class Main {

    public static void main(String[] args) {
        boolean connect = openD.connect(args[0], 4370);
        boolean b = openD.ACUnlock(Long.valueOf(args[1]));
        if(b){
            System.out.println("开门成功");
        }else {
            System.out.println("开门失败");
        }
    }
}
