package example.com.essitrack_clone_nd.bean;

/**
 * Created by Appy-Sales on 06-12-2017.
 */

public class Recyclerview {
    private String status, reference,referenceno,tracking,trackingno,deliveryby,ddate,entryon,entrydate;
    boolean boomarked;

    public Recyclerview() {
    }

    public Recyclerview(String status, String reference, String referenceno, String tracking, String trackingno, String ddate, String entrydate) {
        this.status=status;
        this.reference=reference;
        this.referenceno=referenceno;
        this.tracking=tracking;
        this.trackingno=trackingno;
        this.ddate=ddate;
        this.entrydate=entrydate;


    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
    public String getReferenceno() {
        return referenceno;
    }

    public void setReferenceno(String referenceno) {
        this.referenceno = referenceno;
    }


    public String getTracking() {
        return tracking;
    }

    public void setTracking(String tracking) {
        this.tracking = tracking;
    }

  /*  public String getDeliveryby() {
        return deliveryby;
    }*/
    public String getTrackingno() {
        return trackingno;
    }

    public void setTrackingno(String trackingno) {
        this.trackingno = trackingno;
    }


   /* public void setDeliveryby(String deliveryby) {
        this.deliveryby = deliveryby;
    }
*/
    public String getDdate() {
        return ddate;
    }

    public void setDdate(String ddate) {
        this.ddate = ddate;
    }

  /*  public String getEntryon() {
        return entryon;
    }*/

   /* public void setEntryon(String entryon) {
        this.entryon = entryon;
    }*/

    public String getEntrydate() {
        return entrydate;
    }

    public void setEntrydate(String entrydate) {
        this.entrydate = entrydate;
    }

    public boolean isBoomarked() {
        return boomarked;
    }

    public void setBoomarked(boolean boomarked) {
        this.boomarked = boomarked;
    }
}
