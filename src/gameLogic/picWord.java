package gameLogic;

import java.util.List;
import java.util.ArrayList;

public class picWord extends wordList {

    private final List<List<String>> picList;

    public picWord() throws Exception {
        this.picList = generatePicList();
    }

    private List<List<String>> generatePicList() throws Exception {
        List<List<String>> picLocation = new ArrayList<>();
        for (int i = 0; i < getWordsList().size(); i++) {
            List temp = new ArrayList<String>();
            temp.add(getWordsList().get(i));
            temp.add("/pic/wordPic/set1/" + getWordsList().get(i) + "_1.png");
            temp.add("/pic/wordPic/set2/" + getWordsList().get(i) + "_2.png");
//            temp.add("src\\pic\\wordPic\\set1\\" + getWordsList().get(i) + "_1.png");
//            temp.add("src\\pic\\wordPic\\set2\\" + getWordsList().get(i) + "_2.png");
            picLocation.add(temp);
        }
        return picLocation;
    }

    public List<List<String>> getPicList() {
        return this.picList;
    }

}
