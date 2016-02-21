package com.giovas;

import java.util.Random;

public class JokesProvider {

    private static final String[] JOKES = {"Three guys go to a ski lodge, and there aren't enough rooms, so they have to share a bed. " +
            "In the middle of the night, the guy on the right wakes up and says, \"I had this wild, vivid dream of getting a hand job!\" " +
            "The guy on the left wakes up, and unbelievably, he's had the same dream, too. Then the guy in the middle wakes up and says, " +
            "\"That's funny, I dreamed I was skiing!\" \n",
            "A man and a woman started to have sex in the middle of a dark forest. After about 15 minutes of it, the man finally gets up and says, " +
            "\"Damn, I wish I had a flashlight!\". The woman says, \"Me too, you've been eating grass for the past ten minutes!\" \n",
            "A teacher was wrapping up class, and started talking about tomorrow's final exam. He said there would be no excuses for not showing up tomorrow, " +
            "barring a dire medical condition or an immediate family member's death. One smart ass, male student said, " +
            "\"What about extreme sexual exhaustion?\", and the whole classroom burst into laughter. " +
            "After the laughter had subsided, the teacher glared at the student, and said, \"Not an excuse, you can use your other hand to write.\" \n",
            "A police officer was patrolling the highway when he sees a guy tied up to a tree, crying. The officer stops and approaches the guy. " +
            "\"What's going on here?\", he asks. The guy sobs, \"I was driving and picked up a hitchhiker. He pulled a gun on me, robbed me, " +
            "took all my money, my clothes, my car and then tied me up.\" The cop studied the guy for a moment, " +
            "and then pulled down his pants and whipped out his dick. \"I guess this isn't your lucky day, pal!\" \n",
            "An old man and an old lady are getting ready for bed one night when all of a sudden the woman bursts out of the bathroom, " +
            "flings open her robe and yells \"Super Pussy!\" The old man says \"I'll have the soup.\" \n",
            "Mom: If a boy touches your boobs say \"don't\" and if he touches your pussy say \"stop\"? Girl: But mom, he touched both so I said \"don't stop\" \n",
            "Joke 7", "Joke 8", "Joke 9", "Joke 10"};

    public static String getJokes() {
        Random rand = new Random();
        return JOKES[rand.nextInt(JOKES.length)];
    }
}
