package demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFRame extends JFrame implements ActionListener {


    public JFRame(){
        setTitle("图片压缩");

        Container c = this.getContentPane();
        c.setLayout(null);
        JButtonChangeType jButtonChangeType =  new JButtonChangeType();
        jButtonChangeType.setBounds(111,33,88,20);
        c.add(jButtonChangeType);
        JLabel jLabelin = new JLabel("请选择图片目录");
        jLabelin.setBounds(10,66,188,20);
        c.add(jLabelin);
        JButton jButton1 = new TesSwing("选择目录",jLabelin,jButtonChangeType);
        jButton1.setBounds(200,66,100,20);
        c.add(jButton1);
        JLabel jLabelout = new JLabel("请选择图片存入目录");
        jLabelout.setBounds(10,88,188,20);
        c.add(jLabelout);
        JButton jButton2 = new TesSwing("选择目录",jLabelout,null);
        jButton2.setBounds(200,88,100,20);
        c.add(jButton2);
        JLabel jLabelCount = new JLabel("1");

        jLabelCount.setBounds(111,233,100,20);
        c.add(jLabelCount);//进度条
        JLabel jwith = new JLabel("图片宽度");
        jwith.setBounds(30,111,55,20);
        c.add(jwith);
        JTextField jTextFieldWith = new JTextField("1024");
        jTextFieldWith.setBounds(30,133,55,20);
        c.add(jTextFieldWith);
        JLabel jheight = new JLabel("图片高度");
        jheight.setBounds(133,111,55,20);
        c.add(jheight);
        JTextField jTextFieldheight = new JTextField("768");
        jTextFieldheight.setBounds(133,133,55,20);
        c.add(jTextFieldheight);
        JLabel jCR = new JLabel("压缩比例");
        jCR.setBounds(236,111,55,20);
        c.add(jCR);
        JTextField jTextFieldCR = new JTextField("0.7");
        jTextFieldCR.setBounds(236,133,55,20);
        c.add(jTextFieldCR);
        JButtonStart jButtonStart = new JButtonStart(jLabelCount,jLabelin,jLabelout,jTextFieldWith,jTextFieldheight,jTextFieldCR);
        jButtonStart.setBounds(111,188,100,20);
        c.add(jButtonStart);//开始压缩
        setBounds(333,333,333,333);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
    }
}
