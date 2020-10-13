package com.telRan.tests.tests;

import com.telRan.tests.model.Board;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider
    public Iterator<Object[]> validListsAndCards(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"First list", "1 task"});
        list.add(new Object[]{"Second list", ""});
        list.add(new Object[]{"Third list", ""});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> validBoards(){
        List<Object[]> list  = new ArrayList<>();
        list.add(new Object[]{"yyyyy", "public"});
        list.add(new Object[]{"zzzzz", "public"});
        //list.add(new Object[]{"1", "public"});
       // list.add(new Object[]{"&^$^%", "public"});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]>validTeam(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Vodka", "marketing", "this is team"});
        list.add(new Object[]{"Seledka", "education", ""});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]>validBoardsFromCSV() throws IOException {
        List<Object[]> list  = new ArrayList<>();
        BufferedReader reader = new BufferedReader
                (new FileReader(new File("src/test/resources/boards.csv")));
        String line =  reader.readLine();
        while (line!=null){
            String[] split = line.split(",");
            list.add(new Object[]{new Board().withBoardName(split[0])
                    .withBoardVisible(split[1])});
            line =   reader.readLine();
        }

        return list.iterator();
    }




}
