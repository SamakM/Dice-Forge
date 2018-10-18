package bot;

import objects.Dice;
import org.junit.Assert;
import org.junit.Test;

public class SimpleBotTest {

    @Test
    public void SimpleBotTest(){
        Dice d1 = new Dice();
        d1.solarDiceInit();
        Dice d2 = new Dice();
        d2.lunarDiceInit();

        SimpleBot bot1=new SimpleBot(d1,d2);
        Assert.assertNotNull(bot1);

    }

}