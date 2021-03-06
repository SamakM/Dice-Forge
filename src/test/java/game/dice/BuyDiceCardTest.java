package game.dice;

import bot.SimpleBot;
import game.ScoreCounter;
import game.card.BuyCard;
import org.junit.Assert;
import org.junit.Test;

public class BuyDiceCardTest {

    @Test
    public void setCard() {
        BuyDiceCard.resetBotLog();
        BuyCard.resetBotLog();

        Dice d1 = new Dice();
        d1.solarDiceInit();
        Dice d2 = new Dice();
        d2.lunarDiceInit();
        ScoreCounter score = new ScoreCounter();
        Sanctuary sanctuary = new Sanctuary(2);
        SimpleBot bot = new SimpleBot(d1,d2,"test","\033[0m");


        DiceCard card = new DiceCard(3, Resource.GOLD);
        score.updateScore(bot,new DiceCard[]{new DiceCard(1, Resource.GOLD), new DiceCard(1, Resource.GOLD)});
        BuyDiceCard.setCard(sanctuary,2, card, d1,1, bot.getBotScore());
        Assert.assertEquals(card, d1.getFi(1));
        Assert.assertEquals(0, bot.getBotScore().getGold());

        DiceCard card1 = new DiceCard(1, Resource.LUNAR);
        score.updateScore(bot,new DiceCard[]{new DiceCard(1, Resource.GOLD), new DiceCard(1, Resource.GOLD)});
        BuyDiceCard.setCard(sanctuary,2, card1, d1,2, bot.getBotScore());
        Assert.assertEquals(card1, d1.getFi(2));
        Assert.assertEquals(0, bot.getBotScore().getGold());

        DiceCard card2 = new DiceCard(4, Resource.GOLD);
        score.updateScore(bot,new DiceCard[]{new DiceCard(2, Resource.GOLD), new DiceCard(1, Resource.GOLD)});
        BuyDiceCard.setCard(sanctuary,3, card2, d1,3, bot.getBotScore());
        Assert.assertEquals(card2, d1.getFi(3));
        Assert.assertEquals(0, bot.getBotScore().getGold());

        DiceCard card3 = new DiceCard(1, Resource.SOLAR);
        score.updateScore(bot,new DiceCard[]{new DiceCard(2, Resource.GOLD), new DiceCard(1, Resource.GOLD)});
        BuyDiceCard.setCard(sanctuary,3, card3, d1,4, bot.getBotScore());
        Assert.assertEquals(card3, d1.getFi(4));
        Assert.assertEquals(0, bot.getBotScore().getGold());

        DiceCard card4 = new DiceCard(2, Resource.LUNAR);
        score.updateScore(bot,new DiceCard[]{new DiceCard(3, Resource.GOLD), new DiceCard(3, Resource.GOLD)});
        BuyDiceCard.setCard(sanctuary,6, card4, d1,5, bot.getBotScore());
        Assert.assertEquals(card4, d1.getFi(5));
        Assert.assertEquals(0, bot.getBotScore().getGold());

        DiceCard card5 = new DiceCard(3, Resource.VICTORY);
        score.updateScore(bot,new DiceCard[]{new DiceCard(4, Resource.GOLD), new DiceCard(4, Resource.GOLD)});
        BuyDiceCard.setCard(sanctuary,8, card5, d1,6, bot.getBotScore());
        Assert.assertEquals(card5, d1.getFi(6));
        Assert.assertEquals(0, bot.getBotScore().getGold());
    }

    @Test
    public void setSpecial() {
        BuyDiceCard.resetBotLog();
        BuyCard.resetBotLog();

        Dice d1 = new Dice();
        d1.solarDiceInit();
        Dice d2 = new Dice();
        d2.lunarDiceInit();

        Sanctuary sanctuary = new Sanctuary(2);
        SimpleBot bot = new SimpleBot(d1,d2,"test","\033[0m");

        DiceCard card = new DiceCard(0, Resource.X3);
        BuyDiceCard.setSpecial(d1,2, card);
        Assert.assertEquals(card, d1.getFi(2));

        DiceCard card1 = new DiceCard(0, Resource.QUESTION);
        BuyDiceCard.setSpecial(d1,3, card1);
        Assert.assertEquals(card1, d1.getFi(3));

    }

    @Test
    public void resetBotLog() {

        BuyDiceCard.resetBotLog();
        BuyCard.resetBotLog();

        Dice d1 = new Dice();
        d1.solarDiceInit();
        Dice d2 = new Dice();
        d2.lunarDiceInit();
        ScoreCounter score = new ScoreCounter();

        Sanctuary sanctuary = new Sanctuary(2);
        SimpleBot bot = new SimpleBot(d1,d2,"test","\033[0m");


        DiceCard card = new DiceCard(3, Resource.GOLD);
        score.updateScore(bot,new DiceCard[]{new DiceCard(1, Resource.GOLD), new DiceCard(1, Resource.GOLD)});
        BuyDiceCard.setCard(sanctuary,2, card, d1,1, bot.getBotScore());

        BuyDiceCard.resetBotLog();
        Assert.assertEquals(0, BuyDiceCard.getBought().size());
    }
}
