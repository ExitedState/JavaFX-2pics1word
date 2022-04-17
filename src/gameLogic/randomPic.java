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

    public List<String> getPicArr() throws Exception {
        if (cnt == picArray.size()) {
            cnt = 0;
            picArray = new wordToPicture().getPicList();
            Collections.shuffle(picArray);
        }
        return randomPic.picArray.get(cnt++);
    }

    
//    public static void main(String[] args) throws Exception {
//        randomPic temp = new randomPic();
//        List<List<String>> check = new ArrayList<>();
//        for (int i = 0; i < 190; i++) {
//            List<String> temp2 = temp.getPicArr();
//            check.add(temp2);
//        }
//        System.out.println("List len :" + check.size());
//
//        for (int i = 0; i < check.size(); i++) {
//            for (int j = i + 1; j < check.size(); j++) {
//                if (check.get(i).equals(check.get(j))) {
//                    System.out.println("This text will only print one time");
//                }
//            }
//        }
//    }

}
