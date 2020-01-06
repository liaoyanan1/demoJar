package demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class JButtonStart extends JButton implements ActionListener {
    private JLabel jLabel;//修改进度
    private JLabel jLabelIn;//源
    private JLabel jLabelOut;//目的
    private  JTextField jTextFieldWith;
    private  JTextField jTextFieldCR;
    private JTextField jTextFieldheight;
    private  volatile  boolean f = true;
    public  JButtonStart(JLabel jLabel, JLabel jLabelIn, JLabel jLabelOut,JTextField jTextFieldWith,JTextField jTextFieldheight,JTextField jTextFieldCR){
        this.setText("开始压缩");//设置按钮文字
        this.addActionListener(this);
        this.jLabel = jLabel;
        this.jLabelIn = jLabelIn;
        this.jLabelOut = jLabelOut;
        this.jTextFieldWith = jTextFieldWith;
        this.jTextFieldCR = jTextFieldCR;
        this.jTextFieldheight = jTextFieldheight;
    }
    public void change(final int i){
        new Thread(new Runnable() {
            public void run() {
                    jLabel.setText("当前进度:   " + i + "%");
                }
            }).start();

    }

    public void a(){
        final JButton j = this;
        new Thread(new Runnable() {
            public void run() {
                if(jTextFieldWith==null || jTextFieldheight ==null || jTextFieldCR ==null){
                    jLabel.setText("请输入宽高缩放比例");
                    return;
                }

                try{
                    Integer.valueOf(jTextFieldWith.getText());
                    Integer.valueOf(jTextFieldheight.getText());
                    Float.valueOf(jTextFieldCR.getText());
                }catch (Exception e){
                    jLabel.setText("宽高为整数缩放比例小数");
                }
                if( Float.valueOf(jTextFieldCR.getText())<0 ||  Float.valueOf(jTextFieldCR.getText())>1){
                    jLabel.setText("缩放比例为0-1的小数");
                }
              try{

                  String dirIn = jLabelIn.getText();//源路径
                  String dirout = jLabelOut.getText();//目的路径
                  File filein = new File(dirIn);
                  File fileout = new File(dirout);
                  if(filein.isDirectory() && fileout.isDirectory()){
                      j.setText("压缩中");
                      j.setEnabled(false);
                      File[] files = filein.listFiles();
                      double i = 0;
                      for (File file : files) {
                          if(file.getName().endsWith("jpg") || file.getName().endsWith("png") ||file.getName().endsWith("bmp") || file.getName().endsWith("gif")){
                              jLabel.setText("当前进度:   " + (int)(i/files.length*100) + "%");
                              try {
                                  imagesFiler.imageResize(file,new File(fileout+"\\"+file.getName()),Integer.valueOf(jTextFieldWith.getText()),Integer.valueOf(jTextFieldheight.getText()),Float.valueOf(jTextFieldCR.getText()));
                              } catch (IOException ex) {
                                  ex.printStackTrace();
                              }

                              i++;
                          }
                      }
                      j.setText("开始压缩");
                      j.setEnabled(true);
                      jLabel.setText("压缩成功！");
                  }else {
                      j.setText("压缩中");
                      j.setEnabled(false);
                      try {
                          imagesFiler.imageResize(filein,new File(fileout+"\\"+filein.getName()),Integer.valueOf(jTextFieldWith.getText()),Integer.valueOf(jTextFieldheight.getText()),Float.valueOf(jTextFieldCR.getText()));
                      } catch (IOException e) {
                          j.setText("开始压缩");
                          j.setEnabled(true);
                          jLabel.setText("压缩失败！");
                      }
                      j.setText("开始压缩");
                      j.setEnabled(true);
                      jLabel.setText("压缩成功！");
                  }

              }catch (Exception e){
                  j.setText("开始压缩");
                  j.setEnabled(true);
                  jLabel.setText("压缩失败！");
              }
            }

        }).start();
    }
    public void actionPerformed(ActionEvent e) {
        a();
    }
}
