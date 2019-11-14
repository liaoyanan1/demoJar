package demo;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Variant;

public class openD {
    //zkemkeeper.ZKEM.1 为zkemkeeper.dll 注册成功后 在注册表可以查看：HKEY_CLASSES_ROOT最下面
    private static ActiveXComponent zkem = new ActiveXComponent("zkemkeeper.ZKEM.1");
    /**
     * 连接考勤机
     *
     * @param address 考勤机地址
     * @param port    端口号
     * @return
     */
    public static boolean connect(String address, int port) {
        boolean result = zkem.invoke("Connect_NET", address, port).getBoolean();
        return result;
    }

    /**
     * 开门
     */
    public static boolean ACUnlock(Long mno){
        Variant  m = new Variant(mno,true);
        Variant  time = new Variant(10,true);
        return zkem.invoke("ACUnlock", m, time).getBoolean();
    }

}
