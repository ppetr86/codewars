package com.example.codewars3.codewars.kyu5;

//https://www.codewars.com/kata/5a3267b2ee1aaead3d000037/train/java
//https://www.codewars.com/kata/5a3267b2ee1aaead3d000037/solutions/java

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class PhoneWordV2 {

    public static String[] PRELOADED = new String[]{"ACT", "ADD", "ALL", "APE", "AND", "ANN", "ANY", "ANT", "ARE", "ART", "ASS", "BAD", "BAR", "BAT", "BAY", "BEE", "BIG", "BIT", "BOB", "BOY", "BUN", "BUT", "CAN", "CAR", "CAT", "COT", "COW", "CUT", "DAD", "DAY", "DEW", "DID", "DIN", "DOG", "DON", "DOT", "DUD", "EAR", "EAT", "EEL", "EGG", "ERR", "EYE", "FAG", "FAR", "FLY", "FOR", "FUN", "FUR", "GAY", "GET", "GOT", "GUM", "GUN", "GUY", "GUT", "GYM", "HAS", "HAT", "HER", "HEY", "HIM", "HIS", "HIT", "HOW", "HUG", "HUN", "ICE", "INK", "ITS", "IVE", "JAN", "JET", "JOB", "JOT", "JOY", "KEY", "LAP", "LAY", "LIE", "LET", "LOG", "MAN", "MAP", "MAY", "MEN", "MOM", "MUD", "MUM", "NAP", "NEW", "NOD", "NOT", "NOW", "OAR", "ODD", "OFF", "OLD", "ONE", "OUR", "OUT", "PAN", "PAL", "PAT", "PAW", "PEN", "PET", "PIG", "PIT", "POT", "PRO", "PUT", "QUO", "RAG", "RAM", "RAN", "RAP", "RAT", "RED", "RIP", "ROD", "ROT", "RUN", "RUT", "SAT", "SAW", "SAY", "SEA", "SEE", "SEX", "SHE", "SOY", "SUN", "SUX", "TAN", "TAT", "TEA", "THE", "TIN", "TIP", "TIT", "TON", "TOP", "TOO", "TWO", "URN", "USE", "VAN", "VET", "VIP", "WAR", "WAS", "WAY", "WED", "WHO", "WHY", "WIN", "WON", "XXX", "YAK", "YAM", "YAP", "YOU", "YUM", "ZAP", "ZIP", "ZIT", "ZOO", "ABLE", "ACED", "AGOG", "AHEM", "AHOY", "ALLY", "AMEN", "ANTI", "ANTS", "ANUS", "APES", "ARMY", "ARSE", "ARTY", "AVID", "AWED", "BABY", "BARS", "BATS", "BAYS", "BEAR", "BEES", "BILL", "BITE", "BITS", "BLOW", "BLUE", "BOLD", "BONE", "BOOB", "BOOM", "BOSS", "BOYS", "BUFF", "BUNG", "BUNS", "BUMS", "BURP", "BUST", "BUSY", "BUZZ", "CANS", "CANT", "CARS", "CART", "CATS", "CHAP", "CHIC", "CHUM", "CIAO", "CLAP", "COCK", "CODE", "COOL", "COWS", "COZY", "CRAB", "CREW", "CURE", "CULT", "DADS", "DAFT", "DAWN", "DAYS", "DECK", "DEED", "DICK", "DING", "DOGS", "DOTS", "DOLL", "DOLT", "DONG", "DOPE", "DOWN", "DRAW", "DUCK", "DUDE", "DUMB", "DUTY", "EARL", "EARN", "EARS", "EASY", "EATS", "EDGE", "EELS", "EGGS", "ENVY", "EPIC", "EYES", "FACE", "FAGS", "FANG", "FARM", "FART", "FANS", "FAST", "FEAT", "FEET", "FISH", "FIVE", "FIZZ", "FLAG", "FLEW", "FLIP", "FLOW", "FOOD", "FORT", "FUCK", "FUND", "GAIN", "GEEK", "GEMS", "GIFT", "GIRL", "GIST", "GIVE", "GLEE", "GLOW", "GOLD", "GOOD", "GOSH", "GRAB", "GRIN", "GRIT", "GROT", "GROW", "GRUB", "GUNS", "GUSH", "GYMS", "HAIL", "HAIR", "HALO", "HANG", "HATS", "HEAD", "HEAL", "HEIR", "HELL", "HELP", "HERE", "HERO", "HERS", "HIGH", "HIRE", "HITS", "HOLY", "HOPE", "HOST", "HUNK", "HUGE", "HUNG", "HUNS", "HURT", "ICON", "IDEA", "IDLE", "IDOL", "IOTA", "JAZZ", "JERK", "JESS", "JETS", "JINX", "JOBS", "JOHN", "JOKE", "JUMP", "JUNE", "JULY", "JUNK", "JUST", "KATA", "KEYS", "KICK", "KIND", "KING", "KISS", "KONG", "KNOB", "KNOW", "LARK", "LATE", "LEAN", "LICE", "LICK", "LIKE", "LION", "LIVE", "LOGS", "LOCK", "LONG", "LOOK", "LORD", "LOVE", "LUCK", "LUSH", "MAKE", "MANY", "MART", "MATE", "MAXI", "MEEK", "MIKE", "MILD", "MINT", "MMMM", "MOMS", "MOOD", "MOON", "MOOT", "MUCH", "MUFF", "MUMS", "MUTT", "NAPS", "NAZI", "NEAT", "NECK", "NEED", "NEWS", "NEXT", "NICE", "NICK", "NOON", "NOSE", "NOTE", "OARS", "OATS", "ONCE", "ONLY", "OPEN", "ORGY", "OVAL", "OVER", "PANS", "PALS", "PART", "PAST", "PATS", "PAWS", "PEAR", "PERT", "PENS", "PETS", "PHEW", "PIPE", "PIPS", "PLAN", "PLUM", "PLUS", "POET", "POOF", "POOP", "POSH", "POTS", "PROS", "PSST", "PUKE", "PUNK", "PURE", "PUSH", "PUSS", "QUAD", "QUAK", "QUID", "QUIT", "RANT", "RAPE", "RAPS", "RAPT", "RATE", "RAMS", "RATS", "REAP", "RICK", "RING", "RIPE", "ROOT", "ROSE", "ROSY", "ROTS", "RUNT", "RUTS", "SAFE", "SAGE", "SANE", "SAVE", "SAWS", "SEEK", "SEXY", "SHAG", "SHIT", "SICK", "SIGH", "SIRE", "SLAG", "SLIT", "SLUT", "SNAP", "SNOG", "SNUG", "SOFT", "SOON", "SOUL", "SOUP", "SPRY", "STIR", "STUN", "SUCK", "SWAG", "SWAY", "TACT", "TANK", "TANS", "THAT", "THIS", "TIME", "TINS", "TINY", "TITS", "TOES", "TONS", "TONY", "TOPS", "TOYS", "UBER", "URNS", "USED", "USER", "USES", "VAIN", "VAMP", "VARY", "VEIN", "VENT", "VERY", "VEST", "VIEW", "VIVA", "VOLT", "VOTE", "WAFT", "WAGE", "WAKE", "WALK", "WALL", "WANG", "WANK", "WANT", "WARD", "WARM", "WARP", "WARS", "WART", "WASH", "WAVE", "WEAR", "WEDS", "WEED", "WEEN", "WELD", "WHAT", "WHEE", "WHEW", "WHIP", "WHIZ", "WHOA", "WIFE", "WILL", "WIND", "WING", "WINK", "WINS", "WIRE", "WISH", "WITH", "WORD", "WORK", "WRAP", "XMAN", "XMEN", "XRAY", "XTRA", "XXXX", "YANK", "YAKS", "YAMS", "YAPS", "YARD", "YARN", "YELP", "YERN", "YOKE", "YOLK", "YULE", "ZANY", "ZAPS", "ZIPS", "ZITS", "ZERO", "ZOOM", "ZOOS"};


    public static void main(String[] args) {
        System.out.println(check1800("1-800-CODE-WAR"));
    }


    public static Set<String> check1800(final String str) {
        Map<Character, Integer> stringsToIntegers = createStringToIntegers();

        String strToNumber = lettersToNumbers(str.substring(6).replaceAll("-", ""), stringsToIntegers);
        Set<String> matchingWords = new HashSet<>();
        Set<String> startsWith4Letters = getCombinations(stringsToIntegers, strToNumber, 4);

        if (!startsWith4Letters.isEmpty()) {
            Set<String> endsWith3Letters = getCombinations(stringsToIntegers, strToNumber, 3, 4);

            if (!endsWith3Letters.isEmpty()) {
                for (String len4 : startsWith4Letters) {
                    for (String len3 : endsWith3Letters) {
                        matchingWords.add(String.format("1-800-%s-%s", len4, len3));
                    }
                }
            }
        }

        Set<String> startsWith3Letters = getCombinations(stringsToIntegers, strToNumber, 3);

        if (!startsWith3Letters.isEmpty()) {
            Set<String> endsWith4Letters = getCombinations(stringsToIntegers, strToNumber, 4, 3);

            if (!endsWith4Letters.isEmpty()) {
                for (String len3 : startsWith3Letters) {
                    for (String len4 : endsWith4Letters) {
                        matchingWords.add(String.format("1-800-%s-%s", len3, len4));
                    }
                }
            }
        }
        return matchingWords;
    }

    private static Set<String> getCombinations(Map<Character, Integer> stringsToIntegers, String strToNumber, int i) {
        return Arrays.stream(PRELOADED)
                .filter(each -> each.length() == i)
                .filter(each -> lettersToNumbers(each, stringsToIntegers).equals(strToNumber.substring(0, i)))
                .collect(Collectors.toSet());
    }

    private static Set<String> getCombinations(Map<Character, Integer> stringsToIntegers, String strToNumber, int length, int startIndex) {
        return Arrays.stream(PRELOADED)
                .filter(each -> each.length() == length)
                .filter(each -> lettersToNumbers(each, stringsToIntegers).equals(strToNumber.substring(startIndex)))
                .collect(Collectors.toSet());
    }

    public static String lettersToNumbers(String str, Map<Character, Integer> stringsToIntegers) {

        return Arrays.stream(str.split(""))
                .map(each -> each.charAt(0) == '-' ? "-" : String.valueOf(stringsToIntegers.get(each.charAt(0))))
                .collect(Collectors.joining());
    }

    public static Map<Character, Integer> createStringToIntegers() {
        Map<Character, Integer> stringsToIntegers = new HashMap<>();
        int numberButton = 2;
        int charsOnDigit = 3;
        for (int i = 1; i <= 26; i++) {
            int valueOfChar = (int) 'A' + i - 1;
            if (i < 16) {
                stringsToIntegers.put((char) valueOfChar, numberButton);
                if (i % charsOnDigit == 0) numberButton++;
            } else if (i < 20) {
                stringsToIntegers.put((char) valueOfChar, 7);
            } else if (i < 23) {
                stringsToIntegers.put((char) valueOfChar, 8);
            } else {
                stringsToIntegers.put((char) valueOfChar, 9);
            }
        }

        return stringsToIntegers;
    }

    public static Map<Integer, List<String>> createNumbersToLetters() {
        Map<Integer, List<String>> numbersToLetters = new HashMap<>();
        numbersToLetters.put(2, Arrays.asList("A", "B", "main.java.C"));
        numbersToLetters.put(3, Arrays.asList("main.java.D", "E", "F"));
        numbersToLetters.put(4, Arrays.asList("G", "H", "I"));
        numbersToLetters.put(5, Arrays.asList("J", "K", "L"));
        numbersToLetters.put(6, Arrays.asList("M", "N", "O"));
        numbersToLetters.put(7, Arrays.asList("P", "Q", "R", "S"));
        numbersToLetters.put(8, Arrays.asList("T", "U", "V"));
        numbersToLetters.put(9, Arrays.asList("W", "X", "Y", "Z"));

        return numbersToLetters;
    }
}