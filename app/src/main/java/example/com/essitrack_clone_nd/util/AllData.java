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
            Recyclerview recyclerview = new Recyclerview("TODAY'S", "CICI 9", "Reference#:", "1000146687950", "Tracking#:", "19-12-2017", "04-08-2017");
            tracklist.add(recyclerview);

            recyclerview = new Recyclerview("TODAY'S", "CICI 92", "Reference#:", "1000146687951", "Tracking#:", "19-12-2017", "04-08-2017");
            tracklist.add(recyclerview);

            recyclerview = new Recyclerview("In Progress", "CICI 94", "Reference#:", "10001466879553", "Tracking#:", "09-12-2017", "04-08-2017");
            tracklist.add(recyclerview);

            recyclerview = new Recyclerview("In Progress", "CICI 92", "Reference#:", "100014668795", "Tracking#:", "12-12-2017", "04-08-2017");
            tracklist.add(recyclerview);

            recyclerview = new Recyclerview("Completed", "CICI 987", "Reference#:", "10001466879554", "Tracking#:", "01-12-2017", "04-08-2017");
            tracklist.add(recyclerview);
            recyclerview = new Recyclerview("Completed", "CICI 986", "Reference#:", "10001466879555", "Tracking#:", "01-12-2017", "04-08-2017");
            tracklist.add(recyclerview);


            recyclerview = new Recyclerview("Delay", "CICI 9t", "Reference#:", "1000146687954", "Tracking#:", "02-12-2017", "04-08-2017");
            tracklist.add(recyclerview);

            recyclerview = new Recyclerview("Delay", "CICI 99", "Reference#:", "1000146687955", "Tracking#:", "02-12-2017", "04-08-2017");
            tracklist.add(recyclerview);

            recyclerview = new Recyclerview("Cancelled", "CICI 98", "Reference#:", "1000146687958", "Tracking#:", "05-12-2017", "04-08-2017");
            tracklist.add(recyclerview);

           recyclerview = new Recyclerview("Cancelled", "CICI 99", "Reference#:", "1000146687959", "Tracking#:", "05-12-2017", "04-08-2017");
            tracklist.add(recyclerview);

        }
        return tracklist;
    }


}
