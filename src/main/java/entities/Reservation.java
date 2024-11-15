package entities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private Integer rooNUmber;
    private Date checkin;
    private Date checkout;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation() {}

    public Reservation(Integer rooNUmber, Date checkin, Date checkout) {
        this.rooNUmber = rooNUmber;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Integer getRooNUmber() {
        return rooNUmber;
    }

    public void setRooNUmber(Integer rooNUmber) {
        this.rooNUmber = rooNUmber;
    }

    public Date getCheckin() {
        return checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public long duration(){
        long diff = checkout.getTime() - checkin.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public String updateDates(Date checkin, Date checkout) {
        Date now = new Date();
        if(checkin.before(now) || checkout.before(now)) {
            return "Reservation dates for update must be after check-in date";
        }
        if(!checkout.after(checkin)){
            return "Check-out date must be after check-in date";
        }

        this.checkin = checkin;
        this.checkout = checkout;
        return null;
    }

    @Override
    public String toString() {
        return "Room "
                + rooNUmber
                + ", check-in: "
                + sdf.format(checkin)
                + ", check-out: "
                + sdf.format(checkout)
                + ", "
                + duration()
                + " nights";
    }

}
