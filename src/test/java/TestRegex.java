import com.oussama.RegexBuilder;
import com.oussama.Utils;
import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {
    @Test
    public void testExample() {
        RegexBuilder regexBuilder = new RegexBuilder();

        regexBuilder
                .startsWith("+212")
                .set('6', '7')
                .digit().repeatExactly(8);
        System.out.println(regexBuilder.getRegex());
        Pattern phonePattern = regexBuilder
                .build();
        Matcher matcher = phonePattern.matcher("+212712345678");

        if (matcher.find()) {
            System.out.println("Matched zero or more word characters: " + matcher.group());
            Assert.assertTrue(true);
        } else {
            System.out.println("No match found.");
            Assert.fail();
        }

    }

    @Test
    public void testSet1() {
        RegexBuilder builder = new RegexBuilder();
        builder.set('A','B');
        Assert.assertEquals("[AB]", builder.getRegex());
    }

    @Test
    public void testSet2() {
        RegexBuilder builder = new RegexBuilder();
        builder.set('2','-','?');
        Assert.assertEquals("[2-?]", builder.getRegex());
    }


    @Test
    public void testInsertBeforeEverySpecialCharacter() {
        String input = "1234op+? {}";
        String output = Utils.insertBeforeEverySpecialCharacter(input, "\\");
        Assert.assertEquals(output, "1234op\\+\\? \\{\\}");
    }
}
