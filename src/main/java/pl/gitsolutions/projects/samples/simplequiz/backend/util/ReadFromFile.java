package pl.gitsolutions.projects.samples.simplequiz.backend.util;

import pl.gitsolutions.projects.samples.simplequiz.backend.model.dto.FromFileDto;
import pl.gitsolutions.projects.samples.simplequiz.backend.model.jpa.Quiz;
import pl.gitsolutions.projects.samples.simplequiz.backend.model.jpa.Task;
import pl.gitsolutions.projects.samples.simplequiz.backend.model.jpa.Track;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by katgr on 19.11.2017.
 */
public class ReadFromFile {

    public static FromFileDto loadToDatabase(String fileName) throws IOException {

        FromFileDto result = new FromFileDto();

        List<Track> listOfTracks = new ArrayList<>();
        List<Task> listOfTasks = new ArrayList<>();
        List<Quiz> listOfQuizes = new ArrayList<>();
        List<String> fromFile = new ArrayList<>();

        FileReader fr = new FileReader(fileName);
        fromFile = ReadFromFile.readEachLine(fr);

        int numberOfTracks = 0;
        int numberOfTasks = 0;
        int numberOfQuizes = 0;
        int lastReadLineIndex = 0;

        numberOfTracks = Integer.valueOf(fromFile.get(0));

        for (int i=1; i<=numberOfTracks; i++){
            List<Integer> tabList = new ArrayList<>();

            for (int j=0; j<fromFile.get(i).length(); j++) {
                if (fromFile.get(i).charAt(j) == 0x009) {
                    tabList.add(j);
                }
            }
            String singleLine = fromFile.get(i);
            Track tempTrack = new Track();
            tempTrack.setQuizId(Long.valueOf(singleLine.substring(tabList.get(0)+1,tabList.get(1))));
            tempTrack.setTaskId(Long.valueOf(singleLine.substring(tabList.get(1)+1,tabList.get(2))));
            tempTrack.setId(Long.valueOf(singleLine.substring(tabList.get(2)+1,tabList.get(3))));
            tempTrack.setTrackTitle(singleLine.substring(tabList.get(3)+1,tabList.get(4)));
            tempTrack.setTrackArtist(singleLine.substring(tabList.get(4)+1,tabList.get(5)));
            tempTrack.setAlbumTitle(singleLine.substring(tabList.get(5)+1,tabList.get(6)));
            tempTrack.setYear(Integer.valueOf(singleLine.substring(tabList.get(6)+1,tabList.get(7))));
            tempTrack.setTipOne(singleLine.substring(tabList.get(7)+1,tabList.get(8)));
            tempTrack.setTipTwo(singleLine.substring(tabList.get(8)+1,tabList.get(9)));
            tempTrack.setLyricsStart(singleLine.substring(tabList.get(9)+1,tabList.get(10)));
            tempTrack.setTrackUrl(singleLine.substring(tabList.get(10)+1,tabList.get(11)));
            tempTrack.setWikiUrl(singleLine.substring(tabList.get(11)+1));

            listOfTracks.add(tempTrack);

            if (tempTrack.getTaskId() > numberOfTasks) {
                numberOfTasks = Integer.valueOf(tempTrack.getTaskId().toString());
            }
            lastReadLineIndex = i;
        }

        int taskStart = lastReadLineIndex + 2;

        for (int i = taskStart; i < taskStart + numberOfTasks; i++) {
            List<Integer> tabList = new ArrayList<>();

            for (int j=0; j<fromFile.get(i).length(); j++) {
                if (fromFile.get(i).charAt(j) == 0x009) {
                    tabList.add(j);
                }
            }
            String singleLine = fromFile.get(i);
            Task tempTask = new Task();

            tempTask.setQuizId(Long.valueOf(singleLine.substring(tabList.get(0)+1,tabList.get(1))));
            tempTask.setTaskDescription(singleLine.substring(tabList.get(1)+1));

            listOfTasks.add(tempTask);

            if (tempTask.getQuizId() > numberOfQuizes) {
                numberOfQuizes = Integer.valueOf(tempTask.getQuizId().toString());
            }
            lastReadLineIndex = i;
        }

        int quizStart = lastReadLineIndex + 2;

        for (int i = quizStart; i < fromFile.size(); i++) {
            List<Integer> tabList = new ArrayList<>();

            for (int j=0; j<fromFile.get(i).length(); j++) {
                if (fromFile.get(i).charAt(j) == 0x009) {
                    tabList.add(j);
                }
            }
            String singleLine = fromFile.get(i);
            Quiz tempQuiz = new Quiz();

            tempQuiz.setQuizDescription(singleLine.substring(tabList.get(0)+1));

            listOfQuizes.add(tempQuiz);
        }

        result.setQuizList(listOfQuizes);
        result.setTaskList(listOfTasks);
        result.setTrackList(listOfTracks);

        return result;


    }

    public static List<String> readEachLine(FileReader fr) throws IOException {

        List<String> result = new ArrayList<>();
        BufferedReader br = new BufferedReader(fr);
        for (String line; (line = br.readLine()) != null;) {
            result.add(line);
        }

        return result;
    }
}
