package pl.gitsolutions.projects.samples.simplequiz.backend.util;

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

    public static List<Track> loadToDatabase(String fileName) throws IOException {


        Task tempTask = new Task();
        Quiz tempQuiz = new Quiz();
        List<Track> listOfTracks = new ArrayList<Track>();

        List<Task> listOfTasks = new ArrayList<Task>();
        List<String> fromFile = new ArrayList<String>();

        FileReader fr = new FileReader(fileName);
        fromFile = ReadFromFile.readEachLine(fr);
        int tabPlacement = 0;

        long numberOfTracks = 0;
        long numberOfTasks = 0;
        long firstTrackInTask = 0;
        long numberOfTracksInTask = 0;

        numberOfTracks = Integer.valueOf(fromFile.get(0));

        for (int i=1; i<=numberOfTracks; i++){
            List<Integer> tabList = new ArrayList<Integer>();

            for (int j=0; j<fromFile.get(i).length(); j++) {
                if (fromFile.get(i).charAt(j) == 0x009) {
                    tabList.add(j);
                }
            }
            String singleLine = fromFile.get(i);
            Track tempTrack = new Track();
//            tempTrack.setId(0L);
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
                numberOfTasks = tempTrack.getTaskId();
            }
        }

//        for (int i=numberOfTracks+3; i< numberOfTracks+3+3*numberOfTasks; i+=3){
//            tabPlacement = fromFile.get(i).indexOf(0x009);
//            tempTask.setTaskDescription(fromFile.get(i).substring(tabPlacement+1));
//
//            tabPlacement = fromFile.get(i+1).indexOf(0x009);
//            firstTrackInTask = Integer.valueOf(fromFile.get(i+1).substring(tabPlacement+1));
//
//            tabPlacement = fromFile.get(i+2).indexOf(0x009);
//            numberOfTracksInTask = Integer.valueOf(fromFile.get(i+2).substring(tabPlacement+1));
//
//            List<Track> listOfTracksInTask = new ArrayList<Track>();
//
//            for (int j=firstTrackInTask-1; j<firstTrackInTask+numberOfTracksInTask-1; j++){
//
//                listOfTracksInTask.add(new Track(listOfTracks.get(j).getTitle(),listOfTracks.get(j).getArtist(),
//                        listOfTracks.get(j).getAlbum(), listOfTracks.get(j).getYear(),
//                        listOfTracks.get(j).getTipOne(), listOfTracks.get(j).getTipTwo(), listOfTracks.get(j).getLyricsStart(),
//                        listOfTracks.get(j).getTrackUrl(),listOfTracks.get(j).getWikiUrl(),listOfTracks.get(j).getQuizNr(),
//                        listOfTracks.get(j).getTaskNr(),listOfTracks.get(j).getTrackNr()));
//
//            }
//
//
//            listOfTasks.add(new Task(listOfTracksInTask,tempTask.getTaskDescription()));
//
//        }
//
//        tempQuiz = new Quiz(listOfTasks,"Pierwszy konkurs Muzyczny");



        return listOfTracks;


    }

    public static List<String> readEachLine(FileReader fr) throws IOException {

        List<String> result = new ArrayList<String>();
        BufferedReader br = new BufferedReader(fr);
        for (String line; (line = br.readLine()) != null;) {
            result.add(line);
        }

        return result;
    }
}
