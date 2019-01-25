import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class WordWrapTest {
    WordWrap ww;

    @Before
    public void setUp() {
        ww = new WordWrap();
    }

    @Test
    public void emptyWord_isEmptyString() {
        String new_word = ww.wrap("", 1);

        assertThat(new_word, is(""));
    }

    @Test
    public void sameWidth_isWholeWord() {
        String new_word = ww.wrap("example", 7);

        assertThat(new_word, is("example"));
    }

    @Test
    public void biggerWidth_isWholeWord() {
        String new_word = ww.wrap("example", 9);

        assertThat(new_word, is("example"));
    }

    @Test
    public void smallerWidth_isWrapped(){
        String new_word = ww.wrap("example", 4);

        assertThat(new_word, is("exam\nple"));
    }

    @Test
    public void multipleSmallerWidth_isMultipleWrapped(){
        String new_word = ww.wrap("example", 2);

        assertThat(new_word, is("ex\nam\npl\ne"));
    }

    @Test
    public void widthSameAsSpace(){
        String new_word = ww.wrap("Hello world", 6);

        assertThat(new_word, is("Hello\nworld"));
    }

    @Test
    public void widthInTheSecondWord(){
        String new_word = ww.wrap("Hello world", 8);

        assertThat(new_word, is("Hello\nworld"));
    }

    @Test
    public void widthInTheMiddleOfMultipleWords(){
        String new_word = ww.wrap("Hello world, my name is Merce", 8);

        assertThat(new_word, is("Hello\nworld,\nmy name\nis Merce"));
    }




}