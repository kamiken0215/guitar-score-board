package guitarscoreboardapi.batch;

import guitarscoreboardapi.service.ScoreAccessCountsService;
import guitarscoreboardapi.service.ScoreAccessesService;
import guitarscoreboardapi.service.ScoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
public class ScoreAccessCountBatch {

    @Autowired
    private ScoresService scoresService;
    @Autowired
    private ScoreAccessesService scoreAccessesService;
    @Autowired
    private ScoreAccessCountsService scoreAccessCountsService;

    //  毎日0時1分0秒に実行 ("0秒 1分 0時 * * *")
    @Scheduled(cron = "0 5 0 * * *", zone = "Asia/Tokyo")
    private void update() {
        System.out.println("実行開始");
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String last = df.format(cal.getTime());
        cal.add(Calendar.DATE, -8);
        String start = df.format(cal.getTime());

        List<Integer> idList = scoreAccessesService.findAllId();

        for (Integer id : idList) {
            int totalAccessCount = (int) scoreAccessesService.countAccesses(id,start,last);
            scoreAccessCountsService.countUpdate(id,totalAccessCount);
        }
        System.out.println("実行終了");
    }
}
