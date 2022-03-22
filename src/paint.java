import java.awt.*;
import java.util.Random;

public class paint extends Component {
    Random rand = new Random();
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g.setColor(Color.red);
        for (tromino x: Tromino_tiling.trominos){
            g.setColor(new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat()));

            String o = x.getOrientation();
            //System.out.println("");
            //System.out.println(x.toString());



            if(o=="LL"){
                g2d.fillRect ((x.getL().getX()*100), 900-(x.getL().getY()*100), 100, 100);
                g2d.fillRect ((x.getL().getX()*100)-100, 800-(x.getL().getY()*100), 100, 100);
                g2d.fillRect ((x.getL().getX()*100)-100, 900-(x.getL().getY()*100), 100, 100);
            }
            else if(o=="LR"){
                g2d.fillRect ((x.getL().getX()*100), 900-(x.getL().getY()*100), 100, 100);
                g2d.fillRect ((x.getL().getX()*100), 800-(x.getL().getY()*100), 100, 100);
                g2d.fillRect ((x.getL().getX()*100)-100, 900-(x.getL().getY()*100), 100, 100);
            }
            else if(o=="UR"){
                g2d.fillRect ((x.getL().getX()*100), 900-(x.getL().getY()*100), 100, 100);
                g2d.fillRect ((x.getL().getX()*100)-100, 800-(x.getL().getY()*100), 100, 100);
                g2d.fillRect ((x.getL().getX()*100), 800-(x.getL().getY()*100), 100, 100);
            }
            else if(o=="UL"){
                g2d.fillRect ((x.getL().getX()*100)-100, 800-(x.getL().getY()*100), 100, 100);
                g2d.fillRect ((x.getL().getX()*100), 800-(x.getL().getY()*100), 100, 100);
                g2d.fillRect ((x.getL().getX()*100)-100, 900-(x.getL().getY()*100), 100, 100);
            }



            /*if(o=="LL"){
                g2d.fillRect ((x.getL().getX()*100)-100, 800-(x.getL().getY()*100), 100, 100);
                g2d.fillRect ((x.getL().getX()*100), 900-(x.getL().getY()*100), 100, 100);
                g2d.fillRect ((x.getL().getX()*100), 800-(x.getL().getY()*100), 100, 100);
            }
            else if(o=="LR"){
                g2d.fillRect ((x.getL().getX()*100), 800-(x.getL().getY()*100), 100, 100);
                g2d.fillRect ((x.getL().getX()*100)-100, 900-(x.getL().getY()*100), 100, 100);
                g2d.fillRect ((x.getL().getX()*100), 900-(x.getL().getY()*100), 100, 100);
            }
            else if(o=="UR"){
                g2d.fillRect ((x.getL().getX()*100), 900-(x.getL().getY()*100), 100, 100);
                g2d.fillRect ((x.getL().getX()*100)-100, 800-(x.getL().getY()*100), 100, 100);
                g2d.fillRect ((x.getL().getX()*100), 800-(x.getL().getY()*100), 100, 100);
            }
            else if(o=="UL"){
                g2d.fillRect ((x.getL().getX()*100)-100, 800-(x.getL().getY()*100), 100, 100);
                g2d.fillRect ((x.getL().getX()*100)-100, 900-(x.getL().getY()*100), 100, 100);
                g2d.fillRect ((x.getL().getX()*100), 800-(x.getL().getY()*100), 100, 100);
            }*/
        }
    }

}
