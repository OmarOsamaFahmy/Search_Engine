package com.company;
import java.io.*;

import com.panforge.robotstxt.RobotsTxt;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import crawlercommons.robots.BaseRobotRules;
import crawlercommons.filters.basic.BasicURLNormalizer;
import opennlp.tools.stemmer.PorterStemmer;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import sun.net.util.URLUtil;


public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {



        Dbhandler db=new Dbhandler();
        db.setNotDownloaded();
        Scanner sc=new Scanner (System.in);
        System.out.println("Enter the number of Threads :");
        int threadNum=sc.nextInt();
        Crawler crawler=new Crawler(threadNum);
        crawler.crawl();
        db.setNotIndexed();
        Indexer indexer =new Indexer();
        indexer.startIndexing();




    }

}
