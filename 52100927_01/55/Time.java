public class Time {

    private int hour;
    private int minute;
    private int second;


    public Time(int hour, int minute, int second){
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }


    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public void setTime(int hour, int minute, int second){
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }


    @Override
    public String toString(){

        String h = "0" + this.hour;
        String m = "0" + this.minute;
        String s = "0" + this.second;

        h = h.substring(h.length() - 2);
        m = m.substring(m.length()-2);
        s = s.substring(s.length() - 2);

        return h + ":" + m + ":" + s;
    }

    private int timeToSecond(){
        return this.hour * 3600 + this.minute*60 + second;
    }

    private Time secondToTime(int seconds){
        seconds = seconds % 86400;


        int hour = seconds /3600;
        seconds = seconds % 3600;
        int minute = seconds / 60;
        seconds = seconds % 60;
        int second = seconds;

        Time time = new Time(hour, minute, second);
        return time;

    }


    public Time nextSecond(){
        int seconds = this.timeToSecond();
        return secondToTime(seconds + 1);
    }

    public Time previousSeconde(){
        int seconds = this.timeToSecond();
        return secondToTime(seconds - 1);
    }





}
