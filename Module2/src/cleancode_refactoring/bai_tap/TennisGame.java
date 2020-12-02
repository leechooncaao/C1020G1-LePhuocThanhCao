package cleancode_refactoring.bai_tap;

public class TennisGame {
    public static String getScore(int score1, int score2) {
        StringBuilder score = new StringBuilder();
        int tempScore;
        if (isEqualScores(score1, score2)) {
            switch (score1) {
                case 0:
                    score.append("Love-All");
                    break;
                case 1:
                    score.append("Fifteen-All");
                    break;
                case 2:
                    score.append("Thirty-All");
                    break;
                case 3:
                    score.append("Forty-All");
                    break;
                default:
                    score.append("Deuce");
                    break;
            }
        } else if (score1 >= 4 || score2 >= 4) {
            int difference = score1 - score2;
            if (difference == 1) score.append("Advantage player1");
            else if (difference == -1) score.append("Advantage player2");
            else if (difference >= 2) score.append("Win for player1");
            else score.append("Win for player2");
        } else {
            for (int i = 1; i < 3; i++) {
                if (i == 1) tempScore = score1;
                else {
                    score.append("-");
                    tempScore = score2;
                }
                switch (tempScore) {
                    case 0:
                        score.append("Love");
                        break;
                    case 1:
                        score.append("Fifteen");
                        break;
                    case 2:
                        score.append("Thirty");
                        break;
                    case 3:
                        score.append("Forty");
                        break;
                }
            }
        }
        return score.toString();
    }

    private static boolean isEqualScores(int score1, int score2) {
        return score1 == score2;
    }

    public static void main(String[] args) {
        System.out.println(getScore(2,3));
    }
}
