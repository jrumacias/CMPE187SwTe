/**
 * ProgressCircle Circle
 *
 * Original code written by: Juan Macias
 * San Jose State University
 * Spring 2019
 * CMPE187: Software Testing
 *
 * NOTES
 * To avoid indecision when a point may lie in multiple quadrants, the following limitations apply:
 *  - Quadrant I    x coordinates range from 50-100
 *                  y coordinates range from 50-100
 *  - Quadrant II   x coordinates range from 50-100
 *                  y coordinates range from 0-49
 *  - Quadrant III  x coordinates range from 0-49
 *                  y coordinates range from 0-49
 *  - Quadrant IV   x coordinates range from 0-49
 *                  y coordinates range from 50-100
 */

public class ProgressCircle {
    double P = 0;
    int x = 0;
    int y = 0;

    public ProgressCircle(double P, int x, int y) {
        this.P = P;
        this.x = x;
        this.y = y;
    }

    public static String getProgress(double P, int x, int y) {
//        Calculate the angle based on percentage
        double completedAngle = (P / 100) * 360;
//        Convert angle to radians
        double completedRadians = ((Math.PI / 180) * (completedAngle));

        /*  QUADRANT I
        x: 50-100, rise
        y: 50-100, run
         */
        if ((x >= 50 && x <= 100) && (y >= 50 && y <= 100)) {
            int rise = x;
            int run = y;
            int slope = rise / run;
            double checkRadians = Math.atan(slope); // Add 0 degrees since QI
            if (checkRadians <= completedRadians) {
                return "RED, QI";
            }

        }

        /*  QUADRANT II
        x: 50-100, run
        y: 0-50, rise
         */
        if ((x >= 50 && x <= 100) && (y >= 0 && y <= 49)) {
            double rise = 50 - y;
            double run = 50 - x;
            double slope = rise / run;
            double checkRadians = Math.atan(slope) + 1.5708; // Add 90 degrees since QII
            if (checkRadians <= completedRadians) {
                return "RED, QII";
            }
        }

        /*  QUADRANT III
        x: 0-50, rise
        y: 0-50, run
         */
        if ((x >= 0 && x <= 49) && (y >= 0 && y <= 49)) {
            int rise = 50 - x;
            int run = 50 - y;
            int slope = rise / run;
            double checkRadians = Math.atan(slope) + 3.14159; // Add 180 degrees since QIII
            if (checkRadians <= completedRadians) {
                return "RED, QIII";
            }
        }

        /*  QUADRANT IV
        x: 0-50, run
        y: 50-100, rise */
        if ((x >= 0 && x <= 49) && (y >= 50 && y <= 100)) {
            int rise = y;
            int run = x;
            int slope = rise / run;
            double checkRadians = Math.atan(slope) + 4.71239; // Add 270 degrees since QIV
            if (checkRadians <= completedRadians) {
                return "RED, QIV";
            }
        }

        return "BLUE";
    }

    public static void main(String[] args) {
        ProgressCircle testProgress = new ProgressCircle(100, 5, 40);

        System.out.println(testProgress.getProgress(testProgress.P, testProgress.x, testProgress.y));
    }
}
