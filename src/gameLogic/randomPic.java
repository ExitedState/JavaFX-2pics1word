package gameLogic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class randomPic {

    //first index is answer, other is picture path
    public static List<List<String>> picArray = new ArrayList<>();

    public static int cnt = 0;

    public randomPic() throws Exception {
        if (cnt == 0) {
            picArray = new wordToPicture().getPicList();
            Collections.shuffle(picArray);
        }
    }

    public List<String> getPicArr() throws Exception{
        if (cnt == picArray.size() - 1) {
            cnt = 0;
            picArray = new wordToPicture().getPicList();
            Collections.shuffle(picArray);
        }
        return this.picArray.get(cnt++);
    }

//    public static void main(String[] args) throws Exception {
//        randomPic temp = new randomPic();
//        for (int i = 0; i <1000; i++) {
//            List<String> temp2 = temp.getPicArr();
//            System.out.println(temp2.get(0));
//            System.out.println(temp2.get(1));
//            System.out.println(temp2.get(2));
//        }
//
//    }

}
