package example.com.essitrack_clone_nd.util;

import java.util.ArrayList;
import java.util.List;

import example.com.essitrack_clone_nd.bean.Recyclerview;

/**
 * Created by Appy-Sales on 06-12-2017.
 */

public class AllData
{
    public static List<Recyclerview> tracklist=new ArrayList<>();
    public static List<Recyclerview> getAllDummyData()
    {
        if(tracklist.size()==0) {
            Recyclerview recyclerview = new Recyclerview("TODAY'S", "CICI 91", "Reference#:", "100014668801", "Tracking#:", "21-12-2017", "04-08-2017");
            tracklist.add(recyclerview);

            recyclerview = new Recyclerview("TODAY'S", "CICI 92", "Reference#:", "100014668805", "Tracking#:", "21-12-2017", "04-08-2017");
            tracklist.add(recyclerview);

            recyclerview = new Recyclerview("In Progress", "CICI 93", "Reference#:", "100014668701", "Tracking#:", "22-12-2017", "04-08-2017");
            tracklist.add(recyclerview);

            recyclerview = new Recyclerview("In Progress", "CICI 94", "Reference#:", "100014668766", "Tracking#:", "12-12-2017", "04-08-2017");
            tracklist.add(recyclerview);

            recyclerview = new Recyclerview("Completed", "CICI 95", "Reference#:", "100014668601", "Tracking#:", "01-12-2017", "04-08-2017");
            tracklist.add(recyclerview);
            recyclerview = new Recyclerview("Completed", "CICI 96 ", "Reference#:", "100014668671", "Tracking#:", "01-12-2017", "04-08-2017");
            tracklist.add(recyclerview);


            recyclerview = new Recyclerview("Delay", "CICI 97", "Reference#:", "100014668791", "Tracking#:", "02-12-2017", "04-08-2017");
            tracklist.add(recyclerview);

            recyclerview = new Recyclerview("Delay", "CICI 98", "Reference#:", "100014668796", "Tracking#:", "02-12-2017", "04-08-2017");
            tracklist.add(recyclerview);

            recyclerview = new Recyclerview("Cancelled", "CICI 88", "Reference#:", "100014668501", "Tracking#:", "05-12-2017", "04-08-2017");
            tracklist.add(recyclerview);

           recyclerview = new Recyclerview("Cancelled", "CICI 89", "Reference#:", "100014668401", "Tracking#:", "05-12-2017", "04-08-2017");
            tracklist.add(recyclerview);

        }
        return tracklist;
    }


}
