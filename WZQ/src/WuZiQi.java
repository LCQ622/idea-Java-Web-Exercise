
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class WuZiQi extends KeyAdapter { 
           
    boolean start = false;
   
    JFrame frame;
   
    Thread timerThread;
   
    int h, l;//定义变量
   
    int pans[][]  =new int[11][11]; //变量初始值
   
    int gbx = 5;
   
    int gby = 5;
   
    int ziShu = 0;
   
    int shui = 0;

   

    WuZiQi()
   

    { 
       frame = new JFrame("五子棋");
       frame.getContentPane().add(new Screen());
       frame.addKeyListener(this);
       frame.setSize(12 * 40 + 5 * 2, 12 * 40 + 22 + 5 * 2 + 100);//窗口大小
       frame.setVisible(true);
       frame.repaint();
       frame.addWindowListener(
                           new WindowAdapter() {
                  

        public void windowClosing(WindowEvent e) {
                    System.exit(0);   
             }   
                         
    }   
      );//关闭窗体
   }
   

    public void keyPressed(KeyEvent evt)
   

    {
       switch (evt.getKeyCode())
       {   case KeyEvent.VK_ENTER:
               if (ziShu % 2 == 0)//子数来判断谁赢
               {
                   heiXia();
               }
                else
               {
                   baiXia();
               }
               
             shui = shuiYing();
             break;
           case KeyEvent.VK_ESCAPE:
               System.exit(1);
             break;
           case KeyEvent.VK_LEFT:
               guangBiaoDong(-1, 0);//光标动的坐标
               break;
           case KeyEvent.VK_RIGHT:
               guangBiaoDong(1, 0);//光标动的坐标
               break;   
           case KeyEvent.VK_DOWN:
               guangBiaoDong(0, 1);//光标动的坐标
               break;
           case KeyEvent.VK_UP:
               guangBiaoDong(0, -1);//光标动的坐标
               break;               
       }
         frame.repaint();
   }
   

    class Screen extends JComponent
   

    { 
       public void paint (Graphics g)
       {
           Graphics2D g2d = (Graphics2D) g;
           xianShi(g2d);//画图
       }
   }

   

    public static void main(String[] args)
   

    {
       new WuZiQi();
   }
   

    void xianShi(Graphics2D g2d)//显示
   

    {
     xianShiQiPan(g2d);//显示棋盘
      xianShiQiZis(g2d);//显示旗子
      xianShiGuangBiao(g2d);//显示光标

      g2d.setFont(new Font("STXingkai", 1, 30));//0708第二小组
      g2d.setColor(Color.black);
      g2d.drawString("0708第二小组", 280, 580);

     g2d.setFont(new Font("stCaiyun", 1, 40));
     if (shui == 0)//判断
       {
           g2d.setColor(Color.black);
           xianShiTiShiXia(g2d);//    显示谁下棋
       }
        else
       {
           g2d.setColor(Color.black);
           xianShiTiShiYing(g2d);        //显示谁赢棋
       }
   }   
               
               

    void guangBiaoDong(int fangX, int fangY)////光标动
   

    {
       if (gbx + fangX > 10 || gbx + fangX < 0 || gby + fangY > 10 || gby + fangY < 0)
       {
       }
        else
       {
           gbx = gbx + fangX;   
           gby = gby + fangY;               
       }
   }
   
           

    void heiXia()//黑棋
   

    {
       if (pans[gby][gbx] == 0)
       {
           pans[gby][gbx] = -1;
           ziShu++;
       }
       
   }
   
           

    void baiXia()//白棋
   

    {
       if (pans[gby][gbx] == 0)
       {
           pans[gby][gbx] = 1;
           ziShu++;           
       }   
   }
   
           

    int shuiYing()//0:  1:bai  -1:hei谁赢拉
   

    {
       return kanFangShuiYing(1, 0) + kanFangShuiYing(0, 1) + kanFangShuiYing(1, 1) + kanFangShuiYing(1, -1);
   }
    //---------------------------------------------
           

    void xianShiQiPan(Graphics2D g2d)//显示棋盘
   

    {
       g2d.setColor(Color.pink);
   
       g2d.fillRect(0, 0, 40 * 12, 40 * 12);//    0,0,40*12,40*12   
       g2d.setColor(Color.BLACK);
        //行格
       for (int i = 0; i < 11; i++)//    40,行*40+40,440,行*40+40   
       {
           g2d.drawLine(40, i * 40 + 40, 440, i * 40 + 40);
       }
        //列格
       for (int k = 0; k < 11; k++)//    列*40+40,40,列*40+40,440
       {
           g2d.drawLine(k * 40 + 40, 40, k * 40 + 40, 440);
       }
   }   
                   
               

    void xianShiQiZis(Graphics2D g2d)//显示旗子
   

    {
       for (int h = 0; h < 11; h++)
       {
           for (l = 0; l < 11; l++)
           {
       
               switch (pans[h][l])
               {
                   case 1:   
                       g2d.setColor(Color.BLACK);
                       g2d.fillOval(40 - 15 + l * 40, 40 - 15 + h * 40, 30, 30);//(40-15+l*40,40-15+h*40,30,30);
                       break;
                   case -1:
                       g2d.setColor(Color.white);
                       g2d.fillOval(40 - 15 + l * 40, 40 - 15 + h * 40, 30, 30);//(40-15+l*40,40-15+h*40,30,30);
                       break;                       
                   case 0:
                       break;                       
               }
           }
       }
   }
   

    void xianShiGuangBiao(Graphics2D g2d)//显示光标
   

    {
   g2d.setColor(Color.blue);
   g2d.fillOval(40 - 5 + gbx * 40, 40 - 5 + gby * 40, 10, 10);

   }
        
           

    void xianShiTiShiYing(Graphics2D g2d)//显示谁赢
   

    {
       
       switch (shui)
       {
           case 1:
                //黑棋
               g2d.setColor(Color.black);
               g2d.drawString("黑棋win", 200, 520);
               JOptionPane pane = new JOptionPane("    黑棋胜利^_^");
               JDialog dialog = pane.createDialog(frame, "提示...");
               dialog.show();
               System.exit(0);
               break;
           case -1:
                //白棋
               g2d.setColor(Color.magenta);
              g2d.drawString("白棋win", 200, 520);
               JOptionPane pane1 = new JOptionPane("    白棋胜利^_^");
               JDialog dialog1 = pane1.createDialog(frame, "提示...");
               dialog1.show();
               System.exit(0);
               break;               
       }
   }
   
           

    void xianShiTiShiXia(Graphics2D g2d)////显示提示下一个棋子
   

    {

       switch (ziShu % 2)
       {
           case 0:
            g2d.setColor(Color.magenta);//黑棋
            g2d.drawString("提示:", 10, 520);
            g2d.setColor(Color.orange);
            g2d.drawString("白", 150, 520);
            g2d.setColor(Color.magenta);
            g2d.drawString("棋下", 195, 520);
           break;
           case 1:
            g2d.setColor(Color.magenta);//黑棋
            g2d.drawString("提示:", 10, 520);
            g2d.setColor(Color.black);
            g2d.drawString("黑", 150, 520);
            g2d.setColor(Color.magenta);
            g2d.drawString("棋下", 195, 520);
               break;               
       }
   
   }    
               
               

    int kanFangShuiYing(int fx, int fy)
   

    {
       int kanx = gbx;
       int kany = gby;
       int shu = 1;
        //zuo
       while (kanx + fx >= 0 && kanx + fx < 11  &&kany + fy >= 0 && kany + fy < 11  &&
        pans[kany + fy][kanx + fx] == pans[gby][gbx])
       {
           shu++;
           kany = kany + fy;
           kanx = kanx + fx;           
       }
        //you
       kanx = gbx;
       kany = gby;
       while (kanx - fx >= 0 && kanx - fx < 11  &&kany - fy >= 0 && kany - fy < 11  &&
        pans[kany - fy][kanx - fx] == pans[gby][gbx])
       {
           shu++;
           kany = kany - fy;
           kanx = kanx - fx;           
       }
                       
       return (shu >= 5 ? pans[gby][gbx] : 0);       
   } 
};

