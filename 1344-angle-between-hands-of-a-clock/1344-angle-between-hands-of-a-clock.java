class Solution {
    public double angleClock(int hour, int minutes) {
        double hourHand = ((double)minutes)/ 12.0 ;
        hourHand += (hour*5); 
        double difference = Math.abs(minutes-hourHand);
    return Math.min(difference*6.0, 360-(difference*6.0));
    }
}