package demo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JButtonChangeType extends JButton implements ActionListener {
    private boolean flag = false;

    public JButtonChangeType(){
        setText("压缩一张");
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if(flag){
            setText("压缩一张");
            flag = false;
        }else {
            setText("批量压缩");
            flag= true;
        }
    }
}
