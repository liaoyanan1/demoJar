package demo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
public class TesSwing extends JButton implements ActionListener{
    private JLabel jLabel;
    private JButtonChangeType jButtonChangeType;
    public  TesSwing(String text, JLabel jLabel,JButtonChangeType jButtonChangeType){
        this.setText(text);//设置按钮文字
        this.addActionListener(this);
        this.jLabel = jLabel;
        this.jButtonChangeType = jButtonChangeType;
    }
    public void actionPerformed(ActionEvent e) {
        //文件选择器获取文件或者文件夹
        //========================================
        JFileChooser jfc=new JFileChooser();
        //设置当前路径为桌面路径,否则将我的文档作为默认路径
        FileSystemView fsv = FileSystemView .getFileSystemView();
        jfc.setCurrentDirectory(fsv.getHomeDirectory());
        //JFileChooser.FILES_AND_DIRECTORIES 选择路径和文件

        if (jButtonChangeType!=null  && "压缩一张".equals(jButtonChangeType.getText())){
            jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        }else {
            jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        }
        //用户选择的路径或文件
        if (jfc.showOpenDialog(new JFrame())==JFileChooser.APPROVE_OPTION){
            File file=jfc.getSelectedFile();
            if(file.isDirectory()){
             //   System.out.println("文件夹:"+file.getAbsolutePath());
                jLabel.setText(file.getAbsolutePath());
            }else if(file.isFile()){
            //    System.out.println("文件:"+file.getAbsolutePath());
                jLabel.setText(file.getAbsolutePath());
            }
        }
        //=======================================================
        //文件选择器获取文件,这里只能获取文件，不能获取文件夹
       /* JFileChooser jfc=new JFileChooser("C:\\");//可以直接在这设置默认路径
        if(jfc.showOpenDialog(bbbbbbbbbb.this)==JFileChooser.APPROVE_OPTION){
        File file=jfc.getSelectedFile();
              System.out.println("文件:"+file.getAbsolutePath());
        }*/
        //====================================================
    }
}
