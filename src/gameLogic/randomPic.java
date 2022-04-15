package gameLogic;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;

public class randomPic {

    //first index is answer, other is picture
    private List<String> picArray = new ArrayList<>();

    public randomPic() throws Exception {
        this.picArray = randPic();
    }

    private static List<String> randPic() throws Exception {
        List<List<String>> temp = new picWord().getPicList();
        Random rand = new Random();
        return temp.get(rand.nextInt(temp.size()));
    }

    public List<String> getPicArr() {
        return this.picArray;
    }

    //test
    public static void main(String args[]) throws Exception {

        List<String> test = new randomPic().getPicArr();
        Image picture1 = ImageIO.read(new File(test.get(1)));
        Image picture2 = ImageIO.read(new File(test.get(2)));
        System.out.println(test.get(0));
        System.out.println(test.get(1));
        System.out.println(test.get(2));
        System.out.println("_______________________");
        System.gc();
    }
}
