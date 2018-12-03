package com.yyl.one.classloder;

import javax.swing.*;
import java.awt.*;

/**
 * @author yyl
 * @date 2018/11/25 下午4:53
 */
public class ClassLoaderTest2 {
    public static void main(String[] args) {
        //JFrame frame=new ClassLoaderFrame();
    }

    class ClassLoaderFrame extends JFrame{
        private JTextField keyField=new JTextField("3",4);
        private JTextField nameField=new JTextField("calculator",30);
        public static final int DEFAULT_WIDTH=300;
        public static final int DEFAULT_HEIGHT=200;
        public ClassLoaderFrame(){
            setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
            setLayout(new GridLayout());
            //add(new JLabel("class"),new GBC)
        }

    }
}
