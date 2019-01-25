public class WordWrap {
    int beginningOfWord = 0;
    char space = ' ';
    int width;

    public String wrap(String word, int width) {
        this.width = width;

        if (word.length() <= this.width){
            return word;
        }

        int spacePosition = (word.substring(beginningOfWord, this.width).lastIndexOf(space));

        if (hasSpace(spacePosition)) {
            return partition(word, spacePosition, 1);
        }
        else if (widthIsSpace(word)) {
            return partition(word, this.width, 1);
        }
        else{
            return partition(word, this.width, 0);
        }
    }

    private boolean hasSpace(int space){
        return space != -1;
    }

    private boolean widthIsSpace(String word) { return word.charAt(width) == space; }

    private String partition(String word, int newLinePosition, int offset){
        return word.substring(beginningOfWord, newLinePosition) + "\n" + wrap(word.substring(newLinePosition + offset), width);
    }

}
